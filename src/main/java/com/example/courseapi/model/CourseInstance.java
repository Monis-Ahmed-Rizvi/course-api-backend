package com.example.courseapi.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "course_instances")
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "academic_year")
    private int year;
    private int semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;

    // Constructors
    public CourseInstance() {}

    public CourseInstance(int year, int semester) {
        this.year = year;
        this.semester = semester;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Method to get course details
    public CourseDetails getCourseDetails() {
        if (course != null) {
            return new CourseDetails(course.getId(), course.getTitle(), course.getCourseCode());
        }
        return null;
    }

    // Inner class to represent course details
    public static class CourseDetails {
        private Long id;
        private String title;
        private String courseCode;

        public CourseDetails(Long id, String title, String courseCode) {
            this.id = id;
            this.title = title;
            this.courseCode = courseCode;
        }

        // Getters
        public Long getId() { return id; }
        public String getTitle() { return title; }
        public String getCourseCode() { return courseCode; }
    }
}