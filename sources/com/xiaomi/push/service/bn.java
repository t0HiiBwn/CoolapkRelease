package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.bx;
import com.xiaomi.push.dv;
import com.xiaomi.push.ef;
import com.xiaomi.push.eu;
import com.xiaomi.push.ey;
import com.xiaomi.push.fb;
import com.xiaomi.push.fd;
import com.xiaomi.push.fe;
import com.xiaomi.push.fs;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gz;
import com.xiaomi.push.hf;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.jb;
import com.xiaomi.push.service.b;
import com.xiaomi.push.service.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class bn {
    public static Intent a(byte[] bArr, long j) {
        hf a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f);
        return intent;
    }

    public static hf a(Context context, hf hfVar) {
        gz gzVar = new gz();
        gzVar.b(hfVar.h());
        gv m = hfVar.m();
        if (m != null) {
            gzVar.a(m.b());
            gzVar.a(m.d());
            if (!TextUtils.isEmpty(m.f())) {
                gzVar.c(m.f());
            }
        }
        gzVar.a(ht.a(context, hfVar));
        hf a = bu.a(hfVar.j(), hfVar.h(), gzVar, gi.AckMessage);
        gv a2 = hfVar.m().a();
        a2.a("mat", Long.toString(System.currentTimeMillis()));
        a.a(a2);
        return a;
    }

    public static hf a(byte[] bArr) {
        hf hfVar = new hf();
        try {
            ht.a(hfVar, bArr);
            return hfVar;
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, hf hfVar) {
        xMPushService.a(new bo(4, xMPushService, hfVar));
    }

    private static void a(XMPushService xMPushService, hf hfVar, String str) {
        xMPushService.a(new bs(4, xMPushService, hfVar, str));
    }

    private static void a(XMPushService xMPushService, hf hfVar, String str, String str2) {
        xMPushService.a(new bt(4, xMPushService, hfVar, str, str2));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        dv a;
        String j;
        String b;
        int i;
        String str2;
        String str3;
        dv a2;
        String j2;
        String g;
        String b2;
        String str4;
        boolean z;
        hf a3 = a(bArr);
        gv m = a3.m();
        String str5 = null;
        if (bArr != null) {
            bx.a(a3.j(), xMPushService.getApplicationContext(), null, a3.a(), bArr.length);
        }
        if (c(a3) && a(xMPushService, str)) {
            if (b.f(a3)) {
                dv.a(xMPushService.getApplicationContext()).a(a3.j(), b.g(a3), m.b(), "5");
            }
            c(xMPushService, a3);
        } else if (a(a3) && !a(xMPushService, str) && !b(a3)) {
            if (b.f(a3)) {
                dv.a(xMPushService.getApplicationContext()).a(a3.j(), b.g(a3), m.b(), "6");
            }
            d(xMPushService, a3);
        } else if ((b.b(a3) && eu.e(xMPushService, a3.f)) || a(xMPushService, intent)) {
            if (gi.Registration == a3.a()) {
                String j3 = a3.j();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(j3, a3.e);
                edit.commit();
                dv.a(xMPushService.getApplicationContext()).a(j3, "E100003", m.b(), 6003, null);
                if (!TextUtils.isEmpty(m.b())) {
                    intent.putExtra("messageId", m.b());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (b.d(a3)) {
                dv.a(xMPushService.getApplicationContext()).a(a3.j(), b.g(a3), m.b(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m.b())) {
                    intent.putExtra("messageId", m.b());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (b.c(a3)) {
                dv.a(xMPushService.getApplicationContext()).a(a3.j(), b.g(a3), m.b(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m.b())) {
                    intent.putExtra("messageId", m.b());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (b.b(a3)) {
                dv.a(xMPushService.getApplicationContext()).a(a3.j(), b.g(a3), m.b(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m.b())) {
                    intent.putExtra("messageId", m.b());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m != null && !TextUtils.isEmpty(m.h()) && !TextUtils.isEmpty(m.j()) && m.h != 1 && (b.a(m.s()) || !b.a(xMPushService, a3.f))) {
                if (m != null) {
                    if (m.j != null) {
                        str5 = m.j.get("jobkey");
                    }
                    if (TextUtils.isEmpty(str5)) {
                        str5 = m.b();
                    }
                    z = d.a(xMPushService, a3.f, str5);
                } else {
                    z = false;
                }
                if (z) {
                    dv a4 = dv.a(xMPushService.getApplicationContext());
                    String j4 = a3.j();
                    String g2 = b.g(a3);
                    String b3 = m.b();
                    a4.c(j4, g2, b3, "1:" + str5);
                    c.a("drop a duplicate message, key=" + str5);
                } else {
                    b.c a5 = b.a(xMPushService, a3, bArr);
                    if (a5.b > 0 && !TextUtils.isEmpty(a5.a)) {
                        fs.a(xMPushService, a5.a, a5.b, true, false, System.currentTimeMillis());
                    }
                    if (!b.b(a3)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a3.f);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, bu.a(a3.f));
                            }
                        } catch (Exception unused) {
                            xMPushService.sendBroadcast(intent2, bu.a(a3.f));
                            dv.a(xMPushService.getApplicationContext()).b(a3.j(), b.g(a3), m.b(), "1");
                        }
                    }
                }
                b(xMPushService, a3);
            } else if ("com.xiaomi.xmsf".contains(a3.f) && !a3.c() && m != null && m.s() != null && m.s().containsKey("ab")) {
                b(xMPushService, a3);
                c.c("receive abtest message. ack it." + m.b());
            } else if (a(xMPushService, str, a3, m)) {
                if (m != null && !TextUtils.isEmpty(m.b())) {
                    if (b.c(a3)) {
                        a = dv.a(xMPushService.getApplicationContext());
                        j = a3.j();
                        str3 = b.g(a3);
                        b = m.b();
                        i = 2002;
                        str2 = null;
                    } else {
                        if (b.b(a3)) {
                            a2 = dv.a(xMPushService.getApplicationContext());
                            j2 = a3.j();
                            g = b.g(a3);
                            b2 = m.b();
                            str4 = "7";
                        } else if (b.d(a3)) {
                            a2 = dv.a(xMPushService.getApplicationContext());
                            j2 = a3.j();
                            g = b.g(a3);
                            b2 = m.b();
                            str4 = "8";
                        } else if (b.e(a3)) {
                            a = dv.a(xMPushService.getApplicationContext());
                            j = a3.j();
                            b = m.b();
                            i = 6004;
                            str2 = null;
                            str3 = "E100003";
                        }
                        a2.a(j2, g, b2, str4);
                    }
                    a.a(j, str3, b, i, str2);
                }
                xMPushService.sendBroadcast(intent, bu.a(a3.f));
            } else {
                dv.a(xMPushService.getApplicationContext()).a(a3.j(), b.g(a3), m.b(), "9");
            }
            if (a3.a() == gi.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                xMPushService.stopSelf();
            }
        } else if (!eu.e(xMPushService, a3.f)) {
            if (b.f(a3)) {
                dv.a(xMPushService.getApplicationContext()).b(a3.j(), b.g(a3), m.b(), "2");
            }
            a(xMPushService, a3);
        } else {
            c.a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (b.f(a3)) {
                dv.a(xMPushService.getApplicationContext()).b(a3.j(), b.g(a3), m.b(), "3");
            }
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> s;
        hf a = a(bArr);
        if (a != null) {
            if (TextUtils.isEmpty(a.f)) {
                c.a("receive a mipush message without package name");
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Intent a2 = a(bArr, valueOf.longValue());
            String a3 = b.a(a);
            fs.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
            gv m = a.m();
            if (m != null) {
                m.a("mrt", Long.toString(valueOf.longValue()));
            }
            String str = "";
            if (gi.SendMessage == a.a() && bk.a(xMPushService).a(a.f) && !b.b(a)) {
                if (m != null) {
                    str = m.b();
                    if (b.f(a)) {
                        dv.a(xMPushService.getApplicationContext()).a(a.j(), b.g(a), str, "1");
                    }
                }
                c.a("Drop a message for unregistered, msgid=" + str);
                a(xMPushService, a, a.f);
            } else if (gi.SendMessage == a.a() && bk.a(xMPushService).c(a.f) && !b.b(a)) {
                if (m != null) {
                    str = m.b();
                    if (b.f(a)) {
                        dv.a(xMPushService.getApplicationContext()).a(a.j(), b.g(a), str, "2");
                    }
                }
                c.a("Drop a message for push closed, msgid=" + str);
                a(xMPushService, a, a.f);
            } else if (gi.SendMessage != a.a() || TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") || TextUtils.equals(xMPushService.getPackageName(), a.f)) {
                if (!(m == null || m.b() == null)) {
                    c.a(String.format("receive a message, appid=%1$s, msgid= %2$s", a.h(), m.b()));
                }
                if (m == null || (s = m.s()) == null || !s.containsKey("hide") || !"true".equalsIgnoreCase(s.get("hide"))) {
                    if (!(m == null || m.s() == null || !m.s().containsKey("__miid"))) {
                        String str2 = m.s().get("__miid");
                        String c = jb.c(xMPushService.getApplicationContext());
                        if (TextUtils.isEmpty(c) || !TextUtils.equals(str2, c)) {
                            if (b.f(a)) {
                                dv.a(xMPushService.getApplicationContext()).a(a.j(), b.g(a), m.b(), "4");
                            }
                            c.a(str2 + " should be login, but got " + c);
                            a(xMPushService, a, "miid already logout or anther already login", str2 + " should be login, but got " + c);
                            return;
                        }
                    }
                    a(xMPushService, a3, bArr, a2);
                    return;
                }
                b(xMPushService, a);
            } else {
                c.a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f);
                a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f);
                if (m != null && b.f(a)) {
                    dv.a(xMPushService.getApplicationContext()).a(a.j(), b.g(a), m.b(), "3");
                }
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
            c.a(e);
            return false;
        }
    }

    private static boolean a(hf hfVar) {
        return "com.xiaomi.xmsf".equals(hfVar.f) && hfVar.m() != null && hfVar.m().s() != null && hfVar.m().s().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, hf hfVar, gv gvVar) {
        boolean z = true;
        if (gvVar != null && gvVar.s() != null && gvVar.s().containsKey("__check_alive") && gvVar.s().containsKey("__awake")) {
            hi hiVar = new hi();
            hiVar.b(hfVar.h());
            hiVar.d(str);
            hiVar.c(gs.AwakeSystemApp.S);
            hiVar.a(gvVar.b());
            hiVar.h = new HashMap();
            boolean d = eu.d(xMPushService.getApplicationContext(), str);
            hiVar.h.put("app_running", Boolean.toString(d));
            if (!d) {
                boolean parseBoolean = Boolean.parseBoolean(gvVar.s().get("__awake"));
                hiVar.h.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                bu.a(xMPushService, bu.a(hfVar.j(), hfVar.h(), hiVar, gi.Notification));
            } catch (ey e) {
                c.a(e);
            }
        }
        return z;
    }

    private static void b(XMPushService xMPushService, hf hfVar) {
        xMPushService.a(new bp(4, xMPushService, hfVar));
    }

    private static boolean b(hf hfVar) {
        Map<String, String> s = hfVar.m().s();
        return s != null && s.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, hf hfVar) {
        xMPushService.a(new bq(4, xMPushService, hfVar));
    }

    private static boolean c(hf hfVar) {
        if (hfVar.m() == null || hfVar.m().s() == null) {
            return false;
        }
        return "1".equals(hfVar.m().s().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, hf hfVar) {
        xMPushService.a(new br(4, xMPushService, hfVar));
    }

    public void a(Context context, q.b bVar, boolean z, int i, String str) {
        bi a;
        if (!z && (a = bj.a(context)) != null && "token-expired".equals(str)) {
            try {
                bj.a(context, a.f, a.d, a.e);
            } catch (IOException | JSONException e) {
                c.a(e);
            }
        }
    }

    public void a(XMPushService xMPushService, ef efVar, q.b bVar) {
        try {
            a(xMPushService, efVar.d(bVar.i), (long) efVar.l());
        } catch (IllegalArgumentException e) {
            c.a(e);
        }
    }

    public void a(XMPushService xMPushService, fe feVar, q.b bVar) {
        if (feVar instanceof fd) {
            fd fdVar = (fd) feVar;
            fb p = fdVar.p("s");
            if (p != null) {
                try {
                    a(xMPushService, z.a(z.a(bVar.i, fdVar.k()), p.c()), (long) fs.a(feVar.c()));
                } catch (IllegalArgumentException e) {
                    c.a(e);
                }
            }
        } else {
            c.a("not a mipush message");
        }
    }
}
