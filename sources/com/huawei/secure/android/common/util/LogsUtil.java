package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

public class LogsUtil {
    private static final Pattern k = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    private static final char l = '*';
    private static final int m = 2;

    private static String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(a(str2));
        }
        return sb.toString();
    }

    public static void d(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, a(str2, z));
        }
    }

    public static void d(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.d(str, a(str2, str3));
        }
    }

    public static void d(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.d(str, a(str2, str3), a(th));
        }
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, a(str2, false));
        }
    }

    public static void d(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, a(str2, z), a(th));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.d(str, a(str2, false), a(th));
        }
    }

    public static void i(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, z));
        }
    }

    public static void i(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, a(str2, str3));
        }
    }

    public static void i(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, a(str2, str3), a(th));
        }
    }

    public static void i(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, false));
        }
    }

    public static void i(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.i(str, a(str2, z), a(th));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.i(str, a(str2, false), a(th));
        }
    }

    public static void w(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, z));
        }
    }

    public static void w(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, a(str2, str3));
        }
    }

    public static void w(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, a(str2, str3), a(th));
        }
    }

    public static void w(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, false));
        }
    }

    public static void w(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.w(str, a(str2, z), a(th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.w(str, a(str2, false), a(th));
        }
    }

    public static void e(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, z));
        }
    }

    public static void e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, a(str2, str3));
        }
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, a(str2, str3), a(th));
        }
    }

    public static void e(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, false));
        }
    }

    public static void e(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.e(str, a(str2, z), a(th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.e(str, a(str2, false), a(th));
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (k.matcher(String.valueOf(charAt)).matches()) {
                if (i % 2 == 0) {
                    charAt = '*';
                }
                i++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static Throwable a(Throwable th) {
        if (th == null) {
            return null;
        }
        a aVar = new a(th);
        aVar.setStackTrace(th.getStackTrace());
        aVar.setMessage(b(th.getMessage()));
        Throwable cause = th.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.setMessage(b(cause.getMessage()));
            aVar2.b(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 0) {
                charArray[i] = '*';
            }
        }
        return new String(charArray);
    }

    private static class a extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String n;
        private Throwable o;
        private Throwable p;

        public a(Throwable th) {
            this.p = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.o;
            if (th == this) {
                return null;
            }
            return th;
        }

        public void b(Throwable th) {
            this.o = th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.n;
        }

        public void setMessage(String str) {
            this.n = str;
        }

        @Override // java.lang.Throwable, java.lang.Object
        public String toString() {
            Throwable th = this.p;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.n == null) {
                return name;
            }
            String str = name + ": ";
            if (this.n.startsWith(str)) {
                return this.n;
            }
            return str + this.n;
        }
    }
}
