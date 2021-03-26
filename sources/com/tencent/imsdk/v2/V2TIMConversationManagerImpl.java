package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationSucc;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.conversation.ConversationListener;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfo;
import com.tencent.imsdk.ext.group.TIMGroupDetailInfoResult;
import com.tencent.imsdk.ext.message.TIMMessageDraft;
import com.tencent.imsdk.friendship.TIMFriend;
import com.tencent.imsdk.friendship.TIMFriendGetResult;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class V2TIMConversationManagerImpl extends V2TIMConversationManager {
    private final String TAG;
    protected ConcurrentHashMap<String, Long> conversationIDMap;
    private V2TIMConversationListener mV2TIMConversationListener;

    private interface ExtMsgCallback {
        void onGetExtMsgFinish();
    }

    private static class V2TIMConversationManagerImplHolder {
        private static final V2TIMConversationManagerImpl v2TIMConversationManagerImpl = new V2TIMConversationManagerImpl();

        private V2TIMConversationManagerImplHolder() {
        }
    }

    static V2TIMConversationManagerImpl getInstance() {
        return V2TIMConversationManagerImplHolder.v2TIMConversationManagerImpl;
    }

    private V2TIMConversationManagerImpl() {
        this.TAG = "V2TIMConvMgrImpl";
        this.conversationIDMap = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationListener(V2TIMConversationListener v2TIMConversationListener) {
        this.mV2TIMConversationListener = v2TIMConversationListener;
        ConversationManager.getInstance().setConversationListenerProxy(new ConversationListener() {
            /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass1 */

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onDeleteConversation(List<TIMConversation> list) {
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onAddConversation(List<TIMConversation> list) {
                final ArrayList arrayList = new ArrayList();
                for (TIMConversation tIMConversation : list) {
                    if (!(tIMConversation.getType() == TIMConversationType.System || tIMConversation.getType() == TIMConversationType.Invalid)) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setTIMConversation(tIMConversation);
                        arrayList.add(v2TIMConversation);
                    }
                }
                V2TIMConversationManagerImpl.this.getConversationExtMsg(arrayList, new ExtMsgCallback() {
                    /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.imsdk.v2.V2TIMConversationManagerImpl.ExtMsgCallback
                    public void onGetExtMsgFinish() {
                        ArrayList arrayList = new ArrayList();
                        for (V2TIMConversation v2TIMConversation : arrayList) {
                            if (v2TIMConversation.getConversationID() != null && !V2TIMConversationManagerImpl.this.conversationIDMap.containsKey(v2TIMConversation.getConversationID())) {
                                if (v2TIMConversation.getLastMessage() != null) {
                                    V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), Long.valueOf(v2TIMConversation.getLastMessage().getTimestamp()));
                                } else {
                                    V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), 0L);
                                }
                                arrayList.add(v2TIMConversation);
                            }
                        }
                        if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null && arrayList.size() > 0) {
                            V2TIMConversationManagerImpl.this.mV2TIMConversationListener.onNewConversation(arrayList);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onUpdateConversation(List<TIMConversation> list) {
                final ArrayList arrayList = new ArrayList();
                for (TIMConversation tIMConversation : list) {
                    if (!(tIMConversation.getType() == TIMConversationType.System || tIMConversation.getType() == TIMConversationType.Invalid)) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setTIMConversation(tIMConversation);
                        arrayList.add(v2TIMConversation);
                    }
                }
                V2TIMConversationManagerImpl.this.getConversationExtMsg(arrayList, new ExtMsgCallback() {
                    /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.imsdk.v2.V2TIMConversationManagerImpl.ExtMsgCallback
                    public void onGetExtMsgFinish() {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (V2TIMConversation v2TIMConversation : arrayList) {
                            if (v2TIMConversation.getConversationID() != null) {
                                if (!V2TIMConversationManagerImpl.this.conversationIDMap.containsKey(v2TIMConversation.getConversationID())) {
                                    Iterator<Map.Entry<String, Long>> it2 = V2TIMConversationManagerImpl.this.conversationIDMap.entrySet().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        try {
                                            long longValue = it2.next().getValue().longValue();
                                            if (v2TIMConversation.getLastMessage() != null && v2TIMConversation.getLastMessage().getTimestamp() > longValue) {
                                                V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), Long.valueOf(v2TIMConversation.getLastMessage().getTimestamp()));
                                                arrayList2.add(v2TIMConversation);
                                                break;
                                            }
                                        } catch (Exception e) {
                                            QLog.e("V2TIMConvMgrImpl", "onUpdateConversation,getConversationExtMsg e = " + e);
                                        }
                                    }
                                } else {
                                    if (v2TIMConversation.getLastMessage() != null) {
                                        V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), Long.valueOf(v2TIMConversation.getLastMessage().getTimestamp()));
                                    }
                                    arrayList.add(v2TIMConversation);
                                }
                            }
                        }
                        if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                            if (arrayList.size() > 0) {
                                V2TIMConversationManagerImpl.this.mV2TIMConversationListener.onConversationChanged(arrayList);
                            }
                            if (arrayList2.size() > 0) {
                                V2TIMConversationManagerImpl.this.mV2TIMConversationListener.onNewConversation(arrayList2);
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onSyncServerStart() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListener.onSyncServerStart();
                }
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onSyncServerFinish() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListener.onSyncServerFinish();
                }
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onSyncServerFailed() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListener.onSyncServerFailed();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationList(long j, int i, final V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        ConversationManager.getInstance().getConversationList(j, i, new TIMValueCallBack<TIMConversationSucc>() {
            /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass2 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i, str);
                }
            }

            public void onSuccess(TIMConversationSucc tIMConversationSucc) {
                final V2TIMConversationResult v2TIMConversationResult = new V2TIMConversationResult(tIMConversationSucc);
                V2TIMConversationManagerImpl.this.getConversationExtMsg(v2TIMConversationResult.getConversationList(), new ExtMsgCallback() {
                    /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.imsdk.v2.V2TIMConversationManagerImpl.ExtMsgCallback
                    public void onGetExtMsgFinish() {
                        for (V2TIMConversation v2TIMConversation : v2TIMConversationResult.getConversationList()) {
                            if (v2TIMConversation.getConversationID() != null) {
                                if (v2TIMConversation.getLastMessage() != null) {
                                    V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), Long.valueOf(v2TIMConversation.getLastMessage().getTimestamp()));
                                } else {
                                    V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), 0L);
                                }
                            }
                        }
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(v2TIMConversationResult);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void getConversationExtMsg(List<V2TIMConversation> list, final ExtMsgCallback extMsgCallback) {
        final ArrayList arrayList = new ArrayList();
        final HashMap hashMap = new HashMap();
        final ArrayList arrayList2 = new ArrayList();
        final HashMap hashMap2 = new HashMap();
        for (V2TIMConversation v2TIMConversation : list) {
            if (v2TIMConversation.getType() == 2) {
                v2TIMConversation.setShowName(v2TIMConversation.getGroupID());
                TIMGroupDetailInfo queryGroupInfo = TIMGroupManager.getInstance().queryGroupInfo(v2TIMConversation.getGroupID());
                if (queryGroupInfo != null) {
                    v2TIMConversation.setShowName(queryGroupInfo.getGroupName());
                    v2TIMConversation.setFaceUrl(queryGroupInfo.getFaceUrl());
                    v2TIMConversation.setGroupRecvMsgOpt((int) queryGroupInfo.getRecvOpt().getValue());
                    v2TIMConversation.setGroupType(queryGroupInfo.getGroupType());
                } else {
                    arrayList.add(v2TIMConversation.getGroupID());
                    hashMap.put(v2TIMConversation.getGroupID(), v2TIMConversation);
                }
            } else if (v2TIMConversation.getType() == 1) {
                v2TIMConversation.setShowName(v2TIMConversation.getUserID());
                TIMUserProfile queryUserProfile = TIMFriendshipManager.getInstance().queryUserProfile(v2TIMConversation.getUserID());
                if (queryUserProfile != null) {
                    if (!TextUtils.isEmpty(queryUserProfile.getNickName())) {
                        v2TIMConversation.setShowName(queryUserProfile.getNickName());
                    }
                    if (!TextUtils.isEmpty(queryUserProfile.getFaceUrl())) {
                        v2TIMConversation.setFaceUrl(queryUserProfile.getFaceUrl());
                    }
                }
                TIMFriend queryFriend = TIMFriendshipManager.getInstance().queryFriend(v2TIMConversation.getUserID());
                if (queryFriend != null) {
                    if (!TextUtils.isEmpty(queryFriend.getRemark())) {
                        v2TIMConversation.setShowName(queryFriend.getRemark());
                    } else if (!TextUtils.isEmpty(queryFriend.getTimUserProfile().getNickName())) {
                        v2TIMConversation.setShowName(queryFriend.getTimUserProfile().getNickName());
                    }
                }
                if (queryUserProfile == null && queryFriend == null) {
                    arrayList2.add(v2TIMConversation.getUserID());
                    hashMap2.put(v2TIMConversation.getUserID(), v2TIMConversation);
                }
            }
        }
        if (arrayList.size() != 0 || arrayList2.size() != 0) {
            if (arrayList.size() > 0) {
                TIMGroupManager.getInstance().getGroupInfo(arrayList, new TIMValueCallBack<List<TIMGroupDetailInfoResult>>() {
                    /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass3 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        ExtMsgCallback extMsgCallback;
                        QLog.e("V2TIMConvMgrImpl", "getConversationExtMsg, getGroupInfo fail");
                        arrayList.clear();
                        if (arrayList2.size() <= 0 && (extMsgCallback = extMsgCallback) != null) {
                            extMsgCallback.onGetExtMsgFinish();
                        }
                    }

                    public void onSuccess(List<TIMGroupDetailInfoResult> list) {
                        ExtMsgCallback extMsgCallback;
                        for (TIMGroupDetailInfoResult tIMGroupDetailInfoResult : list) {
                            String groupId = tIMGroupDetailInfoResult.getGroupId();
                            V2TIMConversation v2TIMConversation = (V2TIMConversation) hashMap.get(groupId);
                            if (v2TIMConversation != null) {
                                v2TIMConversation.setShowName(tIMGroupDetailInfoResult.getGroupName());
                                v2TIMConversation.setFaceUrl(tIMGroupDetailInfoResult.getFaceUrl());
                                v2TIMConversation.setGroupType(tIMGroupDetailInfoResult.getGroupType());
                                v2TIMConversation.setGroupRecvMsgOpt((int) tIMGroupDetailInfoResult.getRecvOpt().getValue());
                                v2TIMConversation.setGroupType(tIMGroupDetailInfoResult.getGroupType());
                            }
                            arrayList.remove(groupId);
                        }
                        if (arrayList2.size() <= 0 && (extMsgCallback = extMsgCallback) != null) {
                            extMsgCallback.onGetExtMsgFinish();
                        }
                    }
                });
            }
            if (arrayList2.size() > 0) {
                TIMFriendshipManager.getInstance().getFriendList(arrayList2, new TIMValueCallBack<List<TIMFriendGetResult>>() {
                    /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass4 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        ExtMsgCallback extMsgCallback;
                        QLog.e("V2TIMConvMgrImpl", "getConversationExtMsg, getFriendList fail pullUserIDList:" + arrayList2.toString() + ", code:" + i + ", desc:" + str);
                        arrayList2.clear();
                        if (arrayList.size() <= 0 && (extMsgCallback = extMsgCallback) != null) {
                            extMsgCallback.onGetExtMsgFinish();
                        }
                    }

                    public void onSuccess(List<TIMFriendGetResult> list) {
                        ArrayList arrayList = new ArrayList();
                        if (list != null && list.size() > 0) {
                            for (TIMFriendGetResult tIMFriendGetResult : list) {
                                String identifier = tIMFriendGetResult.getTimFriend().getIdentifier();
                                if (tIMFriendGetResult.getResultCode() == 0 && (tIMFriendGetResult.getRelation() == 1 || tIMFriendGetResult.getRelation() == 3)) {
                                    V2TIMConversation v2TIMConversation = (V2TIMConversation) hashMap2.get(identifier);
                                    v2TIMConversation.setFaceUrl(tIMFriendGetResult.getTimFriend().getTimUserProfile().getFaceUrl());
                                    if (!TextUtils.isEmpty(tIMFriendGetResult.getTimFriend().getRemark())) {
                                        v2TIMConversation.setShowName(tIMFriendGetResult.getTimFriend().getRemark());
                                    } else if (!TextUtils.isEmpty(tIMFriendGetResult.getTimFriend().getTimUserProfile().getNickName())) {
                                        v2TIMConversation.setShowName(tIMFriendGetResult.getTimFriend().getTimUserProfile().getNickName());
                                    }
                                    arrayList2.remove(identifier);
                                } else {
                                    arrayList.add(identifier);
                                }
                            }
                        }
                        if (arrayList2.size() == 0 && arrayList.size() == 0) {
                            ExtMsgCallback extMsgCallback = extMsgCallback;
                            if (extMsgCallback != null) {
                                extMsgCallback.onGetExtMsgFinish();
                            }
                        } else if (arrayList.size() != 0) {
                            TIMFriendshipManager.getInstance().getUsersProfile(arrayList, true, new TIMValueCallBack<List<TIMUserProfile>>() {
                                /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass4.AnonymousClass1 */

                                @Override // com.tencent.imsdk.TIMValueCallBack
                                public void onError(int i, String str) {
                                    QLog.e("V2TIMConvMgrImpl", "getConversationExtMsg, getUsersInfo err");
                                    arrayList2.clear();
                                    if (arrayList.size() <= 0 && extMsgCallback != null) {
                                        extMsgCallback.onGetExtMsgFinish();
                                    }
                                }

                                public void onSuccess(List<TIMUserProfile> list) {
                                    for (TIMUserProfile tIMUserProfile : list) {
                                        String identifier = tIMUserProfile.getIdentifier();
                                        V2TIMConversation v2TIMConversation = (V2TIMConversation) hashMap2.get(identifier);
                                        if (!TextUtils.isEmpty(tIMUserProfile.getNickName())) {
                                            v2TIMConversation.setShowName(tIMUserProfile.getNickName());
                                        }
                                        v2TIMConversation.setFaceUrl(tIMUserProfile.getFaceUrl());
                                        arrayList2.remove(identifier);
                                    }
                                    if (arrayList.size() <= 0 && extMsgCallback != null) {
                                        extMsgCallback.onGetExtMsgFinish();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        } else if (extMsgCallback != null) {
            extMsgCallback.onGetExtMsgFinish();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversation(String str, final V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMConvMgrImpl", "getConversation fail, conversationID is empty!");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationID is empty");
                return;
            }
            return;
        }
        QLog.i("V2TIMConvMgrImpl", "getConversation conversationID:" + str);
        TIMConversation v1Conversation = getV1Conversation(str);
        if (v1Conversation != null) {
            ArrayList arrayList = new ArrayList();
            final V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(v1Conversation);
            arrayList.add(v2TIMConversation);
            getConversationExtMsg(arrayList, new ExtMsgCallback() {
                /* class com.tencent.imsdk.v2.V2TIMConversationManagerImpl.AnonymousClass5 */

                @Override // com.tencent.imsdk.v2.V2TIMConversationManagerImpl.ExtMsgCallback
                public void onGetExtMsgFinish() {
                    if (v2TIMConversation.getConversationID() != null) {
                        if (v2TIMConversation.getLastMessage() != null) {
                            V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), Long.valueOf(v2TIMConversation.getLastMessage().getTimestamp()));
                        } else {
                            V2TIMConversationManagerImpl.this.conversationIDMap.put(v2TIMConversation.getConversationID(), 0L);
                        }
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMConversation);
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "conversationID is not exist");
        }
    }

    private TIMConversation getV1Conversation(String str) {
        String str2;
        TIMConversationType tIMConversationType = TIMConversationType.Invalid;
        if (str.indexOf("c2c_") == 0) {
            tIMConversationType = TIMConversationType.C2C;
            str2 = str.substring(4);
        } else if (str.indexOf("group_") == 0) {
            tIMConversationType = TIMConversationType.Group;
            str2 = str.substring(6);
        } else {
            str2 = "";
        }
        return TIMManager.getInstance().getConversation(tIMConversationType, str2);
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void deleteConversation(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMConvMgrImpl", "deleteConversation fail, conversationID is empty!");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is empty");
                return;
            }
            return;
        }
        QLog.i("V2TIMConvMgrImpl", "deleteConversation conversationID:" + str);
        TIMConversation v1Conversation = getV1Conversation(str);
        if (v1Conversation != null) {
            TIMManager.getInstance().deleteConversation(v1Conversation.getType(), v1Conversation.getPeer());
            if (str != null) {
                this.conversationIDMap.remove(str);
            }
            if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "get conversation failed");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMConvMgrImpl", "setConversationDraft fail, conversationID is empty!");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is empty");
                return;
            }
            return;
        }
        QLog.i("V2TIMConvMgrImpl", "setConversationDraft conversationID:" + str);
        TIMConversation v1Conversation = getV1Conversation(str);
        if (v1Conversation == null) {
            QLog.e("V2TIMConvMgrImpl", "setConversationDraft fail because timConversation is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "timConversation is null");
            }
        } else if (str2 == null) {
            v1Conversation.setDraft(null);
            if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
        } else {
            TIMMessageDraft tIMMessageDraft = new TIMMessageDraft();
            tIMMessageDraft.setUserDefinedData(str2.getBytes());
            v1Conversation.setDraft(tIMMessageDraft);
            if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
        }
    }
}
