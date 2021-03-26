package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy */
public class fr extends fu {
    private Context b;
    private boolean c;
    private int d;
    private int e;

    public fr(Context context, boolean z, int i, int i2) {
        this.b = context;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    @Override // com.amap.api.mapcore2d.fu
    protected boolean a() {
        if (cu.r(this.b) == 1) {
            return true;
        }
        if (!this.c) {
            return false;
        }
        String a = dm.a(this.b, "iKey");
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        String[] split = a.split("\\|");
        if (split == null || split.length < 2) {
            dm.b(this.b, "iKey");
            return true;
        }
        if (!db.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.e) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.mapcore2d.fu
    public int b() {
        int i;
        if (cu.r(this.b) == 1 || (i = this.d) <= 0) {
            i = Integer.MAX_VALUE;
        }
        return this.a != null ? Math.max(i, this.a.b()) : i;
    }

    @Override // com.amap.api.mapcore2d.fu
    public void a(int i) {
        if (cu.r(this.b) != 1) {
            String a = db.a(System.currentTimeMillis(), "yyyyMMdd");
            String a2 = dm.a(this.b, "iKey");
            if (!TextUtils.isEmpty(a2)) {
                String[] split = a2.split("\\|");
                if (split == null || split.length < 2) {
                    dm.b(this.b, "iKey");
                } else if (a.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.b;
            dm.a(context, "iKey", a + "|" + i);
        }
    }
}
