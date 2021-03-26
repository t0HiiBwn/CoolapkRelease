package com.tencent.imsdk;

import java.util.List;

public interface TIMRefreshListener {
    void onRefresh();

    void onRefreshConversation(List<TIMConversation> list);
}
