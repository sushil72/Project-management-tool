package com.SpringbootProject.ProjectManagementTool.Services;

import jakarta.mail.MessagingException;

public interface EmailService {
    public void sendEmilaWithtoken(String email, String link) throws MessagingException;
}
