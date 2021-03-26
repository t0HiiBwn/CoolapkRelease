package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

final class by {
    static boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    static void a(String str, Runnable runnable) {
        if (runnable != null) {
            if (TextUtils.isEmpty(str)) {
                str = "TrackerDr";
            }
            new Thread(new a(runnable, str), str).start();
        }
    }

    static class a implements Runnable {
        private final Runnable a;
        private final String b;
        private final String c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        a(Runnable runnable, String str) {
            this.a = runnable;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e) {
                e.printStackTrace();
                bx.b("TrackerDr", "Thread:" + this.b + " exception\n" + this.c, e);
            }
        }
    }
}
