package LabWork1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {

    public static void CreateFile(ArrayList<Furniture> dataFile) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("./src/LabWork1/SerLabWork1.ser"));
        oos.writeObject(dataFile);
        oos.flush();
    }
}
