package com.tencent.android.tpush.b;

import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class e extends a {
    private int d = 0;
    private int e = 1;
    private int f = 1;
    private int g = 1;
    private int h = 0;
    private int i = 0;
    private String j = "";
    private int k = 1;
    private String l = "";
    private String m = "";
    private int n = 0;
    private int o = 0;
    private String p = "";
    private String q = "";
    private String r = "";
    private int s = 2;
    private String t = "";
    private a u = new a();
    private int v = -1;
    private String w = "";
    private String x = "";
    private int y = 0;

    @Override // com.tencent.android.tpush.b.a
    public int b() {
        return 1;
    }

    public e(String str) {
        super(str);
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int i() {
        return this.f;
    }

    public int j() {
        return this.g;
    }

    public int k() {
        return this.h;
    }

    public a l() {
        return this.u;
    }

    public int m() {
        return this.i;
    }

    public String n() {
        return this.r;
    }

    public String o() {
        return this.t;
    }

    public int p() {
        return this.k;
    }

    public String q() {
        return this.l;
    }

    public String r() {
        return this.j;
    }

    public String s() {
        return this.m;
    }

    public int t() {
        return this.n;
    }

    public int u() {
        return this.o;
    }

    public String v() {
        return this.p;
    }

    public String w() {
        return this.q;
    }

    public int x() {
        return this.s;
    }

    public int y() {
        return this.v;
    }

    public String z() {
        return this.w;
    }

    public String A() {
        return this.x;
    }

    public int B() {
        return this.y;
    }

    @Override // com.tencent.android.tpush.b.a
    protected void c() {
        this.d = this.a.optInt("builder_id");
        this.e = this.a.optInt("ring", 1);
        this.l = this.a.optString("ring_raw");
        this.j = this.a.optString("icon_res");
        this.m = this.a.optString("small_icon");
        this.k = this.a.optInt("lights", 1);
        this.f = this.a.optInt("vibrate", 1);
        this.i = this.a.optInt("icon");
        this.n = this.a.optInt("icon_type", 0);
        this.h = this.a.optInt("n_id");
        this.o = this.a.optInt("style_id", 0);
        this.r = this.a.optString("xg_media_resources", null);
        this.t = this.a.optString("xg_media_audio_resources", null);
        this.p = this.a.optString("n_ch_id");
        this.q = this.a.optString("n_ch_name");
        this.s = this.a.optInt("is_show_type", 2);
        this.y = this.a.optInt("color", 0);
        if (!this.a.isNull("clearable")) {
            this.g = this.a.optInt("clearable");
        } else {
            this.g = 1;
        }
        if (!this.a.isNull("action")) {
            this.u.a(this.a.getString("action"));
        }
        this.v = this.a.optInt("badge_type", -1);
        this.w = this.a.optString("thread_id");
        this.x = this.a.optString("thread_sumtext");
    }

    /* compiled from: ProGuard */
    public static class a {
        public int a = NotificationAction.activity.getType();
        public String b = "";
        public C0130a c = new C0130a();
        public String d = "";
        public String e = "";
        public String f = "";
        public int g = 0;
        public String h = "";
        public String i = "";
        public String j = "";

        /* renamed from: com.tencent.android.tpush.b.e$a$a  reason: collision with other inner class name */
        /* compiled from: ProGuard */
        public static class C0130a {
            public int a = 0;
            public int b = 0;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("action_type")) {
                this.a = jSONObject.getInt("action_type");
            }
            if (!jSONObject.isNull("activity")) {
                this.b = jSONObject.getString("activity");
            }
            if (!jSONObject.isNull("aty_attr")) {
                String optString = jSONObject.optString("aty_attr");
                if (!j.b(optString)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        this.c.a = jSONObject2.optInt("if");
                        this.c.b = jSONObject2.optInt("pf");
                    } catch (Throwable th) {
                        TLogger.e("PushMessageAction", "decode activityAttribute error", th);
                    }
                }
            }
            if (!jSONObject.isNull("intent")) {
                this.d = jSONObject.getString("intent");
            }
            if (!jSONObject.isNull("browser")) {
                this.e = jSONObject.getString("browser");
                JSONObject jSONObject3 = new JSONObject(this.e);
                if (!jSONObject3.isNull("url")) {
                    this.f = jSONObject3.getString("url");
                }
                if (!jSONObject3.isNull("confirm")) {
                    this.g = jSONObject3.getInt("confirm");
                }
            }
            if (!jSONObject.isNull("package_name")) {
                this.i = jSONObject.getString("package_name");
                JSONObject jSONObject4 = new JSONObject(this.i);
                if (!jSONObject4.isNull("packageDownloadUrl")) {
                    this.j = jSONObject4.getString("packageDownloadUrl");
                }
                if (!jSONObject4.isNull("packageName")) {
                    this.h = jSONObject4.getString("packageName");
                }
                if (!jSONObject4.isNull("confirm")) {
                    this.g = jSONObject4.getInt("confirm");
                }
            }
        }
    }
}
