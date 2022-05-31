package com.email.service.datamodel;

import java.time.LocalDateTime;

public class Appointment extends EmailEntity {
    private ELocation location;
    public Appointment(int id, String from, String to, String subject, LocalDateTime timestamp, ELocation location) {
        super(id, from, to, subject, timestamp);

        this.location = location;
    }
}