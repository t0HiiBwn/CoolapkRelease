package com.xiaomi.b.b;

import android.content.Context;
import com.xiaomi.b.a.a;
import com.xiaomi.b.a.c;
import com.xiaomi.b.a.d;
import com.xiaomi.push.ah;
import com.xiaomi.push.ai;
import com.xiaomi.push.aj;
import com.xiaomi.push.ak;
import com.xiaomi.push.al;
import com.xiaomi.push.ao;
import com.xiaomi.push.it;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b {
    private static final int a = (it.a() ? 30 : 10);
    private static volatile b b;
    private ExecutorService c = Executors.newSingleThreadExecutor();
    private HashMap<String, HashMap<String, d>> d = new HashMap<>();
    private HashMap<String, ArrayList<d>> e = new HashMap<>();
    private Context f;
    private a g;
    private String h;
    private com.xiaomi.b.c.a i;
    private com.xiaomi.b.c.b j;

    private b(Context context) {
        this.f = context;
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(context);
                }
            }
        }
        return b;
    }

    private void a(j.a aVar, int i2) {
        j.a(this.f).b(aVar, i2);
    }

    /* access modifiers changed from: private */
    public void b(com.xiaomi.b.a.b bVar) {
        com.xiaomi.b.c.a aVar = this.i;
        if (aVar != null) {
            aVar.b(bVar);
            if (g() >= 10) {
                e();
                j.a(this.f).a(100888);
                return;
            }
            a(new e(this), a);
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        com.xiaomi.b.c.b bVar = this.j;
        if (bVar != null) {
            bVar.b(cVar);
            if (h() >= 10) {
                f();
                j.a(this.f).a(100889);
                return;
            }
            a(new g(this), a);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            this.i.b();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("we: " + e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            this.j.b();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("wp: " + e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public int g() {
        HashMap<String, ArrayList<d>> hashMap = this.e;
        if (hashMap == null) {
            return 0;
        }
        int i2 = 0;
        for (String str : hashMap.keySet()) {
            ArrayList<d> arrayList = this.e.get(str);
            i2 += arrayList != null ? arrayList.size() : 0;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public int h() {
        HashMap<String, HashMap<String, d>> hashMap = this.d;
        int i2 = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, d> hashMap2 = this.d.get(str);
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        d dVar = hashMap2.get(str2);
                        if (dVar instanceof c) {
                            i2 = (int) (((long) i2) + ((c) dVar).b);
                        }
                    }
                }
            }
        }
        return i2;
    }

    private void i() {
        if (a(this.f).a().c()) {
            ai aiVar = new ai(this.f);
            int f2 = (int) a(this.f).a().f();
            if (f2 < 1800) {
                f2 = 1800;
            }
            if (System.currentTimeMillis() - ao.a(this.f).b("sp_client_report_status", "event_last_upload_time", 0) > ((long) (f2 * 1000))) {
                j.a(this.f).a(new i(this, aiVar), 10);
            }
            synchronized (b.class) {
                if (!j.a(this.f).a((j.a) aiVar, f2)) {
                    j.a(this.f).a(100886);
                    j.a(this.f).a((j.a) aiVar, f2);
                }
            }
        }
    }

    private void j() {
        if (a(this.f).a().d()) {
            aj ajVar = new aj(this.f);
            int g2 = (int) a(this.f).a().g();
            if (g2 < 1800) {
                g2 = 1800;
            }
            if (System.currentTimeMillis() - ao.a(this.f).b("sp_client_report_status", "perf_last_upload_time", 0) > ((long) (g2 * 1000))) {
                j.a(this.f).a(new j(this, ajVar), 15);
            }
            synchronized (b.class) {
                if (!j.a(this.f).a((j.a) ajVar, g2)) {
                    j.a(this.f).a(100887);
                    j.a(this.f).a((j.a) ajVar, g2);
                }
            }
        }
    }

    public synchronized a a() {
        if (this.g == null) {
            this.g = a.a(this.f);
        }
        return this.g;
    }

    public com.xiaomi.b.a.b a(int i2, String str) {
        com.xiaomi.b.a.b bVar = new com.xiaomi.b.a.b();
        bVar.d = str;
        bVar.c = System.currentTimeMillis();
        bVar.b = i2;
        bVar.a = ah.a(6);
        bVar.e = 1000;
        bVar.g = 1001;
        bVar.f = "E100004";
        bVar.a(this.f.getPackageName());
        bVar.b(this.h);
        return bVar;
    }

    public void a(a aVar, com.xiaomi.b.c.a aVar2, com.xiaomi.b.c.b bVar) {
        this.g = aVar;
        this.i = aVar2;
        this.j = bVar;
        aVar2.a(this.e);
        this.j.a(this.d);
    }

    public void a(com.xiaomi.b.a.b bVar) {
        if (a().c()) {
            this.c.execute(new c(this, bVar));
        }
    }

    public void a(c cVar) {
        if (a().d()) {
            this.c.execute(new d(this, cVar));
        }
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(boolean z, boolean z2, long j2, long j3) {
        a aVar = this.g;
        if (aVar == null) {
            return;
        }
        if (z != aVar.c() || z2 != this.g.d() || j2 != this.g.f() || j3 != this.g.g()) {
            long f2 = this.g.f();
            long g2 = this.g.g();
            a a2 = a.a().a(al.a(this.f)).a(this.g.b()).b(z).b(j2).c(z2).c(j3).a(this.f);
            this.g = a2;
            if (!a2.c()) {
                j.a(this.f).a(100886);
            } else if (f2 != a2.f()) {
                com.xiaomi.a.a.a.c.c(this.f.getPackageName() + "reset event job " + a2.f());
                i();
            }
            if (!this.g.d()) {
                j.a(this.f).a(100887);
            } else if (g2 != a2.g()) {
                com.xiaomi.a.a.a.c.c(this.f.getPackageName() + "reset perf job " + a2.g());
                j();
            }
        }
    }

    public void b() {
        a(this.f).i();
        a(this.f).j();
    }

    public void c() {
        if (a().c()) {
            ak akVar = new ak();
            akVar.a(this.f);
            akVar.a(this.i);
            this.c.execute(akVar);
        }
    }

    public void d() {
        if (a().d()) {
            ak akVar = new ak();
            akVar.a(this.j);
            akVar.a(this.f);
            this.c.execute(akVar);
        }
    }
}
