package com.tencent.imsdk.friendship;

public class TIMFriendGetResult {
    private int relation;
    private int resultCode;
    private String resultInfo;
    private TIMFriend timFriend;

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public int getRelation() {
        return this.relation;
    }

    public TIMFriend getTimFriend() {
        return this.timFriend;
    }
}
