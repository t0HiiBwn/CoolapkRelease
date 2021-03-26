package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.ad;
import com.amap.api.col.s.bj;
import org.json.JSONObject;

/* compiled from: ManifestConfig */
public final class q {
    public static br a;
    private static q b;
    private static Context c;
    private a d;
    private HandlerThread e = new HandlerThread("manifestThread") {
        /* class com.amap.api.col.s.q.AnonymousClass1 */

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            br a2 = h.a(false);
            q.b(q.c);
            bj.a(q.c, a2, "11K;001;184;185", new bj.a() {
                /* class com.amap.api.col.s.q.AnonymousClass1.AnonymousClass1 */

                @Override // com.amap.api.col.s.bj.a
                public final void a(bj.b bVar) {
                    JSONObject optJSONObject;
                    JSONObject optJSONObject2;
                    Message message = new Message();
                    if (bVar != null) {
                        try {
                            if (bVar.g != null) {
                                message.obj = new r(bVar.g.b, bVar.g.a);
                            }
                        } catch (Throwable th) {
                            message.what = 3;
                            if (q.this.d != null) {
                                q.this.d.sendMessage(message);
                            }
                            throw th;
                        }
                    }
                    if (!(bVar == null || bVar.f == null || (optJSONObject2 = bVar.f.optJSONObject("184")) == null)) {
                        q.d(optJSONObject2);
                        al.a(q.c, "amap_search", "cache_control", optJSONObject2.toString());
                    }
                    if (!(bVar == null || bVar.f == null || (optJSONObject = bVar.f.optJSONObject("185")) == null)) {
                        q.c(optJSONObject);
                        al.a(q.c, "amap_search", "parm_control", optJSONObject.toString());
                    }
                    message.what = 3;
                    if (q.this.d == null) {
                        return;
                    }
                    q.this.d.sendMessage(message);
                }
            });
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private q(Context context) {
        c = context;
        a = h.a(false);
        try {
            ac.a();
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            i.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static q a(Context context) {
        if (b == null) {
            b = new q(context);
        }
        return b;
    }

    /* access modifiers changed from: private */
    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a2 = bj.a(jSONObject.optString("passAreaAble"), true);
                boolean a3 = bj.a(jSONObject.optString("truckAble"), true);
                boolean a4 = bj.a(jSONObject.optString("poiPageAble"), true);
                boolean a5 = bj.a(jSONObject.optString("rideAble"), true);
                boolean a6 = bj.a(jSONObject.optString("walkAble"), true);
                boolean a7 = bj.a(jSONObject.optString("passPointAble"), true);
                boolean a8 = bj.a(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", 1200);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                ag.a().a = a2;
                ag.a().j = optInt2;
                ag.a().p = optInt8;
                ag.a().q = optInt9;
                ag.a().c = a3;
                ag.a().n = optInt6;
                ag.a().d = a4;
                ag.a().m = optInt5;
                ag.a().h = optInt;
                ag.a().i = optInt10;
                ag.a().b = a8;
                ag.a().e = a5;
                ag.a().o = optInt7;
                ag.a().f = a6;
                ag.a().k = optInt3;
                ag.a().g = a7;
                ag.a().f1198l = optInt4;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    ad.a a2 = a(jSONObject, true, (ad.a) null);
                    ad.a().a(a2);
                    if (a2.a()) {
                        a("regeo", jSONObject, a2);
                        a("geo", jSONObject, a2);
                        a("placeText", jSONObject, a2);
                        a("placeAround", jSONObject, a2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(String str, JSONObject jSONObject, ad.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            ad.a().a(str, a(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private static ad.a a(JSONObject jSONObject, boolean z, ad.a aVar) {
        Throwable th;
        boolean z2;
        ad.a aVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            ad.a aVar3 = new ad.a();
            boolean z3 = false;
            if (z) {
                try {
                    String optString = jSONObject.optString("able");
                    if (aVar == null || aVar.a()) {
                        z3 = true;
                    }
                    z2 = bj.a(optString, z3);
                } catch (Throwable th2) {
                    th = th2;
                    aVar2 = aVar3;
                    th.printStackTrace();
                    return aVar2;
                }
            } else {
                if (aVar == null || aVar.a()) {
                    z3 = true;
                }
                z2 = jSONObject.optBoolean("able", z3);
            }
            int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.b() : 86400);
            int optInt2 = jSONObject.optInt("num", aVar != null ? aVar.c() : 10);
            double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.d() : 0.0d);
            aVar3.a(z2);
            aVar3.a((long) optInt);
            aVar3.a(optInt2);
            aVar3.a(optDouble);
            return aVar3;
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return aVar2;
        }
    }

    /* compiled from: ManifestConfig */
    class a extends Handler {
        String a = "handleMessage";

        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    r rVar = (r) message.obj;
                    if (rVar == null) {
                        rVar = new r(false, false);
                    }
                    cg.a(q.c, h.a(rVar.a()));
                    q.a = h.a(rVar.a());
                } catch (Throwable th) {
                    i.a(th, "ManifestConfig", this.a);
                }
            }
        }
    }

    static /* synthetic */ void b(Context context) {
        try {
            String str = (String) al.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                d(new JSONObject(str));
            }
            String str2 = (String) al.b(context, "amap_search", "parm_control", "");
            if (!TextUtils.isEmpty(str2)) {
                c(new JSONObject(str2));
            }
        } catch (Throwable th) {
            i.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }
}
