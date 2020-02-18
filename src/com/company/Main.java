package com.company;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;

class TestSerial implements Serializable {
    public byte version = 100;
    public byte count = 0;
}

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CSVReader reader = new CSVReader(new java.io.FileReader("./src/LabWork1/LabWork1.csv"), ',', '"', 0);
        String[] nextLine = new String[10];

        while ((nextLine =  reader.readNext()) != null)
        {
            if (nextLine != null)
            {
                System.out.println(Arrays.toString(nextLine));
            }
        }
        System.out.println(Arrays.toString(nextLine));

        int[] arr = {10, 20, 30};
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("LabWork1.ser")) ;
        oos.writeObject(arr);
        oos.flush();


        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("LabWork1.ser"));
        int[] a = (int[])ois.readObject();
        System.out.println(Arrays.toString(a));
    }
}