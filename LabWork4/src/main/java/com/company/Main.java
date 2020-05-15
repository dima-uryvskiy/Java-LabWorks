package com.company;

import java.io.IOException;
import java.util.*;

public class Main
{

    private static boolean CheckIndex(int index, int lengthArray)
    {
        return index >= 0 && index < lengthArray;
    }

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

        int lengthArray = furnitures.size();

        Scanner scanner = new Scanner(System.in);
        FurnitureDAO furnitureDAO = new FurnitureDAO();

        for (Furniture furniture: furnitures)
            furnitureDAO.addFurniture(furniture);

        System.out.print("Input index, when you want update name: ");
        int index = scanner.nextInt();

        if (CheckIndex(index, lengthArray)) {
            System.out.print("Input new name: ");
            String name = scanner.nextLine();

            furnitures.get(index).setName(name);
            furnitureDAO.updateFurniture(furnitures.get(index));
        }

        System.out.print("Input index, object which you want delete: ");
        index = scanner.nextInt();

        if  (CheckIndex(index, lengthArray)) {
            furnitureDAO.deleteFurniture(furnitures.get(index));
        }

        System.out.print("Input index, object which you want look main info: ");
        index = scanner.nextInt();

        if  (CheckIndex(index, lengthArray)) {
            furnitureDAO.getFurnitureById(Long.parseLong(Integer.toString(index))).LookInfo();
        }

        for (Furniture fur: furnitureDAO.getAllFurnitures()){
                System.out.println(fur.getName());
        }

        //TODO: добавить еще 2 сущности переделать эту под офис и связать
        //TODO: офис может содержать стулья и столы
        //TODO: session.createQuery("FROM Furniture WHERE name = 'Mini'");
        //TODO: Json можно использовать вместо CSV
    }
}
