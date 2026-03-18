package com.course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    List<Course> courseList = new ArrayList<>();

    // CREATE
    public Course addCourse(Course c) {
        courseList.add(c);
        return c;
    }

    // READ ALL
    public List<Course> getAllCourses() {
        return courseList;
    }

    // READ BY ID
    public Course getCourseById(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public Course updateCourse(int id, Course newCourse) {
        Course c = getCourseById(id);
        if (c != null) {
            c.setTitle(newCourse.getTitle());
            c.setDuration(newCourse.getDuration());
            c.setFee(newCourse.getFee());
        }
        return c;
    }

    // DELETE
    public boolean deleteCourse(int id) {
        Course c = getCourseById(id);
        if (c != null) {
            courseList.remove(c);
            return true;
        }
        return false;
    }

    // SEARCH BY TITLE
    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}