package com.example.courseapi.service;

import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseInstanceService courseInstanceService;

    public CourseServiceImpl(CourseRepository courseRepository, CourseInstanceService courseInstanceService) {
        this.courseRepository = courseRepository;
        this.courseInstanceService = courseInstanceService;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

    @Override
    @Transactional
    public Course createCourse(Course course) {
        if (courseRepository.findByCourseCode(course.getCourseCode()).isPresent()) {
            throw new RuntimeException("Course with this code already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);
        course.setTitle(courseDetails.getTitle());
        course.setCourseCode(courseDetails.getCourseCode());
        course.setDescription(courseDetails.getDescription());
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }

    @Override
    @Transactional
    public Course addCourseInstance(Long courseId, CourseInstance courseInstance) {
        Course course = getCourseById(courseId);
        courseInstance.setCourse(course);
        CourseInstance savedInstance = courseInstanceService.createCourseInstance(courseInstance);
        course.getInstances().add(savedInstance);
        return courseRepository.save(course);
    }
}