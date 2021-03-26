package com.bytedance.sdk.adnet.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.d.f;
import com.bytedance.sdk.adnet.d.g;
import com.bytedance.sdk.adnet.d.h;
import com.bytedance.sdk.openadsdk.j.e;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: AppConfig */
public class a implements com.bytedance.sdk.adnet.c.a, h.a {
    private static a b;
    final h a = new h(Looper.getMainLooper(), this);
    private final boolean c;
    private volatile boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private long g = 0;
    private long h = 0;
    private AtomicBoolean i = new AtomicBoolean(false);
    private final Context j;
    private volatile boolean k = false;

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                a aVar2 = new a(context.getApplicationContext(), f.b(context));
                b = aVar2;
                com.bytedance.sdk.adnet.a.a(aVar2);
            }
            aVar = b;
        }
        return aVar;
    }

    private a(Context context, boolean z) {
        this.j = context;
        this.c = z;
    }

    public void a() {
        a(false);
    }

    public synchronized void a(boolean z) {
        if (this.c) {
            d(z);
        } else if (this.g <= 0) {
            try {
                e.a().execute(new Runnable() {
                    /* class com.bytedance.sdk.adnet.a.a.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(Context context) {
        a aVar = b;
        if (aVar == null) {
            return;
        }
        if (f.b(context)) {
            aVar.a(true);
        } else {
            aVar.a();
        }
    }

    synchronized void b() {
        if (System.currentTimeMillis() - this.g > 3600000) {
            this.g = System.currentTimeMillis();
            try {
                if (com.bytedance.sdk.adnet.c.f.a().e() != null) {
                    com.bytedance.sdk.adnet.c.f.a().e().b();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void d(boolean z) {
        if (!this.f) {
            if (this.e) {
                this.e = false;
                this.g = 0;
                this.h = 0;
            }
            long j2 = z ? 10800000 : 43200000;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g > j2 && currentTimeMillis - this.h > 120000) {
                boolean a2 = com.bytedance.sdk.adnet.d.e.a(this.j);
                if (!this.k || a2) {
                    b(a2);
                }
            }
        }
    }

    public boolean b(final boolean z) {
        c.b("TNCManager", "doRefresh: updating state " + this.i.get());
        if (!this.i.compareAndSet(false, true)) {
            c.b("TNCManager", "doRefresh, already running");
            return false;
        }
        if (z) {
            this.h = System.currentTimeMillis();
        }
        e.a().execute(new Runnable() {
            /* class com.bytedance.sdk.adnet.a.a.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(z);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.adnet.d.h.a
    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.f = false;
            this.g = System.currentTimeMillis();
            c.b("TNCManager", "doRefresh, succ");
            if (this.e) {
                a();
            }
            this.i.set(false);
        } else if (i2 == 102) {
            this.f = false;
            if (this.e) {
                a();
            }
            c.b("TNCManager", "doRefresh, error");
            this.i.set(false);
        }
    }

    public synchronized void c() {
        if (!this.k) {
            this.k = true;
            long j2 = this.j.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (j2 > currentTimeMillis) {
                j2 = currentTimeMillis;
            }
            this.g = j2;
            if (com.bytedance.sdk.adnet.c.f.a().e() != null) {
                com.bytedance.sdk.adnet.c.f.a().e().a();
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.c.a
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                return com.bytedance.sdk.adnet.c.f.a().a(str);
            } catch (Throwable unused) {
                return str;
            }
        } else {
            try {
                if (this.c) {
                    c();
                } else {
                    b();
                }
                return com.bytedance.sdk.adnet.c.f.a().a(str);
            } catch (Throwable unused2) {
                return str;
            }
        }
    }

    void c(boolean z) {
        c.b("TNCManager", "doRefresh, actual request");
        c();
        this.f = true;
        if (!z) {
            this.a.sendEmptyMessage(102);
            return;
        }
        try {
            e();
        } catch (Exception unused) {
            this.i.set(false);
        }
    }

    public String[] d() {
        String[] f2 = com.bytedance.sdk.adnet.a.a().f();
        return (f2 == null || f2.length <= 0) ? new String[0] : f2;
    }

    /* access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor edit = this.j.getSharedPreferences("ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (com.bytedance.sdk.adnet.c.f.a().e() == null) {
            return true;
        }
        com.bytedance.sdk.adnet.c.f.a().e().a(jSONObject2);
        return true;
    }

    private boolean e() {
        String[] d2 = d();
        if (!(d2 == null || d2.length == 0)) {
            a(0);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void a(final int i2) {
        String[] d2 = d();
        if (d2 == null || d2.length <= i2) {
            b(102);
            return;
        }
        String str = d2[i2];
        if (TextUtils.isEmpty(str)) {
            b(102);
            return;
        }
        try {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                b(102);
            } else {
                new com.bytedance.sdk.adnet.b.f(0, b2, new JSONObject(), new m.a<JSONObject>() {
                    /* class com.bytedance.sdk.adnet.a.a.AnonymousClass3 */

                    @Override // com.bytedance.sdk.adnet.core.m.a
                    public void a(m<JSONObject> mVar) {
                        T t = mVar.a;
                        if (t == null) {
                            a.this.a(i2 + 1);
                            return;
                        }
                        String str = null;
                        try {
                            str = t.getString("message");
                        } catch (Exception unused) {
                        }
                        if (!"success".equals(str)) {
                            a.this.a(i2 + 1);
                            return;
                        }
                        try {
                            if (a.this.a((Object) t)) {
                                a.this.b(101);
                            } else {
                                a.this.a(i2 + 1);
                            }
                        } catch (Exception unused2) {
                        }
                    }

                    @Override // com.bytedance.sdk.adnet.core.m.a
                    public void b(m<JSONObject> mVar) {
                        a.this.a(i2 + 1);
                    }
                }).setRetryPolicy(new com.bytedance.sdk.adnet.core.e().a(10000).b(0)).build(com.bytedance.sdk.adnet.a.a(this.j));
            }
        } catch (Throwable th) {
            c.b("AppConfig", "try app config exception: " + th);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.sendEmptyMessage(i2);
        }
    }

    private String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Address a2 = com.bytedance.sdk.adnet.a.a().a(this.j);
        g gVar = new g("https://" + str + "/get_domains/v4/");
        if (a2 != null && a2.hasLatitude() && a2.hasLongitude()) {
            gVar.a("latitude", a2.getLatitude());
            gVar.a("longitude", a2.getLongitude());
            String locality = a2.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                gVar.a("city", Uri.encode(locality));
            }
        }
        if (this.d) {
            gVar.a("force", 1);
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str2 = Build.CPU_ABI;
            } else {
                str2 = Build.SUPPORTED_ABIS[0];
            }
            gVar.a("abi", str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        gVar.a("aid", com.bytedance.sdk.adnet.a.a().a());
        gVar.a("device_platform", com.bytedance.sdk.adnet.a.a().c());
        gVar.a("channel", com.bytedance.sdk.adnet.a.a().b());
        gVar.a("version_code", com.bytedance.sdk.adnet.a.a().d());
        gVar.a("custom_info_1", com.bytedance.sdk.adnet.a.a().e());
        return gVar.toString();
    }
}
