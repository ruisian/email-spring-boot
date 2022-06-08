package com.email.service.datamodel;

import javax.persistence.*;

@Entity
@Table(schema = "public")
public class Role {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(ERole name) {
        this.id = name.ordinal();
        this.name = name;
    }

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
