package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

class n extends i {
    private static final long[] b = {60000};
    private final as c;
    private final aa d;
    private long e;

    @Override // com.bytedance.embedapplog.i
    boolean a() {
        return false;
    }

    @Override // com.bytedance.embedapplog.i
    String e() {
        return "p";
    }

    n(Context context, aa aaVar, as asVar) {
        super(context);
        this.c = asVar;
        this.d = aaVar;
    }

    @Override // com.bytedance.embedapplog.i
    long b() {
        return this.e + 60000;
    }

    @Override // com.bytedance.embedapplog.i
    long[] c() {
        return b;
    }

    @Override // com.bytedance.embedapplog.i
    public boolean d() {
        Bundle a;
        long currentTimeMillis = System.currentTimeMillis();
        q d2 = k.d();
        if (!(d2 == null || (a = d2.a(currentTimeMillis, 50000)) == null)) {
            AppLog.onEventV3("play_session", a);
            AppLog.flush();
        }
        if (this.d.o() == 0) {
            return false;
        }
        JSONObject b2 = this.d.b();
        if (b2 != null) {
            boolean a2 = this.c.a(b2);
            this.e = System.currentTimeMillis();
            return a2;
        }
        bo.a(null);
        return false;
    }
}
