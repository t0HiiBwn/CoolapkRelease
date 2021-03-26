package com.tencent.imsdk.conversation;

import android.text.TextUtils;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMMessageOfflinePushSettings;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.friendship.FriendshipNativeManager;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.List;

public class Msg {
    public static final int DOWNLOAD_TYPE_AUDIO = 3;
    public static final int DOWNLOAD_TYPE_FILE = 1;
    public static final int DOWNLOAD_TYPE_SNAPSHOT = 0;
    public static final int DOWNLOAD_TYPE_VIDEO = 2;
    private static final String TAG = "Msg";
    private transient long cptr;

    private static native int nativeAddElem(long j, int i, TIMElem tIMElem);

    private static native boolean nativeConvertToImportedMsg(long j);

    private static native long nativeCopyFrom(long j);

    private static native void nativeDeleteMsg(long j);

    private static native void nativeDownloadElem(int i, String str, String str2, ICallback<ProgressInfo> iCallback, ICallback iCallback2);

    private static native int nativeElemSize(long j);

    private static native String nativeGetCloudCustomData(long j);

    private static native TIMConversation nativeGetConversation(long j);

    private static native int nativeGetCustomInt(long j);

    private static native String nativeGetCustomStr(long j);

    private static native TIMElem nativeGetElement(long j, int i);

    private static native List<String> nativeGetGroupAtUserList(long j);

    private static native void nativeGetLocator(long j, TIMMessageLocator tIMMessageLocator);

    private static native String nativeGetMsgId(long j);

    private static native boolean nativeGetOfflinePushInfo(long j, TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings);

    private static native String nativeGetSender(long j);

    private static native TIMGroupMemberInfo nativeGetSenderGroupMemberInfo(long j);

    private static native boolean nativeGetSenderProfile(long j, TIMUserProfile tIMUserProfile);

    private static native boolean nativeIsPeerRead(long j);

    private static native boolean nativeIsRead(long j);

    private static native boolean nativeIsSelf(long j);

    private static native long nativeMsgLifetime(long j);

    private static native int nativeMsgPriority(long j);

    private static native long nativeMsgRand(long j);

    private static native int nativeMsgRecvFlag(long j);

    private static native long nativeMsgSeq(long j);

    private static native int nativeMsgStatus(long j);

    private static native long nativeMsgTime(long j);

    private static native long nativeMsgUniqueId(long j);

    private static native long nativeNewMsg();

    private static native boolean nativeRemove(long j);

    private static native void nativeRequestDownloadUrl(int i, int i2, String str, ICallback<List<String>> iCallback);

    private static native boolean nativeSetCloudCustomData(long j, String str);

    private static native boolean nativeSetCustomInt(long j, int i);

    private static native boolean nativeSetCustomStr(long j, String str);

    private static native boolean nativeSetGroupAtUserList(long j, List<String> list);

    private static native void nativeSetLifetime(long j, int i);

    private static native void nativeSetOfflinePushInfo(long j, TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings);

    private static native void nativeSetPriority(long j, int i);

    private static native boolean nativeSetSender(long j, String str);

    private static native boolean nativeSetTimestamp(long j, long j2);

    protected Msg(long j) {
        this.cptr = j;
    }

    public Msg() {
        this(nativeNewMsg());
    }

