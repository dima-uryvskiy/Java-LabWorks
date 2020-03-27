package com.company;

import java.io.IOException;
import java.util.*;

import org.javatuples.Pair;

public class Main
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<String[]> allData = FileReaderWriter.ReadFromFile("DataFile.csv");
        ArrayList<Furniture> allFurnitures = DataParser.Parse(new ArrayList<Furniture>(), allData);

        ArrayList<Pair<String, String>> dataForDatabase = new ArrayList<Pair<String, String>>();
        for (Furniture furniture : allFurnitures)
        {
            furniture.LookInfo();
            dataForDatabase.add(DatabaseDataPreparer.PrepearData(furniture));
        }
        DatabaseMediator databaseMediator = new DatabaseMediator();
        if (databaseMediator.Connect("postgresql", "test", "dima", "postgres"))
        {
            for (int i = 0; i < allFurnitures.size(); i++)
            {
                databaseMediator.Insert(allFurnitures.get(i).TakeClassName(),
                        dataForDatabase.get(i).getValue0(),
                        dataForDatabase.get(i).getValue1());
            }
            databaseMediator.Disconnect();
        }
    }
}
