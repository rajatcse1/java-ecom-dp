package org.example.mediator.impl;

import org.example.mediator.Component;
import org.example.mediator.Mediator;

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
