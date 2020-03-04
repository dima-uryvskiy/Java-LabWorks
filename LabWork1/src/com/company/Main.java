package com.company;

import LabWork1.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER;

    static {
        try (FileInputStream ins = new FileInputStream("./src/LabWork1/log.config")) { //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        LOGGER.log(Level.INFO, "Start main and read csv file");
        List<String[]> result = Reader.ReadFile();
        Reader.PrintData(result);
        LOGGER.log(Level.INFO, "Create array object");
        ArrayList<Furniture> furniture = new ArrayList<>();
        LOGGER.log(Level.INFO, "Add objects in array");
        for (String[] rows : result)  // заполнение массивы объектами
        {
            if (rows[0].contains("chair"))
                furniture.add(new Chair(rows[0], rows[1], Integer.parseInt(rows[2]), Integer.parseInt(rows[3]),
                        Integer.parseInt(rows[4]), rows[5]));
            if (rows[0].contains("table"))
                furniture.add(new Table(rows[0], rows[1], Integer.parseInt(rows[2]), Integer.parseInt(rows[3]),
                        Integer.parseInt(rows[4]), rows[5]));
        }
        LOGGER.log(Level.INFO, "Serialization");
        Serialization.CreateFile(furniture);
        LOGGER.log(Level.INFO, "Deserialization");
        Deserialization.CreateArray();

        LOGGER.log(Level.INFO, "Print info");
        for (Furniture obj: furniture)
            obj.LookInfo();
    }
}