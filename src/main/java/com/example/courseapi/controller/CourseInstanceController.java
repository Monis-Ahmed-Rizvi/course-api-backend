package com.example.courseapi.controller;

import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCourseInstancesByYearAndSemester(
            @PathVariable int year, @PathVariable int semester) {
        List<CourseInstance> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstance> getCourseInstanceByYearSemesterAndCourseId(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        CourseInstance instance = courseInstanceService.getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return ResponseEntity.ok(instance);
    }

    @DeleteMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<?> deleteCourseInstance(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        courseInstanceService.deleteCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return ResponseEntity.ok().build();
    }
}