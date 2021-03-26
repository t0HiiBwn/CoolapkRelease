package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy */
public final class bn extends bq {
    private String a = "iKey";
    private Context b;
    private boolean d;
    private int e;
    private int f;
    private int g = 0;

    public bn(Context context, boolean z, int i, int i2, String str) {
        a(context, z, i, i2, str, 0);
    }

    public bn(Context context, boolean z, int i, int i2, String str, int i3) {
        a(context, z, i, i2, str, i3);
    }

    private void a(Context context, boolean z, int i, int i2, String str, int i3) {
        this.b = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.a = str;
        this.g = i3;
    }

    @Override // com.loc.bq
    public final void a(int i) {
        if (n.q(this.b) != 1) {
            String a2 = u.a(System.currentTimeMillis(), "yyyyMMdd");
            String a3 = z.a(this.b, this.a);
            if (!TextUtils.isEmpty(a3)) {
                String[] split = a3.split("\\|");
                if (split == null || split.length < 2) {
                    z.b(this.b, this.a);
                } else if (a2.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.b;
            String str = this.a;
            z.a(context, str, a2 + "|" + i);
        }
    }

    @Override // com.loc.bq
    protected final boolean a() {
        if (n.q(this.b) == 1) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        String a2 = z.a(this.b, this.a);
        if (TextUtils.isEmpty(a2)) {
            return true;
        }
        String[] split = a2.split("\\|");
        if (split == null || split.length < 2) {
            z.b(this.b, this.a);
            return true;
        }
        return !u.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f;
    }

    @Override // com.loc.bq
    public final int b() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((n.q(this.b) != 1 && (i = this.e) > 0) || ((i = this.g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        return this.c != null ? Math.max(i2, this.c.b()) : i2;
    }
}
