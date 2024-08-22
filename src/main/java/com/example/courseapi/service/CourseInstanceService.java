package com.example.courseapi.service;

import com.example.courseapi.dto.CourseInstanceDTO;
import com.example.courseapi.model.CourseInstance;

import java.util.List;

public interface CourseInstanceService {
    List<CourseInstanceDTO> getCourseInstancesByYearAndSemester(int year, int semester);
    CourseInstanceDTO getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId);
    CourseInstanceDTO createCourseInstance(CourseInstance courseInstance);
    CourseInstanceDTO createCourseInstanceForCourse(Long courseId, CourseInstance courseInstance);  // Added method
    void deleteCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId);
}
