package com.ss.android.downloadlib.h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.ss.android.a.a.a.p;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.g;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.d;
import com.ss.android.socialbase.appdownloader.f.b;
import com.ss.android.socialbase.appdownloader.f.c;
import com.ss.android.socialbase.downloader.g.a;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OpenAppUtils */
public class h {
    public static g a(Context context, Uri uri) {
        if (context == null || uri == null || !"market".equals(uri.getScheme())) {
            return new g(6, 12);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!k.a(context, intent)) {
                return new g(6, 13);
            }
            String i = c.i();
            if (k.d(context, i) && !c.f()) {
                intent.setPackage(i);
            }
            if (a.c().a("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new g(5);
        } catch (Exception unused) {
            return new g(6, 14);
        }
    }

    public static g a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new g(6, 11);
        }
        if (c.f() && k.d(context, "com.sec.android.app.samsungapps")) {
            return d(context, str);
        }
        return a(context, Uri.parse("market://details?id=" + str));
    }

    public static g a(Context context, e eVar, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new g(6, 11);
        }
        if (c.f() && k.d(context, "com.sec.android.app.samsungapps")) {
            return d(context, str);
        }
        if (!eVar.b.t()) {
            return a(context, Uri.parse("market://details?id=" + str));
        }
        JSONArray optJSONArray = k.i().optJSONArray("am_plans");
        if (c.b() && com.ss.android.downloadlib.a.a.a(optJSONArray, "am_0")) {
            b(context, eVar, str);
            return new g(7, "am_m1");
        } else if (c.d() && com.ss.android.downloadlib.a.a.a(optJSONArray, "am_3")) {
            return c(context, eVar, str);
        } else {
            if (c.e() && com.ss.android.downloadlib.a.a.a(optJSONArray, "am_2")) {
                d(context, eVar, str);
                return new g(7, "am_m2");
            } else if (c.a() && com.ss.android.downloadlib.a.a.a(optJSONArray, "am_4")) {
                return e(context, eVar, str);
            } else {
                return a(context, Uri.parse("market://details?id=" + str));
            }
        }
    }

    private static g d(Context context, String str) {
        try {
            Uri parse = Uri.parse("http://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new g(5);
        } catch (Exception unused) {
            return new g(6, 14);
        }
    }

    private static void b(final Context context, final e eVar, final String str) {
        d.a().a(new Runnable() {
            /* class com.ss.android.downloadlib.h.h.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                final JSONObject i = k.i();
                final String optString = i.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String a2 = b.a(i.optString("x"), optString);
                if (k.e() == null) {
                    Context context = context;
                    h.a(context, Uri.parse("market://details?id=" + str));
                    k.a(jSONObject, "error_code", (Object) 5);
                    k.a(jSONObject, "ttdownloader_type", (Object) 1);
                    com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                k.a(jSONObject2, "p", str);
                k.a(jSONObject2, "i", Build.VERSION.INCREMENTAL);
                k.a(jSONObject2, "m", Build.MODEL);
                k.a(jSONObject2, "im", com.ss.android.downloadlib.a.b.b.a(context));
                k.a(jSONObject2, "d", com.ss.android.downloadlib.a.b.b.b(context));
                k.a(jSONObject2, "t", "m");
                byte[] bytes = jSONObject2.toString().getBytes();
                k.e().a(a2, EncryptorUtil.a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new p() {
                    /* class com.ss.android.downloadlib.h.h.AnonymousClass1.AnonymousClass1 */

                    @Override // com.ss.android.a.a.a.p
                    public void a(String str) {
                        h.b(context, str, str, eVar, true, jSONObject, i, optString);
                    }

                    @Override // com.ss.android.a.a.a.p
                    public void a(Throwable th) {
                        Context context = context;
                        h.a(context, Uri.parse("market://details?id=" + str));
                        k.a(jSONObject, "error_code", (Object) 4);
                        k.a(jSONObject, "ttdownloader_type", (Object) 1);
                        com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
                    }
                });
            }
        });
    }

    private static String a(String str, JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a = b.a(jSONObject.optString("g"), str2);
        String a2 = b.a(jSONObject.optString("h"), str2);
        return (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) ? str : str.replace(a, a2);
    }

    private static g c(Context context, e eVar, String str) {
        Intent intent = new Intent(context, JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", eVar.a);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new g(7, "am_kllk2");
        } catch (Throwable unused) {
            k.a(jSONObject, "error_code", (Object) 1);
            k.a(jSONObject, c.i(), Integer.valueOf(k.b(context, c.i())));
            k.a(jSONObject, "ttdownloader_type", (Object) 4);
            com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
            return a(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static void a(Context context, String str, long j, boolean z) {
        boolean z2;
        Throwable th;
        Boolean bool;
        JSONObject jSONObject = new JSONObject();
        e e = f.a().e(j);
        try {
            JSONObject i = k.i();
            String optString = i.optString("s");
            String a = b.a(i.optString("aa"), optString);
            String a2 = b.a(i.optString("ac"), optString);
            String a3 = b.a(i.optString("af"), optString);
            boolean e2 = e(context, a2);
            try {
                StringBuilder sb = new StringBuilder(String.format(a, str, a3, a2));
                Intent intent = new Intent("android.intent.action.VIEW");
                String i2 = c.i();
                if (k.d(context, i2)) {
                    intent.setPackage(i2);
                }
                if (z) {
                    sb.append(b.a(i.optString("ae"), optString));
                } else {
                    intent.addFlags(335544320);
                }
                intent.setData(Uri.parse(sb.toString()));
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                com.ss.android.downloadlib.b.a.a("am_kllk2", jSONObject, e);
                k.a(jSONObject, "error_code", (Object) -1);
                k.a(jSONObject, "if", Boolean.valueOf(z));
                k.a(jSONObject, "ttdownloader_type", (Object) 4);
                bool = Boolean.valueOf(e2);
            } catch (Exception unused) {
                z2 = e2;
                try {
                    com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), e);
                    k.a(jSONObject, "error_code", (Object) 2);
                    k.a(jSONObject, "if", Boolean.valueOf(z));
                    k.a(jSONObject, "ttdownloader_type", (Object) 4);
                    bool = Boolean.valueOf(z2);
                    k.a(jSONObject, "mf", bool);
                    com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) e);
                } catch (Throwable th2) {
                    th = th2;
                    k.a(jSONObject, "if", Boolean.valueOf(z));
                    k.a(jSONObject, "ttdownloader_type", (Object) 4);
                    k.a(jSONObject, "mf", Boolean.valueOf(z2));
                    com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) e);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z2 = e2;
                k.a(jSONObject, "if", Boolean.valueOf(z));
                k.a(jSONObject, "ttdownloader_type", (Object) 4);
                k.a(jSONObject, "mf", Boolean.valueOf(z2));
                com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) e);
                throw th;
            }
        } catch (Exception unused2) {
            z2 = false;
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), e);
            k.a(jSONObject, "error_code", (Object) 2);
            k.a(jSONObject, "if", Boolean.valueOf(z));
            k.a(jSONObject, "ttdownloader_type", (Object) 4);
            bool = Boolean.valueOf(z2);
            k.a(jSONObject, "mf", bool);
            com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) e);
        } catch (Throwable th4) {
            th = th4;
            z2 = false;
            k.a(jSONObject, "if", Boolean.valueOf(z));
            k.a(jSONObject, "ttdownloader_type", (Object) 4);
            k.a(jSONObject, "mf", Boolean.valueOf(z2));
            com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) e);
            throw th;
        }
        k.a(jSONObject, "mf", bool);
        com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) e);
    }

    private static boolean e(Context context, String str) {
        JSONObject i = k.i();
        String optString = i.optString("s");
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                String a = b.a(i.optString("az"), optString);
                String a2 = b.a(i.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(a);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(a2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean f(Context context, String str) {
        if (context == null) {
            context = k.a();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
            if (a.c().a("fix_app_link_flag")) {
                intent.addFlags(32768);
            }
        }
        intent.setData(Uri.parse(str));
        intent.putExtra("start_only_for_android", true);
        String i = c.i();
        if (k.d(k.a(), i)) {
            intent.setPackage(i);
        }
        if (!k.a(k.a(), intent)) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, String str2, e eVar, boolean z, JSONObject jSONObject, JSONObject jSONObject2, String str3) {
        k.a(jSONObject, "ttdownloader_type", Integer.valueOf(z ? 1 : 2));
        try {
            String a = b.a(new JSONObject(str2).optString("a"));
            if (z) {
                a = a(a, jSONObject2, str3);
            }
            k.a(jSONObject, "open_url", a);
            if (f(context, a)) {
                k.a(jSONObject, "error_code", (Object) -2);
                com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
                com.ss.android.downloadlib.b.a.a(z ? "am_m1" : "am_m2", jSONObject, eVar);
                return;
            }
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar);
            k.a(jSONObject, "error_code", (Object) 2);
            com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse("market://details?id=" + str)), eVar);
            k.a(jSONObject, "error_code", (Object) 3);
            com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
        }
    }

    private static void d(final Context context, final e eVar, final String str) {
        d.a().a(new Runnable() {
            /* class com.ss.android.downloadlib.h.h.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                Context context = context;
                com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse("market://details?id=" + str)), eVar);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject i = k.i();
                    Thread.sleep((long) i.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.a.c.a.a().a(context, true);
                    com.ss.android.downloadlib.a.c.b bVar = new com.ss.android.downloadlib.a.c.b();
                    bVar.a = 1;
                    bVar.b = 0;
                    bVar.c = String.format(b.a(i.optString("v"), i.optString("s")), str);
                    com.ss.android.downloadlib.a.c.a.a().a(bVar, (com.ss.android.downloadlib.a.c.d) null);
                    com.ss.android.downloadlib.a.c.a.a().b();
                    k.a(jSONObject, "error_code", (Object) -1);
                } catch (Throwable th) {
                    k.a(jSONObject, "ttdownloader_type", (Object) 3);
                    com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
                    throw th;
                }
                k.a(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
            }
        });
    }

    private static g e(Context context, e eVar, String str) {
        JSONObject i = k.i();
        String optString = i.optString("s");
        String a = b.a(i, "ay", optString);
        JSONObject jSONObject = new JSONObject();
        k.a(jSONObject, "ttdownloader_type", (Object) 4);
        if (com.ss.android.downloadlib.a.a.c.a(context, str, a, i, optString)) {
            k.a(jSONObject, "error_code", (Object) -1);
            com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
            return new g(5, "am_hw");
        }
        k.a(jSONObject, "error_code", (Object) 1);
        com.ss.android.downloadlib.e.a.a().a("am_result", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
        return a(context, Uri.parse("market://details?id=" + str));
    }

    public static g b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new g(4, 11);
        }
        if (context == null) {
            context = k.a();
        }
        Intent f = k.f(context, str);
        if (f == null) {
            return new g(4, 22);
        }
        f.putExtra("start_only_for_android", true);
        try {
            context.startActivity(f);
            return new g(3);
        } catch (Exception unused) {
            return new g(4, 23);
        }
    }

    public static g a(Context context, String str, com.ss.android.downloadad.a.b.a aVar) {
        Intent f = k.f(context, str);
        if (f == null) {
            return new g(4, 22);
        }
        if (Build.VERSION.SDK_INT < 26 || k.i().optInt("open_package_mode") != 1 || k.k() == null || !k.k().a() || !aVar.q()) {
            f.putExtra("start_only_for_android", true);
            try {
                context.startActivity(f);
                return new g(3);
            } catch (Exception unused) {
                return new g(4, 23);
            }
        } else {
            TTDelegateActivity.b(str, aVar);
            return new g(3);
        }
    }

    public static g a(String str, com.ss.android.downloadad.a.b.a aVar) {
        return a(k.a(), str, aVar);
    }

    public static g b(String str, com.ss.android.downloadad.a.b.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return new g(2, 21);
        }
        Context a = k.a();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (a.c().a("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (!k.b(a, intent)) {
            return new g(2, 24);
        }
        if (k.i().optInt("open_url_mode") != 0 || k.k() == null || !k.k().a() || Build.VERSION.SDK_INT < 26 || !aVar.q()) {
            try {
                k.a().startActivity(intent);
            } catch (Exception unused) {
                return new g(2);
            }
        } else {
            TTDelegateActivity.a(str, aVar);
        }
        return new g(1);
    }

    public static g a(com.ss.android.downloadad.a.b.b bVar, String str, String str2) {
        g b = b(str, bVar);
        return (com.ss.android.downloadlib.b.f.a(bVar) && b.a() == 2) ? a(str2, bVar) : b;
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
