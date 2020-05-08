package com.company;

import java.util.ArrayList;

public class DataParser
{
    static public ArrayList<Furniture> Parse(ArrayList<Furniture> furnitures, ArrayList<String []> allData)
    {
        for (String[] furnitureData:allData)
        {
            if(furnitureData[0].contains("table"))
                furnitures.add(new Table_T(furnitureData));
            if(furnitureData[0].contains("chair"))
                furnitures.add(new Chair(furnitureData));
        }
        return furnitures;
    }
}
