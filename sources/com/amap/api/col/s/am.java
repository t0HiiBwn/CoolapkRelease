package com.amap.api.col.s;

import android.content.Context;

/* compiled from: StatisticsUtil */
public final class am {
    static de a;

    public static void a(Context context, String str, long j, boolean z) {
        try {
            String a2 = a(str, j, z);
            if (a2 == null) {
                return;
            }
            if (a2.length() > 0) {
                if (a == null) {
                    a = new de(context, "sea", "7.7.0", "O002");
                }
                a.a(a2);
                df.a(a, context);
            }
        } catch (Throwable th) {
            i.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, long j, boolean z) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j + ",\"Success\":" + z + "}";
        } catch (Throwable th) {
            i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void a(Context context, String str, boolean z) {
        try {
            String a2 = a(str, z);
            if (a2 == null) {
                return;
            }
            if (a2.length() > 0) {
                de deVar = new de(context, "sea", "7.7.0", "O006");
                deVar.a(a2);
                df.a(deVar, context);
            }
        } catch (Throwable th) {
            i.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, boolean z) {
        String str2 = "";
        try {
            int indexOf = str.indexOf("?");
            int length = str.length();
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i = indexOf + 1;
                if (i < length) {
                    str2 = str.substring(i);
                }
                str = substring;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z + "}";
        } catch (Throwable th) {
            i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }
}
