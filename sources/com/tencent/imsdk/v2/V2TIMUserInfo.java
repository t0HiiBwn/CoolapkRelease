package com.tencent.imsdk.v2;

public class V2TIMUserInfo {
    private String faceUrl = "";
    private String nickName = "";
    private String userID = "";

    public String getUserID() {
        return this.userID;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    protected void setUserID(String str) {
        this.userID = str;
    }

    protected void setNickName(String str) {
        this.nickName = str;
    }

    protected void setBaseFaceUrl(String str) {
        this.faceUrl = str;
    }
}
