package com.example.courseapi.service;

import com.example.courseapi.dto.CourseDTO;
import com.example.courseapi.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO createCourse(Course course);
    CourseDTO updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}