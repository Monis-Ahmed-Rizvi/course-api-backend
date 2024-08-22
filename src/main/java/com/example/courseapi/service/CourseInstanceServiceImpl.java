package com.example.courseapi.service;

import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Override
    public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    @Override
    public CourseInstance getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
        return courseInstanceRepository.findByYearAndSemesterAndCourse_Id(year, semester, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found"));
    }

    @Override
    public void deleteCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
        CourseInstance instance = getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        courseInstanceRepository.delete(instance);
    }
}