    public static void downloadToFile(int i, String str, String str2, TIMValueCallBack<ProgressInfo> tIMValueCallBack, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                QLog.e(TAG, "Invalid param");
                tIMCallBack.onError(6017, "invalid params");
                return;
            }
            nativeDownloadElem(i, str, str2, new ICallback<ProgressInfo>(tIMValueCallBack) {
                /* class com.tencent.imsdk.conversation.Msg.AnonymousClass1 */

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                }

                public void done(final ProgressInfo progressInfo) {
                    if (this.valueCallback != null) {
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.conversation.Msg.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (progressInfo.getCurrentSize() == progressInfo.getTotalSize()) {
                                    QLog.i(Msg.TAG, "download finished, progress cb");
                                }
                                AnonymousClass1.this.valueCallback.onSuccess(progressInfo);
                            }
                        });
                    } else if (progressInfo.getCurrentSize() == progressInfo.getTotalSize()) {
                        QLog.e(Msg.TAG, "download finished, no progress cb found");
                    }
                }
            }, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.conversation.Msg.AnonymousClass2 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.Msg.AnonymousClass2.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.i(Msg.TAG, "download req succ");
                            AnonymousClass2.this.cb.onSuccess();
                        }
                    });
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(final int i, final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.conversation.Msg.AnonymousClass2.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            String str = Msg.TAG;
                            QLog.i(str, "download req failed, code " + i + "|desc: " + str);
                            AnonymousClass2.this.cb.onError(i, str);
                        }
                    });
                }
            });
        }
    }

    public static void requestDownloadUrl(int i, int i2, String str, TIMValueCallBack<List<String>> tIMValueCallBack) {
        nativeRequestDownloadUrl(i, i2, str, new ICallback<List<String>>(tIMValueCallBack) {
            /* class com.tencent.imsdk.conversation.Msg.AnonymousClass3 */
        });
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.cptr;
        if (j != 0) {
            nativeDeleteMsg(j);
            this.cptr = 0;
        }
    }

    public long getCptr() {
        return this.cptr;
    }

    public int status() {
        return nativeMsgStatus(this.cptr);
    }

    public boolean isSelf() {
        return nativeIsSelf(this.cptr);
    }

    public long seq() {
        return nativeMsgSeq(this.cptr);
    }

    public long rand() {
        return nativeMsgRand(this.cptr);
    }

    public long time() {
        return nativeMsgTime(this.cptr);
    }

    public long uniqueid() {
        return nativeMsgUniqueId(this.cptr);
    }

    public String msgid() {
        return nativeGetMsgId(this.cptr);
    }

    public long lifetime() {
        return nativeMsgLifetime(this.cptr);
    }

    public int priority() {
        return nativeMsgPriority(this.cptr);
    }

    public int getRecvFlag() {
        return nativeMsgRecvFlag(this.cptr);
    }

    public String getSender() {
        return nativeGetSender(this.cptr);
    }

    public int elemSize() {
        return nativeElemSize(this.cptr);
    }

    public void setPriority(int i) {
        nativeSetPriority(this.cptr, i);
    }

    public int addElem(TIMElem tIMElem) {
        return nativeAddElem(this.cptr, tIMElem.getType().value(), tIMElem);
    }

    public void setLifetime(int i) {
        nativeSetLifetime(this.cptr, i);
    }

    public TIMElem getElement(int i) {
        return nativeGetElement(this.cptr, i);
    }

    public boolean copyFrom(Msg msg) {
        long nativeCopyFrom = nativeCopyFrom(msg.getCptr());
        int i = (nativeCopyFrom > 0 ? 1 : (nativeCopyFrom == 0 ? 0 : -1));
        if (i != 0) {
            this.cptr = nativeCopyFrom;
        }
        return i != 0;
    }

    public void getSenderProfile(final TIMValueCallBack<TIMUserProfile> tIMValueCallBack) {
        String sender = getSender();
        if (TextUtils.isEmpty(sender)) {
            QLog.e(TAG, "getSenderProfile, sender is empty!");
            tIMValueCallBack.onError(6017, "sender is empty");
            return;
        }
        TIMUserProfile nativeQueryUserProfile = FriendshipNativeManager.nativeQueryUserProfile(sender);
        if (nativeQueryUserProfile != null) {
            QLog.i(TAG, "getSenderProfile from query");
            tIMValueCallBack.onSuccess(nativeQueryUserProfile);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(sender);
        FriendshipNativeManager.nativeGetUsersProfile(arrayList, true, null, new ICallback(new TIMValueCallBack<List<TIMUserProfile>>() {
            /* class com.tencent.imsdk.conversation.Msg.AnonymousClass4 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                String str2 = Msg.TAG;
                QLog.e(str2, "getSenderProfile err = " + i + ", desc = " + str);
                TIMValueCallBack tIMValueCallBack = tIMValueCallBack;
                if (tIMValueCallBack != null) {
                    tIMValueCallBack.onError(i, str);
                }
            }

            public void onSuccess(List<TIMUserProfile> list) {
                String str = Msg.TAG;
                QLog.i(str, "getSenderProfile success, timUserProfiles size = " + list.size());
                if (tIMValueCallBack != null) {
                    TIMUserProfile tIMUserProfile = list.get(0);
                    String str2 = Msg.TAG;
                    QLog.i(str2, "getSenderProfile success, timUserProfileFromServer = " + tIMUserProfile.toString());
                    tIMValueCallBack.onSuccess(tIMUserProfile);
                }
            }
        }) {
            /* class com.tencent.imsdk.conversation.Msg.AnonymousClass5 */

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

    public String getSenderNickname() {
        TIMUserProfile tIMUserProfile = new TIMUserProfile();
        nativeGetSenderProfile(this.cptr, tIMUserProfile);
        return tIMUserProfile.getNickName();
    }

    public String getSenderFaceUrl() {
        TIMUserProfile tIMUserProfile = new TIMUserProfile();
        nativeGetSenderProfile(this.cptr, tIMUserProfile);
        return tIMUserProfile.getFaceUrl();
    }

    public TIMMessageOfflinePushSettings getOfflinePushInfo() {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = new TIMMessageOfflinePushSettings();
        if (nativeGetOfflinePushInfo(this.cptr, tIMMessageOfflinePushSettings)) {
            return tIMMessageOfflinePushSettings;
        }
        return null;
    }

    public void setOfflinePushInfo(TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings) {
        nativeSetOfflinePushInfo(this.cptr, tIMMessageOfflinePushSettings);
    }

    public TIMGroupMemberInfo getSenderGroupMemberProfile() {
        return nativeGetSenderGroupMemberInfo(this.cptr);
    }

    public boolean isRead() {
        return nativeIsRead(this.cptr);
    }

    public boolean remove() {
        return nativeRemove(this.cptr);
    }

    public boolean setCustomInt(int i) {
        return nativeSetCustomInt(this.cptr, i);
    }

    public int getCustomInt() {
        return nativeGetCustomInt(this.cptr);
    }

    public boolean setCustomStr(String str) {
        return nativeSetCustomStr(this.cptr, str);
    }

    public String getCustomStr() {
        return nativeGetCustomStr(this.cptr);
    }

    public boolean setCloudCustomData(String str) {
        return nativeSetCloudCustomData(this.cptr, str);
    }

    public String getCloudCustomData() {
        return nativeGetCloudCustomData(this.cptr);
    }

    public boolean convertToImportedMsg() {
        return nativeConvertToImportedMsg(this.cptr);
    }

    public boolean setSender(String str) {
        return nativeSetSender(this.cptr, str);
    }

    public boolean setTimestamp(long j) {
        return nativeSetTimestamp(this.cptr, j);
    }

    public boolean isPeerReaded() {
        return nativeIsPeerRead(this.cptr);
    }

    public boolean setGroupAtUserList(List<String> list) {
        return nativeSetGroupAtUserList(this.cptr, list);
    }

    public List<String> getGroupAtUserList() {
        List<String> nativeGetGroupAtUserList = nativeGetGroupAtUserList(this.cptr);
        return nativeGetGroupAtUserList == null ? new ArrayList() : nativeGetGroupAtUserList;
    }

    public TIMConversation getConversation() {
        return nativeGetConversation(this.cptr);
    }

    public TIMMessageLocator getMessageLocator() {
        TIMMessageLocator tIMMessageLocator = new TIMMessageLocator();
        nativeGetLocator(this.cptr, tIMMessageLocator);
        return tIMMessageLocator;
    }
}
