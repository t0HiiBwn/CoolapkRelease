package com.tencent.imsdk.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class V2TIMGroupManager {
    public abstract void acceptGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback);

    public abstract void createGroup(V2TIMGroupInfo v2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> list, V2TIMValueCallback<String> v2TIMValueCallback);

    public abstract void deleteGroupAttributes(String str, List<String> list, V2TIMCallback v2TIMCallback);

    public abstract void getGroupApplicationList(V2TIMValueCallback<V2TIMGroupApplicationResult> v2TIMValueCallback);

    public abstract void getGroupAttributes(String str, List<String> list, V2TIMValueCallback<Map<String, String>> v2TIMValueCallback);

    public abstract void getGroupMemberList(String str, int i, long j, V2TIMValueCallback<V2TIMGroupMemberInfoResult> v2TIMValueCallback);

    public abstract void getGroupMembersInfo(String str, List<String> list, V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> v2TIMValueCallback);

    public abstract void getGroupOnlineMemberCount(String str, V2TIMValueCallback<Integer> v2TIMValueCallback);

    public abstract void getGroupsInfo(List<String> list, V2TIMValueCallback<List<V2TIMGroupInfoResult>> v2TIMValueCallback);

    public abstract void getJoinedGroupList(V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback);

    public abstract void initGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback);

    public abstract void inviteUserToGroup(String str, List<String> list, V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback);

    public abstract void kickGroupMember(String str, List<String> list, String str2, V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback);

    public abstract void muteGroupMember(String str, String str2, int i, V2TIMCallback v2TIMCallback);

    public abstract void refuseGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback);

    public abstract void setGroupApplicationRead(V2TIMCallback v2TIMCallback);

    public abstract void setGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback);

    public abstract void setGroupInfo(V2TIMGroupInfo v2TIMGroupInfo, V2TIMCallback v2TIMCallback);

    public abstract void setGroupMemberInfo(String str, V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo, V2TIMCallback v2TIMCallback);

    public abstract void setGroupMemberRole(String str, String str2, int i, V2TIMCallback v2TIMCallback);

    public abstract void setReceiveMessageOpt(String str, int i, V2TIMCallback v2TIMCallback);

    public abstract void transferGroupOwner(String str, String str2, V2TIMCallback v2TIMCallback);

    static V2TIMGroupManager getInstance() {
        return V2TIMGroupManagerImpl.getInstance();
    }
}
