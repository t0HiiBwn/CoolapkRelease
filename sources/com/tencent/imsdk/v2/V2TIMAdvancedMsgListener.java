package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMAdvancedMsgListener {
    public void onRecvC2CReadReceipt(List<V2TIMMessageReceipt> list) {
    }

    public void onRecvMessageRevoked(String str) {
    }

    public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
    }
}
