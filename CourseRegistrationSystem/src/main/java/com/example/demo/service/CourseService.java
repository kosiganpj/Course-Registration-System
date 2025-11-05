package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.CourseRegistry;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.CourseRegistryRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseRegistryRepo courseRegistryRepo;

    // Get all available courses
    public List<Course> availableCourses() {
        return courseRepo.findAll();
    }

    // Enroll a student in a course
    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry(name, emailId, courseName);
        courseRegistryRepo.save(courseRegistry);
    }
}
