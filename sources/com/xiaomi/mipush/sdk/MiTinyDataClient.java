package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.gi;
import com.xiaomi.push.gm;
import com.xiaomi.push.gv;
import com.xiaomi.push.hi;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static class a {
        private static volatile a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f107a;

        /* renamed from: a  reason: collision with other field name */
        private C0184a f108a = new C0184a();

        /* renamed from: a  reason: collision with other field name */
        private Boolean f109a;

        /* renamed from: a  reason: collision with other field name */
        private String f110a;

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<gm> f111a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        public class C0184a {

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f112a = new ae(this);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<gm> f113a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f114a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f115a = new ScheduledThreadPoolExecutor(1);

            public C0184a() {
            }

            private void a() {
                if (this.f114a == null) {
                    this.f114a = this.f115a.scheduleAtFixedRate(this.f112a, 1000, 1000, TimeUnit.MILLISECONDS);
                }
            }

            /* access modifiers changed from: private */
            public void b() {
                gm remove = this.f113a.remove(0);
                for (hi hiVar : ak.a(Arrays.asList(remove), a.this.f107a.getPackageName(), b.m54a(a.this.f107a).m55a(), 30720)) {
                    c.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.m());
                    aq.a(a.this.f107a).a((aq) hiVar, gi.Notification, true, (gv) null);
                }
            }

            public void a(gm gmVar) {
                this.f115a.execute(new ad(this, gmVar));
            }
        }

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        private void a(gm gmVar) {
            synchronized (this.f111a) {
                if (!this.f111a.contains(gmVar)) {
                    this.f111a.add(gmVar);
                    if (this.f111a.size() > 100) {
                        this.f111a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (!aq.a(context).m47a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                return packageInfo != null && packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean b(Context context) {
            return b.m54a(context).m55a() == null && !a(this.f107a);
        }

        private boolean b(gm gmVar) {
            if (ak.a(gmVar, false)) {
                return false;
            }
            if (this.f109a.booleanValue()) {
                c.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + gmVar.m());
                aq.a(this.f107a).a(gmVar);
                return true;
            }
            this.f108a.a(gmVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m31a(Context context) {
            if (context == null) {
                c.a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f107a = context;
            this.f109a = Boolean.valueOf(a(context));
            b("com.xiaomi.xmpushsdk.tinydataPending.init");
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c.a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f110a = str;
            b("com.xiaomi.xmpushsdk.tinydataPending.channel");
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m32a() {
            return this.f107a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m33a(gm gmVar) {
            String str;
            boolean z = false;
            if (gmVar == null) {
                return false;
            }
            if (ak.a(gmVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(gmVar.a()) && TextUtils.isEmpty(this.f110a);
            boolean z3 = !m32a();
            Context context = this.f107a;
            if (context == null || b(context)) {
                z = true;
            }
            if (z3 || z2 || z) {
                if (z2) {
                    str = "MiTinyDataClient Pending " + gmVar.d() + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel";
                } else if (z3) {
                    str = "MiTinyDataClient Pending " + gmVar.d() + " reason is com.xiaomi.xmpushsdk.tinydataPending.init";
                } else {
                    if (z) {
                        str = "MiTinyDataClient Pending " + gmVar.d() + " reason is com.xiaomi.xmpushsdk.tinydataPending.appId";
                    }
                    a(gmVar);
                    return true;
                }
                c.c(str);
                a(gmVar);
                return true;
            }
            c.c("MiTinyDataClient Send item immediately." + gmVar.m());
            if (TextUtils.isEmpty(gmVar.m())) {
                gmVar.f(o.a());
            }
            if (TextUtils.isEmpty(gmVar.a())) {
                gmVar.a(this.f110a);
            }
            if (TextUtils.isEmpty(gmVar.k())) {
                gmVar.e(this.f107a.getPackageName());
            }
            if (gmVar.g() <= 0) {
                gmVar.b(System.currentTimeMillis());
            }
            return b(gmVar);
        }

        public void b(String str) {
            c.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f111a) {
                arrayList.addAll(this.f111a);
                this.f111a.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m33a((gm) it2.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            c.a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m31a(context);
        if (TextUtils.isEmpty(str)) {
            c.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, gm gmVar) {
        c.c("MiTinyDataClient.upload " + gmVar.m());
        if (!a.a().m32a()) {
            a.a().m31a(context);
        }
        return a.a().m33a(gmVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        gm gmVar = new gm();
        gmVar.d(str);
        gmVar.c(str2);
        gmVar.a(j);
        gmVar.b(str3);
        gmVar.c(true);
        gmVar.a("push_sdk_channel");
        return upload(context, gmVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        gm gmVar = new gm();
        gmVar.d(str);
        gmVar.c(str2);
        gmVar.a(j);
        gmVar.b(str3);
        return a.a().m33a(gmVar);
    }
}
