package org.example.factory.impl;

import org.example.factory.Notification;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Email notification");
    }
}
