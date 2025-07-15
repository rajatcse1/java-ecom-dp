package org.example.observer.impl;

import org.example.observer.Observer;

public class EmailClient implements Observer {
    private final String clientName;
    public EmailClient() {
        clientName = "Anonymous";
    }

    public EmailClient(String providedClientName) {
        clientName = providedClientName;
    }

    @Override
    public void update(String message) {
        System.out.printf("Email client '%s' received the message: '%s%n", clientName, message);
    }
}
