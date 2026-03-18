package com.fsad.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Certification {
    private int id = 1;
    private String name = "Java Programming";
    private String dateOfCompletion = "2026-03-01";

    public void display() {
        System.out.println("Certification: " + id + " " + name + " " + dateOfCompletion);
    }
}
