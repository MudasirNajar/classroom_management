package com.example.classroom.model;

public class Student {

    private String name;
    private int rollNo;
    private String favouriteSubject;

    public Student() {
    }

    public Student(String name, int rollNo, String favouriteSubject) {
        this.name = name;
        this.rollNo = rollNo;
        this.favouriteSubject = favouriteSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFavouriteSubject() {
        return favouriteSubject;
    }

    public void setFavouriteSubject(String favouriteSubject) {
        this.favouriteSubject = favouriteSubject;
    }
}
