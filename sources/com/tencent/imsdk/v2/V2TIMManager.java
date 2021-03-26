package com.tencent.imsdk.v2;

import android.content.Context;
import java.util.List;

public abstract class V2TIMManager {
    public static final String GROUP_TYPE_AVCHATROOM = "AVChatRoom";
    public static final String GROUP_TYPE_MEETING = "Meeting";
    public static final String GROUP_TYPE_PUBLIC = "Public";
    public static final String GROUP_TYPE_WORK = "Work";
    public static final int V2TIM_STATUS_LOGINED = 1;
    public static final int V2TIM_STATUS_LOGINING = 2;
    public static final int V2TIM_STATUS_LOGOUT = 3;

    public abstract void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener);

    public abstract void createGroup(String str, String str2, String str3, V2TIMValueCallback<String> v2TIMValueCallback);

    public abstract void dismissGroup(String str, V2TIMCallback v2TIMCallback);

    public abstract int getLoginStatus();

    public abstract String getLoginUser();

    public abstract long getServerTime();

    public abstract void getUsersInfo(List<String> list, V2TIMValueCallback<List<V2TIMUserFullInfo>> v2TIMValueCallback);

    public abstract String getVersion();

    public abstract boolean initSDK(Context context, int i, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener);

    public abstract void joinGroup(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void login(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void logout(V2TIMCallback v2TIMCallback);

    public abstract void quitGroup(String str, V2TIMCallback v2TIMCallback);

    public abstract void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener);

    public abstract String sendC2CCustomMessage(byte[] bArr, String str, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract String sendC2CTextMessage(String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract String sendGroupCustomMessage(byte[] bArr, String str, int i, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract String sendGroupTextMessage(String str, String str2, int i, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract void setGroupListener(V2TIMGroupListener v2TIMGroupListener);

    public abstract void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo, V2TIMCallback v2TIMCallback);

    public abstract void unInitSDK();

    public static V2TIMManager getInstance() {
        return V2TIMManagerImpl.getInstance();
    }

    public static V2TIMMessageManager getMessageManager() {
        return V2TIMMessageManagerImpl.getInstance();
    }

    public static V2TIMGroupManager getGroupManager() {
        return V2TIMGroupManager.getInstance();
    }

    public static V2TIMConversationManager getConversationManager() {
        return V2TIMConversationManagerImpl.getInstance();
    }

    public static V2TIMFriendshipManager getFriendshipManager() {
        return V2TIMFriendshipManagerImpl.getInstance();
    }

    public static V2TIMOfflinePushManager getOfflinePushManager() {
        return V2TIMOfflinePushManager.getInstance();
    }

    public static V2TIMSignalingManager getSignalingManager() {
        return V2TIMSignalingManager.getInstance();
    }
}
