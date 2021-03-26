package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.g;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.HashMap;
import java.util.Map;

/* compiled from: WebHelper */
public class z {
    private static boolean a;

    public static void a(boolean z) {
        a = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x016d  */
    public static boolean a(final Context context, final l lVar, final int i, TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, final String str, a aVar, final boolean z, final Map<String, Object> map, boolean z2, boolean z3) {
        boolean z4;
        String str2;
        Map map2;
        Map map3;
        boolean z5;
        String str3;
        if (context == null || lVar == null || i == -1) {
            return false;
        }
        g ai = lVar.ai();
        if (a(str) && !z3 && !z && ai == null && TTMiddlePageActivity.a(context, lVar)) {
            return false;
        }
        if (ai != null) {
            u.b("deepLink", "WebHelper 含有deeplink链接尝试deeplink调起 deepLink != null ");
            String a2 = ai.a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(ai.a());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (!aj.c(context)) {
                    intent.addFlags(268435456);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        d.i(context, lVar, str, "open_url_app", null);
                        z5 = lVar.aw() ? aj.a(lVar, str) : false;
                        try {
                            context.startActivity(intent);
                            str3 = "deeplink_fail_realtime";
                            z4 = true;
                        } catch (Throwable unused) {
                            str3 = "deeplink_fail_realtime";
                            z4 = true;
                            d.b(p.a(), lVar, str, str3);
                            if (z5) {
                            }
                            if (ai.c() == 2) {
                            }
                            map2 = null;
                            if (ai.c() != z4) {
                            }
                            d.i(context, lVar, str, "open_fallback_url", map2);
                            str2 = a2;
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            if (lVar.T() == 2) {
                            }
                            return z4;
                        }
                    } catch (Throwable unused2) {
                        str3 = "deeplink_fail_realtime";
                        z4 = true;
                        z5 = false;
                        d.b(p.a(), lVar, str, str3);
                        if (z5) {
                        }
                        if (ai.c() == 2) {
                        }
                        map2 = null;
                        if (ai.c() != z4) {
                        }
                        d.i(context, lVar, str, "open_fallback_url", map2);
                        str2 = a2;
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (lVar.T() == 2) {
                        }
                        return z4;
                    }
                    try {
                        a(context, lVar, intent, currentTimeMillis, str);
                        d.b(context, lVar, str, "deeplink_success_realtime");
                        k.a().a(lVar, str, false);
                        return true;
                    } catch (Throwable unused3) {
                        d.b(p.a(), lVar, str, str3);
                        if (z5) {
                            return false;
                        }
                        if (ai.c() == 2) {
                        }
                        map2 = null;
                        if (ai.c() != z4) {
                        }
                        d.i(context, lVar, str, "open_fallback_url", map2);
                        str2 = a2;
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (lVar.T() == 2) {
                        }
                        return z4;
                    }
                } else if (aj.a(context, intent)) {
                    if (lVar.aw()) {
                        aj.a(lVar, str);
                    }
                    intent.addFlags(268435456);
                    a(context, lVar, intent, System.currentTimeMillis(), str);
                    b.a(context, intent, new b.a() {
                        /* class com.bytedance.sdk.openadsdk.core.z.AnonymousClass1 */

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                            d.b(p.a(), lVar, str, "deeplink_success_realtime");
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            l lVar = lVar;
                            if (lVar != null && !lVar.aw()) {
                                z.a(context, lVar.W(), lVar, i, str, z, map);
                                u.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                            }
                            d.b(p.a(), lVar, str, "deeplink_fail_realtime");
                        }
                    });
                    d.i(context, lVar, str, "open_url_app", null);
                    k.a().a(lVar, str, false);
                    return true;
                } else {
                    d.b(p.a(), lVar, str, "deeplink_fail_realtime");
                    z4 = true;
                }
                if (ai.c() == 2 || l.c(lVar)) {
                    map2 = null;
                    if (ai.c() != z4) {
                        a2 = ai.b();
                    } else {
                        a2 = lVar.W();
                    }
                } else if (aVar != null) {
                    boolean j = aVar.j();
                    boolean z6 = (j || !aVar.h() || !aVar.a(z)) ? j : true;
                    if (!z6 && aVar.b(z)) {
                        z6 = true;
                    }
                    if (z6 || !aVar.i()) {
                        map3 = null;
                    } else {
                        map3 = null;
                        z6 = true;
                    }
                    d.i(context, lVar, str, "open_fallback_url", map3);
                    return z6;
                } else {
                    map2 = null;
                }
                d.i(context, lVar, str, "open_fallback_url", map2);
            } else {
                z4 = true;
            }
            str2 = a2;
        } else {
            z4 = true;
            str2 = lVar.W();
        }
        if (!TextUtils.isEmpty(str2) && !lVar.C()) {
            return false;
        }
        if (lVar.T() == 2) {
            b.a(context, a(context, str2, lVar, i, tTNativeAd, tTNativeExpressAd, str, z, map, z2, false), null);
            a = false;
        } else if (!x.a(str2)) {
            return false;
        } else {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            try {
                intent2.setData(Uri.parse(str2));
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                b.a(context, intent2, null);
            } catch (Exception unused4) {
                return false;
            }
        }
        return z4;
    }

    public static boolean a(Context context, String str, l lVar, int i, String str2, boolean z, Map<String, Object> map) {
        try {
            return b.a(context, a(context, str, lVar, i, (TTNativeAd) null, (TTNativeExpressAd) null, str2, z, map, false, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("embeded_ad") || str.equals("embeded_ad_landingpage")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = com.bytedance.sdk.openadsdk.core.i.d().c();
     */
    public static void a(final Context context, final l lVar, final Intent intent, final long j, final String str) {
        final com.bytedance.sdk.openadsdk.utils.a c;
        if (lVar != null && intent != null && context != null && lVar.ax() && c != null) {
            c.a(new a.AbstractC0066a() {
                /* class com.bytedance.sdk.openadsdk.core.z.AnonymousClass2 */

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void d() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void e() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void f() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void a() {
                    long currentTimeMillis = System.currentTimeMillis();
                    u.b("WebHelper", "间隔时间 onActivityResumed intervalTime " + (currentTimeMillis - j));
                    if (currentTimeMillis - j <= 3000) {
                        z.b(context, lVar, intent, str);
                    }
                    com.bytedance.sdk.openadsdk.utils.a aVar = c;
                    if (aVar != null) {
                        aVar.b();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void b(final Context context, final l lVar, final Intent intent, final String str) {
        String str2;
        if (lVar != null && context != null && intent != null) {
            String c = lVar.ah() != null ? lVar.ah().c() : "";
            if (TextUtils.isEmpty(c)) {
                str2 = "是否立即打开应用";
            } else {
                str2 = "是否立即打开" + c;
            }
            com.bytedance.sdk.openadsdk.utils.g.a(lVar.ag(), c, str2, "立即打开", "退出", new g.a() {
                /* class com.bytedance.sdk.openadsdk.core.z.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    d.i(context, lVar, str, "open_url_app", null);
                    b.a(context, intent, new b.a() {
                        /* class com.bytedance.sdk.openadsdk.core.z.AnonymousClass3.AnonymousClass1 */

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                            k.a().a(lVar, str, false);
                            d.b(p.a(), lVar, str, "deeplink_success_realtime");
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            d.b(p.a(), lVar, str, "deeplink_fail_realtime");
                        }
                    });
                }
            });
        }
    }

    private static boolean a(TTNativeAd tTNativeAd) {
        if (tTNativeAd == null || !(tTNativeAd instanceof a.AbstractC0059a)) {
            return false;
        }
        try {
            return ((a.AbstractC0059a) tTNativeAd).g();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent a(Context context, String str, l lVar, int i, TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str2, boolean z, Map<String, Object> map, boolean z2, boolean z3) {
        Intent intent;
        int i2;
        if (!lVar.C() || TextUtils.isEmpty(n.a(lVar)) || (tTNativeAd == null && tTNativeExpressAd == null)) {
            intent = tTNativeAd instanceof TTDrawFeedAd ? new Intent(context, TTWebPageActivity.class) : (!l.c(lVar) || a || a(tTNativeAd) || !aj.c(lVar)) ? new Intent(context, TTWebPageActivity.class) : new Intent(context, TTVideoWebPageActivity.class);
        } else {
            intent = new Intent(context, TTPlayableWebPageActivity.class);
            intent.putExtra("ad_pending_download", a(lVar, z));
            String a2 = n.a(lVar);
            if (!TextUtils.isEmpty(a2) && a2 != null) {
                if (a2.contains("?")) {
                    str = a2 + "&orientation=portrait";
                } else {
                    str = a2 + "?orientation=portrait";
                }
            }
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", lVar.Y());
        intent.putExtra("web_title", lVar.ad());
        intent.putExtra("sdk_version", 3412);
        intent.putExtra("adid", lVar.ag());
        intent.putExtra("log_extra", lVar.aj());
        com.bytedance.sdk.openadsdk.multipro.b.a aVar = null;
        intent.putExtra("icon_url", lVar.U() == null ? null : lVar.U().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.bytedance.sdk.openadsdk.utils.k.e(lVar.aF().toString());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra("multi_process_materialmeta", lVar.aF().toString());
        } else {
            u.a().g();
            u.a().a(lVar);
        }
        if (l.c(lVar)) {
            if (tTNativeAd != null) {
                if (tTNativeAd instanceof a.AbstractC0059a) {
                    aVar = ((a.AbstractC0059a) tTNativeAd).e();
                }
                if (aVar != null) {
                    intent.putExtra("multi_process_data", aVar.a().toString());
                }
            }
            if (!(tTNativeExpressAd == null || (aVar = tTNativeExpressAd.getVideoModel()) == null)) {
                intent.putExtra("multi_process_data", aVar.a().toString());
            }
            if (aVar != null) {
                intent.putExtra("video_is_auto_play", aVar.d);
                u.c("videoDataModel", "videoDataModel=" + aVar.a().toString());
            }
            if (TTVideoWebPageActivity.a(intent) && (aVar != null || z2)) {
                if (aVar != null) {
                    try {
                        i2 = (int) ((((float) aVar.g) / ((float) aVar.e)) * 100.0f);
                    } catch (Throwable unused) {
                    }
                } else {
                    com.bytedance.sdk.openadsdk.multipro.b.a aVar2 = new com.bytedance.sdk.openadsdk.multipro.b.a();
                    aVar2.g = 100;
                    aVar2.a = true;
                    aVar2.d = aj.j(lVar);
                    intent.putExtra("multi_process_data", aVar2.a().toString());
                    i2 = 100;
                }
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("play_percent", Integer.valueOf(i2));
                if (lVar.X() == 0) {
                    intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                } else if (lVar.X() > 0 && i2 > lVar.X() && aj.j(lVar)) {
                    intent.setComponent(new ComponentName(context, TTVideoScrollWebPageActivity.class));
                }
            }
        }
        return intent;
    }

    private static boolean a(l lVar, boolean z) {
        if (z && lVar != null && lVar.T() == 4 && lVar.C()) {
            return true;
        }
        return false;
    }
}
