package com.tencent.beacon.core.c;

import android.content.Context;
import com.tencent.beacon.core.b.b;
import com.tencent.beacon.core.event.o;
import com.tencent.beacon.core.protocol.common.RequestPackage;

/* compiled from: EmptyUploadDatas */
public final class c extends a {
    @Override // com.tencent.beacon.core.c.a
    public final void b(boolean z) {
    }

    public c(Context context, String str) {
        super(context, 0, 100, str);
    }

    @Override // com.tencent.beacon.core.c.a
    public final RequestPackage a() {
        try {
            RequestPackage a = a(c(), b.a(o.a), "".getBytes(), -1, -1, this.f);
            if (a != null) {
                return a;
            }
            return null;
        } catch (Throwable th) {
            com.tencent.beacon.core.d.b.a(th);
            com.tencent.beacon.core.d.b.d("[event] encode empty package failed", new Object[0]);
            return null;
        }
    }
}
