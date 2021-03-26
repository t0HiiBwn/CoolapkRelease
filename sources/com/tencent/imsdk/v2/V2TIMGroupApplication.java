package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.ext.group.TIMGroupPendencyGetType;
import com.tencent.imsdk.ext.group.TIMGroupPendencyHandledStatus;
import com.tencent.imsdk.ext.group.TIMGroupPendencyItem;
import com.tencent.imsdk.ext.group.TIMGroupPendencyOperationType;
import java.io.Serializable;

public class V2TIMGroupApplication implements Serializable {
    public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_INVITE = 1;
    public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_JOIN = 0;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_AGREE = 1;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_REFUSE = 0;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_OTHER = 1;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_SELF = 2;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_UNHANDLED = 0;
    private TIMGroupPendencyItem timGroupPendencyItem;
    private TIMUserProfile timUserProfile;

    public String getGroupID() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem != null) {
            return tIMGroupPendencyItem.getGroupId();
        }
        return null;
    }

    public String getFromUser() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem != null) {
            return tIMGroupPendencyItem.getFromUser();
        }
        return null;
    }

    public String getFromUserNickName() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getNickName();
        }
        return null;
    }

    public String getFromUserFaceUrl() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getFaceUrl();
        }
        return null;
    }

    public String getToUser() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem != null) {
            return tIMGroupPendencyItem.getToUser();
        }
        return null;
    }

    public long getAddTime() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem != null) {
            return tIMGroupPendencyItem.getAddTime();
        }
        return 0;
    }

    public String getRequestMsg() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem != null) {
            return tIMGroupPendencyItem.getRequestMsg();
        }
        return null;
    }

    public String getHandledMsg() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem != null) {
            return tIMGroupPendencyItem.getHandledMsg();
        }
        return null;
    }

    public int getType() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem == null) {
            return 0;
        }
        TIMGroupPendencyGetType pendencyType = tIMGroupPendencyItem.getPendencyType();
        if (pendencyType.getValue() != TIMGroupPendencyGetType.APPLY_BY_SELF.getValue() && pendencyType.getValue() == TIMGroupPendencyGetType.INVITED_BY_OTHER.getValue()) {
            return 1;
        }
        return 0;
    }

    public int getHandleStatus() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem == null) {
            return 0;
        }
        TIMGroupPendencyHandledStatus handledStatus = tIMGroupPendencyItem.getHandledStatus();
        if (handledStatus.getValue() == TIMGroupPendencyHandledStatus.HANDLED_BY_OTHER.getValue()) {
            return 1;
        }
        if (handledStatus.getValue() == TIMGroupPendencyHandledStatus.HANDLED_BY_SELF.getValue()) {
            return 2;
        }
        return 0;
    }

    public int getHandleResult() {
        TIMGroupPendencyItem tIMGroupPendencyItem = this.timGroupPendencyItem;
        if (tIMGroupPendencyItem == null || tIMGroupPendencyItem.getOperationType().getValue() != TIMGroupPendencyOperationType.REFUSE.getValue()) {
            return 1;
        }
        return 0;
    }

    void setTIMGroupPendencyItem(TIMGroupPendencyItem tIMGroupPendencyItem) {
        this.timGroupPendencyItem = tIMGroupPendencyItem;
    }

    TIMGroupPendencyItem getTIMGroupPendencyItem() {
        return this.timGroupPendencyItem;
    }

    void setTIMUserProfile(TIMUserProfile tIMUserProfile) {
        this.timUserProfile = tIMUserProfile;
    }
}
