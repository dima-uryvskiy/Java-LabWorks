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
        ArrayList<Chair> chairs = new ArrayList<Chair>();

        for (String[] furnitureData: data)
        {
            Chair chair = new Chair();
            chair.setType(furnitureData[0]);
            chair.setName(furnitureData[1]);
            chair.setWidth(Integer.valueOf(furnitureData[2]));
            chair.setHeight(Integer.valueOf(furnitureData[3]));
            chair.setLength(Integer.valueOf(furnitureData[4]));
            chair.setColor(furnitureData[5]);

            chairs.add(chair);
        }

        for (Chair chair : chairs) {
            chair.LookInfo();
        }

        int lengthArray = chairs.size();

        Scanner scanner = new Scanner(System.in);
        ChairDAO chairDAO = new ChairDAO();

        for (Chair chair : chairs)
            chairDAO.addFurniture(chair);

        System.out.print("Input index, when you want update name: ");
        int index = scanner.nextInt();

        if (CheckIndex(index, lengthArray)) {
            System.out.print("Input new name: ");
            String name = scanner.nextLine();

            chairs.get(index).setName(name);
            chairDAO.updateFurniture(chairs.get(index));
        }

        System.out.print("Input index, object which you want delete: ");
        index = scanner.nextInt();

        if  (CheckIndex(index, lengthArray)) {
            chairDAO.deleteFurniture(chairs.get(index));
        }

        System.out.print("Input index, object which you want look main info: ");
        index = scanner.nextInt();

        if  (CheckIndex(index, lengthArray)) {
            chairDAO.getFurnitureById(Long.parseLong(Integer.toString(index))).LookInfo();
        }

        for (Chair fur: chairDAO.getAllFurnitures()){
                System.out.println(fur.getName());
        }

        //TODO: добавить еще 2 сущности переделать эту под офис и связать
        //TODO: офис может содержать стулья и столы
        //TODO: session.createQuery("FROM Furniture WHERE name = 'Mini'");
        //TODO: Json можно использовать вместо CSV
    }
}
