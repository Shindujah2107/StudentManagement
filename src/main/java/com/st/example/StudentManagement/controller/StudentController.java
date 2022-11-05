package com.st.example.StudentManagement.controller;

import com.st.example.StudentManagement.model.Student;
import com.st.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
     @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = {"/getStudents", "/{studentId}"})
    public List<Student> getStudent(@PathVariable(required = false) Long studentId) {
        return studentService.getStudentDetails(studentId);
    }
    @DeleteMapping("delete/{studentId}")
    public ResponseEntity removeStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return new ResponseEntity(HttpStatus.OK);
    }
   @PutMapping("/{studentId}/course/{courseId}")
    public Student updateStudent(@PathVariable Long studentId, @PathVariable Long courseId){
        return studentService.assignCourseToStudent(studentId, courseId);
   }

}
