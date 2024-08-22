package com.example.courseapi.dto;

import java.util.List;

public class CourseDTO {
    private Long id;
    private String title;
    private String courseCode;
    private String description;
    private List<CourseInstanceDTO> courseInstances; // Optional: Include if required

    // Getters and Setters
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

    public List<CourseInstanceDTO> getCourseInstances() {
        return courseInstances;
    }

    public void setCourseInstances(List<CourseInstanceDTO> courseInstances) {
        this.courseInstances = courseInstances;
    }
}
