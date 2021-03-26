package com.amap.api.mapcore2d;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: HttpsDecisionUtil */
public class cw {
    private volatile b a = new b();
    private el b = new el("HttpsDecisionUtil");

    /* compiled from: HttpsDecisionUtil */
    private static class a {
        static cw a = new cw();
    }

    public static cw a() {
        return a.a;
    }

    public void a(Context context) {
        if (this.a == null) {
            this.a = new b();
        }
        this.a.a(c(context));
        this.a.a(context);
    }

    public void b(Context context) {
        d(context);
    }

    public void a(boolean z) {
        if (this.a == null) {
            this.a = new b();
        }
        this.a.b(z);
    }

    void a(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b();
        }
        b(context, z);
        this.a.a(z);
    }

    public boolean b() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a.a();
    }

    private void b(Context context, boolean z) {
        this.b.a(context, "isTargetRequired", z);
    }

    private boolean c(Context context) {
        return this.b.b(context, "isTargetRequired", true);
    }

    private void d(Context context) {
        this.b.a(context, "isTargetRequired", true);
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

        public void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public void a(boolean z) {
            this.a = z;
        }

        public void b(boolean z) {
            this.d = z;
        }

        private int b() {
            int i = this.b;
            if (i <= 0) {
                return 28;
            }
            return i;
        }

        private boolean c() {
            return b() >= 28;
        }

        private boolean d() {
            return Build.VERSION.SDK_INT >= 28;
        }

        private boolean e() {
            return d() && (!this.a || c());
        }

        public boolean a() {
            return this.d || e();
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

    public static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public boolean b(boolean z) {
        if (c()) {
            return false;
        }
        if (z || b()) {
            return true;
        }
        return false;
    }
}
