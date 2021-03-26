package com.tencent.imsdk.friendship;

import com.tencent.imsdk.TIMSNSChangeInfo;
import java.util.List;

public interface TIMFriendshipListener {
    void onAddFriendReqs(List<TIMFriendPendencyInfo> list);

    void onAddFriends(List<String> list);

    void onDelFriends(List<String> list);

    void onFriendProfileUpdate(List<TIMSNSChangeInfo> list);
}
