package com.example.sample5.service;

import com.example.sample5.entity.Student;
import com.example.sample5.repository.StudentRepository;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceClass implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    // Save operation
    @Override
    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    // Read operation
    @Override public List<Student> fetchStudentList()
    {
        return (List<Student>)
                studentRepository.findAll();
    }

    // Update operation
    @Override
    public Student
    updateStudent(Student student, Long studentId)
    {
        Student depDB
                = studentRepository.findById(studentId)
                .get();

        if (Objects.nonNull(student.getStudentName())
                && !"".equalsIgnoreCase(
                student.getStudentName())) {
            depDB.setStudentName(
                    student.getStudentName());
        }

        if (Objects.nonNull(student.getStudentDept())
                && !"".equalsIgnoreCase(
                student.getStudentDept())) {
            depDB.setStudentDept(
                    student.getStudentDept());
        }

        if (Objects.nonNull(student.getStudentClg())
                && !"".equalsIgnoreCase(
                student.getStudentClg())) {
            depDB.setStudentClg(
                    student.getStudentClg());
        }

        return studentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteStudentById(Long studentId)
    {
        studentRepository.deleteById(studentId);
    }
}
