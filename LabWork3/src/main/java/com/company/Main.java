package com.company;

import java.io.IOException;
import java.util.*;

import org.javatuples.Pair;

public class Main
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<String[]> data = FileReaderWriter.ReadFromFile("DataFile.csv");
        ArrayList<Furniture> furnitures = DataParser.Parse(new ArrayList<Furniture>(), data);

        ArrayList<Pair<String, String>> dataForDatabase = new ArrayList<Pair<String, String>>();
        for (Furniture furniture : furnitures)
        {
            furniture.LookInfo();
            dataForDatabase.add(DatabaseDataPreparer.PrepearData(furniture));
        }
        DatabaseMediator databaseMediator = new DatabaseMediator();
        if (databaseMediator.Connect("postgresql", "test", "dima", "postgres"))
        {
            for (int i = 0; i < furnitures.size(); i++)
            {
                databaseMediator.Insert(furnitures.get(i).TakeClassName(),
                        dataForDatabase.get(i).getValue0(),
                        dataForDatabase.get(i).getValue1());
            }

            databaseMediator.InsertRow();

            databaseMediator.Disconnect();
        }
    }
}
