package org.example.factory.impl;

import org.example.factory.Notification;

public class SmsNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("SMS Notification");
    }
}
