package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.c.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.c.c;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AdEventProviderImpl */
public class a implements com.bytedance.sdk.openadsdk.multipro.a {
    private Context a;

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "t_event_ad_event";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    private static ContentResolver e() {
        try {
            if (p.a() != null) {
                return p.a().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c() {
        if (p.a() != null) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "adEventStart"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z) {
        if (p.a() != null) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "logStatusStart" + ("?isRealTime=" + String.valueOf(z))));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            u.b("AdEventProviderImpl", "dispatch event");
            try {
                ContentResolver e = e();
                if (e != null) {
                    String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                    e.getType(Uri.parse(f() + "adEventDispatch?event=" + a2));
                }
            } catch (Throwable th) {
                u.f("AdEventProviderImpl", "dispatch event Throwable:" + th.toString());
            }
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str2 : list) {
                    sb.append(com.bytedance.sdk.openadsdk.multipro.c.a(str2));
                    sb.append(",");
                }
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(sb.toString());
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(a2) + "&replace=" + String.valueOf(z);
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "trackUrl" + str3));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "trackFailed?did=" + String.valueOf(str)));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void d() {
        try {
            ContentResolver e = e();
            if (e != null) {
                e.getType(Uri.parse(f() + "logStatusInit"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                    e.getType(Uri.parse(f() + "logStatusUpload?event=" + a2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "logStatusDispatch" + ("?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str) + "&isRealTime=" + String.valueOf(z))));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String f() {
        return e.b + "/t_event_ad_event/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("adEventStart".equals(str)) {
            u.b("AdEventProviderImpl", "====ad event function will be start====");
            b.a().a();
        } else if ("logStatusStart".equals(str)) {
            u.b("AdEventProviderImpl", "====log stats function will be start====");
            if (Boolean.valueOf(uri.getQueryParameter("isRealTime")).booleanValue()) {
                b.c().a();
            } else {
                b.b().a();
            }
        } else if ("adEventDispatch".equals(str)) {
            u.b("AdEventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
            com.bytedance.sdk.openadsdk.c.a a2 = com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (a2 != null) {
                b.a().a(a2);
            }
        } else if ("logStatusDispatch".equals(str)) {
            Boolean valueOf = Boolean.valueOf(uri.getQueryParameter("isRealTime"));
            c.a a3 = c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (a3 == null) {
                return null;
            }
            if (valueOf.booleanValue()) {
                b.c().a(a3);
            } else {
                b.b().a(a3);
            }
        } else if ("trackUrl".equals(str)) {
            try {
                String queryParameter = uri.getQueryParameter("did");
                boolean booleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                String[] split = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("track")).split(",");
                if (split.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : split) {
                        String b2 = com.bytedance.sdk.openadsdk.multipro.c.b(str2);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                        }
                    }
                    d.a().a(queryParameter, arrayList, booleanValue);
                }
            } catch (Throwable unused) {
            }
        } else if ("trackFailed".equals(str)) {
            String queryParameter2 = uri.getQueryParameter("did");
            d.a().a(queryParameter2);
            u.b("AdEventProviderImpl", "track failed: " + String.valueOf(queryParameter2));
        } else if ("logStatusInit".equals(str)) {
            c.a().a();
        } else if ("logStatusUpload".equals(str)) {
            String b3 = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event"));
            if (!TextUtils.isEmpty(b3)) {
                c.a().a(C0060a.b(b3));
            }
        }
        return null;
    }

    /* compiled from: AdEventProviderImpl */
    private static class b {
        private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a;
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> b;
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> c;

        static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a() {
            if (a == null) {
                synchronized (p.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.c.b<>(new f(p.a()), p.f(), g.b.a(), d());
                    }
                }
            }
            return a;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> b() {
            if (c == null) {
                synchronized (p.class) {
                    if (c == null) {
                        c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
            return c;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> c() {
            if (b == null) {
                synchronized (p.class) {
                    if (b == null) {
                        b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
            return b;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
            com.bytedance.sdk.openadsdk.c.e eVar;
            g.b bVar;
            if (z) {
                eVar = new n(p.a());
                bVar = g.b.a();
            } else {
                bVar = g.b.b();
                eVar = new l(p.a());
            }
            g.a d = d();
            return new com.bytedance.sdk.openadsdk.c.b<>(eVar, null, bVar, d, new o(str, str2, eVar, null, bVar, d));
        }

        private static g.a d() {
            return new g.a() {
                /* class com.bytedance.sdk.openadsdk.multipro.c.a.b.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.c.g.a
                public boolean a() {
                    return x.a(p.a());
                }
            };
        }
    }

    /* compiled from: AdEventProviderImpl */
    private static class d {
        private static volatile com.bytedance.sdk.openadsdk.k.a a;

        public static com.bytedance.sdk.openadsdk.k.a a() {
            if (a == null) {
                synchronized (com.bytedance.sdk.openadsdk.k.a.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.k.b(p.a(), new com.bytedance.sdk.openadsdk.k.g(p.a()));
                    }
                }
            }
            return a;
        }
    }

    /* compiled from: AdEventProviderImpl */
    private static class c {
        private static volatile com.bytedance.sdk.openadsdk.g.c.c a;

        public static com.bytedance.sdk.openadsdk.g.c.c a() {
            if (a == null) {
                synchronized (com.bytedance.sdk.openadsdk.g.c.c.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.g.c.c();
                    }
                }
            }
            return a;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a  reason: collision with other inner class name */
    /* compiled from: AdEventProviderImpl */
    private static class C0060a implements com.bytedance.sdk.openadsdk.g.a.a {
        JSONObject a;

        /* access modifiers changed from: private */
        public static C0060a b(String str) {
            return new C0060a(str);
        }

        private C0060a(String str) {
            try {
                this.a = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.a
        public JSONObject a() {
            return this.a;
        }
    }
}
