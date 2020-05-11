package com.company;

import com.company.util.HibernateUtil;
import org.hibernate.classic.Session;

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

        for (Furniture obj: furnitures)
            obj.LookInfo();



        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(furnitures.get(3));

        session.getTransaction().commit();
    }
}
