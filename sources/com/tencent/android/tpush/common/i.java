package com.tencent.android.tpush.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.d.a;

/* compiled from: ProGuard */
public class i {
    private static volatile i a;
    private boolean b;
    private boolean c;
    private int d;

    private i(Context context) {
        this.b = false;
        this.c = false;
        this.d = -1;
        this.b = e.a();
        this.c = a.a(context);
    }

    public static i a(Context context) {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i(context);
                }
            }
        }
        return a;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        if (this.d == -1) {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                String lowerCase = str.trim().toLowerCase();
                if ("meizu".equals(lowerCase) || "oppo".equals(lowerCase) || "xiaomi".equals(lowerCase) || "vivo".equals(lowerCase) || "huawei".equals(lowerCase) || this.b) {
                    this.d = 1;
                } else {
                    this.d = 0;
                }
            }
        }
        if (this.d == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        return this.c;
    }
}
