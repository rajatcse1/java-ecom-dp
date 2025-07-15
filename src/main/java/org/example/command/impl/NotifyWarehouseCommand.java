package org.example.command.impl;

import org.example.command.Command;

public class NotifyWarehouseCommand implements Command {
    @Override
    public void execute() {
        System.out.println(String.format("%s executed", this.getClass().getName()));
    }
}
