package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy */
public final class dq extends dt {
    private String a = "iKey";
    private Context b;
    private boolean d;
    private int e;
    private int f;
    private int g = 0;

    public dq(Context context, boolean z, int i, int i2, String str, int i3) {
        this.b = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.a = str;
        this.g = i3;
    }

    @Override // com.amap.api.col.s.dt
    protected final boolean a() {
        if (bm.p(this.b) == 1) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        String a2 = ce.a(this.b, this.a);
        if (TextUtils.isEmpty(a2)) {
            return true;
        }
        String[] split = a2.split("\\|");
        if (split == null || split.length < 2) {
            ce.b(this.b, this.a);
            return true;
        }
        if (!bs.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.s.dt
    public final int b() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((bm.p(this.b) != 1 && (i = this.e) > 0) || ((i = this.g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        return this.c != null ? Math.max(i2, this.c.b()) : i2;
    }

    @Override // com.amap.api.col.s.dt
    public final void a(int i) {
        if (bm.p(this.b) != 1) {
            String a2 = bs.a(System.currentTimeMillis(), "yyyyMMdd");
            String a3 = ce.a(this.b, this.a);
            if (!TextUtils.isEmpty(a3)) {
                String[] split = a3.split("\\|");
                if (split == null || split.length < 2) {
                    ce.b(this.b, this.a);
                } else if (a2.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.b;
            String str = this.a;
            ce.a(context, str, a2 + "|" + i);
        }
    }
}
