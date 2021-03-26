package com.bytedance.sdk.openadsdk.core.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.c;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* compiled from: SdkSettingsHelper */
public class f implements Runnable {
    private static final AtomicLong c = new AtomicLong(0);
    private static volatile f d;
    private static boolean e = true;
    private static volatile boolean f = false;
    private final c a;
    private final Context b;

    public static f a(c cVar) {
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    d = new f(cVar);
                }
            }
        }
        return d;
    }

    public static void a() {
        File file;
        try {
            Context a2 = p.a();
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(a2.getDataDir(), "shared_prefs");
            } else {
                file = new File(a2.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String replace = file2.getName().replace(".xml", "");
                if (Build.VERSION.SDK_INT >= 24) {
                    a2.deleteSharedPreferences(replace);
                    return;
                }
                a2.getSharedPreferences(replace, 0).edit().clear().apply();
                l.c(file2);
            }
        } catch (Throwable unused) {
        }
    }

    private f(c cVar) {
        this.a = cVar == null ? p.h() : cVar;
        Context a2 = p.a();
        this.b = a2;
        if (b.b()) {
            try {
                a2.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: SdkSettingsHelper */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("b_msg_id", -1);
                if (intExtra == 1) {
                    long longExtra = intent.getLongExtra("b_msg_time", -1);
                    if (longExtra > 0) {
                        f.c.set(longExtra);
                    }
                } else if (intExtra == 2) {
                    try {
                        if (f.this.a != null) {
                            f.this.a.a();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static void b() {
        if (p.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                p.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(long j) {
        if (j > 0 && p.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                p.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        try {
            if (!g()) {
                long currentTimeMillis = System.currentTimeMillis();
                AtomicLong atomicLong = c;
                if (currentTimeMillis - atomicLong.get() >= 600000) {
                    atomicLong.set(currentTimeMillis);
                    if (b.b()) {
                        a(currentTimeMillis);
                    }
                    e.a(this, 10);
                }
            }
        } catch (Throwable th) {
            u.a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private boolean g() {
        return TextUtils.isEmpty(i.d().f());
    }

    public static boolean d() {
        return f;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.b)) {
            try {
                this.a.a();
            } catch (Throwable unused) {
            }
        } else if (!g()) {
            new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/settings/"), a(h()), new m.a<JSONObject>() {
                /* class com.bytedance.sdk.openadsdk.core.h.f.AnonymousClass1 */

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r3v4, types: [org.json.JSONObject] */
                /* JADX WARN: Type inference failed for: r3v8, types: [org.json.JSONObject] */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x0068 A[Catch:{ all -> 0x0072 }] */
                /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[Catch:{ all -> 0x0072 }] */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[Catch:{ all -> 0x0085 }] */
                /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
                /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Unknown variable types count: 2 */
                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<JSONObject> mVar) {
                    String str;
                    T t;
                    if (mVar == null || mVar.a == null) {
                        try {
                            f.this.a.a();
                        } catch (Throwable unused) {
                        }
                    } else {
                        int optInt = mVar.a.optInt("cypher", -1);
                        T t2 = mVar.a;
                        Map<String, String> map = null;
                        if (optInt == 1) {
                            str = com.bytedance.sdk.openadsdk.core.a.b(mVar.a.optString("message"), com.bytedance.sdk.openadsdk.core.b.a());
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    t = new JSONObject(str);
                                } catch (Throwable th) {
                                    u.a("SdkSettingsHelper", "setting data error: ", th);
                                }
                            }
                            if (mVar.b != null) {
                                map = mVar.b.h;
                            }
                            f.this.a(str, map);
                            if (!f.f) {
                                boolean unused2 = f.f = true;
                            }
                            f.this.a.a(t2);
                            com.bytedance.sdk.openadsdk.g.a.a().b();
                            if (b.b()) {
                                f.b();
                                return;
                            }
                            return;
                        }
                        if (optInt == 2) {
                            str = aj.k(mVar.a.optString("message"));
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    t = new JSONObject(str);
                                } catch (Throwable th2) {
                                    u.a("SdkSettingsHelper", "setting data error2: ", th2);
                                }
                            }
                        } else {
                            str = null;
                        }
                        if (mVar.b != null) {
                        }
                        f.this.a(str, map);
                        if (!f.f) {
                        }
                        f.this.a.a(t2);
                        com.bytedance.sdk.openadsdk.g.a.a().b();
                        if (b.b()) {
                        }
                        t2 = t;
                        try {
                            if (mVar.b != null) {
                            }
                            f.this.a(str, map);
                        } catch (Throwable unused3) {
                        }
                        try {
                            if (!f.f) {
                            }
                            f.this.a.a(t2);
                        } catch (Throwable unused4) {
                        }
                        com.bytedance.sdk.openadsdk.g.a.a().b();
                        if (b.b()) {
                        }
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<JSONObject> mVar) {
                    try {
                        f.this.a.a();
                    } catch (Throwable unused) {
                    }
                }
            }).setResponseOnMain(false).setShouldCache(false).build(d.a(this.b).d());
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                int intValue = Integer.valueOf(map.get("active-control")).intValue();
                long longValue = Long.valueOf(map.get("ts")).longValue();
                String str2 = map.get("pst");
                String a2 = com.bytedance.sdk.openadsdk.i.g.b.a(str + intValue + longValue);
                if (a2 != null && a2.equalsIgnoreCase(str2)) {
                    i = intValue;
                }
            }
        } catch (Throwable unused) {
        }
        g.a(i);
    }

    private JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.b);
            if (a2 != null) {
                jSONObject.put("latitude", (double) a2.a);
                jSONObject.put("longitude", (double) a2.b);
            }
        } catch (Exception unused) {
        }
        int i = 1;
        try {
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put("imei", k.d(this.b));
            jSONObject.put("oaid", y.a());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("conn_type", x.b(this.b));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", "3.4.1.2");
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.downloadnew.a.a());
            jSONObject.put("package_name", aj.e());
            if (!aj.a()) {
                i = 2;
            }
            jSONObject.put("position", i);
            jSONObject.put("app_version", aj.g());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("app_id", i.d().f());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str = "";
            if (i.d().f() != null) {
                str = i.d().f().concat(String.valueOf(currentTimeMillis)).concat("3.4.1.2");
            }
            jSONObject.put("req_sign", j.a(str));
            u.c("isApplicationForeground", "app_version:" + aj.g() + "，vendor:" + Build.MANUFACTURER);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    private JSONObject a(JSONObject jSONObject) {
        return e ? aj.a(jSONObject) : jSONObject;
    }
}
