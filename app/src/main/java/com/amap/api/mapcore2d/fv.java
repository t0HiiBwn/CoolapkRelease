package com.amap.api.mapcore2d;

import android.content.Context;

/* compiled from: WiFiUplateStrategy */
public class fv extends fu {
    private Context b;
    private boolean c = false;

    public fv(Context context, boolean z) {
        this.b = context;
        this.c = z;
    }

    @Override // com.amap.api.mapcore2d.fu
    protected boolean a() {
        return cu.r(this.b) == 1 || this.c;
    }
}
