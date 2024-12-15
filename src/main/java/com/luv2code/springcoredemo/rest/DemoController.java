package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency

    private Coach myCoach;


    // define constructor for dependency injection
    @Autowired
    public DemoController(
            @Qualifier("aquatic") Coach theCoach
//            @Qualifier("cricketCoach") Coach theAnotherCoach
    ) {
        System.out.println("In Constructor: "+getClass().getName());

        myCoach=theCoach;
//        anotherCoach=theAnotherCoach;
//        System.out.println("Instance of: " + theCoach.getClass().getName());

    }

// define setter injection for dependency injection
//
//    @Autowired
//    public void setCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans: myCoach == anotherCoach, " + (myCoach==anotherCoach);
//    }
}
