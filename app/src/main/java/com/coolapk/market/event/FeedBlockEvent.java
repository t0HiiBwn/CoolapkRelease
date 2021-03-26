package com.coolapk.market.event;

public class FeedBlockEvent {
    public final String id;
    public final boolean isBlocked;

    public FeedBlockEvent(String str, boolean z) {
        this.id = str;
        this.isBlocked = z;
    }
}
