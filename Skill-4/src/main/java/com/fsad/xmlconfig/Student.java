package com.fsad.xmlconfig;


public class Student {
    private int studentId;
    private String name;
    private String course;
    private int year;

    // Constructor
    public Student(int studentId, String name, String course, int year) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // Setters (at least two)
    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Display method
    public void display() {
        System.out.println(studentId + " " + name + " " + course + " " + year);
    }
}
