package com.tencent.msdk.dns.core;

import android.text.TextUtils;

/* compiled from: DnsDescription */
public final class c {
    public final String a;
    public final int b;

    public static boolean a(int i) {
        return (1 == i || 2 == i || 3 == i) ? false : true;
    }

    public c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("channel".concat(" can not be empty"));
        } else if (!a(i)) {
            this.a = str;
            this.b = i;
        } else {
            throw new IllegalArgumentException("family".concat(" is invalid"));
        }
    }

    public String toString() {
        return this.a + "Dns(" + this.b + ")";
    }
}
