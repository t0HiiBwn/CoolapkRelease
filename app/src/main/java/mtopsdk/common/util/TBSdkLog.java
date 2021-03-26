package mtopsdk.common.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.log.LogAdapter;

public class TBSdkLog {
    private static boolean a = true;
    private static boolean b = true;
    private static LogEnable c = LogEnable.DebugEnable;
    private static Map<String, LogEnable> d = new HashMap(5);
    private static LogAdapter e;

    static {
        LogEnable[] values = LogEnable.values();
        for (LogEnable logEnable : values) {
            d.put(logEnable.getLogEnable(), logEnable);
        }
    }

    public enum LogEnable {
        VerboseEnable("V"),
        DebugEnable("D"),
        InfoEnable("I"),
        WarnEnable("W"),
        ErrorEnable("E"),
        NoneEnable("L");
        
        private String logEnable;

        public final String getLogEnable() {
            return this.logEnable;
        }

        private LogEnable(String str) {
            this.logEnable = str;
        }
    }

    public static void setLogAdapter(LogAdapter logAdapter) {
        e = logAdapter;
        Log.d("mtopsdk.TBSdkLog", "[setLogAdapter] logAdapter=" + logAdapter);
    }

    public static void setPrintLog(boolean z) {
        a = z;
        Log.d("mtopsdk.TBSdkLog", "[setPrintLog] printLog=" + z);
    }

    public static boolean isPrintLog() {
        return a;
    }

    public static void setTLogEnabled(boolean z) {
        b = z;
        Log.d("mtopsdk.TBSdkLog", "[setTLogEnabled] tLogEnabled=" + z);
    }

    public static void setLogEnable(LogEnable logEnable) {
        if (logEnable != null) {
            c = logEnable;
            Log.d("mtopsdk.TBSdkLog", "[setLogEnable] logEnable=" + logEnable);
        }
    }

    public static void d(String str, String str2) {
        d(str, (String) null, str2);
    }

    public static void d(String str, String str2, String str3) {
        if (!isLogEnable(LogEnable.DebugEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(2, str, a(str2, str3), null);
            }
        } else if (a) {
            Log.d(str, a(str2, str3));
        }
    }

    public static void d(String str, String str2, String... strArr) {
        if (!isLogEnable(LogEnable.DebugEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(2, str, a(str2, strArr), null);
            }
        } else if (a) {
            Log.d(str, a(str2, strArr));
        }
    }

    public static void i(String str, String str2) {
        i(str, (String) null, str2);
    }

    public static void i(String str, String str2, String str3) {
        if (!isLogEnable(LogEnable.InfoEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(4, str, a(str2, str3), null);
            }
        } else if (a) {
            Log.i(str, a(str2, str3));
        }
    }

    public static void i(String str, String str2, String... strArr) {
        if (!isLogEnable(LogEnable.InfoEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(4, str, a(str2, strArr), null);
            }
        } else if (a) {
            Log.i(str, a(str2, strArr));
        }
    }

    public static void w(String str, String str2) {
        w(str, (String) null, str2);
    }

    public static void w(String str, String str2, String str3) {
        if (!isLogEnable(LogEnable.WarnEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(8, str, a(str2, str3), null);
            }
        } else if (a) {
            Log.w(str, a(str2, str3));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        w(str, null, str2, th);
    }

    public static void w(String str, String str2, String str3, Throwable th) {
        if (!isLogEnable(LogEnable.WarnEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(8, str, a(str2, str3), th);
            }
        } else if (a) {
            Log.w(str, a(str2, str3), th);
        }
    }

    public static void e(String str, String str2) {
        e(str, (String) null, str2);
    }

    public static void e(String str, String str2, String str3) {
        if (!isLogEnable(LogEnable.ErrorEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(16, str, a(str2, str3), null);
            }
        } else if (a) {
            Log.e(str, a(str2, str3));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, null, str2, th);
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (!isLogEnable(LogEnable.ErrorEnable)) {
            return;
        }
        if (b) {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.printLog(16, str, a(str2, str3), th);
            }
        } else if (a) {
            Log.e(str, a(str2, str3), th);
        }
    }

    private static String a(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("[seq:");
            sb.append(str);
            sb.append("]|");
        }
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i < strArr.length - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static boolean isLogEnable(LogEnable logEnable) {
        LogAdapter logAdapter;
        LogEnable logEnable2;
        if (!(!b || (logAdapter = e) == null || (logEnable2 = d.get(logAdapter.getLogLevel())) == null || c.ordinal() == logEnable2.ordinal())) {
            setLogEnable(logEnable2);
        }
        return logEnable.ordinal() >= c.ordinal();
    }

    public static void logTraceId(String str, String str2) {
        try {
            LogAdapter logAdapter = e;
            if (logAdapter != null) {
                logAdapter.traceLog(str, str2);
            }
        } catch (Throwable unused) {
            Log.w("mtopsdk.TBSdkLog", "[logTraceId] call LogAdapter.traceLog error");
        }
    }
}
