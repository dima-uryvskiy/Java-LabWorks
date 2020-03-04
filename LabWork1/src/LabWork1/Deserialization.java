package LabWork1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Deserialization {

    public static List<String[]> CreateArray() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("./src/LabWork1/SerLabWork1.ser"));
        ArrayList<String[]> newResult = (ArrayList<String[]>)ois.readObject();
        return newResult;
    }
}
