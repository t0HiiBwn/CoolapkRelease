package com.ss.android.downloadlib.addownload.b;

import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadad.a.b.a;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ModelBox */
public class e implements a {
    public long a;
    public c b;
    public b c;
    public com.ss.android.a.a.b.a d;

    @Override // com.ss.android.downloadad.a.b.a
    public int s() {
        return 0;
    }

    public e() {
    }

    public e(long j, c cVar, b bVar, com.ss.android.a.a.b.a aVar) {
        this.a = j;
        this.b = cVar;
        this.c = bVar;
        this.d = aVar;
    }

    public boolean w() {
        return this.a <= 0 || this.b == null || this.c == null || this.d == null;
    }

    public boolean x() {
        return this.a > 0 && (this.b instanceof com.ss.android.downloadad.a.a.c) && (this.c instanceof com.ss.android.downloadad.a.a.b) && (this.d instanceof com.ss.android.downloadad.a.a.a);
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String a() {
        return this.b.a();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public long b() {
        return this.b.d();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public boolean c() {
        return this.b.t();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String d() {
        return this.b.u();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String e() {
        return this.b.v();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String f() {
        if (this.b.x() != null) {
            return this.b.x().b();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject g() {
        return this.b.z();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public int h() {
        if (this.d.b() == 2) {
            return 2;
        }
        return this.b.G();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public long l() {
        return this.b.g();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public List<String> n() {
        return this.b.y();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String i() {
        return this.c.a();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String j() {
        return this.c.b();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject k() {
        return this.c.o();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public boolean m() {
        return this.c.m();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public Object o() {
        return this.c.j();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject p() {
        return this.c.n();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public boolean q() {
        return this.d.g();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject r() {
        return this.b.p();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public c t() {
        return this.b;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public b u() {
        return this.c;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public com.ss.android.a.a.b.a v() {
        return this.d;
    }
}
