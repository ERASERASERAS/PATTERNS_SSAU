package com.company.model;

import com.company.patterns.Command;
import com.company.patterns.Visitor;

public interface Pupil {

    void setSurname(String surname);
    String getSurname();
    void setMark(int mark, int index);
    int getMark(int index);
    void setSubject(String subject, int index);
    void setCommand(Command command);
    String getSubject(int index);
    void addSubjectAndMark(String subject, int mark);
    int getSize();
    Pupil clone();
    void accept(Visitor visitor);
}
