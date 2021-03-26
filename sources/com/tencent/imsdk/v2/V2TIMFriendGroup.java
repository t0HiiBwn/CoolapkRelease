package com.tencent.imsdk.v2;

import com.tencent.imsdk.friendship.TIMFriendGroup;
import java.util.List;

public class V2TIMFriendGroup {
    private TIMFriendGroup timFriendGroup;

    void setTIMFriendGroup(TIMFriendGroup tIMFriendGroup) {
        this.timFriendGroup = tIMFriendGroup;
    }

    public String getName() {
        TIMFriendGroup tIMFriendGroup = this.timFriendGroup;
        if (tIMFriendGroup != null) {
            return tIMFriendGroup.getName();
        }
        return null;
    }

    public long getFriendCount() {
        TIMFriendGroup tIMFriendGroup = this.timFriendGroup;
        if (tIMFriendGroup != null) {
            return tIMFriendGroup.getUserCnt();
        }
        return 0;
    }

    public List<String> getFriendIDList() {
        TIMFriendGroup tIMFriendGroup = this.timFriendGroup;
        if (tIMFriendGroup != null) {
            return tIMFriendGroup.getFriends();
        }
        return null;
    }
}
