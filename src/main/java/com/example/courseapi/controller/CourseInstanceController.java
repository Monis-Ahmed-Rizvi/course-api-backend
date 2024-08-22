package com.example.courseapi.controller;

import com.example.courseapi.dto.CourseInstanceDTO;
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
    public ResponseEntity<List<CourseInstanceDTO>> getCourseInstancesByYearAndSemester(
            @PathVariable int year, @PathVariable int semester) {
        List<CourseInstanceDTO> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseInstanceDTO> getCourseInstanceById(@PathVariable Long id) {
        CourseInstanceDTO instance = courseInstanceService.getCourseInstanceById(id);
        return ResponseEntity.ok(instance);
    }

    @GetMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstanceDTO> getCourseInstanceByYearSemesterAndCourseId(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        CourseInstanceDTO instance = courseInstanceService.getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return ResponseEntity.ok(instance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseInstance(@PathVariable Long id) {
        courseInstanceService.deleteCourseInstance(id);
        return ResponseEntity.ok().build();
    }
}