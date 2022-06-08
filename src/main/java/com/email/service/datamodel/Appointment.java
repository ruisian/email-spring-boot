package com.email.service.datamodel;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Entity
public class Appointment extends EmailEntity {
    @ManyToOne()
    @JoinColumn(name="location_id")
    private Location location;
    public Appointment(int id, String from, String to, String subject, LocalDateTime timestamp, Location location) {
        super(id, from, to, subject, timestamp);

        this.location = location;
    }

    public Appointment() {

    }
}