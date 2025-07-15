package org.example.facade.services;

public class EmailService {
    public void sendConfirmationEmail(String userEmail) {
        System.out.println("Sending confirmation email to " + userEmail);
    }
}
