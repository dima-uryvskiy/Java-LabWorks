package com.company;
import java.io.*;

public abstract class Furniture implements Serializable
{
    public String type;
    public String name;
    public int width;
    public int height;
    public int length;
    public String color;
    public void LookInfo(){};
    public void CreateFromText(String [] text){};
    public String TakeClassName(){return this.getClass().getSimpleName();};
}
