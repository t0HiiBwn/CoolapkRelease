package com.tencent.imsdk;

import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.IMFunc;
import java.util.ArrayList;
import java.util.List;

public class TIMMessage {
    private static final String TAG = "TIMMessage";
    private static final TIMElem defaultElem = new TIMElem() {
        /* class com.tencent.imsdk.TIMMessage.AnonymousClass1 */

        @Override // com.tencent.imsdk.TIMElem
        public TIMElemType getType() {
            return super.getType();
        }
    };
    private TIMConversation conversation;
    private Msg msg;

    public TIMMessage() {
        try {
            this.msg = new Msg();
        } catch (Throwable th) {
            QLog.writeException(TAG, "new message failed\n", th);
        }
    }

    TIMMessage(Msg msg2) {
        if (msg2 != null) {
            this.msg = msg2;
            this.conversation = msg2.getConversation();
        }
    }

    Msg getMsg() {
        return this.msg;
    }

    public int addElement(TIMElem tIMElem) {
        Msg msg2 = this.msg;
        if (msg2 == null || tIMElem == null || msg2.addElem(tIMElem) < 0) {
            return 1;
        }
        return 0;
    }

    public TIMElem getElement(int i) {
        Msg msg2 = this.msg;
        if (msg2 == null || i < 0) {
            return defaultElem;
        }
        try {
            return msg2.getElement(i);
        } catch (Throwable th) {
            QLog.e(TAG, IMFunc.getExceptionInfo(th));
            return defaultElem;
        }
    }

