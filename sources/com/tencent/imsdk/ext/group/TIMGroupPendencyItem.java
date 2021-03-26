package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.group.GroupBaseManager;
import java.io.Serializable;

public class TIMGroupPendencyItem implements Serializable {
    private static final String tag = "TIMGroupPendencyItem";
    private long addTime;
    private byte[] auth;
    private String fromUser;
    private String groupId;
    private String handledMsg;
    private TIMGroupPendencyHandledStatus handledStatus;
    private String handledUserData;
    private String identifer;
    private int intHandledStatus;
    private int intOperationType;
    private int intPendencyType;
    private byte[] key;
    private TIMGroupPendencyOperationType operationType;
    private TIMGroupPendencyGetType pendencyType;
    private String requestMsg;
    private String requestUserData;
    private String toUser;

    public String getGroupId() {
        return this.groupId;
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public String getToUser() {
        return this.toUser;
    }

    public long getAddTime() {
        return this.addTime / 1000;
    }

    public TIMGroupPendencyGetType getPendencyType() {
        TIMGroupPendencyGetType[] values = TIMGroupPendencyGetType.values();
        for (TIMGroupPendencyGetType tIMGroupPendencyGetType : values) {
            if (((long) this.intPendencyType) == tIMGroupPendencyGetType.getValue()) {
                this.pendencyType = tIMGroupPendencyGetType;
                return tIMGroupPendencyGetType;
            }
        }
        return TIMGroupPendencyGetType.APPLY_BY_SELF;
    }

    public TIMGroupPendencyHandledStatus getHandledStatus() {
        TIMGroupPendencyHandledStatus[] values = TIMGroupPendencyHandledStatus.values();
        for (TIMGroupPendencyHandledStatus tIMGroupPendencyHandledStatus : values) {
            if (((long) this.intHandledStatus) == tIMGroupPendencyHandledStatus.getValue()) {
                this.handledStatus = tIMGroupPendencyHandledStatus;
                return tIMGroupPendencyHandledStatus;
            }
        }
        return TIMGroupPendencyHandledStatus.NOT_HANDLED;
    }

    public TIMGroupPendencyOperationType getOperationType() {
        TIMGroupPendencyOperationType[] values = TIMGroupPendencyOperationType.values();
        for (TIMGroupPendencyOperationType tIMGroupPendencyOperationType : values) {
            if (((long) this.intOperationType) == tIMGroupPendencyOperationType.getValue()) {
                this.operationType = tIMGroupPendencyOperationType;
                return tIMGroupPendencyOperationType;
            }
        }
        return TIMGroupPendencyOperationType.REFUSE;
    }

    public String getRequestMsg() {
        return this.requestMsg;
    }

    public String getRequestUserData() {
        return this.requestUserData;
    }

    public String getHandledMsg() {
        return this.handledMsg;
    }

    public String getHandledUserData() {
        return this.handledUserData;
    }

    public String getIdentifer() {
        return this.identifer;
    }

    public void setHandledMsg(String str) {
        this.handledMsg = str;
    }

    public byte[] getKey() {
        return this.key;
    }

    public byte[] getAuth() {
        return this.auth;
    }

    public void accept(String str, TIMCallBack tIMCallBack) {
        GroupBaseManager.getInstance().acceptPendency(this, str, tIMCallBack);
    }

    public void refuse(String str, TIMCallBack tIMCallBack) {
        GroupBaseManager.getInstance().refusePendency(this, str, tIMCallBack);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TIMGroupPendencyItem::::::::identifer=");
        stringBuffer.append(this.identifer);
        stringBuffer.append(";groupId=");
        stringBuffer.append(this.groupId);
        stringBuffer.append(";fromUser=");
        stringBuffer.append(this.fromUser);
        stringBuffer.append(";toUser=");
        stringBuffer.append(this.toUser);
        stringBuffer.append(";addTime=");
        stringBuffer.append(this.addTime);
        stringBuffer.append(";pendencyType=");
        stringBuffer.append(this.pendencyType);
        stringBuffer.append(";handledStatus=");
        stringBuffer.append(this.handledStatus);
        stringBuffer.append(";operationType=");
        stringBuffer.append(this.operationType);
        stringBuffer.append(";requestMsg=");
        stringBuffer.append(this.requestMsg);
        stringBuffer.append(";requestUserData=");
        stringBuffer.append(this.requestUserData);
        stringBuffer.append(";handledMsg=");
        stringBuffer.append(this.handledMsg);
        stringBuffer.append(";handledUserData=");
        stringBuffer.append(this.handledUserData);
        return stringBuffer.toString();
    }
}
