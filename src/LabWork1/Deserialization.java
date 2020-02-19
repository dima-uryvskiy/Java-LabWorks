package LabWork1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Deserialization {

    public static void CreateFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("./src/LabWork1/SerLabWork1.ser"));

        FileWriter writer = new FileWriter("./src/LabWork1/DesLabWork1.csv", false);
        for (String[] rows: (ArrayList<String[]>)ois.readObject())  // заполнение массивы объектами
        {
            for (int i = 0; i < rows.length; i++)
                if (i != 5)
                    writer.write(rows[i] + ",");
                else
                    writer.write(rows[i] + "\n");
        }
        writer.flush();

    }

    public static List<String[]> CreateArray(List<String[]> dataFile) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("./src/LabWork1/SerLabWork1.ser"));
        ArrayList<String[]> newResult = (ArrayList<String[]>)ois.readObject();
        return newResult;
    }
}
