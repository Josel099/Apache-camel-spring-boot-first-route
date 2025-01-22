package com.ecsfin.apache_camel_spring_boot_excercise.camelroute;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyDataRoute extends RouteBuilder {



    @Override
    public void configure() throws Exception {
        from("file:/home/joselxavier/Desktop/source")
                .to("file:/home/joselxavier/Desktop/destination");

    }
}
