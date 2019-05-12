package com.company.patterns;

import com.company.model.Schoolboy;
import com.company.model.Student;

public interface Visitor {
    public void visit(Schoolboy schoolboy);
    public void visit(Student student);
}
