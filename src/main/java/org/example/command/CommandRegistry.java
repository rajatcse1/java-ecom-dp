package org.example.command;

import org.example.command.impl.NotifyWarehouseCommand;
import org.example.command.impl.ReserveInventoryCommand;
import org.example.command.impl.SendConfirmationEmailCommand;
import org.example.command.impl.ValidatePaymentCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class CommandRegistry {
    private static Map<CommandTypes, Supplier<Command>> commands = new HashMap<>();

    static {
        commands.put(CommandTypes.NOTIFY_WAREHOUSE, NotifyWarehouseCommand::new);
        commands.put(CommandTypes.RESERVE_INVENTORY, ReserveInventoryCommand::new);
        commands.put(CommandTypes.SEND_CONFIRMATION_EMAIL, SendConfirmationEmailCommand::new);
        commands.put(CommandTypes.VALIDATE_PAYMENT, ValidatePaymentCommand::new);
    }

    public static Command getCommad(CommandTypes commandName){
        return Optional.ofNullable(commands.get(commandName))
                .map(commandSupplier -> commandSupplier.get())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Command: %s not found", commandName)));
    }
}
