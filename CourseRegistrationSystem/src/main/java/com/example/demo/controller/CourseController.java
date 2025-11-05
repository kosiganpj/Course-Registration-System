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
    "https://course-registration-system-production-95ea.up.railway.app",  // ✅ Correct frontend
    "https://balanced-inspiration.up.railway.app",                        // ✅ Backend
    "http://localhost:5500",                                              // ✅ Local test
    "http://127.0.0.1:5500"                                               // ✅ Local test
})
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRegistryRepo courseRegistryRepo;

    @GetMapping("/courses")
    public List<Course> availableCourses() {
        return courseService.availableCourses();
    }

    @GetMapping("/courses/enrolled")
    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    @PostMapping("/courses/register")
    public String enrollCourse(
            @RequestParam("name") String name,
            @RequestParam("emailId") String emailId,
            @RequestParam("courseName") String courseName) {

        courseService.enrollCourse(name, emailId, courseName);
        return "🎓 Congratulations, " + name + "! You have successfully enrolled in " + courseName + ".";
    }
}




