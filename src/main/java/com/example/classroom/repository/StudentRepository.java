package com.example.classroom.repository;

import com.example.classroom.model.Student;
import com.example.classroom.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentDb = new HashMap<>();

    HashMap<String, Teacher> teacherDb = new HashMap<>();

    HashMap<String, List<String>> teacherStudent = new HashMap<>();

    public String addStudent(Student student) {
        String key = student.getName();
        studentDb.put(key, student);
        return "Added student successfully";
    }

    public String addTeacher(Teacher teacher) {
        String key = teacher.getName();
        teacherDb.put(key, teacher);
        return "Added teacher successfully";
    }

    public String addPair(String studentName, String teacherName) {
        List<String> students = teacherStudent.get(teacherName);
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(studentName);
        teacherStudent.put(teacherName, students);
        return "Connected them successfully";
    }

    public Student findStudent(String name) {
        for (Student student : studentDb.values()) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Teacher findTeacher(String name) {
        for (Teacher teacher : teacherDb.values()) {
            if (teacher.getName().equals(name)) {
                return teacher;
            }
        }
        return null;
    }

    public List<String> findStudents(String teacherName) {

        return teacherStudent.get(teacherName);

    }

    public List<String> findAllStudents() {
        return new ArrayList<>(studentDb.keySet());
    }

    public String deleteTeacher(String teacherName) {

        for (String studentName : teacherStudent.get(teacherName)) {
            studentDb.remove(studentName);
        }
        teacherDb.remove(teacherName);
        teacherStudent.remove(teacherName);
        return "Teacher removed successfully";
    }

    public String deleteTeachers() {
        for (String teacherName : teacherDb.keySet()) {
            for (String studentName : teacherStudent.get(teacherName)) {
                studentDb.remove(studentName);
            }
            teacherDb.remove(teacherName);
            teacherStudent.remove(teacherName);
        }
        return "All teachers deleted";
    }
}
