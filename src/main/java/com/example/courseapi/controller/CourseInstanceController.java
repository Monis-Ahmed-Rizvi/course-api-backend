package com.example.courseapi.controller;

import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.service.CourseInstanceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    private final CourseInstanceService courseInstanceService;

    public CourseInstanceController(CourseInstanceService courseInstanceService) {
        this.courseInstanceService = courseInstanceService;
    }

    @GetMapping
    public List<CourseInstance> getAllCourseInstances() {
        return courseInstanceService.getAllCourseInstances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseInstance> getCourseInstanceById(@PathVariable Long id) {
        CourseInstance courseInstance = courseInstanceService.getCourseInstanceById(id);
        return ResponseEntity.ok(courseInstance);
    }

    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@Valid @RequestBody CourseInstance courseInstance) {
        CourseInstance newCourseInstance = courseInstanceService.createCourseInstance(courseInstance);
        return ResponseEntity.ok(newCourseInstance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseInstance> updateCourseInstance(@PathVariable Long id, @Valid @RequestBody CourseInstance courseInstanceDetails) {
        CourseInstance updatedCourseInstance = courseInstanceService.updateCourseInstance(id, courseInstanceDetails);
        return ResponseEntity.ok(updatedCourseInstance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseInstance(@PathVariable Long id) {
        courseInstanceService.deleteCourseInstance(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCourseInstancesByYearAndSemester(
            @PathVariable Integer year, @PathVariable Integer semester) {
        List<CourseInstance> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstance> getCourseInstanceByYearSemesterAndCourseId(
            @PathVariable Integer year, @PathVariable Integer semester, @PathVariable Long courseId) {
        CourseInstance instance = courseInstanceService.getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return ResponseEntity.ok(instance);
    }

    @DeleteMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<?> deleteCourseInstance(
            @PathVariable Integer year, @PathVariable Integer semester, @PathVariable Long courseId) {
        courseInstanceService.deleteCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return ResponseEntity.ok().build();
    }
}