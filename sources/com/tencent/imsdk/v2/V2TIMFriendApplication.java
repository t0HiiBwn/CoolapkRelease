package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.friendship.TIMFriendPendencyInfo;
import com.tencent.imsdk.friendship.TIMFriendPendencyItem;
import java.io.Serializable;

public class V2TIMFriendApplication implements Serializable {
    public static final int V2TIM_FRIEND_ACCEPT_AGREE = 0;
    public static final int V2TIM_FRIEND_ACCEPT_AGREE_AND_ADD = 1;
    public static final int V2TIM_FRIEND_APPLICATION_BOTH = 3;
    public static final int V2TIM_FRIEND_APPLICATION_COME_IN = 1;
    public static final int V2TIM_FRIEND_APPLICATION_SEND_OUT = 2;
    private TIMFriendPendencyInfo timFriendPendencyInfo;
    private TIMFriendPendencyItem timFriendPendencyItem;
    private TIMUserProfile timUserProfile;
    private int type = 3;
    private String userID;

    void setTIMFriendPendencyItem(TIMFriendPendencyItem tIMFriendPendencyItem) {
        this.timFriendPendencyItem = tIMFriendPendencyItem;
    }

    void setTIMFriendPendencyInfo(TIMFriendPendencyInfo tIMFriendPendencyInfo) {
        this.timFriendPendencyInfo = tIMFriendPendencyInfo;
    }

    void setTIMUserProfile(TIMUserProfile tIMUserProfile) {
        this.timUserProfile = tIMUserProfile;
    }

    public String getUserID() {
        TIMFriendPendencyItem tIMFriendPendencyItem = this.timFriendPendencyItem;
        if (tIMFriendPendencyItem != null) {
            return tIMFriendPendencyItem.getIdentifier();
        }
        TIMFriendPendencyInfo tIMFriendPendencyInfo = this.timFriendPendencyInfo;
        if (tIMFriendPendencyInfo != null) {
            return tIMFriendPendencyInfo.getFromUser();
        }
        return null;
    }

    public String getNickname() {
        TIMFriendPendencyItem tIMFriendPendencyItem = this.timFriendPendencyItem;
        if (tIMFriendPendencyItem != null) {
            return tIMFriendPendencyItem.getNickname();
        }
        TIMFriendPendencyInfo tIMFriendPendencyInfo = this.timFriendPendencyInfo;
        if (tIMFriendPendencyInfo != null) {
            return tIMFriendPendencyInfo.getFromUserNickName();
        }
        return null;
    }

    public String getFaceUrl() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getFaceUrl();
        }
        return null;
    }

    public long getAddTime() {
        TIMFriendPendencyItem tIMFriendPendencyItem = this.timFriendPendencyItem;
        if (tIMFriendPendencyItem != null) {
            return tIMFriendPendencyItem.getAddTime();
        }
        return 0;
    }

    public String getAddSource() {
        TIMFriendPendencyItem tIMFriendPendencyItem = this.timFriendPendencyItem;
        if (tIMFriendPendencyItem != null) {
            return tIMFriendPendencyItem.getAddSource();
        }
        TIMFriendPendencyInfo tIMFriendPendencyInfo = this.timFriendPendencyInfo;
        if (tIMFriendPendencyInfo != null) {
            return tIMFriendPendencyInfo.getAddSource();
        }
        return null;
    }

    public String getAddWording() {
        TIMFriendPendencyItem tIMFriendPendencyItem = this.timFriendPendencyItem;
        if (tIMFriendPendencyItem != null) {
            return tIMFriendPendencyItem.getAddWording();
        }
        TIMFriendPendencyInfo tIMFriendPendencyInfo = this.timFriendPendencyInfo;
        if (tIMFriendPendencyInfo != null) {
            return tIMFriendPendencyInfo.getAddWording();
        }
        return null;
    }

    public int getType() {
        TIMFriendPendencyItem tIMFriendPendencyItem = this.timFriendPendencyItem;
        if (tIMFriendPendencyItem != null) {
            return tIMFriendPendencyItem.getType();
        }
        TIMFriendPendencyInfo tIMFriendPendencyInfo = this.timFriendPendencyInfo;
        if (tIMFriendPendencyInfo != null) {
            return tIMFriendPendencyInfo.isBySelf() ? 2 : 1;
        }
        return 3;
    }

    @Override // java.lang.Object
    public String toString() {
        return "V2TIMFriendApplication--->userID:" + getUserID() + ", nickName:" + getNickname() + ", faceUrl:" + getFaceUrl() + ", addSource:" + getAddSource() + ", addWording:" + getAddWording() + ", addTime:" + getAddTime() + ", type:" + getType();
    }
}
