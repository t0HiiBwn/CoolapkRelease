package com.tencent.imsdk.conversation;

import com.tencent.imsdk.TIMConversation;
import java.util.List;

public interface ConversationListener {
    void onAddConversation(List<TIMConversation> list);

    void onDeleteConversation(List<TIMConversation> list);

    void onSyncServerFailed();

    void onSyncServerFinish();

    void onSyncServerStart();

    void onUpdateConversation(List<TIMConversation> list);
}
