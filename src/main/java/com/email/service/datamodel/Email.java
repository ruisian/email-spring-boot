package com.email.service.datamodel;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Email extends EmailEntity {
    private boolean isArchived;
    private String body;

    public Email(int id, String from, String to, String subject, String body, LocalDateTime timestamp, boolean isArchived) {
        super(id, from, to, subject, timestamp);

        this.body = body;
        this.isArchived = isArchived;
    }

    public Email() {
    }

    public Email(String from, String to, String subject, String body) {
        super(from, to, subject);
        this.body = body;
    }


//    public boolean isArchived() {
//        return isArchived;
//    }

    public String getBody() {
        return body;
    }

    public boolean getIsArchived() {
        return isArchived;
    }
}
