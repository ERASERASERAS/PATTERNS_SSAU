package com.company.model;

import com.company.patterns.PupilFactory;
import com.company.patterns.StudentFactory;

public class Pupils {

    private static PupilFactory factory = new StudentFactory();

    public static void showResults(Pupil pupil) {
        System.out.println("Фамилия: " + pupil.getSurname());
        for(int i = 0; i < pupil.getSize(); i++) {
            System.out.println(pupil.getSubject(i) + " - " + pupil.getMark(i));
        }
    }

    public static double getAverage(Pupil pupil) {
        double sum = 0;
        for(int i = 0; i < pupil.getSize(); i++) {
            sum += pupil.getMark(i);
        }
        return  pupil.getSize() != 0 ?  sum / pupil.getSize() : 0;
    }

    public static void setFactory(PupilFactory pupilFactory) {
        factory = pupilFactory;
    }

    public static Pupil createinstance(String surname, int size) {
        return factory.createInstance(surname, size);
    }
}
