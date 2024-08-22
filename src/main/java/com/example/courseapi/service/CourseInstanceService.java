package com.example.courseapi.service;

import com.example.courseapi.model.CourseInstance;
import java.util.List;

public interface CourseInstanceService {
    List<CourseInstance> getAllCourseInstances();
    CourseInstance getCourseInstanceById(Long id);
    CourseInstance createCourseInstance(CourseInstance courseInstance);
    CourseInstance updateCourseInstance(Long id, CourseInstance courseInstanceDetails);
    void deleteCourseInstance(Long id);
    List<CourseInstance> getCourseInstancesByYearAndSemester(Integer year, Integer semester);
}