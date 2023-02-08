package com.kodilla.webcalc.controller;

import com.kodilla.webcalc.event.WebCalcEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/v1/calc")
public class CalcController implements ApplicationEventPublisherAware {

    private final Logger logger = LoggerFactory.getLogger(CalcController.class);
    private ApplicationEventPublisher publisher;

    @GetMapping(path="/add")
    public int add(@RequestParam int a, @RequestParam int b){
        publisher.publishEvent(
                new WebCalcEvent(
                        this,
                        a,
                        b,
                        "Sum"
                )
        );
        logger.info("sum of: "+ a + " " + b +" has been called");
        return a+b;
    }
    @GetMapping(path="/sub")
    public int substract(@RequestParam int a, @RequestParam int b){
        publisher.publishEvent(
                new WebCalcEvent(
                        this,
                        a,
                        b,
                        "Substract"
                )
        );
        logger.info("Substraction of: "+ a + " " + b +" has been called");
        return a-b;
    }
    @GetMapping(path="/mul")
    public int multiply(@RequestParam int a, @RequestParam int b){
        publisher.publishEvent(
                new WebCalcEvent(
                        this,
                        a,
                        b,
                        "multiply"
                )
        );
        logger.info("Multiplification of: "+ a + " " + b +" has been called");
        return a*b;
    }
    @GetMapping(path="/div")
    public double division(@RequestParam int a, @RequestParam int b){
        publisher.publishEvent(
                new WebCalcEvent(
                        this,
                        a,
                        b,
                        "Division"
                )
        );
        logger.info("Division of: "+ a + " " + b +" has been called");
        return a/b;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }
}
