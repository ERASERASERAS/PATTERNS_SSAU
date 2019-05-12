package com.company.patterns;

import com.company.model.Schoolboy;
import com.company.model.Student;

public class VisitorImplement implements Visitor {
    @Override
    public void visit(Schoolboy schoolboy) {
        StringBuilder subjects = new StringBuilder();

        for(int i = 0; i < schoolboy.getSize(); i++){
            subjects.append(schoolboy.getSubject(i)).append("\n").append(schoolboy.getMark(i)).append("\n");
        }

        subjects.deleteCharAt(subjects.length() - 1);

        System.out.println(String.format("%s\n%s", schoolboy.getSurname(), subjects));
    }

    @Override
    public void visit(Student student) {
        StringBuilder subjects = new StringBuilder();

        for(int i = 0; i < student.getSize(); i++){
            subjects.append(student.getSubject(i)).append(" ").append(student.getMark(i)).append(" ");
        }

        subjects.deleteCharAt(subjects.length() - 1);

        System.out.println(String.format("%s %s", student.getSubject(i), subjects));
    }
}
