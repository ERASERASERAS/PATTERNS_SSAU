package com.company.patterns;

import com.company.model.Pupil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ColumnWriter implements ChainOfResponsibility {

    private RowWriter rowWriter;

    public void setNext(RowWriter rowWriter) {
        this.rowWriter = rowWriter;
    }
    @Override
    public void write(Pupil pupil) throws IOException {
        if (pupil.getSize() > 3) {
            try (FileWriter writer = new FileWriter(new File("columnWriter.txt"))) {
                writer.write(String.format("%s\r\n", pupil.getSurname()));
                for (int i = 0; i < pupil.getSize(); i++) {
                    writer.write(String.format("%s\r\n", pupil.getSubject(i)));
                    writer.write(String.format("%s\r\n", pupil.getMark(i)));
                }
            }
        } else {
            next(pupil);
        }
    }

    @Override
    public void next(Pupil pupil) throws IOException {
        rowWriter.next(pupil);
    }
}
