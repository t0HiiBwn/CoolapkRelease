package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.utils.e;
import com.bytedance.sdk.openadsdk.utils.j;

/* compiled from: SecSdkHelper */
public class s {
    private static s a;
    private static t b;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private String e = null;

    private s(String str) {
        this.e = str;
        if (c() == null) {
            b = t.b(str);
        } else if (!TextUtils.isEmpty(this.e)) {
            this.d = true;
            c().NM_setParams(this.e);
        }
    }

    public void a(String str) {
        t tVar = b;
        if (tVar != null) {
            tVar.a(str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.e)) {
                this.e = str;
            }
            if (!this.d && c() != null) {
                this.d = true;
                c().NM_setParams(str);
            }
        }
    }

    public static s b(String str) {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s(str);
                }
            }
        }
        return a;
    }

    public void c(String str) {
        t tVar = b;
        if (tVar != null) {
            tVar.c(str);
        }
        if (!this.c && c() != null) {
            c().NM_reportNow(str);
            this.c = true;
        }
    }

    public String a() {
        t tVar = b;
        if (tVar == null) {
            return "";
        }
        String a2 = tVar.a();
        return a2.length() > 100 ? a2 : "";
    }

    public String b() {
        String str = null;
        try {
            if (c() != null) {
                str = c().NM_pullSg();
            } else {
                t tVar = b;
                if (tVar != null) {
                    str = tVar.b();
                }
            }
            if (e(str)) {
                return str.toUpperCase();
            }
            String a2 = e.a(p.a());
            if (e(a2)) {
                return a2.toUpperCase();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private boolean e(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length < 20) {
            return false;
        }
        for (String str2 : split) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a2 = j.a(str);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        if (c() != null) {
            return c().NM_pullVer(a2);
        }
        t tVar = b;
        if (tVar != null) {
            return tVar.d(str);
        }
        return "";
    }

    private TTSecAbs c() {
        return i.d().n();
    }
}
