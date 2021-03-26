package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.a;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SplashUtils */
public class c {
    public static void a(l lVar, int i) {
        int c = x.c(p.a());
        int i2 = 4;
        if (c == 2) {
            i2 = 2;
        } else if (c == 3) {
            i2 = 3;
        } else if (c == 4) {
            i2 = 1;
        } else if (c != 5) {
            i2 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i));
        hashMap.put("network_status", Integer.valueOf(i2));
        d.b(p.a(), lVar, "splash_ad", "network_type", hashMap);
    }

    public static void a(AdSlot adSlot, boolean z, long j, long j2) {
        int i = z ? 2 : 1;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("available_type", Integer.valueOf(i));
            jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
            a.a().n(com.bytedance.sdk.openadsdk.g.a.c.b().a(4).c(adSlot.getCodeId()).b((int) j).b(jSONObject.toString()));
        } catch (Throwable unused) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.g.a.c cVar, String str) {
        a.a().f(cVar.b(-7).g(h.a(-7)).i(str));
    }

    public static void a(long j, boolean z, boolean z2, l lVar, long j2, m mVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str = z ? z2 ? "load_video_success" : "load_video_error" : z2 ? "download_video_image_success" : "download_video_image_fail";
        String message = (z2 || mVar == null || mVar.c == null) ? null : mVar.c.getMessage();
        if (z) {
            Map<String, Object> a = aj.a(z2, lVar, elapsedRealtime, j2, message);
            a.put("splash_show_type", 1);
            d.f(p.a(), lVar, "splash_ad", str, a);
            return;
        }
        Map<String, Object> b = aj.b(z2, lVar, elapsedRealtime, j2, message);
        b.put("splash_show_type", 2);
        d.e(p.a(), lVar, "splash_ad", str, b);
    }

    public static void a(final com.bytedance.sdk.openadsdk.core.d.a aVar) {
        if (b(aVar)) {
            final l lVar = aVar.c().get(0);
            int d = aj.d(lVar.aj());
            t R = lVar.R();
            if (R != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                String i = R.i();
                if (TextUtils.isEmpty(i)) {
                    a(elapsedRealtime, true, false, lVar, -1, null);
                    return;
                }
                a(lVar, 1);
                final String l2 = R.l();
                if (TextUtils.isEmpty(l2)) {
                    l2 = j.a(i);
                }
                final File a = a(p.a(), a.a(p.a()).a(String.valueOf(d), b.b()), l2);
                if (!p.h().e(String.valueOf(d)) || x.d(p.a())) {
                    com.bytedance.sdk.openadsdk.h.d.a(p.a()).a(i, new b.a() {
                        /* class com.bytedance.sdk.openadsdk.component.splash.c.AnonymousClass1 */

                        @Override // com.bytedance.sdk.adnet.b.c.a
                        public void a(long j, long j2) {
                        }

                        @Override // com.bytedance.sdk.adnet.b.b.a
                        public File a(String str) {
                            try {
                                File parentFile = a.getParentFile();
                                if (parentFile == null || !parentFile.exists()) {
                                    return null;
                                }
                                u.f("splashLoadAd", "SplashUtils preLoadVideo getFile  s " + str);
                                c.a(a);
                                return i.d().p().a(l2, parentFile);
                            } catch (IOException e2) {
                                u.f("SplashUtils", "datastoreGet throw IOException : " + e2.toString());
                                return null;
                            }
                        }

                        @Override // com.bytedance.sdk.adnet.b.b.a
                        public void a(String str, File file) {
                            if (file != null) {
                                u.f("splashLoadAd", "SplashUtils preLoadVideo putFile  s " + str + " file " + file.getPath());
                                c.a(file);
                                a.a(p.a()).a(file);
                            }
                        }

                        @Override // com.bytedance.sdk.adnet.b.b.a
                        public File b(String str) {
                            return a;
                        }

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void a(m<File> mVar) {
                            if (mVar == null || mVar.a == null) {
                                c.a(elapsedRealtime, true, false, lVar, mVar == null ? -3 : mVar.h, mVar);
                                return;
                            }
                            a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                            a.a(p.a()).a(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                            c.a(elapsedRealtime, true, true, lVar, 0, mVar);
                        }

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void b(m<File> mVar) {
                            c.a(elapsedRealtime, true, false, lVar, mVar == null ? -2 : mVar.h, mVar);
                        }
                    });
                } else if (l2 != null && a.exists()) {
                    u.b("preLoadVideo", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                    a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                }
            }
        }
    }

    public static void a(l lVar) {
        if (!(lVar == null || lVar.M() == null)) {
            if (lVar.aB() && lVar.Z() != null && !lVar.Z().isEmpty()) {
                for (k kVar : lVar.Z()) {
                    if (!TextUtils.isEmpty(kVar.a())) {
                        com.bytedance.sdk.openadsdk.h.d.a(p.a()).f().a(kVar.a(), (b.AbstractC0054b) com.bytedance.sdk.openadsdk.h.a.b.a(), kVar.b(), kVar.c(), true);
                    }
                }
            }
            k U = lVar.U();
            if (!(U == null || TextUtils.isEmpty(U.a()))) {
                com.bytedance.sdk.openadsdk.h.d.a(p.a()).f().a(U.a(), (b.AbstractC0054b) com.bytedance.sdk.openadsdk.h.a.b.a(), U.b(), U.c(), true);
            }
        }
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        return (pVar == null || pVar.a() == null) ? false : true;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        return (pVar.a() == null || !pVar.a().aB() || pVar.b() == null || pVar.b().length == 0) ? false : true;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        return (aVar == null || aVar.c() == null || aVar.c().isEmpty() || aVar.c().get(0) == null) ? false : true;
    }

    public static void a(Context context, AdSlot adSlot) {
        try {
            a.a(context).d(adSlot.getCodeId());
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        try {
            a.a(context).a();
        } catch (Throwable unused) {
        }
    }

    public static File a(Context context, String str, String str2) {
        if (p.h().B() == 1) {
            u.f("splashLoadAd", "视频存储使用内部存储");
            return com.bytedance.sdk.openadsdk.utils.l.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        u.f("splashLoadAd", "视频存储使用外存储");
        return com.bytedance.sdk.openadsdk.utils.l.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }

    public static int c(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        if (pVar == null) {
            return 0;
        }
        int c = c(pVar.c());
        return c <= 0 ? b(pVar.a()) : c;
    }

    public static int b(l lVar) {
        if (lVar != null) {
            return aj.d(lVar.aj());
        }
        return 0;
    }

    public static int c(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public static void a(File file) {
        if (file != null) {
            try {
                com.bytedance.sdk.openadsdk.utils.l.b(file);
            } catch (Throwable unused) {
            }
        }
    }
}
