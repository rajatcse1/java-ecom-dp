package org.example.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Notifier {
    private final List<Supplier<Observer>> listeners = new ArrayList<>();

    public void register(Supplier<Observer> observer) {
        listeners.add(observer);
    }

    public void notify(String message) {
        listeners.forEach(observer -> observer.get().update(message));
    }
}
