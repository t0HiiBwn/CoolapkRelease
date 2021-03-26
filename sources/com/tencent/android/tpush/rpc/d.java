package com.tencent.android.tpush.rpc;

import android.content.Intent;
import com.tencent.android.tpush.b.f;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.service.b;

/* compiled from: ProGuard */
public class d extends a.AbstractBinderC0132a {
    @Override // com.tencent.android.tpush.rpc.a
    public void b() {
    }

    @Override // com.tencent.android.tpush.rpc.a
    public void a(String str, b bVar) {
        try {
            f.a(b.e()).a(Intent.parseUri(str, 0));
            bVar.a();
        } catch (Throwable th) {
            TLogger.e("ITaskImpl", "Show", th);
        }
    }

    @Override // com.tencent.android.tpush.rpc.a
    public void a() {
        try {
            TLogger.d("ITaskImpl", "start XGService");
            b.a(b.e());
        } catch (Throwable th) {
            TLogger.e("ITaskImpl", "startService", th);
        }
    }
}
