package LabWork1;

import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<String[]> ReadFile() throws IOException {
        CSVReader reader = new CSVReader(new java.io.FileReader("./src/LabWork1/LabWork1.csv"), ',', '"', 0);
        return reader.readAll();
    }

    public static List<String> ConvertToList(List<String[]> dataFile){
        List<String> tempList = new ArrayList<>();
        for (String[] rows : dataFile) {
            for (String element : rows)
                tempList.add(element);
            tempList.add("/separation\\");
        }
        return tempList;
    }

    public static void PrintData(List<String[]> dataFile){
        for (String[] rows :dataFile)
        {
            for (String  element :rows)
                System.out.print(element + " ");
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void PrintDataList(List<String> dataFile){
            for (String  element :dataFile)
                System.out.print(element + " ");
            System.out.print("\n");
    }
}
