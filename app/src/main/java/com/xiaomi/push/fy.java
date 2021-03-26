package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

public class fy extends fz {
    private boolean a = false;
    private String b = null;

    /* renamed from: b  reason: collision with other field name */
    private boolean f490b = false;
    private String c = null;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i = "";
    private String j = "";
    private String k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f1498l = "";

    public fy() {
    }

    public fy(Bundle bundle) {
        super(bundle);
        this.b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.a = bundle.getBoolean("ext_msg_trans", false);
        this.f490b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.f1498l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.fz
    /* renamed from: a */
    public Bundle mo349a() {
        Bundle a2 = super.mo349a();
        if (!TextUtils.isEmpty(this.b)) {
            a2.putString("ext_msg_type", this.b);
        }
        String str = this.d;
        if (str != null) {
            a2.putString("ext_msg_lang", str);
        }
        String str2 = this.e;
        if (str2 != null) {
            a2.putString("ext_msg_sub", str2);
        }
        String str3 = this.f;
        if (str3 != null) {
            a2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.g)) {
            a2.putString("ext_body_encode", this.g);
        }
        String str4 = this.c;
        if (str4 != null) {
            a2.putString("ext_msg_thread", str4);
        }
        String str5 = this.h;
        if (str5 != null) {
            a2.putString("ext_msg_appid", str5);
        }
        if (this.a) {
            a2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            a2.putString("ext_msg_seq", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            a2.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            a2.putString("ext_msg_fseq", this.k);
        }
        if (this.f490b) {
            a2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f1498l)) {
            a2.putString("ext_msg_status", this.f1498l);
        }
        return a2;
    }

    @Override // com.xiaomi.push.fz
    /* renamed from: a  reason: collision with other method in class */
    public String mo350a() {
        gd a2;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(gk.a(l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(gk.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(gk.a(k()));
            sb.append("\"");
        }
        if (this.a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" type=\"");
            sb.append(this.b);
            sb.append("\"");
        }
        if (this.f490b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.e != null) {
            sb.append("<subject>");
            sb.append(gk.a(this.e));
            sb.append("</subject>");
        }
        if (this.f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                sb.append(" encode=\"");
                sb.append(this.g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(gk.a(this.f));
            sb.append("</body>");
        }
        if (this.c != null) {
            sb.append("<thread>");
            sb.append(this.c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.b) && (a2 = mo349a()) != null) {
            sb.append(a2.m362a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.fz
    public void a(String str) {
        this.h = str;
    }

    @Override // com.xiaomi.push.fz
    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Override // com.xiaomi.push.fz
    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.f490b = z;
    }

    public String c() {
        return this.h;
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        return this.i;
    }

    public void d(String str) {
        this.k = str;
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.f1498l = str;
    }

    @Override // com.xiaomi.push.fz
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fy fyVar = (fy) obj;
        if (!super.equals(fyVar)) {
            return false;
        }
        String str = this.f;
        if (str == null ? fyVar.f != null : !str.equals(fyVar.f)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null ? fyVar.d != null : !str2.equals(fyVar.d)) {
            return false;
        }
        String str3 = this.e;
        if (str3 == null ? fyVar.e != null : !str3.equals(fyVar.e)) {
            return false;
        }
        String str4 = this.c;
        if (str4 == null ? fyVar.c == null : str4.equals(fyVar.c)) {
            return this.b == fyVar.b;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.b = str;
    }

    public String g() {
        return this.f1498l;
    }

    public void g(String str) {
        this.e = str;
    }

    public String h() {
        return this.d;
    }

    public void h(String str) {
        this.f = str;
    }

    @Override // com.xiaomi.push.fz
    public int hashCode() {
        String str = this.b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(String str) {
        this.d = str;
    }
}