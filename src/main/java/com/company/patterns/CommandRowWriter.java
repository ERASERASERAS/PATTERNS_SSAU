package com.company.patterns;

import com.company.model.Pupil;

import java.io.FileWriter;
import java.io.IOException;

public class CommandRowWriter implements Command {
    @Override
    public void write(Pupil pupil, FileWriter writer) throws IOException {
        try {
            writer.write(String.format("%s ", pupil.getSurname() + ' '));
            for (int i = 0; i < pupil.getSize(); i++) {
                writer.write(String.format("%s ", pupil.getSubject(i)));
                writer.write(String.format("%d ", pupil.getMark(i)));
            }
        } finally {
            writer.close();
        }
    }
}
