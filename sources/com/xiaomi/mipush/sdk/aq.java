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
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.aa;
import com.xiaomi.push.ag;
import com.xiaomi.push.bx;
import com.xiaomi.push.dv;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.hf;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.it;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.o;
import com.xiaomi.push.service.u;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aq {
    private static aq a;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f128a = new ArrayList<>();
    private static boolean b;

    /* renamed from: a  reason: collision with other field name */
    private Context f129a;

    /* renamed from: a  reason: collision with other field name */
    private Intent f130a = null;

    /* renamed from: a  reason: collision with other field name */
    private Handler f131a = null;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f132a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f133a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f134a;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f135a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f136a = false;
    private boolean c = false;

    static class a<T extends hu<T, ?>> {
        gi a;

        /* renamed from: a  reason: collision with other field name */
        T f137a;

        /* renamed from: a  reason: collision with other field name */
        boolean f138a;

        a() {
        }
    }

    private aq(Context context) {
        this.f129a = context.getApplicationContext();
        this.f134a = null;
        this.f136a = m42c();
        b = m43d();
        this.f131a = new ar(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f129a.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m40a() {
        return (!m47a() || "com.xiaomi.xmsf".equals(this.f129a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized aq a(Context context) {
        aq aqVar;
        synchronized (aq.class) {
            if (a == null) {
                a = new aq(context);
            }
            aqVar = a;
        }
        return aqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m41a() {
        try {
            return this.f129a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, av avVar, boolean z, HashMap<String, String> hashMap) {
        hi hiVar;
        String str2;
        if (b.m54a(this.f129a).m61b() && aa.c(this.f129a)) {
            hi hiVar2 = new hi();
            hiVar2.a(true);
            Intent a2 = m40a();
            if (TextUtils.isEmpty(str)) {
                str = o.a();
                hiVar2.a(str);
                hiVar = z ? new hi(str, true) : null;
                synchronized (ag.class) {
                    ag.a(this.f129a).m36a(str);
                }
            } else {
                hiVar2.a(str);
                hiVar = z ? new hi(str, true) : null;
            }
            switch (au.a[avVar.ordinal()]) {
                case 1:
                    hiVar2.c(gs.DisablePushMessage.S);
                    hiVar.c(gs.DisablePushMessage.S);
                    if (hashMap != null) {
                        hiVar2.a(hashMap);
                        hiVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    a2.setAction(str2);
                    break;
                case 2:
                    hiVar2.c(gs.EnablePushMessage.S);
                    hiVar.c(gs.EnablePushMessage.S);
                    if (hashMap != null) {
                        hiVar2.a(hashMap);
                        hiVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    a2.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    hiVar2.c(gs.ThirdPartyRegUpdate.S);
                    if (hashMap != null) {
                        hiVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            hiVar2.b(b.m54a(this.f129a).m55a());
            hiVar2.d(this.f129a.getPackageName());
            a((aq) hiVar2, gi.Notification, false, (gv) null);
            if (z) {
                hiVar.b(b.m54a(this.f129a).m55a());
                hiVar.d(this.f129a.getPackageName());
                byte[] a3 = ht.a(aj.a(this.f129a, hiVar, gi.Notification, false, this.f129a.getPackageName(), b.m54a(this.f129a).m55a()));
                if (a3 != null) {
                    bx.a(this.f129a.getPackageName(), this.f129a, hiVar, gi.Notification, a3.length);
                    a2.putExtra("mipush_payload", a3);
                    a2.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    a2.putExtra("mipush_app_id", b.m54a(this.f129a).m55a());
                    a2.putExtra("mipush_app_token", b.m54a(this.f129a).b());
                    c(a2);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f131a.sendMessageDelayed(obtain, 5000);
        }
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f129a.getPackageName())) {
            return c();
        }
        c.c("pushChannel xmsf create own channel");
        return e();
    }

    private void b(Intent intent) {
        try {
            if (it.a() || Build.VERSION.SDK_INT < 26) {
                this.f129a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            c.a(e);
        }
    }

    private Intent c() {
        if (m47a()) {
            c.c("pushChannel app start miui china channel");
            return d();
        }
        c.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f129a.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i).commit();
    }

    private void c(Intent intent) {
        int a2 = l.a(this.f129a).a(gn.ServiceBootMode.a(), gj.START.a());
        int a3 = a();
        boolean z = a2 == gj.BIND.a() && b;
        int a4 = (z ? gj.BIND : gj.START).a();
        if (a4 != a3) {
            m48a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m42c() {
        try {
            PackageInfo packageInfo = this.f129a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f129a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m41a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f135a.size() >= 50) {
                this.f135a.remove(0);
            }
            this.f135a.add(a2);
            return;
        }
        if (this.f132a == null) {
            this.f129a.bindService(intent, new at(this), 1);
            this.c = true;
            this.f135a.clear();
            this.f135a.add(a(intent));
        } else {
            try {
                this.f132a.send(a(intent));
            } catch (RemoteException unused) {
                this.f132a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m43d() {
        if (m47a()) {
            try {
                return this.f129a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f129a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f129a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m44e() {
        String packageName = this.f129a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f129a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f129a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f129a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f129a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f129a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m45a() {
        b(m40a());
    }

    public void a(int i) {
        Intent a2 = m40a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(u.z, this.f129a.getPackageName());
        a2.putExtra(u.A, i);
        c(a2);
    }

    void a(int i, String str) {
        Intent a2 = m40a();
        a2.setAction("com.xiaomi.mipush.thirdparty");
        a2.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        a2.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    void m46a(Intent intent) {
        intent.fillIn(m40a(), 24);
        c(intent);
    }

    public final void a(gm gmVar) {
        Intent a2 = m40a();
        byte[] a3 = ht.a(gmVar);
        if (a3 == null) {
            c.a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        a2.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        a2.putExtra("mipush_payload", a3);
        b(a2);
    }

    public final void a(hj hjVar, boolean z) {
        dv.a(this.f129a.getApplicationContext()).a(this.f129a.getPackageName(), "E100003", hjVar.c(), 6001, null);
        this.f130a = null;
        b.m54a(this.f129a).f143a = hjVar.c();
        Intent a2 = m40a();
        byte[] a3 = ht.a(aj.a(this.f129a, hjVar, gi.Registration));
        if (a3 == null) {
            c.a("register fail, because msgBytes is null.");
            return;
        }
        a2.setAction("com.xiaomi.mipush.REGISTER_APP");
        a2.putExtra("mipush_app_id", b.m54a(this.f129a).m55a());
        a2.putExtra("mipush_payload", a3);
        a2.putExtra("mipush_session", this.f134a);
        a2.putExtra("mipush_env_chanage", z);
        a2.putExtra("mipush_env_type", b.m54a(this.f129a).a());
        if (!aa.c(this.f129a) || !m50b()) {
            this.f130a = a2;
        } else {
            c(a2);
        }
    }

    public final void a(hp hpVar) {
        byte[] a2 = ht.a(aj.a(this.f129a, hpVar, gi.UnRegistration));
        if (a2 == null) {
            c.a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent a3 = m40a();
        a3.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        a3.putExtra("mipush_app_id", b.m54a(this.f129a).m55a());
        a3.putExtra("mipush_payload", a2);
        c(a3);
    }

    public final <T extends hu<T, ?>> void a(T t, gi giVar, gv gvVar) {
        a((aq) t, giVar, !giVar.equals(gi.Registration), gvVar);
    }

    public <T extends hu<T, ?>> void a(T t, gi giVar, boolean z) {
        a aVar = new a();
        aVar.f137a = t;
        aVar.a = giVar;
        aVar.f138a = z;
        ArrayList<a> arrayList = f128a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public final <T extends hu<T, ?>> void a(T t, gi giVar, boolean z, gv gvVar) {
        a(t, giVar, z, true, gvVar, true);
    }

    public final <T extends hu<T, ?>> void a(T t, gi giVar, boolean z, gv gvVar, boolean z2) {
        a(t, giVar, z, true, gvVar, z2);
    }

    public final <T extends hu<T, ?>> void a(T t, gi giVar, boolean z, boolean z2, gv gvVar, boolean z3) {
        a(t, giVar, z, z2, gvVar, z3, this.f129a.getPackageName(), b.m54a(this.f129a).m55a());
    }

    public final <T extends hu<T, ?>> void a(T t, gi giVar, boolean z, boolean z2, gv gvVar, boolean z3, String str, String str2) {
        if (b.m54a(this.f129a).m63c()) {
            hf a2 = aj.a(this.f129a, t, giVar, z, str, str2);
            if (gvVar != null) {
                a2.a(gvVar);
            }
            byte[] a3 = ht.a(a2);
            if (a3 == null) {
                c.a("send message fail, because msgBytes is null.");
                return;
            }
            bx.a(this.f129a.getPackageName(), this.f129a, t, giVar, a3.length);
            Intent a4 = m40a();
            a4.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            a4.putExtra("mipush_payload", a3);
            a4.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            c(a4);
        } else if (z2) {
            a((aq) t, giVar, z);
        } else {
            c.a("drop the message before initialization.");
        }
    }

    public final void a(String str, av avVar, d dVar) {
        ag.a(this.f129a).a(avVar, "syncing");
        a(str, avVar, false, h.a(this.f129a, dVar));
    }

    public void a(String str, String str2) {
        Intent a2 = m40a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(u.z, this.f129a.getPackageName());
        a2.putExtra(u.E, str);
        a2.putExtra(u.F, str2);
        c(a2);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        av avVar;
        if (z) {
            ag.a(this.f129a).a(av.DISABLE_PUSH, "syncing");
            ag.a(this.f129a).a(av.ENABLE_PUSH, "");
            avVar = av.DISABLE_PUSH;
        } else {
            ag.a(this.f129a).a(av.ENABLE_PUSH, "syncing");
            ag.a(this.f129a).a(av.DISABLE_PUSH, "");
            avVar = av.ENABLE_PUSH;
        }
        a(str, avVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m47a() {
        return this.f136a && 1 == b.m54a(this.f129a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m48a(int i) {
        if (!b.m54a(this.f129a).m61b()) {
            return false;
        }
        c(i);
        hi hiVar = new hi();
        hiVar.a(o.a());
        hiVar.b(b.m54a(this.f129a).m55a());
        hiVar.d(this.f129a.getPackageName());
        hiVar.c(gs.ClientABTest.S);
        hiVar.h = new HashMap();
        Map<String, String> map = hiVar.h;
        map.put("boot_mode", i + "");
        a(this.f129a).a((aq) hiVar, gi.Notification, false, (gv) null);
        return true;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m49b() {
        Intent a2 = m40a();
        a2.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(a2);
    }

    public void b(int i) {
        Intent a2 = m40a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(u.z, this.f129a.getPackageName());
        a2.putExtra(u.B, i);
        String str = u.D;
        a2.putExtra(str, ag.b(this.f129a.getPackageName() + i));
        c(a2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m50b() {
        if (!m47a() || !m44e()) {
            return true;
        }
        if (this.f133a == null) {
            Integer valueOf = Integer.valueOf(x.a(this.f129a).b());
            this.f133a = valueOf;
            if (valueOf.intValue() == 0) {
                this.f129a.getContentResolver().registerContentObserver(x.a(this.f129a).c(), false, new as(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f133a.intValue() != 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m51c() {
        Intent intent = this.f130a;
        if (intent != null) {
            c(intent);
            this.f130a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m52d() {
        ArrayList<a> arrayList = f128a;
        synchronized (arrayList) {
            Iterator<a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                a(next.f137a, next.a, next.f138a, false, null, true);
            }
            f128a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m53e() {
        Intent a2 = m40a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(u.z, this.f129a.getPackageName());
        a2.putExtra(u.D, ag.b(this.f129a.getPackageName()));
        c(a2);
    }
}
