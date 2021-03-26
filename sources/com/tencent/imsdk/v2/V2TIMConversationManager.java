package com.tencent.imsdk.v2;

public abstract class V2TIMConversationManager {
    public abstract void deleteConversation(String str, V2TIMCallback v2TIMCallback);

    public abstract void getConversation(String str, V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback);

    public abstract void getConversationList(long j, int i, V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback);

    public abstract void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void setConversationListener(V2TIMConversationListener v2TIMConversationListener);

    static V2TIMConversationManager getInstance() {
        return V2TIMConversationManagerImpl.getInstance();
    }
}
