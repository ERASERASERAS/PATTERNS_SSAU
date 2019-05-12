package com.company.patterns;

import com.company.model.Pupil;

import java.io.IOException;

public interface ChainOfResponsibility {
    public void write(Pupil pupil) throws IOException;
    public void next(Pupil pupil) throws IOException;
}
