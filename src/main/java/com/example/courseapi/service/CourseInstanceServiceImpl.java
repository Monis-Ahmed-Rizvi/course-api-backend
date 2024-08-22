package com.example.courseapi.service;

import com.example.courseapi.dto.CourseInstanceDTO;
import com.example.courseapi.dto.SimplifiedCourseDTO;
import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CourseInstanceDTO> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester).stream()
                .map(this::convertToCourseInstanceDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CourseInstanceDTO getCourseInstanceById(Long id) {
        CourseInstance instance = courseInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found with id " + id));
        return convertToCourseInstanceDTO(instance);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseInstanceDTO getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
        CourseInstance instance = courseInstanceRepository.findByYearAndSemesterAndCourse_Id(year, semester, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found"));
        return convertToCourseInstanceDTO(instance);
    }

    @Override
    @Transactional
    public void deleteCourseInstance(Long id) {
        CourseInstance instance = courseInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found with id " + id));
        courseInstanceRepository.delete(instance);
    }

    private CourseInstanceDTO convertToCourseInstanceDTO(CourseInstance instance) {
        SimplifiedCourseDTO courseDTO = new SimplifiedCourseDTO(
            instance.getCourse().getId(),
            instance.getCourse().getTitle(),
            instance.getCourse().getCourseCode(),
            instance.getCourse().getDescription()
        );
        return new CourseInstanceDTO(instance.getId(), instance.getYear(), instance.getSemester(), courseDTO);
    }
}