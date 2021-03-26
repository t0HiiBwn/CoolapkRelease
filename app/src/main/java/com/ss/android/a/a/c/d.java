package com.ss.android.a.a.c;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DownloadEventModel */
public class d {
    private String a;
    private final String b;
    private final String c;
    private final boolean d;
    private final long e;
    private final String f;
    private final long g;
    private final JSONObject h;
    private final JSONObject i;
    private final List<String> j;
    private final int k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f1392l;
    private final String m;
    private final boolean n;
    private final String o;
    private final JSONObject p;

    d(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.k;
        this.k = aVar.f1393l;
        this.f1392l = aVar.m;
        this.n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.m = aVar.n;
    }

    /* compiled from: DownloadEventModel */
    public static class a {
        private String a;
        private String b;
        private String c;
        private boolean d = false;
        private long e;
        private String f;
        private long g;
        private JSONObject h;
        private JSONObject i;
        private Map<String, Object> j;
        private List<String> k;

        /* renamed from: l  reason: collision with root package name */
        private int f1393l;
        private Object m;
        private String n;
        private boolean o = false;
        private String p;
        private JSONObject q;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(long j2) {
            this.e = j2;
            return this;
        }

        public a b(long j2) {
            this.g = j2;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a b(boolean z) {
            this.d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.k = list;
            return this;
        }

        public a a(int i2) {
            this.f1393l = i2;
            return this;
        }

        public a a(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public d a() {
            if (TextUtils.isEmpty(this.a)) {
                this.a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                Map<String, Object> map = this.j;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.h.has(entry.getKey())) {
                            this.h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.h.get(next));
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.b);
                    this.q.put("value", this.e);
                    this.q.put("ext_value", this.g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    JSONObject jSONObject2 = this.i;
                    if (jSONObject2 != null) {
                        this.q = com.ss.android.a.a.d.a.a(jSONObject2, this.q);
                    }
                    if (this.d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f)) {
                            this.q.put("log_extra", this.f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.d) {
                    jSONObject.put("ad_extra_data", this.h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f)) {
                        jSONObject.put("log_extra", this.f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                JSONObject jSONObject3 = this.i;
                if (jSONObject3 != null) {
                    jSONObject = com.ss.android.a.a.d.a.a(jSONObject3, jSONObject);
                }
                this.h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public JSONObject d() {
        return this.h;
    }

    public boolean e() {
        return this.n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.a);
        sb.append("\ttag: ");
        sb.append(this.b);
        sb.append("\tlabel: ");
        sb.append(this.c);
        sb.append("\nisAd: ");
        sb.append(this.d);
        sb.append("\tadId: ");
        sb.append(this.e);
        sb.append("\tlogExtra: ");
        sb.append(this.f);
        sb.append("\textValue: ");
        sb.append(this.g);
        sb.append("\nextJson: ");
        sb.append(this.h);
        sb.append("\nparamsJson: ");
        sb.append(this.i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.j;
        String str = "";
        sb.append(list != null ? list.toString() : str);
        sb.append("\teventSource: ");
        sb.append(this.k);
        sb.append("\textraObject: ");
        Object obj = this.f1392l;
        sb.append(obj != null ? obj.toString() : str);
        sb.append("\nisV3: ");
        sb.append(this.n);
        sb.append("\tV3EventName: ");
        sb.append(this.o);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.p;
        if (jSONObject != null) {
            str = jSONObject.toString();
        }
        sb.append(str);
        return sb.toString();
    }
}
