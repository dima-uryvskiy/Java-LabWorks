package com.company;

import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<String[]> dataOffice = FileReaderWriter.ReadFromFile("Office.csv");
        ArrayList<Office> offices = new ArrayList<Office>();
        for (String[] officeData: dataOffice) {
            Office office = new Office();
            office.setType(officeData[0]);
            office.setName(officeData[1]);
            office.setCity(officeData[2]);

            offices.add(office);
        }

        ArrayList<String[]> data = FileReaderWriter.ReadFromFile("DataFile.csv");
        ArrayList<Chair> chairs = new ArrayList<Chair>();
        ArrayList<Desk> desks = new ArrayList<Desk>();


        for (String[] furnitureData: data)
        {
            if (furnitureData[0].contains("chair")){

                Chair chair = new Chair();
                chair.setType(furnitureData[0]);
                chair.setName(furnitureData[1]);
                chair.setIdOffice(Integer.valueOf(furnitureData[2]));
                chair.setHeight(Integer.valueOf(furnitureData[3]));
                chair.setLength(Integer.valueOf(furnitureData[4]));
                chair.setColor(furnitureData[5]);

                chairs.add(chair);
            }

            if (furnitureData[0].contains("desk")) {

                Desk desk = new Desk();
                desk.setType(furnitureData[0]);
                desk.setName(furnitureData[1]);
                desk.setIdOffice(Integer.valueOf(furnitureData[2]));
                desk.setHeight(Integer.valueOf(furnitureData[3]));
                desk.setLength(Integer.valueOf(furnitureData[4]));
                desk.setColor(furnitureData[5]);

                desks.add(desk);
            }


        }

         //TODO: look main info about object
        for (Chair chair : chairs) {
            chair.LookInfo();
        }

        for (Desk desk : desks) {
            desk.LookInfo();
        }

        for (Office office : offices) {
            office.LookInfo();
        }

        //TODO: add values in data base
        ObjectDAO objectDAO = new ObjectDAO();

        for (Chair chair : chairs)
            objectDAO.addValue(chair);

        for (Desk desk : desks)
            objectDAO.addValue(desk);

        for (Office office : offices)
            objectDAO.addValue(office);

        int index = 1;

        String name = "Hello";

        chairs.get(index).setName(name);
        objectDAO.updateValue(chairs.get(index));

        desks.get(index).setName(name);
        objectDAO.updateValue(desks.get(index));

        offices.get(index).setName(name);
        objectDAO.updateValue(offices.get(index));

        index = 0;

        objectDAO.deleteValue(chairs.get(index));
        objectDAO.deleteValue(desks.get(index));
        objectDAO.deleteValue(offices.get(index));

        index = 1;

        objectDAO.getChairById(Long.parseLong(Integer.toString(index)));
        objectDAO.getDeskById(Long.parseLong(Integer.toString(index)));
        objectDAO.getOfficeById(Long.parseLong(Integer.toString(index)));

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
