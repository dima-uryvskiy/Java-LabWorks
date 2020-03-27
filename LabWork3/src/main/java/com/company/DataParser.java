package com.company;

import java.util.ArrayList;

public class DataParser
{
    static public ArrayList<Furniture> Parse(ArrayList<Furniture> allFurnitures, ArrayList<String []> allData)
    {
        for (String[] furnitureData:allData)
        {
            if(furnitureData[0].contains("table"))
                allFurnitures.add(new Table_T(furnitureData));
            else
            if(furnitureData[0].contains("chair"))
                allFurnitures.add(new Chair(furnitureData));
        }
        return allFurnitures;
    }
}
