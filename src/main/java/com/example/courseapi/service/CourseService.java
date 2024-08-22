package com.example.courseapi.service;

import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseInstance;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    CourseInstance addCourseInstance(Long courseId, CourseInstance courseInstance);
}