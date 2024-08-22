package com.example.courseapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;

    @NotBlank(message = "Course code is required")
    @Size(max = 20, message = "Course code must be less than 20 characters")
    private String courseCode;

    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CourseInstance> instances = new ArrayList<>();

    // Constructors
    public Course() {}

    public Course(String title, String courseCode, String description) {
        this.title = title;
        this.courseCode = courseCode;
        this.description = description;
    }

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

    public List<CourseInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<CourseInstance> instances) {
        this.instances = instances;
    }

    // Helper methods
    public void addInstance(CourseInstance instance) {
        instances.add(instance);
        instance.setCourse(this);
    }

    public void removeInstance(CourseInstance instance) {
        instances.remove(instance);
        instance.setCourse(null);
    }
}