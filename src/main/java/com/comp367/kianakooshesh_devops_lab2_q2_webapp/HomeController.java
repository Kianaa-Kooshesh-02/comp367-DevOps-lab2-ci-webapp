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
        return buildGreetingPacket(timeOfDay);
    }

    private String buildGreetingPacket(String timeOfDay) {
        if ("morning".equalsIgnoreCase(timeOfDay)) {
            return "Good morning, " + KIANA_NAME + ", " + COURSE_SIGNAL;
        }
        if ("afternoon".equalsIgnoreCase(timeOfDay)) {
            return "Good afternoon, " + KIANA_NAME + ", " + COURSE_SIGNAL;
        }
        return COURSE_SIGNAL;
    }
}