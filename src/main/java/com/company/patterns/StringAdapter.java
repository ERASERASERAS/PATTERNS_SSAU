package com.company.patterns;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StringAdapter {

    public static void write(String [] strings) {
        try(DataOutputStream stream = new DataOutputStream(new FileOutputStream("adapter.txt"))) {
            stream.writeInt(strings.length);
            for (String s : strings) {
                stream.writeInt(s.length());
                stream.writeChars(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String[] read() {
        List<String> res = new ArrayList<>();

        try(DataInputStream stream = new DataInputStream(new FileInputStream("adapter.txt"))){
            int length = stream.readInt();
            for(int i = 0; i < length; i++){
                int strLength = stream.readInt();
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < strLength; j++){
                    s.append(stream.readChar());
                }
                res.add(s.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res.toArray(new String[0]);
    }


}
