package com.tencent.android.tpush.rpc;

import android.content.ServiceConnection;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.rpc.b;

/* compiled from: ProGuard */
public class c extends b.a {
    private ServiceConnection a;

    public void a(ServiceConnection serviceConnection) {
        this.a = serviceConnection;
    }

    @Override // com.tencent.android.tpush.rpc.b
    public void a() {
        try {
            if (com.tencent.android.tpush.service.b.e() != null) {
                com.tencent.android.tpush.service.b.e().unbindService(this.a);
                this.a = null;
            }
        } catch (Throwable th) {
            TLogger.e("ITaskCallbackImpl", "unBind", th);
        }
    }
}
