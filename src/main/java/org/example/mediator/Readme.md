You're 100% right — the example I gave before is indeed closer to the **Facade Pattern**, not the **Mediator Pattern**, because the mediator was coordinating without truly decoupling the **colleagues** from each other.

Let's correct that and provide a **true Mediator Pattern** example in a real-world ecommerce context.

---

## ✅ Real-World Ecommerce Example — **True Mediator Pattern** (Java 17)

### Scenario: **Order Processing**

### ✅ Goal of Mediator:

* Components (e.g., `InventoryService`, `PaymentService`, `NotificationService`) do **not** talk directly to each other.
* Instead, they **only communicate via a Mediator**.
* This pattern avoids hard-wired dependencies between services.

---

### 🧩 Mediator Interface

```java
public interface Mediator {
    void notify(Component sender, String event);
}
```

---

### 🧩 Concrete Mediator

```java
public class OrderMediator implements Mediator {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private NotificationService notificationService;

    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void notify(Component sender, String event) {
        switch (event) {
            case "OrderPlaced" -> {
                if (inventoryService.checkStock()) {
                    paymentService.processPayment();
                } else {
                    System.out.println("Out of stock.");
                }
            }
            case "PaymentProcessed" -> {
                inventoryService.reserveItems();
                notificationService.sendEmail();
            }
        }
    }
}
```

---

### 🧩 Base Component

```java
public abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
}
```

---

### 🧩 Colleague Components

```java
public class InventoryService extends Component {
    public InventoryService(Mediator mediator) {
        super(mediator);
    }

    public boolean checkStock() {
        System.out.println("Checking stock...");
        return true;
    }

    public void reserveItems() {
        System.out.println("Reserving items in inventory...");
    }
}

public class PaymentService extends Component {
    public PaymentService(Mediator mediator) {
        super(mediator);
    }

    public void processPayment() {
        System.out.println("Processing payment...");
        mediator.notify(this, "PaymentProcessed");
    }
}

public class NotificationService extends Component {
    public NotificationService(Mediator mediator) {
        super(mediator);
    }

    public void sendEmail() {
        System.out.println("Sending confirmation email...");
    }
}
```

---

### 🧪 Client Code

```java
public class EcommerceApp {
    public static void main(String[] args) {
        OrderMediator mediator = new OrderMediator();

        InventoryService inventory = new InventoryService(mediator);
        PaymentService payment = new PaymentService(mediator);
        NotificationService notification = new NotificationService(mediator);

        mediator.setInventoryService(inventory);
        mediator.setPaymentService(payment);
        mediator.setNotificationService(notification);

        System.out.println("== Order is being placed ==");
        mediator.notify(null, "OrderPlaced");
    }
}
```

---

## 🔄 Comparison to Facade

| Feature                      | **Mediator**                                         | **Facade**                                           |
| ---------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| Who controls the flow?       | The components notify the mediator and let it decide | The facade class drives everything                   |
| Component dependencies       | Components know only the mediator                    | Components call each other directly through a facade |
| Bi-directional communication | ✅ (Mediator can be notified and trigger flow)        | ❌ (Facade is one-directional)                        |
| Goal                         | Decoupling peers                                     | Simplifying interface                                |

---

Would you like to convert this into a Spring Boot REST API example with Mediator logic inside services?
