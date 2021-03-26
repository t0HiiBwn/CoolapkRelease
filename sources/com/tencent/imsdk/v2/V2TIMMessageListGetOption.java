package com.tencent.imsdk.v2;

public class V2TIMMessageListGetOption {
    public static final int V2TIM_GET_CLOUD_NEWER_MSG = 2;
    public static final int V2TIM_GET_CLOUD_OLDER_MSG = 1;
    public static final int V2TIM_GET_LOCAL_NEWER_MSG = 4;
    public static final int V2TIM_GET_LOCAL_OLDER_MSG = 3;
    private int count;
    private int getType;
    private String groupID;
    private V2TIMMessage lastMsg;
    private String userID;

    public void setGetType(int i) {
        this.getType = i;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setLastMsg(V2TIMMessage v2TIMMessage) {
        this.lastMsg = v2TIMMessage;
    }

    public int getGetType() {
        return this.getType;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public int getCount() {
        return this.count;
    }

    public V2TIMMessage getLastMsg() {
        return this.lastMsg;
    }
}
