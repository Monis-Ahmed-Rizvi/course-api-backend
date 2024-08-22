package com.example.courseapi.dto;

public class CourseInstanceDTO {
    private Long id;
    private int year;
    private int semester;
    private SimplifiedCourseDTO course;

    public CourseInstanceDTO(Long id, int year, int semester, SimplifiedCourseDTO course) {
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.course = course;
    }

    // Getters and setters

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

    public SimplifiedCourseDTO getCourse() {
        return course;
    }

    public void setCourse(SimplifiedCourseDTO course) {
        this.course = course;
    }
}