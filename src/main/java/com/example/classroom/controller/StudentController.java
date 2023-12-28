package com.example.classroom.controller;

import com.example.classroom.model.Student;
import com.example.classroom.model.Teacher;
import com.example.classroom.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        String ans = studentService.addStudent(student);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }


    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        String ans = studentService.addTeacher(teacher);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam("studentName") String studentName,
                                                        @RequestParam("teacherName") String teacherName) {
        String ans = studentService.addStudentTeacherPair(studentName, teacherName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name) {
        Student student = studentService.findStudent(name);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable("name") String name) {
        Teacher teacher = studentService.findTeacher(name);
        return new ResponseEntity<>(teacher, HttpStatus.FOUND);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<Student>> getStudentsByTeacherName(@PathVariable("teacher") String teacherName) {
        List<Student> students = studentService.getStudentsByTeacherName(teacherName);
        return new ResponseEntity<>(students, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.findAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam("teacherName") String teacherName) {
        String ans = studentService.deleteTeacherByName(teacherName);
        return new ResponseEntity<>(ans, HttpStatus.GONE);
    }

    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers() {
        String ans = studentService.deleteTeachers();
        return new ResponseEntity<>(ans, HttpStatus.GONE);
    }

}
