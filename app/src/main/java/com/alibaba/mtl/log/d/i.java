package com.alibaba.mtl.log.d;

import android.os.Process;
import android.util.Log;

/* compiled from: Logger */
public class i {
    private static boolean K = false;
    private static boolean L = false;
    private static String af = "UTAnalytics:";

    public static boolean k() {
        return K;
    }

    public static boolean l() {
        return L;
    }

    public static void d(boolean z) {
        L = z;
    }

    public static void a(String str, Object... objArr) {
        if (L) {
            String str2 = af + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] != null) {
                        String obj = objArr[i].toString();
                        if (obj.endsWith(":") || obj.endsWith(": ")) {
                            sb.append(obj);
                        } else {
                            sb.append(obj);
                            sb.append(",");
                        }
                    }
                }
            }
            Log.d(str2, sb.toString());
        }
    }

    public static void a(String str, Object obj, Throwable th) {
        if (l() || k()) {
            Log.w(str + af, obj + "", th);
        }
    }

    public static void a(String str, Object obj) {
        if (l() || k()) {
            Log.w(str + af, obj + "");
        }
    }

    public static void a(String str, String... strArr) {
        if (L) {
            String str2 = af + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i] != null) {
                        String str3 = strArr[i];
                        if (str3.endsWith(":") || str3.endsWith(": ")) {
                            sb.append(str3);
                        } else {
                            sb.append(str3);
                            sb.append(",");
                        }
                    }
                }
            }
            Log.i(str2, sb.toString());
        }
    }
}
