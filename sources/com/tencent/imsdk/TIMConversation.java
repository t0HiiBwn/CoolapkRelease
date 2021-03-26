package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import com.tencent.imsdk.ext.message.TIMMessageDraft;
import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.List;

public class TIMConversation {
    private static final String TAG = "TIMConversation";
    protected Conversation mConversation;
    private String peer = "";
    private TIMConversationType type = TIMConversationType.Invalid;

    protected TIMConversation(TIMConversationType tIMConversationType, String str) {
        this.peer = str;
        if (!(tIMConversationType == TIMConversationType.C2C || tIMConversationType == TIMConversationType.Group || tIMConversationType == TIMConversationType.System)) {
            tIMConversationType = TIMConversationType.Invalid;
        }
        this.type = tIMConversationType;
        if (tIMConversationType == TIMConversationType.Invalid) {
            String str2 = TAG;
            QLog.e(str2, "conversation is null because type = " + tIMConversationType.value() + ", peer = " + str);
            this.mConversation = null;
        } else if (tIMConversationType == TIMConversationType.System || !TextUtils.isEmpty(str)) {
            this.mConversation = new Conversation(tIMConversationType.value(), str);
        } else {
            String str3 = TAG;
            QLog.e(str3, "conversation is null because type = " + tIMConversationType.value() + ", peer = " + str);
            this.mConversation = null;
        }
    }

