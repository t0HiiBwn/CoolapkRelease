package com.huawei.updatesdk.service.a;

import android.content.Context;
import android.text.TextUtils;

public final class a {
    private static final Object a = new Object();
    private static a b;
    private b c;
    private String d;

    private a(Context context) {
        this.c = b.a("DeviceSessionUpdateSDK_V1", context);
    }

    public static a a() {
        a aVar;
        synchronized (a) {
            if (b == null) {
                b = new a(com.huawei.updatesdk.a.b.a.a.a().b());
            }
            aVar = b;
        }
        return aVar;
    }

    public void a(long j) {
        this.c.a("updatesdk.lastCheckDate", j);
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.c.a(str, str2);
        }
    }

    public long b() {
        return this.c.b("updatesdk.lastCheckDate", 0);
    }

    public void b(long j) {
        this.c.a("updatesdk.lastInitAccountTime", j);
    }

    public void b(String str) {
        this.c.a("updatesdk.lastAccountZone", str);
    }

    public String c() {
        return this.d;
    }

    public String c(String str) {
        return TextUtils.isEmpty(str) ? "" : this.c.b(str, "");
    }

    public long d() {
        return this.c.b("updatesdk.lastInitAccountTime", 0);
    }

    public void d(String str) {
        this.c.a(str);
    }

    public String e() {
        return this.c.b("updatesdk.lastAccountZone", "");
    }
}
