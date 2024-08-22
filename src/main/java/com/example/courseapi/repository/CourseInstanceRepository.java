package com.example.courseapi.repository;

import com.example.courseapi.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    @Query("SELECT ci FROM CourseInstance ci JOIN FETCH ci.course WHERE ci.year = :year AND ci.semester = :semester")
    List<CourseInstance> findByYearAndSemester(int year, int semester);

    @Query("SELECT ci FROM CourseInstance ci JOIN FETCH ci.course WHERE ci.year = :year AND ci.semester = :semester AND ci.course.id = :courseId")
    Optional<CourseInstance> findByYearAndSemesterAndCourse_Id(int year, int semester, Long courseId);
}