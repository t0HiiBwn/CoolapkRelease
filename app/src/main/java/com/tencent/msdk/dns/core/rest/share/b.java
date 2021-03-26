package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: AbsHttpDnsConfig */
public abstract class b {
    private SocketAddress a = null;
    private SocketAddress b = null;

    public abstract String a();

    public abstract String a(String str, String str2);

    public abstract String b();

    public abstract int c();

    public String b(String str, String str2) {
        a(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return a(e.a(str) ? a() : b(), str2);
    }

    public SocketAddress a(String str, int i) {
        a(str);
        if (e.a(str)) {
            return d();
        }
        return e();
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bizId".concat(" can not be empty"));
        }
    }

    private SocketAddress d() {
        if (this.a == null) {
            try {
                this.a = new InetSocketAddress(InetAddress.getByName(a()), c());
            } catch (Exception unused) {
            }
        }
        return this.a;
    }

    private SocketAddress e() {
        if (this.b == null) {
            try {
                this.b = new InetSocketAddress(InetAddress.getByName(b()), c());
            } catch (Exception unused) {
            }
        }
        return this.b;
    }
}
