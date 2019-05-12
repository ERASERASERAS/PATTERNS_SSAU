package com.company.patterns;

import com.company.model.Pupil;

public class PupilDecorator implements Pupil {

    private Pupil pupil;

    public PupilDecorator(Pupil pupil) {
        this.pupil = pupil;
    }
    @Override
    public  synchronized void setSurname(String surname) {

    }

    @Override
    public synchronized String getSurname() {
        return null;
    }

    @Override
    public synchronized void setMark(int mark, int index) {

    }

    @Override
    public synchronized int getMark(int index) {
        return 0;
    }

    @Override
    public synchronized void setSubject(String subject, int index) {

    }

    @Override
    public void setCommand(Command command) {

    }

    @Override
    public synchronized String getSubject(int index) {
        return null;
    }

    @Override
    public synchronized void addSubjectAndMark(String subject, int mark) {

    }

    @Override
    public synchronized int getSize() {
        return 0;
    }

    @Override
    public synchronized Pupil clone() {
        return null;
    }
}
