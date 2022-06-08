package com.email.service.datamodel;

import javax.persistence.*;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name="from_email")
    private String from;
    @Column(name="to_email")
    private String to;
    private String subject;
    private LocalDateTime timestamp;

    public EmailEntity (int id, String fromEmail, String toEmail, String subject, LocalDateTime timestamp) {
        this.id = id;
        this.from = fromEmail;
        this.to = toEmail;
        this.subject = subject;
        this.timestamp = timestamp;
    }

    public EmailEntity() {

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



