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

    @GetMapping("/{id}")
    public ResponseEntity<CourseInstance> getCourseInstanceById(@PathVariable Long id) {
        CourseInstance instance = courseInstanceService.getCourseInstanceById(id);
        return ResponseEntity.ok(instance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseInstance(@PathVariable Long id) {
        courseInstanceService.deleteCourseInstance(id);
        return ResponseEntity.ok().build();
    }
}