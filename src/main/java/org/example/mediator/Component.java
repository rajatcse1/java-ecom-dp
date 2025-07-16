package org.example.mediator;

public abstract class Component {
    Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
}
