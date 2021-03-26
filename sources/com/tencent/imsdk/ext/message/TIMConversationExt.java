package com.tencent.imsdk.ext.message;

import android.text.TextUtils;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.log.QLog;
import java.util.List;

@Deprecated
public class TIMConversationExt {
    private static final String TAG = "TIMConversationExt";
    private TIMConversation conversation;
    private Conversation mConversation;

    public TIMConversationExt(TIMConversation tIMConversation) {
        this.conversation = tIMConversation;
        if (tIMConversation.getType() == TIMConversationType.Invalid) {
            String str = TAG;
            QLog.e(str, "conversation is null because type = " + tIMConversation.getType().value());
            this.mConversation = null;
        } else if (tIMConversation.getType() == TIMConversationType.System || !TextUtils.isEmpty(tIMConversation.getPeer())) {
            this.mConversation = new Conversation(tIMConversation.getType().value(), tIMConversation.getPeer());
        } else {
            String str2 = TAG;
            QLog.e(str2, "conversation is null because type = " + tIMConversation.getType());
            this.mConversation = null;
        }
    }

    @Deprecated
    public void getMessage(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e(TAG, "getMessage ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "getMessage fail because mConversation is null");
        } else {
            conversation2.getMessages(i, tIMMessage, true, false, tIMValueCallBack);
        }
    }

    public void getMessageForward(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e(TAG, "getMessageForward ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "getMessageForward fail because mConversation is null");
        } else {
            conversation2.getMessages(i, tIMMessage, true, true, tIMValueCallBack);
        }
    }

    @Deprecated
    public void getLocalMessage(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e(TAG, "getLocalMessage ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "getLocalMessage fail because mConversation is null");
        } else {
            conversation2.getMessages(i, tIMMessage, false, false, tIMValueCallBack);
        }
    }

    @Deprecated
    public void getLocalMessageForward(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e(TAG, "getLocalMessageForward ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "getLocalMessageForward fail because mConversation is null");
        } else {
            conversation2.getMessages(i, tIMMessage, false, true, tIMValueCallBack);
        }
    }

    @Deprecated
    public void deleteLocalMessage(TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            QLog.e(TAG, "deleteLocalMessage ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "deleteLocalMessage fail because mConversation is null");
        } else {
            conversation2.deleteLocalMessage(tIMCallBack);
        }
    }

    @Deprecated
    public void setReadMessage(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            QLog.e(TAG, "setReadMessage ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "setReadMessage fail because mConversation is null");
        } else {
            conversation2.reportReaded(tIMMessage, tIMCallBack);
        }
    }

    @Deprecated
    public long getUnreadMessageNum() {
        Conversation conversation2 = this.mConversation;
        if (conversation2 != null) {
            return (long) conversation2.getUnreadMessageNum();
        }
        QLog.e(TAG, "getUnreadMessageNum fail because mConversation is null");
        return 0;
    }

    @Deprecated
    public int saveMessage(TIMMessage tIMMessage, String str, boolean z) {
        Conversation conversation2 = this.mConversation;
        if (conversation2 != null) {
            return conversation2.saveMessage(tIMMessage, str, z);
        }
        QLog.e(TAG, "saveMessage fail because mConversation is null");
        return 6004;
    }

    @Deprecated
    public int importMsg(List<TIMMessage> list) {
        Conversation conversation2 = this.mConversation;
        if (conversation2 != null) {
            return conversation2.importMsg(list);
        }
        QLog.e(TAG, "importMsg fail because mConversation is null");
        return 6004;
    }

    @Deprecated
    public TIMMessage getLastMsg() {
        Conversation conversation2 = this.mConversation;
        if (conversation2 != null) {
            return conversation2.getLastMsg();
        }
        QLog.e(TAG, "getLastMsg fail because mConversation is null");
        return null;
    }

    @Deprecated
    public TIMMessageDraft getDraft() {
        Conversation conversation2 = this.mConversation;
        if (conversation2 != null) {
            return conversation2.getDraft();
        }
        QLog.e(TAG, "setDraft fail because mConversation is null");
        return null;
    }

    @Deprecated
    public void setDraft(TIMMessageDraft tIMMessageDraft) {
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "setDraft fail because mConversation is null");
        } else {
            conversation2.setDraft(tIMMessageDraft);
        }
    }

    @Deprecated
    public boolean hasDraft() {
        Conversation conversation2 = this.mConversation;
        if (conversation2 != null) {
            return conversation2.hasDraft();
        }
        QLog.e(TAG, "hasDraft fail because mConversation is null");
        return false;
    }

    @Deprecated
    public void findMessages(List<TIMMessageLocator> list, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e(TAG, "findMessages ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "findMessages fail because mConversation is null");
        } else {
            conversation2.findMessages(list, tIMValueCallBack);
        }
    }

    @Deprecated
    public void revokeMessage(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            QLog.e(TAG, "revokeMessage ignore, callback is null");
            return;
        }
        Conversation conversation2 = this.mConversation;
        if (conversation2 == null) {
            QLog.e(TAG, "revokeMessage fail because mConversation is null");
        } else {
            conversation2.revokeMessage(tIMMessage, tIMCallBack);
        }
    }
}
