package LabWork1;

import java.io.*;
import java.util.List;


class TestSerial implements Serializable {
    public byte version = 100;
    public byte count = 0;
}

public class Serialization {

    public static void CreateFile(List<String[]> dataFile) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("./src/LabWork1/SerLabWork1.ser")) ;
        oos.writeObject(dataFile);
        oos.flush();
    }
}
