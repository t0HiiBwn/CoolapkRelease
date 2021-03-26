package com.bytedance.sdk.openadsdk.core.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.sdk.adnet.b.f;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ApplistHelper */
public class b implements Runnable {
    private static volatile b a;
    private final Context b;
    private final a c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private boolean e = false;
    private Comparator<JSONObject> f = new Comparator<JSONObject>() {
        /* class com.bytedance.sdk.openadsdk.core.h.b.AnonymousClass1 */

        /* renamed from: a */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
        }
    };

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private b() {
        Context a2 = p.a();
        this.b = a2;
        this.c = new a(a2);
    }

    public void b() {
        this.e = p.h().D() && i.d().e().alist();
        if (f.d()) {
            if ((!ad.r() || Build.VERSION.SDK_INT < 29) && !this.d.get()) {
                this.d.set(true);
                try {
                    e.a(this, 1);
                } catch (Throwable th) {
                    u.a("ApplistHelper", "upload sdk applist error: ", th);
                    this.d.set(false);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3 A[Catch:{ all -> 0x00d5 }] */
    private List<JSONObject> b(Context context) {
        List list;
        String str;
        ApplicationInfo applicationInfo;
        ArrayList arrayList = new ArrayList();
        if (context != null && this.e) {
            try {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.core.a.b(C0043b.a("utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"), com.bytedance.sdk.openadsdk.core.b.a()));
                Object invoke = ah.a(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
                String optString = jSONObject.optString("pn");
                Object invoke2 = ah.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
                if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                    for (Object obj : list) {
                        if (obj instanceof PackageInfo) {
                            PackageInfo packageInfo = (PackageInfo) obj;
                            String str2 = "unknown";
                            if (packageInfo.applicationInfo != null) {
                                try {
                                    CharSequence charSequence = (CharSequence) ah.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
                                    if (!TextUtils.isEmpty(charSequence)) {
                                        str = charSequence.toString();
                                        applicationInfo = (ApplicationInfo) ah.a(optString, "getApplicationInfo", String.class, Integer.TYPE).invoke(invoke, packageInfo.packageName, 0);
                                        if (applicationInfo != null) {
                                            str2 = applicationInfo.sourceDir;
                                        }
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("package_name", packageInfo.packageName);
                                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                                        jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                                        jSONObject2.put("version_name", packageInfo.versionName);
                                        jSONObject2.put("version_code", packageInfo.versionCode);
                                        jSONObject2.put("app_name", str);
                                        jSONObject2.put("app_type", a(packageInfo));
                                        jSONObject2.put("apk_dir", str2);
                                        arrayList.add(jSONObject2);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                            str = str2;
                            try {
                                applicationInfo = (ApplicationInfo) ah.a(optString, "getApplicationInfo", String.class, Integer.TYPE).invoke(invoke, packageInfo.packageName, 0);
                                if (applicationInfo != null) {
                                }
                            } catch (Throwable unused2) {
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("package_name", packageInfo.packageName);
                            jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                            jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                            jSONObject2.put("version_name", packageInfo.versionName);
                            jSONObject2.put("version_code", packageInfo.versionCode);
                            jSONObject2.put("app_name", str);
                            jSONObject2.put("app_type", a(packageInfo));
                            jSONObject2.put("apk_dir", str2);
                            arrayList.add(jSONObject2);
                        }
                    }
                }
            } catch (Throwable th) {
                u.a("ApplistHelper", "get install apps error: ", th);
            }
        }
        return arrayList;
    }

    public List<String> a(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.core.a.b(C0043b.a("utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"), com.bytedance.sdk.openadsdk.core.b.a()));
            Object invoke = ah.a(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
            String optString = jSONObject.optString("pn");
            Object invoke2 = ah.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
            if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        String str = "unknown";
                        if (packageInfo.applicationInfo != null) {
                            try {
                                CharSequence charSequence = (CharSequence) ah.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
                                if (!TextUtils.isEmpty(charSequence)) {
                                    str = charSequence.toString();
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        if (a(packageInfo) != 1) {
                            arrayList.add(str + ":" + packageInfo.packageName);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            u.a("ApplistHelper", "loadApps error2: ", th);
        }
        return arrayList;
    }

    private int a(PackageInfo packageInfo) {
        if (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.b)) {
            this.d.set(false);
            return;
        }
        try {
            boolean c2 = this.c.c();
            if (c2) {
                long currentTimeMillis = System.currentTimeMillis();
                List<JSONObject> b2 = b(this.b);
                u.b("ApplistHelper", "get duration: " + (System.currentTimeMillis() - currentTimeMillis));
                a(b2, c2);
                return;
            }
            this.d.set(false);
        } catch (Throwable th) {
            this.d.set(false);
            u.c("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    private boolean a(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            u.b("ApplistHelper", "is app change true1");
            return false;
        }
        Collections.sort(list, this.f);
        String b2 = com.bytedance.sdk.openadsdk.core.a.b(this.c.b(), com.bytedance.sdk.openadsdk.core.b.a());
        if (TextUtils.isEmpty(b2)) {
            u.b("ApplistHelper", "is app change true2");
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(b2);
            int length = jSONArray.length();
            if (length == list.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getJSONObject(i));
                }
                Collections.sort(arrayList, this.f);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = list.get(i2);
                    JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                    String optString = jSONObject.optString("package_name");
                    String optString2 = jSONObject.optString("last_update_time");
                    if (!(optString == null || optString2 == null || !optString.equals(jSONObject2.optString("package_name")))) {
                        if (optString2.equals(jSONObject2.optString("last_update_time"))) {
                        }
                    }
                    u.b("ApplistHelper", "is app change true3");
                    return true;
                }
                u.b("ApplistHelper", "is app change false");
                return false;
            }
            u.b("ApplistHelper", "is app change true4");
            return true;
        } catch (Throwable th) {
            u.c("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void a(final List<JSONObject> list, final boolean z) throws JSONException {
        List<JSONObject> list2;
        if (k.d(this.b) == null && k.c(this.b) == null && k.a(this.b) == null && y.a() == null) {
            this.d.set(false);
            u.b("ApplistHelper", "real upload error1");
            return;
        }
        boolean a2 = a(list);
        List<String> A = p.h().A();
        List<String> C = p.h().C();
        if (a2 || ((A != null && !A.isEmpty()) || (C != null && !C.isEmpty()))) {
            if (a2) {
                list2 = list;
            } else {
                list2 = new ArrayList<>();
            }
            JSONObject a3 = aj.a(a(list2, A, C));
            StringBuilder sb = new StringBuilder();
            sb.append("param:");
            sb.append(list == null ? 0 : list.size());
            u.b("ApplistHelper", sb.toString());
            new f(1, aj.l("/api/ad/union/sdk/upload/app_info/"), a3, new m.a<JSONObject>() {
                /* class com.bytedance.sdk.openadsdk.core.h.b.AnonymousClass2 */

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<JSONObject> mVar) {
                    u.b("ApplistHelper", "real upload response");
                    if (mVar != null && mVar.a()) {
                        if (mVar.a == null || !"20000".equals(mVar.a.optString("status"))) {
                            u.b("ApplistHelper", "APP List upload failed !");
                        } else {
                            if (z) {
                                b.this.c.a();
                            }
                            b.this.c.a(com.bytedance.sdk.openadsdk.core.a.a(new JSONArray((Collection) list).toString(), com.bytedance.sdk.openadsdk.core.b.a()));
                            u.b("ApplistHelper", "APP List upload success ! " + mVar.e);
                        }
                    }
                    b.this.d.set(false);
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<JSONObject> mVar) {
                    if (mVar != null) {
                        u.c("ApplistHelper", "upload failed: code=" + mVar.h, mVar.c);
                    }
                    b.this.d.set(false);
                }
            }).setResponseOnMain(false).setShouldCache(false).build(d.a(this.b).d());
            return;
        }
        this.d.set(false);
        u.b("ApplistHelper", "real upload error2");
    }

    private JSONObject a(List<JSONObject> list, List<String> list2, List<String> list3) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        int i = -1;
        try {
            if (!TextUtils.isEmpty(k.d(this.b))) {
                obj = k.d(this.b);
                i = 1;
            } else {
                obj = "";
            }
            if (i < 0 && !TextUtils.isEmpty(y.a())) {
                i = 4;
                obj = y.a();
            }
            if (i < 0) {
                i = 3;
                obj = k.c(this.b);
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject2 : list) {
                jSONArray.put(jSONObject2.optString("package_name"));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", k.a(this.b));
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("app_id", i.d().f());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", "3.4.1.2");
            jSONObject.put("device_id_type", i);
            if (TextUtils.isEmpty(k.d(this.b))) {
                jSONObject.put("imei", "");
            } else {
                jSONObject.put("imei", k.d(this.b));
            }
            if (TextUtils.isEmpty(y.a())) {
                jSONObject.put("oaid", "");
            } else {
                jSONObject.put("oaid", y.a());
            }
            if (TextUtils.isEmpty(AppLog.getDid())) {
                jSONObject.put("applog_did", "");
            } else {
                jSONObject.put("applog_did", AppLog.getDid());
            }
            if (TextUtils.isEmpty(k.c(this.b))) {
                jSONObject.put("android_id", "");
            } else {
                jSONObject.put("android_id", k.c(this.b));
            }
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (aj.c(p.a(), str)) {
                                jSONArray2.put(str);
                            } else {
                                jSONArray3.put(str);
                            }
                        } catch (Throwable unused) {
                            jSONArray3.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray2);
                jSONObject.put("no_applist", jSONArray3);
            }
            if (list3 != null && !list3.isEmpty()) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (String str2 : list3) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Uri parse = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(parse);
                            if (aj.a(p.a(), intent)) {
                                jSONArray4.put(str2);
                            } else {
                                jSONArray5.put(str2);
                            }
                        } catch (Throwable unused2) {
                            jSONArray5.put(str2);
                        }
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }

    /* compiled from: ApplistHelper */
    class a {
        private final SharedPreferences b;

        a(Context context) {
            this.b = context.getSharedPreferences("tt_sp_app_list", 0);
        }

        void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "old_app_list", str);
                } else {
                    this.b.edit().putString("old_app_list", str).apply();
                }
            }
        }

        void a() {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", Long.valueOf(System.currentTimeMillis()));
            } else {
                this.b.edit().putLong("day_update_time", System.currentTimeMillis()).apply();
            }
        }

        String b() {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sp_app_list", "old_app_list", "");
            }
            return this.b.getString("old_app_list", "");
        }

        boolean c() {
            long j;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                j = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", 0L);
            } else {
                j = this.b.getLong("day_update_time", 0);
            }
            return !aj.a(j, System.currentTimeMillis());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.h.b$b  reason: collision with other inner class name */
    /* compiled from: ApplistHelper */
    private static class C0043b {
        static String a(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }
}
