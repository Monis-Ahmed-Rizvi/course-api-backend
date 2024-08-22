package com.example.courseapi.service;

import com.example.courseapi.dto.CourseDTO;
import com.example.courseapi.dto.CourseInstanceDTO;
import com.example.courseapi.dto.SimplifiedCourseDTO;
import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        return convertToCourseDTO(course);
    }

    @Override
    @Transactional
    public CourseDTO createCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return convertToCourseDTO(savedCourse);
    }

    @Override
    @Transactional
    public CourseDTO updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        course.setTitle(courseDetails.getTitle());
        course.setCourseCode(courseDetails.getCourseCode());
        course.setDescription(courseDetails.getDescription());
        Course updatedCourse = courseRepository.save(course);
        return convertToCourseDTO(updatedCourse);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        courseRepository.delete(course);
    }

    @Override
    @Transactional
    public CourseInstance addCourseInstance(Long courseId, CourseInstance courseInstance) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        course.addInstance(courseInstance);
        courseRepository.save(course);
        return courseInstance;
    }

    private CourseDTO convertToCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO(
                course.getId(),
                course.getTitle(),
                course.getCourseCode(),
                course.getDescription()
        );
        dto.setInstances(course.getInstances().stream()
                .map(this::convertToCourseInstanceDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private CourseInstanceDTO convertToCourseInstanceDTO(CourseInstance instance) {
        SimplifiedCourseDTO simplifiedCourseDTO = new SimplifiedCourseDTO(
            instance.getCourse().getId(),
            instance.getCourse().getTitle(),
            instance.getCourse().getCourseCode(),
            instance.getCourse().getDescription()
        );
        return new CourseInstanceDTO(instance.getId(), instance.getYear(), instance.getSemester(), simplifiedCourseDTO);
    }
}