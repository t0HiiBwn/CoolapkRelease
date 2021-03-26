package com.coolapk.market.event;

public class ApplicationVisibleEvent {
    private final boolean isShown;

    public ApplicationVisibleEvent(boolean z) {
        this.isShown = z;
    }

    public boolean isShown() {
        return this.isShown;
    }
}
