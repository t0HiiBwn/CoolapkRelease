package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.IMBridge;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageStatus;
import com.tencent.imsdk.conversation.Msg;

@Deprecated
public class TIMMessageExt {
    private static final String TAG = ("imsdk." + TIMMessageExt.class.getSimpleName());
    private boolean isImported = false;
    private Msg msg;

    public TIMMessageExt(TIMMessage tIMMessage) {
        this.msg = IMBridge.getMsgFromTIMMessage(tIMMessage == null ? new TIMMessage() : tIMMessage);
    }

    @Deprecated
    public boolean isRead() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.isRead();
        }
        return true;
    }

    @Deprecated
    public boolean remove() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.remove();
    }

    @Deprecated
    public int getCustomInt() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.getCustomInt();
    }

    @Deprecated
    public void setCustomInt(int i) {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            msg2.setCustomInt(i);
        }
    }

    @Deprecated
    public String getCustomStr() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return "";
        }
        return msg2.getCustomStr();
    }

    @Deprecated
    public void setCustomStr(String str) {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            if (str == null) {
                str = "";
            }
            msg2.setCustomStr(str);
        }
    }

    @Deprecated
    public boolean convertToImportedMsg() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.convertToImportedMsg();
    }

    @Deprecated
    public boolean setSender(String str) {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return msg2.setSender(str);
    }

    @Deprecated
    public boolean setTimestamp(long j) {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.setTimestamp(j);
    }

    @Deprecated
    public boolean isPeerReaded() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.isPeerReaded();
    }

    @Deprecated
    public TIMMessageLocator getMessageLocator() {
        return this.msg.getMessageLocator();
    }

    @Deprecated
    public boolean checkEquals(TIMMessageLocator tIMMessageLocator) {
        if (tIMMessageLocator == null) {
            return false;
        }
        if (!tIMMessageLocator.isRevokedMsg() || tIMMessageLocator.getConversationType() != TIMConversationType.Group) {
            if (tIMMessageLocator.getConversationType() == this.msg.getConversation().getType() && tIMMessageLocator.getSid().equals(this.msg.getConversation().getPeer()) && tIMMessageLocator.getSeq() == this.msg.seq() && tIMMessageLocator.getRand() == this.msg.rand() && tIMMessageLocator.getTimestamp() == this.msg.time()) {
                return true;
            }
            return false;
        } else if ((this.msg.status() == TIMMessageStatus.SendSucc.getStatus() || this.msg.status() == TIMMessageStatus.HasRevoked.getStatus()) && tIMMessageLocator.getSeq() == this.msg.seq() && tIMMessageLocator.getSid().equals(this.msg.getConversation().getPeer())) {
            return true;
        } else {
            return false;
        }
    }
}
