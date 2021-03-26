package com.tencent.imsdk.v2;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class V2TIMSignalingManagerImpl extends V2TIMSignalingManager {
    private final String TAG;
    private final int TIMEOUT_DELAY;
    private List<V2TIMSignalingInfo> invitationList;
    private CopyOnWriteArrayList<V2TIMSignalingListener> mSignalingListenerList;
    private Handler mTimeoutHandler;

    private static class V2TIMSignalingManagerImplHolder {
        private static final V2TIMSignalingManagerImpl v2TIMSignalingManagerImpl = new V2TIMSignalingManagerImpl();

        private V2TIMSignalingManagerImplHolder() {
        }
    }

    static V2TIMSignalingManagerImpl getInstance() {
        return V2TIMSignalingManagerImplHolder.v2TIMSignalingManagerImpl;
    }

    private V2TIMSignalingManagerImpl() {
        this.TAG = "V2TIMSigMgrImpl";
        this.TIMEOUT_DELAY = 5;
        this.invitationList = new ArrayList();
        this.mSignalingListenerList = new CopyOnWriteArrayList<>();
        this.mTimeoutHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void addSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            if (!this.mSignalingListenerList.contains(v2TIMSignalingListener)) {
                this.mSignalingListenerList.add(v2TIMSignalingListener);
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void removeSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            this.mSignalingListenerList.remove(v2TIMSignalingListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public String invite(String str, String str2, boolean z, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, int i, final V2TIMCallback v2TIMCallback) {
        TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.C2C, str);
        if (conversation == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "get conv failed!");
            }
            QLog.e("V2TIMSigMgrImpl", "signaling invite get conv failed!");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "invitee is empty");
            }
            QLog.e("V2TIMSigMgrImpl", "signaling invite error, invitee is empty");
            return null;
        } else {
            final V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
            v2TIMSignalingInfo.setInviter(V2TIMManager.getInstance().getLoginUser());
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            v2TIMSignalingInfo.setInviteeList(arrayList);
            v2TIMSignalingInfo.setData(str2);
            v2TIMSignalingInfo.setOnlineUserOnly(z);
            v2TIMSignalingInfo.setTimeout(i);
            v2TIMSignalingInfo.setActionType(1);
            v2TIMSignalingInfo.setOfflinePushInfo(v2TIMOfflinePushInfo);
            new V2TIMConversationInternal(conversation).sendSignalMessage(v2TIMSignalingInfo, new TIMValueCallBack<TIMMessage>() {
                /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass1 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i, str);
                    }
                }

                public void onSuccess(TIMMessage tIMMessage) {
                    V2TIMSignalingManagerImpl.this.invitationList.add(v2TIMSignalingInfo);
                    V2TIMSignalingManagerImpl.this.checkInviteTimeout(v2TIMSignalingInfo);
                    if (!v2TIMSignalingInfo.isOnlineUserOnly()) {
                        V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(tIMMessage);
                    }
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
            QLog.i("V2TIMSigMgrImpl", "signaling invite, inviteID:" + v2TIMSignalingInfo.getInviteID() + ", invitee:" + str + ", timeout:" + i);
            return v2TIMSignalingInfo.getInviteID();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public String inviteInGroup(String str, List<String> list, String str2, boolean z, int i, final V2TIMCallback v2TIMCallback) {
        TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.Group, str);
        if (conversation == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "get conv failed!");
            }
            QLog.e("V2TIMSigMgrImpl", "signaling inviteInGroup get conv failed!");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
            }
            QLog.e("V2TIMSigMgrImpl", "signaling invite error, groupID is empty");
            return null;
        } else if (list == null || list.size() == 0) {
            if (v2TIMCallback != null) {
                QLog.e("V2TIMSigMgrImpl", "signaling invite error, inviteeList is empty");
                v2TIMCallback.onError(6017, "inviteeList is empty");
            }
            return null;
        } else {
            final V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
            v2TIMSignalingInfo.setInviter(V2TIMManager.getInstance().getLoginUser());
            v2TIMSignalingInfo.setGroupID(str);
            v2TIMSignalingInfo.setInviteeList(list);
            v2TIMSignalingInfo.setData(str2);
            v2TIMSignalingInfo.setOnlineUserOnly(z);
            v2TIMSignalingInfo.setTimeout(i);
            v2TIMSignalingInfo.setActionType(1);
            new V2TIMConversationInternal(conversation).sendSignalMessage(v2TIMSignalingInfo, new TIMValueCallBack<TIMMessage>() {
                /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("V2TIMSigMgrImpl", "signaling sendSignalMessage failed code:" + i + ", desc:" + str);
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i, str);
                    }
                }

                public void onSuccess(TIMMessage tIMMessage) {
                    V2TIMSignalingManagerImpl.this.invitationList.add(v2TIMSignalingInfo);
                    V2TIMSignalingManagerImpl.this.checkInviteTimeout(v2TIMSignalingInfo);
                    if (!v2TIMSignalingInfo.isOnlineUserOnly()) {
                        V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(tIMMessage);
                    }
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
            QLog.i("V2TIMSigMgrImpl", "signaling inviteInGroup, inviteID:" + v2TIMSignalingInfo.getInviteID() + ", groupID:" + str + ", inviteeList:" + list + ", timeout:" + i);
            return v2TIMSignalingInfo.getInviteID();
        }
    }

    /* access modifiers changed from: private */
    public void checkInviteTimeout(final V2TIMSignalingInfo v2TIMSignalingInfo) {
        if (v2TIMSignalingInfo.getTimeout() <= 0) {
            QLog.i("V2TIMSigMgrImpl", "signaling checkInviteTimeout timeout is <= 0, ignore to post delay task");
        } else {
            this.mTimeoutHandler.postDelayed(new Runnable() {
                /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < V2TIMSignalingManagerImpl.this.invitationList.size(); i++) {
                        final V2TIMSignalingInfo v2TIMSignalingInfo = (V2TIMSignalingInfo) V2TIMSignalingManagerImpl.this.invitationList.get(i);
                        if (v2TIMSignalingInfo.getInviteID().equals(v2TIMSignalingInfo.getInviteID()) && v2TIMSignalingInfo.getInviteeList().size() > 0) {
                            QLog.i("V2TIMSigMgrImpl", "signaling invite local timeout inviteID:" + v2TIMSignalingInfo.getInviteID() + ", inviteeList:" + v2TIMSignalingInfo.getInviteeList());
                            final int actionType = v2TIMSignalingInfo.getActionType();
                            v2TIMSignalingInfo.setActionType(5);
                            v2TIMSignalingInfo.setOfflinePushInfo(null);
                            new V2TIMConversationInternal(V2TIMSignalingManagerImpl.this.getConversationFromSignaling(v2TIMSignalingInfo, true)).sendSignalMessage(v2TIMSignalingInfo, new TIMValueCallBack<TIMMessage>() {
                                /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass3.AnonymousClass1 */

                                public void onSuccess(TIMMessage tIMMessage) {
                                    synchronized (V2TIMSignalingManagerImpl.this) {
                                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                        while (it2.hasNext()) {
                                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                            if (v2TIMSignalingListener != null) {
                                                v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo.getInviteID(), v2TIMSignalingInfo.getInviteeList());
                                            }
                                        }
                                    }
                                    V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                    if (!v2TIMSignalingInfo.isOnlineUserOnly()) {
                                        V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(tIMMessage);
                                    }
                                }

                                @Override // com.tencent.imsdk.TIMValueCallBack
                                public void onError(int i, String str) {
                                    v2TIMSignalingInfo.setActionType(actionType);
                                    synchronized (V2TIMSignalingManagerImpl.this) {
                                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                        while (it2.hasNext()) {
                                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                            if (v2TIMSignalingListener != null) {
                                                v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo.getInviteID(), v2TIMSignalingInfo.getInviteeList());
                                            }
                                        }
                                    }
                                    V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                    QLog.e("V2TIMSigMgrImpl", "signaling send timeout msg failed, inviteID: " + v2TIMSignalingInfo.getInviteID() + ", code:" + i + ", desc:" + str);
                                }
                            });
                            return;
                        }
                    }
                }
            }, (long) ((v2TIMSignalingInfo.getTimeout() + 5) * 1000));
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void cancel(final String str, final String str2, final V2TIMCallback v2TIMCallback) {
        QLog.i("V2TIMSigMgrImpl", "signaling cancel, inviteID:" + str);
        if (!TextUtils.isEmpty(str)) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i >= V2TIMSignalingManagerImpl.this.invitationList.size()) {
                            break;
                        }
                        final V2TIMSignalingInfo v2TIMSignalingInfo = (V2TIMSignalingInfo) V2TIMSignalingManagerImpl.this.invitationList.get(i);
                        if (v2TIMSignalingInfo.getInviteID().equals(str)) {
                            String loginUser = V2TIMManager.getInstance().getLoginUser();
                            if (TextUtils.isEmpty(loginUser)) {
                                QLog.e("V2TIMSigMgrImpl", "signaling cancel error, not login");
                                V2TIMCallback v2TIMCallback = v2TIMCallback;
                                if (v2TIMCallback != null) {
                                    v2TIMCallback.onError(6014, "not login");
                                    return;
                                }
                                return;
                            }
                            if (!v2TIMSignalingInfo.getInviter().equals(loginUser)) {
                                QLog.e("V2TIMSigMgrImpl", "signaling cancel invite failed，the invitation is not initiated by yourself");
                                V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                                if (v2TIMCallback2 != null) {
                                    v2TIMCallback2.onError(8011, "the invitation is not initiated by yourself");
                                }
                            } else {
                                TIMConversation conversationFromSignaling = V2TIMSignalingManagerImpl.this.getConversationFromSignaling(v2TIMSignalingInfo, true);
                                if (conversationFromSignaling != null) {
                                    final V2TIMSignalingInfo v2TIMSignalingInfo2 = new V2TIMSignalingInfo();
                                    v2TIMSignalingInfo2.setInviteID(v2TIMSignalingInfo.getInviteID());
                                    v2TIMSignalingInfo2.setGroupID(v2TIMSignalingInfo.getGroupID());
                                    v2TIMSignalingInfo2.setInviter(v2TIMSignalingInfo.getInviter());
                                    v2TIMSignalingInfo2.setInviteeList(v2TIMSignalingInfo.getInviteeList());
                                    v2TIMSignalingInfo2.setData(str2);
                                    v2TIMSignalingInfo2.setOnlineUserOnly(v2TIMSignalingInfo.isOnlineUserOnly());
                                    v2TIMSignalingInfo2.setActionType(2);
                                    new V2TIMConversationInternal(conversationFromSignaling).sendSignalMessage(v2TIMSignalingInfo2, new TIMValueCallBack<TIMMessage>() {
                                        /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass4.AnonymousClass1 */

                                        @Override // com.tencent.imsdk.TIMValueCallBack
                                        public void onError(int i, String str) {
                                            QLog.e("V2TIMSigMgrImpl", "signaling cancel invite failed, inviteID: " + str + ", code:" + i + ", desc:" + str);
                                            if (v2TIMCallback != null) {
                                                v2TIMCallback.onError(i, str);
                                            }
                                        }

                                        public void onSuccess(TIMMessage tIMMessage) {
                                            synchronized (V2TIMSignalingManagerImpl.this) {
                                                Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                                while (it2.hasNext()) {
                                                    V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                                    if (v2TIMSignalingListener != null) {
                                                        v2TIMSignalingListener.onInvitationCancelled(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviter(), v2TIMSignalingInfo2.getData());
                                                    }
                                                }
                                            }
                                            V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                            if (!v2TIMSignalingInfo2.isOnlineUserOnly()) {
                                                V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(tIMMessage);
                                            }
                                            if (v2TIMCallback != null) {
                                                v2TIMCallback.onSuccess();
                                            }
                                        }
                                    });
                                } else {
                                    QLog.e("V2TIMSigMgrImpl", "signaling cancel, get conv failed, inviteID:" + str);
                                    V2TIMCallback v2TIMCallback3 = v2TIMCallback;
                                    if (v2TIMCallback3 != null) {
                                        v2TIMCallback3.onError(6017, "get conv failed");
                                    }
                                }
                            }
                            z = true;
                        } else {
                            i++;
                        }
                    }
                    if (!z && v2TIMCallback != null) {
                        QLog.e("V2TIMSigMgrImpl", "signaling cancel failed, inviteID is invalid or invitation has been processed inviteID:" + str);
                        v2TIMCallback.onError(8010, "inviteID is invalid or invitation has been processed");
                    }
                }
            });
        } else if (v2TIMCallback != null) {
            QLog.e("V2TIMSigMgrImpl", "signaling cancel error, inviteID is empty");
            v2TIMCallback.onError(6017, "inviteID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void accept(final String str, final String str2, final V2TIMCallback v2TIMCallback) {
        QLog.i("V2TIMSigMgrImpl", "signaling accept invite, inviteID:" + str);
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMSigMgrImpl", "signaling accept failed, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "inviteID is null");
                return;
            }
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() {
            /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                V2TIMSignalingManagerImpl.this.doResponse(str, str2, true, new V2TIMCallback() {
                    /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i, String str) {
                        if (v2TIMCallback != null) {
                            v2TIMCallback.onError(i, str);
                        }
                        QLog.e("V2TIMSigMgrImpl", "signaling accept failed, inviteID:" + str + ", code:" + i + ", desc:" + str);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        if (v2TIMCallback != null) {
                            v2TIMCallback.onSuccess();
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void reject(final String str, final String str2, final V2TIMCallback v2TIMCallback) {
        QLog.i("V2TIMSigMgrImpl", "signaling reject invite, inviteID:" + str);
        if (TextUtils.isEmpty(str)) {
            QLog.e("V2TIMSigMgrImpl", "signaling reject invite, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "inviteID is null");
                return;
            }
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() {
            /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                V2TIMSignalingManagerImpl.this.doResponse(str, str2, false, new V2TIMCallback() {
                    /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass6.AnonymousClass1 */

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i, String str) {
                        if (v2TIMCallback != null) {
                            v2TIMCallback.onError(i, str);
                        }
                        QLog.e("V2TIMSigMgrImpl", "signaling reject failed, inviteID:" + str + ", code:" + i + ", desc:" + str);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        if (v2TIMCallback != null) {
                            v2TIMCallback.onSuccess();
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void doResponse(String str, String str2, final boolean z, final V2TIMCallback v2TIMCallback) {
        final String loginUser = V2TIMManager.getInstance().getLoginUser();
        if (TextUtils.isEmpty(loginUser)) {
            QLog.e("V2TIMSigMgrImpl", "signaling doResponse failed, not login");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6014, "not login");
                return;
            }
            return;
        }
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= this.invitationList.size()) {
                break;
            }
            final V2TIMSignalingInfo v2TIMSignalingInfo = this.invitationList.get(i);
            if (!v2TIMSignalingInfo.getInviteID().equals(str) || !v2TIMSignalingInfo.getInviteeList().contains(loginUser)) {
                i++;
            } else {
                TIMConversation conversationFromSignaling = getConversationFromSignaling(v2TIMSignalingInfo, false);
                if (conversationFromSignaling != null) {
                    final V2TIMSignalingInfo v2TIMSignalingInfo2 = new V2TIMSignalingInfo();
                    v2TIMSignalingInfo2.setInviteID(v2TIMSignalingInfo.getInviteID());
                    v2TIMSignalingInfo2.setGroupID(v2TIMSignalingInfo.getGroupID());
                    v2TIMSignalingInfo2.setInviter(v2TIMSignalingInfo.getInviter());
                    v2TIMSignalingInfo2.addInvitee(V2TIMManager.getInstance().getLoginUser());
                    v2TIMSignalingInfo2.setData(str2);
                    v2TIMSignalingInfo2.setOnlineUserOnly(v2TIMSignalingInfo.isOnlineUserOnly());
                    if (z) {
                        v2TIMSignalingInfo2.setActionType(3);
                    } else {
                        v2TIMSignalingInfo2.setActionType(4);
                    }
                    new V2TIMConversationInternal(conversationFromSignaling).sendSignalMessage(v2TIMSignalingInfo2, new TIMValueCallBack<TIMMessage>() {
                        /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass7 */

                        public void onSuccess(TIMMessage tIMMessage) {
                            synchronized (V2TIMSignalingManagerImpl.this) {
                                Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                while (it2.hasNext()) {
                                    V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                    if (v2TIMSignalingListener != null) {
                                        if (z) {
                                            v2TIMSignalingListener.onInviteeAccepted(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList().get(0), v2TIMSignalingInfo2.getData());
                                        } else {
                                            v2TIMSignalingListener.onInviteeRejected(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList().get(0), v2TIMSignalingInfo2.getData());
                                        }
                                    }
                                }
                            }
                            v2TIMSignalingInfo.getInviteeList().remove(loginUser);
                            if (v2TIMSignalingInfo.getInviteeList().size() == 0) {
                                V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                            }
                            if (!v2TIMSignalingInfo2.isOnlineUserOnly()) {
                                V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(tIMMessage);
                            }
                            V2TIMCallback v2TIMCallback = v2TIMCallback;
                            if (v2TIMCallback != null) {
                                v2TIMCallback.onSuccess();
                            }
                        }

                        @Override // com.tencent.imsdk.TIMValueCallBack
                        public void onError(int i, String str) {
                            V2TIMCallback v2TIMCallback = v2TIMCallback;
                            if (v2TIMCallback != null) {
                                v2TIMCallback.onError(i, str);
                            }
                        }
                    });
                } else {
                    QLog.e("V2TIMSigMgrImpl", "signaling doResponse get conv failed");
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(6017, "get conv failed");
                    }
                }
                z2 = true;
            }
        }
        if (!z2) {
            QLog.e("V2TIMSigMgrImpl", "signaling doResponse failed, inviteID is invalid or invitation has been processed inviteID:" + str);
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(8010, "inviteID is invalid or invitation has been processed");
            }
        }
    }

    protected V2TIMSignalingInfo processSignalingMessage(V2TIMMessage v2TIMMessage) {
        final V2TIMSignalingInfo signalingInfo = new V2TIMConversationInternal(v2TIMMessage.getTIMMessage().getConversation()).getSignalingInfo(v2TIMMessage.getTIMMessage());
        if (signalingInfo == null) {
            return null;
        }
        int actionType = signalingInfo.getActionType();
        if (actionType == 1) {
            int serverTime = (int) (V2TIMManager.getInstance().getServerTime() - v2TIMMessage.getTimestamp());
            if (signalingInfo.getTimeout() <= 0 || serverTime <= signalingInfo.getTimeout()) {
                this.invitationList.add(signalingInfo);
                final String loginUser = V2TIMManager.getInstance().getLoginUser();
                if (!TextUtils.isEmpty(loginUser) && signalingInfo.getInviteeList().contains(loginUser) && signalingInfo.getTimeout() > 0) {
                    this.mTimeoutHandler.postDelayed(new Runnable() {
                        /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass8 */

                        @Override // java.lang.Runnable
                        public void run() {
                            for (int i = 0; i < V2TIMSignalingManagerImpl.this.invitationList.size(); i++) {
                                final V2TIMSignalingInfo v2TIMSignalingInfo = (V2TIMSignalingInfo) V2TIMSignalingManagerImpl.this.invitationList.get(i);
                                if (v2TIMSignalingInfo.getInviteID().equals(signalingInfo.getInviteID()) && v2TIMSignalingInfo.getInviteeList().contains(loginUser)) {
                                    QLog.i("V2TIMSigMgrImpl", "signaling receive invite but local timeout, inviteID:" + signalingInfo.getInviteID());
                                    final V2TIMSignalingInfo v2TIMSignalingInfo2 = new V2TIMSignalingInfo();
                                    v2TIMSignalingInfo2.setInviteID(signalingInfo.getInviteID());
                                    v2TIMSignalingInfo2.setGroupID(signalingInfo.getGroupID());
                                    v2TIMSignalingInfo2.setInviter(signalingInfo.getInviter());
                                    v2TIMSignalingInfo2.addInvitee(loginUser);
                                    v2TIMSignalingInfo2.setActionType(5);
                                    v2TIMSignalingInfo2.setOnlineUserOnly(signalingInfo.isOnlineUserOnly());
                                    new V2TIMConversationInternal(V2TIMSignalingManagerImpl.this.getConversationFromSignaling(v2TIMSignalingInfo2, false)).sendSignalMessage(v2TIMSignalingInfo2, new TIMValueCallBack<TIMMessage>() {
                                        /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass8.AnonymousClass1 */

                                        public void onSuccess(TIMMessage tIMMessage) {
                                            V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(tIMMessage);
                                            V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                            synchronized (V2TIMSignalingManagerImpl.this) {
                                                Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                                while (it2.hasNext()) {
                                                    V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                                    if (v2TIMSignalingListener != null) {
                                                        v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList());
                                                    }
                                                }
                                            }
                                        }

                                        @Override // com.tencent.imsdk.TIMValueCallBack
                                        public void onError(int i, String str) {
                                            V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                            synchronized (V2TIMSignalingManagerImpl.this) {
                                                Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                                while (it2.hasNext()) {
                                                    V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                                    if (v2TIMSignalingListener != null) {
                                                        v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList());
                                                    }
                                                }
                                            }
                                            QLog.e("V2TIMSigMgrImpl", "signaling send timeout msg failed, inviteID:" + v2TIMSignalingInfo2.getInviteID() + ", code:" + i + ", desc:" + str);
                                        }
                                    });
                                    return;
                                }
                            }
                        }
                    }, (long) (signalingInfo.getTimeout() * 1000));
                }
                QLog.i("V2TIMSigMgrImpl", "signaling receive invitation, inviteID:" + signalingInfo.getInviteID() + ", inviter:" + signalingInfo.getInviter() + ", groupID:" + signalingInfo.getGroupID() + ", inviteeList:" + signalingInfo.getInviteeList());
                synchronized (this) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(signalingInfo.getInviteeList());
                    Iterator<V2TIMSignalingListener> it2 = this.mSignalingListenerList.iterator();
                    while (it2.hasNext()) {
                        V2TIMSignalingListener next = it2.next();
                        if (next != null) {
                            next.onReceiveNewInvitation(signalingInfo.getInviteID(), signalingInfo.getInviter(), signalingInfo.getGroupID(), arrayList, signalingInfo.getData());
                        }
                    }
                }
            } else {
                QLog.d("V2TIMSigMgrImpl", "signaling receive invitation but ignore to callback because timeInterval:" + serverTime + " > timeout:" + signalingInfo.getTimeout());
                return signalingInfo;
            }
        } else if (actionType == 2) {
            QLog.i("V2TIMSigMgrImpl", "signaling receive cancel, inviteID:" + signalingInfo.getInviteID() + ", inviter:" + signalingInfo.getInviter());
            Iterator<V2TIMSignalingInfo> it3 = this.invitationList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                V2TIMSignalingInfo next2 = it3.next();
                if (next2.getInviteID().equals(signalingInfo.getInviteID())) {
                    this.invitationList.remove(next2);
                    break;
                }
            }
            synchronized (this) {
                Iterator<V2TIMSignalingListener> it4 = this.mSignalingListenerList.iterator();
                while (it4.hasNext()) {
                    V2TIMSignalingListener next3 = it4.next();
                    if (next3 != null) {
                        next3.onInvitationCancelled(signalingInfo.getInviteID(), signalingInfo.getInviter(), signalingInfo.getData());
                    }
                }
            }
        } else if (actionType != 3) {
            if (actionType != 4) {
                if (actionType != 5) {
                    QLog.e("V2TIMSigMgrImpl", "signaling unknown action type:" + signalingInfo.getActionType());
                } else {
                    List<String> inviteeList = signalingInfo.getInviteeList();
                    if (inviteeList.size() == 0) {
                        QLog.e("V2TIMSigMgrImpl", "signaling receive timeout but timeouters is empty");
                        return signalingInfo;
                    }
                    QLog.i("V2TIMSigMgrImpl", "signaling receive timeout, inviteID:" + signalingInfo.getInviteID() + ", timeouters:" + inviteeList);
                    Iterator<V2TIMSignalingInfo> it5 = this.invitationList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        V2TIMSignalingInfo next4 = it5.next();
                        if (next4.getInviteID().equals(signalingInfo.getInviteID())) {
                            next4.getInviteeList().removeAll(inviteeList);
                            if (next4.getInviteeList().size() == 0) {
                                this.invitationList.remove(next4);
                            }
                        }
                    }
                    synchronized (this) {
                        Iterator<V2TIMSignalingListener> it6 = this.mSignalingListenerList.iterator();
                        while (it6.hasNext()) {
                            V2TIMSignalingListener next5 = it6.next();
                            if (next5 != null) {
                                next5.onInvitationTimeout(signalingInfo.getInviteID(), inviteeList);
                            }
                        }
                    }
                }
            } else if (signalingInfo.getInviteeList().size() == 0) {
                QLog.e("V2TIMSigMgrImpl", "signaling receive reject but rejecter is empty");
                return signalingInfo;
            } else {
                String str = signalingInfo.getInviteeList().get(0);
                QLog.i("V2TIMSigMgrImpl", "signaling receive reject, inviteID:" + signalingInfo.getInviteID() + ", rejecter:" + str);
                Iterator<V2TIMSignalingInfo> it7 = this.invitationList.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    V2TIMSignalingInfo next6 = it7.next();
                    if (next6.getInviteID().equals(signalingInfo.getInviteID())) {
                        next6.getInviteeList().remove(str);
                        if (next6.getInviteeList().size() == 0) {
                            this.invitationList.remove(next6);
                        }
                    }
                }
                synchronized (this) {
                    Iterator<V2TIMSignalingListener> it8 = this.mSignalingListenerList.iterator();
                    while (it8.hasNext()) {
                        V2TIMSignalingListener next7 = it8.next();
                        if (next7 != null) {
                            next7.onInviteeRejected(signalingInfo.getInviteID(), str, signalingInfo.getData());
                        }
                    }
                }
            }
        } else if (signalingInfo.getInviteeList().size() == 0) {
            QLog.e("V2TIMSigMgrImpl", "signaling receive accept but accepter is empty");
            return signalingInfo;
        } else {
            String str2 = signalingInfo.getInviteeList().get(0);
            QLog.i("V2TIMSigMgrImpl", "signaling receive accept, inviteID:" + signalingInfo.getInviteID() + ", accepter:" + str2);
            Iterator<V2TIMSignalingInfo> it9 = this.invitationList.iterator();
            while (true) {
                if (!it9.hasNext()) {
                    break;
                }
                V2TIMSignalingInfo next8 = it9.next();
                if (next8.getInviteID().equals(signalingInfo.getInviteID())) {
                    next8.getInviteeList().remove(str2);
                    if (next8.getInviteeList().size() == 0) {
                        this.invitationList.remove(next8);
                    }
                }
            }
            synchronized (this) {
                Iterator<V2TIMSignalingListener> it10 = this.mSignalingListenerList.iterator();
                while (it10.hasNext()) {
                    V2TIMSignalingListener next9 = it10.next();
                    if (next9 != null) {
                        next9.onInviteeAccepted(signalingInfo.getInviteID(), str2, signalingInfo.getData());
                    }
                }
            }
        }
        return signalingInfo;
    }

    /* access modifiers changed from: private */
    public void notifyOnRecvMessage(TIMMessage tIMMessage) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setTIMMessage(tIMMessage);
        V2TIMManagerImpl.getInstance().onRecvNewMessage(v2TIMMessage);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public V2TIMSignalingInfo getSignalingInfo(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null || v2TIMMessage.getElemType() != 2) {
            QLog.e("V2TIMSigMgrImpl", "signaling getSignalingInfo failed, msg maybe null or must have custom elem");
            return null;
        }
        TIMConversation conversation = v2TIMMessage.getTIMMessage().getConversation();
        if (conversation != null) {
            return new V2TIMConversationInternal(conversation).getSignalingInfo(v2TIMMessage.getTIMMessage());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public TIMConversation getConversationFromSignaling(V2TIMSignalingInfo v2TIMSignalingInfo, boolean z) {
        if (v2TIMSignalingInfo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(v2TIMSignalingInfo.getGroupID())) {
            return TIMManager.getInstance().getConversation(TIMConversationType.Group, v2TIMSignalingInfo.getGroupID());
        }
        if (z) {
            return TIMManager.getInstance().getConversation(TIMConversationType.C2C, v2TIMSignalingInfo.getInviteeList().get(0));
        }
        return TIMManager.getInstance().getConversation(TIMConversationType.C2C, v2TIMSignalingInfo.getInviter());
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void addInvitedSignaling(final V2TIMSignalingInfo v2TIMSignalingInfo, final V2TIMCallback v2TIMCallback) {
        if (v2TIMSignalingInfo == null || TextUtils.isEmpty(v2TIMSignalingInfo.getInviteID()) || TextUtils.isEmpty(v2TIMSignalingInfo.getInviter()) || v2TIMSignalingInfo.getInviteeList() == null || v2TIMSignalingInfo.getInviteeList().isEmpty()) {
            QLog.e("V2TIMSigMgrImpl", "addInvitedSignaling, info is invalid");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "V2TIMSignalingInfo is invalid");
            }
        } else if (!this.invitationList.contains(v2TIMSignalingInfo)) {
            for (V2TIMSignalingInfo v2TIMSignalingInfo2 : this.invitationList) {
                if (TextUtils.equals(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo.getInviteID())) {
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(8012, "inviteID " + v2TIMSignalingInfo.getInviteID() + " is exist");
                        return;
                    }
                    return;
                }
            }
            IMContext.getInstance().runOnMainThread(new Runnable() {
                /* class com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.AnonymousClass9 */

                @Override // java.lang.Runnable
                public void run() {
                    V2TIMSignalingManagerImpl.this.invitationList.add(v2TIMSignalingInfo);
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(8012, "V2TIMSignalingInfo is exist");
        }
    }
}
