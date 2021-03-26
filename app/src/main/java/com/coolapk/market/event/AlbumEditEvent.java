package com.coolapk.market.event;

public class AlbumEditEvent {
    private String Des;
    private String id;
    private String title;

    public AlbumEditEvent(String str, String str2, String str3) {
        this.id = str;
        this.title = str2;
        this.Des = str3;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDes() {
        return this.Des;
    }

    public String getId() {
        return this.id;
    }
}
