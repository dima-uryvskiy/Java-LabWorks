package LabWork1;

import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {
    public static ArrayList ReadFile() throws IOException {
        CSVReader reader = new CSVReader(new java.io.FileReader("./src/LabWork1/LabWork1.csv"), ',', '"', 0);
        String nextLine = "";
        ArrayList dataFile = new ArrayList();

        while ((nextLine =  Arrays.toString(reader.readNext())) != "null")
            dataFile.add(nextLine);
        return dataFile;
    }
}
