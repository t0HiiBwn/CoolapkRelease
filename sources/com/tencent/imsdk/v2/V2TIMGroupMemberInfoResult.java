package com.tencent.imsdk.v2;

import java.util.List;

public class V2TIMGroupMemberInfoResult {
    private long nextSeq;
    private List<V2TIMGroupMemberFullInfo> v2TIMGroupMemberFullInfoList;

    V2TIMGroupMemberInfoResult(long j, List<V2TIMGroupMemberFullInfo> list) {
        this.nextSeq = j;
        this.v2TIMGroupMemberFullInfoList = list;
    }

    public long getNextSeq() {
        return this.nextSeq;
    }

    public List<V2TIMGroupMemberFullInfo> getMemberInfoList() {
        return this.v2TIMGroupMemberFullInfoList;
    }
}
