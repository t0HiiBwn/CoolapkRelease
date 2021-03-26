package com.huawei.hms.stats;

import android.text.TextUtils;
import com.huawei.hms.stats.e;

public class z {
    private static z a = new z();
    private final Object b = new Object();
    private String c;

    public static z a() {
        return a;
    }

    private String c() {
        return e.a().a(e.a.AES).a(am.a().c(), ap.b(b.j(), "global_v2", "common_prop", ""));
    }

    private void d() {
        ap.a(b.j(), "global_v2", "common_prop", e.a().a(e.a.AES).b(am.a().c(), this.c));
    }

    public void a(String str) {
        synchronized (this.b) {
            this.c = str;
            d();
        }
    }

    public String b() {
        String str;
        synchronized (this.b) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = c();
            }
            str = this.c;
        }
        return str;
    }
}
