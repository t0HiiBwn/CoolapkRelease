package com.amap.api.mapcore2d;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Request */
public abstract class ew {
    int c = 20000;
    int d = 20000;
    Proxy e = null;

    public byte[] a_() {
        return null;
    }

    public abstract Map<String, String> f();

    public abstract Map<String, String> g();

    public abstract String h();

    protected String m() {
        return "";
    }

    public boolean o() {
        return false;
    }

    String l() {
        byte[] a_ = a_();
        if (a_ == null || a_.length == 0) {
            return h();
        }
        Map<String, String> g = g();
        if (g == null) {
            return h();
        }
        String a = eu.a(g);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h());
        stringBuffer.append("?");
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    protected boolean n() {
        return !TextUtils.isEmpty(m());
    }

    byte[] p() {
        byte[] a_ = a_();
        if (a_ != null && a_.length != 0) {
            return a_;
        }
        String a = eu.a(g());
        return !TextUtils.isEmpty(a) ? db.a(a) : a_;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final void a(Proxy proxy) {
        this.e = proxy;
    }
}
