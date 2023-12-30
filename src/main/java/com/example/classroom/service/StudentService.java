package com.example.classroom.service;

import com.example.classroom.model.Student;
import com.example.classroom.model.Teacher;
import com.example.classroom.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String addTeacher(Teacher teacher) {
        return studentRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair(String studentName, String teacherName) {
        return studentRepository.addPair(studentName, teacherName);
    }

    public Student findStudent(String name) {
        return studentRepository.findStudent(name);
    }

    public Teacher findTeacher(String teacherName) {
        return studentRepository.findTeacher(teacherName);
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        return studentRepository.findStudents(teacherName);
    }

    public List<String> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public String deleteTeacherByName(String teacherName) {
        return studentRepository.deleteTeacher(teacherName);
    }

    public String deleteTeachers() {
        return studentRepository.deleteTeachers();
    }
}