    public int getElementCount() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.elemSize();
    }

    public TIMMessageStatus status() {
        if (this.msg != null) {
            TIMMessageStatus[] values = TIMMessageStatus.values();
            for (TIMMessageStatus tIMMessageStatus : values) {
                if (tIMMessageStatus.getStatus() == this.msg.status()) {
                    return tIMMessageStatus;
                }
            }
        }
        return TIMMessageStatus.SendSucc;
    }

    public boolean isSelf() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.isSelf();
        }
        return true;
    }

    public String getSender() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.getSender();
        }
        QLog.i(TAG, "getSender() msg is null");
        return null;
    }

    public String getSenderNickname() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.getSenderNickname();
        }
        return null;
    }

    public String getSenderFaceUrl() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.getSenderFaceUrl();
        }
        return null;
    }

    public String getMsgId() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.msgid();
        }
        QLog.i(TAG, "getMsgId() msg is null");
        return "";
    }

    public long getMsgUniqueId() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.uniqueid();
        }
        return 0;
    }

    public long timestamp() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.time();
        }
        return 0;
    }

    public boolean isRead() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.isRead();
        }
        return true;
    }

    public boolean isPeerReaded() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.isPeerReaded();
    }

    public TIMMessageLocator getMessageLocator() {
        return this.msg.getMessageLocator();
    }

    public boolean checkEquals(TIMMessageLocator tIMMessageLocator) {
        if (tIMMessageLocator == null) {
            QLog.e(TAG, "checkEquals, locator is null");
            return false;
        } else if (this.msg.getConversation() == null) {
            QLog.e(TAG, "checkEquals, conversation is null");
            return false;
        } else if (!tIMMessageLocator.isRevokedMsg() || tIMMessageLocator.getConversationType() != TIMConversationType.Group) {
            if (tIMMessageLocator.getConversationType() == this.msg.getConversation().getType() && tIMMessageLocator.getConversationId().equals(this.msg.getConversation().getPeer()) && tIMMessageLocator.getSeq() == this.msg.seq() && tIMMessageLocator.getRand() == this.msg.rand() && tIMMessageLocator.getTimestamp() == this.msg.time()) {
                return true;
            }
            return false;
        } else if ((this.msg.status() == TIMMessageStatus.SendSucc.getStatus() || this.msg.status() == TIMMessageStatus.HasRevoked.getStatus()) && tIMMessageLocator.getSeq() == this.msg.seq() && tIMMessageLocator.getConversationId().equals(this.msg.getConversation().getPeer())) {
            return true;
        } else {
            return false;
        }
    }

    @Deprecated
    public boolean remove() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.remove();
    }

    public TIMConversation getConversation() {
        return this.msg.getConversation();
    }

    void setConversation(TIMConversation tIMConversation) {
        this.conversation = tIMConversation;
    }

    public void getSenderProfile(TIMValueCallBack<TIMUserProfile> tIMValueCallBack) {
        String str = TAG;
        QLog.i(str, "getSenderProfile called");
        Msg msg2 = this.msg;
        if (msg2 == null) {
            QLog.e(str, "getSenderProfile fail, msg is null");
        } else {
            msg2.getSenderProfile(tIMValueCallBack);
        }
    }

    public TIMGroupMemberInfo getSenderGroupMemberProfile() {
        if (this.msg == null || getConversation() == null || getConversation().getType() != TIMConversationType.Group) {
            return null;
        }
        return this.msg.getSenderGroupMemberProfile();
    }

    public TIMMessagePriority getPriority() {
        if (this.msg == null) {
            return TIMMessagePriority.Normal;
        }
        TIMMessagePriority[] values = TIMMessagePriority.values();
        for (TIMMessagePriority tIMMessagePriority : values) {
            if (tIMMessagePriority.getValue() == this.msg.priority()) {
                return tIMMessagePriority;
            }
        }
        return TIMMessagePriority.Normal;
    }

    public void setPriority(TIMMessagePriority tIMMessagePriority) {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            msg2.setPriority(tIMMessagePriority.getValue());
        }
    }

    public TIMMessageOfflinePushSettings getOfflinePushSettings() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return null;
        }
        return msg2.getOfflinePushInfo();
    }

    public void setOfflinePushSettings(TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings) {
        if (this.msg != null && tIMMessageOfflinePushSettings != null && tIMMessageOfflinePushSettings.isValid()) {
            this.msg.setOfflinePushInfo(tIMMessageOfflinePushSettings);
        }
    }

    public int getCustomInt() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.getCustomInt();
    }

    public void setCustomInt(int i) {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            msg2.setCustomInt(i);
        }
    }

    public String getCustomStr() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return "";
        }
        return msg2.getCustomStr();
    }

    public void setCustomStr(String str) {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            if (str == null) {
                str = "";
            }
            msg2.setCustomStr(str);
        }
    }

    public void setCloudCustomData(String str) {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            if (str == null) {
                str = "";
            }
            msg2.setCloudCustomData(str);
        }
    }

    public String getCloudCustomData() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return "";
        }
        return msg2.getCloudCustomData();
    }

    public boolean copyFrom(TIMMessage tIMMessage) {
        Msg msg2 = this.msg;
        if (msg2 == null || tIMMessage == null) {
            return false;
        }
        return msg2.copyFrom(tIMMessage.getMsg());
    }

    public boolean convertToImportedMsg() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.convertToImportedMsg();
    }

    public boolean setTimestamp(long j) {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return false;
        }
        return msg2.setTimestamp(j);
    }

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
    public TIMGroupReceiveMessageOpt getRecvFlag() {
        if (this.msg != null) {
            return TIMGroupReceiveMessageOpt.values()[this.msg.getRecvFlag()];
        }
        return null;
    }

    public long getRand() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.rand();
    }

    public long getSeq() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.seq();
    }

    public boolean setGroupAtUserList(List<String> list) {
        return this.msg.setGroupAtUserList(list);
    }

    public List<String> getGroupAtUserList() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return new ArrayList();
        }
        return msg2.getGroupAtUserList();
    }

    public String toString() {
        String str;
        TIMConversation conversation2 = getConversation();
        TIMConversationType tIMConversationType = TIMConversationType.Invalid;
        if (conversation2 != null) {
            tIMConversationType = conversation2.getType();
            str = conversation2.getPeer();
        } else {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("TIMMessage{");
        sb.append("\n\tConverstaionType:");
        sb.append(tIMConversationType);
        sb.append("\n\tConversationId:");
        sb.append(str);
        sb.append("\n\tMsgId:");
        sb.append(getMsgId());
        sb.append("\n\tMsgSeq:");
        sb.append(getSeq());
        sb.append("\n\tRand:");
        sb.append(getRand());
        sb.append("\n\ttime:");
        sb.append(timestamp());
        sb.append("\n\tisSelf:");
        sb.append(isSelf());
        sb.append("\n\tStatus:");
        sb.append(status());
        sb.append("\n\tSender:");
        sb.append(getSender());
        sb.append("\n\telements:[");
        int elementCount = getElementCount();
        for (int i = 0; i < elementCount; i++) {
            TIMElem element = getElement(i);
            if (element != null) {
                sb.append("\n\t\t{");
                sb.append("Type:");
                sb.append(element.getType());
                if (element.getType() == TIMElemType.Text) {
                    sb.append(", Content:");
                    sb.append(((TIMTextElem) element).getText());
                } else if (element.getType() == TIMElemType.Custom) {
                    TIMCustomElem tIMCustomElem = (TIMCustomElem) element;
                    sb.append("\n\t\tdesc: ");
                    sb.append(tIMCustomElem.getDesc());
                    sb.append("\n\t\tdata: ");
                    sb.append(new String(tIMCustomElem.getData()));
                    sb.append("\n\t\text: ");
                    sb.append(new String(tIMCustomElem.getExt()));
                }
                sb.append("}");
            }
        }
        sb.append("\n\t]");
        sb.append("\n}\n");
        return sb.toString();
    }
}
