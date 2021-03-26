package com.loc;

import android.content.Context;

/* compiled from: WiFiUplateStrategy */
public final class br extends bq {
    private Context a;
    private boolean b = false;

    public br(Context context) {
        this.a = context;
        this.b = false;
    }

    @Override // com.loc.bq
    protected final boolean a() {
        return n.q(this.a) == 1 || this.b;
    }
}
