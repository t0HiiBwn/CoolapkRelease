package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMCustomElem;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMFaceElem;
import com.tencent.imsdk.TIMFileElem;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupTipsElem;
import com.tencent.imsdk.TIMImageElem;
import com.tencent.imsdk.TIMLocationElem;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageOfflinePushSettings;
import com.tencent.imsdk.TIMMessagePriority;
import com.tencent.imsdk.TIMMessageStatus;
import com.tencent.imsdk.TIMSoundElem;
import com.tencent.imsdk.TIMTextElem;
import com.tencent.imsdk.TIMVideoElem;
import com.tencent.imsdk.friendship.TIMFriend;
import java.util.ArrayList;
import java.util.List;

public class V2TIMMessage {
    static final int MSG_SEND_TYPE_NORMAL = 0;
    static final int MSG_SEND_TYPE_ONLINE = 1;
    public static final int V2TIM_ELEM_TYPE_CUSTOM = 2;
    public static final int V2TIM_ELEM_TYPE_FACE = 8;
    public static final int V2TIM_ELEM_TYPE_FILE = 6;
    public static final int V2TIM_ELEM_TYPE_GROUP_TIPS = 9;
    public static final int V2TIM_ELEM_TYPE_IMAGE = 3;
    public static final int V2TIM_ELEM_TYPE_LOCATION = 7;
    public static final int V2TIM_ELEM_TYPE_NONE = 0;
    public static final int V2TIM_ELEM_TYPE_SOUND = 4;
    public static final int V2TIM_ELEM_TYPE_TEXT = 1;
    public static final int V2TIM_ELEM_TYPE_VIDEO = 5;
    public static final int V2TIM_MSG_STATUS_HAS_DELETED = 4;
    public static final int V2TIM_MSG_STATUS_LOCAL_REVOKED = 6;
    public static final int V2TIM_MSG_STATUS_SENDING = 1;
    public static final int V2TIM_MSG_STATUS_SEND_FAIL = 3;
    public static final int V2TIM_MSG_STATUS_SEND_SUCC = 2;
    public static final int V2TIM_PRIORITY_DEFAULT = 0;
    public static final int V2TIM_PRIORITY_HIGH = 1;
    public static final int V2TIM_PRIORITY_LOW = 3;
    public static final int V2TIM_PRIORITY_NORMAL = 2;
    private boolean canReadMsgID = true;
    private TIMMessage timMessage = new TIMMessage();

    void setTIMMessage(TIMMessage tIMMessage) {
        this.timMessage = tIMMessage;
    }

    TIMMessage getTIMMessage() {
        return this.timMessage;
    }

