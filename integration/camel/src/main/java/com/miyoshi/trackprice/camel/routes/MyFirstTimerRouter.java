package com.miyoshi.trackprice.camel.routes;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLogginsProcessingComponent loggingComponent;
    
    @Override
    public void configure() throws Exception {
        from("timer:first-time")
        .log("${body}")
        //.transform().constant("My constant Message")
        //.transform().constant("Time is " + LocalDateTime.now())
        //.bean("getCurrentTimeBean")
        
        //processing


        //transformation

        .bean(getCurrentTimeBean)
        .log("${body}")
        .bean(loggingComponent)
        .process(new SimpleLoggigProcessor())
        .to("log:first-timer");
    }
}

@Component
class GetCurrentTimeBean {
    public String getCurrentTime(){
        return "Time is " + LocalDateTime.now();
    }
}

@Component
class SimpleLogginsProcessingComponent {
    private Logger logger = LoggerFactory.getLogger(SimpleLogginsProcessingComponent.class);
    public void process(String message){
        logger.info("SimpleLogginProcessingComponent {}", message);
    }
}

class SimpleLoggigProcessor implements Processor {

    private Logger logger = LoggerFactory.getLogger(SimpleLogginsProcessingComponent.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        
        logger.info("SimpleLoggigProcessor {}", exchange.getMessage().getBody());
    }
    
}