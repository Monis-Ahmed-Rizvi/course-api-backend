package com.example.courseapi.service;

import com.example.courseapi.model.CourseInstance;

import java.util.List;

public interface CourseInstanceService {
    List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester);
    CourseInstance getCourseInstanceById(Long id);
    void deleteCourseInstance(Long id);
}