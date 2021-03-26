package com.coolapk.market.event;

public class SettingEvent implements Event {
    public final String key;

    public SettingEvent(String str) {
        this.key = str;
    }
}
