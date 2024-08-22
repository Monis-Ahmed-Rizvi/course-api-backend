package com.example.courseapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initData() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS courses (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(255)," +
                "course_code VARCHAR(255)," +
                "description VARCHAR(255)" +
                ")");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS course_instances (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "academic_year INT," +
                "semester INT," +
                "course_id BIGINT," +
                "FOREIGN KEY (course_id) REFERENCES courses(id)" +
                ")");
    }
}