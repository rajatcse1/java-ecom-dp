package org.example.command;

import java.util.List;

public class CommandDemo {
    public static void main(String[] args) {
        System.out.println("Command pattern.");
        final boolean isVip = false;

        List<CommandTypes> vipOrderFlow = List.of(
                CommandTypes.RESERVE_INVENTORY,
                CommandTypes.VALIDATE_PAYMENT,
                CommandTypes.SEND_CONFIRMATION_EMAIL
        );

        List<CommandTypes> genericOrderFlow = List.of(
                CommandTypes.VALIDATE_PAYMENT,
                CommandTypes.RESERVE_INVENTORY,
                CommandTypes.NOTIFY_WAREHOUSE,
                CommandTypes.SEND_CONFIRMATION_EMAIL
        );

        FlowBuilder flowBuilder  = new FlowBuilder();

        List<CommandTypes> currentFlow = isVip ? vipOrderFlow : genericOrderFlow;
        currentFlow.forEach(command -> flowBuilder.addFlow(CommandRegistry.getCommad(command)));

        flowBuilder.processFlows();
    }
}
