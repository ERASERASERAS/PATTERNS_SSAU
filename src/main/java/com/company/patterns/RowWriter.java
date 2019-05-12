package com.company.patterns;

import com.company.model.Pupil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RowWriter implements ChainOfResponsibility {

    private ColumnWriter columnWriter;

    public void setNext(ColumnWriter columnWriter) {
        this.columnWriter = columnWriter;
    }



    @Override
    public void write(Pupil pupil) throws IOException {
        if (pupil.getSize() <= 3) {
            try (FileWriter writer = new FileWriter(new File("rowwriter.txt"))) {
                writer.write(String.format("%s ", pupil.getSurname() + ' '));
                for (int i = 0; i < pupil.getSize(); i++) {
                    writer.write(String.format("%s ", pupil.getSubject(i)));
                    writer.write(String.format("%d ", pupil.getMark(i)));
                }
            }
        } else {
            next(pupil);
        }
    }

    @Override
    public void next(Pupil pupil) throws IOException {
        columnWriter.write(pupil);
    }
}
