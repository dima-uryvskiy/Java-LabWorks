package com.company;

public class Table_T extends Furniture
{
    public Table_T(String [] allParameters)
    {
        CreateFromText(allParameters);
    }

    @Override public void CreateFromText(String [] allParameters)
    {
        this.type = allParameters[0];
        this.name = allParameters[1];
        this.width = Integer.valueOf(allParameters[2]);
        this.height = Integer.valueOf(allParameters[3]);
        this.length = Integer.valueOf(allParameters[4]);
        this.color = allParameters[5];
    }

    @Override public void LookInfo()
    {
        System.out.println("Main Info:");
        System.out.printf("Type: %s\nName: %s\nWidth: %d\nHeight: %d\nLength: %d\nColor: %s\n",
                this.type, this.name, this.width, this.height, this.length, this.color);
        System.out.print("\n");
    }

}
