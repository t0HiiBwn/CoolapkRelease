package com.ss.android.downloadlib.b;

import android.text.TextUtils;
import com.ss.android.a.a.c.b;
import com.ss.android.downloadad.a.a.c;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.g;
import com.ss.android.downloadlib.addownload.i;
import com.ss.android.downloadlib.h.f;
import com.ss.android.downloadlib.h.h;
import com.ss.android.downloadlib.h.k;
import org.json.JSONObject;

/* compiled from: AdAppLinkUtils */
public class a {
    public static boolean a(e eVar) {
        String str;
        boolean z;
        b x = eVar.b.x();
        if (x == null) {
            str = null;
        } else {
            str = x.b();
        }
        JSONObject a = f.a(new JSONObject(), eVar);
        k.a(a, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.e.a.a().a("applink_click", a, (com.ss.android.downloadad.a.b.a) eVar);
        g b = h.b(str, eVar);
        if (b.a() == 2) {
            if (!TextUtils.isEmpty(str)) {
                b("by_url", b, a, eVar);
            }
            b = h.a(com.ss.android.downloadlib.addownload.k.a(), eVar.b.v(), eVar);
        }
        boolean z2 = false;
        if (!a(eVar.a) || com.ss.android.downloadlib.addownload.k.i().optInt("link_ad_click_event") != 1) {
            z = false;
        } else {
            if (eVar.b instanceof c) {
                ((c) eVar.b).a(4);
            }
            com.ss.android.downloadlib.e.a.a().a(eVar.a, 0);
            z = true;
        }
        int a2 = b.a();
        if (a2 == 1) {
            b("by_url", a, eVar);
        } else if (a2 != 3) {
            if (a2 != 4) {
                k.b();
            } else {
                a("by_package", b, a, eVar);
            }
            if (z2 && !z && ((com.ss.android.downloadlib.e.c.a().b() && !com.ss.android.downloadlib.e.c.a().b(eVar.a, eVar.b.u())) || com.ss.android.downloadlib.e.c.a().c())) {
                com.ss.android.downloadlib.e.a.a().a(eVar.a, 2);
            }
            return z2;
        } else {
            a("by_package", a, (com.ss.android.downloadad.a.b.a) eVar);
        }
        z2 = true;
        com.ss.android.downloadlib.e.a.a().a(eVar.a, 2);
        return z2;
    }

    public static void a(com.ss.android.downloadad.a.b.b bVar) {
        String f = bVar.f();
        JSONObject a = f.a(new JSONObject(), bVar);
        k.a(a, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.e.a.a().a("applink_click", a, (com.ss.android.downloadad.a.b.a) bVar);
        g b = h.b(f, bVar);
        if (b.a() == 2) {
            if (!TextUtils.isEmpty(f)) {
                b("notify_by_url", b, a, bVar);
            }
            b = h.a(com.ss.android.downloadlib.addownload.k.a(), bVar.e(), bVar);
        }
        int a2 = b.a();
        if (a2 == 1) {
            b("notify_by_url", a, bVar);
        } else if (a2 == 3) {
            a("notify_by_package", a, bVar);
        } else if (a2 != 4) {
            k.b();
        } else {
            a("notify_by_package", b, a, bVar);
        }
    }

    public static void b(com.ss.android.downloadad.a.b.b bVar) {
        if (bVar != null) {
            String str = null;
            if (com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1) {
                str = bVar.f();
            }
            JSONObject a = f.a(new JSONObject(), bVar);
            k.a(a, "applink_source", "dialog_click_by_sdk");
            com.ss.android.downloadlib.e.a.a().a("applink_click", a, (com.ss.android.downloadad.a.b.a) bVar);
            g b = h.b(str, bVar);
            if (b.a() == 2) {
                if (!TextUtils.isEmpty(str)) {
                    b("dialog_by_url", b, a, bVar);
                }
                b = h.a(com.ss.android.downloadlib.addownload.k.a(), bVar.e(), bVar);
            }
            int a2 = b.a();
            if (a2 == 1) {
                b("dialog_by_url", a, bVar);
            } else if (a2 == 3) {
                a("dialog_by_package", a, bVar);
            } else if (a2 != 4) {
                k.b();
            } else {
                a("dialog_by_package", b, a, bVar);
            }
        }
    }

    public static boolean a(String str, com.ss.android.downloadad.a.b.b bVar) {
        if (!i.b(bVar.N())) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.b.a().f(bVar.s());
        JSONObject jSONObject = new JSONObject();
        f.a(jSONObject, bVar);
        k.a(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.e.a.a().a("applink_click", (com.ss.android.downloadad.a.b.a) bVar);
        g a = h.a(bVar, bVar.f(), bVar.e());
        int a2 = a.a();
        if (a2 == 1) {
            b("auto_by_url", jSONObject, bVar);
            return true;
        } else if (a2 == 2) {
            b("auto_by_url", a, jSONObject, bVar);
            return false;
        } else if (a2 == 3) {
            a("auto_by_package", jSONObject, bVar);
            return true;
        } else if (a2 != 4) {
            return false;
        } else {
            a("auto_by_package", a, jSONObject, bVar);
            return false;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str, final JSONObject jSONObject, final com.ss.android.downloadad.a.b.a aVar) {
        k.a(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.e.a.a().a("deeplink_app_open", jSONObject, aVar);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1282070764:
                if (str.equals("notify_by_package")) {
                    c = 0;
                    break;
                }
                break;
            case -441514770:
                if (str.equals("auto_by_package")) {
                    c = 1;
                    break;
                }
                break;
            case -185950114:
                if (str.equals("by_package")) {
                    c = 2;
                    break;
                }
                break;
            case 368401333:
                if (str.equals("dialog_by_package")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                if (com.ss.android.downloadlib.addownload.k.i().optInt("download_sdk_optimize_mode") == 1) {
                    k.a(jSONObject, "check_applink_result_opt", (Object) 1);
                    e.a().a(aVar.e(), new d() {
                        /* class com.ss.android.downloadlib.b.a.AnonymousClass1 */

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            if (z) {
                                com.ss.android.downloadlib.e.a.a().a("deeplink_success", jSONObject, aVar);
                            } else {
                                com.ss.android.downloadlib.e.a.a().a("deeplink_failed", jSONObject, aVar);
                            }
                        }
                    });
                    return;
                }
                break;
            case 2:
            case 3:
                break;
            default:
                return;
        }
        com.ss.android.downloadlib.addownload.k.c().a(com.ss.android.downloadlib.addownload.k.a(), aVar.t(), aVar.v(), aVar.u(), aVar.e(), str);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(String str, final JSONObject jSONObject, final com.ss.android.downloadad.a.b.a aVar) {
        k.a(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.e.a.a().a("deeplink_url_open", jSONObject, aVar);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1721882089:
                if (str.equals("auto_by_url")) {
                    c = 0;
                    break;
                }
                break;
            case -1374618233:
                if (str.equals("by_url")) {
                    c = 1;
                    break;
                }
                break;
            case -129544387:
                if (str.equals("notify_by_url")) {
                    c = 2;
                    break;
                }
                break;
            case 829750366:
                if (str.equals("dialog_by_url")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
                if (com.ss.android.downloadlib.addownload.k.i().optInt("download_sdk_optimize_mode") == 1) {
                    k.a(jSONObject, "check_applink_result_opt", (Object) 1);
                    e.a().a(aVar.e(), new d() {
                        /* class com.ss.android.downloadlib.b.a.AnonymousClass2 */

                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            if (z) {
                                com.ss.android.downloadlib.e.a.a().a("deeplink_success", jSONObject, aVar);
                            } else {
                                com.ss.android.downloadlib.e.a.a().a("deeplink_failed", jSONObject, aVar);
                            }
                        }
                    });
                    return;
                }
                break;
            case 1:
            case 3:
                break;
            default:
                return;
        }
        com.ss.android.downloadlib.addownload.k.c().a(com.ss.android.downloadlib.addownload.k.a(), aVar.t(), aVar.v(), aVar.u(), aVar.e(), str);
    }

    public static void a(String str, g gVar, JSONObject jSONObject, com.ss.android.downloadad.a.b.a aVar) {
        k.a(jSONObject, "applink_source", str);
        k.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
        com.ss.android.downloadlib.e.a.a().a("deeplink_app_open_fail", jSONObject, aVar);
    }

    public static void b(String str, g gVar, JSONObject jSONObject, com.ss.android.downloadad.a.b.a aVar) {
        k.a(jSONObject, "applink_source", str);
        k.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
        com.ss.android.downloadlib.e.a.a().a("deeplink_url_open_fail", jSONObject, aVar);
    }

    public static boolean a(e eVar, int i) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.e.a.a().a("market_click_open", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
        g a = h.a(com.ss.android.downloadlib.addownload.k.a(), eVar, eVar.b.v());
        String a2 = k.a(a.c(), "open_market");
        int a3 = a.a();
        if (a3 == 5) {
            a(a2, jSONObject, eVar);
        } else if (a3 == 6) {
            k.a(jSONObject, "error_code", Integer.valueOf(a.b()));
            com.ss.android.downloadlib.e.a.a().a("market_open_failed", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
            return false;
        } else if (a3 != 7) {
            return false;
        }
        com.ss.android.downloadlib.e.a.a().a(eVar.a, i);
        return true;
    }

    public static void a(String str, JSONObject jSONObject, e eVar) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                k.a(e);
                return;
            }
        }
        k.a(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.e.a.a().a("market_open_success", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
        com.ss.android.downloadlib.addownload.k.c().a(com.ss.android.downloadlib.addownload.k.a(), eVar.b, eVar.d, eVar.c, eVar.b.v(), str);
        com.ss.android.downloadad.a.b.b bVar = new com.ss.android.downloadad.a.b.b(eVar.b, eVar.c, eVar.d);
        bVar.e(2);
        bVar.f(System.currentTimeMillis());
        bVar.h(4);
        bVar.i(2);
        com.ss.android.downloadlib.addownload.b.f.a().a(bVar);
    }

    public static void a(g gVar, e eVar) {
        String a = k.a(gVar.c(), "open_market");
        JSONObject jSONObject = new JSONObject();
        k.a(jSONObject, "ttdownloader_type", "backup");
        int a2 = gVar.a();
        if (a2 == 5) {
            a(a, jSONObject, eVar);
        } else if (a2 == 6) {
            k.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
            com.ss.android.downloadlib.e.a.a().a("market_open_failed", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
        }
    }

    public static boolean a(long j) {
        return com.ss.android.downloadlib.addownload.b.f.a().d(j) == null;
    }
}
