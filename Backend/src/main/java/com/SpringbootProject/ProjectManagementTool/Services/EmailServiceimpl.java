package com.SpringbootProject.ProjectManagementTool.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class  EmailServiceimpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendEmilaWithtoken(String email, String link) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"utf-8");
        try{

            String subject = "Invitation for Project Joining ";
            String text = "Click link to join the project "+link;
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            mimeMessageHelper.setTo(email);
        }catch (MessagingException e){
            throw new MessagingException("Failed to send message ");
        }
    }

}

