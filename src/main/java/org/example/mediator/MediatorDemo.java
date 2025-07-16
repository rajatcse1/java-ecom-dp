package org.example.mediator;

import org.example.mediator.impl.InventoryService;
import org.example.mediator.impl.NotificationService;
import org.example.mediator.impl.PaymentService;

public class MediatorDemo {
    public static void main(String[] args) {
        System.out.println(MediatorDemo.class.getSimpleName());
        OrderMediator orderMediator = new OrderMediator();

        InventoryService inventoryService = new InventoryService(orderMediator);
        NotificationService notificationService = new NotificationService(orderMediator);
        PaymentService paymentService = new PaymentService(orderMediator);

        orderMediator.setInventoryService(inventoryService);
        orderMediator.setNotificationService(notificationService);
        orderMediator.setPaymentService(paymentService);

        orderMediator.notify(null, EventType.ORDER_PLACED);
    }
}
