package com.coolapk.market.event;

public class AppEvent implements Event {
    public String packageName;

    public AppEvent(String str) {
        this.packageName = str;
    }
}
