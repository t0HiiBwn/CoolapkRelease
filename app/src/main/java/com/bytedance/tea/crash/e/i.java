package com.bytedance.tea.crash.e;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;

/* compiled from: ProcessCpuTracker */
public class i {
    private static long a = -1;

    /* compiled from: ProcessCpuTracker */
    static class a {
        private static long a = -1;

        public static long a(long j) {
            long j2;
            long j3 = a;
            if (j3 > 0) {
                return j3;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                j2 = Os.sysconf(OsConstants._SC_CLK_TCK);
            } else {
                j2 = Build.VERSION.SDK_INT >= 14 ? a("_SC_CLK_TCK", j) : j;
            }
            if (j2 > 0) {
                j = j2;
            }
            a = j;
            return j;
        }

        public static long a() {
            if (i.a == -1) {
                long unused = i.a = 1000 / b();
            }
            return i.a;
        }

        public static long b() {
            return a(100);
        }

        private static long a(String str, long j) {
            try {
                int i = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Class<?> cls2 = Class.forName("libcore.io.Os");
                return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i))).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return j;
            }
        }
    }
}
