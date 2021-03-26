package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.xiaomi.push.service.an;

public class dl {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (an.a(context).a(hh.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ag.a(context, str, j);
        }
        return false;
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] a = bf.m137a(str);
        try {
            a(a);
            return h.a(a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] a = bf.m137a(str);
        try {
            a(a);
            return h.b(a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
