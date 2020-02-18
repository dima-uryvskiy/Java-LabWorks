package com.company;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CSVReader reader = new CSVReader(new java.io.FileReader("./src/LabWork1/LabWork1.csv"), ',', '"', 0);
        String nextLine = "";
        ArrayList result = new ArrayList();

        while ((nextLine =  Arrays.toString(reader.readNext())) != "null")
           result.add(nextLine);

        for (Object i :result)
            System.out.println(i);


        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("LabWork1.ser")) ;
        oos.writeObject(result);
        oos.flush();


        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("LabWork1.ser"));
        ArrayList newResult = (ArrayList)ois.readObject();

        for (Object i :newResult)
            System.out.println(i);
    }
}