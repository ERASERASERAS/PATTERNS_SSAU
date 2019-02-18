package com.company.patterns;

import com.company.model.Pupil;
import com.company.model.Schoolboy;

public class SchoolboyFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String surname, int size) {
        return new Schoolboy(surname, size);
    }
}
