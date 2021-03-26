package com.tencent.beacon.core.b;

import android.content.Context;

/* compiled from: DefaultQimeiImpl */
public final class c implements f {
    private final Context a;
    private String b = null;

    @Override // com.tencent.beacon.core.b.f
    public final void updateQimei(byte[] bArr) {
    }

    public c(Context context) {
        this.a = context;
    }

    @Override // com.tencent.beacon.core.b.f
    public final String getQimei() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        String a2 = com.tencent.beacon.core.a.c.a(this.a).a("QIMEI_DENGTA", "");
        this.b = a2;
        return a2;
    }
}
