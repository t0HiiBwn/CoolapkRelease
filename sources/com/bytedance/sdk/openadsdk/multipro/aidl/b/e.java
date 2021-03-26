package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* compiled from: TTAppDownloadListenerImpl */
public class e extends ITTAppDownloadListener.Stub {
    private volatile TTAppDownloadListener a;
    private Handler b = new Handler(Looper.getMainLooper());

    private Handler b() {
        Handler handler = this.b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.b = handler2;
        return handler2;
    }

    public e(TTAppDownloadListener tTAppDownloadListener) {
        this.a = tTAppDownloadListener;
    }

    /* access modifiers changed from: private */
    public boolean c() {
        return this.a != null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        if (this.a != null) {
            b().post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.e.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.a.onIdle();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.a != null) {
            b().post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.e.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.a.onDownloadActive(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.a != null) {
            b().post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.e.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.a.onDownloadPaused(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.a != null) {
            b().post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.e.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.a.onDownloadFailed(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(final long j, final String str, final String str2) throws RemoteException {
        if (this.a != null) {
            b().post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.e.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.a.onDownloadFinished(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(final String str, final String str2) throws RemoteException {
        if (this.a != null) {
            b().post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.e.AnonymousClass6 */

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.a.onInstalled(str, str2);
                    }
                }
            });
        }
    }

    public void a() {
        this.a = null;
        this.b = null;
    }
}
