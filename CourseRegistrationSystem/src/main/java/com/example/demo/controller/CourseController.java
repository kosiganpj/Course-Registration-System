
package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.CourseRegistry;
import com.example.demo.repository.CourseRegistryRepo;
import com.example.demo.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {
    "https://balanced-inspiration.up.railway.app",              // ✅ Your deployed backend
    "https://course-registration-system-production-3c01.up.railway.app",  // ✅ Your frontend
    "http://localhost:5500",                                    // ✅ Local test (VS Code Live Server)
    "http://127.0.0.1:5500"                                     // ✅ Local test (alternative)
})
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRegistryRepo courseRegistryRepo;

    // ✅ Get all available courses
    @GetMapping("/courses")
    public List<Course> availableCourses() {
        return courseService.availableCourses();
    }

    // ✅ Get all enrolled students
    @GetMapping("/courses/enrolled")
    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    // ✅ Register a student for a course
    @PostMapping("/courses/register")
    public String enrollCourse(
            @RequestParam("name") String name,
            @RequestParam("emailId") String emailId,
            @RequestParam("courseName") String courseName) {

        courseService.enrollCourse(name, emailId, courseName);
        return "🎓 Congratulations, " + name + "! You have successfully enrolled in " + courseName + ".";
    }
}



