package com.company.patterns;

import com.company.model.Pupil;

import java.io.FileWriter;
import java.io.IOException;

public class CommandColumnWriter implements  Command {
    @Override
    public void write(Pupil pupil, FileWriter writer) throws IOException {
        try {
            writer.write(String.format("%s\r\n", pupil.getSurname()));
            for (int i = 0; i < pupil.getSize(); i++) {
                writer.write(String.format("%s\r\n", pupil.getSubject(i)));
                writer.write(String.format("%s\r\n", pupil.getMark(i)));
            }
        } finally {
            writer.close();
        }
    }
}
