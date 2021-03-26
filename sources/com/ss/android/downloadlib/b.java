package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.d;
import com.ss.android.a.a.b.g;
import com.ss.android.a.a.c.c;
import com.ss.android.downloadad.a.a.a;
import com.ss.android.downloadad.a.a.b;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.h.h;
import com.ss.android.downloadlib.h.j;
import org.json.JSONObject;

/* compiled from: AdWebViewDownloadManagerImpl */
public class b implements com.ss.android.downloadad.a.b {
    private static String a = "b";
    private static volatile b b;
    private g c = g.a(k.a());

    private b() {
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    @Override // com.ss.android.downloadad.a.b
    public Dialog a(Context context, String str, boolean z, final c cVar, com.ss.android.a.a.b.b bVar, a aVar, d dVar, int i) {
        if (b(cVar.d())) {
            a(cVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(cVar.a())) {
            return null;
        } else {
            this.c.a(context, i, dVar, cVar);
            boolean z2 = true;
            final com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.h.k.a(bVar, c());
            final a aVar2 = (a) com.ss.android.downloadlib.h.k.a(aVar, b());
            bVar2.a(1);
            boolean z3 = (k.i().optInt("disable_lp_dialog", 0) == 1) | z;
            if (!aVar2.e() || !com.ss.android.downloadlib.addownload.compliance.b.a().a(cVar)) {
                z2 = z3;
            }
            if (z2) {
                this.c.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                return null;
            }
            String str2 = a;
            j.a(str2, "tryStartDownload show dialog appName:" + cVar.a(), null);
            Dialog b2 = k.d().b(new c.a(context).a(cVar.h()).b("确认要下载此应用吗？").c("确认").d("取消").a(new c.b() {
                /* class com.ss.android.downloadlib.b.AnonymousClass1 */

                @Override // com.ss.android.a.a.c.c.b
                public void a(DialogInterface dialogInterface) {
                    b.this.c.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                    com.ss.android.downloadlib.e.a.a().a("landing_download_dialog_confirm", cVar, bVar2, aVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.c.c.b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.a().a("landing_download_dialog_cancel", cVar, bVar2, aVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.c.c.b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.a().a("landing_download_dialog_cancel", cVar, bVar2, aVar2);
                }
            }).a(0).a());
            com.ss.android.downloadlib.e.a.a().a("landing_download_dialog_show", cVar, bVar2, aVar2);
            return b2;
        }
    }

    @Override // com.ss.android.downloadad.a.b
    public boolean a(Context context, long j, String str, d dVar, int i) {
        com.ss.android.downloadad.a.b.b d = f.a().d(j);
        if (d != null) {
            this.c.a(context, i, dVar, d.ae());
            return true;
        }
        com.ss.android.a.a.b.c a2 = f.a().a(j);
        if (a2 == null) {
            return false;
        }
        this.c.a(context, i, dVar, a2);
        return true;
    }

    public void a(long j) {
        com.ss.android.a.a.b.c a2 = f.a().a(j);
        com.ss.android.downloadad.a.b.b d = f.a().d(j);
        if (a2 == null && d != null) {
            a2 = d.ae();
        }
        if (a2 != null) {
            com.ss.android.a.a.b.b b2 = f.a().b(j);
            a c2 = f.a().c(j);
            if (b2 instanceof g) {
                b2 = null;
            }
            if (c2 instanceof com.ss.android.a.a.b.f) {
                c2 = null;
            }
            if (d == null) {
                if (b2 == null) {
                    b2 = c();
                }
                if (c2 == null) {
                    c2 = b();
                }
            } else {
                if (b2 == null) {
                    b2 = new b.a().a(d.j()).i(d.i()).c(d.m()).a(false).c("click_start_detail").d("click_pause_detail").e("click_continue_detail").f("click_install_detail").h("storage_deny_detail").a();
                }
                if (c2 == null) {
                    c2 = d.ag();
                }
            }
            b2.a(1);
            this.c.a(a2.a(), j, 2, b2, c2);
        }
    }

    public boolean b(long j) {
        return (f.a().a(j) == null && f.a().d(j) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.a.b
    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, a aVar) {
        a aVar2 = aVar;
        if (!com.ss.android.downloadlib.b.j.a(uri) || k.i().optInt("disable_market") == 1) {
            return false;
        }
        Context a2 = context == null ? k.a() : context;
        String b2 = com.ss.android.downloadlib.b.j.b(uri);
        if (cVar != null) {
            if (aVar2 != null) {
                aVar2.a(2);
            } else if ((cVar instanceof com.ss.android.downloadad.a.a.c) && TextUtils.isEmpty(cVar.a())) {
                ((com.ss.android.downloadad.a.a.c) cVar).c(uri.toString());
                aVar2 = a(true);
            } else if (cVar.a().startsWith("market")) {
                aVar2 = a(true);
            } else {
                aVar2 = b();
            }
            e eVar = new e(cVar.d(), cVar, (com.ss.android.a.a.b.b) com.ss.android.downloadlib.h.k.a(bVar, c()), aVar2);
            if (!TextUtils.isEmpty(b2) && (cVar instanceof com.ss.android.downloadad.a.a.c)) {
                ((com.ss.android.downloadad.a.a.c) cVar).b(b2);
            }
            if (com.ss.android.downloadlib.h.k.a(cVar) && com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.a(eVar)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.k.a(jSONObject, "market_url", uri.toString());
            com.ss.android.downloadlib.e.a.a().a("market_click_open", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
            com.ss.android.downloadlib.addownload.b.g a3 = h.a(a2, eVar, b2);
            String a4 = com.ss.android.downloadlib.h.k.a(a3.c(), "open_market");
            if (a3.a() == 5) {
                com.ss.android.downloadlib.b.a.a(a4, jSONObject, eVar);
                return true;
            }
            com.ss.android.downloadlib.h.k.a(jSONObject, "error_code", Integer.valueOf(a3.b()));
            com.ss.android.downloadlib.e.a.a().a("market_open_failed", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
            return false;
        } else if (h.a(a2, b2).a() == 5) {
            return true;
        } else {
            return false;
        }
    }

    public static a b() {
        return a(false);
    }

    public static a a(boolean z) {
        a.C0080a d = new a.C0080a().a(0).a(true).c(false).d(false);
        if (z) {
            d.b(2);
        } else {
            d.b(0);
        }
        return d.a();
    }

    public static com.ss.android.a.a.b.b c() {
        return new b.a().a("landing_h5_download_ad_button").b("landing_h5_download_ad_button").c("click_start_detail").d("click_pause_detail").e("click_continue_detail").f("click_install_detail").g("click_open_detail").h("storage_deny_detail").a(1).a(false).b(true).c(false).a();
    }
}
