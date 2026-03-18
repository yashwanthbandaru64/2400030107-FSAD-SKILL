package com.fsad.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 101;
    private String name = "Yashwanth";
    private String gender = "Male";

    @Autowired   // Dependency Injection
    private Certification certification;

    public void display() {
        System.out.println("Student: " + id + " " + name + " " + gender);
        certification.display();
    }
}