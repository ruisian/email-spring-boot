package com.email.service.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public abstract class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String from;
    private String to;
    private String subject;
    private LocalDateTime timestamp;

    public EmailEntity (int id, String from, String to, String subject, LocalDateTime timestamp) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.timestamp = timestamp;
    }


    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}



