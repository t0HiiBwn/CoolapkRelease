package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy */
public final class bp extends bq {
    protected int a;
    protected long b;
    private String d;
    private Context e;

    public bp(Context context, int i, String str, bq bqVar) {
        super(bqVar);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.loc.bq
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.b = currentTimeMillis;
            z.a(this.e, str, String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.loc.bq
    protected final boolean a() {
        long j = 0;
        if (this.b == 0) {
            String a2 = z.a(this.e, this.d);
            if (!TextUtils.isEmpty(a2)) {
                j = Long.parseLong(a2);
            }
            this.b = j;
        }
        return System.currentTimeMillis() - this.b >= ((long) this.a);
    }
}
