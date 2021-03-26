package com.coolapk.market.event;

public class UserNameEditEvent {
    private String userName;

    public UserNameEditEvent(String str) {
        this.userName = str;
    }

    public String getUserName() {
        return this.userName;
    }
}
