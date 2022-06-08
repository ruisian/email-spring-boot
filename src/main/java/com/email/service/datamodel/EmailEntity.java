package com.email.service.datamodel;

import javax.persistence.*;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name="from_email")
    private String fromEmail;
    @Column(name="to_email")
    private String toEmail;
    private String subject;
    private LocalDateTime timestamp;

    public EmailEntity (int id, String fromEmail, String toEmail, String subject, LocalDateTime timestamp) {
        this.id = id;
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.subject = subject;
        this.timestamp = timestamp;
    }

    public EmailEntity() {

    }

    public EmailEntity(String fromEmail, String toEmail, String subject) {
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    public void setFromEmail(User user) {
        this.fromEmail = user.getEmail();
    }
}



