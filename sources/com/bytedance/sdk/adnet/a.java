package com.bytedance.sdk.adnet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.openadsdk.j.e;
import java.io.File;

/* compiled from: AdNetSdk */
public class a {
    public static n a = null;
    private static String b = null;
    private static b c = null;
    private static boolean d = true;
    private static com.bytedance.sdk.adnet.c.a e;

    public static l a(Context context) {
        return k.a(context);
    }

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(b)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                b = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            o.a(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return b;
    }

    public static void a(b bVar) {
        c = bVar;
    }

    public static b a() {
        b bVar = c;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static void a(boolean z) {
        d = z;
    }

    public static boolean b() {
        return d;
    }

    public static void c() {
        c.a(c.a.DEBUG);
    }

    public static void a(com.bytedance.sdk.adnet.c.a aVar) {
        e = aVar;
    }

    public static com.bytedance.sdk.adnet.c.a d() {
        return e;
    }

    public static void a(Context context, Application application, boolean z) {
        if (context != null) {
            f.a().a(context, com.bytedance.sdk.adnet.d.f.b(context));
            if (com.bytedance.sdk.adnet.d.f.a(context) || (!com.bytedance.sdk.adnet.d.f.b(context) && z)) {
                com.bytedance.sdk.adnet.a.a.a(context).c();
                com.bytedance.sdk.adnet.a.a.a(context).a();
            }
            if (com.bytedance.sdk.adnet.d.f.b(context)) {
                com.bytedance.sdk.adnet.a.a.a(context);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet context is null");
    }

    public static void a(Activity activity) {
        if (activity != null) {
            final Context applicationContext = activity.getApplicationContext();
            e.a().execute(new Runnable() {
                /* class com.bytedance.sdk.adnet.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.adnet.a.a.a(applicationContext).c();
                    com.bytedance.sdk.adnet.a.a.a(applicationContext);
                    com.bytedance.sdk.adnet.a.a.b(applicationContext);
                }
            });
        }
    }
}
