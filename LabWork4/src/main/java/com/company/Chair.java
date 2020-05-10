package com.company;

import javax.persistence.*;

@Entity
@Table
public class Chair extends Furniture
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Chair(String [] parameters)
    {
        this.type = parameters[0];
        this.name = parameters[1];
        this.width = Integer.valueOf(parameters[2]);
        this.height = Integer.valueOf(parameters[3]);
        this.length = Integer.valueOf(parameters[4]);
        this.color = parameters[5];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override public void LookInfo()
    {
        System.out.println("Main Info:");
        System.out.printf("Type: %s\nName: %s\nWidth: %d\nHeight: %d\nLength: %d\nColor: %s\n",
                this.type, this.name, this.width, this.height, this.length, this.color);
        System.out.print("\n");
    }
}
