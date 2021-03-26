package com.amap.api.mapcore2d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@du(a = "a")
/* compiled from: SDKInfo */
public class da {
    @dv(a = "a1", b = 6)
    private String a;
    @dv(a = "a2", b = 6)
    private String b;
    @dv(a = "a6", b = 2)
    private int c;
    @dv(a = "a3", b = 6)
    private String d;
    @dv(a = "a4", b = 6)
    private String e;
    @dv(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    /* renamed from: l  reason: collision with root package name */
    private String[] f1231l;

    public static String h() {
        return "a6=1";
    }

    private da() {
        this.c = 1;
        this.f1231l = null;
    }

    private da(a aVar) {
        this.c = 1;
        this.f1231l = null;
        this.g = aVar.a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.f1231l = aVar.g;
        this.b = db.b(this.h);
        this.a = db.b(this.j);
        this.d = db.b(this.i);
        this.e = db.b(a(this.f1231l));
        this.f = db.b(this.k);
    }

    /* compiled from: SDKInfo */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e = true;
        private String f = "standard";
        private String[] g = null;

        public a(String str, String str2, String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public a a(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public da a() throws cp {
            if (this.g != null) {
                return new da(this);
            }
            throw new cp("sdk packages is null");
        }
    }

    public void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a)) {
            this.j = db.c(this.a);
        }
        return this.j;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = db.c(this.b);
        }
        return this.h;
    }

    public String d() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.d)) {
            this.i = db.c(this.d);
        }
        return this.i;
    }

    public String e() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = db.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "standard";
        }
        return this.k;
    }

    public boolean f() {
        return this.c == 1;
    }

    public String[] g() {
        String[] strArr = this.f1231l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.f1231l = b(db.c(this.e));
        }
        return (String[]) this.f1231l.clone();
    }

    private String[] b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", db.b(str));
        return dt.a((Map<String, String>) hashMap);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() == obj.getClass() && hashCode() == ((da) obj).hashCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        dk dkVar = new dk();
        dkVar.a(this.j).a(this.g).a(this.h).a((Object[]) this.f1231l);
        return dkVar.a();
    }
}
