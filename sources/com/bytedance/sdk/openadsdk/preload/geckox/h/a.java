package com.bytedance.sdk.openadsdk.preload.geckox.h;

import android.util.Log;
import com.bytedance.sdk.openadsdk.preload.geckox.c.b;

/* compiled from: DefaultLogger */
class a implements c {
    a() {
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.h.c
    public void a(String str, Object... objArr) {
        if (objArr == null) {
            Log.d(str, "null");
        } else {
            Log.d(str, b.a().b().a(objArr));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.h.c
    public void a(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.h.c
    public void b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
