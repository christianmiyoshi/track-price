package com.miyoshi.trackprice.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class KabumRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("timer:kabum?period=1h")
        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .to("http://projection-clojure:8080?id=1")
        .to("log:kabum");
    }

}
