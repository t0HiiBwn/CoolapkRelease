package com.tencent.imsdk.ext.group;

public class TIMGroupPendencyGetParam {
    private long numPerPage;
    private long timestamp;

    public TIMGroupPendencyGetParam setTimestamp(long j) {
        if (j < 0) {
            j = 0;
        }
        this.timestamp = j;
        return this;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public TIMGroupPendencyGetParam setNumPerPage(long j) {
        this.numPerPage = j;
        return this;
    }

    public long getNumPerPage() {
        return this.numPerPage;
    }
}
