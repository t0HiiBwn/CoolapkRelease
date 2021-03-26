package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.ext.group.TIMGroupAVMemberInfo;
import com.tencent.imsdk.friendship.TIMFriend;

public class V2TIMGroupMemberInfo {
    private String faceUrl = "";
    private String friendRemark = "";
    private String nameCard = "";
    private String nickName = "";
    TIMGroupAVMemberInfo timGroupAVMemberInfo;
    TIMGroupMemberInfo timGroupMemberInfo;
    TIMUserProfile timUserProfile;
    private String userID = "";

    void setTimGroupMemberInfo(TIMGroupMemberInfo tIMGroupMemberInfo) {
        this.timGroupMemberInfo = tIMGroupMemberInfo;
    }

    void setTimGroupAVMemberInfo(TIMGroupAVMemberInfo tIMGroupAVMemberInfo) {
        this.timGroupAVMemberInfo = tIMGroupAVMemberInfo;
    }

    void setTimUserProfile(TIMUserProfile tIMUserProfile) {
        this.timUserProfile = tIMUserProfile;
    }

    TIMUserProfile getTimUserProfile() {
        return this.timUserProfile;
    }

    public String getUserID() {
        if (!TextUtils.isEmpty(this.userID)) {
            return this.userID;
        }
        TIMGroupMemberInfo tIMGroupMemberInfo = this.timGroupMemberInfo;
        if (tIMGroupMemberInfo != null) {
            return tIMGroupMemberInfo.getUser();
        }
        TIMGroupAVMemberInfo tIMGroupAVMemberInfo = this.timGroupAVMemberInfo;
        if (tIMGroupAVMemberInfo != null) {
            return tIMGroupAVMemberInfo.getUserID();
        }
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getIdentifier();
        }
        return null;
    }

    public String getNickName() {
        if (!TextUtils.isEmpty(this.nickName)) {
            return this.nickName;
        }
        TIMGroupAVMemberInfo tIMGroupAVMemberInfo = this.timGroupAVMemberInfo;
        if (tIMGroupAVMemberInfo != null) {
            return tIMGroupAVMemberInfo.getNickName();
        }
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getNickName();
        }
        return null;
    }

    public String getNameCard() {
        if (!TextUtils.isEmpty(this.nameCard)) {
            return this.nameCard;
        }
        TIMGroupMemberInfo tIMGroupMemberInfo = this.timGroupMemberInfo;
        if (tIMGroupMemberInfo != null) {
            return tIMGroupMemberInfo.getNameCard();
        }
        return null;
    }

    public String getFriendRemark() {
        TIMFriend queryFriend;
        String userID2 = getUserID();
        if (TextUtils.isEmpty(userID2) || (queryFriend = TIMFriendshipManager.getInstance().queryFriend(userID2)) == null) {
            return null;
        }
        String remark = queryFriend.getRemark();
        if (TextUtils.isEmpty(remark)) {
            return null;
        }
        return remark;
    }

    public String getFaceUrl() {
        if (!TextUtils.isEmpty(this.faceUrl)) {
            return this.faceUrl;
        }
        TIMGroupAVMemberInfo tIMGroupAVMemberInfo = this.timGroupAVMemberInfo;
        if (tIMGroupAVMemberInfo != null) {
            return tIMGroupAVMemberInfo.getFaceUrl();
        }
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getFaceUrl();
        }
        return null;
    }

    protected void setMsgSenderUserID(String str) {
        this.userID = str;
    }

    protected void setMsgSenderNickName(String str) {
        this.nickName = str;
    }

    protected void setMsgSenderNameCard(String str) {
        this.nameCard = str;
    }

    protected void setMsgSenderFaceUrl(String str) {
        this.faceUrl = str;
    }

    public String toString() {
        return "V2TIMGroupMemberInfo--->userID:" + getUserID() + ", nickName:" + getNickName() + ", nameCard:" + getNameCard() + ", friendRemark:" + getFriendRemark() + ", faceUrl:" + getFaceUrl();
    }
}
