package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMGroupAtInfo;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import com.tencent.imsdk.ext.message.TIMConversationExt;
import com.tencent.imsdk.ext.message.TIMMessageDraft;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.NetConnectInfoCenter;
import java.util.ArrayList;
import java.util.List;

public class V2TIMConversation {
    static final String CONVERSATION_C2C_PREFIX = "c2c_";
    static final String CONVERSATION_GROUP_PREFIX = "group_";
    public static final int CONVERSATION_TYPE_INVALID = 0;
    public static final int V2TIM_C2C = 1;
    public static final int V2TIM_GROUP = 2;
    private final String TAG = "V2TIMConversation";
    private String faceUrl;
    private int groupRecvMsgOpt;
    private String groupType;
    private String showName;
    private TIMConversation timConversation;

    V2TIMConversation() {
    }

    void setTIMConversation(TIMConversation tIMConversation) {
        this.timConversation = tIMConversation;
    }

    TIMConversation getTIMConversation() {
        return this.timConversation;
    }

    public String getConversationID() {
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation == null) {
            return null;
        }
        if (tIMConversation.getType() == TIMConversationType.C2C) {
            return "c2c_" + this.timConversation.getPeer();
        } else if (this.timConversation.getType() != TIMConversationType.Group) {
            return "";
        } else {
            return "group_" + this.timConversation.getPeer();
        }
    }

    public int getType() {
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation != null) {
            return tIMConversation.getType().value();
        }
        return 0;
    }

    public String getUserID() {
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation != null && tIMConversation.getType() == TIMConversationType.C2C) {
            return this.timConversation.getPeer();
        }
        return null;
    }

    public String getGroupID() {
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation != null && tIMConversation.getType() == TIMConversationType.Group) {
            return this.timConversation.getPeer();
        }
        return null;
    }

    protected void setShowName(String str) {
        this.showName = str;
    }

    public String getShowName() {
        return this.showName;
    }

    protected void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    protected void setGroupRecvMsgOpt(int i) {
        this.groupRecvMsgOpt = i;
    }

    public int getRecvOpt() {
        return this.groupRecvMsgOpt;
    }

    protected void setGroupType(String str) {
        this.groupType = str;
    }

    public String getGroupType() {
        if (TextUtils.isEmpty(this.groupType)) {
            return null;
        }
        if (this.groupType.equals("Private")) {
            return "Work";
        }
        if (this.groupType.equals("ChatRoom")) {
            return "Meeting";
        }
        return this.groupType;
    }

    public int getUnreadCount() {
        TIMGroupDetailInfo queryGroupInfo;
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation == null) {
            QLog.e("V2TIMConversation", "getUnreadCount fail because timConversation is null");
            return 0;
        }
        if (tIMConversation.getType() == TIMConversationType.Group && (queryGroupInfo = TIMGroupManager.getInstance().queryGroupInfo(getGroupID())) != null) {
            String groupType2 = queryGroupInfo.getGroupType();
            if ("AVChatRoom".equals(groupType2) || "BChatRoom".equals(groupType2)) {
                return 0;
            }
        }
        return (int) this.timConversation.getUnreadMessageNum();
    }

    public V2TIMMessage getLastMessage() {
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation == null) {
            QLog.e("V2TIMConversation", "getLastMessage fail because timConversation is null");
            return null;
        }
        TIMMessage lastMsg = tIMConversation.getLastMsg();
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setTIMMessage(lastMsg);
        return v2TIMMessage;
    }

    public String getDraftText() {
        byte[] userDefinedData;
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation == null) {
            QLog.e("V2TIMConversation", "getDraftText fail because timConversation is null");
            return null;
        }
        TIMMessageDraft draft = tIMConversation.getDraft();
        if (draft == null || (userDefinedData = draft.getUserDefinedData()) == null) {
            return null;
        }
        return new String(userDefinedData);
    }

    public long getDraftTimestamp() {
        TIMConversation tIMConversation = this.timConversation;
        if (tIMConversation == null) {
            QLog.e("V2TIMConversation", "getDraftTimestamp fail because timConversation is null");
            return 0;
        }
        TIMMessageDraft draft = tIMConversation.getDraft();
        if (draft == null) {
            return 0;
        }
        return draft.getTimestamp();
    }

    public List<V2TIMGroupAtInfo> getGroupAtInfoList() {
        if (this.timConversation == null) {
            QLog.e("V2TIMConversation", "getDraftTimestamp fail because timConversation is null");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (TIMGroupAtInfo tIMGroupAtInfo : this.timConversation.getGroupAtInfoList()) {
            V2TIMGroupAtInfo v2TIMGroupAtInfo = new V2TIMGroupAtInfo();
            v2TIMGroupAtInfo.setTimGroupAtInfo(tIMGroupAtInfo);
            arrayList.add(v2TIMGroupAtInfo);
        }
        return arrayList;
    }

    String sendMessage(final V2TIMMessage v2TIMMessage, int i, final V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback) {
        if (this.timConversation != null && v2TIMMessage != null) {
            AnonymousClass1 r0 = new TIMValueCallBack<TIMMessage>() {
                /* class com.tencent.imsdk.v2.V2TIMConversation.AnonymousClass1 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMSendCallback v2TIMSendCallback = v2TIMSendCallback;
                    if (v2TIMSendCallback != null) {
                        v2TIMSendCallback.onError(i, str);
                        V2TIMManagerImpl.getInstance().removeSendCallback(v2TIMMessage.getMsgID());
                    }
                }

                public void onSuccess(TIMMessage tIMMessage) {
                    if (v2TIMSendCallback != null) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setTIMMessage(tIMMessage);
                        v2TIMSendCallback.onSuccess(v2TIMMessage);
                        V2TIMManagerImpl.getInstance().removeSendCallback(v2TIMMessage.getMsgID());
                    }
                }
            };
            if (i == 0) {
                this.timConversation.sendMessage(v2TIMMessage.getTIMMessage(), r0);
                v2TIMMessage.setCanReadMsgID(true);
                V2TIMManagerImpl.getInstance().addSendCallback(v2TIMMessage.getMsgID(), v2TIMSendCallback);
            } else if (i == 1) {
                this.timConversation.sendOnlineMessage(v2TIMMessage.getTIMMessage(), r0);
                v2TIMMessage.setCanReadMsgID(true);
                V2TIMManagerImpl.getInstance().addSendCallback(v2TIMMessage.getMsgID(), v2TIMSendCallback);
            }
            return v2TIMMessage.getMsgID();
        } else if (v2TIMSendCallback == null) {
            return "";
        } else {
            v2TIMSendCallback.onError(6017, "v2TIMMessage is null");
            return "";
        }
    }

    String insertMessageToLocalStorage(V2TIMMessage v2TIMMessage, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        int saveMessage = this.timConversation.saveMessage(v2TIMMessage.getTIMMessage(), v2TIMMessage.getSender(), true);
        v2TIMMessage.setCanReadMsgID(true);
        if (v2TIMValueCallback == null) {
            return v2TIMMessage.getMsgID();
        }
        if (saveMessage == 0) {
            v2TIMValueCallback.onSuccess(v2TIMMessage);
        } else {
            v2TIMValueCallback.onError(saveMessage, "");
        }
        return v2TIMMessage.getMsgID();
    }

    void revokeMessage(V2TIMMessage v2TIMMessage, final V2TIMCallback v2TIMCallback) {
        if (this.timConversation != null && v2TIMMessage != null) {
            this.timConversation.revokeMessage(v2TIMMessage.getTIMMessage(), new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMConversation.AnonymousClass2 */

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
            v2TIMCallback.onError(6017, "timConversation or v2TIMMessage is null");
        }
    }

    void getC2CHistoryMessageList(int i, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        getMessageList(i, true, false, v2TIMMessage, v2TIMValueCallback);
    }

    void getGroupHistoryMessageList(final int i, final V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        getMessageList(i, true, false, v2TIMMessage, new V2TIMValueCallback<List<V2TIMMessage>>() {
            /* class com.tencent.imsdk.v2.V2TIMConversation.AnonymousClass3 */

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                if (i == 10007) {
                    TIMConversation tIMConversation = V2TIMConversation.this.timConversation;
                    int i2 = i;
                    V2TIMMessage v2TIMMessage = v2TIMMessage;
                    tIMConversation.getLocalMessage(i2, v2TIMMessage == null ? null : v2TIMMessage.getTIMMessage(), new TIMValueCallBack<List<TIMMessage>>() {
                        /* class com.tencent.imsdk.v2.V2TIMConversation.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.imsdk.TIMValueCallBack
                        public void onError(int i, String str) {
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
                }
            }

            public void onSuccess(List<V2TIMMessage> list) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onSuccess(list);
                }
            }
        });
    }

    void getMessageList(int i, boolean z, boolean z2, V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        AnonymousClass4 r0 = new TIMValueCallBack<List<TIMMessage>>() {
            /* class com.tencent.imsdk.v2.V2TIMConversation.AnonymousClass4 */

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
        };
        TIMMessage tIMMessage = null;
        if (!z || !NetConnectInfoCenter.getInstance().isNetworkConnected() || TextUtils.isEmpty(V2TIMManager.getInstance().getLoginUser())) {
            if (z2) {
                TIMConversationExt tIMConversationExt = new TIMConversationExt(this.timConversation);
                if (v2TIMMessage != null) {
                    tIMMessage = v2TIMMessage.getTIMMessage();
                }
                tIMConversationExt.getLocalMessageForward(i, tIMMessage, r0);
                return;
            }
            TIMConversation tIMConversation = this.timConversation;
            if (v2TIMMessage != null) {
                tIMMessage = v2TIMMessage.getTIMMessage();
            }
            tIMConversation.getLocalMessage(i, tIMMessage, r0);
        } else if (z2) {
            TIMConversationExt tIMConversationExt2 = new TIMConversationExt(this.timConversation);
            if (v2TIMMessage != null) {
                tIMMessage = v2TIMMessage.getTIMMessage();
            }
            tIMConversationExt2.getMessageForward(i, tIMMessage, r0);
        } else {
            TIMConversation tIMConversation2 = this.timConversation;
            if (v2TIMMessage != null) {
                tIMMessage = v2TIMMessage.getTIMMessage();
            }
            tIMConversation2.getMessage(i, tIMMessage, r0);
        }
    }

    void setMessageRead(V2TIMMessage v2TIMMessage, final V2TIMCallback v2TIMCallback) {
        if (this.timConversation != null) {
            this.timConversation.setReadMessage(v2TIMMessage == null ? null : v2TIMMessage.getTIMMessage(), new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMConversation.AnonymousClass5 */

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
            v2TIMCallback.onError(6017, "timConversation is null");
        }
    }

    void deleteMessages(List<V2TIMMessage> list, final V2TIMCallback v2TIMCallback) {
        if (this.timConversation != null) {
            ArrayList arrayList = new ArrayList();
            for (V2TIMMessage v2TIMMessage : list) {
                arrayList.add(v2TIMMessage.getTIMMessage());
            }
            this.timConversation.deleteMessages(arrayList, new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMConversation.AnonymousClass6 */

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
            v2TIMCallback.onError(6017, "timConversation is null");
        }
    }
}
