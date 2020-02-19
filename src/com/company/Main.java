package com.company;

import LabWork1.Reader;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList result = Reader.ReadFile();

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