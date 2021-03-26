package com.coolapk.market.event;

public class FeedRemoveHeadlineEvent {
    private String id;

    public FeedRemoveHeadlineEvent(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }
}
