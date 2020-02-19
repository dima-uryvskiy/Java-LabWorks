package com.company;

import LabWork1.Chair;
import LabWork1.Reader;
import LabWork1.Table;

import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       List<String[]> result = Reader.ReadFile();
       Reader.PrintData(result);
       Chair test = new Chair("Chair", "Test", 50,60,70,"Red");
       test.LookInfo();
       Table table = new Table("Table", "Test1", 50,60,70,"Red");
       table.LookInfo();

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