package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.l;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b {
    private static int a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static Context f104a;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f105a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f106a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static String f107a = ("XMPush-" + Process.myPid());

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f108a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f109a = new AtomicInteger(1);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f110a;
    private static final HashMap<Integer, String> b = new HashMap<>();

    static class a implements LoggerInterface {
        private String a = b.f107a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.a = str;
        }
    }

    public static int a() {
        return a;
    }

    public static Integer a(String str) {
        if (a > 1) {
            return f106a;
        }
        Integer valueOf = Integer.valueOf(f109a.incrementAndGet());
        f108a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        b.put(valueOf, str);
        LoggerInterface loggerInterface = f105a;
        loggerInterface.log(str + " starts");
        return valueOf;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m40a(String str) {
        return b() + str;
    }

    private static String a(String str, String str2) {
        return b() + "[" + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f105a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f105a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f105a.log("", th);
        }
    }

    public static void a(Context context) {
        f104a = context;
        if (l.m569a(context)) {
            f110a = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f105a = loggerInterface;
    }

    public static void a(Integer num) {
        if (a <= 1) {
            HashMap<Integer, Long> hashMap = f108a;
            if (hashMap.containsKey(num)) {
                long currentTimeMillis = System.currentTimeMillis() - hashMap.remove(num).longValue();
                LoggerInterface loggerInterface = f105a;
                loggerInterface.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m41a(String str) {
        a(2, m40a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m42a(String str, String str2) {
        a(2, a(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m40a(str), th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static void b(String str) {
        a(0, m40a(str));
    }

    public static void c(String str) {
        a(1, m40a(str));
    }

    public static void d(String str) {
        a(4, m40a(str));
    }

    public static void e(String str) {
        if (f110a) {
            m41a(str);
        } else {
            Log.i(f107a, m40a(str));
        }
    }
}
