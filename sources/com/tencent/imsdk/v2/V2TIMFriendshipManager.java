package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMFriendshipManager {
    public abstract void acceptFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, int i, V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback);

    public abstract void addFriend(V2TIMFriendAddApplication v2TIMFriendAddApplication, V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback);

    public abstract void addFriendsToFriendGroup(String str, List<String> list, V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback);

    public abstract void addToBlackList(List<String> list, V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback);

    public abstract void checkFriend(String str, int i, V2TIMValueCallback<V2TIMFriendCheckResult> v2TIMValueCallback);

    public abstract void createFriendGroup(String str, List<String> list, V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback);

    public abstract void deleteFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, V2TIMCallback v2TIMCallback);

    public abstract void deleteFriendGroup(List<String> list, V2TIMCallback v2TIMCallback);

    public abstract void deleteFriendsFromFriendGroup(String str, List<String> list, V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback);

    public abstract void deleteFromBlackList(List<String> list, V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback);

    public abstract void deleteFromFriendList(List<String> list, int i, V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback);

    public abstract void getBlackList(V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback);

    public abstract void getFriendApplicationList(V2TIMValueCallback<V2TIMFriendApplicationResult> v2TIMValueCallback);

    public abstract void getFriendGroups(List<String> list, V2TIMValueCallback<List<V2TIMFriendGroup>> v2TIMValueCallback);

    public abstract void getFriendList(V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback);

    public abstract void getFriendsInfo(List<String> list, V2TIMValueCallback<List<V2TIMFriendInfoResult>> v2TIMValueCallback);

    public abstract void refuseFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback);

    public abstract void renameFriendGroup(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void setFriendApplicationRead(V2TIMCallback v2TIMCallback);

    public abstract void setFriendInfo(V2TIMFriendInfo v2TIMFriendInfo, V2TIMCallback v2TIMCallback);

    public abstract void setFriendListener(V2TIMFriendshipListener v2TIMFriendshipListener);

    static V2TIMFriendshipManager getInstance() {
        return V2TIMFriendshipManagerImpl.getInstance();
    }
}
