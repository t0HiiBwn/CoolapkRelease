package com.xiaomi.push.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.push.aa;
import com.xiaomi.push.ag;
import com.xiaomi.push.al;
import com.xiaomi.push.bq;
import com.xiaomi.push.ca;
import com.xiaomi.push.dj;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.ef;
import com.xiaomi.push.ek;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.es;
import com.xiaomi.push.ey;
import com.xiaomi.push.fc;
import com.xiaomi.push.fd;
import com.xiaomi.push.fe;
import com.xiaomi.push.fg;
import com.xiaomi.push.fs;
import com.xiaomi.push.ga;
import com.xiaomi.push.gc;
import com.xiaomi.push.gd;
import com.xiaomi.push.gg;
import com.xiaomi.push.gi;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gw;
import com.xiaomi.push.hf;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ia;
import com.xiaomi.push.it;
import com.xiaomi.push.iw;
import com.xiaomi.push.j;
import com.xiaomi.push.jb;
import com.xiaomi.push.service.be;
import com.xiaomi.push.service.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMPushService extends Service implements ep {
    public static int c = 1;
    private static final int l = Process.myPid();
    protected Class a = XMJobService.class;
    Messenger b = null;
    private en d;
    private aa e;
    private String f;
    private e g;
    private p h;
    private int i = 0;
    private int j = 0;
    private long k = 0;
    private ek m;
    private em n;
    private bb o;
    private p p = null;
    private be q = null;
    private Collection<g> r = Collections.synchronizedCollection(new ArrayList());
    private ArrayList<l> s = new ArrayList<>();
    private er t = new an(this);
    private ContentObserver u;
    private ContentObserver v;

    class a extends i {
        q.b a = null;

        public a(q.b bVar) {
            super(9);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            String str;
            try {
                if (!XMPushService.this.f()) {
                    com.xiaomi.a.a.a.c.d("trying bind while the connection is not created, quit!");
                    return;
                }
                q.b b2 = q.a().b(this.a.h, this.a.b);
                if (b2 == null) {
                    str = "ignore bind because the channel " + this.a.h + " is removed ";
                } else if (b2.m == q.c.unbind) {
                    b2.a(q.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.n.a(b2);
                    gc.a(XMPushService.this, b2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + b2.m;
                }
                com.xiaomi.a.a.a.c.a(str);
            } catch (Exception e) {
                com.xiaomi.a.a.a.c.a(e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "bind the client. " + this.a.h;
        }
    }

    static class b extends i {
        private final q.b a;

        public b(q.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            this.a.a(q.c.unbind, 1, 21, (String) null, (String) null);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "bind time out. chid=" + this.a.h;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return TextUtils.equals(((b) obj).a.h, this.a.h);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.h.hashCode();
        }
    }

    class c extends i {
        private ef b = null;

        public c(ef efVar) {
            super(8);
            this.b = efVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.p.a(this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "receive a message.";
        }
    }

    public class d extends i {
        d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.b()) {
                XMPushService.this.t();
            } else {
                com.xiaomi.a.a.a.c.a("should not connect. quit the job.");
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "do reconnect..";
        }
    }

    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, XMPushService.c);
        }
    }

    public class f extends i {
        public int a;
        public Exception b;

        f(int i, Exception exc) {
            super(2);
            this.a = i;
            this.b = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(this.a, this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "disconnect the connection.";
        }
    }

    class g extends i {
        g() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.m();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "Init Job";
        }
    }

    class h extends i {
        private Intent b = null;

        public h(Intent intent) {
            super(15);
            this.b = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.c(this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "Handle intent action = " + this.b.getAction();
        }
    }

    public static abstract class i extends be.b {
        public i(int i) {
            super(i);
        }

        public abstract void a();

        public abstract String b();

        @Override // java.lang.Runnable
        public void run() {
            if (!(this.f == 4 || this.f == 8)) {
                com.xiaomi.a.a.a.c.a("JOB: " + b());
            }
            a();
        }
    }

    class j extends i {
        public j() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.q.b();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "ask the job queue to quit";
        }
    }

    class k extends i {
        private fe b = null;

        public k(fe feVar) {
            super(8);
            this.b = feVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.p.a(this.b);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "receive a message.";
        }
    }

    public interface l {
        void a();
    }

    class m extends i {
        boolean a;

        public m(boolean z) {
            super(4);
            this.a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (XMPushService.this.f()) {
                try {
                    if (!this.a) {
                        gc.a();
                    }
                    XMPushService.this.n.b(this.a);
                } catch (ey e) {
                    com.xiaomi.a.a.a.c.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "send ping..";
        }
    }

    class n extends i {
        q.b a = null;

        public n(q.b bVar) {
            super(4);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            try {
                this.a.a(q.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.n.a(this.a.h, this.a.b);
                this.a.a(q.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.n.a(this.a);
            } catch (ey e) {
                com.xiaomi.a.a.a.c.a(e);
                XMPushService.this.a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "rebind the client. " + this.a.h;
        }
    }

    class o extends i {
        o() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.b()) {
                XMPushService.this.t();
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "reset the connection.";
        }
    }

    class p extends BroadcastReceiver {
        p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    class q extends i {
        q.b a = null;
        int b;
        String c;
        String d;

        public q(q.b bVar, int i, String str, String str2) {
            super(9);
            this.a = bVar;
            this.b = i;
            this.c = str;
            this.d = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            if (!(this.a.m == q.c.unbind || XMPushService.this.n == null)) {
                try {
                    XMPushService.this.n.a(this.a.h, this.a.b);
                } catch (ey e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
            this.a.a(q.c.unbind, this.b, 0, this.d, this.c);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String b() {
            return "unbind the channel. " + this.a.h;
        }
    }

    static {
        bq.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
    }

    public static Notification a(Context context) {
        Intent intent = new Intent(context, XMPushService.class);
        if (Build.VERSION.SDK_INT >= 11) {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setSmallIcon(context.getApplicationInfo().icon);
            builder.setContentTitle("Push Service");
            builder.setContentText("Push Service");
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
            return builder.getNotification();
        }
        Notification notification = new Notification();
        try {
            notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, "Push Service", "Push Service", PendingIntent.getService(context, 0, intent, 0));
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
        return notification;
    }

    private fe a(fe feVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        q a2 = q.a();
        List<String> b2 = a2.b(str);
        if (b2.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            feVar.o(str);
            str = feVar.l();
            if (TextUtils.isEmpty(str)) {
                str = b2.get(0);
                feVar.l(str);
            }
            q.b b3 = a2.b(str, feVar.n());
            if (!f()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (b3 == null || b3.m != q.c.binded) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            } else if (TextUtils.equals(str2, b3.j)) {
                return feVar;
            } else {
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.a.a.a.c.a(sb.toString());
                return null;
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.a.a.a.c.a(sb.toString());
        return null;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra(u.z);
        String stringExtra2 = intent.getStringExtra(u.C);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        q a2 = q.a();
        ef efVar = null;
        if (bundleExtra != null) {
            fd fdVar = (fd) a(new fd(bundleExtra), stringExtra, stringExtra2);
            if (fdVar != null) {
                efVar = ef.a(fdVar, a2.b(fdVar.l(), fdVar.n()).i);
            } else {
                return;
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                long longExtra = intent.getLongExtra(u.p, 0);
                String stringExtra3 = intent.getStringExtra(u.q);
                String stringExtra4 = intent.getStringExtra("ext_chid");
                q.b b2 = a2.b(stringExtra4, Long.toString(longExtra));
                if (b2 != null) {
                    ef efVar2 = new ef();
                    try {
                        efVar2.a(Integer.parseInt(stringExtra4));
                    } catch (NumberFormatException unused) {
                    }
                    efVar2.a("SECMSG", (String) null);
                    efVar2.a(longExtra, "xiaomi.com", stringExtra3);
                    efVar2.a(intent.getStringExtra("ext_pkt_id"));
                    efVar2.a(byteArrayExtra, b2.i);
                    efVar = efVar2;
                }
            }
        }
        if (efVar != null) {
            c(new ac(this, efVar));
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        hi hiVar = new hi();
        try {
            ht.a(hiVar, byteArrayExtra);
            com.xiaomi.push.j.a(getApplicationContext()).a((j.a) new ab(hiVar, new WeakReference(this), booleanExtra), i2);
        } catch (ia unused) {
            com.xiaomi.a.a.a.c.d("aw_ping : send help app ping  error");
        }
    }

    private void a(String str, int i2) {
        Collection<q.b> c2 = q.a().c(str);
        if (c2 != null) {
            for (q.b bVar : c2) {
                if (bVar != null) {
                    a(new q(bVar, i2, null, null));
                }
            }
        }
        q.a().a(str);
    }

    private boolean a(String str, Intent intent) {
        q.b b2 = q.a().b(str, intent.getStringExtra(u.p));
        boolean z = false;
        if (b2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(u.C);
        String stringExtra2 = intent.getStringExtra(u.v);
        if (!TextUtils.isEmpty(b2.j) && !TextUtils.equals(stringExtra, b2.j)) {
            com.xiaomi.a.a.a.c.a("session changed. old session=" + b2.j + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(b2.i)) {
            return z;
        }
        com.xiaomi.a.a.a.c.a("security changed. chid = " + str + " sechash = " + ag.a(stringExtra2));
        return true;
    }

    private q.b b(String str, Intent intent) {
        q.b b2 = q.a().b(str, intent.getStringExtra(u.p));
        if (b2 == null) {
            b2 = new q.b(this);
        }
        b2.h = intent.getStringExtra(u.r);
        b2.b = intent.getStringExtra(u.p);
        b2.c = intent.getStringExtra(u.t);
        b2.a = intent.getStringExtra(u.z);
        b2.f = intent.getStringExtra(u.x);
        b2.g = intent.getStringExtra(u.y);
        b2.e = intent.getBooleanExtra(u.w, false);
        b2.i = intent.getStringExtra(u.v);
        b2.j = intent.getStringExtra(u.C);
        b2.d = intent.getStringExtra(u.u);
        b2.k = this.o;
        b2.a((Messenger) intent.getParcelableExtra(u.G));
        b2.l = getApplicationContext();
        q.a().a(b2);
        return b2;
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra(u.z);
        String stringExtra2 = intent.getStringExtra(u.C);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fe[] feVarArr = new fd[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            feVarArr[i2] = new fd((Bundle) parcelableArrayExtra[i2]);
            feVarArr[i2] = (fd) a(feVarArr[i2], stringExtra, stringExtra2);
            if (feVarArr[i2] == null) {
                return;
            }
        }
        q a2 = q.a();
        ef[] efVarArr = new ef[length];
        for (int i3 = 0; i3 < length; i3++) {
            fd fdVar = feVarArr[i3];
            efVarArr[i3] = ef.a(fdVar, a2.b(fdVar.l(), fdVar.n()).i);
        }
        c(new ba(this, efVarArr));
    }

    private void b(boolean z) {
        this.k = System.currentTimeMillis();
        if (f()) {
            if (this.n.n() || this.n.o() || aa.e(this)) {
                c(new m(z));
                return;
            }
            c(new f(17, null));
        }
        a(true);
    }

    /* access modifiers changed from: private */
    public void c(Intent intent) {
        String str;
        String str2;
        bb bbVar;
        boolean z;
        int i2;
        i nVar;
        String str3;
        String str4;
        String str5;
        i acVar;
        q a2 = q.a();
        boolean z2 = true;
        boolean z3 = false;
        int i3 = 0;
        if (u.d.equalsIgnoreCase(intent.getAction()) || u.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(u.r);
            if (TextUtils.isEmpty(intent.getStringExtra(u.v))) {
                str = "security is empty. ignore.";
            } else if (stringExtra != null) {
                boolean a3 = a(stringExtra, intent);
                q.b b2 = b(stringExtra, intent);
                if (!aa.c(this)) {
                    bbVar = this.o;
                    z = false;
                    i2 = 2;
                } else {
                    if (f()) {
                        if (b2.m == q.c.unbind) {
                            nVar = new a(b2);
                        } else if (a3) {
                            nVar = new n(b2);
                        } else if (b2.m == q.c.binding) {
                            str = String.format("the client is binding. %1$s %2$s.", b2.h, q.b.a(b2.b));
                        } else if (b2.m == q.c.binded) {
                            bbVar = this.o;
                            z = true;
                            i2 = 0;
                        } else {
                            return;
                        }
                    }
                    a(true);
                    return;
                }
                bbVar.a(this, b2, z, i2, null);
                return;
            } else {
                str2 = "channel id is empty, do nothing!";
                com.xiaomi.a.a.a.c.d(str2);
                return;
            }
            com.xiaomi.a.a.a.c.a(str);
            return;
        } else if (u.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(u.z);
            String stringExtra3 = intent.getStringExtra(u.r);
            String stringExtra4 = intent.getStringExtra(u.p);
            com.xiaomi.a.a.a.c.a("Service called close channel chid = " + stringExtra3 + " res = " + q.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str6 : a2.b(stringExtra2)) {
                    a(str6, 2);
                }
                return;
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
                return;
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
                return;
            }
        } else if (u.e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
            return;
        } else if (u.g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
            return;
        } else {
            if (u.f.equalsIgnoreCase(intent.getAction())) {
                fe a4 = a(new fc(intent.getBundleExtra("ext_packet")), intent.getStringExtra(u.z), intent.getStringExtra(u.C));
                if (a4 != null) {
                    acVar = new ac(this, ef.a(a4, a2.b(a4.l(), a4.n()).i));
                } else {
                    return;
                }
            } else if (u.h.equalsIgnoreCase(intent.getAction())) {
                fe a5 = a(new fg(intent.getBundleExtra("ext_packet")), intent.getStringExtra(u.z), intent.getStringExtra(u.C));
                if (a5 != null) {
                    acVar = new ac(this, ef.a(a5, a2.b(a5.l(), a5.n()).i));
                } else {
                    return;
                }
            } else if (u.k.equals(intent.getAction())) {
                String stringExtra5 = intent.getStringExtra(u.r);
                String stringExtra6 = intent.getStringExtra(u.p);
                if (stringExtra5 != null) {
                    com.xiaomi.a.a.a.c.a("request reset connection from chid = " + stringExtra5);
                    q.b b3 = q.a().b(stringExtra5, stringExtra6);
                    if (b3 != null && b3.i.equals(intent.getStringExtra(u.v)) && b3.m == q.c.binded) {
                        em h2 = h();
                        if (h2 == null || !h2.a(System.currentTimeMillis() - 15000)) {
                            nVar = new o();
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                q.b bVar = null;
                if (u.l.equals(intent.getAction())) {
                    String stringExtra7 = intent.getStringExtra(u.z);
                    List<String> b4 = a2.b(stringExtra7);
                    if (b4.isEmpty()) {
                        str5 = "open channel should be called first before update info, pkg=" + stringExtra7;
                    } else {
                        String stringExtra8 = intent.getStringExtra(u.r);
                        String stringExtra9 = intent.getStringExtra(u.p);
                        if (TextUtils.isEmpty(stringExtra8)) {
                            stringExtra8 = b4.get(0);
                        }
                        if (TextUtils.isEmpty(stringExtra9)) {
                            Collection<q.b> c2 = a2.c(stringExtra8);
                            if (c2 != null && !c2.isEmpty()) {
                                bVar = c2.iterator().next();
                            }
                        } else {
                            bVar = a2.b(stringExtra8, stringExtra9);
                        }
                        if (bVar != null) {
                            if (intent.hasExtra(u.x)) {
                                bVar.f = intent.getStringExtra(u.x);
                            }
                            if (intent.hasExtra(u.y)) {
                                bVar.g = intent.getStringExtra(u.y);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                            if (!v()) {
                                com.xiaomi.a.a.a.c.a("exit falldown mode, activate alarm.");
                                s();
                                if (f() || g()) {
                                    return;
                                }
                                a(true);
                                return;
                            }
                            return;
                        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && v() && dw.b()) {
                            str3 = "enter falldown mode, stop alarm.";
                        } else {
                            return;
                        }
                    } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                        if (!x.a(getApplicationContext()).a() || x.a(getApplicationContext()).b() != 0) {
                            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                            String stringExtra10 = intent.getStringExtra("mipush_app_package");
                            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                            int intExtra = intent.getIntExtra("mipush_env_type", 1);
                            bk.a(this).g(stringExtra10);
                            if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                a(byteArrayExtra, stringExtra10);
                                return;
                            }
                            nVar = new az(this, 14, intExtra, byteArrayExtra, stringExtra10);
                        } else {
                            str5 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                        }
                    } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                        String stringExtra11 = intent.getStringExtra("mipush_app_package");
                        byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                        boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                        if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                            bk.a(this).d(stringExtra11);
                        }
                        a(stringExtra11, byteArrayExtra2, booleanExtra2);
                        return;
                    } else if (y.a.equals(intent.getAction())) {
                        String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
                        if (stringExtra12 != null && !TextUtils.isEmpty(stringExtra12.trim())) {
                            try {
                                getPackageManager().getPackageInfo(stringExtra12, 0);
                                z2 = false;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                            if (!"com.xiaomi.channel".equals(stringExtra12) || q.a().c("1").isEmpty() || !z2) {
                                SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                String string = sharedPreferences.getString(stringExtra12, null);
                                if (!TextUtils.isEmpty(string) && z2) {
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.remove(stringExtra12);
                                    edit.commit();
                                    if (b.e(this, stringExtra12)) {
                                        b.d(this, stringExtra12);
                                    }
                                    b.b(this, stringExtra12);
                                    if (f() && string != null) {
                                        try {
                                            bu.a(this, bu.a(stringExtra12, string));
                                            com.xiaomi.a.a.a.c.a("uninstall " + stringExtra12 + " msg sent");
                                            return;
                                        } catch (ey e2) {
                                            com.xiaomi.a.a.a.c.d("Fail to send Message: " + e2.getMessage());
                                            a(10, e2);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                a("1", 0);
                                str5 = "close the miliao channel as the app is uninstalled.";
                            }
                        } else {
                            return;
                        }
                    } else if (y.b.equals(intent.getAction())) {
                        String stringExtra13 = intent.getStringExtra("data_cleared_pkg_name");
                        if (!(stringExtra13 == null || TextUtils.isEmpty(stringExtra13.trim()))) {
                            com.xiaomi.a.a.a.c.a("clear notifications of package " + stringExtra13);
                            b.b(this, stringExtra13);
                            return;
                        }
                        return;
                    } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                        String stringExtra14 = intent.getStringExtra(u.z);
                        int intExtra2 = intent.getIntExtra(u.A, -2);
                        if (TextUtils.isEmpty(stringExtra14)) {
                            return;
                        }
                        if (intExtra2 >= -1) {
                            b.a(this, stringExtra14, intExtra2);
                            return;
                        } else {
                            b.a(this, stringExtra14, intent.getStringExtra(u.E), intent.getStringExtra(u.F));
                            return;
                        }
                    } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                        String stringExtra15 = intent.getStringExtra(u.z);
                        String stringExtra16 = intent.getStringExtra(u.D);
                        if (intent.hasExtra(u.B)) {
                            int intExtra3 = intent.getIntExtra(u.B, 0);
                            str4 = ag.b(stringExtra15 + intExtra3);
                            i3 = intExtra3;
                            z2 = false;
                        } else {
                            str4 = ag.b(stringExtra15);
                        }
                        if (TextUtils.isEmpty(stringExtra15) || !TextUtils.equals(stringExtra16, str4)) {
                            str2 = "invalid notification for " + stringExtra15;
                            com.xiaomi.a.a.a.c.d(str2);
                            return;
                        } else if (z2) {
                            b.d(this, stringExtra15);
                            return;
                        } else {
                            b.b(this, stringExtra15, i3);
                            return;
                        }
                    } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                        String stringExtra17 = intent.getStringExtra("mipush_app_package");
                        if (!TextUtils.isEmpty(stringExtra17)) {
                            bk.a(this).e(stringExtra17);
                        }
                        if (!"com.xiaomi.xmsf".equals(getPackageName())) {
                            a(19, (Exception) null);
                            s();
                            stopSelf();
                            return;
                        }
                        return;
                    } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        String stringExtra18 = intent.getStringExtra("mipush_app_package");
                        byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                        String stringExtra19 = intent.getStringExtra("mipush_app_id");
                        String stringExtra20 = intent.getStringExtra("mipush_app_token");
                        if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                            bk.a(this).f(stringExtra18);
                        }
                        if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                            bk.a(this).h(stringExtra18);
                            bk.a(this).i(stringExtra18);
                        }
                        if (byteArrayExtra3 == null) {
                            bm.a(this, stringExtra18, byteArrayExtra3, 70000003, "null payload");
                            return;
                        }
                        bm.b(stringExtra18, byteArrayExtra3);
                        a(new bl(this, stringExtra18, stringExtra19, stringExtra20, byteArrayExtra3));
                        if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.g == null) {
                            this.g = new e();
                            registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                            return;
                        }
                        return;
                    } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                        String stringExtra21 = intent.getStringExtra("mipush_app_package");
                        byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                        gm gmVar = new gm();
                        try {
                            ht.a(gmVar, byteArrayExtra4);
                            gg.a(this).a(gmVar, stringExtra21);
                            return;
                        } catch (ia e3) {
                            com.xiaomi.a.a.a.c.a(e3);
                            return;
                        }
                    } else {
                        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.a.a.a.c.a("Service called on timer");
                            if (!v()) {
                                dw.a(false);
                                if (!o()) {
                                    return;
                                }
                            } else if (dw.b()) {
                                str3 = "enter falldown mode, stop alarm";
                            } else {
                                return;
                            }
                        } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.a.a.a.c.a("Service called on check alive.");
                            if (!o()) {
                                return;
                            }
                        } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                            com.xiaomi.a.a.a.c.a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                            dw.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                            return;
                        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            n();
                            return;
                        } else if ("action_cr_config".equals(intent.getAction())) {
                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400);
                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400);
                            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576);
                            com.xiaomi.b.a.a a6 = com.xiaomi.b.a.a.a().b(booleanExtra3).b(longExtra).c(booleanExtra4).c(longExtra2).a(al.a(getApplicationContext())).a(booleanExtra5).a(longExtra3).a(getApplicationContext());
                            if (!"com.xiaomi.xmsf".equals(getPackageName()) && longExtra > 0 && longExtra2 > 0 && longExtra3 > 0) {
                                du.a(getApplicationContext(), a6);
                                return;
                            }
                            return;
                        } else if ("action_help_ping".equals(intent.getAction())) {
                            boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                            int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                            if (intExtra4 >= 0 && intExtra4 < 30) {
                                com.xiaomi.a.a.a.c.c("aw_ping: frquency need > 30s.");
                                intExtra4 = 30;
                            }
                            if (intExtra4 >= 0) {
                                z3 = booleanExtra6;
                            }
                            com.xiaomi.a.a.a.c.a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                            if (z3 && intExtra4 > 0 && !"com.xiaomi.xmsf".equals(getPackageName())) {
                                a(intent, intExtra4);
                                return;
                            }
                            return;
                        } else if ("action_aw_app_logic".equals(intent.getAction())) {
                            d(intent);
                            return;
                        } else {
                            return;
                        }
                        b(false);
                        return;
                    }
                    com.xiaomi.a.a.a.c.a(str3);
                    dw.a();
                    return;
                }
                com.xiaomi.a.a.a.c.a(str5);
                return;
            }
            c(acVar);
            return;
        }
        c(nVar);
    }

    private void c(i iVar) {
        this.q.a(iVar);
    }

    private void c(boolean z) {
        try {
            if (!jb.c()) {
                return;
            }
            if (z) {
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (g gVar : (g[]) this.r.toArray(new g[0])) {
                    gVar.a();
                }
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    private void d(Intent intent) {
        int i2;
        try {
            dj.a(getApplicationContext()).a(new w());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra != null) {
                hi hiVar = new hi();
                ht.a(hiVar, byteArrayExtra);
                String e2 = hiVar.e();
                Map<String, String> j2 = hiVar.j();
                if (j2 != null) {
                    String str = j2.get("extra_help_aw_info");
                    String str2 = j2.get("extra_aw_app_online_cmd");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            i2 = Integer.parseInt(str2);
                        } catch (NumberFormatException unused) {
                            i2 = 0;
                        }
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(e2) && !TextUtils.isEmpty(str)) {
                            dj.a(getApplicationContext()).a(this, str, i2, stringExtra, e2);
                        }
                    }
                }
            }
        } catch (ia e3) {
            com.xiaomi.a.a.a.c.d("aw_logic: translate fail. " + e3.getMessage());
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0034: APUT  
      (r1v5 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x0030: INVOKE  (r4v2 int) = 
      (wrap: java.lang.Integer : 0x002c: INVOKE  (r4v1 java.lang.Integer) = 
      (wrap: java.lang.String : 0x002a: AGET  (r4v0 java.lang.String) = (r0v3 java.lang.String[]), (0 ??[int, short, byte, char]))
     type: STATIC call: java.lang.Integer.valueOf(java.lang.String):java.lang.Integer)
     type: VIRTUAL call: java.lang.Integer.intValue():int)
     */
    private int[] k() {
        String[] split;
        String a2 = l.a(getApplicationContext()).a(gn.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23 && iArr[0] != iArr[1]) {
                    return iArr;
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.a.a.a.c.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private String l() {
        String str;
        com.xiaomi.push.p.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str2 = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            x a2 = x.a(this);
            str = null;
            while (true) {
                if (!TextUtils.isEmpty(str) && a2.b() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str)) {
                    str = it.a("ro.miui.region");
                    if (TextUtils.isEmpty(str)) {
                        str = it.a("ro.product.locale.region");
                    }
                }
                try {
                    synchronized (obj) {
                        obj.wait(100);
                    }
                } catch (InterruptedException unused) {
                }
            }
        } else {
            str = it.f();
        }
        if (!TextUtils.isEmpty(str)) {
            a.a(getApplicationContext()).b(str);
            str2 = it.b(str).name();
        }
        com.xiaomi.a.a.a.c.a("wait region :" + str2 + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str2;
    }

    /* access modifiers changed from: private */
    public void m() {
        String str;
        a a2 = a.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.a.a.a.c.a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = l();
        }
        if (!TextUtils.isEmpty(a3)) {
            this.f = a3;
            a2.a(a3);
            if (iw.Global.name().equals(this.f)) {
                str = "app.chat.global.xiaomi.net";
            } else if (iw.Europe.name().equals(this.f)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (iw.Russia.name().equals(this.f)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (iw.India.name().equals(this.f)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            en.a(str);
        } else {
            this.f = iw.China.name();
        }
        if (iw.China.name().equals(this.f)) {
            en.a("cn.app.chat.xiaomi.net");
        }
        if (r()) {
            ax axVar = new ax(this, 11);
            a(axVar);
            bj.a(new ay(this, axVar));
        }
        try {
            if (jb.c()) {
                this.o.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    private void n() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            com.xiaomi.a.a.a.c.a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.a.a.a.c.a("network changed, no active network");
        }
        if (ga.b() != null) {
            ga.b().b();
        }
        fs.a(this);
        this.m.p();
        if (aa.c(this)) {
            if (f() && o()) {
                b(false);
            }
            if (!f() && !g()) {
                this.q.b(1);
                a(new d());
            }
            ca.a(this).a();
        } else {
            a(new f(2, null));
        }
        s();
    }

    private boolean o() {
        if (System.currentTimeMillis() - this.k < 30000) {
            return false;
        }
        return aa.d(this);
    }

    /* access modifiers changed from: private */
    public boolean p() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    /* access modifiers changed from: private */
    public boolean q() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private boolean r() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !bk.a(this).b(getPackageName());
    }

    /* access modifiers changed from: private */
    public void s() {
        if (!b()) {
            dw.a();
        } else if (!dw.b()) {
            dw.a(true);
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        String str;
        em emVar = this.n;
        if (emVar == null || !emVar.i()) {
            em emVar2 = this.n;
            if (emVar2 == null || !emVar2.j()) {
                this.d.b(aa.k(this));
                u();
                if (this.n == null) {
                    q.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.a.a.a.c.d(str);
    }

    private void u() {
        try {
            this.m.a(this.t, new aq(this));
            this.m.r();
            this.n = this.m;
        } catch (ey e2) {
            com.xiaomi.a.a.a.c.a("fail to create Slim connection", e2);
            this.m.b(3, e2);
        }
    }

    private boolean v() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && w() && !gw.p(this) && !gw.o(getApplicationContext());
    }

    private boolean w() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.i;
        int i3 = this.j;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private boolean x() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return l.a(this).a(gn.ForegroundServiceSwitch.a(), false);
    }

    private void y() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(l, new Notification());
        } else {
            bindService(new Intent(this, this.a), new ar(this), 1);
        }
    }

    private void z() {
        synchronized (this.s) {
            this.s.clear();
        }
    }

    void a() {
        if (System.currentTimeMillis() - this.k >= ((long) es.b()) && aa.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.q.b(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        em emVar = this.n;
        sb.append(emVar == null ? null : Integer.valueOf(emVar.hashCode()));
        com.xiaomi.a.a.a.c.a(sb.toString());
        em emVar2 = this.n;
        if (emVar2 != null) {
            emVar2.b(i2, exc);
            this.n = null;
        }
        a(7);
        a(4);
        q.a().a(this, i2);
    }

    public void a(ef efVar) {
        em emVar = this.n;
        if (emVar != null) {
            emVar.b(efVar);
            return;
        }
        throw new ey("try send msg while connection is null.");
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar) {
        ga.b().a(emVar);
        c(true);
        this.e.a();
        if (!dw.b() && !v()) {
            com.xiaomi.a.a.a.c.a("reconnection successful, reactivate alarm.");
            dw.a(true);
        }
        Iterator<q.b> it2 = q.a().b().iterator();
        while (it2.hasNext()) {
            a(new a(it2.next()));
        }
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar, int i2, Exception exc) {
        ga.b().a(emVar, i2, exc);
        if (!v()) {
            a(false);
        }
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar, Exception exc) {
        ga.b().a(emVar, exc);
        c(false);
        if (!v()) {
            a(false);
        }
    }

    public void a(i iVar) {
        a(iVar, 0);
    }

    public void a(i iVar, long j2) {
        try {
            this.q.a(iVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.a.a.a.c.a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(l lVar) {
        synchronized (this.s) {
            this.s.add(lVar);
        }
    }

    public void a(q.b bVar) {
        if (bVar != null) {
            long b2 = bVar.b();
            com.xiaomi.a.a.a.c.a("schedule rebind job in " + (b2 / 1000));
            a(new a(bVar), b2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        q.b b2 = q.a().b(str, str2);
        if (b2 != null) {
            a(new q(b2, i2, str4, str3));
        }
        q.a().a(str, str2);
    }

    void a(String str, byte[] bArr, boolean z) {
        Collection<q.b> c2 = q.a().c("5");
        if (c2.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (c2.iterator().next().m == q.c.binded) {
            a(new ao(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        bm.b(str, bArr);
    }

    public void a(boolean z) {
        this.e.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            bm.a(this, str, bArr, 70000003, "null payload");
            com.xiaomi.a.a.a.c.a("register request without payload");
            return;
        }
        hf hfVar = new hf();
        try {
            ht.a(hfVar, bArr);
            if (hfVar.a == gi.Registration) {
                hj hjVar = new hj();
                try {
                    ht.a(hjVar, hfVar.f());
                    bm.a(hfVar.j(), bArr);
                    a(new bl(this, hfVar.j(), hjVar.e(), hjVar.i(), bArr));
                    dv.a(getApplicationContext()).a(hfVar.j(), "E100003", hjVar.c(), 6002, null);
                } catch (ia e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                    bm.a(this, str, bArr, 70000003, " data action error.");
                }
            } else {
                bm.a(this, str, bArr, 70000003, " registration action required.");
                com.xiaomi.a.a.a.c.a("register request with invalid payload");
            }
        } catch (ia e3) {
            com.xiaomi.a.a.a.c.a(e3);
            bm.a(this, str, bArr, 70000003, " data container error.");
        }
    }

    public void a(ef[] efVarArr) {
        em emVar = this.n;
        if (emVar != null) {
            emVar.a(efVarArr);
            return;
        }
        throw new ey("try send msg while connection is null.");
    }

    @Override // com.xiaomi.push.ep
    public void b(em emVar) {
        com.xiaomi.a.a.a.c.c("begin to connect...");
        ga.b().b(emVar);
    }

    public void b(i iVar) {
        this.q.a(iVar.f, iVar);
    }

    public boolean b() {
        return aa.c(this) && q.a().c() > 0 && !c() && r() && !q() && !p();
    }

    public boolean b(int i2) {
        return this.q.a(i2);
    }

    public boolean c() {
        try {
            Class<?> a2 = jb.a(this, "miui.os.Build");
            return a2.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CT_CUSTOMIZATION_TEST").getBoolean(null);
        } catch (Throwable unused) {
            return false;
        }
    }

    public bb d() {
        return new bb();
    }

    public bb e() {
        return this.o;
    }

    public boolean f() {
        em emVar = this.n;
        return emVar != null && emVar.j();
    }

    public boolean g() {
        em emVar = this.n;
        return emVar != null && emVar.i();
    }

    public em h() {
        return this.n;
    }

    void i() {
        Iterator it2 = new ArrayList(this.s).iterator();
        while (it2.hasNext()) {
            ((l) it2.next()).a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.b.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        jb.a(this);
        bi a2 = bj.a(this);
        if (a2 != null) {
            com.xiaomi.push.c.a(a2.g);
        }
        this.b = new Messenger(new as(this));
        v.a(this);
        at atVar = new at(this, null, 5222, "xiaomi.com", null);
        this.d = atVar;
        atVar.a(true);
        this.m = new ek(this, this.d);
        this.o = d();
        dw.a(this);
        this.m.a(this);
        this.p = new p(this);
        this.e = new aa(this);
        new bc().a();
        ga.a().a(this);
        this.q = new be("Connection Controller Thread");
        q a3 = q.a();
        a3.e();
        a3.a(new au(this));
        if (x()) {
            y();
        }
        gg.a(this).a(new bg(this), "UPLOADER_PUSH_CHANNEL");
        a(new gd(this));
        a(new g());
        this.r.add(ai.a(this));
        if (r()) {
            this.g = new e();
            registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.u = new av(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.u);
                } catch (Throwable th) {
                    com.xiaomi.a.a.a.c.a("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.v = new aw(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.v);
                } catch (Throwable th2) {
                    com.xiaomi.a.a.a.c.d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] k2 = k();
            if (k2 != null) {
                this.h = new p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.h, intentFilter);
                this.i = k2[0];
                this.j = k2[1];
                com.xiaomi.a.a.a.c.a("falldown initialized: " + this.i + "," + this.j);
            }
        }
        com.xiaomi.a.a.a.c.a("XMPushService created pid = " + l);
    }

    @Override // android.app.Service
    public void onDestroy() {
        e eVar = this.g;
        if (eVar != null) {
            a(eVar);
            this.g = null;
        }
        p pVar = this.h;
        if (pVar != null) {
            a(pVar);
            this.h = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.u != null) {
            try {
                getContentResolver().unregisterContentObserver(this.u);
            } catch (Throwable th) {
                com.xiaomi.a.a.a.c.a("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.v != null) {
            try {
                getContentResolver().unregisterContentObserver(this.v);
            } catch (Throwable th2) {
                com.xiaomi.a.a.a.c.d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.r.clear();
        this.q.c();
        a(new ap(this, 2));
        a(new j());
        q.a().e();
        q.a().a(this, 15);
        q.a().d();
        this.m.b(this);
        ag.a().b();
        dw.a();
        z();
        super.onDestroy();
        com.xiaomi.a.a.a.c.a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        h hVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.a.a.a.c.d("onStart() with intent NULL");
        } else {
            com.xiaomi.a.a.a.c.c(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, from-bridge = %s", intent.getAction(), intent.getStringExtra(u.r), intent.getStringExtra(u.z), intent.getStringExtra("mipush_app_package"), intent.getStringExtra("ext_is_xmpushservice_bridge")));
        }
        if (!(intent == null || intent.getAction() == null)) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.q.d()) {
                    com.xiaomi.a.a.a.c.d("ERROR, the job controller is blocked.");
                    q.a().a(this, 14);
                    stopSelf();
                } else {
                    hVar = new h(intent);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                hVar = new h(intent);
            }
            a(hVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.a.a.a.c.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return c;
    }
}
