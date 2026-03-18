package com.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")   // Base URL
public class CourseController {

    @Autowired
    private CourseService service;

    // ================= CREATE =================
    // POST http://localhost:8080/courses/add
    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course c) {
        if (c.getTitle() == null || c.getTitle().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Course Data");
        }
        service.addCourse(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Course Added Successfully");
    }

    // ================= READ ALL =================
    // GET http://localhost:8080/courses/all
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // ================= READ BY ID =================
    // GET http://localhost:8080/courses/get/{id}
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Course c = service.getCourseById(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course Not Found");
        }
        return ResponseEntity.ok(c);
    }

    // ================= UPDATE =================
    // PUT http://localhost:8080/courses/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course c) {
        Course updated = service.updateCourse(id, c);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course Not Found");
        }
        return ResponseEntity.ok("Course Updated Successfully");
    }

    // ================= DELETE =================
    // DELETE http://localhost:8080/courses/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        boolean deleted = service.deleteCourse(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course Not Found");
        }
        return ResponseEntity.ok("Course Deleted Successfully");
    }

    // ================= SEARCH =================
    // GET http://localhost:8080/courses/search/{title}
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {
        List<Course> result = service.searchByTitle(title);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No Courses Found");
        }
        return ResponseEntity.ok(result);
    }
}