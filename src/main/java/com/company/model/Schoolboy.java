package com.company.model;

import java.util.Arrays;

public class Schoolboy implements Pupil{
    private String surname;

    private Register[] registers;

    public Schoolboy(String surname, int registersSize) {
        this.surname = surname;
        registers = new Register[registersSize];
    }

    public Schoolboy(Schoolboy schoolboy) {
        this.surname = schoolboy.getSurname();
        this.registers = new Register[schoolboy.getSize()];
        for(int i = 0; i < schoolboy.getSize(); i++) {
            this.registers[i] = new Register(schoolboy.getSubject(i), schoolboy.getMark(i));
        }
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setMark(int mark, int index) {
        registers[index].setMark(mark);
    }

    public int getMark(int index) {
        return registers[index].getMark();
    }

    public void setSubject(String subject, int index) {
        registers[index].setSubject(subject);
    }

    public String getSubject(int index) {
        return registers[index].getSubject();
    }

    public void addSubjectAndMark(String subject, int mark) {
       registers =  Arrays.copyOf(registers, registers.length + 1);
        registers[registers.length - 1] = new Register(subject, mark);
    }

    @Override
    public Pupil clone() {
        return new Schoolboy(this);
    }

    public int getSize() {
        return registers.length;
    }


    public class Register {
        int mark;
        String subject;

        public Register(String subject, int mark) {
            this.subject = subject;
            this.mark = mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public int getMark() {
            return mark;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getSubject() {
            return subject;
        }
    }
}
