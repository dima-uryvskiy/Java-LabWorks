package com.company;
import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.util.Arrays;


public class Main
{
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new java.io.FileReader("LabWork1.csv"), ',', '"', 0);
        String[] nextLine;
        while ((nextLine =  reader.readNext()) != null)
        {
            if (nextLine != null)
            {
                System.out.println(Arrays.toString(nextLine));
            }
        }
    }
}