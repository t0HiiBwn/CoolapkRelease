package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

public class bg {
    private static bg b;
    private Context a;

    private static class a extends bh {
        String a;
        String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.huawei.hms.stats.bh
        public String a() {
            return a.b(this.a, this.b);
        }

        @Override // com.huawei.hms.stats.bh
        public String a(String str) {
            return e.a().a(str);
        }

        @Override // com.huawei.hms.stats.bh
        public String b() {
            return a.a(this.a, this.b);
        }

        @Override // com.huawei.hms.stats.bh
        public String c() {
            return a.d(this.a, this.b);
        }

        @Override // com.huawei.hms.stats.bh
        public int d() {
            int i = 0;
            int i2 = (a.h(this.a, this.b) ? 4 : 0) | 0;
            if (a.g(this.a, this.b)) {
                i = 2;
            }
            return i2 | i | (a.j(this.a, this.b) ? 1 : 0);
        }
    }

    public static bg a() {
        bg bgVar;
        synchronized (bg.class) {
            if (b == null) {
                b = new bg();
            }
            bgVar = b;
        }
        return bgVar;
    }

    public be a(String str, String str2) {
        return new a(str, str2).a(this.a);
    }

    public String a(boolean z) {
        if (!z) {
            return "";
        }
        String g = b.g();
        if (TextUtils.isEmpty(g)) {
            g = ap.b(this.a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(g)) {
                g = UUID.randomUUID().toString().replace("-", "");
                ap.a(this.a, "global_v2", "uuid", g);
            }
            b.a(g);
        }
        return g;
    }

    public void a(Context context) {
        if (this.a == null) {
            this.a = context;
        }
    }

    public Pair<String, String> b(String str, String str2) {
        if (!a.f(str, str2)) {
            return new Pair<>("", "");
        }
        String n = n.a().c().n();
        String o = n.a().c().o();
        if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(o)) {
            return new Pair<>(n, o);
        }
        Pair<String, String> g = bi.g(this.a);
        n.a().c().l((String) g.first);
        n.a().c().m((String) g.second);
        return g;
    }

    public String c(String str, String str2) {
        return bj.b(str, str2);
    }

    public String d(String str, String str2) {
        return bj.a(this.a, str, str2);
    }

    public String e(String str, String str2) {
        return bj.b(this.a, str, str2);
    }

    public String f(String str, String str2) {
        return bj.a(str, str2);
    }
}
