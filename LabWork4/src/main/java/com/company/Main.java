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
        ObjectDAO objectDAO = new ObjectDAO();

        for (Chair chair : chairs)
            objectDAO.addValue(chair);

        //System.out.print("Input index, when you want update name: ");
        int index = 3;//scanner.nextInt();

        if (CheckIndex(index, lengthArray)) {
           // System.out.print("Input new name: ");
            String name = "Hello";//scanner.nextLine();

            chairs.get(index).setName(name);
            objectDAO.updateValue(chairs.get(index));
        }

        //System.out.print("Input index, object which you want delete: ");
        index = 2;//scanner.nextInt();

        if  (CheckIndex(index, lengthArray)) {
            objectDAO.deleteValue(chairs.get(index));
        }

        //System.out.print("Input index, object which you want look main info: ");
        index = 1;//scanner.nextInt();

        //if  (CheckIndex(index, lengthArray)) {
          //  object = objectDAO.getObjectById(Long.parseLong(Integer.toString(index)));
        //}

       // for (Chair fur: chairDAO.getAllValue()){
              //  System.out.println(fur.getName());
       // }

        //TODO: добавить еще 2 сущности переделать эту под офис и связать
        //TODO: офис может содержать стулья и столы
        //TODO: Json можно использовать вместо CSV
    }
}
