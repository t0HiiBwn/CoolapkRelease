package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupTipsElem;
import com.tencent.imsdk.TIMGroupTipsElemGroupInfo;
import com.tencent.imsdk.TIMGroupTipsElemMemberInfo;
import com.tencent.imsdk.TIMGroupTipsType;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class V2TIMGroupTipsElem extends V2TIMElem {
    public static final int GROUP_TIPS_TYPE_INVALID = 0;
    public static final int V2TIM_GROUP_TIPS_TYPE_CANCEL_ADMIN = 6;
    public static final int V2TIM_GROUP_TIPS_TYPE_GROUP_INFO_CHANGE = 7;
    public static final int V2TIM_GROUP_TIPS_TYPE_INVITE = 2;
    public static final int V2TIM_GROUP_TIPS_TYPE_JOIN = 1;
    public static final int V2TIM_GROUP_TIPS_TYPE_KICKED = 4;
    public static final int V2TIM_GROUP_TIPS_TYPE_MEMBER_INFO_CHANGE = 8;
    public static final int V2TIM_GROUP_TIPS_TYPE_QUIT = 3;
    public static final int V2TIM_GROUP_TIPS_TYPE_SET_ADMIN = 5;

    public String getGroupID() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMGroupTipsElem) getTIMElem()).getGroupId();
    }

    public int getType() {
        TIMGroupTipsElem tIMGroupTipsElem = (TIMGroupTipsElem) getTIMElem();
        if (tIMGroupTipsElem == null) {
            return 0;
        }
        int value = tIMGroupTipsElem.getTipsType().value();
        if (value == TIMGroupTipsType.Join.value()) {
            TIMGroupDetailInfo queryGroupInfo = TIMGroupManager.getInstance().queryGroupInfo(tIMGroupTipsElem.getGroupId());
            return (queryGroupInfo == null || !queryGroupInfo.getGroupType().equals("Private")) ? 1 : 2;
        } else if (value == TIMGroupTipsType.Quit.value()) {
            return 3;
        } else {
            if (value == TIMGroupTipsType.Kick.value()) {
                return 4;
            }
            if (value == TIMGroupTipsType.SetAdmin.value()) {
                return 5;
            }
            if (value == TIMGroupTipsType.CancelAdmin.value()) {
                return 6;
            }
            if (value == TIMGroupTipsType.ModifyGroupInfo.value()) {
                return 7;
            }
            if (value == TIMGroupTipsType.ModifyMemberInfo.value()) {
                return 8;
            }
            return 0;
        }
    }

    public V2TIMGroupMemberInfo getOpMember() {
        TIMGroupTipsElem tIMGroupTipsElem;
        if (getTIMElem() == null || (tIMGroupTipsElem = (TIMGroupTipsElem) getTIMElem()) == null) {
            return null;
        }
        V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
        v2TIMGroupMemberInfo.setTimUserProfile(tIMGroupTipsElem.getOpUserInfo());
        v2TIMGroupMemberInfo.setTimGroupMemberInfo(tIMGroupTipsElem.getOpGroupMemberInfo());
        return v2TIMGroupMemberInfo;
    }

    public List<V2TIMGroupMemberInfo> getMemberList() {
        if (getTIMElem() == null) {
            return null;
        }
        TIMGroupTipsElem tIMGroupTipsElem = (TIMGroupTipsElem) getTIMElem();
        List<String> userList = tIMGroupTipsElem.getUserList();
        Map<String, TIMUserProfile> changedUserInfo = tIMGroupTipsElem.getChangedUserInfo();
        Map<String, TIMGroupMemberInfo> changedGroupMemberInfo = tIMGroupTipsElem.getChangedGroupMemberInfo();
        ArrayList arrayList = new ArrayList();
        for (String str : userList) {
            V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
            TIMUserProfile tIMUserProfile = changedUserInfo.get(str);
            TIMGroupMemberInfo tIMGroupMemberInfo = changedGroupMemberInfo.get(str);
            if (tIMUserProfile != null) {
                v2TIMGroupMemberInfo.setTimUserProfile(tIMUserProfile);
            }
            if (tIMGroupMemberInfo != null) {
                v2TIMGroupMemberInfo.setTimGroupMemberInfo(tIMGroupMemberInfo);
            }
            arrayList.add(v2TIMGroupMemberInfo);
        }
        return arrayList;
    }

    public List<V2TIMGroupChangeInfo> getGroupChangeInfoList() {
        if (getTIMElem() == null) {
            return null;
        }
        List<TIMGroupTipsElemGroupInfo> groupInfoList = ((TIMGroupTipsElem) getTIMElem()).getGroupInfoList();
        ArrayList arrayList = new ArrayList();
        for (TIMGroupTipsElemGroupInfo tIMGroupTipsElemGroupInfo : groupInfoList) {
            V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
            v2TIMGroupChangeInfo.setTIMGroupTipsElemGroupInfo(tIMGroupTipsElemGroupInfo);
            arrayList.add(v2TIMGroupChangeInfo);
        }
        return arrayList;
    }

    public List<V2TIMGroupMemberChangeInfo> getMemberChangeInfoList() {
        if (getTIMElem() == null) {
            return null;
        }
        List<TIMGroupTipsElemMemberInfo> memberInfoList = ((TIMGroupTipsElem) getTIMElem()).getMemberInfoList();
        ArrayList arrayList = new ArrayList();
        for (TIMGroupTipsElemMemberInfo tIMGroupTipsElemMemberInfo : memberInfoList) {
            V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
            v2TIMGroupMemberChangeInfo.setTIMGroupTipsElemMemberInfo(tIMGroupTipsElemMemberInfo);
            arrayList.add(v2TIMGroupMemberChangeInfo);
        }
        return arrayList;
    }

    public int getMemberCount() {
        if (getTIMElem() == null) {
            return 0;
        }
        return (int) ((TIMGroupTipsElem) getTIMElem()).getMemberNum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V2TIMGroupChangeInfo v2TIMGroupChangeInfo : getGroupChangeInfoList()) {
            sb.append("sub type:");
            sb.append(v2TIMGroupChangeInfo.getType());
            sb.append(", key:");
            sb.append(v2TIMGroupChangeInfo.getKey());
            sb.append(", value:");
            sb.append(v2TIMGroupChangeInfo.getValue());
            sb.append("\n");
        }
        StringBuilder sb2 = new StringBuilder();
        for (V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo : getMemberChangeInfoList()) {
            sb2.append("userID:");
            sb2.append(v2TIMGroupMemberChangeInfo.getUserID());
            sb2.append(", muteTime:");
            sb2.append(v2TIMGroupMemberChangeInfo.getMuteTime());
            sb2.append("\n");
        }
        List<V2TIMGroupMemberInfo> memberList = getMemberList();
        StringBuilder sb3 = new StringBuilder();
        for (V2TIMGroupMemberInfo v2TIMGroupMemberInfo : memberList) {
            sb3.append(v2TIMGroupMemberInfo.toString());
            sb3.append("\n");
        }
        V2TIMGroupMemberInfo opMember = getOpMember();
        String v2TIMGroupMemberInfo2 = opMember != null ? opMember.toString() : "";
        return "V2TIMGroupTipsElem--->groupID:" + getGroupID() + ", tips type:" + getType() + ", memberCount:" + getMemberCount() + "\n, memberList:\n" + sb3.toString() + ", groupChangedInfoList:\n" + sb.toString() + ", memberChangedInfoList:\n" + sb2.toString() + ", opUser:" + v2TIMGroupMemberInfo2;
    }
}
