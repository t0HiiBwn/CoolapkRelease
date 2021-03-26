package com.alibaba.baichuan.trade.common.utils;

import android.util.Log;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;

public class AlibcLogger {
    private static final String a = ("AliBC_Trade[" + AlibcTradeCommon.systemVersion + "]");

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    private static String a(String str, String str2) {
        String str3;
        String str4;
        int i;
        Exception e;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            str4 = stackTrace[2].getClassName();
            try {
                str3 = stackTrace[2].getMethodName();
                try {
                    i = stackTrace[2].getLineNumber();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                str3 = "";
                e.printStackTrace();
                i = -1;
                StringBuffer stringBuffer = new StringBuffer();
                if (str == null) {
                }
                stringBuffer.append(str);
                stringBuffer.append(" -> [");
                stringBuffer.append(str4);
                stringBuffer.append(".");
                stringBuffer.append(str3);
                stringBuffer.append(":");
                stringBuffer.append(i);
                stringBuffer.append("] ");
                if (str2 == null) {
                }
                stringBuffer.append(str2);
                return stringBuffer.toString();
            }
        } catch (Exception e4) {
            e = e4;
            str4 = "";
            str3 = str4;
            e.printStackTrace();
            i = -1;
            StringBuffer stringBuffer = new StringBuffer();
            if (str == null) {
            }
            stringBuffer.append(str);
            stringBuffer.append(" -> [");
            stringBuffer.append(str4);
            stringBuffer.append(".");
            stringBuffer.append(str3);
            stringBuffer.append(":");
            stringBuffer.append(i);
            stringBuffer.append("] ");
            if (str2 == null) {
            }
            stringBuffer.append(str2);
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null) {
            str = "";
        }
        stringBuffer.append(str);
        stringBuffer.append(" -> [");
        stringBuffer.append(str4);
        stringBuffer.append(".");
        stringBuffer.append(str3);
        stringBuffer.append(":");
        stringBuffer.append(i);
        stringBuffer.append("] ");
        if (str2 == null) {
            str2 = "";
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    private static void a(int i, String str, String str2) {
    }

    public static void d(String str, String str2) {
        if (AlibcTradeCommon.isDebug()) {
            Log.d(a, a(str, str2));
        }
    }

    public static void e(String str, String str2) {
        if (AlibcTradeCommon.isDebug()) {
            Log.e(a, a(str, str2));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(a, a(str, str2), th);
    }

    public static void i(String str, String str2) {
        if (AlibcTradeCommon.isDebug()) {
            Log.i(a, a(str, str2));
        }
    }

    public static void tlogd(String str, String str2) {
        String a2 = a(str, str2);
        if (AlibcTradeCommon.isDebug()) {
            Log.d(a, a2);
        }
        a(3, a, a2);
    }

    public static void tloge(String str, String str2) {
        String a2 = a(str, str2);
        if (AlibcTradeCommon.isDebug()) {
            Log.e(a, a2);
        }
        a(6, a, a2);
    }

    public static void tloge(String str, String str2, Throwable th) {
        String a2 = a(str, str2);
        if (AlibcTradeCommon.isDebug()) {
            Log.e(a, a2, th);
        }
        String str3 = a;
        a(6, str3, a2 + '\n' + Log.getStackTraceString(th));
    }

    public static void tlogi(String str, String str2) {
        String a2 = a(str, str2);
        if (AlibcTradeCommon.isDebug()) {
            Log.i(a, a2);
        }
        a(4, a, a2);
    }

    public static void tlogw(String str, String str2) {
        String a2 = a(str, str2);
        if (AlibcTradeCommon.isDebug()) {
            Log.w(a, a2);
        }
        a(5, a, a2);
    }

    public static void tlogw(String str, String str2, Throwable th) {
        String a2 = a(str, str2);
        if (AlibcTradeCommon.isDebug()) {
            Log.w(a, a2, th);
        }
        String str3 = a;
        a(5, str3, a2 + '\n' + Log.getStackTraceString(th));
    }

    public static void w(String str, String str2) {
        if (AlibcTradeCommon.isDebug()) {
            Log.w(a, a(str, str2));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (AlibcTradeCommon.isDebug()) {
            Log.w(a, a(str, str2), th);
        }
    }
}
