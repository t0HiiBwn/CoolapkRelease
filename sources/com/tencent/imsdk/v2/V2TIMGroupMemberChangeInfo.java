package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMGroupTipsElemMemberInfo;

public class V2TIMGroupMemberChangeInfo {
    private TIMGroupTipsElemMemberInfo timGroupTipsElemMemberInfo;

    void setTIMGroupTipsElemMemberInfo(TIMGroupTipsElemMemberInfo tIMGroupTipsElemMemberInfo) {
        this.timGroupTipsElemMemberInfo = tIMGroupTipsElemMemberInfo;
    }

    public String getUserID() {
        TIMGroupTipsElemMemberInfo tIMGroupTipsElemMemberInfo = this.timGroupTipsElemMemberInfo;
        if (tIMGroupTipsElemMemberInfo != null) {
            return tIMGroupTipsElemMemberInfo.getIdentifier();
        }
        return null;
    }

    public long getMuteTime() {
        TIMGroupTipsElemMemberInfo tIMGroupTipsElemMemberInfo = this.timGroupTipsElemMemberInfo;
        if (tIMGroupTipsElemMemberInfo != null) {
            return tIMGroupTipsElemMemberInfo.getShutupTime();
        }
        return 0;
    }
}
