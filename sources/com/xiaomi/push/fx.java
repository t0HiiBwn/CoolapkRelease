package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class fx extends fz {
    private a a = a.a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f488a = new HashMap();

    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f489a;

        private a(String str) {
            this.f489a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f489a;
        }
    }

    public fx() {
    }

    public fx(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.fz
    /* renamed from: a */
    public Bundle mo349a() {
        Bundle a2 = super.mo349a();
        a aVar = this.a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.fz
    /* renamed from: a  reason: collision with other method in class */
    public a mo349a() {
        return this.a;
    }

    @Override // com.xiaomi.push.fz
    /* renamed from: a */
    public String mo349a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(gk.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(gk.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(gk.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f488a.entrySet()) {
            sb.append(gk.a(entry.getKey()));
            sb.append("=\"");
            sb.append(gk.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(mo349a());
            str = "\">";
        }
        sb.append(str);
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        gd a2 = mo349a();
        if (a2 != null) {
            sb.append(a2.m362a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.a;
        }
        this.a = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.f488a.putAll(map);
    }

    @Override // com.xiaomi.push.fz
    public String b() {
        return null;
    }
}
