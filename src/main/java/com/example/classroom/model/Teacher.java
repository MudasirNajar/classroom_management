package com.example.classroom.model;

public class Teacher {
    private String name;
    private String subject;

    private String qualification;

    public Teacher() {
    }

    public Teacher(String name, String subject, String qualification) {
        this.name = name;
        this.subject = subject;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
