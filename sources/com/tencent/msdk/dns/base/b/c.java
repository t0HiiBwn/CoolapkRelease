package com.tencent.msdk.dns.base.b;

import android.app.Activity;
import android.app.ActivityThread;
import android.app.Application;
import android.content.Context;
import com.tencent.msdk.dns.base.d.a;
import com.tencent.msdk.dns.base.log.b;

/* compiled from: ApplicationProvider */
final class c {
    private static Application a;

    public static Application a(Context context) {
        if (a == null) {
            Application b = b(context);
            a = b;
            if (b == null) {
                a = b(a.a().b());
            }
            if (a == null) {
                a = a();
            }
        }
        return a;
    }

    private static Application b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Application) {
                return (Application) context;
            }
            if (context instanceof Activity) {
                return ((Activity) context).getApplication();
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
            return null;
        } catch (Exception e) {
            b.b(e, "Get Application failed", new Object[0]);
            return null;
        }
    }

    private static Application a() {
        try {
            return ActivityThread.currentActivityThread().getApplication();
        } catch (Throwable unused) {
            return null;
        }
    }
}
