package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.cn;
import com.bytedance.embedapplog.d;

final class cb extends bt<d> {
    cb() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.bt
    protected cn.b<d, String> a() {
        return new cn.b<d, String>() {
            /* class com.bytedance.embedapplog.cb.AnonymousClass1 */

            /* renamed from: a */
            public d b(IBinder iBinder) {
                return d.a.a(iBinder);
            }

            public String a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                return dVar.a();
            }
        };
    }

    @Override // com.bytedance.embedapplog.bt
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
