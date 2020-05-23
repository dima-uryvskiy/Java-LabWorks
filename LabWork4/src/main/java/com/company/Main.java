package com.company;

import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<String[]> dataOffice = FileReaderWriter.ReadFromFile("Office.csv");
        ArrayList<Office> offices = new ArrayList<Office>();
        ObjectDAO objectDAO = new ObjectDAO();
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
                chair.setWeight(Integer.valueOf(furnitureData[2]));
                chair.setHeight(Integer.valueOf(furnitureData[3]));
                chair.setLength(Integer.valueOf(furnitureData[4]));
                chair.setColor(furnitureData[5]);

                objectDAO.addValue(chair);
                chairs.add(chair);
            }

            if (furnitureData[0].contains("desk")) {

                Desk desk = new Desk();
                desk.setType(furnitureData[0]);
                desk.setName(furnitureData[1]);
                desk.setWeight(Integer.valueOf(furnitureData[2]));
                desk.setHeight(Integer.valueOf(furnitureData[3]));
                desk.setLength(Integer.valueOf(furnitureData[4]));
                desk.setColor(furnitureData[5]);

                objectDAO.addValue(desk);
                desks.add(desk);
            }
        }

         //Look main info about object
        for (Chair chair : chairs) {
            chair.toString();
        }

        for (Desk desk : desks) {
            desk.toString();
        }

        for (Office office : offices) {
            office.toString();
        }

        objectDAO = new ObjectDAO();

        //Add values in data base
        int indexObject = 0;
        for (Office office : offices)
        {
            objectDAO.addValue(office);

            office.addChairs(chairs.get(indexObject));
            office.addDesks(desks.get(indexObject));
        }

        //Update values in data base
        int index = 1;
        String name = "Hello";

        offices.get(index).setName(name);
        objectDAO.updateValue(offices.get(index));

        //Delete values in data base
        index = 1;

        objectDAO.deleteValue(offices.get(index));

        //Look main info values in data base
        index = 1;

        System.out.println(objectDAO.getOfficeById(Long.parseLong(Integer.toString(index))).toString());

        for (Office office: objectDAO.getAllOffice()){
            System.out.println(office.toString());
        }

        for (Office  office: objectDAO.hqlRequest()){
            System.out.println(office.toString());
        }
    }
}