    public String getMsgID() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null || !this.canReadMsgID) {
            return "";
        }
        return tIMMessage.getMsgId();
    }

    public long getTimestamp() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.timestamp();
        }
        return 0;
    }

    public String getSender() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.getSender();
        }
        return null;
    }

    boolean setSender(String str) {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.setSender(str);
        }
        return false;
    }

    public String getNickName() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.getSenderNickname();
        }
        return null;
    }

    public String getFriendRemark() {
        TIMFriend queryFriend;
        if (this.timMessage == null) {
            return null;
        }
        String sender = getSender();
        if (TextUtils.isEmpty(sender) || (queryFriend = TIMFriendshipManager.getInstance().queryFriend(sender)) == null) {
            return null;
        }
        String remark = queryFriend.getRemark();
        if (TextUtils.isEmpty(remark)) {
            return null;
        }
        return remark;
    }

    public String getFaceUrl() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.getSenderFaceUrl();
        }
        return null;
    }

    public String getNameCard() {
        TIMGroupMemberInfo senderGroupMemberProfile;
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null || (senderGroupMemberProfile = tIMMessage.getSenderGroupMemberProfile()) == null) {
            return null;
        }
        return senderGroupMemberProfile.getNameCard();
    }

    public String getGroupID() {
        TIMConversation conversation;
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null || (conversation = tIMMessage.getConversation()) == null || conversation.getType() != TIMConversationType.Group) {
            return null;
        }
        return conversation.getPeer();
    }

    public String getUserID() {
        TIMConversation conversation;
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null || (conversation = tIMMessage.getConversation()) == null || conversation.getType() != TIMConversationType.C2C) {
            return null;
        }
        return conversation.getPeer();
    }

    public int getStatus() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return 1;
        }
        TIMMessageStatus status = tIMMessage.status();
        if (status.getStatus() == TIMMessageStatus.Sending.getStatus()) {
            return 1;
        }
        if (status.getStatus() == TIMMessageStatus.SendSucc.getStatus()) {
            return 2;
        }
        if (status.getStatus() == TIMMessageStatus.SendFail.getStatus()) {
            return 3;
        }
        if (status.getStatus() == TIMMessageStatus.HasDeleted.getStatus()) {
            return 4;
        }
        if (status.getStatus() == TIMMessageStatus.HasRevoked.getStatus()) {
            return 6;
        }
        return 1;
    }

    public int getElemType() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null || tIMMessage.getElementCount() <= 0) {
            return 0;
        }
        TIMElem element = this.timMessage.getElement(0);
        if (element instanceof TIMTextElem) {
            return 1;
        }
        if (element instanceof TIMImageElem) {
            return 3;
        }
        if (element instanceof TIMVideoElem) {
            return 5;
        }
        if (element instanceof TIMSoundElem) {
            return 4;
        }
        if (element instanceof TIMFaceElem) {
            return 8;
        }
        if (element instanceof TIMFileElem) {
            return 6;
        }
        if (element instanceof TIMCustomElem) {
            return 2;
        }
        if (element instanceof TIMLocationElem) {
            return 7;
        }
        if (element instanceof TIMGroupTipsElem) {
            return 9;
        }
        return 0;
    }

    public V2TIMTextElem getTextElem() {
        if (getElemType() == 0 || getElemType() != 1) {
            return null;
        }
        V2TIMTextElem v2TIMTextElem = new V2TIMTextElem();
        v2TIMTextElem.setTIMMessage(this.timMessage);
        v2TIMTextElem.setElemIndex(0);
        return v2TIMTextElem;
    }

    public V2TIMCustomElem getCustomElem() {
        if (getElemType() == 0 || getElemType() != 2) {
            return null;
        }
        V2TIMCustomElem v2TIMCustomElem = new V2TIMCustomElem();
        v2TIMCustomElem.setTIMMessage(this.timMessage);
        v2TIMCustomElem.setElemIndex(0);
        return v2TIMCustomElem;
    }

    public V2TIMImageElem getImageElem() {
        if (getElemType() == 0 || getElemType() != 3) {
            return null;
        }
        V2TIMImageElem v2TIMImageElem = new V2TIMImageElem();
        v2TIMImageElem.setTIMMessage(this.timMessage);
        v2TIMImageElem.setElemIndex(0);
        return v2TIMImageElem;
    }

    public V2TIMSoundElem getSoundElem() {
        if (getElemType() == 0 || getElemType() != 4) {
            return null;
        }
        V2TIMSoundElem v2TIMSoundElem = new V2TIMSoundElem();
        v2TIMSoundElem.setTIMMessage(this.timMessage);
        v2TIMSoundElem.setElemIndex(0);
        return v2TIMSoundElem;
    }

    public V2TIMVideoElem getVideoElem() {
        if (getElemType() == 0 || getElemType() != 5) {
            return null;
        }
        V2TIMVideoElem v2TIMVideoElem = new V2TIMVideoElem();
        v2TIMVideoElem.setTIMMessage(this.timMessage);
        v2TIMVideoElem.setElemIndex(0);
        return v2TIMVideoElem;
    }

    public V2TIMFileElem getFileElem() {
        if (getElemType() == 0 || getElemType() != 6) {
            return null;
        }
        V2TIMFileElem v2TIMFileElem = new V2TIMFileElem();
        v2TIMFileElem.setTIMMessage(this.timMessage);
        v2TIMFileElem.setElemIndex(0);
        return v2TIMFileElem;
    }

    public V2TIMLocationElem getLocationElem() {
        if (getElemType() == 0 || getElemType() != 7) {
            return null;
        }
        V2TIMLocationElem v2TIMLocationElem = new V2TIMLocationElem();
        v2TIMLocationElem.setTIMMessage(this.timMessage);
        v2TIMLocationElem.setElemIndex(0);
        return v2TIMLocationElem;
    }

    public V2TIMFaceElem getFaceElem() {
        if (getElemType() == 0 || getElemType() != 8) {
            return null;
        }
        V2TIMFaceElem v2TIMFaceElem = new V2TIMFaceElem();
        v2TIMFaceElem.setTIMMessage(this.timMessage);
        v2TIMFaceElem.setElemIndex(0);
        return v2TIMFaceElem;
    }

    public V2TIMGroupTipsElem getGroupTipsElem() {
        if (getElemType() == 0 || getElemType() != 9) {
            return null;
        }
        V2TIMGroupTipsElem v2TIMGroupTipsElem = new V2TIMGroupTipsElem();
        v2TIMGroupTipsElem.setTIMMessage(this.timMessage);
        v2TIMGroupTipsElem.setElemIndex(0);
        return v2TIMGroupTipsElem;
    }

    public String getLocalCustomData() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return "";
        }
        return tIMMessage.getCustomStr();
    }

    public void setLocalCustomData(String str) {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            tIMMessage.setCustomStr(str);
        }
    }

    public int getLocalCustomInt() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return 0;
        }
        return tIMMessage.getCustomInt();
    }

    public void setLocalCustomInt(int i) {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            tIMMessage.setCustomInt(i);
        }
    }

    public void setCloudCustomData(String str) {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            tIMMessage.setCloudCustomData(str);
        }
    }

    public String getCloudCustomData() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return "";
        }
        return tIMMessage.getCloudCustomData();
    }

    public boolean isSelf() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.isSelf();
        }
        return true;
    }

    public boolean isRead() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.isRead();
        }
        return true;
    }

    public boolean isPeerRead() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            return tIMMessage.isPeerReaded();
        }
        return false;
    }

    V2TIMConversation getConversation() {
        TIMConversation conversation;
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null || (conversation = tIMMessage.getConversation()) == null) {
            return null;
        }
        V2TIMConversation v2TIMConversation = new V2TIMConversation();
        v2TIMConversation.setTIMConversation(conversation);
        return v2TIMConversation;
    }

    public int getPriority() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return 2;
        }
        TIMMessagePriority priority = tIMMessage.getPriority();
        if (priority.ordinal() == TIMMessagePriority.High.ordinal()) {
            return 1;
        }
        if (priority.ordinal() != TIMMessagePriority.Normal.ordinal() && priority.ordinal() == TIMMessagePriority.Low.ordinal()) {
            return 3;
        }
        return 2;
    }

    public V2TIMOfflinePushInfo getOfflinePushInfo() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return null;
        }
        TIMMessageOfflinePushSettings offlinePushSettings = tIMMessage.getOfflinePushSettings();
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setTIMMessageOfflinePushConfig(offlinePushSettings);
        return v2TIMOfflinePushInfo;
    }

    public List<String> getGroupAtUserList() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return new ArrayList();
        }
        return tIMMessage.getGroupAtUserList();
    }

    public long getSeq() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return 0;
        }
        return tIMMessage.getSeq();
    }

    public long getRandom() {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null) {
            return 0;
        }
        return tIMMessage.getRand();
    }

    void setOfflinePushInfo(V2TIMOfflinePushInfo v2TIMOfflinePushInfo) {
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage != null) {
            tIMMessage.setOfflinePushSettings(v2TIMOfflinePushInfo.getTimMessageOfflinePushConfig());
        }
    }

    void setCanReadMsgID(boolean z) {
        this.canReadMsgID = z;
    }
}
