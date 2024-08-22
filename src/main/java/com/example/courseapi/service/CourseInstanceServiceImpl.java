package com.example.courseapi.service;

import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.repository.CourseInstanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService {

    private final CourseInstanceRepository courseInstanceRepository;

    public CourseInstanceServiceImpl(CourseInstanceRepository courseInstanceRepository) {
        this.courseInstanceRepository = courseInstanceRepository;
    }

    @Override
    public List<CourseInstance> getAllCourseInstances() {
        return courseInstanceRepository.findAll();
    }

    @Override
    public CourseInstance getCourseInstanceById(Long id) {
        return courseInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found with id: " + id));
    }

    @Override
    @Transactional
    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    @Override
    @Transactional
    public CourseInstance updateCourseInstance(Long id, CourseInstance courseInstanceDetails) {
        CourseInstance courseInstance = getCourseInstanceById(id);
        courseInstance.setYear(courseInstanceDetails.getYear());
        courseInstance.setSemester(courseInstanceDetails.getSemester());
        courseInstance.setCourse(courseInstanceDetails.getCourse());
        return courseInstanceRepository.save(courseInstance);
    }

    @Override
    @Transactional
    public void deleteCourseInstance(Long id) {
        CourseInstance courseInstance = getCourseInstanceById(id);
        courseInstanceRepository.delete(courseInstance);
    }

    @Override
    public List<CourseInstance> getCourseInstancesByYearAndSemester(Integer year, Integer semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }
}