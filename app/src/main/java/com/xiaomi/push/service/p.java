package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cw;
import com.xiaomi.push.en;
import com.xiaomi.push.fb;
import com.xiaomi.push.ft;
import com.xiaomi.push.fw;
import com.xiaomi.push.fy;
import com.xiaomi.push.fz;
import com.xiaomi.push.g;
import com.xiaomi.push.gn;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.is;
import com.xiaomi.push.service.ab;
import com.xiaomi.push.service.as;
import com.xiaomi.push.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class p {
    public static Intent a(byte[] bArr, long j) {
        hy a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f703b);
        return intent;
    }

    public static hy a(Context context, hy hyVar) {
        hs hsVar = new hs();
        hsVar.b(hyVar.m457a());
        hp a = hyVar.m456a();
        if (a != null) {
            hsVar.a(a.m422a());
            hsVar.a(a.m420a());
            if (!TextUtils.isEmpty(a.m427b())) {
                hsVar.c(a.m427b());
            }
        }
        hsVar.a(im.a(context, hyVar));
        hy a2 = x.a(hyVar.b(), hyVar.m457a(), hsVar, hc.AckMessage);
        hp a3 = hyVar.m456a().m421a();
        a3.a("mat", Long.toString(System.currentTimeMillis()));
        a2.a(a3);
        return a2;
    }

    public static hy a(byte[] bArr) {
        hy hyVar = new hy();
        try {
            im.a(hyVar, bArr);
            return hyVar;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, hy hyVar) {
        xMPushService.a(new q(4, xMPushService, hyVar));
    }

    private static void a(XMPushService xMPushService, hy hyVar, ib ibVar) {
        xMPushService.a(new w(4, ibVar, hyVar, xMPushService));
    }

    private static void a(XMPushService xMPushService, hy hyVar, String str) {
        xMPushService.a(new u(4, xMPushService, hyVar, str));
    }

    private static void a(XMPushService xMPushService, hy hyVar, String str, String str2) {
        xMPushService.a(new v(4, xMPushService, hyVar, str, str2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:137:0x03f5 A[SYNTHETIC, Splitter:B:137:0x03f5] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0413  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0456  */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        boolean z;
        ib ibVar;
        String str2;
        int i;
        en a;
        String b;
        String a2;
        int i2;
        String str3;
        String str4;
        en a3;
        String b2;
        String b3;
        String a4;
        String str5;
        boolean z2;
        hy a5 = a(bArr);
        hp a6 = a5.m456a();
        in inVar = null;
        r2 = null;
        String str6 = null;
        if (bArr != null) {
            cw.a(a5.b(), xMPushService.getApplicationContext(), null, a5.a(), bArr.length);
        }
        if (c(a5) && a(xMPushService, str)) {
            if (ab.e(a5)) {
                en.a(xMPushService.getApplicationContext()).a(a5.b(), ab.b(a5), a6.m422a(), "5");
            }
            c(xMPushService, a5);
        } else if (a(a5) && !a(xMPushService, str) && !b(a5)) {
            if (ab.e(a5)) {
                en.a(xMPushService.getApplicationContext()).a(a5.b(), ab.b(a5), a6.m422a(), "6");
            }
            d(xMPushService, a5);
        } else if ((ab.m607a(a5) && g.m360b((Context) xMPushService, a5.f703b)) || a(xMPushService, intent)) {
            boolean z3 = false;
            if (hc.Registration == a5.a()) {
                String b4 = a5.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b4, a5.f699a);
                edit.commit();
                m.a(xMPushService).e(b4);
                m.a(xMPushService).f(b4);
                en.a(xMPushService.getApplicationContext()).a(b4, "E100003", a6.m422a(), 6003, null);
                if (!TextUtils.isEmpty(a6.m422a())) {
                    intent.putExtra("messageId", a6.m422a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (ab.c(a5)) {
                en.a(xMPushService.getApplicationContext()).a(a5.b(), ab.b(a5), a6.m422a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(a6.m422a())) {
                    intent.putExtra("messageId", a6.m422a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (ab.m611b(a5)) {
                en.a(xMPushService.getApplicationContext()).a(a5.b(), ab.b(a5), a6.m422a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(a6.m422a())) {
                    intent.putExtra("messageId", a6.m422a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (ab.m607a(a5)) {
                en.a(xMPushService.getApplicationContext()).a(a5.b(), ab.b(a5), a6.m422a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(a6.m422a())) {
                    intent.putExtra("messageId", a6.m422a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (a6 != null && !TextUtils.isEmpty(a6.m430c()) && !TextUtils.isEmpty(a6.d()) && a6.f613b != 1 && (ab.m608a(a6.m423a()) || !ab.m606a((Context) xMPushService, a5.f703b))) {
                if (a6 != null) {
                    if (a6.f611a != null) {
                        str6 = a6.f611a.get("jobkey");
                    }
                    if (TextUtils.isEmpty(str6)) {
                        str6 = a6.m422a();
                    }
                    z2 = ae.a(xMPushService, a5.f703b, str6);
                } else {
                    z2 = false;
                }
                if (z2) {
                    en a7 = en.a(xMPushService.getApplicationContext());
                    String b5 = a5.b();
                    String b6 = ab.b(a5);
                    String a8 = a6.m422a();
                    a7.c(b5, b6, a8, "1:" + str6);
                    b.m41a("drop a duplicate message, key=" + str6);
                } else {
                    ab.c a9 = ab.m604a((Context) xMPushService, a5, bArr);
                    if (a9.a > 0 && !TextUtils.isEmpty(a9.f935a)) {
                        gn.a(xMPushService, a9.f935a, a9.a, true, false, System.currentTimeMillis());
                    }
                    if (!ab.m607a(a5) && g.m358a(xMPushService.getApplicationContext(), str)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a5.f703b);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                b.m41a("broadcast message arrived.");
                                xMPushService.sendBroadcast(intent2, x.a(a5.f703b));
                            }
                        } catch (Exception unused) {
                            en.a(xMPushService.getApplicationContext()).b(a5.b(), ab.b(a5), a6.m422a(), "1");
                        }
                    }
                }
                b(xMPushService, a5);
            } else if ("com.xiaomi.xmsf".contains(a5.f703b) && !a5.m464b() && a6 != null && a6.m423a() != null && a6.m423a().containsKey("ab")) {
                b(xMPushService, a5);
                b.c("receive abtest message. ack it." + a6.m422a());
            } else if (a(xMPushService, str, a5, a6)) {
                if (a6 != null && !TextUtils.isEmpty(a6.m422a())) {
                    if (ab.m611b(a5)) {
                        a = en.a(xMPushService.getApplicationContext());
                        b = a5.b();
                        str4 = ab.b(a5);
                        a2 = a6.m422a();
                        i2 = 2002;
                        str3 = null;
                    } else {
                        if (ab.m607a(a5)) {
                            a3 = en.a(xMPushService.getApplicationContext());
                            b2 = a5.b();
                            b3 = ab.b(a5);
                            a4 = a6.m422a();
                            str5 = "7";
                        } else if (ab.c(a5)) {
                            a3 = en.a(xMPushService.getApplicationContext());
                            b2 = a5.b();
                            b3 = ab.b(a5);
                            a4 = a6.m422a();
                            str5 = "8";
                        } else if (ab.d(a5)) {
                            a = en.a(xMPushService.getApplicationContext());
                            b = a5.b();
                            a2 = a6.m422a();
                            i2 = 6004;
                            str3 = null;
                            str4 = "E100003";
                        }
                        a3.a(b2, b3, a4, str5);
                    }
                    a.a(b, str4, a2, i2, str3);
                }
                if (hc.Notification == a5.f696a) {
                    try {
                        inVar = bo.a(xMPushService, a5);
                        if (inVar == null) {
                            b.d("receiving an un-recognized notification message. " + a5.f696a);
                            z = false;
                            if (z && (inVar instanceof ib)) {
                                ibVar = (ib) inVar;
                                if (hm.CancelPushMessage.f576a.equals(ibVar.f722d) && ibVar.m481a() != null) {
                                    str2 = ibVar.m481a().get(aw.J);
                                    i = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            i = Integer.parseInt(str2);
                                        } catch (NumberFormatException e) {
                                            b.m41a("parse notifyId from STRING to INT failed: " + e);
                                        }
                                    }
                                    if (i < -1) {
                                        b.m41a("try to retract a message by notifyId=" + i);
                                        ab.a(xMPushService, a5.f703b, i);
                                    } else {
                                        b.m41a("try to retract a message by title&description.");
                                        ab.a(xMPushService, a5.f703b, ibVar.m481a().get(aw.H), ibVar.m481a().get(aw.I));
                                    }
                                    a(xMPushService, a5, ibVar);
                                    if (z3) {
                                        b.m41a("broadcast passthrough message.");
                                        xMPushService.sendBroadcast(intent, x.a(a5.f703b));
                                    }
                                }
                            }
                        } else {
                            z = true;
                            ibVar = (ib) inVar;
                            str2 = ibVar.m481a().get(aw.J);
                            i = -2;
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            if (i < -1) {
                            }
                            a(xMPushService, a5, ibVar);
                            if (z3) {
                            }
                        }
                    } catch (is e2) {
                        b.d("receive a message which action string is not valid. " + e2);
                    }
                }
                z3 = true;
                if (z3) {
                }
            } else {
                en.a(xMPushService.getApplicationContext()).a(a5.b(), ab.b(a5), a6.m422a(), "9");
            }
            if (a5.a() == hc.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                xMPushService.stopSelf();
            }
        } else if (!g.m360b((Context) xMPushService, a5.f703b)) {
            if (ab.e(a5)) {
                en.a(xMPushService.getApplicationContext()).b(a5.b(), ab.b(a5), a6.m422a(), "2");
            }
            a(xMPushService, a5);
        } else {
            b.m41a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (ab.e(a5)) {
                en.a(xMPushService.getApplicationContext()).b(a5.b(), ab.b(a5), a6.m422a(), "3");
            }
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> a;
        hy a2 = a(bArr);
        if (a2 != null) {
            if (TextUtils.isEmpty(a2.f703b)) {
                b.m41a("receive a mipush message without package name");
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Intent a3 = a(bArr, valueOf.longValue());
            String a4 = ab.a(a2);
            gn.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
            hp a5 = a2.m456a();
            if (!(a5 == null || a5.m422a() == null)) {
                b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a2.m457a(), a5.m422a(), a2.a()));
            }
            if (a5 != null) {
                a5.a("mrt", Long.toString(valueOf.longValue()));
            }
            String str = "";
            if (hc.SendMessage == a2.a() && m.a(xMPushService).m663a(a2.f703b) && !ab.m607a(a2)) {
                if (a5 != null) {
                    str = a5.m422a();
                    if (ab.e(a2)) {
                        en.a(xMPushService.getApplicationContext()).a(a2.b(), ab.b(a2), str, "1");
                    }
                }
                b.m41a("Drop a message for unregistered, msgid=" + str);
                a(xMPushService, a2, a2.f703b);
            } else if (hc.SendMessage == a2.a() && m.a(xMPushService).m665c(a2.f703b) && !ab.m607a(a2)) {
                if (a5 != null) {
                    str = a5.m422a();
                    if (ab.e(a2)) {
                        en.a(xMPushService.getApplicationContext()).a(a2.b(), ab.b(a2), str, "2");
                    }
                }
                b.m41a("Drop a message for push closed, msgid=" + str);
                a(xMPushService, a2, a2.f703b);
            } else if (hc.SendMessage == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f703b)) {
                b.m41a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f703b);
                a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f703b);
                if (a5 != null && ab.e(a2)) {
                    en.a(xMPushService.getApplicationContext()).a(a2.b(), ab.b(a2), a5.m422a(), "3");
                }
            } else if (a5 == null || (a = a5.m423a()) == null || !a.containsKey("hide") || !"true".equalsIgnoreCase(a.get("hide"))) {
                if (!(a5 == null || a5.m423a() == null || !a5.m423a().containsKey("__miid"))) {
                    String str2 = a5.m423a().get("__miid");
                    String a6 = t.a(xMPushService.getApplicationContext());
                    if (TextUtils.isEmpty(a6) || !TextUtils.equals(str2, a6)) {
                        if (ab.e(a2)) {
                            en.a(xMPushService.getApplicationContext()).a(a2.b(), ab.b(a2), a5.m422a(), "4");
                        }
                        b.m41a(str2 + " should be login, but got " + a6);
                        a(xMPushService, a2, "miid already logout or anther already login", str2 + " should be login, but got " + a6);
                        return;
                    }
                }
                a(xMPushService, a4, bArr, a3);
            } else {
                b(xMPushService, a2);
            }
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return !packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() || !packageManager.queryIntentServices(intent, 32).isEmpty();
        } catch (Exception e) {
            b.a(e);
            return false;
        }
    }

    private static boolean a(hy hyVar) {
        return "com.xiaomi.xmsf".equals(hyVar.f703b) && hyVar.m456a() != null && hyVar.m456a().m423a() != null && hyVar.m456a().m423a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, hy hyVar, hp hpVar) {
        boolean z = true;
        if (hpVar != null && hpVar.m423a() != null && hpVar.m423a().containsKey("__check_alive") && hpVar.m423a().containsKey("__awake")) {
            ib ibVar = new ib();
            ibVar.b(hyVar.m457a());
            ibVar.d(str);
            ibVar.c(hm.AwakeSystemApp.f576a);
            ibVar.a(hpVar.m422a());
            ibVar.f717a = new HashMap();
            boolean a = g.m358a(xMPushService.getApplicationContext(), str);
            ibVar.f717a.put("app_running", Boolean.toString(a));
            if (!a) {
                boolean parseBoolean = Boolean.parseBoolean(hpVar.m423a().get("__awake"));
                ibVar.f717a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                x.a(xMPushService, x.a(hyVar.b(), hyVar.m457a(), ibVar, hc.Notification));
            } catch (ft e) {
                b.a(e);
            }
        }
        return z;
    }

    private static void b(XMPushService xMPushService, hy hyVar) {
        xMPushService.a(new r(4, xMPushService, hyVar));
    }

    private static boolean b(hy hyVar) {
        Map<String, String> a = hyVar.m456a().m423a();
        return a != null && a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, hy hyVar) {
        xMPushService.a(new s(4, xMPushService, hyVar));
    }

    private static boolean c(hy hyVar) {
        if (hyVar.m456a() == null || hyVar.m456a().m423a() == null) {
            return false;
        }
        return "1".equals(hyVar.m456a().m423a().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, hy hyVar) {
        xMPushService.a(new t(4, xMPushService, hyVar));
    }

    public void a(Context context, as.b bVar, boolean z, int i, String str) {
        k a;
        if (!z && (a = l.a(context)) != null && "token-expired".equals(str)) {
            try {
                l.a(context, a.f, a.d, a.e);
            } catch (IOException | JSONException e) {
                b.a(e);
            }
        }
    }

    public void a(XMPushService xMPushService, fb fbVar, as.b bVar) {
        try {
            a(xMPushService, fbVar.m322a(bVar.h), (long) fbVar.c());
        } catch (IllegalArgumentException e) {
            b.a(e);
        }
    }

    public void a(XMPushService xMPushService, fz fzVar, as.b bVar) {
        if (fzVar instanceof fy) {
            fy fyVar = (fy) fzVar;
            fw a = fyVar.a("s");
            if (a != null) {
                try {
                    a(xMPushService, bb.a(bb.a(bVar.h, fyVar.j()), a.c()), (long) gn.a(fzVar.m352a()));
                } catch (IllegalArgumentException e) {
                    b.a(e);
                }
            }
        } else {
            b.m41a("not a mipush message");
        }
    }
}
