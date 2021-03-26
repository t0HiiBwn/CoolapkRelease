package com.tencent.imsdk.ext.group;

public class TIMGroupAVMemberInfo {
    private String faceUrl = "";
    private long joinTime = 0;
    private String nickName = "";
    private int role;
    private String userID = "";

    public String getUserID() {
        return this.userID;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public int getRole() {
        return this.role;
    }
}
