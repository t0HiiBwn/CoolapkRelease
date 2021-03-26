package com.xiaomi.push.service;

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
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.ab;
import com.xiaomi.push.ai;
import com.xiaomi.push.ao;
import com.xiaomi.push.bc;
import com.xiaomi.push.bh;
import com.xiaomi.push.bm;
import com.xiaomi.push.cq;
import com.xiaomi.push.cz;
import com.xiaomi.push.ec;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.es;
import com.xiaomi.push.fb;
import com.xiaomi.push.fg;
import com.xiaomi.push.fi;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.ft;
import com.xiaomi.push.fx;
import com.xiaomi.push.fy;
import com.xiaomi.push.fz;
import com.xiaomi.push.gb;
import com.xiaomi.push.gn;
import com.xiaomi.push.gu;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.ha;
import com.xiaomi.push.hc;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.im;
import com.xiaomi.push.is;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.g;
import com.xiaomi.push.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMPushService extends Service implements fl {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f898a = 0;

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f899a;

    /* renamed from: a  reason: collision with other field name */
    Messenger f900a = null;

    /* renamed from: a  reason: collision with other field name */
    private fg f901a;

    /* renamed from: a  reason: collision with other field name */
    private fi f902a;

    /* renamed from: a  reason: collision with other field name */
    private fj f903a;

    /* renamed from: a  reason: collision with other field name */
    private fn f904a = new bq(this);

    /* renamed from: a  reason: collision with other field name */
    private e f905a;

    /* renamed from: a  reason: collision with other field name */
    private p f906a;

    /* renamed from: a  reason: collision with other field name */
    private ar f907a = null;

    /* renamed from: a  reason: collision with other field name */
    private bc f908a;

    /* renamed from: a  reason: collision with other field name */
    private d f909a;

    /* renamed from: a  reason: collision with other field name */
    private g f910a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Class f911a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private String f912a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<l> f913a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private Collection<ah> f914a = Collections.synchronizedCollection(new ArrayList());
    private int b = 0;

    /* renamed from: b  reason: collision with other field name */
    private ContentObserver f915b;

    class a extends i {

        /* renamed from: a  reason: collision with other field name */
        as.b f916a = null;

        public a(as.b bVar) {
            super(9);
            this.f916a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "bind the client. " + this.f916a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo590a() {
            String str;
            try {
                if (!XMPushService.this.m588c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                as.b a2 = as.a().a(this.f916a.g, this.f916a.f971b);
                if (a2 == null) {
                    str = "ignore bind because the channel " + this.f916a.g + " is removed ";
                } else if (a2.f966a == as.c.unbind) {
                    a2.a(as.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f902a.a(a2);
                    gw.a(XMPushService.this, a2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a2.f966a;
                }
                com.xiaomi.channel.commonutils.logger.b.m41a(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }
    }

    static class b extends i {
        private final as.b a;

        public b(as.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "bind time out. chid=" + this.a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo591a() {
            this.a.a(as.c.unbind, 1, 21, (String) null, (String) null);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return TextUtils.equals(((b) obj).a.g, this.a.g);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.g.hashCode();
        }
    }

    class c extends i {
        private fb a = null;

        public c(fb fbVar) {
            super(8);
            this.a = fbVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo592a() {
            XMPushService.this.f907a.a(this.a);
        }
    }

    public class d extends i {
        d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo593a() {
            if (XMPushService.this.m584a()) {
                XMPushService.this.f();
            } else {
                com.xiaomi.channel.commonutils.logger.b.m41a("should not connect. quit the job.");
            }
        }
    }

    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class f extends i {

        /* renamed from: a  reason: collision with other field name */
        public Exception f918a;
        public int b;

        f(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f918a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo594a() {
            XMPushService.this.a(this.b, this.f918a);
        }
    }

    class g extends i {
        g() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo595a() {
            XMPushService.this.c();
        }
    }

    class h extends i {
        private Intent a = null;

        public h(Intent intent) {
            super(15);
            this.a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "Handle intent action = " + this.a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo596a() {
            XMPushService.this.c(this.a);
        }
    }

    public static abstract class i extends g.b {
        public i(int i) {
            super(i);
        }

        /* renamed from: a */
        public abstract String mo344a();

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            if (!(this.a == 4 || this.a == 8)) {
                com.xiaomi.channel.commonutils.logger.b.m42a(com.xiaomi.channel.commonutils.logger.a.a, mo344a());
            }
            a();
        }
    }

    class j extends i {
        public j() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo597a() {
            XMPushService.this.f910a.m650a();
        }
    }

    class k extends i {
        private fz a = null;

        public k(fz fzVar) {
            super(8);
            this.a = fzVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo598a() {
            XMPushService.this.f907a.a(this.a);
        }
    }

    public interface l {
        /* renamed from: a */
        void mo385a();
    }

    class m extends i {

        /* renamed from: a  reason: collision with other field name */
        boolean f921a;

        public m(boolean z) {
            super(4);
            this.f921a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo599a() {
            if (XMPushService.this.m588c()) {
                try {
                    if (!this.f921a) {
                        gw.a();
                    }
                    XMPushService.this.f902a.b(this.f921a);
                } catch (ft e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    class n extends i {

        /* renamed from: a  reason: collision with other field name */
        as.b f922a = null;

        public n(as.b bVar) {
            super(4);
            this.f922a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "rebind the client. " + this.f922a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo600a() {
            try {
                this.f922a.a(as.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f902a.a(this.f922a.g, this.f922a.f971b);
                this.f922a.a(as.c.binding, 1, 16, (String) null, (String) null);
                XMPushService.this.f902a.a(this.f922a);
            } catch (ft e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    class o extends i {
        o() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo601a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m584a()) {
                XMPushService.this.f();
            }
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

        /* renamed from: a  reason: collision with other field name */
        as.b f923a = null;

        /* renamed from: a  reason: collision with other field name */
        String f924a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f925b;

        public q(as.b bVar, int i, String str, String str2) {
            super(9);
            this.f923a = bVar;
            this.b = i;
            this.f924a = str;
            this.f925b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a */
        public String mo344a() {
            return "unbind the channel. " + this.f923a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        /* renamed from: a  reason: collision with other method in class */
        public void mo602a() {
            if (!(this.f923a.f966a == as.c.unbind || XMPushService.this.f902a == null)) {
                try {
                    XMPushService.this.f902a.a(this.f923a.g, this.f923a.f971b);
                } catch (ft e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f923a.a(as.c.unbind, this.b, 0, this.f925b, this.f924a);
        }
    }

    static {
        cq.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
    }

    private fz a(fz fzVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        as a2 = as.a();
        List<String> a3 = a2.m626a(str);
        if (a3.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            fzVar.o(str);
            str = fzVar.k();
            if (TextUtils.isEmpty(str)) {
                str = a3.get(0);
                fzVar.l(str);
            }
            as.b a4 = a2.a(str, fzVar.m());
            if (!m588c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a4 == null || a4.f966a != as.c.binded) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            } else if (TextUtils.equals(str2, a4.i)) {
                return fzVar;
            } else {
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.m41a(sb.toString());
                return null;
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.m41a(sb.toString());
        return null;
    }

    private as.b a(String str, Intent intent) {
        as.b a2 = as.a().a(str, intent.getStringExtra(aw.p));
        if (a2 == null) {
            a2 = new as.b(this);
        }
        a2.g = intent.getStringExtra(aw.r);
        a2.f971b = intent.getStringExtra(aw.p);
        a2.c = intent.getStringExtra(aw.t);
        a2.f968a = intent.getStringExtra(aw.z);
        a2.e = intent.getStringExtra(aw.x);
        a2.f = intent.getStringExtra(aw.y);
        a2.f970a = intent.getBooleanExtra(aw.w, false);
        a2.h = intent.getStringExtra(aw.v);
        a2.i = intent.getStringExtra(aw.C);
        a2.d = intent.getStringExtra(aw.u);
        a2.f967a = this.f909a;
        a2.a((Messenger) intent.getParcelableExtra(aw.G));
        a2.f960a = getApplicationContext();
        as.a().a(a2);
        return a2;
    }

    private String a() {
        String str;
        ao.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str2 = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            az a2 = az.a(this);
            str = null;
            while (true) {
                if (!TextUtils.isEmpty(str) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str)) {
                    str = com.xiaomi.push.l.m566a("ro.miui.region");
                    if (TextUtils.isEmpty(str)) {
                        str = com.xiaomi.push.l.m566a("ro.product.locale.region");
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
            str = com.xiaomi.push.l.b();
        }
        if (!TextUtils.isEmpty(str)) {
            a.a(getApplicationContext()).b(str);
            str2 = com.xiaomi.push.l.a(str).name();
        }
        com.xiaomi.channel.commonutils.logger.b.m41a("wait region :" + str2 + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str2;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra(aw.z);
        String stringExtra2 = intent.getStringExtra(aw.C);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        as a2 = as.a();
        fb fbVar = null;
        if (bundleExtra != null) {
            fy fyVar = (fy) a(new fy(bundleExtra), stringExtra, stringExtra2);
            if (fyVar != null) {
                fbVar = fb.a(fyVar, a2.a(fyVar.k(), fyVar.m()).h);
            } else {
                return;
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                long longExtra = intent.getLongExtra(aw.p, 0);
                String stringExtra3 = intent.getStringExtra(aw.q);
                String stringExtra4 = intent.getStringExtra("ext_chid");
                as.b a3 = a2.a(stringExtra4, Long.toString(longExtra));
                if (a3 != null) {
                    fb fbVar2 = new fb();
                    try {
                        fbVar2.a(Integer.parseInt(stringExtra4));
                    } catch (NumberFormatException unused) {
                    }
                    fbVar2.a("SECMSG", (String) null);
                    fbVar2.a(longExtra, "xiaomi.com", stringExtra3);
                    fbVar2.a(intent.getStringExtra("ext_pkt_id"));
                    fbVar2.a(byteArrayExtra, a3.h);
                    fbVar = fbVar2;
                }
            }
        }
        if (fbVar != null) {
            c(new bd(this, fbVar));
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ib ibVar = new ib();
        try {
            im.a(ibVar, byteArrayExtra);
            ai.a(getApplicationContext()).a((ai.a) new b(ibVar, new WeakReference(this), booleanExtra), i2);
        } catch (is unused) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(String str, int i2) {
        Collection<as.b> a2 = as.a().m625a(str);
        if (a2 != null) {
            for (as.b bVar : a2) {
                if (bVar != null) {
                    a(new q(bVar, i2, null, null));
                }
            }
        }
        as.a().m628a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m574a(String str, Intent intent) {
        as.b a2 = as.a().a(str, intent.getStringExtra(aw.p));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(aw.C);
        String stringExtra2 = intent.getStringExtra(aw.v);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m41a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m41a("security changed. chid = " + str + " sechash = " + bh.a(stringExtra2));
        return true;
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
    /* renamed from: a  reason: collision with other method in class */
    private int[] m575a() {
        String[] split;
        String a2 = an.a(getApplicationContext()).a(hh.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23 && iArr[0] != iArr[1]) {
                    return iArr;
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra(aw.z);
        String stringExtra2 = intent.getStringExtra(aw.C);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fz[] fzVarArr = new fy[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            fzVarArr[i2] = new fy((Bundle) parcelableArrayExtra[i2]);
            fzVarArr[i2] = (fy) a(fzVarArr[i2], stringExtra, stringExtra2);
            if (fzVarArr[i2] == null) {
                return;
            }
        }
        as a2 = as.a();
        fb[] fbVarArr = new fb[length];
        for (int i3 = 0; i3 < length; i3++) {
            fy fyVar = fzVarArr[i3];
            fbVarArr[i3] = fb.a(fyVar, a2.a(fyVar.k(), fyVar.m()).h);
        }
        c(new c(this, fbVarArr));
    }

    private void b(boolean z) {
        this.f898a = System.currentTimeMillis();
        if (m588c()) {
            if (bc.b(this)) {
                c(new m(z));
                return;
            }
            c(new f(17, null));
        }
        a(true);
    }

    /* access modifiers changed from: private */
    public void c() {
        String str;
        a a2 = a.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.channel.commonutils.logger.b.m41a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = a();
        }
        if (!TextUtils.isEmpty(a3)) {
            this.f912a = a3;
            a2.a(a3);
            if (com.xiaomi.push.o.Global.name().equals(this.f912a)) {
                str = "app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.Europe.name().equals(this.f912a)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.Russia.name().equals(this.f912a)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.India.name().equals(this.f912a)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            fj.a(str);
        } else {
            this.f912a = com.xiaomi.push.o.China.name();
        }
        if (com.xiaomi.push.o.China.name().equals(this.f912a)) {
            fj.a("cn.app.chat.xiaomi.net");
        }
        if (m579h()) {
            bz bzVar = new bz(this, 11);
            a(bzVar);
            l.a(new ca(this, bzVar));
        }
        try {
            if (t.m677a()) {
                this.f909a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* access modifiers changed from: private */
    public void c(Intent intent) {
        String str;
        String str2;
        d dVar;
        boolean z;
        int i2;
        i nVar;
        String str3;
        String str4;
        String str5;
        i bdVar;
        as a2 = as.a();
        boolean z2 = true;
        boolean z3 = false;
        int i3 = 0;
        if (aw.d.equalsIgnoreCase(intent.getAction()) || aw.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(aw.r);
            if (TextUtils.isEmpty(intent.getStringExtra(aw.v))) {
                str = "security is empty. ignore.";
            } else if (stringExtra != null) {
                boolean a3 = m574a(stringExtra, intent);
                as.b a4 = a(stringExtra, intent);
                if (!bc.b(this)) {
                    dVar = this.f909a;
                    z = false;
                    i2 = 2;
                } else {
                    if (m588c()) {
                        if (a4.f966a == as.c.unbind) {
                            nVar = new a(a4);
                        } else if (a3) {
                            nVar = new n(a4);
                        } else if (a4.f966a == as.c.binding) {
                            str = String.format("the client is binding. %1$s %2$s.", a4.g, as.b.a(a4.f971b));
                        } else if (a4.f966a == as.c.binded) {
                            dVar = this.f909a;
                            z = true;
                            i2 = 0;
                        } else {
                            return;
                        }
                    }
                    a(true);
                    return;
                }
                dVar.a(this, a4, z, i2, null);
                return;
            } else {
                str2 = "channel id is empty, do nothing!";
                com.xiaomi.channel.commonutils.logger.b.d(str2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m41a(str);
            return;
        } else if (aw.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(aw.z);
            String stringExtra3 = intent.getStringExtra(aw.r);
            String stringExtra4 = intent.getStringExtra(aw.p);
            com.xiaomi.channel.commonutils.logger.b.m41a("Service called close channel chid = " + stringExtra3 + " res = " + as.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str6 : a2.m626a(stringExtra2)) {
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
        } else if (aw.e.equalsIgnoreCase(intent.getAction())) {
            a(intent);
            return;
        } else if (aw.g.equalsIgnoreCase(intent.getAction())) {
            b(intent);
            return;
        } else {
            if (aw.f.equalsIgnoreCase(intent.getAction())) {
                fz a5 = a(new fx(intent.getBundleExtra("ext_packet")), intent.getStringExtra(aw.z), intent.getStringExtra(aw.C));
                if (a5 != null) {
                    bdVar = new bd(this, fb.a(a5, a2.a(a5.k(), a5.m()).h));
                } else {
                    return;
                }
            } else if (aw.h.equalsIgnoreCase(intent.getAction())) {
                fz a6 = a(new gb(intent.getBundleExtra("ext_packet")), intent.getStringExtra(aw.z), intent.getStringExtra(aw.C));
                if (a6 != null) {
                    bdVar = new bd(this, fb.a(a6, a2.a(a6.k(), a6.m()).h));
                } else {
                    return;
                }
            } else if (aw.k.equals(intent.getAction())) {
                String stringExtra5 = intent.getStringExtra(aw.r);
                String stringExtra6 = intent.getStringExtra(aw.p);
                if (stringExtra5 != null) {
                    com.xiaomi.channel.commonutils.logger.b.m41a("request reset connection from chid = " + stringExtra5);
                    as.b a7 = as.a().a(stringExtra5, stringExtra6);
                    if (a7 != null && a7.h.equals(intent.getStringExtra(aw.v)) && a7.f966a == as.c.binded) {
                        fi a8 = m581a();
                        if (a8 == null || !a8.a(System.currentTimeMillis() - 15000)) {
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
                as.b bVar = null;
                if (aw.f1512l.equals(intent.getAction())) {
                    String stringExtra7 = intent.getStringExtra(aw.z);
                    List<String> a9 = a2.m626a(stringExtra7);
                    if (a9.isEmpty()) {
                        str5 = "open channel should be called first before update info, pkg=" + stringExtra7;
                    } else {
                        String stringExtra8 = intent.getStringExtra(aw.r);
                        String stringExtra9 = intent.getStringExtra(aw.p);
                        if (TextUtils.isEmpty(stringExtra8)) {
                            stringExtra8 = a9.get(0);
                        }
                        if (TextUtils.isEmpty(stringExtra9)) {
                            Collection<as.b> a10 = a2.m625a(stringExtra8);
                            if (a10 != null && !a10.isEmpty()) {
                                bVar = a10.iterator().next();
                            }
                        } else {
                            bVar = a2.a(stringExtra8, stringExtra9);
                        }
                        if (bVar != null) {
                            if (intent.hasExtra(aw.x)) {
                                bVar.e = intent.getStringExtra(aw.x);
                            }
                            if (intent.hasExtra(aw.y)) {
                                bVar.f = intent.getStringExtra(aw.y);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                            if (!m580i()) {
                                com.xiaomi.channel.commonutils.logger.b.m41a("exit falldown mode, activate alarm.");
                                e();
                                if (m588c() || m589d()) {
                                    return;
                                }
                                a(true);
                                return;
                            }
                            return;
                        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m580i() && es.m309a()) {
                            str3 = "enter falldown mode, stop alarm.";
                        } else {
                            return;
                        }
                    } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                        if (!az.a(getApplicationContext()).m635a() || az.a(getApplicationContext()).a() != 0) {
                            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                            String stringExtra10 = intent.getStringExtra("mipush_app_package");
                            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                            int intExtra = intent.getIntExtra("mipush_env_type", 1);
                            m.a(this).d(stringExtra10);
                            if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                a(byteArrayExtra, stringExtra10);
                                return;
                            }
                            nVar = new cb(this, 14, intExtra, byteArrayExtra, stringExtra10);
                        } else {
                            str5 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                        }
                    } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                        String stringExtra11 = intent.getStringExtra("mipush_app_package");
                        byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                        boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                        if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                            m.a(this).a(stringExtra11);
                        }
                        a(stringExtra11, byteArrayExtra2, booleanExtra2);
                        return;
                    } else if (ba.a.equals(intent.getAction())) {
                        String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
                        if (stringExtra12 != null && !TextUtils.isEmpty(stringExtra12.trim())) {
                            try {
                                getPackageManager().getPackageInfo(stringExtra12, 0);
                                z2 = false;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                            if (!"com.xiaomi.channel".equals(stringExtra12) || as.a().m625a("1").isEmpty() || !z2) {
                                SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                String string = sharedPreferences.getString(stringExtra12, null);
                                if (!TextUtils.isEmpty(string) && z2) {
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.remove(stringExtra12);
                                    edit.commit();
                                    if (ab.m610b((Context) this, stringExtra12)) {
                                        ab.m609b((Context) this, stringExtra12);
                                    }
                                    ab.m605a((Context) this, stringExtra12);
                                    if (m588c() && string != null) {
                                        try {
                                            x.a(this, x.a(stringExtra12, string));
                                            com.xiaomi.channel.commonutils.logger.b.m41a("uninstall " + stringExtra12 + " msg sent");
                                            return;
                                        } catch (ft e2) {
                                            com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e2.getMessage());
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
                    } else if (ba.b.equals(intent.getAction())) {
                        String stringExtra13 = intent.getStringExtra("data_cleared_pkg_name");
                        if (!(stringExtra13 == null || TextUtils.isEmpty(stringExtra13.trim()))) {
                            com.xiaomi.channel.commonutils.logger.b.m41a("clear notifications of package " + stringExtra13);
                            ab.m605a((Context) this, stringExtra13);
                            return;
                        }
                        return;
                    } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                        String stringExtra14 = intent.getStringExtra(aw.z);
                        int intExtra2 = intent.getIntExtra(aw.A, -2);
                        if (TextUtils.isEmpty(stringExtra14)) {
                            return;
                        }
                        if (intExtra2 >= -1) {
                            ab.a(this, stringExtra14, intExtra2);
                            return;
                        } else {
                            ab.a(this, stringExtra14, intent.getStringExtra(aw.E), intent.getStringExtra(aw.F));
                            return;
                        }
                    } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                        String stringExtra15 = intent.getStringExtra(aw.z);
                        String stringExtra16 = intent.getStringExtra(aw.D);
                        if (intent.hasExtra(aw.B)) {
                            int intExtra3 = intent.getIntExtra(aw.B, 0);
                            str4 = bh.b(stringExtra15 + intExtra3);
                            i3 = intExtra3;
                            z2 = false;
                        } else {
                            str4 = bh.b(stringExtra15);
                        }
                        if (TextUtils.isEmpty(stringExtra15) || !TextUtils.equals(stringExtra16, str4)) {
                            str2 = "invalid notification for " + stringExtra15;
                            com.xiaomi.channel.commonutils.logger.b.d(str2);
                            return;
                        } else if (z2) {
                            ab.m609b((Context) this, stringExtra15);
                            return;
                        } else {
                            ab.b(this, stringExtra15, i3);
                            return;
                        }
                    } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                        String stringExtra17 = intent.getStringExtra("mipush_app_package");
                        if (!TextUtils.isEmpty(stringExtra17)) {
                            m.a(this).b(stringExtra17);
                        }
                        if (!"com.xiaomi.xmsf".equals(getPackageName())) {
                            a(19, (Exception) null);
                            e();
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
                            m.a(this).c(stringExtra18);
                        }
                        if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                            m.a(this).e(stringExtra18);
                            m.a(this).f(stringExtra18);
                        }
                        if (byteArrayExtra3 == null) {
                            o.a(this, stringExtra18, byteArrayExtra3, 70000003, "null payload");
                            return;
                        }
                        o.b(stringExtra18, byteArrayExtra3);
                        a(new n(this, stringExtra18, stringExtra19, stringExtra20, byteArrayExtra3));
                        if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f905a == null) {
                            this.f905a = new e();
                            registerReceiver(this.f905a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                            return;
                        }
                        return;
                    } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                        String stringExtra21 = intent.getStringExtra("mipush_app_package");
                        byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                        hg hgVar = new hg();
                        try {
                            im.a(hgVar, byteArrayExtra4);
                            ha.a(this).a(hgVar, stringExtra21);
                            return;
                        } catch (is e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                            return;
                        }
                    } else {
                        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m41a("Service called on timer");
                            if (!m580i()) {
                                es.a(false);
                                if (!m576e()) {
                                    return;
                                }
                            } else if (es.m309a()) {
                                str3 = "enter falldown mode, stop alarm";
                            } else {
                                return;
                            }
                        } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m41a("Service called on check alive.");
                            if (!m576e()) {
                                return;
                            }
                        } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m41a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                            es.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                            return;
                        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            d();
                            return;
                        } else if ("action_cr_config".equals(intent.getAction())) {
                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400);
                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400);
                            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576);
                            Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(bm.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
                            if (!"com.xiaomi.xmsf".equals(getPackageName()) && longExtra > 0 && longExtra2 > 0 && longExtra3 > 0) {
                                em.a(getApplicationContext(), build);
                                return;
                            }
                            return;
                        } else if ("action_help_ping".equals(intent.getAction())) {
                            boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                            int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                            if (intExtra4 >= 0 && intExtra4 < 30) {
                                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                                intExtra4 = 30;
                            }
                            if (intExtra4 >= 0) {
                                z3 = booleanExtra6;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m41a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
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
                    com.xiaomi.channel.commonutils.logger.b.m41a(str3);
                    es.a();
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m41a(str5);
                return;
            }
            c(bdVar);
            return;
        }
        c(nVar);
    }

    private void c(i iVar) {
        this.f910a.a(iVar);
    }

    private void c(boolean z) {
        try {
            if (!t.m677a()) {
                return;
            }
            if (z) {
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ah ahVar : (ah[]) this.f914a.toArray(new ah[0])) {
                    ahVar.a();
                }
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.m41a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m41a("network changed, no active network");
        }
        if (gu.a() != null) {
            gu.a().m377a();
        }
        gn.m373a((Context) this);
        this.f901a.d();
        if (bc.b(this)) {
            if (m588c() && m576e()) {
                b(false);
            }
            if (!m588c() && !m589d()) {
                this.f910a.a(1);
                a(new d());
            }
            cz.a(this).a();
        } else {
            a(new f(2, null));
        }
        e();
    }

    private void d(Intent intent) {
        int i2;
        try {
            ec.a(getApplicationContext()).a(new ay());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra != null) {
                ib ibVar = new ib();
                im.a(ibVar, byteArrayExtra);
                String b2 = ibVar.b();
                Map<String, String> a2 = ibVar.m481a();
                if (a2 != null) {
                    String str = a2.get("extra_help_aw_info");
                    String str2 = a2.get("extra_aw_app_online_cmd");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            i2 = Integer.parseInt(str2);
                        } catch (NumberFormatException unused) {
                            i2 = 0;
                        }
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(b2) && !TextUtils.isEmpty(str)) {
                            ec.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
                        }
                    }
                }
            }
        } catch (is e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    private void e() {
        if (!m584a()) {
            es.a();
        } else if (!es.m309a()) {
            es.a(true);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m576e() {
        if (System.currentTimeMillis() - this.f898a < 30000) {
            return false;
        }
        return bc.c(this);
    }

    /* access modifiers changed from: private */
    public void f() {
        String str;
        fi fiVar = this.f902a;
        if (fiVar == null || !fiVar.m335b()) {
            fi fiVar2 = this.f902a;
            if (fiVar2 == null || !fiVar2.m336c()) {
                this.f903a.b(bc.m129a((Context) this));
                g();
                if (this.f902a == null) {
                    as.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m577f() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    private void g() {
        try {
            this.f901a.a(this.f904a, new bt(this));
            this.f901a.e();
            this.f902a = this.f901a;
        } catch (ft e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f901a.b(3, e2);
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private boolean m578g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m579h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !m.a(this).m664b(getPackageName());
    }

    private void i() {
        synchronized (this.f913a) {
            this.f913a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m580i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m473b(this) && !com.xiaomi.push.i.m470a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.a;
        int i3 = this.b;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return an.a(this).a(hh.ForegroundServiceSwitch.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fi m581a() {
        return this.f902a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public d m582a() {
        return new d();
    }

    /* renamed from: a  reason: collision with other method in class */
    void m583a() {
        if (System.currentTimeMillis() - this.f898a >= ((long) fo.a()) && bc.c(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f910a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        fi fiVar = this.f902a;
        sb.append(fiVar == null ? null : Integer.valueOf(fiVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m41a(sb.toString());
        fi fiVar2 = this.f902a;
        if (fiVar2 != null) {
            fiVar2.b(i2, exc);
            this.f902a = null;
        }
        a(7);
        a(4);
        as.a().a(this, i2);
    }

    public void a(fb fbVar) {
        fi fiVar = this.f902a;
        if (fiVar != null) {
            fiVar.b(fbVar);
            return;
        }
        throw new ft("try send msg while connection is null.");
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar) {
        gu.a().a(fiVar);
        c(true);
        this.f908a.m637a();
        if (!es.m309a() && !m580i()) {
            com.xiaomi.channel.commonutils.logger.b.m41a("reconnection successful, reactivate alarm.");
            es.a(true);
        }
        Iterator<as.b> it2 = as.a().m624a().iterator();
        while (it2.hasNext()) {
            a(new a(it2.next()));
        }
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar, int i2, Exception exc) {
        gu.a().a(fiVar, i2, exc);
        if (!m580i()) {
            a(false);
        }
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar, Exception exc) {
        gu.a().a(fiVar, exc);
        c(false);
        if (!m580i()) {
            a(false);
        }
    }

    public void a(i iVar) {
        a(iVar, 0);
    }

    public void a(i iVar, long j2) {
        try {
            this.f910a.a(iVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m41a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(l lVar) {
        synchronized (this.f913a) {
            this.f913a.add(lVar);
        }
    }

    public void a(as.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m41a("schedule rebind job in " + (a2 / 1000));
            a(new a(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        as.b a2 = as.a().a(str, str2);
        if (a2 != null) {
            a(new q(a2, i2, str4, str3));
        }
        as.a().m629a(str, str2);
    }

    void a(String str, byte[] bArr, boolean z) {
        Collection<as.b> a2 = as.a().m625a("5");
        if (a2.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (a2.iterator().next().f966a == as.c.binded) {
            a(new br(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        o.b(str, bArr);
    }

    public void a(boolean z) {
        this.f908a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            o.a(this, str, bArr, 70000003, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m41a("register request without payload");
            return;
        }
        hy hyVar = new hy();
        try {
            im.a(hyVar, bArr);
            if (hyVar.f696a == hc.Registration) {
                ic icVar = new ic();
                try {
                    im.a(icVar, hyVar.m462a());
                    o.a(hyVar.b(), bArr);
                    a(new n(this, hyVar.b(), icVar.b(), icVar.c(), bArr));
                    en.a(getApplicationContext()).a(hyVar.b(), "E100003", icVar.a(), 6002, null);
                } catch (is e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    o.a(this, str, bArr, 70000003, " data action error.");
                }
            } else {
                o.a(this, str, bArr, 70000003, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m41a("register request with invalid payload");
            }
        } catch (is e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            o.a(this, str, bArr, 70000003, " data container error.");
        }
    }

    public void a(fb[] fbVarArr) {
        fi fiVar = this.f902a;
        if (fiVar != null) {
            fiVar.a(fbVarArr);
            return;
        }
        throw new ft("try send msg while connection is null.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m584a() {
        return bc.b(this) && as.a().m623a() > 0 && !m587b() && m579h() && !m578g() && !m577f();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m585a(int i2) {
        return this.f910a.m652a(i2);
    }

    public d b() {
        return this.f909a;
    }

    /* renamed from: b  reason: collision with other method in class */
    void m586b() {
        Iterator it2 = new ArrayList(this.f913a).iterator();
        while (it2.hasNext()) {
            ((l) it2.next()).mo385a();
        }
    }

    @Override // com.xiaomi.push.fl
    public void b(fi fiVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        gu.a().b(fiVar);
    }

    public void b(i iVar) {
        this.f910a.a(iVar.a, iVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m587b() {
        try {
            Class<?> a2 = t.a(this, "miui.os.Build");
            return a2.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CT_CUSTOMIZATION_TEST").getBoolean(null);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m588c() {
        fi fiVar = this.f902a;
        return fiVar != null && fiVar.m336c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m589d() {
        fi fiVar = this.f902a;
        return fiVar != null && fiVar.m335b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f900a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        t.m676a((Context) this);
        k a2 = l.a((Context) this);
        if (a2 != null) {
            ab.a(a2.a);
        }
        this.f900a = new Messenger(new bu(this));
        ax.a(this);
        bv bvVar = new bv(this, null, 5222, "xiaomi.com", null);
        this.f903a = bvVar;
        bvVar.a(true);
        this.f901a = new fg(this, this.f903a);
        this.f909a = m582a();
        es.a(this);
        this.f901a.a(this);
        this.f907a = new ar(this);
        this.f908a = new bc(this);
        new e().a();
        gu.m378a().a(this);
        this.f910a = new g("Connection Controller Thread");
        as a3 = as.a();
        a3.b();
        a3.a(new bw(this));
        if (k()) {
            h();
        }
        ha.a(this).a(new i(this), "UPLOADER_PUSH_CHANNEL");
        a(new gx(this));
        a(new g());
        this.f914a.add(bj.a(this));
        if (m579h()) {
            this.f905a = new e();
            registerReceiver(this.f905a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.f899a = new bx(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f899a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m41a("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.f915b = new by(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.f915b);
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] a4 = m575a();
            if (a4 != null) {
                this.f906a = new p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f906a, intentFilter);
                this.a = a4[0];
                this.b = a4[1];
                com.xiaomi.channel.commonutils.logger.b.m41a("falldown initialized: " + this.a + "," + this.b);
            }
        }
        String str = "";
        if (a2 != null) {
            try {
                if (!TextUtils.isEmpty(a2.f1024a) && (split = a2.f1024a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        e eVar = this.f905a;
        if (eVar != null) {
            a(eVar);
            this.f905a = null;
        }
        p pVar = this.f906a;
        if (pVar != null) {
            a(pVar);
            this.f906a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f899a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f899a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m41a("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f915b != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f915b);
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f914a.clear();
        this.f910a.m653b();
        a(new bs(this, 2));
        a(new j());
        as.a().b();
        as.a().a(this, 15);
        as.a().m627a();
        this.f901a.b(this);
        bh.a().m644a();
        es.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m41a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        h hVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.m41a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(aw.r), intent.getStringExtra(aw.z), intent.getStringExtra("mipush_app_package")));
        }
        if (!(intent == null || intent.getAction() == null)) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f910a.m651a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    as.a().a(this, 14);
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
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }
}