    protected TIMConversation(int i, String str) {
        TIMConversationType[] values = TIMConversationType.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            TIMConversationType tIMConversationType = values[i2];
            if (tIMConversationType.value() == i) {
                this.type = tIMConversationType;
                break;
            }
            i2++;
        }
        this.peer = str;
        if (i == TIMConversationType.Invalid.value()) {
            String str2 = TAG;
            QLog.i(str2, "conversation is null because type = " + i + ", peer = " + str);
            this.mConversation = null;
        } else if (i == TIMConversationType.System.value() || !TextUtils.isEmpty(str)) {
            this.mConversation = new Conversation(i, str);
        } else {
            String str3 = TAG;
            QLog.e(str3, "conversation is null because type = " + i + ", peer = " + str);
            this.mConversation = null;
        }
    }

    public void sendMessage(TIMMessage tIMMessage, TIMValueCallBack<TIMMessage> tIMValueCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            String str = TAG;
            QLog.e(str, "sendMessage fail because mConversation is null, type = " + this.type + ", peer = " + this.peer);
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "mConversation is null, type = " + this.type + ", peer = " + this.peer);
                return;
            }
            return;
        }
        conversation.sendMessage(false, false, tIMMessage, tIMValueCallBack);
    }

    public void sendOnlineMessage(TIMMessage tIMMessage, TIMValueCallBack<TIMMessage> tIMValueCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            String str = TAG;
            QLog.e(str, "sendOnlineMessage fail because mConversation is null, type = " + this.type + ", peer = " + this.peer);
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "mConversation is null, type = " + this.type + ", peer = " + this.peer);
                return;
            }
            return;
        }
        conversation.sendMessage(true, false, tIMMessage, tIMValueCallBack);
    }

    public void getMessage(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            QLog.e(TAG, "getMessage fail because mConversation is null");
        } else {
            conversation.getMessages(i, tIMMessage, true, false, tIMValueCallBack);
        }
    }

    public void getLocalMessage(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            QLog.e(TAG, "getLocalMessage fail because mConversation is null");
        } else {
            conversation.getMessages(i, tIMMessage, false, false, tIMValueCallBack);
        }
    }

    public TIMMessage getLastMsg() {
        Conversation conversation = this.mConversation;
        if (conversation != null) {
            return conversation.getLastMsg();
        }
        QLog.e(TAG, "getLastMsg fail because mConversation is null");
        return null;
    }

    public List<TIMGroupAtInfo> getGroupAtInfoList() {
        Conversation conversation = this.mConversation;
        if (conversation != null) {
            return conversation.getGroupAtInfoList();
        }
        QLog.e(TAG, "getGroupAtInfoList fail because mConversation is null");
        return new ArrayList();
    }

    public void setReadMessage(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            QLog.e(TAG, "setReadMessage fail because mConversation is null");
        } else {
            conversation.reportReaded(tIMMessage, tIMCallBack);
        }
    }

    public long getUnreadMessageNum() {
        Conversation conversation = this.mConversation;
        if (conversation != null) {
            return (long) conversation.getUnreadMessageNum();
        }
        QLog.e(TAG, "getUnreadMessageNum fail because mConversation is null");
        return 0;
    }

    public void revokeMessage(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            QLog.e(TAG, "revokeMessage fail because mConversation is null");
        } else {
            conversation.revokeMessage(tIMMessage, tIMCallBack);
        }
    }

    public void deleteLocalMessage(TIMCallBack tIMCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            QLog.e(TAG, "deleteLocalMessage fail because mConversation is null");
        } else {
            conversation.deleteLocalMessage(tIMCallBack);
        }
    }

    public void deleteMessages(List<TIMMessage> list, TIMCallBack tIMCallBack) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("deleteMessages: messages size:");
        sb.append(list == null ? 0 : list.size());
        sb.append(", callBack:");
        sb.append(tIMCallBack);
        QLog.i(str, sb.toString());
        if (this.mConversation == null) {
            QLog.e(str, "deleteMessages fail because mConversation is null");
        } else if (list == null || list.size() == 0) {
            QLog.e(str, "deleteMessages fail because messages is empty");
        } else {
            this.mConversation.deleteMessages(list, tIMCallBack);
        }
    }

    public TIMConversationType getType() {
        return this.type;
    }

    public String getPeer() {
        return this.peer;
    }

    public String getGroupName() {
        TIMGroupDetailInfo queryGroupInfo;
        if (this.mConversation == null) {
            QLog.e(TAG, "getGroupName fail because mConversation is null");
            return null;
        } else if (this.type.value() != TIMConversationType.Group.value()) {
            return null;
        } else {
            String groupName = this.mConversation.getGroupName();
            return (TextUtils.isEmpty(groupName) && (queryGroupInfo = TIMGroupManager.getInstance().queryGroupInfo(this.peer)) != null && !TextUtils.isEmpty(queryGroupInfo.getGroupName())) ? queryGroupInfo.getGroupName() : groupName;
        }
    }

    public TIMMessageDraft getDraft() {
        Conversation conversation = this.mConversation;
        if (conversation != null) {
            return conversation.getDraft();
        }
        QLog.e(TAG, "getDraft fail because mConversation is null");
        return null;
    }

    public void setDraft(TIMMessageDraft tIMMessageDraft) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            QLog.e(TAG, "setDraft fail because mConversation is null");
        } else {
            conversation.setDraft(tIMMessageDraft);
        }
    }

    public boolean hasDraft() {
        Conversation conversation = this.mConversation;
        if (conversation != null) {
            return conversation.hasDraft();
        }
        QLog.e(TAG, "hasDraft fail because mConversation is null");
        return false;
    }

    public int saveMessage(TIMMessage tIMMessage, String str, boolean z) {
        Conversation conversation = this.mConversation;
        if (conversation != null) {
            return conversation.saveMessage(tIMMessage, str, z);
        }
        QLog.e(TAG, "saveMessage fail because mConversation is null");
        return 6017;
    }

    public int importMsg(List<TIMMessage> list) {
        Conversation conversation = this.mConversation;
        if (conversation != null) {
            return conversation.importMsg(list);
        }
        QLog.e(TAG, "importMsg fail because mConversation is null");
        return 6017;
    }

    public void findMessages(List<TIMMessageLocator> list, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        Conversation conversation = this.mConversation;
        if (conversation == null) {
            QLog.e(TAG, "findMessages fail because mConversation is null");
        } else {
            conversation.findMessages(list, tIMValueCallBack);
        }
    }
}
