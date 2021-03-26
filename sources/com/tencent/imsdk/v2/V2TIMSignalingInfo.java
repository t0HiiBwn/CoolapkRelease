package com.tencent.imsdk.v2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class V2TIMSignalingInfo {
    public static final int SIGNALING_ACTION_TYPE_ACCEPT_INVITE = 3;
    public static final int SIGNALING_ACTION_TYPE_CANCEL_INVITE = 2;
    public static final int SIGNALING_ACTION_TYPE_INVITE = 1;
    public static final int SIGNALING_ACTION_TYPE_INVITE_TIMEOUT = 5;
    public static final int SIGNALING_ACTION_TYPE_REJECT_INVITE = 4;
    private int actionType;
    private int businessID = 0;
    private String data;
    private String groupID;
    private String inviteID;
    private List<String> inviteeList = new ArrayList();
    private String inviter;
    private V2TIMOfflinePushInfo offlinePushInfo;
    private boolean onlineUserOnly;
    private int timeout;

    public String getInviteID() {
        return this.inviteID;
    }

    public void setInviteID(String str) {
        this.inviteID = str;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public String getInviter() {
        return this.inviter;
    }

    public void setInviter(String str) {
        this.inviter = str;
    }

    public List<String> getInviteeList() {
        return this.inviteeList;
    }

    public void setInviteeList(List<String> list) {
        this.inviteeList = list;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public int getActionType() {
        return this.actionType;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    void addInvitee(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.inviteeList.add(str);
        }
    }

    public int getBusinessID() {
        return this.businessID;
    }

    public void setBusinessID(int i) {
        this.businessID = i;
    }

    public boolean isOnlineUserOnly() {
        return this.onlineUserOnly;
    }

    protected void setOnlineUserOnly(boolean z) {
        this.onlineUserOnly = z;
    }

    public V2TIMOfflinePushInfo getOfflinePushInfo() {
        return this.offlinePushInfo;
    }

    protected void setOfflinePushInfo(V2TIMOfflinePushInfo v2TIMOfflinePushInfo) {
        this.offlinePushInfo = v2TIMOfflinePushInfo;
    }
}
