package com.company;

import LabWork1.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<String[]> result = Reader.ReadFile();
        Reader.PrintData(result);

        // Сериализация
        Serialization.CreateFile(result);
        // Десериализация
        Reader.PrintData(Deserialization.CreateArray(result));  //  создание нового массива
        Deserialization.CreateFile();

        ArrayList<Chair> chairs = new ArrayList<>();  // массив объектов
        ArrayList<Table> tables = new ArrayList<>();

        for (String[] rows: result)  // заполнение массивы объектами
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
    }
}