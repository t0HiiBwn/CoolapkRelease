package com.bytedance.sdk.openadsdk.core.d;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TempPkgModel */
public class q {
    private String a;
    private String b;
    private String c;
    private String d;
    private List<a> e;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public List<a> e() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        return this.e;
    }

    public void a(List<a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.e = list;
    }

    public boolean f() {
        return (c() == null || b() == null || a() == null) ? false : true;
    }

    public String g() {
        if (!f()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", a());
            jSONObject.putOpt("version", b());
            jSONObject.putOpt("main", c());
            jSONObject.putOpt("fallback", d());
            JSONArray jSONArray = new JSONArray();
            if (e() != null) {
                for (a aVar : e()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", aVar.a());
                    jSONObject2.putOpt("md5", aVar.b());
                    jSONObject2.putOpt("level", Integer.valueOf(aVar.c()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* compiled from: TempPkgModel */
    public static class a {
        private String a;
        private String b;
        private int c;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            String str = this.a;
            return str != null && str.equals(((a) obj).a());
        }

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public int c() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }
    }

    public static q e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static q a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            q qVar = new q();
            try {
                qVar.a(jSONObject.getString("name"));
                qVar.b(jSONObject.getString("version"));
                qVar.c(jSONObject.getString("main"));
                String string = jSONObject.getString("fallback");
                qVar.d(string);
                com.bytedance.sdk.openadsdk.core.dynamic.c.a.a(string);
                JSONArray jSONArray = jSONObject.getJSONArray("resources");
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.a(jSONObject2.getString("url"));
                        aVar.b(jSONObject2.getString("md5"));
                        aVar.a(jSONObject2.getInt("level"));
                        arrayList.add(aVar);
                    }
                }
                qVar.a(arrayList);
                if (!qVar.f()) {
                    return null;
                }
            } catch (Throwable unused) {
            }
            return qVar;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
