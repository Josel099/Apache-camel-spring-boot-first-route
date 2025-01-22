package com.ecsfin.apache_camel_spring_boot_excercise.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFirstRoute extends RouteBuilder {

    Logger log = LoggerFactory.getLogger(MyFirstRoute.class);
    @Override
    public void configure() throws Exception {
        from("timer:myTimer?period={{periodSec}}")
                .routeId("Hello World")
                .routeDescription("This route will display Hello world to the screen")
//                .log("Hello World")
                .log("${body}")
                .transform().constant("Hello World")
                .log("${body}")
                .to("log:myLog");
    }
}
