package com.example.courseapi.service;

import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
    }

    @Override
    @Transactional
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);
        course.setTitle(courseDetails.getTitle());
        course.setCourseCode(courseDetails.getCourseCode());
        course.setDescription(courseDetails.getDescription());
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }

    @Override
    @Transactional
    public CourseInstance addCourseInstance(Long courseId, CourseInstance courseInstance) {
        Course course = getCourseById(courseId);
        course.addInstance(courseInstance);
        courseRepository.save(course);
        return courseInstance;
    }
}