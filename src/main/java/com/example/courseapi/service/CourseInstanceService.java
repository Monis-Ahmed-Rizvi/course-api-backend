package com.example.courseapi.service;

import com.example.courseapi.dto.CourseInstanceDTO;
import java.util.List;

public interface CourseInstanceService {
    List<CourseInstanceDTO> getCourseInstancesByYearAndSemester(int year, int semester);
    CourseInstanceDTO getCourseInstanceById(Long id);
    CourseInstanceDTO getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId);
    void deleteCourseInstance(Long id);
}