package LabWork1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {

    public static void CreateFileChair(ArrayList<Chair> dataFile) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("./src/LabWork1/SerChairLabWork1.ser"));
        oos.writeObject(dataFile);
        oos.flush();
    }

    public static void CreateFileTable(ArrayList<Table> dataFile) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("./src/LabWork1/SerTableLabWork1.ser"));
        oos.writeObject(dataFile);
        oos.flush();
    }
}
