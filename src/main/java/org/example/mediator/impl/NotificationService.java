package org.example.mediator.impl;

import org.example.mediator.Component;
import org.example.mediator.Mediator;

public class NotificationService extends Component {
    public NotificationService(Mediator mediator) {
        super(mediator);
    }

    public void sendEmail() {
        System.out.println("Sending confirmation email...");
    }
}
