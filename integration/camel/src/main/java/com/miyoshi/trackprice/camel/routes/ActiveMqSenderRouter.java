package com.miyoshi.trackprice.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
public class ActiveMqSenderRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("timer:active-mq-timer?period=10000")
        .log("Message to activemq")
        .transform().constant("MyMessageFor Active MQ")
        .to("activemq:my-queue");
    }
    
}
