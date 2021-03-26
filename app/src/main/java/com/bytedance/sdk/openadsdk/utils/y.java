package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;

/* compiled from: OAIDHelper */
public class y {
    private static volatile String a = "";
    private static volatile boolean b;

    static {
        try {
            if (TextUtils.isEmpty(a)) {
                a = d.a(p.a()).b("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        try {
            AppLog.setOaidObserver(new IOaidObserver() {
                /* class com.bytedance.sdk.openadsdk.utils.y.AnonymousClass1 */

                @Override // com.bytedance.embedapplog.IOaidObserver
                public void onOaidLoaded(IOaidObserver.Oaid oaid) {
                    try {
                        if (!TextUtils.isEmpty(oaid.id)) {
                            boolean unused = y.b = true;
                            String unused2 = y.a = oaid.id;
                            y.c();
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        TTCustomController e;
        if (TextUtils.isEmpty(a) && !b && (e = i.d().e()) != null && !TextUtils.isEmpty(e.getDevOaid())) {
            a = e.getDevOaid();
            c();
        }
        return a == null ? "" : a;
    }

    /* access modifiers changed from: private */
    public static void c() {
        if (!TextUtils.isEmpty(a)) {
            e.a(new a(a), 5);
        }
    }

    /* compiled from: OAIDHelper */
    private static class a implements Runnable {
        String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.a)) {
                d.a(p.a()).a("oaid", this.a);
                u.b("OAIDHelper", "oaid=" + this.a);
            }
        }
    }
}
