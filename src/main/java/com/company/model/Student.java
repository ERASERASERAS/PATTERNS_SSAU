package com.company.model;

import com.company.patterns.Command;
import com.company.patterns.CommandRowWriter;
import com.company.patterns.Visitor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Student implements  Pupil{

    private String surname;
    int [] marks;
    String [] subjects;

    private Command command = new CommandRowWriter();

    public Student () {

    }

    public Student(String surname, int arraySize) {
        this.surname = surname;
        marks = new int[arraySize];
        subjects = new String[arraySize];
    }


    public Student(Student student) {
        this.surname = student.getSurname();
        this.marks = new int[student.getSize()];
        this.subjects = new String[student.getSize()];
        for(int i = 0; i < student.getSize(); i++) {
            this.marks[i] = student.getMark(i);
            this.subjects[i] = student.getSubject(i);
        }
    }

    public void setSurname(String surname)  {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setMark(int mark, int index) {
        marks[index] = mark;
    }

    public int getMark(int index) {
        return marks[index];
    }

    public void setSubject(String subject, int index) {
        subjects[index] = subject;
    }

    public String getSubject(int index) {
        return subjects[index];
    }

    public void addSubjectAndMark(String subject, int mark) {
        marks = Arrays.copyOf(marks, marks.length + 1);
        marks[marks.length - 1] = mark;
        subjects = Arrays.copyOf(subjects, subjects.length + 1);
        subjects[subjects.length - 1] = subject;
    }

    public void print(FileWriter fileWriter) throws IOException {
        command.write(this, fileWriter);
    }

    public int getSize() {
        return marks.length;
    }

    @Override
    public Pupil clone() {
        return new Student(this);
    }

    @Override
    public void setCommand(Command command) {
        this.command = command;
    }

    public void createMemento(){
        Memento.setStudent(this);
    }

    public Student getMemento(){
        return Memento.getStudent();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public static class Memento {
        private static byte[] studentArray;

        static void setStudent(Student student) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
                baos.write(student.surname.length());

                baos.write(student.surname.getBytes());

                int size = student.marks.length;

                baos.write(size);

                for(int i = 0; i < size; i++){
                    baos.write(student.subjects[i].length());
                    baos.write(student.subjects[i].getBytes());
                    baos.write(student.marks[i]);
                }

                studentArray = baos.toByteArray();
            } catch (Exception e) {
                studentArray = null;
            }
        }

        static Student getStudent() {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(studentArray)) {
                int famLength = bais.read();

                String family = new String(bais.readNBytes(famLength), StandardCharsets.UTF_8);

                int size = bais.read();

                Student student = new Student(family, size);

                for(int i = 0; i < size; i++){
                    int s = bais.read();
                    String subj = new String(bais.readNBytes(s), StandardCharsets.UTF_8);
                    int mark = bais.read();

                    student.setMark(mark, i);
                    student.setSubject(subj, i);
                }

                return student;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
