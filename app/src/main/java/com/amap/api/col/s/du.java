package com.amap.api.col.s;

import android.content.Context;

/* compiled from: WiFiUplateStrategy */
public final class du extends dt {
    private Context a;
    private boolean b = false;

    public du(Context context) {
        this.a = context;
        this.b = false;
    }

    @Override // com.amap.api.col.s.dt
    protected final boolean a() {
        return bm.p(this.a) == 1 || this.b;
    }
}
