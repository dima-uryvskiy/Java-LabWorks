package com.company;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "desk")
public class Desk
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "id_desk")
    private Long id;

    @Column (name = "type")
    private String type;

    @Column (name = "name")
    private String name;

    @Column (name = "weight")
    private int weight;

    @Column (name = "height")
    private int height;

    @Column (name = "length")
    private int length;

    @Column (name = "color")
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_office")
    private Office office;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString()
    {
        return
                "Main Info:\n" +
                "Type:" + type + "\nName:" + name +
                "\nwight:" + weight + "\nHeight:" + height + "\nLength:" +
                 length + "\nColor:" + color + "\n";
    }
}
