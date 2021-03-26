package com.coolapk.market.event;

public class WifiEvent {
    private final boolean isFirst;
    private final boolean isWifiAvailableAfter;
    private final boolean isWifiAvailableBefore;

    public WifiEvent(boolean z, boolean z2, boolean z3) {
        this.isFirst = z;
        this.isWifiAvailableBefore = z2;
        this.isWifiAvailableAfter = z3;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isWifiAvailableBefore() {
        return this.isWifiAvailableBefore;
    }

    public boolean isWifiAvailableAfter() {
        return this.isWifiAvailableAfter;
    }
}
