package com.tencent.imsdk.friendship;

import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.common.ICallback;
import java.util.HashMap;
import java.util.List;

public class FriendshipNativeManager {
    public static native void nativeAddBlackList(List<String> list, ICallback iCallback);

    public static native void nativeAddFriend(TIMFriendRequest tIMFriendRequest, ICallback iCallback);

    public static native void nativeAddFriendsToFriendGroup(String str, List<String> list, ICallback iCallback);

    public static native void nativeCheckFriends(TIMFriendCheckInfo tIMFriendCheckInfo, ICallback iCallback);

    public static native void nativeCreateGroup(List<String> list, List<String> list2, ICallback iCallback);

    public static native void nativeDelFriend(List<String> list, int i, ICallback iCallback);

    public static native void nativeDeleteBlackList(List<String> list, ICallback iCallback);

    public static native void nativeDeleteFriendsFromFriendGroup(String str, List<String> list, ICallback iCallback);

    public static native void nativeDeleteGroup(List<String> list, ICallback iCallback);

    public static native void nativeDeletePendency(int i, List<String> list, ICallback iCallback);

    public static native void nativeDoResponse(TIMFriendResponse tIMFriendResponse, ICallback iCallback);

    public static native void nativeGetBlackList(ICallback iCallback);

    public static native void nativeGetFriendList(ICallback iCallback);

    public static native void nativeGetGroup(List<String> list, ICallback iCallback);

    public static native void nativeGetPendencyList(int i, long j, long j2, int i2, ICallback iCallback);

    public static native void nativeGetSpecifiedFriendList(List<String> list, ICallback iCallback);

    public static native void nativeGetUsersProfile(List<String> list, boolean z, List<String> list2, ICallback iCallback);

    public static native void nativeModifyFriendProfile(String str, HashMap<String, Object> hashMap, ICallback iCallback);

    public static native void nativeModifySelfProfile(HashMap<String, Object> hashMap, ICallback iCallback);

    public static native void nativePendencyReport(long j, ICallback iCallback);

    public static native TIMFriend nativeQueryFriend(String str);

    public static native List<TIMFriend> nativeQueryFriendList();

    public static native TIMUserProfile nativeQueryUserProfile(String str);

    public static native void nativeRenameFriendGroup(String str, String str2, ICallback iCallback);

    public static native void nativeSetFriendshipListener(TIMFriendshipListener tIMFriendshipListener);
}
