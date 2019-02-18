package com.company.patterns;

import com.company.model.Pupil;

public interface PupilFactory {
    Pupil createInstance(String surname, int size);
}
