package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMGroupTipsElemGroupInfo;
import com.tencent.imsdk.TIMGroupTipsGroupInfoType;

public class V2TIMGroupChangeInfo {
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_CUSTOM = 6;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_FACE_URL = 4;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_INTRODUCTION = 2;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_NAME = 1;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_NOTIFICATION = 3;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_OWNER = 5;
    public static final int V2TIM_GROUP_INFO_INVALID = 0;
    private TIMGroupTipsElemGroupInfo timGroupTipsElemGroupInfo;

    void setTIMGroupTipsElemGroupInfo(TIMGroupTipsElemGroupInfo tIMGroupTipsElemGroupInfo) {
        this.timGroupTipsElemGroupInfo = tIMGroupTipsElemGroupInfo;
    }

    public int getType() {
        TIMGroupTipsElemGroupInfo tIMGroupTipsElemGroupInfo = this.timGroupTipsElemGroupInfo;
        if (tIMGroupTipsElemGroupInfo == null) {
            return 0;
        }
        TIMGroupTipsGroupInfoType type = tIMGroupTipsElemGroupInfo.getType();
        if (type.value() == TIMGroupTipsGroupInfoType.Invalid.value()) {
            return 0;
        }
        if (type.value() == TIMGroupTipsGroupInfoType.ModifyName.value()) {
            return 1;
        }
        if (type.value() == TIMGroupTipsGroupInfoType.ModifyIntroduction.value()) {
            return 2;
        }
        if (type.value() == TIMGroupTipsGroupInfoType.ModifyNotification.value()) {
            return 3;
        }
        if (type.value() == TIMGroupTipsGroupInfoType.ModifyFaceUrl.value()) {
            return 4;
        }
        if (type.value() == TIMGroupTipsGroupInfoType.ModifyOwner.value()) {
            return 5;
        }
        if (type.value() == TIMGroupTipsGroupInfoType.ModifyCustom.value()) {
            return 6;
        }
        return 0;
    }

    public String getValue() {
        TIMGroupTipsElemGroupInfo tIMGroupTipsElemGroupInfo = this.timGroupTipsElemGroupInfo;
        if (tIMGroupTipsElemGroupInfo != null) {
            return tIMGroupTipsElemGroupInfo.getContent();
        }
        return null;
    }

    public String getKey() {
        TIMGroupTipsElemGroupInfo tIMGroupTipsElemGroupInfo = this.timGroupTipsElemGroupInfo;
        if (tIMGroupTipsElemGroupInfo != null) {
            return tIMGroupTipsElemGroupInfo.getKey();
        }
        return null;
    }
}
