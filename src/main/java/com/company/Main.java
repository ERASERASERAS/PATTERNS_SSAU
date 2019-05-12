package com.company;

import com.company.model.Pupil;
import com.company.model.Pupils;
import com.company.model.Student;
import com.company.patterns.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        checkSingleton();

        System.out.println("________________FACTORY____________");
        Pupil pupilIvanov = Pupils.createinstance("IVANOV" , 0);
        pupilIvanov.addSubjectAndMark("Math" , 4);
        pupilIvanov.addSubjectAndMark("Foreign language", 3);
        pupilIvanov.addSubjectAndMark("Physics" , 5);
        System.out.println(pupilIvanov.getClass());

        Pupils.showResults(pupilIvanov);
        System.out.println("AVERAGE: " + Pupils.getAverage(pupilIvanov));

        Pupils.setFactory(new SchoolboyFactory());

        Pupil pupilPetrov = Pupils.createinstance("PETROV", 0);
        System.out.println(pupilPetrov.getClass());
        pupilPetrov.addSubjectAndMark("Math", 2);
        pupilPetrov.addSubjectAndMark("Foreigh language", 2);
        pupilPetrov.addSubjectAndMark("Physics", 3);

        Pupils.showResults(pupilPetrov);
        System.out.println("AVERAGE: " + Pupils.getAverage(pupilPetrov));
        System.out.println("____________FACTORY_____________________");

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
        prototypes[0].setSubject("dfdfdf", 1);

        Pupils.showResults(prototypes[0]);
        Pupils.showResults(initPupils[0]);

        String[] strings = {"aa", "bb", "ccc"};

        StringAdapter.write(strings);

        String [] readStrings = StringAdapter.read();

        for(String s : readStrings) {
            System.out.println(s);
        }


        try {
            checkChainOfResponsobility();
            checkCommand();
          //  checkMemento();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void checkSingleton() {
        System.out.println("__________CHECK SINGLETON_____________");
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
        System.out.println("______________CHECK SINGLETON____________");
    }

    public static void checkChainOfResponsobility() throws IOException {
        System.out.println("______________CHAIN OF RESPONSOBILITY________________");

        Student st = new Student("SURNAME", 3);

        st.setMark(5, 0);
        st.setMark(5,1);
        st.setMark(5, 2);

        st.setSubject("asd", 0);
        st.setSubject("zxc", 1);
        st.setSubject("qwe", 2);

        Student st2 = (Student) st.clone();

        st2.addSubjectAndMark("POI", 5);

        ColumnWriter columnWriter = new ColumnWriter();
        RowWriter rowWriter = new RowWriter();

        columnWriter.setNext(rowWriter);
        rowWriter.setNext(columnWriter);

        rowWriter.write(st);
        rowWriter.write(st2);
        System.out.println("______________CHAIN OF RESPONSOBILITY________________");
    }


    public static void checkCommand() throws IOException {
        System.out.println("___________CHECK COMMAND___________");
        Student st = new Student("SURNAME", 3);
        st.setMark(5, 0);
        st.setMark(5,1);
        st.setMark(5, 2);

        st.setSubject("asd", 0);
        st.setSubject("zxc", 1);
        st.setSubject("qwe", 2);

        st.print(new FileWriter(new File("commandRow.txt")));
        st.setCommand(new CommandColumnWriter());
        st.print(new FileWriter(new File("commandColumn.txt")));
        System.out.println("___________CHECK COMMAND___________");
    }

    public static void checkIterator() {
        System.out.println("________CHECK ITERATOR________");

        System.out.println("_______CHECK ITERATOR________");
    }

    public static void checkMemento() {
        System.out.println("_______________MEMENTO___________________");
        Student st = new Student("SURNAME", 3);
        st.setMark(5, 0);
        st.setMark(5,1);
        st.setMark(5, 2);

        st.createMemento();
        st.setSurname("MEMENTO");

        Pupils.showResults(st);

        Pupils.showResults(st.getMemento());

        System.out.println("_______________MEMENTO___________________");

    }

    public static void checkStrategy() {
        System.out.println("_________STRATEGY___________");

        System.out.println("_________STRATEGY___________");

    }



}
