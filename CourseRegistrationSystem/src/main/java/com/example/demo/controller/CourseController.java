package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.CourseRegistry;
import com.example.demo.repository.CourseRegistryRepo;
import com.example.demo.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*") // ✅ Allow requests from anywhere (for your deployed frontend)
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRegistryRepo courseRegistryRepo;

    // ✅ Get all available courses
    @GetMapping
    public List<Course> availableCourses() {
        return courseService.availableCourses();
    }

    // ✅ Get all enrolled students
    @GetMapping("/enrolled")
    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    // ✅ Register a student for a course
    @PostMapping("/register")
    public String enrollCourse(
            @RequestParam("name") String name,
            @RequestParam("emailId") String emailId,
            @RequestParam("courseName") String courseName) {
        courseService.enrollCourse(name, emailId, courseName);
        return "🎓 Congratulations, " + name + "! You have successfully enrolled in " + courseName + ".";
    }
}

