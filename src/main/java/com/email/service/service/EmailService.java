package com.email.service.service;

import com.email.service.datamodel.Email;
import com.email.service.datamodel.User;
import com.email.service.icd.EmailListData;
import com.email.service.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    public Email createEmail(Email email, User user) {
        email.setTimestamp();
        email.setFromEmail(user);
        Email e = emailRepository.save(email);
        return e;
    }

    public List<EmailListData> listEmailSubjects(String emailAddress) {
        return emailRepository.listEmailsBySubject(emailAddress);
    }

    public List<EmailListData> listSentEmails(String emailAddress) {
        return emailRepository.listSentEmails(emailAddress);
    }

}
