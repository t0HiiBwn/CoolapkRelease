package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.ext.message.TIMMessageReceipt;

public class V2TIMMessageReceipt {
    private TIMMessageReceipt timMessageReceipt;

    void setTimMessageReceipt(TIMMessageReceipt tIMMessageReceipt) {
        this.timMessageReceipt = tIMMessageReceipt;
    }

    public String getUserID() {
        TIMMessageReceipt tIMMessageReceipt = this.timMessageReceipt;
        if (tIMMessageReceipt == null) {
            return null;
        }
        TIMConversation conversation = tIMMessageReceipt.getConversation();
        if (conversation != null || conversation.getType() == TIMConversationType.C2C) {
            return conversation.getPeer();
        }
        return null;
    }

    public long getTimestamp() {
        TIMMessageReceipt tIMMessageReceipt = this.timMessageReceipt;
        if (tIMMessageReceipt != null) {
            return tIMMessageReceipt.getTimestamp();
        }
        return 0;
    }
}
