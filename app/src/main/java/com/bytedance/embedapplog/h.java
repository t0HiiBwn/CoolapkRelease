package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

class h extends i {
    private boolean b;
    private final aa c;

    @Override // com.bytedance.embedapplog.i
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.i
    String e() {
        return "ac";
    }

    h(Context context, aa aaVar) {
        super(context);
        this.c = aaVar;
    }

    @Override // com.bytedance.embedapplog.i
    long b() {
        return this.b ? Long.MAX_VALUE : 0;
    }

    @Override // com.bytedance.embedapplog.i
    long[] c() {
        return o.b;
    }

    @Override // com.bytedance.embedapplog.i
    boolean d() {
        if (this.c.o() != 0) {
            JSONObject a = this.c.a();
            if (a != null) {
                this.b = ao.b(ap.a(this.a, this.c.a(), ao.a().getActiveUri(), true, AppLog.getIAppParam()), a);
            } else {
                bo.a(null);
            }
        }
        return this.b;
    }
}
