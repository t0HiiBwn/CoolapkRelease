package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMCustomElem;
import com.tencent.imsdk.TIMFaceElem;
import com.tencent.imsdk.TIMFileElem;
import com.tencent.imsdk.TIMImageElem;
import com.tencent.imsdk.TIMLocationElem;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessagePriority;
import com.tencent.imsdk.TIMSnapshot;
import com.tencent.imsdk.TIMSoundElem;
import com.tencent.imsdk.TIMTextElem;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.TIMVideo;
import com.tencent.imsdk.TIMVideoElem;
import com.tencent.imsdk.ext.message.TIMManagerExt;
import com.tencent.imsdk.group.GroupBaseManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class V2TIMMessageManagerImpl extends V2TIMMessageManager {
    private final String TAG;
    CopyOnWriteArrayList<V2TIMAdvancedMsgListener> mV2TIMMsgListenerList;

    private static class V2TIMMessageManagerImplHolder {
        private static final V2TIMMessageManagerImpl v2TIMMessageManagerImpl = new V2TIMMessageManagerImpl();

        private V2TIMMessageManagerImplHolder() {
        }
    }

    static V2TIMMessageManagerImpl getInstance() {
        return V2TIMMessageManagerImplHolder.v2TIMMessageManagerImpl;
    }

    private V2TIMMessageManagerImpl() {
        this.TAG = "V2TIMMessageManagerImpl";
        this.mV2TIMMsgListenerList = new CopyOnWriteArrayList<>();
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        if (v2TIMAdvancedMsgListener != null) {
            synchronized (this) {
                if (!this.mV2TIMMsgListenerList.contains(v2TIMAdvancedMsgListener)) {
                    this.mV2TIMMsgListenerList.add(v2TIMAdvancedMsgListener);
                }
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        synchronized (this) {
            this.mV2TIMMsgListenerList.remove(v2TIMAdvancedMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createTextMessage(String str) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMTextElem tIMTextElem = new TIMTextElem();
        tIMTextElem.setText(str);
        tIMMessage.addElement(tIMTextElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createTextAtMessage(String str, List<String> list) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMTextElem tIMTextElem = new TIMTextElem();
        tIMTextElem.setText(str);
        tIMMessage.addElement(tIMTextElem);
        tIMMessage.setGroupAtUserList(list);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createCustomMessage(byte[] bArr) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMCustomElem tIMCustomElem = new TIMCustomElem();
        tIMCustomElem.setData(bArr);
        tIMMessage.addElement(tIMCustomElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createCustomMessage(byte[] bArr, String str, byte[] bArr2) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMCustomElem tIMCustomElem = new TIMCustomElem();
        tIMCustomElem.setData(bArr);
        tIMCustomElem.setDesc(str);
        tIMCustomElem.setExt(bArr2);
        tIMMessage.addElement(tIMCustomElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createImageMessage(String str) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMImageElem tIMImageElem = new TIMImageElem();
        tIMImageElem.setPath(str);
        tIMMessage.addElement(tIMImageElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createSoundMessage(String str, int i) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMSoundElem tIMSoundElem = new TIMSoundElem();
        if (i < 0) {
            i = 0;
        }
        tIMSoundElem.setDuration((long) i);
        tIMSoundElem.setPath(str);
        tIMMessage.addElement(tIMSoundElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createVideoMessage(String str, String str2, int i, String str3) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMVideoElem tIMVideoElem = new TIMVideoElem();
        TIMVideo tIMVideo = new TIMVideo();
        if (i < 0) {
            i = 0;
        }
        tIMVideo.setType(str2);
        tIMVideo.setDuaration((long) i);
        tIMVideoElem.setVideo(tIMVideo);
        tIMVideoElem.setSnapshot(new TIMSnapshot());
        tIMVideoElem.setSnapshotPath(str3);
        tIMVideoElem.setVideoPath(str);
        tIMMessage.addElement(tIMVideoElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createFileMessage(String str, String str2) {
        if (!new File(str).exists()) {
            return null;
        }
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMFileElem tIMFileElem = new TIMFileElem();
        tIMFileElem.setPath(str);
        tIMFileElem.setFileName(str2);
        tIMMessage.addElement(tIMFileElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createLocationMessage(String str, double d, double d2) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMLocationElem tIMLocationElem = new TIMLocationElem();
        tIMLocationElem.setDesc(str);
        tIMLocationElem.setLongitude(d);
        tIMLocationElem.setLatitude(d2);
        tIMMessage.addElement(tIMLocationElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createFaceMessage(int i, byte[] bArr) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setCanReadMsgID(false);
        TIMMessage tIMMessage = new TIMMessage();
        TIMFaceElem tIMFaceElem = new TIMFaceElem();
        tIMFaceElem.setIndex(i);
        tIMFaceElem.setData(bArr);
        tIMMessage.addElement(tIMFaceElem);
        v2TIMMessage.setTIMMessage(tIMMessage);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String sendMessage(V2TIMMessage v2TIMMessage, String str, String str2, int i, boolean z, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback) {
        TIMConversation tIMConversation = null;
        if (v2TIMMessage == null) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(6017, "message is null!");
            }
            return null;
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(6017, "receiver and groupID cannot be empty at the same time!");
            }
            return null;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str)) {
                tIMConversation = TIMManager.getInstance().getConversation(TIMConversationType.C2C, str);
            } else if (!TextUtils.isEmpty(str2)) {
                tIMConversation = TIMManager.getInstance().getConversation(TIMConversationType.Group, str2);
                TIMMessage tIMMessage = v2TIMMessage.getTIMMessage();
                if (i == 1) {
                    tIMMessage.setPriority(TIMMessagePriority.High);
                } else if (i == 3) {
                    tIMMessage.setPriority(TIMMessagePriority.Low);
                }
            }
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(tIMConversation);
            if (v2TIMOfflinePushInfo != null) {
                v2TIMMessage.setOfflinePushInfo(v2TIMOfflinePushInfo);
            }
            if (z) {
                return v2TIMConversation.sendMessage(v2TIMMessage, 1, v2TIMSendCallback);
            }
            return v2TIMConversation.sendMessage(v2TIMMessage, 0, v2TIMSendCallback);
        } else {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(6017, "receiver and groupID cannot set at the same time!");
            }
            return null;
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getC2CHistoryMessageList(String str, int i, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && i != 0) {
            TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.C2C, str);
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(conversation);
            v2TIMConversation.getC2CHistoryMessageList(i, v2TIMMessage, v2TIMValueCallback);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "userID is empty or count is 0");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getGroupHistoryMessageList(final String str, final int i, final V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && i != 0) {
            GroupBaseManager.getInstance().getGroupsType(str, new GroupBaseManager.GroupTypeCallback() {
                /* class com.tencent.imsdk.v2.V2TIMMessageManagerImpl.AnonymousClass1 */

                @Override // com.tencent.imsdk.group.GroupBaseManager.GroupTypeCallback
                public void onGetGroupType(String str) {
                    TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.Group, str);
                    V2TIMConversation v2TIMConversation = new V2TIMConversation();
                    v2TIMConversation.setTIMConversation(conversation);
                    v2TIMConversation.getGroupHistoryMessageList(i, v2TIMMessage, v2TIMValueCallback);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "groupID is empty or count is 0");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b  */
    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getHistoryMessageList(V2TIMMessageListGetOption v2TIMMessageListGetOption, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        boolean z;
        TIMConversation tIMConversation;
        if (v2TIMMessageListGetOption == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "option is null");
            }
        } else if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) || !TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
            if (TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) || TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
                if (v2TIMMessageListGetOption.getCount() > 0) {
                    int getType = v2TIMMessageListGetOption.getGetType();
                    boolean z2 = true;
                    if (getType != 1) {
                        if (getType != 2) {
                            if (getType == 3) {
                                z2 = false;
                            } else if (getType == 4) {
                                z2 = false;
                            } else if (v2TIMValueCallback != null) {
                                v2TIMValueCallback.onError(6017, "getType is invalid");
                                return;
                            } else {
                                return;
                            }
                        }
                        z = true;
                        if (TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID())) {
                            tIMConversation = TIMManager.getInstance().getConversation(TIMConversationType.C2C, v2TIMMessageListGetOption.getUserID());
                        } else {
                            tIMConversation = TIMManager.getInstance().getConversation(TIMConversationType.Group, v2TIMMessageListGetOption.getGroupID());
                        }
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setTIMConversation(tIMConversation);
                        v2TIMConversation.getMessageList(v2TIMMessageListGetOption.getCount(), z2, z, v2TIMMessageListGetOption.getLastMsg(), v2TIMValueCallback);
                    }
                    z = false;
                    if (TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID())) {
                    }
                    V2TIMConversation v2TIMConversation = new V2TIMConversation();
                    v2TIMConversation.setTIMConversation(tIMConversation);
                    v2TIMConversation.getMessageList(v2TIMMessageListGetOption.getCount(), z2, z, v2TIMMessageListGetOption.getLastMsg(), v2TIMValueCallback);
                } else if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(6017, "count less than 0");
                }
            } else if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID and userID cannot set at the same time");
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "groupID and userID cannot be null at the same time");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void revokeMessage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage != null) {
            V2TIMConversation conversation = v2TIMMessage.getConversation();
            if (conversation != null) {
                conversation.revokeMessage(v2TIMMessage, v2TIMCallback);
            } else if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "msg getConversation is null");
            }
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "msg is null");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void markC2CMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.C2C, str);
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(conversation);
            v2TIMConversation.setMessageRead(null, v2TIMCallback);
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "userID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void markGroupMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.Group, str);
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(conversation);
            v2TIMConversation.setMessageRead(null, v2TIMCallback);
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "groupID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void deleteMessageFromLocalStorage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "message is null");
            }
        } else if (v2TIMMessage.getTIMMessage() == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "message is invalid");
            }
        } else if (v2TIMMessage.getTIMMessage().remove()) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "delete message failed");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String insertC2CMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "message is null");
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "sender is empty");
            }
            return "";
        } else {
            TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.C2C, str);
            v2TIMMessage.setSender(str2);
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(conversation);
            return v2TIMConversation.insertMessageToLocalStorage(v2TIMMessage, v2TIMValueCallback);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String insertGroupMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "message is null");
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID is empty");
            }
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "sender is empty");
            }
            return "";
        } else {
            TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.Group, str);
            v2TIMMessage.setSender(str2);
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(conversation);
            return v2TIMConversation.insertMessageToLocalStorage(v2TIMMessage, v2TIMValueCallback);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void deleteMessages(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            V2TIMConversation conversation = list.get(0).getConversation();
            if (conversation != null && !TextUtils.isEmpty(conversation.getConversationID())) {
                for (V2TIMMessage v2TIMMessage : list) {
                    if (v2TIMMessage.getTIMMessage() != null) {
                        if (v2TIMMessage.getConversation() == null || !TextUtils.equals(conversation.getConversationID(), v2TIMMessage.getConversation().getConversationID())) {
                            if (v2TIMCallback != null) {
                                v2TIMCallback.onError(6017, "messages must is the same conversation");
                                return;
                            }
                            return;
                        }
                        while (r2.hasNext()) {
                        }
                    } else if (v2TIMCallback != null) {
                        v2TIMCallback.onError(6017, "list messages has invalid item");
                        return;
                    } else {
                        return;
                    }
                }
                conversation.deleteMessages(list, v2TIMCallback);
            } else if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "the conversation in message is empty");
            }
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "messages is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void findMessages(List<String> list, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (list != null && !list.isEmpty()) {
            TIMManagerExt.getInstance().findMessageByMessageID(list, new TIMValueCallBack<List<TIMMessage>>() {
                /* class com.tencent.imsdk.v2.V2TIMMessageManagerImpl.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(List<TIMMessage> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TIMMessage tIMMessage : list) {
                            V2TIMMessage v2TIMMessage = new V2TIMMessage();
                            v2TIMMessage.setTIMMessage(tIMMessage);
                            arrayList.add(v2TIMMessage);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "messages is empty");
        }
    }
}
