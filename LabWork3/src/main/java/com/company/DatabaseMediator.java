package com.company;

import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DatabaseMediator
{
    private Connection connection;

    public boolean Connect(String userSystemName, String dataBaseName, String userName, String password)
    {
        boolean isConnected;
        try
        {
            connection = DriverManager.getConnection("jdbc:" + userSystemName + "://localhost:5432/" + dataBaseName,
                    userName,
                    password);
            connection.setAutoCommit(false);
            isConnected = true;
            System.out.println("Opened database successfully");
        } catch (SQLException e)
        {
            isConnected = false;
            System.out.println("Database connection is failed");
        }
        return isConnected;
    }

    public void Disconnect()
    {
        try
        {
            connection.close();
            System.out.println("Database disconnected successfully");
        } catch (SQLException e)
        {
            System.out.println("Database disconnect is failed");
        }
    }

    public boolean Insert(String tableName, String nameOfColumns, String values)
    {
        boolean isInserted;
        String requestText = "insert into " + tableName + " (" + nameOfColumns + ") values (" + values + ");";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(requestText);
            statement.close();
            connection.commit();
            isInserted = true;
            System.out.println("New " + tableName + " has been added to the database");
        } catch (SQLException e)
        {
            isInserted = false;
            System.out.println("adding a new " + tableName + " to the database failed");
        }
        return isInserted;
    }

    public ArrayList<String> SelectFieldsFromTable(String tableName, LinkedList<String> allFields)
    {
        ArrayList<String> allObjectsValues = new ArrayList<String>();
        StringBuilder requestResult = new StringBuilder();
        String requestText = "select * from " + tableName + ";";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet dataFromRequest = statement.executeQuery(requestText);
            while (dataFromRequest.next())
            {
                for (String field : allFields)
                {
                    requestResult.append(String.valueOf(dataFromRequest.getObject(field)).trim() + " ");
                }
                allObjectsValues.add(requestResult.toString());
                requestResult.setLength(0);
            }
            dataFromRequest.close();
            statement.close();
            connection.commit();
        } catch (SQLException e)
        {
            allObjectsValues.add("adding a new " + tableName + " to the database failed");
        }

        for (String obj : allObjectsValues)
            System.out.println(obj);

        return allObjectsValues;
    }

    public void DeleteAllFromTable(String tableName)
    {
        String requestText = "delete from " + tableName + ";";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(requestText);
            statement.close();
            connection.commit();
            System.out.println("Delete from " + tableName + " success");
        } catch (SQLException e)
        {
            System.out.println("Delete from " + tableName + " is failed");
        }
    }

    public void UpdateLineInTable(String tableName, LinkedList<String> allFields, String field, String newValue)
    {
        allFields.addFirst("id");
        SelectFieldsFromTable(tableName, allFields);
        Scanner in = new Scanner(System.in);
        System.out.print("Input id of updatable record: ");
        String id = in.nextLine();
        in.close();
        String requestText = "update " + tableName + " set " + field + " = '" + newValue + "' where id = " + id + ";";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(requestText);
            connection.commit();
            statement.close();
            System.out.println("Update in " + tableName + " success");
        } catch (SQLException e)
        {
            System.out.println("Update if " + tableName + " is failed");
        }
    }


    public void  InsertRow()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input product type: ");
        String type = scanner.nextLine();

        System.out.print("Input product name: ");
        String name = scanner.nextLine();

        System.out.print("Input product color: ");
        String color = scanner.nextLine();

        System.out.print("Input product width: ");
        int width = scanner.nextInt();

        System.out.print("Input product height: ");
        int height = scanner.nextInt();

        System.out.print("Input product length: ");
        int length = scanner.nextInt();

        System.out.print("\n");

        try {
                String sql = "INSERT INTO chair (type, name, width, height, length, color) Values (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, type);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, width);
                preparedStatement.setInt(4, height);
                preparedStatement.setInt(5, length);
                preparedStatement.setString(6, color);
                int rows = preparedStatement.executeUpdate();

                System.out.printf("%d rows added", rows);
                connection.commit();
                preparedStatement.close();
        }
        catch(Exception ex) {
            System.out.println("Connection failed...");
        }
    }
}