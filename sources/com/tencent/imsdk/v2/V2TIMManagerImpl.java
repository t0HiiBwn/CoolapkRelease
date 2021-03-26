package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.IMBridge;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConnListener;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMCustomElem;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupSystemElem;
import com.tencent.imsdk.TIMGroupSystemElemType;
import com.tencent.imsdk.TIMGroupTipsElem;
import com.tencent.imsdk.TIMGroupTipsElemGroupInfo;
import com.tencent.imsdk.TIMGroupTipsElemMemberInfo;
import com.tencent.imsdk.TIMGroupTipsGroupInfoType;
import com.tencent.imsdk.TIMGroupTipsType;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageListener;
import com.tencent.imsdk.TIMMessagePriority;
import com.tencent.imsdk.TIMProfileSystemElem;
import com.tencent.imsdk.TIMSNSChangeInfo;
import com.tencent.imsdk.TIMSNSSystemElem;
import com.tencent.imsdk.TIMSdkConfig;
import com.tencent.imsdk.TIMTextElem;
import com.tencent.imsdk.TIMUploadProgressListener;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMUserStatusListener;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.ext.message.TIMMessageReceipt;
import com.tencent.imsdk.ext.message.TIMMessageReceiptListener;
import com.tencent.imsdk.ext.message.TIMMessageRevokedListener;
import com.tencent.imsdk.friendship.FriendshipNativeManager;
import com.tencent.imsdk.friendship.TIMFriend;
import com.tencent.imsdk.friendship.TIMFriendPendencyInfo;
import com.tencent.imsdk.group.GroupBaseManager;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class V2TIMManagerImpl extends V2TIMManager {
    private static final String TAG = "V2TIMManagerImpl";
    private TIMManager mManager = TIMManager.getInstance();
    private TIMMessageListener mV1TIMMessageListener;
    private V2TIMGroupListener mV2TIMGroupListener;
    V2TIMSDKListener mV2TIMSDKListener;
    private HashMap<String, V2TIMSendCallback> mV2TIMSendCallbackMap = new HashMap<>();
    private CopyOnWriteArrayList<V2TIMSimpleMsgListener> mV2TIMSimpleMsgListenerList = new CopyOnWriteArrayList<>();

    private static class V2TIMManagerImplHolder {
        private static final V2TIMManagerImpl v2TIMManagerImpl = new V2TIMManagerImpl();

        private V2TIMManagerImplHolder() {
        }
    }

    public static V2TIMManagerImpl getInstance() {
        return V2TIMManagerImplHolder.v2TIMManagerImpl;
    }

    protected V2TIMManagerImpl() {
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener) {
        if (context == null) {
            QLog.e("V2TIMManagerImpl", "init fail, context is null");
            return false;
        }
        if (v2TIMSDKConfig == null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
        }
        this.mV2TIMSDKListener = v2TIMSDKListener;
        TIMSdkConfig initV1SDKConfig = v2TIMSDKConfig.initV1SDKConfig(i);
        TIMUserConfig tIMUserConfig = new TIMUserConfig();
        tIMUserConfig.disableAutoReport(true);
        tIMUserConfig.enableReadReceipt(true);
        this.mManager.setUserConfig(tIMUserConfig);
        initInternalListener(tIMUserConfig);
        BaseManager.getInstance().setV2Api();
        return this.mManager.init(context, initV1SDKConfig);
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unInitSDK() {
        TIMManager.getInstance().removeMessageListener(this.mV1TIMMessageListener);
        this.mManager.unInit();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getVersion() {
        return this.mManager.getVersion();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public long getServerTime() {
        return TIMManager.getInstance().getServerTime();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void login(final String str, final String str2, final V2TIMCallback v2TIMCallback) {
        QLog.i("V2TIMManagerImpl", "login : userID = " + str);
        if (v2TIMCallback == null) {
            QLog.e("V2TIMManagerImpl", "login callback is null!");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            QLog.e("V2TIMManagerImpl", "userSig is empty");
            v2TIMCallback.onError(6017, "userID or userSig is empty");
        } else {
            BaseManager.getInstance().login(str, str2, true, new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass1 */

                @Override // com.tencent.imsdk.TIMCallBack
                public void onError(int i, String str) {
                    if (i == 6208) {
                        QLog.i("V2TIMManagerImpl", "offline kicked by other, login again");
                        V2TIMManagerImpl.this.login(str, str2, v2TIMCallback);
                        return;
                    }
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.TIMCallBack
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
            V2TIMConversationManagerImpl.getInstance().conversationIDMap.clear();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void logout(final V2TIMCallback v2TIMCallback) {
        QLog.i("V2TIMManagerImpl", "logout: userID=" + getLoginUser());
        this.mManager.logout(new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass2 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
        V2TIMConversationManagerImpl.getInstance().conversationIDMap.clear();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getLoginUser() {
        return this.mManager.getLoginUser();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public int getLoginStatus() {
        return this.mManager.getLoginStatus();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener != null) {
            synchronized (this) {
                if (!this.mV2TIMSimpleMsgListenerList.contains(v2TIMSimpleMsgListener)) {
                    this.mV2TIMSimpleMsgListenerList.add(v2TIMSimpleMsgListener);
                }
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        synchronized (this) {
            this.mV2TIMSimpleMsgListenerList.remove(v2TIMSimpleMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CTextMessage(String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "text is null");
            }
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return null;
        } else {
            V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
            TIMManager.getInstance().getConversation(TIMConversationType.C2C, str2).sendMessage(createTextMessage.getTIMMessage(), new TIMValueCallBack<TIMMessage>() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass3 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(TIMMessage tIMMessage) {
                    if (v2TIMValueCallback != null) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setTIMMessage(tIMMessage);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            createTextMessage.setCanReadMsgID(true);
            return createTextMessage.getMsgID();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CCustomMessage(byte[] bArr, String str, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "customData is null");
            }
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return null;
        } else {
            V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
            TIMManager.getInstance().getConversation(TIMConversationType.C2C, str).sendMessage(createCustomMessage.getTIMMessage(), new TIMValueCallBack<TIMMessage>() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass4 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(TIMMessage tIMMessage) {
                    if (v2TIMValueCallback != null) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setTIMMessage(tIMMessage);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            createCustomMessage.setCanReadMsgID(true);
            return createCustomMessage.getMsgID();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupTextMessage(String str, String str2, int i, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback == null) {
                return null;
            }
            v2TIMValueCallback.onError(6017, "text is null");
            return null;
        } else if (!TextUtils.isEmpty(str2)) {
            V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
            if (i == 1) {
                createTextMessage.getTIMMessage().setPriority(TIMMessagePriority.High);
            } else if (i == 3) {
                createTextMessage.getTIMMessage().setPriority(TIMMessagePriority.Low);
            }
            TIMManager.getInstance().getConversation(TIMConversationType.Group, str2).sendMessage(createTextMessage.getTIMMessage(), new TIMValueCallBack<TIMMessage>() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass5 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(TIMMessage tIMMessage) {
                    if (v2TIMValueCallback != null) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setTIMMessage(tIMMessage);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            createTextMessage.setCanReadMsgID(true);
            return createTextMessage.getMsgID();
        } else if (v2TIMValueCallback == null) {
            return "";
        } else {
            v2TIMValueCallback.onError(6017, "groupID is empty");
            return "";
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupCustomMessage(byte[] bArr, String str, int i, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback == null) {
                return null;
            }
            v2TIMValueCallback.onError(6017, "customData is null");
            return null;
        } else if (!TextUtils.isEmpty(str)) {
            V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
            if (i == 1) {
                createCustomMessage.getTIMMessage().setPriority(TIMMessagePriority.High);
            } else if (i == 3) {
                createCustomMessage.getTIMMessage().setPriority(TIMMessagePriority.Low);
            }
            TIMManager.getInstance().getConversation(TIMConversationType.Group, str).sendMessage(createCustomMessage.getTIMMessage(), new TIMValueCallBack<TIMMessage>() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass6 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(TIMMessage tIMMessage) {
                    if (v2TIMValueCallback != null) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setTIMMessage(tIMMessage);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            createCustomMessage.setCanReadMsgID(true);
            return createCustomMessage.getMsgID();
        } else if (v2TIMValueCallback == null) {
            return "";
        } else {
            v2TIMValueCallback.onError(6017, "groupID is empty");
            return "";
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setGroupListener(V2TIMGroupListener v2TIMGroupListener) {
        this.mV2TIMGroupListener = v2TIMGroupListener;
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void createGroup(String str, String str2, String str3, final V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupType is empty");
            }
        } else if (!TextUtils.isEmpty(str3)) {
            if (!str.equalsIgnoreCase("Work")) {
                if (!str.equalsIgnoreCase("Meeting")) {
                    if (!str.equalsIgnoreCase("Private")) {
                        if (!str.equalsIgnoreCase("ChatRoom")) {
                            if (str.equalsIgnoreCase("Public")) {
                                str = "Public";
                            } else if (str.equalsIgnoreCase("AVChatRoom")) {
                                str = "AVChatRoom";
                            }
                            TIMGroupManager.CreateGroupParam createGroupParam = new TIMGroupManager.CreateGroupParam(str, str3);
                            createGroupParam.setGroupId(str2);
                            TIMGroupManager.getInstance().createGroup(createGroupParam, new TIMValueCallBack<String>() {
                                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass7 */

                                @Override // com.tencent.imsdk.TIMValueCallBack
                                public void onError(int i, String str) {
                                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                                    if (v2TIMValueCallback != null) {
                                        v2TIMValueCallback.onError(i, str);
                                    }
                                }

                                public void onSuccess(String str) {
                                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                                    if (v2TIMValueCallback != null) {
                                        v2TIMValueCallback.onSuccess(str);
                                    }
                                }
                            });
                        }
                    }
                }
                str = "ChatRoom";
                TIMGroupManager.CreateGroupParam createGroupParam = new TIMGroupManager.CreateGroupParam(str, str3);
                createGroupParam.setGroupId(str2);
                TIMGroupManager.getInstance().createGroup(createGroupParam, new TIMValueCallBack<String>() {
                    /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass7 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(i, str);
                        }
                    }

                    public void onSuccess(String str) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(str);
                        }
                    }
                });
            }
            str = "Private";
            TIMGroupManager.CreateGroupParam createGroupParam = new TIMGroupManager.CreateGroupParam(str, str3);
            createGroupParam.setGroupId(str2);
            TIMGroupManager.getInstance().createGroup(createGroupParam, new TIMValueCallBack<String>() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass7 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(str);
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "groupName is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void joinGroup(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMManagerImpl", "joinGroup fail, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        TIMGroupManager.getInstance().applyJoinGroup(str, str2, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass8 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void quitGroup(String str, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMManagerImpl", "quitGroup fail, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        TIMGroupManager.getInstance().quitGroup(str, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass9 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void dismissGroup(String str, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMManagerImpl", "dismissGroup fail, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        TIMGroupManager.getInstance().deleteGroup(str, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass10 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void getUsersInfo(List<String> list, final V2TIMValueCallback<List<V2TIMUserFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() > 0) {
            TIMFriendshipManager.getInstance().getUsersProfile(list, true, new TIMValueCallBack<List<TIMUserProfile>>() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass11 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(List<TIMUserProfile> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TIMUserProfile tIMUserProfile : list) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setTIMUserProfile(tIMUserProfile);
                            arrayList.add(v2TIMUserFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "userIDList is null");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo, final V2TIMCallback v2TIMCallback) {
        if (v2TIMUserFullInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "v2TIMUserProfile is null");
            }
        } else if (!TextUtils.isEmpty(TIMManager.getInstance().getLoginUser())) {
            TIMFriendshipManager.getInstance().modifySelfProfile(v2TIMUserFullInfo.getModifyProfileMap(), new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass12 */

                @Override // com.tencent.imsdk.TIMCallBack
                public void onError(int i, String str) {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.TIMCallBack
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "not login");
        }
    }

    private void initInternalListener(TIMUserConfig tIMUserConfig) {
        if (this.mV1TIMMessageListener == null) {
            this.mV1TIMMessageListener = new TIMMessageListener() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass13 */

                @Override // com.tencent.imsdk.TIMMessageListener
                public boolean onNewMessages(List<TIMMessage> list) {
                    if (list.size() > 0) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setTIMMessage(list.get(0));
                        V2TIMSignalingInfo processSignalingMessage = V2TIMSignalingManagerImpl.getInstance().processSignalingMessage(v2TIMMessage);
                        if (processSignalingMessage != null && processSignalingMessage.isOnlineUserOnly()) {
                            return false;
                        }
                        V2TIMManagerImpl.this.onRecvNewMessage(v2TIMMessage);
                    }
                    return false;
                }
            };
        }
        TIMManager.getInstance().addMessageListener(this.mV1TIMMessageListener);
        GroupBaseManager.getInstance().setGroupInternalListener(new GroupBaseManager.GroupInternalListener() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass14 */

            @Override // com.tencent.imsdk.group.GroupBaseManager.GroupInternalListener
            public void onRecvGroup0x38TipsMessage(Msg msg) {
                final TIMMessage convertMsgToTIMMessage = IMBridge.convertMsgToTIMMessage(msg);
                if (convertMsgToTIMMessage != null && convertMsgToTIMMessage.getElementCount() != 0 && convertMsgToTIMMessage.getElementCount() <= 1) {
                    TIMElem element = convertMsgToTIMMessage.getElement(0);
                    if (element instanceof TIMGroupTipsElem) {
                        TIMGroupTipsElem tIMGroupTipsElem = (TIMGroupTipsElem) element;
                        V2TIMManagerImpl.this.processGroupTipsElem(tIMGroupTipsElem);
                        if (tIMGroupTipsElem.getTipsType() == TIMGroupTipsType.ModifyGroupInfo && tIMGroupTipsElem.getGroupInfoList().size() != 0 && tIMGroupTipsElem.getGroupInfoList().size() <= 1 && tIMGroupTipsElem.getGroupInfoList().get(0).getType() == TIMGroupTipsGroupInfoType.ModifyCustom) {
                            IMContext.getInstance().runOnMainThread(new Runnable() {
                                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass14.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    synchronized (V2TIMMessageManagerImpl.getInstance()) {
                                        Iterator<V2TIMAdvancedMsgListener> it2 = V2TIMMessageManagerImpl.getInstance().mV2TIMMsgListenerList.iterator();
                                        while (it2.hasNext()) {
                                            V2TIMMessage v2TIMMessage = new V2TIMMessage();
                                            v2TIMMessage.setTIMMessage(convertMsgToTIMMessage);
                                            it2.next().onRecvNewMessage(v2TIMMessage);
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.group.GroupBaseManager.GroupInternalListener
            public void onRecvGroupAttribute(String str, Map<String, String> map) {
                if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mV2TIMGroupListener.onGroupAttributeChanged(str, map);
                }
            }
        });
        tIMUserConfig.setUserStatusListener(new TIMUserStatusListener() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass15 */

            @Override // com.tencent.imsdk.TIMUserStatusListener
            public void onForceOffline() {
                if (V2TIMManagerImpl.this.mV2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mV2TIMSDKListener.onKickedOffline();
                }
            }

            @Override // com.tencent.imsdk.TIMUserStatusListener
            public void onUserSigExpired() {
                if (V2TIMManagerImpl.this.mV2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mV2TIMSDKListener.onUserSigExpired();
                }
            }
        });
        tIMUserConfig.setConnectionListener(new TIMConnListener() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass16 */

            @Override // com.tencent.imsdk.TIMConnListener
            public void onWifiNeedAuth(String str) {
            }

            @Override // com.tencent.imsdk.TIMConnListener
            public void onConnected() {
                if (V2TIMManagerImpl.this.mV2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mV2TIMSDKListener.onConnectSuccess();
                }
            }

            @Override // com.tencent.imsdk.TIMConnListener
            public void onDisconnected(int i, String str) {
                if (V2TIMManagerImpl.this.mV2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mV2TIMSDKListener.onConnectFailed(i, str);
                }
            }
        });
        tIMUserConfig.setMessageReceiptListener(new TIMMessageReceiptListener() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass17 */

            @Override // com.tencent.imsdk.ext.message.TIMMessageReceiptListener
            public void onRecvReceipt(List<TIMMessageReceipt> list) {
                ArrayList arrayList = new ArrayList();
                for (TIMMessageReceipt tIMMessageReceipt : list) {
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setTimMessageReceipt(tIMMessageReceipt);
                    arrayList.add(v2TIMMessageReceipt);
                }
                synchronized (V2TIMMessageManagerImpl.getInstance()) {
                    Iterator<V2TIMAdvancedMsgListener> it2 = V2TIMMessageManagerImpl.getInstance().mV2TIMMsgListenerList.iterator();
                    while (it2.hasNext()) {
                        it2.next().onRecvC2CReadReceipt(arrayList);
                    }
                }
            }
        });
        tIMUserConfig.setMessageRevokedListener(new TIMMessageRevokedListener() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass18 */

            @Override // com.tencent.imsdk.ext.message.TIMMessageRevokedListener
            public void onMessageRevoked(TIMMessageLocator tIMMessageLocator) {
                synchronized (V2TIMMessageManagerImpl.getInstance()) {
                    String msgID = tIMMessageLocator.getMsgID();
                    Iterator<V2TIMAdvancedMsgListener> it2 = V2TIMMessageManagerImpl.getInstance().mV2TIMMsgListenerList.iterator();
                    while (it2.hasNext()) {
                        it2.next().onRecvMessageRevoked(msgID);
                    }
                }
            }
        });
        tIMUserConfig.setUploadProgressListener(new TIMUploadProgressListener() {
            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass19 */

            @Override // com.tencent.imsdk.TIMUploadProgressListener
            public void onMessagesUpdate(TIMMessage tIMMessage, int i, int i2, int i3) {
                synchronized (V2TIMManagerImpl.this) {
                    V2TIMSendCallback v2TIMSendCallback = (V2TIMSendCallback) V2TIMManagerImpl.this.mV2TIMSendCallbackMap.get(tIMMessage.getMsgId());
                    if (v2TIMSendCallback != null) {
                        v2TIMSendCallback.onProgress(i3);
                    }
                }
            }
        });
    }

    protected void onRecvNewMessage(final V2TIMMessage v2TIMMessage) {
        TIMMessage tIMMessage = v2TIMMessage.getTIMMessage();
        String str = "";
        int elementCount = tIMMessage.getElementCount();
        for (int i = 0; i < elementCount; i++) {
            TIMElem element = tIMMessage.getElement(i);
            if (element instanceof TIMTextElem) {
                processSimpleTextElem(tIMMessage, (TIMTextElem) element);
            } else if (element instanceof TIMCustomElem) {
                processSimpleCustomElem(tIMMessage, (TIMCustomElem) element);
            } else if (element instanceof TIMGroupTipsElem) {
                TIMGroupTipsElem tIMGroupTipsElem = (TIMGroupTipsElem) element;
                processGroupTipsElem(tIMGroupTipsElem);
                str = tIMGroupTipsElem.getGroupId();
            } else if (element instanceof TIMGroupSystemElem) {
                processGroupSystemElem((TIMGroupSystemElem) element);
                return;
            } else if (element instanceof TIMSNSSystemElem) {
                processSNSSystemElem((TIMSNSSystemElem) element);
                return;
            } else if (element instanceof TIMProfileSystemElem) {
                processSystemProfileChangeElem((TIMProfileSystemElem) element);
                return;
            }
        }
        synchronized (V2TIMMessageManagerImpl.getInstance()) {
            if (!TextUtils.isEmpty(str)) {
                GroupBaseManager.getInstance().getGroupsType(str, new GroupBaseManager.GroupTypeCallback() {
                    /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass20 */

                    @Override // com.tencent.imsdk.group.GroupBaseManager.GroupTypeCallback
                    public void onGetGroupType(String str) {
                        Iterator<V2TIMAdvancedMsgListener> it2 = V2TIMMessageManagerImpl.getInstance().mV2TIMMsgListenerList.iterator();
                        while (it2.hasNext()) {
                            it2.next().onRecvNewMessage(v2TIMMessage);
                        }
                    }
                });
            } else {
                Iterator<V2TIMAdvancedMsgListener> it2 = V2TIMMessageManagerImpl.getInstance().mV2TIMMsgListenerList.iterator();
                while (it2.hasNext()) {
                    it2.next().onRecvNewMessage(v2TIMMessage);
                }
            }
        }
    }

    protected void addSendCallback(String str, V2TIMSendCallback v2TIMSendCallback) {
        synchronized (this) {
            this.mV2TIMSendCallbackMap.put(str, v2TIMSendCallback);
        }
    }

    protected void removeSendCallback(String str) {
        synchronized (this) {
            this.mV2TIMSendCallbackMap.remove(str);
        }
    }

    /* access modifiers changed from: private */
    public void processGroupTipsElem(TIMGroupTipsElem tIMGroupTipsElem) {
        final String groupId = tIMGroupTipsElem.getGroupId();
        TIMGroupTipsType tipsType = tIMGroupTipsElem.getTipsType();
        QLog.i("V2TIMManagerImpl", "processGroupTipsElem tipsType:" + tipsType);
        if (!TextUtils.isEmpty(groupId)) {
            final V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
            v2TIMGroupMemberInfo.setTimUserProfile(tIMGroupTipsElem.getOpUserInfo());
            v2TIMGroupMemberInfo.setTimGroupMemberInfo(tIMGroupTipsElem.getOpGroupMemberInfo());
            final ArrayList arrayList = new ArrayList();
            for (TIMUserProfile tIMUserProfile : tIMGroupTipsElem.getChangedUserInfo().values()) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo2 = new V2TIMGroupMemberInfo();
                v2TIMGroupMemberInfo2.setTimUserProfile(tIMUserProfile);
                arrayList.add(v2TIMGroupMemberInfo2);
            }
            if (arrayList.size() > 0) {
                for (TIMGroupMemberInfo tIMGroupMemberInfo : tIMGroupTipsElem.getChangedGroupMemberInfo().values()) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        V2TIMGroupMemberInfo v2TIMGroupMemberInfo3 = (V2TIMGroupMemberInfo) it2.next();
                        if (v2TIMGroupMemberInfo3.getTimUserProfile().getIdentifier().equals(tIMGroupMemberInfo.getUser())) {
                            v2TIMGroupMemberInfo3.setTimGroupMemberInfo(tIMGroupMemberInfo);
                            break;
                        }
                    }
                }
            }
            if (tipsType == TIMGroupTipsType.Join) {
                GroupBaseManager.getInstance().getGroupsType(groupId, new GroupBaseManager.GroupTypeCallback() {
                    /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass21 */

                    @Override // com.tencent.imsdk.group.GroupBaseManager.GroupTypeCallback
                    public void onGetGroupType(String str) {
                        int i = 0;
                        while (true) {
                            if (i >= arrayList.size()) {
                                break;
                            } else if (((V2TIMGroupMemberInfo) arrayList.get(i)).getUserID().equals(TIMManager.getInstance().getLoginUser())) {
                                arrayList.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (arrayList.size() != 0) {
                            if ("Private".equals(str)) {
                                if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                                    V2TIMManagerImpl.this.mV2TIMGroupListener.onMemberInvited(groupId, v2TIMGroupMemberInfo, arrayList);
                                }
                            } else if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                                V2TIMManagerImpl.this.mV2TIMGroupListener.onMemberEnter(groupId, arrayList);
                            }
                        }
                    }
                });
            } else if (tipsType == TIMGroupTipsType.Quit) {
                V2TIMGroupListener v2TIMGroupListener = this.mV2TIMGroupListener;
                if (v2TIMGroupListener != null) {
                    v2TIMGroupListener.onMemberLeave(groupId, v2TIMGroupMemberInfo);
                }
            } else if (tipsType == TIMGroupTipsType.Kick) {
                V2TIMGroupListener v2TIMGroupListener2 = this.mV2TIMGroupListener;
                if (v2TIMGroupListener2 != null) {
                    v2TIMGroupListener2.onMemberKicked(groupId, v2TIMGroupMemberInfo, arrayList);
                }
            } else if (tipsType == TIMGroupTipsType.SetAdmin) {
                V2TIMGroupListener v2TIMGroupListener3 = this.mV2TIMGroupListener;
                if (v2TIMGroupListener3 != null) {
                    v2TIMGroupListener3.onGrantAdministrator(groupId, v2TIMGroupMemberInfo, arrayList);
                }
            } else if (tipsType == TIMGroupTipsType.CancelAdmin) {
                V2TIMGroupListener v2TIMGroupListener4 = this.mV2TIMGroupListener;
                if (v2TIMGroupListener4 != null) {
                    v2TIMGroupListener4.onRevokeAdministrator(groupId, v2TIMGroupMemberInfo, arrayList);
                }
            } else if (tipsType == TIMGroupTipsType.ModifyGroupInfo) {
                if (this.mV2TIMGroupListener != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (TIMGroupTipsElemGroupInfo tIMGroupTipsElemGroupInfo : tIMGroupTipsElem.getGroupInfoList()) {
                        V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
                        v2TIMGroupChangeInfo.setTIMGroupTipsElemGroupInfo(tIMGroupTipsElemGroupInfo);
                        arrayList2.add(v2TIMGroupChangeInfo);
                    }
                    this.mV2TIMGroupListener.onGroupInfoChanged(groupId, arrayList2);
                }
            } else if (tipsType == TIMGroupTipsType.ModifyMemberInfo && this.mV2TIMGroupListener != null) {
                ArrayList arrayList3 = new ArrayList();
                for (TIMGroupTipsElemMemberInfo tIMGroupTipsElemMemberInfo : tIMGroupTipsElem.getMemberInfoList()) {
                    V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
                    v2TIMGroupMemberChangeInfo.setTIMGroupTipsElemMemberInfo(tIMGroupTipsElemMemberInfo);
                    arrayList3.add(v2TIMGroupMemberChangeInfo);
                }
                this.mV2TIMGroupListener.onMemberInfoChanged(groupId, arrayList3);
            }
        }
    }

    private void processGroupSystemElem(TIMGroupSystemElem tIMGroupSystemElem) {
        final String groupId = tIMGroupSystemElem.getGroupId();
        final V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
        v2TIMGroupMemberInfo.setTimUserProfile(tIMGroupSystemElem.getOpUserInfo());
        v2TIMGroupMemberInfo.setTimGroupMemberInfo(tIMGroupSystemElem.getOpGroupMemberInfo());
        QLog.i("V2TIMManagerImpl", "processGroupSystemElem subtpye:" + tIMGroupSystemElem.getSubtype());
        int i = AnonymousClass29.$SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[tIMGroupSystemElem.getSubtype().ordinal()];
        if (i != 12) {
            switch (i) {
                case 1:
                    if (this.mV2TIMGroupListener != null) {
                        V2TIMGroupMemberInfo v2TIMGroupMemberInfo2 = new V2TIMGroupMemberInfo();
                        TIMUserProfile querySelfProfile = TIMFriendshipManager.getInstance().querySelfProfile();
                        if (querySelfProfile == null) {
                            querySelfProfile = new TIMUserProfile();
                            querySelfProfile.setIdentifier(TIMManager.getInstance().getLoginUser());
                        }
                        v2TIMGroupMemberInfo2.setTimUserProfile(querySelfProfile);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(v2TIMGroupMemberInfo2);
                        this.mV2TIMGroupListener.onMemberKicked(groupId, v2TIMGroupMemberInfo, arrayList);
                        return;
                    }
                    return;
                case 2:
                    V2TIMGroupListener v2TIMGroupListener = this.mV2TIMGroupListener;
                    if (v2TIMGroupListener != null) {
                        v2TIMGroupListener.onGroupDismissed(groupId, v2TIMGroupMemberInfo);
                        return;
                    }
                    return;
                case 3:
                    V2TIMGroupListener v2TIMGroupListener2 = this.mV2TIMGroupListener;
                    if (v2TIMGroupListener2 != null) {
                        v2TIMGroupListener2.onGroupCreated(groupId);
                        return;
                    }
                    return;
                case 4:
                    if (this.mV2TIMGroupListener != null) {
                        GroupBaseManager.getInstance().getGroupsType(groupId, new GroupBaseManager.GroupTypeCallback() {
                            /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass22 */

                            @Override // com.tencent.imsdk.group.GroupBaseManager.GroupTypeCallback
                            public void onGetGroupType(String str) {
                                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                                TIMUserProfile querySelfProfile = TIMFriendshipManager.getInstance().querySelfProfile();
                                if (querySelfProfile == null) {
                                    querySelfProfile = new TIMUserProfile();
                                    querySelfProfile.setIdentifier(TIMManager.getInstance().getLoginUser());
                                }
                                v2TIMGroupMemberInfo.setTimUserProfile(querySelfProfile);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(v2TIMGroupMemberInfo);
                                if ("Private".equals(str)) {
                                    if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                                        V2TIMManagerImpl.this.mV2TIMGroupListener.onMemberInvited(groupId, v2TIMGroupMemberInfo, arrayList);
                                    }
                                } else if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                                    V2TIMManagerImpl.this.mV2TIMGroupListener.onMemberEnter(groupId, arrayList);
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 5:
                    V2TIMGroupListener v2TIMGroupListener3 = this.mV2TIMGroupListener;
                    if (v2TIMGroupListener3 != null) {
                        v2TIMGroupListener3.onGroupRecycled(groupId, v2TIMGroupMemberInfo);
                        return;
                    }
                    return;
                case 6:
                    V2TIMGroupListener v2TIMGroupListener4 = this.mV2TIMGroupListener;
                    if (v2TIMGroupListener4 != null) {
                        v2TIMGroupListener4.onReceiveJoinApplication(groupId, v2TIMGroupMemberInfo, tIMGroupSystemElem.getOpReason());
                        return;
                    }
                    return;
                case 7:
                    V2TIMGroupListener v2TIMGroupListener5 = this.mV2TIMGroupListener;
                    if (v2TIMGroupListener5 != null) {
                        v2TIMGroupListener5.onApplicationProcessed(groupId, v2TIMGroupMemberInfo, true, tIMGroupSystemElem.getOpReason());
                        V2TIMGroupMemberInfo v2TIMGroupMemberInfo3 = new V2TIMGroupMemberInfo();
                        TIMUserProfile querySelfProfile2 = TIMFriendshipManager.getInstance().querySelfProfile();
                        if (querySelfProfile2 == null) {
                            querySelfProfile2 = new TIMUserProfile();
                            querySelfProfile2.setIdentifier(TIMManager.getInstance().getLoginUser());
                        }
                        v2TIMGroupMemberInfo3.setTimUserProfile(querySelfProfile2);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(v2TIMGroupMemberInfo3);
                        this.mV2TIMGroupListener.onMemberEnter(groupId, arrayList2);
                        return;
                    }
                    return;
                case 8:
                    V2TIMGroupListener v2TIMGroupListener6 = this.mV2TIMGroupListener;
                    if (v2TIMGroupListener6 != null) {
                        v2TIMGroupListener6.onApplicationProcessed(groupId, v2TIMGroupMemberInfo, false, tIMGroupSystemElem.getOpReason());
                        return;
                    }
                    return;
                case 9:
                    V2TIMGroupListener v2TIMGroupListener7 = this.mV2TIMGroupListener;
                    if (v2TIMGroupListener7 != null) {
                        v2TIMGroupListener7.onQuitFromGroup(groupId);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            V2TIMGroupListener v2TIMGroupListener8 = this.mV2TIMGroupListener;
            if (v2TIMGroupListener8 != null) {
                v2TIMGroupListener8.onReceiveRESTCustomData(groupId, tIMGroupSystemElem.getUserData());
            }
        }
    }

    /* renamed from: com.tencent.imsdk.v2.V2TIMManagerImpl$29  reason: invalid class name */
    static /* synthetic */ class AnonymousClass29 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType;

        static {
            int[] iArr = new int[TIMGroupSystemElemType.values().length];
            $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType = iArr;
            try {
                iArr[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_KICK_OFF_FROM_GROUP_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_DELETE_GROUP_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_CREATE_GROUP_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_INVITED_TO_GROUP_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_REVOKE_GROUP_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_ADD_GROUP_REQUEST_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_ADD_GROUP_ACCEPT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_ADD_GROUP_REFUSE_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_QUIT_GROUP_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_GRANT_ADMIN_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_CANCEL_ADMIN_TYPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMGroupSystemElemType[TIMGroupSystemElemType.TIM_GROUP_SYSTEM_CUSTOM_INFO.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private void processSystemProfileChangeElem(TIMProfileSystemElem tIMProfileSystemElem) {
        String fromUser = tIMProfileSystemElem.getFromUser();
        if (!TextUtils.isEmpty(fromUser)) {
            if (fromUser.equals(TIMManager.getInstance().getLoginUser())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(fromUser);
                getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
                    /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass23 */

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int i, String str) {
                        QLog.e("V2TIMManagerImpl", "TIMProfileSystemElem, callback get self profile error code = " + i + ", desc = " + str);
                    }

                    public void onSuccess(List<V2TIMUserFullInfo> list) {
                        if (list.size() > 0) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = list.get(0);
                            if (V2TIMManagerImpl.this.mV2TIMSDKListener != null) {
                                V2TIMManagerImpl.this.mV2TIMSDKListener.onSelfInfoUpdated(v2TIMUserFullInfo);
                            }
                        }
                    }
                });
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(fromUser);
            V2TIMFriendshipManagerImpl.getInstance().getFriendsInfo(arrayList2, new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() {
                /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass24 */

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    QLog.e("V2TIMManagerImpl", "TIMProfileSystemElem, callback getFriendsInfo error code = " + i + ", desc = " + str);
                }

                public void onSuccess(List<V2TIMFriendInfoResult> list) {
                    if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null && list.size() > 0) {
                        V2TIMFriendInfo friendInfo = list.get(0).getFriendInfo();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(friendInfo);
                        V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendInfoChanged(arrayList);
                    }
                }
            });
        }
    }

    private void processSimpleCustomElem(TIMMessage tIMMessage, TIMCustomElem tIMCustomElem) {
        if (tIMMessage.getConversation() != null) {
            if (tIMMessage.getConversation().getType() == TIMConversationType.Group) {
                String peer = tIMMessage.getConversation().getPeer();
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                v2TIMGroupMemberInfo.setMsgSenderUserID(tIMMessage.getSender());
                v2TIMGroupMemberInfo.setMsgSenderNickName(tIMMessage.getSenderNickname());
                v2TIMGroupMemberInfo.setMsgSenderFaceUrl(tIMMessage.getSenderFaceUrl());
                TIMGroupMemberInfo senderGroupMemberProfile = tIMMessage.getSenderGroupMemberProfile();
                if (senderGroupMemberProfile != null) {
                    v2TIMGroupMemberInfo.setMsgSenderNameCard(senderGroupMemberProfile.getNameCard());
                }
                synchronized (this) {
                    Iterator<V2TIMSimpleMsgListener> it2 = this.mV2TIMSimpleMsgListenerList.iterator();
                    while (it2.hasNext()) {
                        it2.next().onRecvGroupCustomMessage(tIMMessage.getMsgId(), peer, v2TIMGroupMemberInfo, tIMCustomElem.getData());
                    }
                }
            } else if (tIMMessage.getConversation().getType() == TIMConversationType.C2C) {
                V2TIMUserInfo v2TIMUserInfo = new V2TIMUserInfo();
                v2TIMUserInfo.setUserID(tIMMessage.getSender());
                v2TIMUserInfo.setNickName(tIMMessage.getSenderNickname());
                v2TIMUserInfo.setBaseFaceUrl(tIMMessage.getSenderFaceUrl());
                synchronized (this) {
                    Iterator<V2TIMSimpleMsgListener> it3 = this.mV2TIMSimpleMsgListenerList.iterator();
                    while (it3.hasNext()) {
                        it3.next().onRecvC2CCustomMessage(tIMMessage.getMsgId(), v2TIMUserInfo, tIMCustomElem.getData());
                    }
                }
            }
        }
    }

    private void processSimpleTextElem(TIMMessage tIMMessage, TIMTextElem tIMTextElem) {
        if (tIMMessage.getConversation() != null) {
            if (tIMMessage.getConversation().getType() == TIMConversationType.Group) {
                String peer = tIMMessage.getConversation().getPeer();
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                v2TIMGroupMemberInfo.setMsgSenderUserID(tIMMessage.getSender());
                v2TIMGroupMemberInfo.setMsgSenderNickName(tIMMessage.getSenderNickname());
                v2TIMGroupMemberInfo.setMsgSenderFaceUrl(tIMMessage.getSenderFaceUrl());
                TIMGroupMemberInfo senderGroupMemberProfile = tIMMessage.getSenderGroupMemberProfile();
                if (senderGroupMemberProfile != null) {
                    v2TIMGroupMemberInfo.setMsgSenderNameCard(senderGroupMemberProfile.getNameCard());
                }
                synchronized (this) {
                    Iterator<V2TIMSimpleMsgListener> it2 = this.mV2TIMSimpleMsgListenerList.iterator();
                    while (it2.hasNext()) {
                        it2.next().onRecvGroupTextMessage(tIMMessage.getMsgId(), peer, v2TIMGroupMemberInfo, tIMTextElem.getText());
                    }
                }
            } else if (tIMMessage.getConversation().getType() == TIMConversationType.C2C) {
                V2TIMUserInfo v2TIMUserInfo = new V2TIMUserInfo();
                v2TIMUserInfo.setUserID(tIMMessage.getSender());
                v2TIMUserInfo.setNickName(tIMMessage.getSenderNickname());
                v2TIMUserInfo.setBaseFaceUrl(tIMMessage.getSenderFaceUrl());
                synchronized (this) {
                    Iterator<V2TIMSimpleMsgListener> it3 = this.mV2TIMSimpleMsgListenerList.iterator();
                    while (it3.hasNext()) {
                        it3.next().onRecvC2CTextMessage(tIMMessage.getMsgId(), v2TIMUserInfo, tIMTextElem.getText());
                    }
                }
            }
        }
    }

    private void processSNSSystemElem(TIMSNSSystemElem tIMSNSSystemElem) {
        List<String> arrayList = new ArrayList<>();
        final int subType = tIMSNSSystemElem.getSubType();
        if (subType == 1) {
            arrayList = tIMSNSSystemElem.getRequestAddFriendUserList();
        } else if (subType == 5) {
            arrayList = tIMSNSSystemElem.getAddBlacklistUserList();
        } else if (subType == 8) {
            for (TIMSNSChangeInfo tIMSNSChangeInfo : tIMSNSSystemElem.getChangeInfoList()) {
                arrayList.add(tIMSNSChangeInfo.getUpdateUser());
            }
        } else if (subType == 3) {
            for (TIMFriendPendencyInfo tIMFriendPendencyInfo : tIMSNSSystemElem.getFriendAddPendencyList()) {
                arrayList.add(tIMFriendPendencyInfo.getFromUser());
            }
        }
        switch (subType) {
            case 1:
            case 8:
                V2TIMFriendshipManagerImpl.getInstance().getFriendsInfo(arrayList, new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() {
                    /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass25 */

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int i, String str) {
                        QLog.e("V2TIMManagerImpl", "processSNSSystemElem, subType = " + subType + ", getFriendsInfo error code = " + i + ", desc = " + str);
                    }

                    public void onSuccess(List<V2TIMFriendInfoResult> list) {
                        ArrayList arrayList = new ArrayList();
                        for (V2TIMFriendInfoResult v2TIMFriendInfoResult : list) {
                            arrayList.add(v2TIMFriendInfoResult.getFriendInfo());
                        }
                        int i = subType;
                        if (i == 1) {
                            if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                                V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendListAdded(arrayList);
                            }
                        } else if (i == 8 && V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                            V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendInfoChanged(arrayList);
                        }
                    }
                });
                return;
            case 2:
                if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendListDeleted(tIMSNSSystemElem.getDelRequestAddFriendUserList());
                    return;
                }
                return;
            case 3:
                List<TIMFriendPendencyInfo> friendAddPendencyList = tIMSNSSystemElem.getFriendAddPendencyList();
                final ArrayList arrayList2 = new ArrayList();
                for (TIMFriendPendencyInfo tIMFriendPendencyInfo2 : friendAddPendencyList) {
                    V2TIMFriendApplication v2TIMFriendApplication = new V2TIMFriendApplication();
                    v2TIMFriendApplication.setTIMFriendPendencyInfo(tIMFriendPendencyInfo2);
                    arrayList2.add(v2TIMFriendApplication);
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add("Tag_Profile_IM_Image");
                FriendshipNativeManager.nativeGetUsersProfile(arrayList, true, arrayList3, new ICallback(new TIMValueCallBack<List<TIMUserProfile>>() {
                    /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass27 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        QLog.e("V2TIMManagerImpl", "TIM_SNS_SYSTEM_ADD_FRIEND_REQ->GetUsersProfile error = " + i + ", desc = " + str);
                        if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                            V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendApplicationListAdded(arrayList2);
                        }
                    }

                    public void onSuccess(List<TIMUserProfile> list) {
                        for (V2TIMFriendApplication v2TIMFriendApplication : arrayList2) {
                            for (TIMUserProfile tIMUserProfile : list) {
                                if (v2TIMFriendApplication.getUserID().equals(tIMUserProfile.getIdentifier())) {
                                    v2TIMFriendApplication.setTIMUserProfile(tIMUserProfile);
                                }
                            }
                        }
                        if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                            V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendApplicationListAdded(arrayList2);
                        }
                    }
                }) {
                    /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass28 */

                    @Override // com.tencent.imsdk.common.ICallback
                    public void done(Object obj) {
                        super.done(obj);
                    }

                    @Override // com.tencent.imsdk.common.ICallback
                    public void fail(int i, String str) {
                        super.fail(i, str);
                    }
                });
                return;
            case 4:
                if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendApplicationListDeleted(tIMSNSSystemElem.getDelFriendAddPendencyList());
                    return;
                }
                return;
            case 5:
                final ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                for (String str : arrayList) {
                    TIMFriend queryFriend = TIMFriendshipManager.getInstance().queryFriend(str);
                    if (queryFriend != null) {
                        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                        v2TIMFriendInfo.setTIMFriend(queryFriend);
                        arrayList4.add(v2TIMFriendInfo);
                    } else {
                        arrayList5.add(str);
                    }
                }
                if (arrayList5.size() > 0) {
                    getUsersInfo(arrayList5, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
                        /* class com.tencent.imsdk.v2.V2TIMManagerImpl.AnonymousClass26 */

                        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                        public void onError(int i, String str) {
                            QLog.e("V2TIMManagerImpl", "processSNSSystemElem, subType = " + subType + ", getUsersInfo failed, code = " + i + ", desc = " + str);
                            if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                                V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onBlackListAdd(arrayList4);
                            }
                        }

                        public void onSuccess(List<V2TIMUserFullInfo> list) {
                            for (V2TIMUserFullInfo v2TIMUserFullInfo : list) {
                                V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                                v2TIMFriendInfo.setV2TIMUserFullInfo(v2TIMUserFullInfo);
                                arrayList4.add(v2TIMFriendInfo);
                            }
                            if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                                V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onBlackListAdd(arrayList4);
                            }
                        }
                    });
                    return;
                }
                return;
            case 6:
                if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onBlackListDeleted(tIMSNSSystemElem.getDelBlacklistUserList());
                    return;
                }
                return;
            case 7:
                if (V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.getInstance().mV2TIMFriendshipListener.onFriendApplicationListRead();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
