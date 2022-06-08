package com.email.service.icd;

public class EmailListData {
    public String fromEmail;
    public String toEmail;
    public String subject;

    public EmailListData(String from_email, String to_email, String subject) {
        this.fromEmail = from_email;
        this.toEmail = to_email;
        this.subject = subject;
    }
}
