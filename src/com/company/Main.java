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

        ArrayList<Chair> chairs = new ArrayList<>();  // массив объектов
        ArrayList<Table> tables = new ArrayList<>();

        for (String[] rows: result)
        {
            if (rows[0].contains("chair"))
                chairs.add(new Chair(rows[0], rows[1], Integer.parseInt(rows[2]),Integer.parseInt(rows[3]),
                        Integer.parseInt(rows[4]),rows[5]));
            if (rows[0].contains("table"))
                tables.add(new Table(rows[0], rows[1], Integer.parseInt(rows[2]),Integer.parseInt(rows[3]),
                        Integer.parseInt(rows[4]),rows[5]));
        }

        for (Chair rows: chairs)  // вывод стульев
            rows.LookInfo();

        for (Table rows: tables)  // вывод столов
            rows.LookInfo();

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