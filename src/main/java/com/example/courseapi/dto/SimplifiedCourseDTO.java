package com.example.courseapi.dto;

public class SimplifiedCourseDTO {
    private Long id;
    private String title;
    private String courseCode;
    private String description;

    public SimplifiedCourseDTO(Long id, String title, String courseCode, String description) {
        this.id = id;
        this.title = title;
        this.courseCode = courseCode;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}