package org.example.mediator;

public interface Mediator {
    void notify(Component sender, EventType event);
}
