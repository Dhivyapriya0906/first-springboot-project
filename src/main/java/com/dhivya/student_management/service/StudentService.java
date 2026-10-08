package com.dhivya.student_management.service;

import com.dhivya.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.dhivya.student_management.entity.Student;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDepartment(updatedStudent.getDepartment());
        existingStudent.setCgpa(updatedStudent.getCgpa());

        return studentRepository.save(existingStudent);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}