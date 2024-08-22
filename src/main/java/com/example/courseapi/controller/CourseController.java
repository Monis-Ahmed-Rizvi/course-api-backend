package com.example.courseapi.controller;

import com.example.courseapi.dto.CourseDTO;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.service.CourseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(convertToDTO(course));
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@Valid @RequestBody Course course) {
        try {
            Course newCourse = courseService.createCourse(course);
            return ResponseEntity.ok(convertToDTO(newCourse));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @Valid @RequestBody Course courseDetails) {
        Course updatedCourse = courseService.updateCourse(id, courseDetails);
        return ResponseEntity.ok(convertToDTO(updatedCourse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{courseId}/instances")
    public ResponseEntity<CourseDTO> addCourseInstance(@PathVariable Long courseId, @Valid @RequestBody CourseInstance courseInstance) {
        logger.info("Received request to add instance to course: {}", courseId);
        logger.info("Course Instance details: {}", courseInstance);
        
        Course course = courseService.getCourseById(courseId);
        courseInstance.setCourse(course);
        
        Course updatedCourse = courseService.addCourseInstance(courseId, courseInstance);
        logger.info("Updated course: {}", updatedCourse);
        return ResponseEntity.ok(convertToDTO(updatedCourse));
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setCourseCode(course.getCourseCode());
        dto.setDescription(course.getDescription());
        return dto;
    }
}