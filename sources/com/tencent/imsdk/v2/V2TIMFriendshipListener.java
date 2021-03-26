package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMFriendshipListener {
    public void onBlackListAdd(List<V2TIMFriendInfo> list) {
    }

    public void onBlackListDeleted(List<String> list) {
    }

    public void onFriendApplicationListAdded(List<V2TIMFriendApplication> list) {
    }

    public void onFriendApplicationListDeleted(List<String> list) {
    }

    public void onFriendApplicationListRead() {
    }

    public void onFriendInfoChanged(List<V2TIMFriendInfo> list) {
    }

    public void onFriendListAdded(List<V2TIMFriendInfo> list) {
    }

    public void onFriendListDeleted(List<String> list) {
    }
}
