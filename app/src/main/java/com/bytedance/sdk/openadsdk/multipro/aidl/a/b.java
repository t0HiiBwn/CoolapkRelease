package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.multipro.aidl.b.e;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AppDownloadListenerManagerImpl */
public class b extends a {
    private static Map<String, RemoteCallbackList<ITTAppDownloadListener>> a = Collections.synchronizedMap(new HashMap());
    private static volatile b b;

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList = a.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(iTTAppDownloadListener);
        a.put(str, remoteCallbackList);
        u.f("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:" + str);
        u.f("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + a.size());
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        Map<String, RemoteCallbackList<ITTAppDownloadListener>> map = a;
        if (map == null) {
            u.f("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:" + str);
            return;
        }
        RemoteCallbackList<ITTAppDownloadListener> remove = map.remove(str);
        if (remove == null) {
            u.f("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:" + str);
            return;
        }
        a(remove);
        u.f("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:" + str);
        u.f("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + a.size());
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        a(str, str2, j, j2, str3, str4);
    }

    private synchronized void a(String str, String str2, long j, long j2, String str3, String str4) {
        Throwable th;
        try {
            if (a != null) {
                if ("recycleRes".equals(str2)) {
                    a(a.remove(str));
                    u.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:" + str);
                    u.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + a.size());
                    return;
                }
                RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList = a.get(str);
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        try {
                            ITTAppDownloadListener broadcastItem = remoteCallbackList.getBroadcastItem(i);
                            if (broadcastItem != null) {
                                if ("onIdle".equals(str2)) {
                                    broadcastItem.onIdle();
                                } else if ("onDownloadActive".equals(str2)) {
                                    broadcastItem.onDownloadActive(j, j2, str3, str4);
                                } else if ("onDownloadPaused".equals(str2)) {
                                    broadcastItem.onDownloadPaused(j, j2, str3, str4);
                                } else if ("onDownloadFailed".equals(str2)) {
                                    broadcastItem.onDownloadFailed(j, j2, str3, str4);
                                } else {
                                    if ("onDownloadFinished".equals(str2)) {
                                        try {
                                            broadcastItem.onDownloadFinished(j, str3, str4);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            u.c("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                        }
                                    } else if ("onInstalled".equals(str2)) {
                                        broadcastItem.onInstalled(str3, str4);
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            u.c("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                }
                return;
            }
            return;
        } catch (Throwable th4) {
            u.c("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th4);
        }
    }

    private void a(RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ITTAppDownloadListener broadcastItem = remoteCallbackList.getBroadcastItem(i);
                        if (broadcastItem != null) {
                            ((e) broadcastItem).a();
                        }
                    } catch (Throwable th) {
                        u.c("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                u.c("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }
}
