package org.example.mediator;

import org.example.mediator.impl.InventoryService;
import org.example.mediator.impl.NotificationService;
import org.example.mediator.impl.PaymentService;

public class OrderMediator implements Mediator{
    InventoryService inventoryService;
    NotificationService notificationService;
    PaymentService paymentService;

    @Override
    public void notify(Component sender, EventType event) {
        switch (event){
            case ORDER_PLACED -> {
                if(inventoryService.checkStock()){
                    paymentService.processPayment();
                } else{
                    System.out.println("out of stock");
                }
            }
            case PAYMENT_PROCESSED -> {
                inventoryService.reserveItems();
                notificationService.sendEmail();
            }
        }
    }

    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
