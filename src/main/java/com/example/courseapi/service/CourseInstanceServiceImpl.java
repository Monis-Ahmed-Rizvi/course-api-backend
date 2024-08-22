package com.example.courseapi.service;

import com.example.courseapi.dto.CourseInstanceDTO;
import com.example.courseapi.dto.SimplifiedCourseDTO;
import com.example.courseapi.exception.ResourceNotFoundException;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseInstance;
import com.example.courseapi.repository.CourseInstanceRepository;
import com.example.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseInstanceDTO> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester).stream()
                .map(this::convertToCourseInstanceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseInstanceDTO getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
        CourseInstance courseInstance = courseInstanceRepository.findByYearAndSemesterAndCourse_Id(year, semester, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course instance not found"));
        return convertToCourseInstanceDTO(courseInstance);
    }

    @Override
    public CourseInstanceDTO createCourseInstance(CourseInstance courseInstance) {
        CourseInstance savedInstance = courseInstanceRepository.save(courseInstance);
        return convertToCourseInstanceDTO(savedInstance);
    }

    @Override
    public CourseInstanceDTO createCourseInstanceForCourse(Long courseId, CourseInstance courseInstance) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        courseInstance.setCourse(course);
        courseInstance = courseInstanceRepository.save(courseInstance);
        return convertToCourseInstanceDTO(courseInstance);
    }

    @Override
    public void deleteCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
        CourseInstance courseInstance = courseInstanceRepository.findByYearAndSemesterAndCourse_Id(year, semester, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course instance not found"));
        courseInstanceRepository.delete(courseInstance);
    }

    private CourseInstanceDTO convertToCourseInstanceDTO(CourseInstance courseInstance) {
        return new CourseInstanceDTO(
            courseInstance.getId(),
            courseInstance.getYear(),
            courseInstance.getSemester(),
            new SimplifiedCourseDTO(
                courseInstance.getCourse().getId(),
                courseInstance.getCourse().getTitle(),
                courseInstance.getCourse().getCourseCode(),
                courseInstance.getCourse().getDescription()
            )
        );
    }
}
