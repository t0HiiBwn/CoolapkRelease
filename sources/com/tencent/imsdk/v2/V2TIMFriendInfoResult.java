package com.tencent.imsdk.v2;

import com.tencent.imsdk.friendship.TIMFriendGetResult;

public class V2TIMFriendInfoResult {
    private TIMFriendGetResult timFriendGetResult;
    private V2TIMFriendInfo v2TIMFriendInfo;

    void setTimFriendGetResult(TIMFriendGetResult tIMFriendGetResult) {
        this.timFriendGetResult = tIMFriendGetResult;
        if (tIMFriendGetResult != null) {
            if (this.v2TIMFriendInfo == null) {
                this.v2TIMFriendInfo = new V2TIMFriendInfo();
            }
            this.v2TIMFriendInfo.setTIMFriend(tIMFriendGetResult.getTimFriend());
        }
    }

    public int getResultCode() {
        TIMFriendGetResult tIMFriendGetResult = this.timFriendGetResult;
        if (tIMFriendGetResult != null) {
            return tIMFriendGetResult.getResultCode();
        }
        return -1;
    }

    public String getResultInfo() {
        TIMFriendGetResult tIMFriendGetResult = this.timFriendGetResult;
        return tIMFriendGetResult != null ? tIMFriendGetResult.getResultInfo() : "";
    }

    public int getRelation() {
        TIMFriendGetResult tIMFriendGetResult = this.timFriendGetResult;
        if (tIMFriendGetResult != null) {
            return tIMFriendGetResult.getRelation();
        }
        return 0;
    }

    public V2TIMFriendInfo getFriendInfo() {
        return this.v2TIMFriendInfo;
    }
}
