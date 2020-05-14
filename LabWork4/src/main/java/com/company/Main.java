package com.company;

import java.io.IOException;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<String[]> data = FileReaderWriter.ReadFromFile("DataFile.csv");
        ArrayList<Furniture> furnitures = new ArrayList<Furniture>();

        for (String[] furnitureData: data)
        {
            Furniture furniture = new Furniture();
            furniture.setType(furnitureData[0]);
            furniture.setName(furnitureData[1]);
            furniture.setWidth(Integer.valueOf(furnitureData[2]));
            furniture.setHeight(Integer.valueOf(furnitureData[3]));
            furniture.setLength(Integer.valueOf(furnitureData[4]));
            furniture.setColor(furnitureData[5]);

            furnitures.add(furniture);
        }

        for (Furniture furniture: furnitures) {
            furniture.LookInfo();
        }

        FurnitureDAO furnitureDAO = new FurnitureDAO();

        for (Furniture furniture: furnitures)
            furnitureDAO.addFurniture(furniture);

        //TODO: добавить ввод пользователя на значение и в каком меняем в общем сделать менюшку
        furnitures.get(0).setName("Hello");
        furnitureDAO.updateFurniture(furnitures.get(0));

        furnitureDAO.deleteFurniture(furnitures.get(0));

        //TODO: добавить ввод пользователя
        furnitureDAO.getFurnitureById(Long.parseLong("3")).LookInfo();

        //TODO: разобраться с методом getAllFurnitures
    }
}
