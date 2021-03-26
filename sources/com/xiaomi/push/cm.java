package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.l;

public class cm {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        return l.a(context).a(gn.DCJobMutualSwitch.a(), false) && !h.a(context, str, j);
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] c = ae.c(str);
        try {
            a(c);
            return fv.a(c, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] c = ae.c(str);
        try {
            a(c);
            return fv.b(c, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
