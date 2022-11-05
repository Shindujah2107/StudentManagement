package com.st.example.StudentManagement.service;

import com.st.example.StudentManagement.model.Course;
import com.st.example.StudentManagement.model.Student;
import com.st.example.StudentManagement.repo.CourseRepo;
import com.st.example.StudentManagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;


//public List<Student> getAllStudents() {
//    return studentRepo.findAll();
//}
    public void saveStudent(Student student){
        studentRepo.save(student);
  }
    public List<Student> getStudentDetails(Long studentId) {
      if (null != studentId) {
          return studentRepo.findAllByStudentId(studentId);
      } else {
          return studentRepo.findAll();
      }
  }

    public Student assignCourseToStudent(Long studentId, Long courseId) {
        Set<Course> courseSet = null;
        Student student = studentRepo.findById(studentId).get();
        Course course = courseRepo.findById(courseId).get();
        courseSet =  student.getCourse();
        courseSet.add(course);
        student.setCourse(courseSet);
        return studentRepo.save(student);
    }
//public List<Student> getStudentById(Long studentId){
//    return studentRepo.findAllByStudentId(studentId);
//}
//public Student editStudent(Student student){
//    return studentRepo.save(student);
//}
   public void deleteStudentById(Long studentId){
      studentRepo.deleteById(studentId);
   }
  }
