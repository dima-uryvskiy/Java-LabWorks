package com.company;

import LabWork1.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       List<String[]> result = Reader.ReadFile();
       Reader.PrintData(result);


        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("LabWork1.ser")) ;
        oos.writeObject(result);
        oos.flush();


        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("LabWork1.ser"));
        ArrayList<String[]> newResult = (ArrayList<String[]>)ois.readObject();

        Reader.PrintData(result);

    }
}