package com.kodilla.webcalc.service;

import com.kodilla.webcalc.event.WebCalcEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalcManager implements ApplicationListener<WebCalcEvent> {
    @Override
    public void onApplicationEvent(WebCalcEvent event) {
        System.out.println("Method " + event.getMethodName()+" was " + "called with: " + event.getA() + " and " + event.getB());
    }
}
