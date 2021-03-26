package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.u;

/* compiled from: CommonDialogListenerImpl */
public class a extends ICommonDialogListener.Stub {
    private Handler a = new Handler(Looper.getMainLooper());
    private g.a b;

    public a(g.a aVar) {
        this.b = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
    public void onDialogBtnYes() throws RemoteException {
        u.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnYes");
        a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.b != null) {
                    a.this.b.a();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
    public void onDialogBtnNo() throws RemoteException {
        u.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnNo");
        a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.b != null) {
                    a.this.b.b();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
    public void onDialogCancel() throws RemoteException {
        u.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogCancel");
        a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.b != null) {
                    a.this.b.c();
                }
            }
        });
    }

    private void a(Runnable runnable) {
        this.a.post(runnable);
    }
}
