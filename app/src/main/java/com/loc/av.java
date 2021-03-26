package com.loc;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Request */
public abstract class av {
    int c = 20000;
    int d = 20000;
    Proxy e = null;

    private String a(String str) {
        Map<String, String> b_;
        byte[] e2 = e();
        if (e2 == null || e2.length == 0 || (b_ = b_()) == null) {
            return str;
        }
        String a = at.a(b_);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(Proxy proxy) {
        this.e = proxy;
    }

    public abstract Map<String, String> b();

    public final void b(int i) {
        this.d = i;
    }

    public abstract Map<String, String> b_();

    public abstract String c();

    public String d() {
        return c();
    }

    public byte[] e() {
        return null;
    }

    protected String h() {
        return "";
    }

    public boolean i() {
        return false;
    }

    final String m() {
        return a(c());
    }

    final String n() {
        return a(d());
    }

    protected final boolean o() {
        return !TextUtils.isEmpty(h());
    }

    public String p() {
        return "";
    }
}
