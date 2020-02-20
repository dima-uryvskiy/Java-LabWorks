package LabWork1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Deserialization {

    public static List<String[]> CreateArrayChair() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("./src/LabWork1/SerChairLabWork1.ser"));
        ArrayList<String[]> newResult = (ArrayList<String[]>)ois.readObject();
        return newResult;
    }

    public static List<String[]> CreateArrayTable() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("./src/LabWork1/SerTableLabWork1.ser"));
        ArrayList<String[]> newResult = (ArrayList<String[]>)ois.readObject();
        return newResult;
    }
}
