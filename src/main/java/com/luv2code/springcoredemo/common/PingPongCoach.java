package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

    public PingPongCoach() {
        System.out.println("In Constructor: "+getClass().getName());

    }

    @Override
    public String getDailyWorkout() {
        return "Practice your serve";
    }
}
