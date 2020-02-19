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
       List<String> list = Reader.ConvertToList(result);
       String [] array = list.toArray(new String[list.size()]);
       Reader.PrintDataList(list);
      // Reader.PrintData(result);




       Chair test = new Chair(array[0], array[1], Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5]);
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