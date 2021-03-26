package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMMessageManager {
    public abstract void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener);

    public abstract V2TIMMessage createCustomMessage(byte[] bArr);

    public abstract V2TIMMessage createCustomMessage(byte[] bArr, String str, byte[] bArr2);

    public abstract V2TIMMessage createFaceMessage(int i, byte[] bArr);

    public abstract V2TIMMessage createFileMessage(String str, String str2);

    public abstract V2TIMMessage createImageMessage(String str);

    public abstract V2TIMMessage createLocationMessage(String str, double d, double d2);

    public abstract V2TIMMessage createSoundMessage(String str, int i);

    public abstract V2TIMMessage createTextAtMessage(String str, List<String> list);

    public abstract V2TIMMessage createTextMessage(String str);

    public abstract V2TIMMessage createVideoMessage(String str, String str2, int i, String str3);

    public abstract void deleteMessageFromLocalStorage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback);

    public abstract void deleteMessages(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback);

    public abstract void findMessages(List<String> list, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getC2CHistoryMessageList(String str, int i, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getGroupHistoryMessageList(String str, int i, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getHistoryMessageList(V2TIMMessageListGetOption v2TIMMessageListGetOption, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract String insertC2CMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract String insertGroupMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract void markC2CMessageAsRead(String str, V2TIMCallback v2TIMCallback);

    public abstract void markGroupMessageAsRead(String str, V2TIMCallback v2TIMCallback);

    public abstract void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener);

    public abstract void revokeMessage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback);

    public abstract String sendMessage(V2TIMMessage v2TIMMessage, String str, String str2, int i, boolean z, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback);

    static V2TIMMessageManager getInstance() {
        return V2TIMMessageManagerImpl.getInstance();
    }
}
