package org.example.mediator.impl;

import org.example.mediator.Component;
import org.example.mediator.EventType;
import org.example.mediator.Mediator;
import org.example.mediator.OrderMediator;

public class PaymentService extends Component {
    private Mediator mediator;

    public PaymentService(Mediator mediator) {
        super(mediator);
        this.mediator = mediator;
    }

    public void processPayment() {
        System.out.println("Processing payment...");
        mediator.notify(this, EventType.PAYMENT_PROCESSED);
    }
}
