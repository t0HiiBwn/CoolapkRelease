package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.utils.h;

/* compiled from: CommonPermissionListenerImpl */
public class b extends ICommonPermissionListener.Stub {
    private Handler a = new Handler(Looper.getMainLooper());
    private h.a b;

    public b(h.a aVar) {
        this.b = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
    public void onGranted() throws RemoteException {
        a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.b != null) {
                    b.this.b.a();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
    public void onDenied(final String str) throws RemoteException {
        a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.b != null) {
                    b.this.b.a(str);
                }
            }
        });
    }

    private void a(Runnable runnable) {
        if (this.a == null) {
            this.a = new Handler(Looper.getMainLooper());
        }
        this.a.post(runnable);
    }
}
