package com.bytedance.embedapplog;

import android.content.Context;

class m extends p {
    private boolean b;

    m(Context context, as asVar, z zVar, aa aaVar) {
        super(context, asVar, zVar, aaVar);
    }

    @Override // com.bytedance.embedapplog.p, com.bytedance.embedapplog.i
    long b() {
        return this.b ? Long.MAX_VALUE : 0;
    }

    @Override // com.bytedance.embedapplog.p, com.bytedance.embedapplog.i
    public boolean d() {
        boolean d = super.d();
        this.b = d;
        return d;
    }
}
