package com.amap.api.col.s;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Request */
public abstract class cy {
    int g = 20000;
    int h = 20000;
    Proxy i = null;

    public String c() {
        return "";
    }

    public abstract Map<String, String> e();

    public abstract Map<String, String> f();

    public byte[] g() {
        return null;
    }

    public abstract String h();

    protected String j() {
        return "";
    }

    public boolean k() {
        return false;
    }

    final String m() {
        return a(h());
    }

    private String a(String str) {
        Map<String, String> e;
        byte[] g2 = g();
        if (g2 == null || g2.length == 0 || (e = e()) == null) {
            return str;
        }
        String a = cv.a(e);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    final String n() {
        return a(a_());
    }

    protected final boolean o() {
        return !TextUtils.isEmpty(j());
    }

    public String a_() {
        return h();
    }

    public final void a(int i2) {
        this.g = i2;
    }

    public final void b(int i2) {
        this.h = i2;
    }
}
