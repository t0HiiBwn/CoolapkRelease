package com.tencent.imsdk;

public class TIMGroupChangeInfo {
    String faceUrl;
    int flag;
    String introduction;
    String name;
    String notification;
    String owner;
    long ownerTinyId;

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public String getNotification() {
        return this.notification;
    }

    public void setNotification(String str) {
        this.notification = str;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public long getOwnerTinyId() {
        return this.ownerTinyId;
    }

    public void setOwnerTinyId(long j) {
        this.ownerTinyId = j;
    }
}
