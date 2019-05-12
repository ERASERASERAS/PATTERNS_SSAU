package com.company.model;

import com.company.patterns.Command;
import com.company.patterns.CommandRowWriter;
import com.company.patterns.Visitor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Schoolboy implements Pupil{
    private String surname;

    private Register[] registers;

    private Command command = new CommandRowWriter();

    public Schoolboy() {}

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

    public class SchoolboyIterator implements Iterator<Register> {
        private int count = registers.length;
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < count;
        }

        @Override
        public Register next() {
            if (current < count) {
                return registers[current++];
            } else {
                throw new NoSuchElementException("No such element.");
            }
        }
    }


    static class Register implements Serializable {
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

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Предмет: " + subject + " Оценка: " + mark;
        }

    }

    @Override
    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
