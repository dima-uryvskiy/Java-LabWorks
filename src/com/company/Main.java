package com.company;

import LabWork1.Chair;
import LabWork1.Reader;
import LabWork1.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<String[]> result = Reader.ReadFile();

        ArrayList<Chair[]> chairs; //= new Chair(array[0], array[1], Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5]);
        ArrayList<Table[]> tables;



       /*
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("LabWork1.ser")) ;
        oos.writeObject(result);
        oos.flush();


        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("LabWork1.ser"));
        ArrayList<String[]> newResult = (ArrayList<String[]>)ois.readObject();

        Reader.PrintData(result);
*/
    }
}