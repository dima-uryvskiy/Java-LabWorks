package sample;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Furniture {

    private SimpleStringProperty type;
    private SimpleStringProperty name;
    private SimpleIntegerProperty width;
    private SimpleIntegerProperty height;
    private SimpleIntegerProperty length;
    private SimpleStringProperty color;

    public Furniture(String type, String name, int width, int height, int length, String color)
    {
        this.type = new SimpleStringProperty(type);
        this.name = new SimpleStringProperty(name);
        this.width = new SimpleIntegerProperty(width);
        this.height = new SimpleIntegerProperty(height);
        this.length = new SimpleIntegerProperty(length);
        this.color = new SimpleStringProperty(color);
    }

    public String getType(){ return type.get();}
    public void setType(String value){ type.set(value);}

    public String getName(){ return name.get();}
    public void setName(String value){ name.set(value);}

    public int getWidth(){ return width.get();}
    public void setWidth(int value){width.set(value);}

    public int getHeight(){ return height.get();}
    public void setHeight(int value){ height.set(value);}

    public int getLength(){ return length.get();}
    public void setLength(int value){ length.set(value);}

    public String getColor(){ return color.get();}
    public void setColor(String value){ color.set(value);}

    public String[] returnArray(){
        return new String[] {type.get(), name.get(), String.valueOf(width.get()),  String.valueOf(height.get()),
                String.valueOf(length.get()), color.get()};
    }

}
