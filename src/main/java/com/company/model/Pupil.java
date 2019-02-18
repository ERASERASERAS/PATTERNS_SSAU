package com.company.model;

public interface Pupil {

    void setSurname(String surname);
    String getSurname();
    void setMark(int mark, int index);
    int getMark(int index);
    void setSubject(String subject, int index);
    String getSubject(int index);
    void addSubjectAndMark(String subject, int mark);
    int getSize();
    Pupil clone();
}
