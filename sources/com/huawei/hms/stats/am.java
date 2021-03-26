package com.huawei.hms.stats;

import android.text.TextUtils;
import com.huawei.hms.stats.e;

public class am {
    private static am a;
    private String b;
    private String c;

    public static am a() {
        if (a == null) {
            d();
        }
        return a;
    }

    private boolean a(String str) {
        af.b("RootKeyManager", "refresh sp aes key");
        String b2 = e.a().a(e.a.AES).b(f(), str);
        if (TextUtils.isEmpty(b2)) {
            af.b("RootKeyManager", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        ap.a(b.j(), "Privacy_MY", "PrivacyData", b2);
        ap.a(b.j(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    private static synchronized void d() {
        synchronized (am.class) {
            if (a == null) {
                a = new am();
            }
        }
    }

    private String e() {
        String b2 = ap.b(b.j(), "Privacy_MY", "PrivacyData", "");
        e a2 = e.a();
        if (TextUtils.isEmpty(b2)) {
            String b3 = a2.b(e.a.AES);
            a(b3);
            return b3;
        }
        String a3 = a2.a(e.a.AES).a(f(), b2);
        if (!TextUtils.isEmpty(a3)) {
            return a3;
        }
        String b4 = a2.b(e.a.AES);
        a(b4);
        return b4;
    }

    private String f() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = new al().a();
        }
        return this.c;
    }

    public void b() {
        String b2 = e.a().b(e.a.AES);
        if (a(b2)) {
            this.b = b2;
        }
    }

    public String c() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = e();
        }
        return this.b;
    }
}
