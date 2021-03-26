package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dd;
import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.q;
import com.xiaomi.push.service.z;

public class ek extends et {
    private Thread v;
    private eg w;
    private eh x;
    private byte[] y;

    public ek(XMPushService xMPushService, en enVar) {
        super(xMPushService, enVar);
    }

    private ef c(boolean z) {
        ej ejVar = new ej();
        if (z) {
            ejVar.a("1");
        }
        byte[] c = gc.c();
        if (c != null) {
            dd.j jVar = new dd.j();
            jVar.a(a.a(c));
            ejVar.a(jVar.c(), (String) null);
        }
        return ejVar;
    }

    private void v() {
        try {
            this.w = new eg(this.p.getInputStream(), this);
            this.x = new eh(this.p.getOutputStream(), this);
            el elVar = new el(this, "Blob Reader (" + this.k + ")");
            this.v = elVar;
            elVar.start();
        } catch (Exception e) {
            throw new ey("Error to init reader and writer", e);
        }
    }

    @Override // com.xiaomi.push.et
    protected synchronized void a(int i, Exception exc) {
        eg egVar = this.w;
        if (egVar != null) {
            egVar.b();
            this.w = null;
        }
        eh ehVar = this.x;
        if (ehVar != null) {
            try {
                ehVar.b();
            } catch (Exception e) {
                c.a(e);
            }
            this.x = null;
        }
        this.y = null;
        super.a(i, exc);
    }

    void a(ef efVar) {
        if (efVar != null) {
            if (efVar.d()) {
                c.a("[Slim] RCV blob chid=" + efVar.c() + "; id=" + efVar.h() + "; errCode=" + efVar.e() + "; err=" + efVar.f());
            }
            if (efVar.c() == 0) {
                if ("PING".equals(efVar.a())) {
                    c.a("[Slim] RCV ping id=" + efVar.h());
                    u();
                } else if ("CLOSE".equals(efVar.a())) {
                    c(13, null);
                }
            }
            for (em.a aVar : this.f.values()) {
                aVar.a(efVar);
            }
        }
    }

    @Override // com.xiaomi.push.em
    @Deprecated
    public void a(fe feVar) {
        b(ef.a(feVar, (String) null));
    }

    @Override // com.xiaomi.push.em
    public synchronized void a(q.b bVar) {
        ee.a(bVar, q(), this);
    }

    @Override // com.xiaomi.push.em
    public synchronized void a(String str, String str2) {
        ee.a(str, str2, this);
    }

    @Override // com.xiaomi.push.et
    protected void a(boolean z) {
        if (this.x != null) {
            ef c = c(z);
            c.a("[Slim] SND ping id=" + c.h());
            b(c);
            t();
            return;
        }
        throw new ey("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.et, com.xiaomi.push.em
    public void a(ef[] efVarArr) {
        for (ef efVar : efVarArr) {
            b(efVar);
        }
    }

    synchronized byte[] a() {
        if (this.y == null && !TextUtils.isEmpty(this.i)) {
            String e = ag.e();
            this.y = z.a(this.i.getBytes(), (this.i.substring(this.i.length() / 2) + e.substring(e.length() / 2)).getBytes());
        }
        return this.y;
    }

    @Override // com.xiaomi.push.em
    public void b(ef efVar) {
        eh ehVar = this.x;
        if (ehVar != null) {
            try {
                int a = ehVar.a(efVar);
                this.n = System.currentTimeMillis();
                String i = efVar.i();
                if (!TextUtils.isEmpty(i)) {
                    fs.a(this.m, i, (long) a, false, true, System.currentTimeMillis());
                }
                for (em.a aVar : this.g.values()) {
                    aVar.a(efVar);
                }
            } catch (Exception e) {
                throw new ey(e);
            }
        } else {
            throw new ey("the writer is null.");
        }
    }

    void b(fe feVar) {
        if (feVar != null) {
            for (em.a aVar : this.f.values()) {
                aVar.a(feVar);
            }
        }
    }

    @Override // com.xiaomi.push.em
    public boolean b() {
        return true;
    }

    @Override // com.xiaomi.push.et
    protected synchronized void c() {
        v();
        this.x.a();
    }
}
