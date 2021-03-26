package com.bytedance.embedapplog;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

class p extends i {
    private static final long[] b = {60000};
    private final z c;
    private final as d;
    private final aa e;
    private long f;
    private long g;

    @Override // com.bytedance.embedapplog.i
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.i
    String e() {
        return "s";
    }

    p(Context context, as asVar, z zVar, aa aaVar) {
        super(context);
        this.d = asVar;
        this.c = zVar;
        this.e = aaVar;
    }

    @Override // com.bytedance.embedapplog.i
    long b() {
        long y = this.c.y();
        if (y > 60000 || y <= 0) {
            y = 60000;
        }
        b[0] = y;
        return this.f + y;
    }

    @Override // com.bytedance.embedapplog.i
    long[] c() {
        return b;
    }

    @Override // com.bytedance.embedapplog.i
    public boolean d() {
        aw a;
        if (System.currentTimeMillis() > this.g + this.c.y()) {
            JSONObject b2 = this.e.b();
            q d2 = k.d();
            if (!(d2 == null || b2 == null || (a = d2.a()) == null)) {
                this.d.a(b2, a, d2.b());
                this.g = System.currentTimeMillis();
            }
        }
        ArrayList<ax> a2 = this.d.a();
        ArrayList<ax> arrayList = new ArrayList<>(a2.size());
        ArrayList<ax> arrayList2 = new ArrayList<>(a2.size());
        String[] a3 = ap.a(this.a, this.e.a());
        Iterator<ax> it2 = a2.iterator();
        while (it2.hasNext()) {
            ax next = it2.next();
            int a4 = ao.a(a3, next.h, this.c);
            if (a4 == 200) {
                arrayList.add(next);
            } else {
                next.j = a4;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.d.a(arrayList, arrayList2);
        }
        bo.d(e() + arrayList.size() + " " + a2.size(), null);
        if (arrayList.size() != a2.size()) {
            return false;
        }
        this.f = System.currentTimeMillis();
        return true;
    }
}
