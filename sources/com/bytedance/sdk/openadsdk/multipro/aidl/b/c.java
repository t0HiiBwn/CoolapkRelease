package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* compiled from: FullScreenVideoListenerImpl */
public class c extends IFullScreenVideoAdInteractionListener.Stub {
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener a;
    private Handler b = new Handler(Looper.getMainLooper());

    public c(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.a = fullScreenVideoAdInteractionListener;
    }

    private void a() {
        this.a = null;
        this.b = null;
    }

    private Handler b() {
        Handler handler = this.b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.b = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a != null) {
                    c.this.a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.c.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a != null) {
                    c.this.a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.c.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a != null) {
                    c.this.a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.c.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a != null) {
                    c.this.a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.c.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a != null) {
                    c.this.a.onSkippedVideo();
                }
            }
        });
    }
}
