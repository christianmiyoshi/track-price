package com.miyoshi.trackprice.camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        restConfiguration()
            .host("0.0.0.0")
            .port(8080)
            .component("jetty")
            .bindingMode(RestBindingMode.json);

        rest().get("/hello")
            .to("direct:hello");

        from("direct:hello")
            .log(LoggingLevel.INFO, "Hello World")
            .transform().simple("Hello World");
            
    }
    
}
