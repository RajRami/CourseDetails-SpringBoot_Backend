package com.example.coursedetailsspringboot_backend.controller;

import com.example.coursedetailsspringboot_backend.entity.Course;
import com.example.coursedetailsspringboot_backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> list = courseRepository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/courses")
    public ResponseEntity<Void> addCourse(@RequestBody Course course) {
        try {
            courseRepository.save(course);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Void> updateCourse(@RequestBody Course course, @PathVariable("id") long id) {
        try {
            course.setId(id);
            courseRepository.save(course);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") long id) {
        try {
            courseRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
