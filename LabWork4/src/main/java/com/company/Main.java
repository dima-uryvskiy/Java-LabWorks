package com.company;

import java.io.IOException;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<String[]> data = FileReaderWriter.ReadFromFile("DataFile.csv");
        ArrayList<Furniture> furnitures = DataParser.Parse(new ArrayList<Furniture>(), data);

        for (Furniture obj: furnitures)
            obj.LookInfo();
    }
}
