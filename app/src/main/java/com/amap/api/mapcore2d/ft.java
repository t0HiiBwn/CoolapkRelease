package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy */
public class ft extends fu {
    private int b;
    private long c;
    private String d;
    private Context e;

    public ft(Context context, int i, String str, fu fuVar) {
        super(fuVar);
        this.b = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.mapcore2d.fu
    protected boolean a() {
        if (this.c == 0) {
            this.c = a(this.d);
        }
        return System.currentTimeMillis() - this.c >= ((long) this.b);
    }

    @Override // com.amap.api.mapcore2d.fu
    public void a(boolean z) {
        super.a(z);
        if (z) {
            a(this.d, System.currentTimeMillis());
        }
    }

    private void a(String str, long j) {
        this.c = j;
        dm.a(this.e, str, String.valueOf(j));
    }

    private long a(String str) {
        String a = dm.a(this.e, str);
        if (TextUtils.isEmpty(a)) {
            return 0;
        }
        return Long.parseLong(a);
    }
}
