package com.example.courseapi.repository;

import com.example.courseapi.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(Integer year, Integer semester);
    Optional<CourseInstance> findByYearAndSemesterAndCourseId(Integer year, Integer semester, Long courseId);
}