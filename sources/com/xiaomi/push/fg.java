package com.xiaomi.push;

import android.os.Bundle;
import java.util.Objects;

public class fg extends fe {
    private b c = b.available;
    private String d = null;
    private int e = Integer.MIN_VALUE;
    private a f = null;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fg(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.c = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public fg(b bVar) {
        a(bVar);
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.e = i;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(b bVar) {
        Objects.requireNonNull(bVar, "Type cannot be null");
        this.c = bVar;
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // com.xiaomi.push.fe
    public Bundle b() {
        Bundle b2 = super.b();
        b bVar = this.c;
        if (bVar != null) {
            b2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.d;
        if (str != null) {
            b2.putString("ext_pres_status", str);
        }
        int i = this.e;
        if (i != Integer.MIN_VALUE) {
            b2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f;
        if (!(aVar == null || aVar == a.available)) {
            b2.putString("ext_pres_mode", this.f.toString());
        }
        return b2;
    }

    @Override // com.xiaomi.push.fe
    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (t() != null) {
            sb.append(" xmlns=\"");
            sb.append(t());
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
        if (this.c != null) {
            sb.append(" type=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.d != null) {
            sb.append("<status>");
            sb.append(fp.a(this.d));
            sb.append("</status>");
        }
        if (this.e != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.e);
            sb.append("</priority>");
        }
        a aVar = this.f;
        if (!(aVar == null || aVar == a.available)) {
            sb.append("<show>");
            sb.append(this.f);
            sb.append("</show>");
        }
        sb.append(s());
        fi p = p();
        if (p != null) {
            sb.append(p.b());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
