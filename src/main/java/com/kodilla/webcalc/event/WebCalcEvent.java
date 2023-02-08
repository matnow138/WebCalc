package com.kodilla.webcalc.event;

import org.springframework.context.ApplicationEvent;

public class WebCalcEvent extends ApplicationEvent {

    private int a;
    private int b;
    private String methodName;


    public WebCalcEvent(Object source, int a, int b, String methodName) {
        super(source);
        this.a = a;
        this.b = b;
        this.methodName=methodName;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public String getMethodName(){
        return methodName;
    }
}
