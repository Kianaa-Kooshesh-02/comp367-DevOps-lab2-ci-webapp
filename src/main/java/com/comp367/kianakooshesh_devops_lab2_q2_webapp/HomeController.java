package com.comp367.kianakooshesh_devops_lab2_q2_webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final String KIANA_NAME = "Kiana Kooshesh";
    private static final String COURSE_SIGNAL = "Welcome to COMP367";

    @GetMapping("/")
    public String renderGreeting(@RequestParam(required = false) String timeOfDay) {
        // For delegating greeting generation based on the optional timeOfDay query param
        return buildGreetingPacket(timeOfDay);
    }

    private String buildGreetingPacket(String timeOfDay) {
        // For normalizing user input (handles null, extra spaces, and different casing)
        String normalized = (timeOfDay == null) ? "" : timeOfDay.trim().toLowerCase();

        if (normalized.equals("morning") || normalized.equals("am") || normalized.equals("a.m.")){
            return "Good morning, " + KIANA_NAME + ", " + COURSE_SIGNAL;
        }
        if (normalized.equals("afternoon") || normalized.equals("pm") || normalized.equals("p.m.")) {
            return "Good afternoon, " + KIANA_NAME + ", " + COURSE_SIGNAL;
        }
        return COURSE_SIGNAL;
    }
}