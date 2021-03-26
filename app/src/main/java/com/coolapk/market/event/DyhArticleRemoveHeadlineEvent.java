package com.coolapk.market.event;

public class DyhArticleRemoveHeadlineEvent {
    private String id;

    public DyhArticleRemoveHeadlineEvent(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }
}
