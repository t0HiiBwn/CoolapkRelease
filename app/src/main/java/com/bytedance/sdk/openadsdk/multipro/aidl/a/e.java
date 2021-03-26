package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FullScreenVideoListenerManagerImpl */
public class e extends a {
    private static Map<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>> a = Collections.synchronizedMap(new HashMap());
    private static volatile e b;

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iFullScreenVideoAdInteractionListener);
        a.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeFullVideoCallback(String str, String str2) throws RemoteException {
        a(str, str2);
    }

    private synchronized void a(String str, String str2) {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList;
        try {
            if (a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = a.remove(str);
                } else {
                    remoteCallbackList = a.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        try {
                            IFullScreenVideoAdInteractionListener broadcastItem = remoteCallbackList.getBroadcastItem(i);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    broadcastItem.onAdClose();
                                } else if ("onVideoComplete".equals(str2)) {
                                    broadcastItem.onVideoComplete();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    broadcastItem.onSkippedVideo();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    broadcastItem.onAdVideoBarClick();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            u.c("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            u.c("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
        return;
    }
}
