package com.email.service.icd;

public class EmailListData {
    public int id;
    public String fromEmail;
    public String toEmail;
    public String subject;

    public EmailListData(int id, String from_email, String to_email, String subject) {
        this.id = id;
        this.fromEmail = from_email;
        this.toEmail = to_email;
        this.subject = subject;
    }
}
