package com.tencent.android.tpush.service.util;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Md5;

/* compiled from: ProGuard */
public class d {
    private static String a(String str) {
        return Md5.md5(str);
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            e.b(context, a(str), str2);
            return true;
        } catch (Throwable th) {
            TLogger.e("ServicePushInfoMd5Pref", "putString", th);
            return false;
        }
    }

    public static String a(Context context, String str) {
        try {
            return e.a(context, a(str), null);
        } catch (Throwable th) {
            TLogger.e("ServicePushInfoMd5Pref", "getString", th);
            return null;
        }
    }
}
