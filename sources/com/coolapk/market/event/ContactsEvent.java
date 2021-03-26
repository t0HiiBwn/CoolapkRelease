package com.coolapk.market.event;

public class ContactsEvent {
    public final boolean isFollow;
    public final String uid;

    public ContactsEvent(boolean z, String str) {
        this.isFollow = z;
        this.uid = str;
    }
}
