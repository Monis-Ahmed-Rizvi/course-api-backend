package com.example.courseapi.controller;

import com.example.courseapi.dto.CourseInstanceDTO;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping("/instances")
    public ResponseEntity<CourseInstanceDTO> createCourseInstance(@Valid @RequestBody CourseInstance courseInstance) {
        CourseInstanceDTO newInstance = courseInstanceService.createCourseInstance(courseInstance);
        return ResponseEntity.status(201).body(newInstance);
    }

    @PostMapping("/courses/{courseId}/instances")
    public ResponseEntity<CourseInstanceDTO> createCourseInstanceForCourse(
            @PathVariable Long courseId,
            @Valid @RequestBody CourseInstance courseInstance) {
        CourseInstanceDTO newInstance = courseInstanceService.createCourseInstanceForCourse(courseId, courseInstance);
        return ResponseEntity.status(201).body(newInstance);
    }

    @GetMapping("/instances/{year}/{semester}")
    public ResponseEntity<List<CourseInstanceDTO>> getCourseInstancesByYearAndSemester(
            @PathVariable int year, @PathVariable int semester) {
        List<CourseInstanceDTO> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstanceDTO> getCourseInstanceByYearSemesterAndCourseId(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        CourseInstanceDTO instance = courseInstanceService.getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return ResponseEntity.ok(instance);
    }

    @DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<Void> deleteCourseInstance(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        courseInstanceService.deleteCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return ResponseEntity.noContent().build();
    }
}
