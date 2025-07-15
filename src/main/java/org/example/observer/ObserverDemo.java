package org.example.observer;

import org.example.observer.impl.EmailClient;

public class ObserverDemo {
    public static void main(String[] args) {
        // loosely coupled agencies and clients many-to-many relationship
        Notifier agency1 = new Notifier();
        Notifier agency2 = new Notifier();

        agency1.register(EmailClient::new);
        agency1.register(() -> new EmailClient("Client 1"));
        agency2.register(() -> new EmailClient("Client 1"));

        agency1.notify("New job available.");
        agency2.notify("New package available.");
    }
}
