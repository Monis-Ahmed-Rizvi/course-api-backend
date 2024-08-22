package com.example.courseapi.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String courseCode;
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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