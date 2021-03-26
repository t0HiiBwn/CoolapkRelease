package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.bx;
import com.xiaomi.push.ef;
import com.xiaomi.push.em;
import com.xiaomi.push.ey;
import com.xiaomi.push.fe;
import com.xiaomi.push.gi;
import com.xiaomi.push.gy;
import com.xiaomi.push.hf;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.ia;
import com.xiaomi.push.service.q;
import java.nio.ByteBuffer;

final class bu {
    static ef a(XMPushService xMPushService, byte[] bArr) {
        hf hfVar = new hf();
        try {
            ht.a(hfVar, bArr);
            return a(bj.a(xMPushService), xMPushService, hfVar);
        } catch (ia e) {
            c.a(e);
            return null;
        }
    }

    static ef a(bi biVar, Context context, hf hfVar) {
        try {
            ef efVar = new ef();
            efVar.a(5);
            efVar.c(biVar.a);
            efVar.b(a(hfVar));
            efVar.a("SECMSG", "message");
            String str = biVar.a;
            hfVar.g.b = str.substring(0, str.indexOf("@"));
            hfVar.g.d = str.substring(str.indexOf("/") + 1);
            efVar.a(ht.a(hfVar), biVar.c);
            efVar.a((short) 1);
            c.a("try send mi push message. packagename:" + hfVar.f + " action:" + hfVar.a);
            return efVar;
        } catch (NullPointerException e) {
            c.a(e);
            return null;
        }
    }

    static hf a(String str, String str2) {
        hi hiVar = new hi();
        hiVar.b(str2);
        hiVar.c("package uninstalled");
        hiVar.a(fe.j());
        hiVar.a(false);
        return a(str, str2, hiVar, gi.Notification);
    }

    static <T extends hu<T, ?>> hf a(String str, String str2, T t, gi giVar) {
        byte[] a = ht.a(t);
        hf hfVar = new hf();
        gy gyVar = new gy();
        gyVar.a = 5;
        gyVar.b = "fakeid";
        hfVar.a(gyVar);
        hfVar.a(ByteBuffer.wrap(a));
        hfVar.a(giVar);
        hfVar.c(true);
        hfVar.b(str);
        hfVar.a(false);
        hfVar.a(str2);
        return hfVar;
    }

    private static String a(hf hfVar) {
        if (!(hfVar.h == null || hfVar.h.k == null)) {
            String str = hfVar.h.k.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hfVar.f;
    }

    static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    static void a(XMPushService xMPushService) {
        bi a = bj.a(xMPushService.getApplicationContext());
        if (a != null) {
            q.b a2 = bj.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a2);
            q.a().a(a2);
            ai.a(xMPushService).a(new bv("GAID", 172800, xMPushService, a));
            a(xMPushService, a, 172800);
        }
    }

    static void a(XMPushService xMPushService, hf hfVar) {
        bx.a(hfVar.j(), xMPushService.getApplicationContext(), hfVar, -1);
        em h = xMPushService.h();
        if (h == null) {
            throw new ey("try send msg while connection is null.");
        } else if (h.b()) {
            ef a = a(bj.a(xMPushService), xMPushService, hfVar);
            if (a != null) {
                h.b(a);
            }
        } else {
            throw new ey("Don't support XMPP connection.");
        }
    }

    private static void a(XMPushService xMPushService, bi biVar, int i) {
        ai.a(xMPushService).a(new bw("MSAID", (long) i, xMPushService, biVar));
    }

    static void a(XMPushService xMPushService, q.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new bx(xMPushService));
    }

    static void a(XMPushService xMPushService, String str, byte[] bArr) {
        bx.a(str, xMPushService.getApplicationContext(), bArr);
        em h = xMPushService.h();
        if (h == null) {
            throw new ey("try send msg while connection is null.");
        } else if (h.b()) {
            ef a = a(xMPushService, bArr);
            if (a != null) {
                h.b(a);
            } else {
                bm.a(xMPushService, str, bArr, 70000003, "not a valid message");
            }
        } else {
            throw new ey("Don't support XMPP connection.");
        }
    }
}
