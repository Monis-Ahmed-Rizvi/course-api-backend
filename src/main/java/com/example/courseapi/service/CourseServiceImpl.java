package com.example.courseapi.service;

import com.example.courseapi.dto.CourseDTO;
import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.Course;
import com.example.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        return convertToCourseDTO(course);
    }

    @Override
    public CourseDTO createCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return convertToCourseDTO(savedCourse);
    }

    @Override
    public CourseDTO updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        existingCourse.setTitle(course.getTitle());
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setDescription(course.getDescription());
        Course updatedCourse = courseRepository.save(existingCourse);
        return convertToCourseDTO(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        courseRepository.delete(course);
    }

    private CourseDTO convertToCourseDTO(Course course) {
        return new CourseDTO(course.getId(), course.getTitle(), course.getCourseCode(), course.getDescription());
    }
}

