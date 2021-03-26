package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hc;
import com.xiaomi.push.hg;
import com.xiaomi.push.hp;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.bl;
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
        private Context f129a;

        /* renamed from: a  reason: collision with other field name */
        private C0156a f130a = new C0156a();

        /* renamed from: a  reason: collision with other field name */
        private Boolean f131a;

        /* renamed from: a  reason: collision with other field name */
        private String f132a;

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hg> f133a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        public class C0156a {

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f134a = new z(this);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hg> f135a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f136a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f137a = new ScheduledThreadPoolExecutor(1);

            public C0156a() {
            }

            private void a() {
                if (this.f136a == null) {
                    this.f136a = this.f137a.scheduleAtFixedRate(this.f134a, 1000, 1000, TimeUnit.MILLISECONDS);
                }
            }

            /* access modifiers changed from: private */
            public void b() {
                hg remove = this.f135a.remove(0);
                for (ib ibVar : bl.a(Arrays.asList(remove), a.this.f129a.getPackageName(), b.m75a(a.this.f129a).m76a(), 30720)) {
                    b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ak.a(a.this.f129a).a((ak) ibVar, hc.Notification, true, (hp) null);
                }
            }

            public void a(hg hgVar) {
                this.f137a.execute(new y(this, hgVar));
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

        private void a(hg hgVar) {
            synchronized (this.f133a) {
                if (!this.f133a.contains(hgVar)) {
                    this.f133a.add(hgVar);
                    if (this.f133a.size() > 100) {
                        this.f133a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (!ak.a(context).m68a()) {
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
            return b.m75a(context).m76a() == null && !a(this.f129a);
        }

        private boolean b(hg hgVar) {
            if (bl.a(hgVar, false)) {
                return false;
            }
            if (this.f131a.booleanValue()) {
                b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hgVar.d());
                ak.a(this.f129a).a(hgVar);
                return true;
            }
            this.f130a.a(hgVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m52a(Context context) {
            if (context == null) {
                b.m41a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f129a = context;
            this.f131a = Boolean.valueOf(a(context));
            b("com.xiaomi.xmpushsdk.tinydataPending.init");
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                b.m41a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f132a = str;
            b("com.xiaomi.xmpushsdk.tinydataPending.channel");
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m53a() {
            return this.f129a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m54a(hg hgVar) {
            String str;
            boolean z = false;
            if (hgVar == null) {
                return false;
            }
            if (bl.a(hgVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(hgVar.m390a()) && TextUtils.isEmpty(this.f132a);
            boolean z3 = !m53a();
            Context context = this.f129a;
            if (context == null || b(context)) {
                z = true;
            }
            if (z3 || z2 || z) {
                if (z2) {
                    str = "MiTinyDataClient Pending " + hgVar.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel";
                } else if (z3) {
                    str = "MiTinyDataClient Pending " + hgVar.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.init";
                } else {
                    if (z) {
                        str = "MiTinyDataClient Pending " + hgVar.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.appId";
                    }
                    a(hgVar);
                    return true;
                }
                b.c(str);
                a(hgVar);
                return true;
            }
            b.c("MiTinyDataClient Send item immediately." + hgVar.d());
            if (TextUtils.isEmpty(hgVar.d())) {
                hgVar.f(aq.a());
            }
            if (TextUtils.isEmpty(hgVar.m390a())) {
                hgVar.a(this.f132a);
            }
            if (TextUtils.isEmpty(hgVar.c())) {
                hgVar.e(this.f129a.getPackageName());
            }
            if (hgVar.a() <= 0) {
                hgVar.b(System.currentTimeMillis());
            }
            return b(hgVar);
        }

        public void b(String str) {
            b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f133a) {
                arrayList.addAll(this.f133a);
                this.f133a.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m54a((hg) it2.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            b.m41a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m52a(context);
        if (TextUtils.isEmpty(str)) {
            b.m41a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hg hgVar) {
        b.c("MiTinyDataClient.upload " + hgVar.d());
        if (!a.a().m53a()) {
            a.a().m52a(context);
        }
        return a.a().m54a(hgVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hg hgVar = new hg();
        hgVar.d(str);
        hgVar.c(str2);
        hgVar.a(j);
        hgVar.b(str3);
        hgVar.a(true);
        hgVar.a("push_sdk_channel");
        return upload(context, hgVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hg hgVar = new hg();
        hgVar.d(str);
        hgVar.c(str2);
        hgVar.a(j);
        hgVar.b(str3);
        return a.a().m54a(hgVar);
    }
}
