package com.bytedance.embedapplog;

import android.content.Context;

class l extends n {
    private boolean b;

    l(Context context, aa aaVar, as asVar) {
        super(context, aaVar, asVar);
    }

    @Override // com.bytedance.embedapplog.n, com.bytedance.embedapplog.i
    long b() {
        return this.b ? Long.MAX_VALUE : 0;
    }

    @Override // com.bytedance.embedapplog.n, com.bytedance.embedapplog.i
    public boolean d() {
        boolean d = super.d();
        this.b = d;
        return d;
    }
}
