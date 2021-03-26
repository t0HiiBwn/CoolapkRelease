package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: HttpsDecisionUtil */
public final class bo {
    private volatile b a = new b((byte) 0);
    private ci b = new ci("HttpsDecisionUtil");

    /* compiled from: HttpsDecisionUtil */
    private static class a {
        static bo a = new bo();
    }

    public static bo a() {
        return a.a;
    }

    public final void a(Context context) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.a(ci.a(context, "open_common", "a3", true));
        this.a.a(context);
    }

    public final void a(boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.b(z);
    }

    final void a(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        b(context, z);
        this.a.a(z);
    }

    private static void b(Context context, boolean z) {
        SharedPreferences.Editor b2 = ci.b(context, "open_common");
        ci.a(b2, "a3", z);
        ci.a(b2);
    }

    /* compiled from: HttpsDecisionUtil */
    private static class b {
        protected boolean a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.a = true;
            this.c = true;
            this.d = false;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void b(boolean z) {
            this.d = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[RETURN] */
        public final boolean a() {
            boolean z;
            if (!this.d) {
                boolean z2 = Build.VERSION.SDK_INT >= 28;
                if (this.a) {
                    int i = this.b;
                    if (i <= 0) {
                        i = 28;
                    }
                    if (!(i >= 28)) {
                        z = false;
                        if (!z2 && z) {
                            return false;
                        }
                    }
                }
                z = true;
                if (!z2 && z) {
                }
            }
            return true;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.scheme("https");
            return buildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final boolean b(boolean z) {
        if (b()) {
            return false;
        }
        if (z) {
            return true;
        }
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        if (this.a.a()) {
            return true;
        }
        return false;
    }

    public static void b(Context context) {
        b(context, true);
    }
}
