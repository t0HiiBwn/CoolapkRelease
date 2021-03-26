package com.tencent.imsdk.v2;

import com.tencent.imsdk.friendship.TIMFriend;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V2TIMFriendInfo {
    private static final String FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_SNS_Custom_";
    private static final String FRIEND_PROFILE_TYPE_KEY_REMARK = "Tag_SNS_IM_Remark";
    public static final int V2TIM_FRIEND_TYPE_BOTH = 2;
    public static final int V2TIM_FRIEND_TYPE_SINGLE = 1;
    private HashMap<String, Object> modifyFriendProfileHashMap;
    private String modifyUserID;
    private TIMFriend timFriend;
    private V2TIMUserFullInfo v2TIMUserFullInfo;

    void setTIMFriend(TIMFriend tIMFriend) {
        this.timFriend = tIMFriend;
        V2TIMUserFullInfo v2TIMUserFullInfo2 = new V2TIMUserFullInfo();
        this.v2TIMUserFullInfo = v2TIMUserFullInfo2;
        v2TIMUserFullInfo2.setTIMUserProfile(tIMFriend.getTimUserProfile());
    }

    void setV2TIMUserFullInfo(V2TIMUserFullInfo v2TIMUserFullInfo2) {
        this.v2TIMUserFullInfo = v2TIMUserFullInfo2;
    }

    public String getUserID() {
        TIMFriend tIMFriend = this.timFriend;
        return tIMFriend != null ? tIMFriend.getIdentifier() : "";
    }

    public void setUserID(String str) {
        this.modifyUserID = str;
    }

    public String getFriendRemark() {
        TIMFriend tIMFriend = this.timFriend;
        return tIMFriend != null ? tIMFriend.getRemark() : "";
    }

    public void setFriendRemark(String str) {
        if (this.modifyFriendProfileHashMap == null) {
            this.modifyFriendProfileHashMap = new HashMap<>();
        }
        this.modifyFriendProfileHashMap.put("Tag_SNS_IM_Remark", str);
    }

    public List<String> getFriendGroups() {
        TIMFriend tIMFriend = this.timFriend;
        if (tIMFriend != null) {
            return tIMFriend.getGroupNames();
        }
        return null;
    }

    public HashMap<String, byte[]> getFriendCustomInfo() {
        TIMFriend tIMFriend = this.timFriend;
        if (tIMFriend != null) {
            return (HashMap) tIMFriend.getCustomInfo();
        }
        return null;
    }

    public void setFriendCustomInfo(HashMap<String, byte[]> hashMap) {
        if (!(hashMap == null || hashMap.size() == 0)) {
            if (this.modifyFriendProfileHashMap == null) {
                this.modifyFriendProfileHashMap = new HashMap<>();
            }
            if (hashMap.entrySet() != null) {
                for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                    if (entry.getKey().contains("Tag_SNS_Custom_")) {
                        this.modifyFriendProfileHashMap.put(entry.getKey(), new String(entry.getValue()));
                    } else {
                        HashMap<String, Object> hashMap2 = this.modifyFriendProfileHashMap;
                        hashMap2.put("Tag_SNS_Custom_" + entry.getKey(), new String(entry.getValue()));
                    }
                }
            }
        }
    }

    public V2TIMUserFullInfo getUserProfile() {
        return this.v2TIMUserFullInfo;
    }

    String getModifyUserID() {
        return this.modifyUserID;
    }

    HashMap<String, Object> getModifyFriendInfo() {
        return this.modifyFriendProfileHashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMFriendProfile--->");
        HashMap<String, byte[]> friendCustomInfo = getFriendCustomInfo();
        StringBuilder sb2 = new StringBuilder();
        if (friendCustomInfo != null) {
            sb2.append("\n");
            for (Map.Entry<String, byte[]> entry : friendCustomInfo.entrySet()) {
                sb2.append(" |key:" + entry.getKey() + ", value:" + new String(entry.getValue()));
                sb2.append("\n");
            }
        }
        sb.append("userID:");
        sb.append(getUserID());
        sb.append(", remark:");
        sb.append(getFriendRemark());
        sb.append(", groupNames:");
        sb.append(getFriendGroups());
        sb.append(", friendCustomInfo:");
        sb.append(sb2.toString());
        sb.append(", userProfile:");
        V2TIMUserFullInfo v2TIMUserFullInfo2 = this.v2TIMUserFullInfo;
        sb.append(v2TIMUserFullInfo2 == null ? "" : v2TIMUserFullInfo2.toString());
        return sb.toString();
    }
}
