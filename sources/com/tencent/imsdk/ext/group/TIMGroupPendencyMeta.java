package com.tencent.imsdk.ext.group;

public class TIMGroupPendencyMeta {
    private long nextStartTimestamp;
    private long reportedTimestamp;
    private long unReadCount;

    public long getNextStartTimestamp() {
        return this.nextStartTimestamp;
    }

    void setNextStartTimestamp(long j) {
        this.nextStartTimestamp = j;
    }

    public long getReportedTimestamp() {
        return this.reportedTimestamp;
    }

    void setReportedTimestamp(long j) {
        this.reportedTimestamp = j;
    }

    public long getUnReadCount() {
        return this.unReadCount;
    }

    void setUnReadCount(long j) {
        this.unReadCount = j;
    }
}
