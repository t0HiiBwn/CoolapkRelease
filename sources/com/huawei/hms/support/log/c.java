package com.huawei.hms.support.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: LogRecord */
public class c {
    private final StringBuilder a = new StringBuilder();
    private String b = null;
    private String c = "HMS";
    private int d = 0;
    private long e = 0;
    private long f = 0;
    private String g;
    private int h;
    private int i;
    private int j = 0;

    c(int i2, String str, int i3, String str2) {
        this.j = i2;
        this.b = str;
        this.d = i3;
        if (str2 != null) {
            this.c = str2;
        }
        c();
    }

    public static String a(int i2) {
        if (i2 == 3) {
            return "D";
        }
        if (i2 == 4) {
            return "I";
        }
        if (i2 != 5) {
            return i2 != 6 ? String.valueOf(i2) : "E";
        }
        return "W";
    }

    private c c() {
        this.e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f = currentThread.getId();
        this.h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i2 = this.j;
        if (length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            this.g = stackTraceElement.getFileName();
            this.i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public <T> c a(T t) {
        this.a.append((Object) t);
        return this;
    }

    public c a(Throwable th) {
        a((c) '\n').a((c) Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    private StringBuilder a(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.e)));
        String a2 = a(this.d);
        sb.append(' ');
        sb.append(a2);
        sb.append('/');
        sb.append(this.c);
        sb.append('/');
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.h);
        sb.append(':');
        sb.append(this.f);
        sb.append(' ');
        sb.append(this.g);
        sb.append(':');
        sb.append(this.i);
        sb.append(']');
        return sb;
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    private StringBuilder b(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.a.toString());
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        b(sb);
        return sb.toString();
    }
}
