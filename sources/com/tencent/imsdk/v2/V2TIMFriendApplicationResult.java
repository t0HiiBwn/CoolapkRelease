package com.tencent.imsdk.v2;

import java.util.ArrayList;
import java.util.List;

public class V2TIMFriendApplicationResult {
    private int unreadCount = 0;
    private List<V2TIMFriendApplication> v2TIMFriendApplicationList = new ArrayList();

    public int getUnreadCount() {
        return this.unreadCount;
    }

    void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public List<V2TIMFriendApplication> getFriendApplicationList() {
        return this.v2TIMFriendApplicationList;
    }
}
