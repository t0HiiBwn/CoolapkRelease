package com.tencent.android.tpush.c;

import android.content.Context;
import com.tencent.android.tpush.stat.a.a;
import com.tencent.android.tpush.stat.a.b;

/* compiled from: ProGuard */
public abstract class d {
    protected b a = a.b();
    protected Context b = null;
    protected int c = 0;

    protected abstract String a();

    protected abstract boolean b();

    protected d(Context context, int i) {
        this.b = context;
        this.c = i;
    }

    protected String c() {
        if (this.c == 0) {
            return com.tencent.android.tpush.stat.a.d.a("4kU71lN96TJUomD1vOU9lgj9Tw==");
        }
        return com.tencent.android.tpush.stat.a.d.a("4kU71lN96TJUomD1vOU9lgj9Tw==") + this.c;
    }

    private String e() {
        if (b()) {
            return b(a());
        }
        return null;
    }

    public a d() {
        String e = e();
        if (e != null) {
            return a.a(e);
        }
        return null;
    }

    protected String b(String str) {
        return com.tencent.android.tpush.stat.a.d.a(str);
    }
}
