package com.email.service.repository;

import com.email.service.datamodel.Email;
import com.email.service.icd.EmailListData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Integer> {
    @Query(value = "select new com.email.service.icd.EmailListData(fromEmail, toEmail, subject) from Email where toEmail = :toEmail")
    List<EmailListData> listEmailsBySubject(@Param("toEmail") String emailAddress);

    @Query(value = "select new com.email.service.icd.EmailListData(fromEmail, toEmail, subject) from Email where fromEmail = :fromEmail")
    List<EmailListData> listSentEmails(@Param("fromEmail") String emailAddress);
}
