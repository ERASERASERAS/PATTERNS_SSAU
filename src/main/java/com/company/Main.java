package com.company;

import com.company.model.Pupil;
import com.company.model.Pupils;
import com.company.patterns.ConfigLoader;
import com.company.patterns.SchoolboyFactory;

import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            Properties propertiesFile = ConfigLoader.getInstance().getPropertiesFile();
            propertiesFile = ConfigLoader.getInstance().getPropertiesFile();

            System.out.println("PROPERTIES: "
                    + "\nNAME = " + propertiesFile.getProperty("user.name")
                    + "\nSURNAME = " + propertiesFile.get("user.surname")
                    + "\nCLASSES = " + propertiesFile.get("user.classes"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pupil pupilIvanov = Pupils.createinstance("IVANOV" , 0);
        pupilIvanov.addSubjectAndMark("Math" , 4);
        pupilIvanov.addSubjectAndMark("Foreign language", 3);
        pupilIvanov.addSubjectAndMark("Physics" , 5);

        Pupils.showResults(pupilIvanov);
        System.out.println("AVERAGE: " + Pupils.getAverage(pupilIvanov));

        Pupils.setFactory(new SchoolboyFactory());

        Pupil pupilPetrov = Pupils.createinstance("PETROV", 0);
        pupilPetrov.addSubjectAndMark("Math", 2);
        pupilPetrov.addSubjectAndMark("Foreigh language", 2);
        pupilPetrov.addSubjectAndMark("Physics", 3);

        Pupils.showResults(pupilPetrov);
        System.out.println("AVERAGE: " + Pupils.getAverage(pupilPetrov));


        System.out.println("_____PROTOTYPE________");
        Pupil [] initPupils = new Pupil[2];
        initPupils[0] = pupilPetrov;
        initPupils[1] = pupilIvanov;
        Pupil[] prototypes = new Pupil[2];

        for(int i = 0; i < initPupils.length; i++) {
            prototypes[i] = initPupils[i].clone();
        }

        for(int i = 0; i < prototypes.length; i++) {
            System.out.println("PROTOTYPE INSTANCE:   "  + prototypes[i].getClass());
        }

        System.out.println("_____PROTOTYPE________");
    }
}
