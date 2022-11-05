package com.st.example.StudentManagement.controller;

import com.st.example.StudentManagement.model.Course;
import com.st.example.StudentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity createCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getCourses", "/{courseId}"})
    public List<Course> getCourses(@PathVariable(required = false) Long courseId) {
        return courseService.getCourseDetails(courseId);
    }

}
