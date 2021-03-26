package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

public class fd extends fe {
    private String c = null;
    private String d = null;
    private String e;
    private String f;
    private String g;
    private String h;
    private boolean i = false;
    private String j;
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private boolean o = false;

    public fd() {
    }

    public fd(Bundle bundle) {
        super(bundle);
        this.c = bundle.getString("ext_msg_type");
        this.e = bundle.getString("ext_msg_lang");
        this.d = bundle.getString("ext_msg_thread");
        this.f = bundle.getString("ext_msg_sub");
        this.g = bundle.getString("ext_msg_body");
        this.h = bundle.getString("ext_body_encode");
        this.j = bundle.getString("ext_msg_appid");
        this.i = bundle.getBoolean("ext_msg_trans", false);
        this.o = bundle.getBoolean("ext_msg_encrypt", false);
        this.k = bundle.getString("ext_msg_seq");
        this.l = bundle.getString("ext_msg_mseq");
        this.m = bundle.getString("ext_msg_fseq");
        this.n = bundle.getString("ext_msg_status");
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(String str, String str2) {
        this.g = str;
        this.h = str2;
    }

    public void a(boolean z) {
        this.i = z;
    }

    @Override // com.xiaomi.push.fe
    public Bundle b() {
        Bundle b = super.b();
        if (!TextUtils.isEmpty(this.c)) {
            b.putString("ext_msg_type", this.c);
        }
        String str = this.e;
        if (str != null) {
            b.putString("ext_msg_lang", str);
        }
        String str2 = this.f;
        if (str2 != null) {
            b.putString("ext_msg_sub", str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            b.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.h)) {
            b.putString("ext_body_encode", this.h);
        }
        String str4 = this.d;
        if (str4 != null) {
            b.putString("ext_msg_thread", str4);
        }
        String str5 = this.j;
        if (str5 != null) {
            b.putString("ext_msg_appid", str5);
        }
        if (this.i) {
            b.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.k)) {
            b.putString("ext_msg_seq", this.k);
        }
        if (!TextUtils.isEmpty(this.l)) {
            b.putString("ext_msg_mseq", this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            b.putString("ext_msg_fseq", this.m);
        }
        if (this.o) {
            b.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.n)) {
            b.putString("ext_msg_status", this.n);
        }
        return b;
    }

    public void b(String str) {
        this.k = str;
    }

    public void b(boolean z) {
        this.o = z;
    }

    @Override // com.xiaomi.push.fe
    public String c() {
        fi p;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (t() != null) {
            sb.append(" xmlns=\"");
            sb.append(t());
            sb.append("\"");
        }
        if (this.e != null) {
            sb.append(" xml:lang=\"");
            sb.append(i());
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" id=\"");
            sb.append(k());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" to=\"");
            sb.append(fp.a(m()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" seq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" mseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" fseq=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(h())) {
            sb.append(" status=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (n() != null) {
            sb.append(" from=\"");
            sb.append(fp.a(n()));
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" chid=\"");
            sb.append(fp.a(l()));
            sb.append("\"");
        }
        if (this.i) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.j)) {
            sb.append(" appid=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(" type=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        if (this.o) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f != null) {
            sb.append("<subject>");
            sb.append(fp.a(this.f));
            sb.append("</subject>");
        }
        if (this.g != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.h)) {
                sb.append(" encode=\"");
                sb.append(this.h);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(fp.a(this.g));
            sb.append("</body>");
        }
        if (this.d != null) {
            sb.append("<thread>");
            sb.append(this.d);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.c) && (p = p()) != null) {
            sb.append(p.b());
        }
        sb.append(s());
        sb.append("</message>");
        return sb.toString();
    }

    public void c(String str) {
        this.l = str;
    }

    public String d() {
        return this.j;
    }

    public void d(String str) {
        this.m = str;
    }

    public String e() {
        return this.k;
    }

    public void e(String str) {
        this.n = str;
    }

    @Override // com.xiaomi.push.fe
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fd fdVar = (fd) obj;
        if (!super.equals(fdVar)) {
            return false;
        }
        String str = this.g;
        if (str == null ? fdVar.g != null : !str.equals(fdVar.g)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? fdVar.e != null : !str2.equals(fdVar.e)) {
            return false;
        }
        String str3 = this.f;
        if (str3 == null ? fdVar.f != null : !str3.equals(fdVar.f)) {
            return false;
        }
        String str4 = this.d;
        if (str4 == null ? fdVar.d == null : str4.equals(fdVar.d)) {
            return this.c == fdVar.c;
        }
        return false;
    }

    public String f() {
        return this.l;
    }

    public void f(String str) {
        this.c = str;
    }

    public String g() {
        return this.m;
    }

    public void g(String str) {
        this.f = str;
    }

    public String h() {
        return this.n;
    }

    public void h(String str) {
        this.g = str;
    }

    @Override // com.xiaomi.push.fe
    public int hashCode() {
        String str = this.c;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public String i() {
        return this.e;
    }

    public void i(String str) {
        this.d = str;
    }

    public void j(String str) {
        this.e = str;
    }
}
