package com.ecsfin.apache_camel_spring_boot_excercise.camelroute;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

@Component
public class NewProcessRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("{{my.app.process-source}}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                            // read input message give by source
                        Message input =  exchange.getIn();

                        // read body as string from input Message
                       String data = input.getBody(String.class);

                       //operation
                        StringTokenizer str = new StringTokenizer(data,",");
                        String eid = str.nextToken();
                        String ename = str.nextToken();
                        String esal = str.nextToken();

                        //output (data)
                        String modifiedData = "{eid:"+eid+" ,ename:"+ename+" ,esal:"+esal+" } ";

                        //read output message reference
                        Message output =exchange.getMessage();

                        // set data to output
                        output.setBody(modifiedData);
                    }
                })
                .to("{{my.app.process-destination}}");
    }
}
