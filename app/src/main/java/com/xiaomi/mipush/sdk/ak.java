package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc;
import com.xiaomi.push.bh;
import com.xiaomi.push.cw;
import com.xiaomi.push.en;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ii;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.l;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ak {
    private static ak a;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f146a = new ArrayList<>();
    private static boolean b;

    /* renamed from: a  reason: collision with other field name */
    private Context f147a;

    /* renamed from: a  reason: collision with other field name */
    private Intent f148a = null;

    /* renamed from: a  reason: collision with other field name */
    private Handler f149a = null;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f150a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f151a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f152a;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f153a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f154a = false;
    private boolean c = false;

    static class a<T extends in<T, ?>> {
        hc a;

        /* renamed from: a  reason: collision with other field name */
        T f155a;

        /* renamed from: a  reason: collision with other field name */
        boolean f156a;

        a() {
        }
    }

    private ak(Context context) {
        this.f147a = context.getApplicationContext();
        this.f152a = null;
        this.f154a = m63c();
        b = m64d();
        this.f149a = new al(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f147a.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m61a() {
        return (!m68a() || "com.xiaomi.xmsf".equals(this.f147a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized ak a(Context context) {
        ak akVar;
        synchronized (ak.class) {
            if (a == null) {
                a = new ak(context);
            }
            akVar = a;
        }
        return akVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m62a() {
        try {
            return this.f147a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, ap apVar, boolean z, HashMap<String, String> hashMap) {
        ib ibVar;
        String str2;
        if (b.m75a(this.f147a).m82b() && bc.b(this.f147a)) {
            ib ibVar2 = new ib();
            ibVar2.a(true);
            Intent a2 = m61a();
            if (TextUtils.isEmpty(str)) {
                str = aq.a();
                ibVar2.a(str);
                ibVar = z ? new ib(str, true) : null;
                synchronized (ab.class) {
                    ab.a(this.f147a).m57a(str);
                }
            } else {
                ibVar2.a(str);
                ibVar = z ? new ib(str, true) : null;
            }
            switch (ao.a[apVar.ordinal()]) {
                case 1:
                    ibVar2.c(hm.DisablePushMessage.f576a);
                    ibVar.c(hm.DisablePushMessage.f576a);
                    if (hashMap != null) {
                        ibVar2.a(hashMap);
                        ibVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    a2.setAction(str2);
                    break;
                case 2:
                    ibVar2.c(hm.EnablePushMessage.f576a);
                    ibVar.c(hm.EnablePushMessage.f576a);
                    if (hashMap != null) {
                        ibVar2.a(hashMap);
                        ibVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    a2.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ibVar2.c(hm.ThirdPartyRegUpdate.f576a);
                    if (hashMap != null) {
                        ibVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            b.e("type:" + apVar + ", " + str);
            ibVar2.b(b.m75a(this.f147a).m76a());
            ibVar2.d(this.f147a.getPackageName());
            a((ak) ibVar2, hc.Notification, false, (hp) null);
            if (z) {
                ibVar.b(b.m75a(this.f147a).m76a());
                ibVar.d(this.f147a.getPackageName());
                byte[] a3 = im.a(ae.a(this.f147a, ibVar, hc.Notification, false, this.f147a.getPackageName(), b.m75a(this.f147a).m76a()));
                if (a3 != null) {
                    cw.a(this.f147a.getPackageName(), this.f147a, ibVar, hc.Notification, a3.length);
                    a2.putExtra("mipush_payload", a3);
                    a2.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    a2.putExtra("mipush_app_id", b.m75a(this.f147a).m76a());
                    a2.putExtra("mipush_app_token", b.m75a(this.f147a).b());
                    c(a2);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = apVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f149a.sendMessageDelayed(obtain, 5000);
        }
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f147a.getPackageName())) {
            return c();
        }
        b.c("pushChannel xmsf create own channel");
        return e();
    }

    private void b(Intent intent) {
        try {
            if (l.m568a() || Build.VERSION.SDK_INT < 26) {
                this.f147a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            b.a(e);
        }
    }

    private Intent c() {
        if (m68a()) {
            b.c("pushChannel app start miui china channel");
            return d();
        }
        b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f147a.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i).commit();
    }

    private void c(Intent intent) {
        int a2 = an.a(this.f147a).a(hh.ServiceBootMode.a(), hd.START.a());
        int a3 = a();
        boolean z = a2 == hd.BIND.a() && b;
        int a4 = (z ? hd.BIND : hd.START).a();
        if (a4 != a3) {
            m69a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m63c() {
        try {
            PackageInfo packageInfo = this.f147a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f147a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m62a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f153a.size() >= 50) {
                this.f153a.remove(0);
            }
            this.f153a.add(a2);
            return;
        }
        if (this.f150a == null) {
            this.f147a.bindService(intent, new an(this), 1);
            this.c = true;
            this.f153a.clear();
            this.f153a.add(a(intent));
        } else {
            try {
                this.f150a.send(a(intent));
            } catch (RemoteException unused) {
                this.f150a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m64d() {
        if (m68a()) {
            try {
                return this.f147a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f147a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f147a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m65e() {
        String packageName = this.f147a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f147a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f147a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f147a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f147a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f147a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m66a() {
        b(m61a());
    }

    public void a(int i) {
        Intent a2 = m61a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(aw.z, this.f147a.getPackageName());
        a2.putExtra(aw.A, i);
        c(a2);
    }

    void a(int i, String str) {
        Intent a2 = m61a();
        a2.setAction("com.xiaomi.mipush.thirdparty");
        a2.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        a2.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    void m67a(Intent intent) {
        intent.fillIn(m61a(), 24);
        c(intent);
    }

    public final void a(hg hgVar) {
        Intent a2 = m61a();
        byte[] a3 = im.a(hgVar);
        if (a3 == null) {
            b.m41a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        a2.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        a2.putExtra("mipush_payload", a3);
        b(a2);
    }

    public final void a(ic icVar, boolean z) {
        en.a(this.f147a.getApplicationContext()).a(this.f147a.getPackageName(), "E100003", icVar.a(), 6001, null);
        this.f148a = null;
        b.m75a(this.f147a).f161a = icVar.a();
        Intent a2 = m61a();
        byte[] a3 = im.a(ae.a(this.f147a, icVar, hc.Registration));
        if (a3 == null) {
            b.m41a("register fail, because msgBytes is null.");
            return;
        }
        a2.setAction("com.xiaomi.mipush.REGISTER_APP");
        a2.putExtra("mipush_app_id", b.m75a(this.f147a).m76a());
        a2.putExtra("mipush_payload", a3);
        a2.putExtra("mipush_session", this.f152a);
        a2.putExtra("mipush_env_chanage", z);
        a2.putExtra("mipush_env_type", b.m75a(this.f147a).a());
        if (!bc.b(this.f147a) || !m71b()) {
            this.f148a = a2;
        } else {
            c(a2);
        }
    }

    public final void a(ii iiVar) {
        byte[] a2 = im.a(ae.a(this.f147a, iiVar, hc.UnRegistration));
        if (a2 == null) {
            b.m41a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent a3 = m61a();
        a3.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        a3.putExtra("mipush_app_id", b.m75a(this.f147a).m76a());
        a3.putExtra("mipush_payload", a2);
        c(a3);
    }

    public final <T extends in<T, ?>> void a(T t, hc hcVar, hp hpVar) {
        a((ak) t, hcVar, !hcVar.equals(hc.Registration), hpVar);
    }

    public <T extends in<T, ?>> void a(T t, hc hcVar, boolean z) {
        a aVar = new a();
        aVar.f155a = t;
        aVar.a = hcVar;
        aVar.f156a = z;
        ArrayList<a> arrayList = f146a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public final <T extends in<T, ?>> void a(T t, hc hcVar, boolean z, hp hpVar) {
        a(t, hcVar, z, true, hpVar, true);
    }

    public final <T extends in<T, ?>> void a(T t, hc hcVar, boolean z, hp hpVar, boolean z2) {
        a(t, hcVar, z, true, hpVar, z2);
    }

    public final <T extends in<T, ?>> void a(T t, hc hcVar, boolean z, boolean z2, hp hpVar, boolean z3) {
        a(t, hcVar, z, z2, hpVar, z3, this.f147a.getPackageName(), b.m75a(this.f147a).m76a());
    }

    public final <T extends in<T, ?>> void a(T t, hc hcVar, boolean z, boolean z2, hp hpVar, boolean z3, String str, String str2) {
        a(t, hcVar, z, z2, hpVar, z3, str, str2, true);
    }

    public final <T extends in<T, ?>> void a(T t, hc hcVar, boolean z, boolean z2, hp hpVar, boolean z3, String str, String str2, boolean z4) {
        if (b.m75a(this.f147a).m84c()) {
            Context context = this.f147a;
            hy a2 = z4 ? ae.a(context, t, hcVar, z, str, str2) : ae.b(context, t, hcVar, z, str, str2);
            if (hpVar != null) {
                a2.a(hpVar);
            }
            byte[] a3 = im.a(a2);
            if (a3 == null) {
                b.m41a("send message fail, because msgBytes is null.");
                return;
            }
            cw.a(this.f147a.getPackageName(), this.f147a, t, hcVar, a3.length);
            Intent a4 = m61a();
            a4.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            a4.putExtra("mipush_payload", a3);
            a4.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            c(a4);
        } else if (z2) {
            a((ak) t, hcVar, z);
        } else {
            b.m41a("drop the message before initialization.");
        }
    }

    public final void a(String str, ap apVar, d dVar) {
        ab.a(this.f147a).a(apVar, "syncing");
        a(str, apVar, false, h.a(this.f147a, dVar));
    }

    public void a(String str, String str2) {
        Intent a2 = m61a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(aw.z, this.f147a.getPackageName());
        a2.putExtra(aw.E, str);
        a2.putExtra(aw.F, str2);
        c(a2);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        ap apVar;
        if (z) {
            ab.a(this.f147a).a(ap.DISABLE_PUSH, "syncing");
            ab.a(this.f147a).a(ap.ENABLE_PUSH, "");
            apVar = ap.DISABLE_PUSH;
        } else {
            ab.a(this.f147a).a(ap.ENABLE_PUSH, "syncing");
            ab.a(this.f147a).a(ap.DISABLE_PUSH, "");
            apVar = ap.ENABLE_PUSH;
        }
        a(str, apVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m68a() {
        return this.f154a && 1 == b.m75a(this.f147a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m69a(int i) {
        if (!b.m75a(this.f147a).m82b()) {
            return false;
        }
        c(i);
        ib ibVar = new ib();
        ibVar.a(aq.a());
        ibVar.b(b.m75a(this.f147a).m76a());
        ibVar.d(this.f147a.getPackageName());
        ibVar.c(hm.ClientABTest.f576a);
        ibVar.f717a = new HashMap();
        Map<String, String> map = ibVar.f717a;
        map.put("boot_mode", i + "");
        a(this.f147a).a((ak) ibVar, hc.Notification, false, (hp) null);
        return true;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m70b() {
        Intent a2 = m61a();
        a2.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(a2);
    }

    public void b(int i) {
        Intent a2 = m61a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(aw.z, this.f147a.getPackageName());
        a2.putExtra(aw.B, i);
        String str = aw.D;
        a2.putExtra(str, bh.b(this.f147a.getPackageName() + i));
        c(a2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m71b() {
        if (!m68a() || !m65e()) {
            return true;
        }
        if (this.f151a == null) {
            Integer valueOf = Integer.valueOf(az.a(this.f147a).a());
            this.f151a = valueOf;
            if (valueOf.intValue() == 0) {
                this.f147a.getContentResolver().registerContentObserver(az.a(this.f147a).m634a(), false, new am(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f151a.intValue() != 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m72c() {
        Intent intent = this.f148a;
        if (intent != null) {
            c(intent);
            this.f148a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m73d() {
        ArrayList<a> arrayList = f146a;
        synchronized (arrayList) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                a(next.f155a, next.a, next.f156a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f146a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m74e() {
        Intent a2 = m61a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(aw.z, this.f147a.getPackageName());
        a2.putExtra(aw.D, bh.b(this.f147a.getPackageName()));
        c(a2);
    }
}
