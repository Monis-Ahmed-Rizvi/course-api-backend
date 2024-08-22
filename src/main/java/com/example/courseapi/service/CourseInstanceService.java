package com.example.courseapi.service;

import com.example.courseapi.model.CourseInstance;

import java.util.List;

public interface CourseInstanceService {
    List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester);
    CourseInstance getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId);
    void deleteCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId);
}