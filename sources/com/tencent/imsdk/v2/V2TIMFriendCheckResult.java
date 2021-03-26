package com.tencent.imsdk.v2;

import com.tencent.imsdk.friendship.TIMCheckFriendResult;

public class V2TIMFriendCheckResult {
    public static final int V2TIM_FRIEND_RELATION_TYPE_BOTH_WAY = 3;
    public static final int V2TIM_FRIEND_RELATION_TYPE_IN_MY_FRIEND_LIST = 1;
    public static final int V2TIM_FRIEND_RELATION_TYPE_IN_OTHER_FRIEND_LIST = 2;
    public static final int V2TIM_FRIEND_RELATION_TYPE_NONE = 0;
    private TIMCheckFriendResult timCheckFriendResult;

    void setTIMCheckFriendResult(TIMCheckFriendResult tIMCheckFriendResult) {
        this.timCheckFriendResult = tIMCheckFriendResult;
    }

    public String getUserID() {
        TIMCheckFriendResult tIMCheckFriendResult = this.timCheckFriendResult;
        if (tIMCheckFriendResult != null) {
            return tIMCheckFriendResult.getIdentifier();
        }
        return null;
    }

    public int getResultCode() {
        TIMCheckFriendResult tIMCheckFriendResult = this.timCheckFriendResult;
        if (tIMCheckFriendResult != null) {
            return tIMCheckFriendResult.getResultCode();
        }
        return 0;
    }

    public String getResultInfo() {
        TIMCheckFriendResult tIMCheckFriendResult = this.timCheckFriendResult;
        if (tIMCheckFriendResult != null) {
            return tIMCheckFriendResult.getResultInfo();
        }
        return null;
    }

    public int getResultType() {
        TIMCheckFriendResult tIMCheckFriendResult = this.timCheckFriendResult;
        if (tIMCheckFriendResult != null) {
            return tIMCheckFriendResult.getResultType();
        }
        return 0;
    }
}
