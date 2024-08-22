package com.example.courseapi.controller;

import com.example.courseapi.dto.CourseDTO;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course) {
        CourseDTO newCourse = courseService.createCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        CourseDTO updatedCourse = courseService.updateCourse(id, courseDetails);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{courseId}/instances")
    public ResponseEntity<CourseInstance> addCourseInstance(@PathVariable Long courseId, @RequestBody CourseInstance courseInstance) {
        CourseInstance newInstance = courseService.addCourseInstance(courseId, courseInstance);
        return ResponseEntity.ok(newInstance);
    }
}