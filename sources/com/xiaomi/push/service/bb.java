package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ef;
import com.xiaomi.push.fc;
import com.xiaomi.push.fd;
import com.xiaomi.push.fe;
import com.xiaomi.push.fg;
import com.xiaomi.push.it;
import com.xiaomi.push.service.q;
import java.util.Collection;
import java.util.Iterator;

public class bb {
    private bn a = new bn();

    public static String a(q.b bVar) {
        StringBuilder sb;
        String str;
        if (!"9".equals(bVar.h)) {
            sb = new StringBuilder();
            sb.append(bVar.a);
            str = ".permission.MIPUSH_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.a);
            str = ".permission.MIMC_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    private static void a(Context context, Intent intent, q.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    q.b a(ef efVar) {
        Collection<q.b> c = q.a().c(Integer.toString(efVar.c()));
        if (c.isEmpty()) {
            return null;
        }
        Iterator<q.b> it2 = c.iterator();
        if (c.size() == 1) {
            return it2.next();
        }
        String j = efVar.j();
        while (it2.hasNext()) {
            q.b next = it2.next();
            if (TextUtils.equals(j, next.b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    q.b a(fe feVar) {
        Collection<q.b> c = q.a().c(feVar.l());
        if (c.isEmpty()) {
            return null;
        }
        Iterator<q.b> it2 = c.iterator();
        if (c.size() == 1) {
            return it2.next();
        }
        String n = feVar.n();
        String m = feVar.m();
        while (it2.hasNext()) {
            q.b next = it2.next();
            if (TextUtils.equals(n, next.b) || TextUtils.equals(m, next.b)) {
                return next;
            }
            while (it2.hasNext()) {
            }
        }
        return null;
    }

    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (it.e()) {
            intent.addFlags(16777216);
        }
        context.sendBroadcast(intent);
    }

    public void a(Context context, q.b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.h)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.a);
            intent.putExtra(u.r, bVar.h);
            intent.putExtra("ext_reason", i);
            intent.putExtra(u.p, bVar.b);
            intent.putExtra(u.C, bVar.j);
            if (bVar.o == null || !"9".equals(bVar.h)) {
                a(context, intent, bVar);
                return;
            }
            try {
                bVar.o.send(Message.obtain(null, 17, intent));
            } catch (RemoteException unused) {
                bVar.o = null;
                c.a("peer may died: " + bVar.b.substring(bVar.b.lastIndexOf(64)));
            }
        }
    }

    public void a(Context context, q.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            c.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.h);
        intent.putExtra(u.p, bVar.b);
        intent.putExtra(u.C, bVar.j);
        a(context, intent, bVar);
    }

    public void a(Context context, q.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.h);
        intent.putExtra(u.p, bVar.b);
        intent.putExtra(u.C, bVar.j);
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, ef efVar) {
        q.b a2 = a(efVar);
        if (a2 == null) {
            c.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, efVar, a2);
        } else {
            String str2 = a2.a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", efVar.d(a2.i));
            intent.putExtra(u.C, a2.j);
            intent.putExtra(u.v, a2.i);
            if (a2.o != null) {
                try {
                    a2.o.send(Message.obtain(null, 17, intent));
                    return;
                } catch (RemoteException unused) {
                    a2.o = null;
                    c.a("peer may died: " + a2.b.substring(a2.b.lastIndexOf(64)));
                }
            }
            if (!"com.xiaomi.xmsf".equals(str2)) {
                a(xMPushService, intent, a2);
            }
        }
    }

    public void a(XMPushService xMPushService, String str, fe feVar) {
        String str2;
        String str3;
        q.b a2 = a(feVar);
        if (a2 == null) {
            str3 = "error while notify channel closed! channel " + str + " not registered";
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, feVar, a2);
            return;
        } else {
            String str4 = a2.a;
            if (feVar instanceof fd) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (feVar instanceof fc) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (feVar instanceof fg) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                str3 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", feVar.b());
            intent.putExtra(u.C, a2.j);
            intent.putExtra(u.v, a2.i);
            a(xMPushService, intent, a2);
            return;
        }
        c.d(str3);
    }
}
