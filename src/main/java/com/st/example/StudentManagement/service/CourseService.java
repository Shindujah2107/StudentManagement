package com.st.example.StudentManagement.service;

import com.st.example.StudentManagement.model.Course;
import com.st.example.StudentManagement.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }
    public void saveCourse(Course course){
        courseRepo.save(course);
    }

    public List<Course> getCourseDetails(Long courseId) {
        if (null != courseId) {
            return courseRepo.findAllByCourseId(courseId);
        } else {
            return courseRepo.findAll();
        }
    }

//    public Course getCourseById(Long id){
//        return courseRepo.findById(id).get();
//    }
//    public Course updateCourse(Course course){
//        return courseRepo.save(course);
//    }
    public void deleteCourseById(Long courseId){
         courseRepo.deleteById(courseId);
    }
}
