package com.coolapk.market.event;

public class NotificationDeletedEvent {
    private final String id;

    public NotificationDeletedEvent(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }
}
