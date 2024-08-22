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
    public CourseInstance getCourseInstanceById(Long id) {
        return courseInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found with id " + id));
    }

    @Override
    public void deleteCourseInstance(Long id) {
        CourseInstance courseInstance = getCourseInstanceById(id);
        courseInstanceRepository.delete(courseInstance);
    }
}