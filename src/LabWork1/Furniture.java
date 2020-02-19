package LabWork1;

abstract class Furniture
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

    protected abstract void LookInfo();
}
