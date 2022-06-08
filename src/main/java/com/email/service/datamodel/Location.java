package com.email.service.datamodel;

import javax.persistence.*;

@Entity
@Table(schema = "public")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private ELocation name;

    public Location() {}


    public int getId() {
        return id;
    }

    public ELocation getName() {
        return name;
    }
}
