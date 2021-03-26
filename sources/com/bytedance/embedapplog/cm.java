package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.c;
import com.bytedance.embedapplog.cn;

final class cm extends bt<c> {
    cm() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.bt
    protected cn.b<c, String> a() {
        return new cn.b<c, String>() {
            /* class com.bytedance.embedapplog.cm.AnonymousClass1 */

            /* renamed from: a */
            public c b(IBinder iBinder) {
                return c.a.a(iBinder);
            }

            public String a(c cVar) {
                return cVar.a();
            }
        };
    }

    @Override // com.bytedance.embedapplog.bt
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
