package com.company.patterns;

import com.company.model.Pupil;
import com.company.model.Student;

public class StudentFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String surname, int size) {
        return new Student(surname, size);
    }
}
