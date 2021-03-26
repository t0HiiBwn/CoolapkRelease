package com.tencent.imsdk;

import com.tencent.imsdk.conversation.Msg;

public class IMBridge {
    public static Msg getMsgFromTIMMessage(TIMMessage tIMMessage) {
        if (tIMMessage == null) {
            return null;
        }
        return tIMMessage.getMsg();
    }

    public static TIMMessage convertMsgToTIMMessage(Msg msg) {
        if (msg == null) {
            return null;
        }
        return new TIMMessage(msg);
    }

    public static TIMConversation newTIMConversation(TIMConversationType tIMConversationType, String str) {
        return new TIMConversation(tIMConversationType, str);
    }
}
