package com.tencent.imsdk.v2;

import com.tencent.imsdk.friendship.TIMFriendResult;

public class V2TIMFriendOperationResult {
    private TIMFriendResult timFriendResult;

    void setTIMFriendResult(TIMFriendResult tIMFriendResult) {
        this.timFriendResult = tIMFriendResult;
    }

    public String getUserID() {
        TIMFriendResult tIMFriendResult = this.timFriendResult;
        if (tIMFriendResult != null) {
            return tIMFriendResult.getIdentifier();
        }
        return null;
    }

    public int getResultCode() {
        TIMFriendResult tIMFriendResult = this.timFriendResult;
        if (tIMFriendResult != null) {
            return tIMFriendResult.getResultCode();
        }
        return 6017;
    }

    public String getResultInfo() {
        TIMFriendResult tIMFriendResult = this.timFriendResult;
        if (tIMFriendResult != null) {
            return tIMFriendResult.getResultInfo();
        }
        return null;
    }
}
