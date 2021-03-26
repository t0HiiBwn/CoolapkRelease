package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class fc extends fe {
    private a c = a.a;
    private final Map<String, String> d = new HashMap();

    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a("command");
        private String f;

        private a(String str) {
            this.f = str;
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
            return this.f;
        }
    }

    public fc() {
    }

    public fc(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.c = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public a a() {
        return this.c;
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.a;
        }
        this.c = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.d.putAll(map);
    }

    @Override // com.xiaomi.push.fe
    public Bundle b() {
        Bundle b = super.b();
        a aVar = this.c;
        if (aVar != null) {
            b.putString("ext_iq_type", aVar.toString());
        }
        return b;
    }

    @Override // com.xiaomi.push.fe
    public String c() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (k() != null) {
            sb.append("id=\"" + k() + "\" ");
        }
        if (m() != null) {
            sb.append("to=\"");
            sb.append(fp.a(m()));
            sb.append("\" ");
        }
        if (n() != null) {
            sb.append("from=\"");
            sb.append(fp.a(n()));
            sb.append("\" ");
        }
        if (l() != null) {
            sb.append("chid=\"");
            sb.append(fp.a(l()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.d.entrySet()) {
            sb.append(fp.a(entry.getKey()));
            sb.append("=\"");
            sb.append(fp.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.c == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(a());
            str = "\">";
        }
        sb.append(str);
        String d2 = d();
        if (d2 != null) {
            sb.append(d2);
        }
        sb.append(s());
        fi p = p();
        if (p != null) {
            sb.append(p.b());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public String d() {
        return null;
    }
}
