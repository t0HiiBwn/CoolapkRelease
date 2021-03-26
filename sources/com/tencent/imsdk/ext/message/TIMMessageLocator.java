package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.TIMConversationType;

public class TIMMessageLocator {
    private boolean isRevokedMsg = false;
    private boolean isSelf = true;
    private String msgID;
    private long rand = 0;
    private long seq = 0;
    private String sid;
    private TIMConversationType stype = TIMConversationType.Invalid;
    private long timestamp = 0;

    public String toString() {
        return (("ConverSationType: " + this.stype) + ", ConversationID: " + this.sid) + ", seq: " + this.seq + ", rand: " + this.rand + ", isSelf: " + this.isSelf + ", isRevokedMsg: " + this.isRevokedMsg;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public TIMMessageLocator setTimestamp(long j) {
        this.timestamp = j;
        return this;
    }

    public long getSeq() {
        return this.seq;
    }

    public TIMMessageLocator setSeq(long j) {
        this.seq = j;
        return this;
    }

    public long getRand() {
        return this.rand;
    }

    public TIMMessageLocator setRand(long j) {
        this.rand = j;
        return this;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public TIMMessageLocator setSelf(boolean z) {
        this.isSelf = z;
        return this;
    }

    public boolean isRevokedMsg() {
        return this.isRevokedMsg;
    }

    public TIMConversationType getConversationType() {
        return this.stype;
    }

    public int getTypeValue() {
        return this.stype.value();
    }

    public String getConversationId() {
        return this.sid;
    }

    protected String getSid() {
        return this.sid;
    }

    void setType(int i) {
        TIMConversationType[] values = TIMConversationType.values();
        for (TIMConversationType tIMConversationType : values) {
            if (tIMConversationType.value() == i) {
                this.stype = tIMConversationType;
            }
        }
    }

    public String getMsgID() {
        return this.msgID;
    }
}
