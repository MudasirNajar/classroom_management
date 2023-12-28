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
    HashMap<String, String> studentTeacherPair = new HashMap<>();

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
        studentTeacherPair.put(studentName, teacherName);
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

    public List<Student> findStudents(String teacherName) {
        List<Student> students = new ArrayList<>();

        for (Map.Entry<String, String> entry : studentTeacherPair.entrySet()) {
            if (entry.getValue().equals(teacherName)) {
                String studentName = entry.getKey();
                for (Student student : studentDb.values()) {
                    if (student.getName().equals(studentName)) {
                        students.add(student);
                    }
                }
            }
        }
        return students;
    }

    public List<Student> findAllStudents() {
        return studentDb.values().stream().toList();
    }

    public String deleteTeacher(String teacherName) {
        teacherDb.remove(teacherName);
        for (Map.Entry<String, String> entry : studentTeacherPair.entrySet()) {
            if (entry.getValue().equals(teacherName)) {
                String studentName = entry.getKey();
                studentDb.remove(studentName);
                studentTeacherPair.remove(studentName);
            }
        }
        return "Teacher removed successfully";
    }

    public String deleteTeachers() {
        for (String teacherName : teacherDb.keySet()) {
            teacherDb.remove(teacherName);
            for (Map.Entry<String, String> entry : studentTeacherPair.entrySet()) {
                if (entry.getValue().equals(teacherName)) {
                    String studentName = entry.getKey();
                    studentDb.remove(studentName);
                    studentTeacherPair.remove(studentName);
                }
            }
        }
        return "All teachers deleted";
    }
}
