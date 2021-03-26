package com.tencent.imsdk.conversation;

import com.tencent.imsdk.IMBridge;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationSucc;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMElemType;
import com.tencent.imsdk.TIMFileElem;
import com.tencent.imsdk.TIMImageElem;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageListener;
import com.tencent.imsdk.TIMMessageUpdateListener;
import com.tencent.imsdk.TIMOfflinePushListener;
import com.tencent.imsdk.TIMRefreshListener;
import com.tencent.imsdk.TIMSoundElem;
import com.tencent.imsdk.TIMUploadProgressListener;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.TIMVideoElem;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.ext.message.TIMMessageReceipt;
import com.tencent.imsdk.ext.message.TIMMessageReceiptListener;
import com.tencent.imsdk.ext.message.TIMMessageRevokedListener;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConversationManager {
    private static final String TAG = ("imsdk." + ConversationManager.class.getSimpleName());
    private ConversationListener conversationListenerProxy;
    private CopyOnWriteArrayList<TIMMessageListener> msgListeners;
    private CopyOnWriteArrayList<TIMMessageUpdateListener> msgUpdateListeners;
    private TIMOfflinePushListener offlinePushListener;
    private TIMMessageReceiptListener receiptListener;
    private TIMRefreshListener refreshListener;
    private TIMMessageRevokedListener revokedListener;
    private TIMUploadProgressListener uploadProgressListener;

    private native void nativeDeleteConversation(int i, String str, ICallback iCallback);

    private native void nativeDeleteConversationAndLocalMsgs(int i, String str, ICallback iCallback);

    private native void nativeFindMessageByMessageID(List<String> list, ICallback iCallback);

    private native void nativeGetConversationList(long j, int i, ICallback iCallback);

    private native void nativeGetConversations(List<TIMConversation> list);

    private native void nativeParseMsg(String str, byte[] bArr, ICallback<Msg> iCallback);

    private native void nativeSetConversationListener(ConversationListener conversationListener);

    private native void nativeSetMessageListener(MessageListener messageListener);

    private ConversationManager() {
        this.msgListeners = new CopyOnWriteArrayList<>();
        this.msgUpdateListeners = new CopyOnWriteArrayList<>();
    }

    public static ConversationManager getInstance() {
        return Holder.instant;
    }

    public void init() {
        setConversationListener();
        setMessageListener();
    }

    public void setConversationListenerProxy(ConversationListener conversationListener) {
        this.conversationListenerProxy = conversationListener;
    }

    public synchronized void addMessageListener(TIMMessageListener tIMMessageListener) {
        String str = TAG;
        QLog.i(str, "addMessageListener: " + tIMMessageListener);
        if (this.msgListeners.contains(tIMMessageListener)) {
            QLog.i(str, "addMessageListener: added this listener object before, ignore");
        } else {
            this.msgListeners.add(tIMMessageListener);
        }
    }

    public synchronized void removeMessageListener(TIMMessageListener tIMMessageListener) {
        String str = TAG;
        QLog.i(str, "removeMessageListener: " + tIMMessageListener);
        this.msgListeners.remove(tIMMessageListener);
    }

    public synchronized List<TIMMessageListener> getMessageListeners() {
        return this.msgListeners;
    }

    public synchronized void addMessageUpdateListener(TIMMessageUpdateListener tIMMessageUpdateListener) {
        String str = TAG;
        QLog.i(str, "addMessageUpdateListener: " + tIMMessageUpdateListener);
        if (this.msgUpdateListeners.contains(tIMMessageUpdateListener)) {
            QLog.i(str, "addMessageUpdateListener: added this listener object before, ignore");
        } else {
            this.msgUpdateListeners.add(tIMMessageUpdateListener);
        }
    }

    public synchronized void removeMessageUpdateListener(TIMMessageUpdateListener tIMMessageUpdateListener) {
        String str = TAG;
        QLog.i(str, "removeMessageUpdateListener: " + tIMMessageUpdateListener);
        this.msgUpdateListeners.remove(tIMMessageUpdateListener);
    }

    public synchronized CopyOnWriteArrayList<TIMMessageUpdateListener> getMsgUpdateListeners() {
        return this.msgUpdateListeners;
    }

    public TIMMessageRevokedListener getRevokedListener() {
        return this.revokedListener;
    }

    public TIMMessageReceiptListener getReceiptListener() {
        return this.receiptListener;
    }

    public TIMOfflinePushListener getOfflinePushListener() {
        return this.offlinePushListener;
    }

    public void setOfflinePushListener(TIMOfflinePushListener tIMOfflinePushListener) {
        String str = TAG;
        QLog.i(str, "setOfflinePushListener: " + tIMOfflinePushListener);
        this.offlinePushListener = tIMOfflinePushListener;
    }

    protected TIMRefreshListener getRefreshListener() {
        return this.refreshListener;
    }

    public void setRefreshListener(TIMRefreshListener tIMRefreshListener) {
        this.refreshListener = tIMRefreshListener;
    }

    public TIMUploadProgressListener getUploadProgressListener() {
        return this.uploadProgressListener;
    }

    public void setUploadProgressListener(TIMUploadProgressListener tIMUploadProgressListener) {
        this.uploadProgressListener = tIMUploadProgressListener;
    }

    private void setConversationListener() {
        nativeSetConversationListener(new ConversationListener() {
            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1 */

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onAddConversation(List<TIMConversation> list) {
                if (ConversationManager.this.refreshListener != null) {
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.refreshListener.onRefresh();
                            ConversationManager.this.refreshListener.onRefreshConversation(copyOnWriteArrayList);
                        }
                    });
                } else {
                    QLog.w(ConversationManager.TAG, "onAddConversation, no refresh listener found");
                }
                if (ConversationManager.this.conversationListenerProxy != null) {
                    final CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(list);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.conversationListenerProxy.onAddConversation(copyOnWriteArrayList2);
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onDeleteConversation(List<TIMConversation> list) {
                if (ConversationManager.this.refreshListener != null) {
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.refreshListener.onRefresh();
                            ConversationManager.this.refreshListener.onRefreshConversation(copyOnWriteArrayList);
                        }
                    });
                } else {
                    QLog.w(ConversationManager.TAG, "onDelConversation, no refresh listener found");
                }
                if (ConversationManager.this.conversationListenerProxy != null) {
                    final CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(list);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass4 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.conversationListenerProxy.onDeleteConversation(copyOnWriteArrayList2);
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onUpdateConversation(List<TIMConversation> list) {
                if (ConversationManager.this.refreshListener != null) {
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.refreshListener.onRefresh();
                            ConversationManager.this.refreshListener.onRefreshConversation(copyOnWriteArrayList);
                        }
                    });
                } else {
                    QLog.w(ConversationManager.TAG, "onUpdateConversation, no refresh listener found");
                }
                if (ConversationManager.this.conversationListenerProxy != null) {
                    final CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(list);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass6 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.conversationListenerProxy.onUpdateConversation(copyOnWriteArrayList2);
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onSyncServerStart() {
                if (ConversationManager.this.conversationListenerProxy != null) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass7 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.conversationListenerProxy.onSyncServerStart();
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onSyncServerFinish() {
                if (ConversationManager.this.conversationListenerProxy != null) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass8 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.conversationListenerProxy.onSyncServerFinish();
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.ConversationListener
            public void onSyncServerFailed() {
                if (ConversationManager.this.conversationListenerProxy != null) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass1.AnonymousClass9 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.conversationListenerProxy.onSyncServerFailed();
                        }
                    });
                }
            }
        });
    }

    private void setMessageListener() {
        nativeSetMessageListener(new MessageListener() {
            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass2 */

            @Override // com.tencent.imsdk.conversation.MessageListener
            public void onRecvMessage(List<Msg> list) {
                String str = ConversationManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("RecvMsg|msg size: ");
                sb.append(list.size());
                sb.append("|listeners: ");
                sb.append(ConversationManager.this.msgListeners == null ? 0 : ConversationManager.this.msgListeners.size());
                QLog.i(str, sb.toString());
                final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                for (Msg msg : list) {
                    copyOnWriteArrayList.add(IMBridge.convertMsgToTIMMessage(msg));
                }
                if (!(ConversationManager.this.msgListeners == null || ConversationManager.this.msgListeners.isEmpty())) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass2.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (ConversationManager.this) {
                                Iterator it2 = ConversationManager.this.msgListeners.iterator();
                                while (it2.hasNext() && !((TIMMessageListener) it2.next()).onNewMessages(copyOnWriteArrayList)) {
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.MessageListener
            public void onUpdateMessage(List<Msg> list) {
                if (ConversationManager.this.msgUpdateListeners == null || ConversationManager.this.msgUpdateListeners.isEmpty()) {
                    QLog.w(ConversationManager.TAG, "msg update listener not found");
                    return;
                }
                final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                for (Msg msg : list) {
                    copyOnWriteArrayList.add(IMBridge.convertMsgToTIMMessage(msg));
                }
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass2.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ConversationManager.this) {
                            Iterator it2 = ConversationManager.this.msgUpdateListeners.iterator();
                            while (it2.hasNext()) {
                                ((TIMMessageUpdateListener) it2.next()).onMessagesUpdate(copyOnWriteArrayList);
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.conversation.MessageListener
            public void onRecvMessageReceipts(final List<TIMMessageReceipt> list) {
                if (ConversationManager.this.receiptListener == null) {
                    QLog.w(ConversationManager.TAG, "msg receipt listener not found");
                } else {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass2.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.receiptListener.onRecvReceipt(list);
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.MessageListener
            public void onRevokeMessage(final List<TIMMessageLocator> list) {
                if (ConversationManager.this.revokedListener == null) {
                    QLog.w(ConversationManager.TAG, "msg revoke listener not found");
                } else {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass2.AnonymousClass4 */

                        @Override // java.lang.Runnable
                        public void run() {
                            for (TIMMessageLocator tIMMessageLocator : list) {
                                ConversationManager.this.revokedListener.onMessageRevoked(tIMMessageLocator);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.conversation.MessageListener
            public void onUploadProgress(Msg msg, final int i, final long j, final long j2) {
                final int i2;
                int i3;
                if (ConversationManager.this.uploadProgressListener != null) {
                    TIMElem element = msg.getElement(i);
                    int i4 = AnonymousClass8.$SwitchMap$com$tencent$imsdk$TIMElemType[element.getType().ordinal()];
                    if (i4 == 1) {
                        i3 = ((TIMFileElem) element).getTaskId();
                    } else if (i4 == 2) {
                        i3 = ((TIMSoundElem) element).getTaskId();
                    } else if (i4 != 3) {
                        if (i4 != 4) {
                            i2 = 0;
                        } else {
                            i2 = (int) ((TIMVideoElem) element).getTaskId();
                        }
                        final TIMMessage convertMsgToTIMMessage = IMBridge.convertMsgToTIMMessage(msg);
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass2.AnonymousClass5 */

                            @Override // java.lang.Runnable
                            public void run() {
                                ConversationManager.this.uploadProgressListener.onMessagesUpdate(convertMsgToTIMMessage, i, i2, (int) ((j * 100) / j2));
                            }
                        });
                    } else {
                        i3 = ((TIMImageElem) element).getTaskId();
                    }
                    i2 = i3;
                    final TIMMessage convertMsgToTIMMessage = IMBridge.convertMsgToTIMMessage(msg);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass2.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ConversationManager.this.uploadProgressListener.onMessagesUpdate(convertMsgToTIMMessage, i, i2, (int) ((j * 100) / j2));
                        }
                    });
                }
            }
        });
    }

    /* renamed from: com.tencent.imsdk.conversation.ConversationManager$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$imsdk$TIMElemType;

        static {
            int[] iArr = new int[TIMElemType.values().length];
            $SwitchMap$com$tencent$imsdk$TIMElemType = iArr;
            try {
                iArr[TIMElemType.File.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMElemType[TIMElemType.Sound.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMElemType[TIMElemType.Image.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$imsdk$TIMElemType[TIMElemType.Video.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void setMessageReceiptListener(TIMMessageReceiptListener tIMMessageReceiptListener) {
        this.receiptListener = tIMMessageReceiptListener;
    }

    public void setMessageRevokedListener(TIMMessageRevokedListener tIMMessageRevokedListener) {
        this.revokedListener = tIMMessageRevokedListener;
    }

    public TIMConversation getConversation(TIMConversationType tIMConversationType, String str) {
        return IMBridge.newTIMConversation(tIMConversationType, str);
    }

    public List<TIMConversation> getConversationList() {
        if (!BaseManager.getInstance().isInited()) {
            QLog.e(TAG, "getConversationList error, sdk not init");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        nativeGetConversations(arrayList);
        return arrayList;
    }

    public void getConversationList(long j, int i, TIMValueCallBack<TIMConversationSucc> tIMValueCallBack) {
        nativeGetConversationList(j, i, new ICallback(tIMValueCallBack) {
            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass3 */

            @Override // com.tencent.imsdk.common.ICallback
            public void done(Object obj) {
                super.done(obj);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }
        });
    }

    public void deleteConversation(TIMConversationType tIMConversationType, String str) {
        if (!BaseManager.getInstance().isInited()) {
            QLog.e(TAG, "deleteConversation error, sdk not init");
        } else {
            nativeDeleteConversation(tIMConversationType.value(), str, new ICallback(null) {
                /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass4 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    if (this.cb != null) {
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass4.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass4.this.cb.onSuccess();
                            }
                        });
                    }
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(final int i, final String str) {
                    if (this.cb != null) {
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass4.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass4.this.cb.onError(i, str);
                            }
                        });
                    }
                }
            });
        }
    }

    public void deleteConversationAndLocalMsgs(TIMConversationType tIMConversationType, String str) {
        if (!BaseManager.getInstance().isInited()) {
            QLog.e(TAG, "deleteConverationAndLocalMsgs error, sdk not init");
        } else {
            nativeDeleteConversationAndLocalMsgs(tIMConversationType.value(), str, new ICallback(null) {
                /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass5 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    if (this.cb != null) {
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass5.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass5.this.cb.onSuccess();
                            }
                        });
                    }
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(final int i, final String str) {
                    if (this.cb != null) {
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass5.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass5.this.cb.onError(i, str);
                            }
                        });
                    }
                }
            });
        }
    }

    public void findMessageByMessageID(List<String> list, final TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (!BaseManager.getInstance().isInited()) {
            if (tIMValueCallBack != null) {
                tIMValueCallBack.onError(6013, "sdk not init");
            }
        } else if (list != null && !list.isEmpty()) {
            nativeFindMessageByMessageID(list, new ICallback(new TIMValueCallBack<List<Msg>>() {
                /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass6 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(final int i, final String str) {
                    String str2 = ConversationManager.TAG;
                    QLog.e(str2, "findMessageByMessageID onError code:" + i + "|descr:" + str);
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass6.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (tIMValueCallBack != null) {
                                tIMValueCallBack.onError(i, str);
                            }
                        }
                    });
                }

                public void onSuccess(List<Msg> list) {
                    QLog.i(ConversationManager.TAG, "findMessageByMessageID success");
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (Msg msg : list) {
                        if (msg != null) {
                            copyOnWriteArrayList.add(IMBridge.convertMsgToTIMMessage(msg));
                        }
                    }
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass6.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (tIMValueCallBack != null) {
                                tIMValueCallBack.onSuccess(copyOnWriteArrayList);
                            }
                        }
                    });
                }
            }) {
                /* class com.tencent.imsdk.conversation.ConversationManager.AnonymousClass7 */
            });
        } else if (tIMValueCallBack != null) {
            tIMValueCallBack.onError(6017, "messageIDList can't be null");
        }
    }

    private static class Holder {
        public static ConversationManager instant = new ConversationManager();

        private Holder() {
        }
    }
}
