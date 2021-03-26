package com.tencent.msdk.dns.core.rest.share.a;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.e.c;

/* compiled from: Response */
public final class a {
    public static final a a = new a("0", com.tencent.msdk.dns.core.a.a, 0);
    public static final a b = new a("0", com.tencent.msdk.dns.core.a.a, 0);
    public final String c;
    public final String[] d;
    public final int e;

    public static boolean a(int i) {
        return i < 0;
    }

    a(int i, String str, String[] strArr, int i2) {
        i = 2 != i ? 1 : i;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("clientIp".concat(" can not be empty"));
        } else if (!com.tencent.msdk.dns.base.e.a.a((Object[]) strArr)) {
            String[] a2 = a(i, strArr);
            if (com.tencent.msdk.dns.base.e.a.a((Object[]) a2)) {
                throw new IllegalArgumentException("ips".concat(" can not be empty"));
            } else if (!a(i2)) {
                this.c = str;
                if (5 >= a2.length) {
                    this.d = a2;
                } else {
                    String[] strArr2 = new String[5];
                    this.d = strArr2;
                    System.arraycopy(a2, 0, strArr2, 0, 5);
                }
                this.e = i2;
            } else {
                throw new IllegalArgumentException("ttl".concat(" is invalid"));
            }
        } else {
            throw new IllegalArgumentException("ips".concat(" can not be empty"));
        }
    }

    private a(String str, String[] strArr, int i) {
        this.c = str;
        this.d = strArr;
        this.e = i;
    }

    private static String[] a(int i, String[] strArr) {
        int length = strArr.length;
        int i2 = length;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            if (2 == i) {
                if (!c.b(str)) {
                    strArr[i3] = "0";
                }
            } else if (!c.a(str)) {
                strArr[i3] = "0";
            }
            i2--;
        }
        if (i2 == length) {
            return strArr;
        }
        if (i2 <= 0) {
            return com.tencent.msdk.dns.core.a.a;
        }
        String[] strArr2 = new String[i2];
        int i4 = i2 - 1;
        for (int i5 = length - 1; i5 >= 0 && i4 >= 0; i5--) {
            String str2 = strArr[i5];
            if (!"0".equals(str2)) {
                strArr2[i4] = str2;
                i4--;
            }
        }
        return strArr2;
    }
}
