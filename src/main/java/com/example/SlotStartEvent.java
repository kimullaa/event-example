package com.example;

import org.springframework.context.ApplicationEvent;

public class SlotStartEvent extends ApplicationEvent {
    private final Rotation rotation;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SlotStartEvent(Object source, Rotation rotation) {
        super(source);
        this.rotation = rotation;
    }

    public Rotation getRotation() {
        return rotation;
    }
}


