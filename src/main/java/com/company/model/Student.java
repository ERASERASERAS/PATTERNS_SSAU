package com.company.model;

import java.util.Arrays;

public class Student implements  Pupil{

    private String surname;
    int [] marks;
    String [] subjects;

    public Student(String surname, int arraySize) {
        this.surname = surname;
        marks = new int[arraySize];
        subjects = new String[arraySize];
    }


    public Student(Student student) {
        this.surname = student.getSurname();
        this.marks = new int[student.getSize()];
        this.subjects = new String[student.getSize()];
        for(int i = 0; i < student.getSize(); i++) {
            this.marks[i] = student.getMark(i);
            this.subjects[i] = student.getSubject(i);
        }
    }

    public void setSurname(String surname)  {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setMark(int mark, int index) {
        marks[index] = mark;
    }

    public int getMark(int index) {
        return marks[index];
    }

    public void setSubject(String subject, int index) {
        subjects[index] = subject;
    }

    public String getSubject(int index) {
        return subjects[index];
    }

    public void addSubjectAndMark(String subject, int mark) {
        marks = Arrays.copyOf(marks, marks.length + 1);
        marks[marks.length - 1] = mark;
        subjects = Arrays.copyOf(subjects, subjects.length + 1);
        subjects[subjects.length - 1] = subject;
    }

    public int getSize() {
        return marks.length;
    }

    @Override
    public Pupil clone() {
        return new Student(this);
    }
}
