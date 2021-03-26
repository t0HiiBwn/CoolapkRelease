package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;

/* compiled from: DynamicLayoutNativeValue */
public class e {
    public int a;
    public String b;
    private d c;

    public e(c cVar) {
        this.a = cVar.a();
        this.b = cVar.b();
        this.c = cVar.c();
    }

    public int a() {
        return (int) this.c.c();
    }

    public int b() {
        return (int) this.c.f();
    }

    public int c() {
        return (int) this.c.d();
    }

    public int d() {
        return (int) this.c.e();
    }

    public float e() {
        return this.c.g();
    }

    public String f() {
        return this.a == 0 ? this.b : "";
    }

    public int g() {
        return a(this.c.j());
    }

    public int h() {
        String i = this.c.i();
        if ("left".equals(i)) {
            return 2;
        }
        if ("center".equals(i)) {
            return 4;
        }
        if ("right".equals(i)) {
            return 3;
        }
        return 2;
    }

    public String i() {
        return this.a == 2 ? this.b : "";
    }

    public String j() {
        return this.a == 1 ? this.b : "";
    }

    public int k() {
        return this.c.h();
    }

    public float l() {
        return this.c.a();
    }

    public int m() {
        return a(this.c.l());
    }

    public float n() {
        return this.c.b();
    }

    public boolean o() {
        return this.c.o();
    }

    public int p() {
        String m = this.c.m();
        if (!TextUtils.isEmpty(m) && !m.equals("none")) {
            if (m.equals("normal")) {
                return 1;
            }
            if (m.equals("creative")) {
                return 2;
            }
            if (m.equals("video")) {
                return 4;
            }
            if ("slide".equals(this.c.n())) {
                return 2;
            }
        }
        return 0;
    }

    public int q() {
        return a(this.c.k());
    }

    private int a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null && split.length == 4) {
            return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2])) | 0;
        }
        return -16777216;
    }
}
