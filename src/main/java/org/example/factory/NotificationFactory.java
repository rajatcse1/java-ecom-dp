package org.example.factory;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class NotificationFactory {
    public static Map<NotificationType, Supplier<Notification>> registry = new HashMap<>();

    public static void register(NotificationType type, Supplier<Notification> notification){
        registry.put(type, notification);
    }

    public static Notification create(NotificationType type){
        return Optional.ofNullable(registry.get(type))
                .map(Supplier::get)
                .orElseThrow(() -> new IllegalArgumentException("Not a correct type"));
    }
}
