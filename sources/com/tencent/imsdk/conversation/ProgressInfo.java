package com.tencent.imsdk.conversation;

public class ProgressInfo {
    private long currentSize;
    private long totalSize;

    public ProgressInfo(long j, long j2) {
        this.currentSize = j;
        this.totalSize = j2;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    public long getTotalSize() {
        return this.totalSize;
    }
}
