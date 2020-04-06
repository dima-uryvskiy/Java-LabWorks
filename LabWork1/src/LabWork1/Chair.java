package LabWork1;

public class Chair extends Furniture
{
    public Chair(String type, String name, int width, int height, int length, String color)
    {
       super(type, name, width, height, length, color);
    }

    public void LookInfo()
    {
        System.out.println("Main Info:");
        System.out.printf("Type: %s\nName: %s\nWidth: %d\nHeight: %d\nLength: %d\nColor: %s\n",
                type, name, width, height, length, color);
        System.out.print("\n");
    }
}
