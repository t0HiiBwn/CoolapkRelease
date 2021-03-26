package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

public class cx extends cw {
    private boolean a;
    private boolean b;
    private boolean e;
    private boolean f;

    public cx(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, i);
        this.a = z;
        this.b = z2;
        if (it.g()) {
            this.b = false;
        }
        this.e = z3;
        this.f = z4;
    }

    private String a(Context context) {
        return !this.f ? "off" : "";
    }

    private String f() {
        if (!this.a) {
            return "off";
        }
        try {
            String g = g();
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            return ah.a(g) + "," + ah.b(g);
        } catch (Throwable unused) {
            return "";
        }
    }

    private String g() {
        return "";
    }

    private String h() {
        return !this.b ? "off" : "";
    }

    private String i() {
        return !this.e ? "off" : "";
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 13;
    }

    @Override // com.xiaomi.push.cw
    public String b() {
        return f() + "|" + h() + "|" + i() + "|" + a(this.d);
    }

    @Override // com.xiaomi.push.cw
    public gk c() {
        return gk.DeviceBaseInfo;
    }
}
