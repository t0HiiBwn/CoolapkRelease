package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMGroupAddOpt;
import com.tencent.imsdk.TIMGroupReceiveMessageOpt;
import com.tencent.imsdk.TIMMessage;
import java.util.HashMap;
import java.util.Map;

public class TIMGroupDetailInfo {
    private static final String tag = "TIMGroupDetailInfo";
    private TIMGroupAddOpt addOption;
    private long createTime = 0;
    private Map<String, byte[]> custom = new HashMap();
    private String groupFaceUrl = "";
    private String groupId = "";
    private String groupIntroduction = "";
    private String groupName = "";
    private String groupNotice = "";
    private String groupOwner = "";
    private String groupType = "";
    private int intAddOption;
    private boolean isSilenceAll = false;
    private long joinTime = 0;
    private long lastInfoTime = 0;
    private TIMMessage lastMsg = null;
    private long lastMsgTime = 0;
    private long maxMemberNum = 0;
    private long memberNum = 0;
    private long onlineMemberNum = 0;
    private int recvOpt = 0;
    private int role = 0;
    private int unReadMessageNum = 0;

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupOwner() {
        return this.groupOwner;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getLastInfoTime() {
        return this.lastInfoTime;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public long getMemberNum() {
        return this.memberNum;
    }

    public long getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public String getGroupIntroduction() {
        return this.groupIntroduction;
    }

    public String getGroupNotification() {
        return this.groupNotice;
    }

    public String getFaceUrl() {
        return this.groupFaceUrl;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public TIMMessage getLastMsg() {
        return this.lastMsg;
    }

    public Map<String, byte[]> getCustom() {
        return this.custom;
    }

    public long getOnlineMemberNum() {
        return this.onlineMemberNum;
    }

    public boolean isSilenceAll() {
        return this.isSilenceAll;
    }

    public TIMGroupAddOpt getAddOption() {
        TIMGroupAddOpt tIMGroupAddOpt = TIMGroupAddOpt.values()[this.intAddOption];
        this.addOption = tIMGroupAddOpt;
        return tIMGroupAddOpt;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public int getRole() {
        return this.role;
    }

    public TIMGroupReceiveMessageOpt getRecvOpt() {
        if (((long) this.recvOpt) == TIMGroupReceiveMessageOpt.ReceiveAndNotify.getValue()) {
            return TIMGroupReceiveMessageOpt.ReceiveAndNotify;
        }
        if (((long) this.recvOpt) == TIMGroupReceiveMessageOpt.NotReceive.getValue()) {
            return TIMGroupReceiveMessageOpt.NotReceive;
        }
        if (((long) this.recvOpt) == TIMGroupReceiveMessageOpt.ReceiveNotNotify.getValue()) {
            return TIMGroupReceiveMessageOpt.ReceiveNotNotify;
        }
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TIMGroupDetailInfo::::::::groupType=");
        stringBuffer.append(this.groupType);
        stringBuffer.append(";groupId=");
        stringBuffer.append(this.groupId);
        stringBuffer.append(";groupName=");
        stringBuffer.append(this.groupName);
        stringBuffer.append(";groupNotice=");
        stringBuffer.append(this.groupNotice);
        stringBuffer.append(";groupOwner=");
        stringBuffer.append(this.groupOwner);
        stringBuffer.append(";groupFaceUrl=");
        stringBuffer.append(this.groupFaceUrl);
        stringBuffer.append(";notification=");
        stringBuffer.append(this.groupNotice);
        stringBuffer.append(";introduction=");
        stringBuffer.append(this.groupIntroduction);
        stringBuffer.append(";createTime=");
        stringBuffer.append(this.createTime);
        stringBuffer.append(";lastInfoTime=");
        stringBuffer.append(this.lastInfoTime);
        stringBuffer.append(";lastMsgTime=");
        stringBuffer.append(this.lastMsgTime);
        stringBuffer.append(";memberNum=");
        stringBuffer.append(this.memberNum);
        stringBuffer.append(";maxMemberNum=");
        stringBuffer.append(this.maxMemberNum);
        stringBuffer.append(";onlineMemberNum=");
        stringBuffer.append(this.onlineMemberNum);
        stringBuffer.append(";addOpt=");
        stringBuffer.append(this.intAddOption);
        stringBuffer.append(";isSilenceAll=");
        stringBuffer.append(this.isSilenceAll);
        stringBuffer.append(";joinTime=");
        stringBuffer.append(this.joinTime);
        stringBuffer.append(";role=");
        stringBuffer.append(this.role);
        stringBuffer.append(";unreadMsgNum=");
        stringBuffer.append(this.unReadMessageNum);
        stringBuffer.append(";recvOpt=");
        stringBuffer.append(this.recvOpt);
        return stringBuffer.toString();
    }
}
