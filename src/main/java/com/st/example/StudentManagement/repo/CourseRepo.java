package com.st.example.StudentManagement.repo;

import com.st.example.StudentManagement.model.Course;
import com.st.example.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findAllByCourseId(Long courseId);
}
