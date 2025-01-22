package com.ecsfin.apache_camel_spring_boot_excercise.camelroute;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyDataRoute extends RouteBuilder {





    /**
     *  Use noop=true to process files without moving or deleting them.
     *  The original files will remain in the source folder unchanged after processing.
     *  noop => no operation to override program.
     *  no backup in .camel folder
     *  avoid sending duplicates
     *  "file:/home/joselxavier/Desktop/source?noop=true"
     *
     */
    @Override
    public void configure() throws Exception {
        from("{{my.app.source}}")
                .to("{{my.app.destination}}");

    }
}
