package com.example.sample5.service;

import com.example.sample5.entity.Student;
import java.util.List;

public interface StudentService {
    //create
    Student saveStudent(Student student);
    //read
    List<Student> fetchStudentList();
    //update
    Student updateStudent(Student student, Long studentId);
    // delete
    void deleteStudentById(Long studentId);
}
