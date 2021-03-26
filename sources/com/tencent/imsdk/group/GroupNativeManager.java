package com.tencent.imsdk.group;

import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import java.util.List;
import java.util.Map;

public class GroupNativeManager {
    protected static native void nativeAcceptPendency(String str, long j, String str2, long j2, String str3, long j3, long j4, long j5, long j6, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ICallback iCallback);

    protected static native void nativeCreateGroup(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2, List<TIMGroupMemberInfo> list, Map<String, byte[]> map, ICallback iCallback);

    protected static native void nativeDeleteGroup(String str, ICallback iCallback);

    protected static native void nativeDeleteGroupAttributes(String str, List<String> list, ICallback iCallback);

    public static native void nativeDeleteGroupMember(String str, List<String> list, String str2, ICallback iCallback);

    protected static native void nativeGetAVChatRoomMembers(String str, ICallback iCallback);

    protected static native void nativeGetGroupAttributes(String str, List<String> list, ICallback iCallback);

    protected static native void nativeGetGroupMembers(String str, ICallback iCallback);

    protected static native void nativeGetGroupMembersByFilter(String str, long j, long j2, List<String> list, long j3, ICallback iCallback);

    protected static native void nativeGetGroupMembersInfo(String str, List<String> list, ICallback iCallback);

    protected static native void nativeGetGroupOnlineMemberCount(String str, ICallback iCallback);

    protected static native void nativeGetGroupPendencies(long j, long j2, ICallback iCallback);

    protected static native void nativeGetGroupSelfInfo(String str, String str2, ICallback iCallback);

    protected static native void nativeGetGroupsInfo(List<String> list, ICallback iCallback);

    protected static native void nativeGetJoinedGroups(ICallback iCallback);

    protected static native void nativeInitGroupAttributes(String str, Map<String, String> map, ICallback iCallback);

    protected static native void nativeInviteGroupMember(String str, List<String> list, String str2, ICallback iCallback);

    protected static native void nativeJoinGroup(String str, String str2, ICallback iCallback);

    protected static native void nativeModifyGroupOwner(String str, String str2, ICallback iCallback);

    protected static native TIMGroupDetailInfo nativeQueryGroupInfo(String str);

    protected static native void nativeQuitGroup(String str, ICallback iCallback);

    protected static native void nativeRefusePendency(String str, long j, String str2, long j2, String str3, long j3, long j4, long j5, long j6, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ICallback iCallback);

    protected static native void nativeReportGroupPendencies(long j, ICallback iCallback);

    protected static native void nativeSetGroupAttributes(String str, Map<String, String> map, ICallback iCallback);

    public static native void nativeSetGroupInfo(long j, String str, String str2, String str3, String str4, String str5, long j2, long j3, boolean z, boolean z2, boolean z3, Map<String, byte[]> map, ICallback iCallback);

    protected static native void nativeSetGroupListener(GroupListener groupListener);

    public static native void nativeSetGroupMemberInfo(long j, String str, String str2, String str3, long j2, long j3, long j4, Map<String, byte[]> map, ICallback iCallback);
}
