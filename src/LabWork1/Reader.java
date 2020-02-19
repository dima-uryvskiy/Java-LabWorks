package LabWork1;

import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.util.List;

public class Reader {
    public static List<String[]> ReadFile() throws IOException {
        CSVReader reader = new CSVReader(new java.io.FileReader("./src/LabWork1/LabWork1.csv"), ',', '"', 0);
        return reader.readAll();
    }

    public static void PrintData(List<String[]> dataFile){
        for (String[] i :dataFile)
        {
            for (String j :i)
                System.out.print(j + " ");
            System.out.print("\n");
        }
    }
}
