package org.example.factory;

import org.example.factory.impl.EmailNotification;
import org.example.factory.impl.SmsNotification;

public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("Factory");
        NotificationFactory.register(NotificationType.EMAIL, EmailNotification::new);
        NotificationFactory.register(NotificationType.SMS, SmsNotification::new);

        Notification notification = NotificationFactory.create(NotificationType.SMS);
        notification.notifyUser();
    }
}
