package org.example.facade;

import org.example.facade.services.EmailService;
import org.example.facade.services.InventoryService;
import org.example.facade.services.InvoiceService;
import org.example.facade.services.PaymentService;

public class OrderFacade {
    private EmailService emailService = new EmailService();
    private InventoryService inventoryService = new InventoryService();
    private InvoiceService invoiceService = new InvoiceService();
    private PaymentService paymentService = new PaymentService();

    public void placeOrder(
            String productId,
            String userId,
            double amount,
            String orderId,
            String email
    ){
        if(inventoryService.checkStock(productId)){
            paymentService.processPayment(userId, amount, () -> {
                invoiceService.generateInvoice(orderId);
                emailService.sendConfirmationEmail(email);
                System.out.println("Order successful.");
            });
        }else{
            System.out.println("Product is out of stock");
        }
    }
}
