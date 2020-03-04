package LabWork1;

import java.io.Serializable;

public abstract class Furniture implements Serializable
{
    protected String type;
    protected String name;
    protected int width;
    protected int height;
    protected int length;
    protected String color;

    public Furniture(String type, String name, int width, int height, int length, String color)
    {
        this.type = type;
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length ;
        this.color = color;
    }

    public void LookInfo()
    {
        System.out.println("Main Info:");
        System.out.printf("Type: %s\nName: %s\nWidth: %d\nHeight: %d\nLength: %d\nColor: %s\n",
                type, name, width, height, length, color);
        System.out.print("\n");
    }
}
