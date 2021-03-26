package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RewardAdVideoListenerManagerImpl */
public class f extends a {
    private static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> a = Collections.synchronizedMap(new HashMap());
    private static volatile f b;

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iRewardAdInteractionListener);
        a.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3, int i2, String str4) throws RemoteException {
        a(str, str2, z, i, str3, i2, str4);
    }

    private synchronized void a(String str, String str2, boolean z, int i, String str3, int i2, String str4) {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList;
        try {
            if (a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = a.remove(str);
                } else {
                    remoteCallbackList = a.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        try {
                            IRewardAdInteractionListener broadcastItem = remoteCallbackList.getBroadcastItem(i3);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    broadcastItem.onAdClose();
                                } else if ("onVideoComplete".equals(str2)) {
                                    broadcastItem.onVideoComplete();
                                } else if ("onVideoError".equals(str2)) {
                                    broadcastItem.onVideoError();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    broadcastItem.onAdVideoBarClick();
                                } else if ("onRewardVerify".equals(str2)) {
                                    broadcastItem.onRewardVerify(z, i, str3, i2, str4);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    broadcastItem.onSkippedVideo();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            u.c("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            u.c("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
        return;
    }
}
