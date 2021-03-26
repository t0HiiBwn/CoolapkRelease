package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMConversationListener {
    public void onConversationChanged(List<V2TIMConversation> list) {
    }

    public void onNewConversation(List<V2TIMConversation> list) {
    }

    public void onSyncServerFailed() {
    }

    public void onSyncServerFinish() {
    }

    public void onSyncServerStart() {
    }
}
