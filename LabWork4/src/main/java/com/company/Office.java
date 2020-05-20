package com.company;

import org.apache.commons.collections.ArrayStack;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "office")
public class Office {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_office")
    private Long id;

    @Column (name = "type")
    private String type;

    @Column (name = "name")
    private String name;

    @Column (name = "city")
    private String city;


    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chair> chairs;
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Desk> desks;

    public Office() {
        chairs = new ArrayList<Chair>();
        desks = new ArrayList<Desk>();

    }

    public void addChairs(Chair chair) {
        chair.setOffice(this);
        chairs.add(chair);
    }

    public void removeChair(Chair chair) {
        chairs.remove(chair);
    }

    public void addDesks(Desk desk) {
        desk.setOffice(this);
        desks.add(desk);
    }

    public void removeDesk(Desk desk) {
        desks.remove(desk);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return
                "Main Info:\n" +
                "Type:" + type + "\nName:" + name +
                "\nCity:" + city + "\n";
    }
}

