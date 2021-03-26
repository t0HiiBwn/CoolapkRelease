package com.tencent.msdk.dns.core.rest.c;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.rest.share.e;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* compiled from: UdpDnsConfig */
final class c {
    private static InetSocketAddress a;
    private static InetSocketAddress b;

    static InetSocketAddress a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bizId".concat(" can not be empty"));
        } else if (e.a(str)) {
            return a();
        } else {
            return b();
        }
    }

    private static InetSocketAddress a() {
        if (a == null) {
            try {
                a = new InetSocketAddress(InetAddress.getByName("182.254.116.17"), 8080);
            } catch (Exception unused) {
            }
        }
        return a;
    }

    private static InetSocketAddress b() {
        if (b == null) {
            try {
                b = new InetSocketAddress(InetAddress.getByName("119.28.28.28"), 8080);
            } catch (Exception unused) {
            }
        }
        return b;
    }
}
