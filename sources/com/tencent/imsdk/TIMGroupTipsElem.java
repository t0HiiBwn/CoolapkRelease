package com.tencent.imsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMGroupTipsElem extends TIMElem {
    private static final String TAG = "TIMGroupTipsElem";
    private Map<String, TIMGroupMemberInfo> changedGroupMemberInfo = new HashMap();
    private Map<String, TIMUserProfile> changedUserInfo = new HashMap();
    private String groupId = "";
    private List<TIMGroupTipsElemGroupInfo> groupInfoList = new ArrayList();
    private String groupName = "";
    private List<TIMGroupTipsElemMemberInfo> memberInfoList = new ArrayList();
    private long memberNum = 0;
    private TIMGroupMemberInfo opGroupMemberInfo;
    private String opUser = "";
    private TIMUserProfile opUserInfo;
    private String platform = "";
    private TIMGroupTipsType tipsType = TIMGroupTipsType.Invalid;
    private List<String> userList = new ArrayList();

    public TIMGroupTipsElem() {
        this.type = TIMElemType.GroupTips;
    }

    public String getOpUser() {
        return this.opUser;
    }

    public List<String> getUserList() {
        return this.userList;
    }

    public String getGroupName() {
        return this.groupName;
    }

    void setGroupName(String str) {
        this.groupName = str;
    }

    public TIMGroupTipsType getTipsType() {
        return this.tipsType;
    }

    void setTipsType(long j) {
        TIMGroupTipsType[] values = TIMGroupTipsType.values();
        for (TIMGroupTipsType tIMGroupTipsType : values) {
            if (((long) tIMGroupTipsType.value()) == j) {
                this.tipsType = tIMGroupTipsType;
            }
        }
    }

    void setTipsType(TIMGroupTipsType tIMGroupTipsType) {
        this.tipsType = tIMGroupTipsType;
    }

    public List<TIMGroupTipsElemGroupInfo> getGroupInfoList() {
        return this.groupInfoList;
    }

    public List<TIMGroupTipsElemMemberInfo> getMemberInfoList() {
        return this.memberInfoList;
    }

    public TIMUserProfile getOpUserInfo() {
        return this.opUserInfo;
    }

    void setOpUserInfo(TIMUserProfile tIMUserProfile) {
        this.opUserInfo = tIMUserProfile;
    }

    public TIMGroupMemberInfo getOpGroupMemberInfo() {
        return this.opGroupMemberInfo;
    }

    void setOpGroupMemberInfo(TIMGroupMemberInfo tIMGroupMemberInfo) {
        this.opGroupMemberInfo = tIMGroupMemberInfo;
    }

    public Map<String, TIMUserProfile> getChangedUserInfo() {
        return this.changedUserInfo;
    }

    public Map<String, TIMGroupMemberInfo> getChangedGroupMemberInfo() {
        return this.changedGroupMemberInfo;
    }

    public String getGroupId() {
        return this.groupId;
    }

    void setGroupId(String str) {
        this.groupId = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    void setPlatform(String str) {
        this.platform = str;
    }

    public long getMemberNum() {
        return this.memberNum;
    }

    void addUser(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.userList.add(str);
        }
    }

    void addGroupInfo(TIMGroupTipsElemGroupInfo tIMGroupTipsElemGroupInfo) {
        if (tIMGroupTipsElemGroupInfo != null) {
            this.groupInfoList.add(tIMGroupTipsElemGroupInfo);
        }
    }

    void addMemberInfo(TIMGroupTipsElemMemberInfo tIMGroupTipsElemMemberInfo) {
        if (tIMGroupTipsElemMemberInfo != null) {
            this.memberInfoList.add(tIMGroupTipsElemMemberInfo);
        }
    }

    void addChangedUserInfo(String str, TIMUserProfile tIMUserProfile) {
        if (!TextUtils.isEmpty(str) && tIMUserProfile != null) {
            this.changedUserInfo.put(str, tIMUserProfile);
        }
    }

    void addChangedGroupMemberInfo(String str, TIMGroupMemberInfo tIMGroupMemberInfo) {
        if (!TextUtils.isEmpty(str) && tIMGroupMemberInfo != null) {
            this.changedGroupMemberInfo.put(str, tIMGroupMemberInfo);
        }
    }
}
