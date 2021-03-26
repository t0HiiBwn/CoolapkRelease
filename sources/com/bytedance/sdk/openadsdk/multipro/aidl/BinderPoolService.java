package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.b;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.utils.u;

public class BinderPoolService extends Service {
    private Binder a = new a();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        u.b("MultiProcess", "BinderPoolService has been created ! ");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        u.b("MultiProcess", "BinderPoolService onBind ! ");
        return this.a;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        u.b("MultiProcess", "BinderPoolService is destroy ! ");
    }

    public static class a extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            u.c("MultiProcess", "queryBinder...........binderCode=" + i);
            if (i == 0) {
                return f.a();
            }
            if (i == 1) {
                return e.a();
            }
            if (i == 2) {
                return c.a();
            }
            if (i == 3) {
                return b.a();
            }
            if (i != 4) {
                return null;
            }
            return d.a();
        }
    }
}
