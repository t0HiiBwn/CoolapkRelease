package com.bytedance.sdk.openadsdk.core.h;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SdkSwitch */
public class g {
    private static AtomicInteger a = new AtomicInteger(1);

    public static boolean a() {
        return a.get() == 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    protected static void a(int i) {
        Throwable th;
        boolean z = true;
        if (i == 1 || i == 2) {
            try {
                if (a.get() != i) {
                    try {
                        a.set(i);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    z = false;
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
                th.printStackTrace();
                if (!z) {
                }
            }
            if (!z) {
                Log.e("SdkSwitch", "switch status changed: " + a());
                if (a()) {
                    p.b();
                    return;
                }
                try {
                    if (p.c() != null) {
                        p.c().b();
                    }
                    if (p.e() != null) {
                        p.e().b();
                    }
                    if (p.d() != null) {
                        p.d().b();
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    if (p.g() != null) {
                        p.g().a();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                try {
                    if (p.i() != null) {
                        p.i().b();
                    }
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        }
    }
}
