package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cw;
import com.xiaomi.push.fb;
import com.xiaomi.push.fi;
import com.xiaomi.push.ft;
import com.xiaomi.push.fz;
import com.xiaomi.push.hc;
import com.xiaomi.push.hr;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.is;
import com.xiaomi.push.service.as;
import java.nio.ByteBuffer;

final class x {
    static fb a(XMPushService xMPushService, byte[] bArr) {
        hy hyVar = new hy();
        try {
            im.a(hyVar, bArr);
            return a(l.a((Context) xMPushService), xMPushService, hyVar);
        } catch (is e) {
            b.a(e);
            return null;
        }
    }

    static fb a(k kVar, Context context, hy hyVar) {
        try {
            fb fbVar = new fb();
            fbVar.a(5);
            fbVar.c(kVar.f1024a);
            fbVar.b(a(hyVar));
            fbVar.a("SECMSG", "message");
            String str = kVar.f1024a;
            hyVar.f698a.f625a = str.substring(0, str.indexOf("@"));
            hyVar.f698a.f629c = str.substring(str.indexOf("/") + 1);
            fbVar.a(im.a(hyVar), kVar.c);
            fbVar.a((short) 1);
            b.m41a("try send mi push message. packagename:" + hyVar.f703b + " action:" + hyVar.f696a);
            return fbVar;
        } catch (NullPointerException e) {
            b.a(e);
            return null;
        }
    }

    static hy a(String str, String str2) {
        ib ibVar = new ib();
        ibVar.b(str2);
        ibVar.c("package uninstalled");
        ibVar.a(fz.i());
        ibVar.a(false);
        return a(str, str2, ibVar, hc.Notification);
    }

    static <T extends in<T, ?>> hy a(String str, String str2, T t, hc hcVar) {
        return a(str, str2, t, hcVar, true);
    }

    private static <T extends in<T, ?>> hy a(String str, String str2, T t, hc hcVar, boolean z) {
        byte[] a = im.a(t);
        hy hyVar = new hy();
        hr hrVar = new hr();
        hrVar.f624a = 5;
        hrVar.f625a = "fakeid";
        hyVar.a(hrVar);
        hyVar.a(ByteBuffer.wrap(a));
        hyVar.a(hcVar);
        hyVar.b(z);
        hyVar.b(str);
        hyVar.a(false);
        hyVar.a(str2);
        return hyVar;
    }

    private static String a(hy hyVar) {
        if (!(hyVar.f697a == null || hyVar.f697a.f615b == null)) {
            String str = hyVar.f697a.f615b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hyVar.f703b;
    }

    static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    static void a(XMPushService xMPushService) {
        k a = l.a(xMPushService.getApplicationContext());
        if (a != null) {
            as.b a2 = l.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a2);
            as.a().a(a2);
            bj.a(xMPushService).a(new y("GAID", 172800, xMPushService, a));
            a(xMPushService, a, 172800);
        }
    }

    static void a(XMPushService xMPushService, hy hyVar) {
        cw.a(hyVar.b(), xMPushService.getApplicationContext(), hyVar, -1);
        fi a = xMPushService.m581a();
        if (a == null) {
            throw new ft("try send msg while connection is null.");
        } else if (a.m332a()) {
            fb a2 = a(l.a((Context) xMPushService), xMPushService, hyVar);
            if (a2 != null) {
                a.b(a2);
            }
        } else {
            throw new ft("Don't support XMPP connection.");
        }
    }

    static void a(XMPushService xMPushService, as.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new aa(xMPushService));
    }

    private static void a(XMPushService xMPushService, k kVar, int i) {
        bj.a(xMPushService).a(new z("MSAID", (long) i, xMPushService, kVar));
    }

    static void a(XMPushService xMPushService, String str, byte[] bArr) {
        cw.a(str, xMPushService.getApplicationContext(), bArr);
        fi a = xMPushService.m581a();
        if (a == null) {
            throw new ft("try send msg while connection is null.");
        } else if (a.m332a()) {
            fb a2 = a(xMPushService, bArr);
            if (a2 != null) {
                a.b(a2);
            } else {
                o.a(xMPushService, str, bArr, 70000003, "not a valid message");
            }
        } else {
            throw new ft("Don't support XMPP connection.");
        }
    }

    static <T extends in<T, ?>> hy b(String str, String str2, T t, hc hcVar) {
        return a(str, str2, t, hcVar, false);
    }
}
