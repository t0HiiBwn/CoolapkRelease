package com.coolapk.market.event;

public class ImageLoadEvent {
    private long bytesRead;
    private long expectedLength;
    private boolean isClosed;
    private final String url;

    public ImageLoadEvent(String str, long j, long j2) {
        this.url = str;
        this.bytesRead = j;
        this.expectedLength = j2;
    }

    public ImageLoadEvent(String str, boolean z) {
        this.url = str;
        this.isClosed = z;
    }

    public String getUrl() {
        return this.url;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public long getExpectedLength() {
        return this.expectedLength;
    }

    public boolean isClosed() {
        return this.isClosed;
    }
}
