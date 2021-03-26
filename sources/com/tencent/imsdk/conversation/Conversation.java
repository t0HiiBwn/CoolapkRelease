package com.tencent.imsdk.conversation;

import com.tencent.imsdk.IMBridge;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMGroupAtInfo;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.ext.message.TIMBatchOprDetailInfo;
import com.tencent.imsdk.ext.message.TIMMessageDraft;
import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.ext.message.TIMSendMsgToMultiUserCallback;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.utils.IMErrInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Conversation {
    private static final String TAG = "Conversation";
    private transient long cptr;

    private static native void nativeDeleteConversation(long j);

    private native void nativeDeleteLocalMessage(long j, ICallback iCallback);

    private native void nativeDeleteMessages(long j, List<Long> list, ICallback iCallback);

    private native void nativeFindMessage(long j, List<TIMMessageLocator> list, ICallback<List<Msg>> iCallback);

    private native long nativeGetActiveTime(long j);

    private static native long nativeGetConversation(int i, String str);

    private static native TIMMessageDraft nativeGetDraft(long j);

    private native List<TIMGroupAtInfo> nativeGetGroupAtInfoList(long j);

    private static native String nativeGetGroupName(long j);

    private static native Msg nativeGetLastMsg(long j);

    private native void nativeGetMessage(long j, long j2, int i, boolean z, boolean z2, ICallback<List<Msg>> iCallback);

    private static native int nativeGetUnreadNum(long j);

    private static native boolean nativeHasDraft(long j);

    private native int nativeImportMessage(long j, List<Long> list);

    private native void nativeReportReaded(long j, long j2, ICallback iCallback);

    private native void nativeRevokeMessage(long j, long j2, ICallback iCallback);

    private native int nativeSaveMessage(long j, long j2, String str, boolean z);

    private native void nativeSendMessage(long j, long j2, boolean z, ICallback iCallback);

    private static native void nativeSendMessageToMultiUsers(long j, List<String> list, ICallback<TIMBatchOprDetailInfo> iCallback);

    private static native void nativeSetDraft(long j, TIMMessageDraft tIMMessageDraft);

    protected Conversation(long j) {
        this.cptr = j;
    }

    public Conversation(int i, String str) {
        this(nativeGetConversation(i, str));
    }

    public static void sendMessageToMultiUsers(List<String> list, TIMMessage tIMMessage, final TIMSendMsgToMultiUserCallback tIMSendMsgToMultiUserCallback) {
        if (tIMSendMsgToMultiUserCallback != null) {
            if (list == null || list.isEmpty()) {
                tIMSendMsgToMultiUserCallback.onError(6017, "users can't be null or empty", null);
            } else if (tIMMessage == null || IMBridge.getMsgFromTIMMessage(tIMMessage) == null) {
                tIMSendMsgToMultiUserCallback.onError(6017, "invalid msg", null);
            } else {
                nativeSendMessageToMultiUsers(IMBridge.getMsgFromTIMMessage(tIMMessage).getCptr(), list, new ICallback<TIMBatchOprDetailInfo>(new TIMValueCallBack<TIMBatchOprDetailInfo>() {
                    /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass1 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(final int i, final String str) {
                        String str2 = Conversation.TAG;
                        QLog.e(str2, "sendMessageToMultiUsers onError:" + i + "|msg:" + str);
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (tIMSendMsgToMultiUserCallback != null) {
                                    tIMSendMsgToMultiUserCallback.onError(i, str, null);
                                }
                            }
                        });
                    }

                    public void onSuccess(final TIMBatchOprDetailInfo tIMBatchOprDetailInfo) {
                        QLog.i(Conversation.TAG, "sendMessageToMultiUsers onSuccess");
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass1.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (tIMSendMsgToMultiUserCallback != null) {
                                    if (tIMBatchOprDetailInfo == null) {
                                        tIMSendMsgToMultiUserCallback.onSuccess();
                                    } else {
                                        tIMSendMsgToMultiUserCallback.onError(6003, "please check detail info", tIMBatchOprDetailInfo);
                                    }
                                }
                            }
                        });
                    }
                }) {
                    /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass2 */

                    public void done(TIMBatchOprDetailInfo tIMBatchOprDetailInfo) {
                        this.valueCallback.onSuccess(tIMBatchOprDetailInfo);
                    }

                    @Override // com.tencent.imsdk.common.ICallback
                    public void fail(int i, String str) {
                        this.valueCallback.onError(i, str);
                    }
                });
            }
        }
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.cptr;
        if (j != 0) {
            nativeDeleteConversation(j);
            this.cptr = 0;
        }
    }

    public int getUnreadMessageNum() {
        return nativeGetUnreadNum(this.cptr);
    }

    public long getActiveTime() {
        return nativeGetActiveTime(this.cptr);
    }

    public TIMMessage getLastMsg() {
        return IMBridge.convertMsgToTIMMessage(nativeGetLastMsg(this.cptr));
    }

    public boolean hasDraft() {
        return nativeHasDraft(this.cptr);
    }

    public TIMMessageDraft getDraft() {
        return nativeGetDraft(this.cptr);
    }

    public void setDraft(TIMMessageDraft tIMMessageDraft) {
        nativeSetDraft(this.cptr, tIMMessageDraft);
    }

    public void reportReaded(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            long j = 0;
            if (!(tIMMessage == null || IMBridge.getMsgFromTIMMessage(tIMMessage) == null)) {
                j = IMBridge.getMsgFromTIMMessage(tIMMessage).getCptr();
            }
            nativeReportReaded(this.cptr, j, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass3 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i(Conversation.TAG, "reportReaded success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    String str2 = Conversation.TAG;
                    QLog.e(str2, "reportReaded fail code:" + i + "|msg:" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void deleteLocalMessage(TIMCallBack tIMCallBack) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteLocalMessage(this.cptr, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass4 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i(Conversation.TAG, "deleteLocalMessage success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    String str2 = Conversation.TAG;
                    QLog.e(str2, "deleteLocalMessage fail code:" + i + "|msg:" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6013, "sdk not init");
        }
    }

    public void deleteMessages(List<TIMMessage> list, final TIMCallBack tIMCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (this.cptr == 0) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6004, "conversation is invalid");
            }
        } else if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (TIMMessage tIMMessage : list) {
                Msg msgFromTIMMessage = IMBridge.getMsgFromTIMMessage(tIMMessage);
                if (msgFromTIMMessage == null || msgFromTIMMessage.getCptr() == 0) {
                    QLog.e(TAG, "deleteMessages, invalid msg");
                } else {
                    arrayList.add(Long.valueOf(msgFromTIMMessage.getCptr()));
                }
            }
            if (!arrayList.isEmpty()) {
                nativeDeleteMessages(this.cptr, arrayList, new ICallback(new TIMCallBack() {
                    /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass5 */

                    @Override // com.tencent.imsdk.TIMCallBack
                    public void onError(final int i, final String str) {
                        String str2 = Conversation.TAG;
                        QLog.e(str2, "deleteMessages onError code:" + i + "|descr: " + str);
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass5.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (tIMCallBack != null) {
                                    tIMCallBack.onError(i, str);
                                }
                            }
                        });
                    }

                    @Override // com.tencent.imsdk.TIMCallBack
                    public void onSuccess() {
                        QLog.i(Conversation.TAG, "deleteMessages success");
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass5.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (tIMCallBack != null) {
                                    tIMCallBack.onSuccess();
                                }
                            }
                        });
                    }
                }) {
                    /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass6 */

                    @Override // com.tencent.imsdk.common.ICallback
                    public void done(Object obj) {
                        QLog.i(Conversation.TAG, "nativeDeleteMessages success");
                        super.done(obj);
                    }

                    @Override // com.tencent.imsdk.common.ICallback
                    public void fail(int i, String str) {
                        String str2 = Conversation.TAG;
                        QLog.e(str2, "nativeDeleteMessages fail code:" + i + "|msg:" + str);
                        super.fail(i, str);
                    }
                });
            } else if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "messages has no valid item");
            }
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6017, "messages is empty");
        }
    }

    public void revokeMessage(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMCallBack != null) {
                tIMCallBack.onError(6013, "sdk not init");
            }
        } else if (tIMMessage != null && IMBridge.getMsgFromTIMMessage(tIMMessage) != null) {
            nativeRevokeMessage(this.cptr, IMBridge.getMsgFromTIMMessage(tIMMessage).getCptr(), new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass7 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i(Conversation.TAG, "revokeMessage success");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    String str2 = Conversation.TAG;
                    QLog.e(str2, "revokeMessage fail code:" + i + "|msg:" + str);
                    super.fail(i, str);
                }
            });
        } else if (tIMCallBack != null) {
            tIMCallBack.onError(6017, "invalid msg");
        }
    }

    public int saveMessage(TIMMessage tIMMessage, String str, boolean z) {
        if (!BaseManager.getInstance().isInited()) {
            return 6013;
        }
        if (this.cptr == 0) {
            return 6004;
        }
        Msg msgFromTIMMessage = IMBridge.getMsgFromTIMMessage(tIMMessage);
        if (msgFromTIMMessage != null && msgFromTIMMessage.getCptr() != 0) {
            return nativeSaveMessage(this.cptr, msgFromTIMMessage.getCptr(), str, z);
        }
        QLog.e(TAG, "saveMessage failed, invalid msg");
        return 6017;
    }

    public int importMsg(List<TIMMessage> list) {
        if (!BaseManager.getInstance().isInited()) {
            return 6013;
        }
        if (this.cptr == 0) {
            return 6004;
        }
        if (list == null || list.isEmpty()) {
            return 6017;
        }
        ArrayList arrayList = new ArrayList();
        for (TIMMessage tIMMessage : list) {
            Msg msgFromTIMMessage = IMBridge.getMsgFromTIMMessage(tIMMessage);
            if (msgFromTIMMessage == null || msgFromTIMMessage.getCptr() == 0) {
                QLog.e(TAG, "importMsg, invalid msg");
            } else {
                arrayList.add(Long.valueOf(msgFromTIMMessage.getCptr()));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        return nativeImportMessage(this.cptr, arrayList);
    }

    public void sendMessage(boolean z, boolean z2, TIMMessage tIMMessage, TIMValueCallBack<TIMMessage> tIMValueCallBack) {
        IMErrInfo readyCheck = IMContext.getInstance().readyCheck();
        if (readyCheck.getCode() == 0 || tIMValueCallBack == null) {
            Msg msgFromTIMMessage = IMBridge.getMsgFromTIMMessage(tIMMessage);
            if (msgFromTIMMessage != null && msgFromTIMMessage.getCptr() != 0) {
                if (z) {
                    msgFromTIMMessage.setLifetime(0);
                }
                nativeSendMessage(this.cptr, msgFromTIMMessage.getCptr(), z2, new SendMsgCallback(tIMMessage, tIMValueCallBack));
            } else if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6021, "invalid msg");
            }
        } else {
            tIMValueCallBack.onError(readyCheck.getCode(), readyCheck.getMsg());
        }
    }

    public void getMessages(int i, TIMMessage tIMMessage, boolean z, boolean z2, final TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        IMErrInfo readyCheck = IMContext.getInstance().readyCheck();
        if (!z || readyCheck.getCode() == 0) {
            if (!z2 || tIMMessage != null) {
                Msg msgFromTIMMessage = IMBridge.getMsgFromTIMMessage(tIMMessage);
                nativeGetMessage(this.cptr, msgFromTIMMessage != null ? msgFromTIMMessage.getCptr() : 0, i, z, z2, new GetMsgsListener(new TIMValueCallBack<List<Msg>>() {
                    /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass8 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(final int i, final String str) {
                        String str2 = Conversation.TAG;
                        QLog.e(str2, "getMessages onError code:" + i + "|descr: " + str);
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass8.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (tIMValueCallBack != null) {
                                    tIMValueCallBack.onError(i, str);
                                }
                            }
                        });
                    }

                    public void onSuccess(List<Msg> list) {
                        QLog.i(Conversation.TAG, "getMessages success");
                        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (Msg msg : list) {
                            if (msg != null) {
                                copyOnWriteArrayList.add(IMBridge.convertMsgToTIMMessage(msg));
                            }
                        }
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass8.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (tIMValueCallBack != null) {
                                    tIMValueCallBack.onSuccess(copyOnWriteArrayList);
                                }
                            }
                        });
                    }
                }) {
                    /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass9 */
                });
            } else if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6017, "lastMsg can't be null");
            }
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(readyCheck.getCode(), readyCheck.getMsg());
        }
    }

    public List<TIMGroupAtInfo> getGroupAtInfoList() {
        if (!BaseManager.getInstance().isInited()) {
            return new ArrayList();
        }
        long j = this.cptr;
        if (j == 0) {
            return new ArrayList();
        }
        List<TIMGroupAtInfo> nativeGetGroupAtInfoList = nativeGetGroupAtInfoList(j);
        return nativeGetGroupAtInfoList == null ? new ArrayList() : nativeGetGroupAtInfoList;
    }

    public void findMessages(List<TIMMessageLocator> list, final TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (this.cptr == 0) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6004, "invalid converstion");
            }
        } else if (list != null && !list.isEmpty()) {
            nativeFindMessage(this.cptr, new ArrayList(list), new GetMsgsListener(new TIMValueCallBack<List<Msg>>() {
                /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass10 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(final int i, final String str) {
                    String str2 = Conversation.TAG;
                    QLog.e(str2, "findMessages onError code:" + i + "|descr:" + str);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass10.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (tIMValueCallBack != null) {
                                tIMValueCallBack.onError(i, str);
                            }
                        }
                    });
                }

                public void onSuccess(List<Msg> list) {
                    QLog.i(Conversation.TAG, "findMessages success");
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (Msg msg : list) {
                        if (msg != null) {
                            copyOnWriteArrayList.add(IMBridge.convertMsgToTIMMessage(msg));
                        }
                    }
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass10.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (tIMValueCallBack != null) {
                                tIMValueCallBack.onSuccess(copyOnWriteArrayList);
                            }
                        }
                    });
                }
            }) {
                /* class com.tencent.imsdk.conversation.Conversation.AnonymousClass11 */
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6017, "locators can't be null");
        }
    }

    public String getGroupName() {
        if (BaseManager.getInstance().isInited()) {
            return nativeGetGroupName(this.cptr);
        }
        QLog.e(TAG, "getGroupName error, sdk not init");
        return null;
    }

    private static abstract class GetMsgsListener extends ICallback<List<Msg>> {
        public GetMsgsListener(TIMValueCallBack<List<Msg>> tIMValueCallBack) {
            super(tIMValueCallBack);
        }

        public final void done(List<Msg> list) {
            QLog.i(Conversation.TAG, "GetMessage success");
            this.valueCallback.onSuccess(list);
        }

        @Override // com.tencent.imsdk.common.ICallback
        public final void fail(int i, String str) {
            String str2 = Conversation.TAG;
            QLog.e(str2, "GetMessage code:" + i + "|msg:" + str);
            this.valueCallback.onError(i, str);
        }
    }

    private class SendMsgCallback extends ICallback<TIMMessage> {
        private TIMMessage msg;

        public SendMsgCallback(TIMMessage tIMMessage, TIMValueCallBack<TIMMessage> tIMValueCallBack) {
            super(tIMValueCallBack);
            this.msg = tIMMessage;
        }

        public void done(TIMMessage tIMMessage) {
            QLog.i(Conversation.TAG, "SendMessage success");
            IMContext.getInstance().runOnMainThread(new Runnable() {
                /* class com.tencent.imsdk.conversation.Conversation.SendMsgCallback.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (SendMsgCallback.this.valueCallback != null) {
                        SendMsgCallback.this.valueCallback.onSuccess(SendMsgCallback.this.msg);
                    }
                }
            });
        }

        @Override // com.tencent.imsdk.common.ICallback
        public void fail(final int i, final String str) {
            String str2 = Conversation.TAG;
            QLog.e(str2, "SendMessage fail code:" + i + "|msg:" + str);
            IMContext.getInstance().runOnMainThread(new Runnable() {
                /* class com.tencent.imsdk.conversation.Conversation.SendMsgCallback.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (SendMsgCallback.this.valueCallback != null) {
                        SendMsgCallback.this.valueCallback.onError(i, str);
                    }
                }
            });
        }
    }
}
