package com.example.courseapi.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String courseCode;
    private String description;
}