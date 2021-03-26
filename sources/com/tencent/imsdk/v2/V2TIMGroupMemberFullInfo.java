package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMGroupManager;
import java.util.Map;

public class V2TIMGroupMemberFullInfo extends V2TIMGroupMemberInfo {
    public static final int V2TIM_GROUP_MEMBER_FILTER_ADMIN = 2;
    public static final int V2TIM_GROUP_MEMBER_FILTER_ALL = 0;
    public static final int V2TIM_GROUP_MEMBER_FILTER_COMMON = 4;
    public static final int V2TIM_GROUP_MEMBER_FILTER_OWNER = 1;
    public static final int V2TIM_GROUP_MEMBER_ROLE_ADMIN = 300;
    public static final int V2TIM_GROUP_MEMBER_ROLE_MEMBER = 200;
    public static final int V2TIM_GROUP_MEMBER_ROLE_OWNER = 400;
    public static final int V2TIM_GROUP_MEMBER_UNDEFINED = 0;
    private final String TAG = "V2TIMGroupMemberFullInfo";
    private TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam;

    TIMGroupManager.ModifyMemberInfoParam getModifyMemberInfoParam() {
        return this.modifyMemberInfoParam;
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupMemberInfo
    public String getUserID() {
        TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam2 = this.modifyMemberInfoParam;
        if (modifyMemberInfoParam2 != null) {
            return modifyMemberInfoParam2.getIdentifier();
        }
        if (this.timGroupMemberInfo != null) {
            return this.timGroupMemberInfo.getUser();
        }
        if (this.timGroupAVMemberInfo != null) {
            return this.timGroupAVMemberInfo.getUserID();
        }
        return null;
    }

    public void setUserID(String str) {
        if (this.modifyMemberInfoParam == null) {
            this.modifyMemberInfoParam = new TIMGroupManager.ModifyMemberInfoParam("", "");
        }
        this.modifyMemberInfoParam.setUserID(str);
    }

    public void setNameCard(String str) {
        if (this.modifyMemberInfoParam == null) {
            this.modifyMemberInfoParam = new TIMGroupManager.ModifyMemberInfoParam("", "");
        }
        this.modifyMemberInfoParam.setNameCard(str);
    }

    public int getRole() {
        TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam2 = this.modifyMemberInfoParam;
        if (modifyMemberInfoParam2 != null) {
            return modifyMemberInfoParam2.getRoleType();
        }
        if (this.timGroupMemberInfo != null) {
            return this.timGroupMemberInfo.getRole();
        }
        if (this.timGroupAVMemberInfo != null) {
            return this.timGroupAVMemberInfo.getRole();
        }
        return 0;
    }

    public long getMuteUntil() {
        if (this.timGroupMemberInfo != null) {
            return this.timGroupMemberInfo.getSilenceSeconds();
        }
        return 0;
    }

    public long getJoinTime() {
        if (this.timGroupMemberInfo != null) {
            return this.timGroupMemberInfo.getJoinTime();
        }
        return 0;
    }

    public Map<String, byte[]> getCustomInfo() {
        TIMGroupManager.ModifyMemberInfoParam modifyMemberInfoParam2 = this.modifyMemberInfoParam;
        if (modifyMemberInfoParam2 != null) {
            return modifyMemberInfoParam2.getCustomInfo();
        }
        if (this.timGroupMemberInfo != null) {
            return this.timGroupMemberInfo.getCustomInfo();
        }
        return null;
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        if (this.modifyMemberInfoParam == null) {
            this.modifyMemberInfoParam = new TIMGroupManager.ModifyMemberInfoParam("", "");
        }
        this.modifyMemberInfoParam.setCustomInfo(map);
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupMemberInfo
    public String toString() {
        Map<String, byte[]> customInfo = getCustomInfo();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        if (customInfo.entrySet() != null) {
            for (Map.Entry<String, byte[]> entry : customInfo.entrySet()) {
                sb.append(" |key:" + entry.getKey() + ", value:" + new String(entry.getValue()));
                sb.append("\n");
            }
        }
        return "V2TIMGroupMemberProfile--->userID:" + getUserID() + ", nickName:" + getNickName() + ", nameCard:" + getNameCard() + ", friendRemark:" + getFriendRemark() + ", faceUrl:" + getFaceUrl() + ", role:" + getRole() + ", muteUtil:" + getMuteUntil() + ", joinTime:" + getJoinTime() + ", customInfo:" + sb.toString();
    }
}
