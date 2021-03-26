package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;

public abstract class bh {
    private be a(int i, Context context) {
        String str;
        if ((i & 4) != 0 && (i & 1) != 0) {
            return new be(bf.UDID, a(b(context)));
        }
        if ((i & 1) != 0) {
            str = b(context);
            if (!TextUtils.isEmpty(str)) {
                return new be(bf.SN, str);
            }
        } else {
            str = "";
        }
        if ((i & 2) == 0) {
            return new be(bf.EMPTY, str);
        }
        return new be(bf.IMEI, c(context));
    }

    private be b(int i, Context context) {
        String str;
        if (i != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new be(bf.UDID, str);
            }
        } else {
            str = "";
        }
        if ((i & 2) != 0) {
            str = c(context);
            if (!TextUtils.isEmpty(str)) {
                return new be(bf.IMEI, str);
            }
        }
        if ((i & 1) == 0) {
            return new be(bf.EMPTY, str);
        }
        return new be(bf.SN, b(context));
    }

    private String b(Context context) {
        q c = n.a().c();
        if (TextUtils.isEmpty(c.d())) {
            c.a(bi.f(context));
        }
        return c.d();
    }

    private String c(Context context) {
        q c = n.a().c();
        if (TextUtils.isEmpty(c.g())) {
            c.d(bi.e(context));
        }
        return c.g();
    }

    private boolean e() {
        q c = n.a().c();
        if (TextUtils.isEmpty(c.f())) {
            c.c(bi.a());
        }
        return !TextUtils.isEmpty(c.f());
    }

    private String f() {
        q c = n.a().c();
        if (TextUtils.isEmpty(c.h())) {
            c.e(bi.c());
        }
        return c.h();
    }

    public be a(Context context) {
        be beVar;
        String a = a();
        if (!TextUtils.isEmpty(a)) {
            return new be(bf.UDID, a);
        }
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            return new be(bf.IMEI, b);
        }
        boolean e = e();
        String c = c();
        if (TextUtils.isEmpty(c)) {
            return e ? b(d(), context) : a(d(), context);
        }
        if (e) {
            bf bfVar = bf.SN;
            return beVar;
        }
        beVar = new be(bf.UDID, a(c));
        return beVar;
    }

    public abstract String a();

    public abstract String a(String str);

    public abstract String b();

    public abstract String c();

    public abstract int d();
}
