package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.downloadnew.a.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.c;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.downloadnew.a.e;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.ss.android.downloadlib.addownload.a.a;

/* compiled from: TTDownloadFactory */
public class a {
    public static com.bytedance.sdk.openadsdk.downloadnew.core.a a(Context context, l lVar, String str) {
        if (aj.c(context)) {
            return new d(context, lVar, str);
        }
        return new b(context, lVar, str);
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.core.b b(Context context, l lVar, String str) {
        if (aj.c(context)) {
            return new c(context, lVar, str);
        }
        return new com.bytedance.sdk.openadsdk.downloadnew.a.a(context, lVar, str);
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.core.a a(Context context, String str, l lVar, String str2) {
        return new e(context, str, lVar, str2);
    }

    public static boolean a(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.a.a.a().a(activity, false, new a.AbstractC0085a() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.AnonymousClass1 */

            @Override // com.ss.android.downloadlib.addownload.a.a.AbstractC0085a
            public void a() {
                ExitInstallListener exitInstallListener = exitInstallListener;
                if (exitInstallListener != null) {
                    exitInstallListener.onExitInstall();
                }
            }
        });
    }

    public static String a() {
        try {
            return g.d().f();
        } catch (Exception e) {
            u.a("TTDownloadFactory", "get download sdk version error", e);
            return "0.0.0";
        }
    }
}
