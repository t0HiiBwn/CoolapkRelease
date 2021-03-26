package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fb;
import com.xiaomi.push.fx;
import com.xiaomi.push.fy;
import com.xiaomi.push.fz;
import com.xiaomi.push.gb;
import com.xiaomi.push.l;
import com.xiaomi.push.service.as;
import java.util.Collection;
import java.util.Iterator;

public class d {
    private p a = new p();

    public static String a(as.b bVar) {
        StringBuilder sb;
        String str;
        if (!"9".equals(bVar.g)) {
            sb = new StringBuilder();
            sb.append(bVar.f968a);
            str = ".permission.MIPUSH_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f968a);
            str = ".permission.MIMC_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    private static void a(Context context, Intent intent, as.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    as.b a(fb fbVar) {
        Collection<as.b> a2 = as.a().m625a(Integer.toString(fbVar.a()));
        if (a2.isEmpty()) {
            return null;
        }
        Iterator<as.b> it2 = a2.iterator();
        if (a2.size() == 1) {
            return it2.next();
        }
        String g = fbVar.g();
        while (it2.hasNext()) {
            as.b next = it2.next();
            if (TextUtils.equals(g, next.f971b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    as.b a(fz fzVar) {
        Collection<as.b> a2 = as.a().m625a(fzVar.k());
        if (a2.isEmpty()) {
            return null;
        }
        Iterator<as.b> it2 = a2.iterator();
        if (a2.size() == 1) {
            return it2.next();
        }
        String m = fzVar.m();
        String l2 = fzVar.l();
        while (it2.hasNext()) {
            as.b next = it2.next();
            if (TextUtils.equals(m, next.f971b) || TextUtils.equals(l2, next.f971b)) {
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
        if (l.c()) {
            intent.addFlags(16777216);
        }
        context.sendBroadcast(intent);
    }

    public void a(Context context, as.b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.g)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f968a);
            intent.putExtra(aw.r, bVar.g);
            intent.putExtra("ext_reason", i);
            intent.putExtra(aw.p, bVar.f971b);
            intent.putExtra(aw.C, bVar.i);
            if (bVar.f962a == null || !"9".equals(bVar.g)) {
                a(context, intent, bVar);
                return;
            }
            try {
                bVar.f962a.send(Message.obtain(null, 17, intent));
            } catch (RemoteException unused) {
                bVar.f962a = null;
                b.m41a("peer may died: " + bVar.f971b.substring(bVar.f971b.lastIndexOf(64)));
            }
        }
    }

    public void a(Context context, as.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f968a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(aw.p, bVar.f971b);
        intent.putExtra(aw.C, bVar.i);
        a(context, intent, bVar);
    }

    public void a(Context context, as.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f968a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(aw.p, bVar.f971b);
        intent.putExtra(aw.C, bVar.i);
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fb fbVar) {
        as.b a2 = a(fbVar);
        if (a2 == null) {
            b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, fbVar, a2);
        } else {
            String str2 = a2.f968a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", fbVar.m322a(a2.h));
            intent.putExtra(aw.C, a2.i);
            intent.putExtra(aw.v, a2.h);
            if (a2.f962a != null) {
                try {
                    a2.f962a.send(Message.obtain(null, 17, intent));
                    return;
                } catch (RemoteException unused) {
                    a2.f962a = null;
                    b.m41a("peer may died: " + a2.f971b.substring(a2.f971b.lastIndexOf(64)));
                }
            }
            if (!"com.xiaomi.xmsf".equals(str2)) {
                a(xMPushService, intent, a2);
            }
        }
    }

    public void a(XMPushService xMPushService, String str, fz fzVar) {
        String str2;
        String str3;
        as.b a2 = a(fzVar);
        if (a2 == null) {
            str3 = "error while notify channel closed! channel " + str + " not registered";
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, fzVar, a2);
            return;
        } else {
            String str4 = a2.f968a;
            if (fzVar instanceof fy) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (fzVar instanceof fx) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (fzVar instanceof gb) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                str3 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", fzVar.mo349a());
            intent.putExtra(aw.C, a2.i);
            intent.putExtra(aw.v, a2.h);
            a(xMPushService, intent, a2);
            return;
        }
        b.d(str3);
    }
}
