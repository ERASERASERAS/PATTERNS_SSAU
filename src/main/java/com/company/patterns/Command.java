package com.company.patterns;

import com.company.model.Pupil;

import java.io.FileWriter;
import java.io.IOException;

public interface Command {
    public void write(Pupil pupil, FileWriter writer) throws IOException;



}
