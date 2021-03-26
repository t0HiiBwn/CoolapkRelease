package com.tencent.imsdk;

public class TIMGroupSystemElem extends TIMElem {
    private byte[] authKey;
    private String groupId = "";
    private long msgKey;
    private TIMGroupMemberInfo opGroupMemberInfo;
    private String opReason = "";
    private String opUser = "";
    private TIMUserProfile opUserInfo;
    private String platform = "";
    private long subtype;
    private byte[] userData = null;

    public TIMGroupSystemElem() {
        this.type = TIMElemType.GroupSystem;
    }

    public String getPlatform() {
        return this.platform;
    }

    void setPlatform(String str) {
        this.platform = str;
    }

    public TIMGroupSystemElemType getSubtype() {
        TIMGroupSystemElemType[] values = TIMGroupSystemElemType.values();
        for (TIMGroupSystemElemType tIMGroupSystemElemType : values) {
            if (this.subtype == tIMGroupSystemElemType.getValue()) {
                return tIMGroupSystemElemType;
            }
        }
        return TIMGroupSystemElemType.INVALID;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getOpUser() {
        return this.opUser;
    }

    public String getOpReason() {
        return this.opReason;
    }

    public byte[] getUserData() {
        return this.userData;
    }

    public TIMUserProfile getOpUserInfo() {
        return this.opUserInfo;
    }

    public TIMGroupMemberInfo getOpGroupMemberInfo() {
        return this.opGroupMemberInfo;
    }
}
