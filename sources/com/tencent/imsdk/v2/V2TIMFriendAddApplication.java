package com.tencent.imsdk.v2;

import com.tencent.imsdk.friendship.TIMFriendRequest;

public class V2TIMFriendAddApplication {
    private TIMFriendRequest timFriendRequest;

    public V2TIMFriendAddApplication(String str) {
        this.timFriendRequest = new TIMFriendRequest(str);
    }

    TIMFriendRequest getTIMFriendRequest() {
        return this.timFriendRequest;
    }

    public void setUserID(String str) {
        this.timFriendRequest.setIdentifier(str);
    }

    public void setFriendRemark(String str) {
        this.timFriendRequest.setRemark(str);
    }

    public void setFriendGroup(String str) {
        this.timFriendRequest.setFriendGroup(str);
    }

    public void setAddWording(String str) {
        this.timFriendRequest.setAddWording(str);
    }

    public void setAddSource(String str) {
        this.timFriendRequest.setAddSource(str);
    }

    public void setAddType(int i) {
        if (!(i == 1 || i == 2)) {
            i = 2;
        }
        this.timFriendRequest.setAddType(i);
    }
}
