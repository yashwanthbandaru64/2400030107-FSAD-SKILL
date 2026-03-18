package com.student;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer, String> students = new HashMap<>();

    public StudentController() {
        students.put(1, "Yashwanth");
        students.put(2, "Kiran");
    }

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {

        if (id <= 0) {
            throw new InvalidInputException("Invalid ID: ID must be positive");
        }

        if (!students.containsKey(id)) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return "Student Name: " + students.get(id);
    }
}