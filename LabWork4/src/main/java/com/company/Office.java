package com.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {
        private Long id;
        private String type;
        private String name;
        private String city;

        @Id
        @GeneratedValue(generator = "increment")
        @GenericGenerator(name = "increment", strategy = "increment")
        @Column(name = "id")
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Column (name = "type")
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Column (name = "name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

         @Column (name = "city")
         public String getCity() {
        return city;
    }

        public void setCity(String city) {
        this.city = city;
    }

        public void LookInfo()
        {
            System.out.println("Main Info:");
            System.out.printf("Type: %s\nName: %s\nCity: %s\n",
                    this.type, this.name, this.city);
            System.out.print("\n");
        }
    }

