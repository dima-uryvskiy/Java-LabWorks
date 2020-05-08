package com.company;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;


public class FileReaderWriter
{
    static public ArrayList<String []> ReadFromFile(String downloadFilePath) throws IOException
    {
        CSVReader reader = new CSVReader(new FileReader(downloadFilePath), ',', '\0', 0);
        String[] nextLine;
        ArrayList<String []> data = new ArrayList<String[]>();
        while ((nextLine = reader.readNext()) != null)
                data.add(nextLine);
        return data;
    }
}

