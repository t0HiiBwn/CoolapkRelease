package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: Logger */
public class a {
    private static int a = 4;
    private static AbstractC0105a b;

    /* renamed from: com.ss.android.socialbase.downloader.c.a$a  reason: collision with other inner class name */
    /* compiled from: Logger */
    public static abstract class AbstractC0105a {
        public void a(String str, String str2) {
        }

        public void a(String str, String str2, Throwable th) {
        }

        public void b(String str, String str2) {
        }

        public void c(String str, String str2) {
        }

        public void d(String str, String str2) {
        }

        public void e(String str, String str2) {
        }
    }

    public static void a(int i) {
        a = i;
    }

    public static boolean a() {
        return a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 != null) {
            if (a <= 2) {
                Log.v(str, str2);
            }
            AbstractC0105a aVar = b;
            if (aVar != null) {
                aVar.a(b(str), str2);
            }
        }
    }

    public static void a(String str) {
        b("DownloaderLogger", str);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void b(String str, String str2) {
        if (str2 != null) {
            if (a <= 3) {
                Log.d(b(str), str2);
            }
            AbstractC0105a aVar = b;
            if (aVar != null) {
                aVar.b(b(str), str2);
            }
        }
    }

    public static void c(String str, String str2) {
        if (str2 != null) {
            if (a <= 4) {
                Log.i(b(str), str2);
            }
            AbstractC0105a aVar = b;
            if (aVar != null) {
                aVar.c(b(str), str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (str2 != null) {
            if (a <= 5) {
                Log.w(b(str), str2);
            }
            AbstractC0105a aVar = b;
            if (aVar != null) {
                aVar.e(b(str), str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            if (a <= 6) {
                Log.e(b(str), str2);
            }
            AbstractC0105a aVar = b;
            if (aVar != null) {
                aVar.d(b(str), str2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 != null || th != null) {
            if (a <= 6) {
                Log.e(b(str), str2, th);
            }
            AbstractC0105a aVar = b;
            if (aVar != null) {
                aVar.a(b(str), str2, th);
            }
        }
    }
}
