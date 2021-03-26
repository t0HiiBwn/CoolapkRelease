package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy */
public final class ds extends dt {
    protected int a;
    protected long b;
    private String d;
    private Context e;

    public ds(Context context, int i, String str, dt dtVar) {
        super(dtVar);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.col.s.dt
    protected final boolean a() {
        long j = 0;
        if (this.b == 0) {
            String a2 = ce.a(this.e, this.d);
            if (!TextUtils.isEmpty(a2)) {
                j = Long.parseLong(a2);
            }
            this.b = j;
        }
        return System.currentTimeMillis() - this.b >= ((long) this.a);
    }

    @Override // com.amap.api.col.s.dt
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.b = currentTimeMillis;
            ce.a(this.e, str, String.valueOf(currentTimeMillis));
        }
    }
}
