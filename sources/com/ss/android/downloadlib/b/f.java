package com.ss.android.downloadlib.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.d;
import com.ss.android.downloadlib.h.e;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.a.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppLinkOptimiseHelper */
public class f {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static void a(final b bVar, final h hVar) {
        boolean b = a.a().b();
        if (!b && Build.VERSION.SDK_INT >= 29) {
            k.c();
        }
        boolean b2 = a.a().b();
        boolean z = !b && b2;
        if (bVar != null) {
            bVar.l(z);
        }
        hVar.a(z);
        if (bVar != null) {
            b(bVar, j(bVar));
            if (!b2) {
                final long currentTimeMillis = System.currentTimeMillis();
                a.a().a(new a.AbstractC0102a() {
                    /* class com.ss.android.downloadlib.b.f.AnonymousClass1 */

                    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
                    public void c() {
                    }

                    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
                    public void b() {
                        a.a().b(this);
                        d.a().a(new Runnable() {
                            /* class com.ss.android.downloadlib.b.f.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                boolean c = k.c(bVar.e());
                                long e = f.e(bVar);
                                if (!c || e >= System.currentTimeMillis() - currentTimeMillis) {
                                    if (System.currentTimeMillis() - currentTimeMillis > f.h(bVar)) {
                                        com.ss.android.downloadlib.e.a.a().a("deeplink_delay_timeout", bVar);
                                        return;
                                    }
                                    bVar.l(true);
                                    com.ss.android.downloadlib.e.a.a().a("deeplink_delay_invoke", bVar);
                                    hVar.a(true);
                                    f.b(bVar, f.j(bVar));
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(final b bVar, final int i) {
        if (i > 0) {
            d.a().a(new Runnable() {
                /* class com.ss.android.downloadlib.b.f.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    int i = 1;
                    if (k.c(bVar.e())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!bVar.Z()) {
                                i = 2;
                            }
                            jSONObject.putOpt("deeplink_source", Integer.valueOf(i));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        com.ss.android.downloadlib.e.a.a().a("deeplink_success_2", jSONObject, bVar);
                        return;
                    }
                    f.b(bVar, i - 1);
                }
            }, (long) (i(bVar) * 1000));
        }
    }

    /* access modifiers changed from: private */
    public static long h(b bVar) {
        return e.a(bVar).a("app_link_check_timeout", 300000L);
    }

    private static int i(b bVar) {
        return e.a(bVar).a("app_link_check_delay", 1);
    }

    /* access modifiers changed from: private */
    public static int j(b bVar) {
        return e.a(bVar).a("app_link_check_count", 10);
    }

    public static boolean a(b bVar) {
        return e.a(bVar).b("app_link_opt_switch") == 1;
    }

    public static boolean b(b bVar) {
        return e.a(bVar).b("app_link_opt_install_switch") == 1;
    }

    public static boolean c(b bVar) {
        return e.a(bVar).b("app_link_opt_invoke_switch") == 1;
    }

    public static boolean d(b bVar) {
        return e.a(bVar).b("app_link_opt_dialog_switch") == 1;
    }

    public static long e(b bVar) {
        if (bVar == null) {
            return 3000;
        }
        return (long) (e.a(bVar).a("app_link_opt_back_time_limit", 3) * 1000);
    }
}
