package com.tencent.imsdk.v2;

import java.util.ArrayList;
import java.util.List;

public class V2TIMGroupApplicationResult {
    private long reportedTimestamp = 0;
    private int unreadCount = 0;
    private List<V2TIMGroupApplication> v2TIMGroupApplicationList = new ArrayList();

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public List<V2TIMGroupApplication> getGroupApplicationList() {
        return this.v2TIMGroupApplicationList;
    }

    void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    void setReportedTimestamp(long j) {
        this.reportedTimestamp = j;
    }
}
