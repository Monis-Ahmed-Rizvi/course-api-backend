package com.example.courseapi.repository;

import com.example.courseapi.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    @Query("SELECT ci FROM CourseInstance ci WHERE ci.year = :year AND ci.semester = :semester")
    List<CourseInstance> findByYearAndSemester(int year, int semester);
}