package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* compiled from: RewardVideoListenerImpl */
public class d extends IRewardAdInteractionListener.Stub {
    private TTRewardVideoAd.RewardAdInteractionListener a;
    private Handler b = new Handler(Looper.getMainLooper());

    public d(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.a = rewardAdInteractionListener;
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

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.d.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.a != null) {
                    d.this.a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.d.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.a != null) {
                    d.this.a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.d.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.a != null) {
                    d.this.a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.d.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.a != null) {
                    d.this.a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoError() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.d.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.a != null) {
                    d.this.a.onVideoError();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.d.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.a != null) {
                    d.this.a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.d.AnonymousClass7 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.a != null) {
                    d.this.a.onRewardVerify(z, i, str, i2, str2);
                }
            }
        });
    }
}
