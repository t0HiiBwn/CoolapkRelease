package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dw;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bh;

public class fg extends fp {
    private fc a;

    /* renamed from: a  reason: collision with other field name */
    private fd f455a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f456a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f457a;

    public fg(XMPushService xMPushService, fj fjVar) {
        super(xMPushService, fjVar);
    }

    @Override // com.xiaomi.push.fp
    /* renamed from: a */
    private fb mo327a(boolean z) {
        ff ffVar = new ff();
        if (z) {
            ffVar.a("1");
        }
        byte[] a2 = gw.m384a();
        if (a2 != null) {
            dw.j jVar = new dw.j();
            jVar.a(a.a(a2));
            ffVar.a(jVar.mo211a(), (String) null);
        }
        return ffVar;
    }

    private void h() {
        try {
            this.a = new fc(this.f478a.getInputStream(), this);
            this.f455a = new fd(this.f478a.getOutputStream(), this);
            fh fhVar = new fh(this, "Blob Reader (" + this.b + ")");
            this.f456a = fhVar;
            fhVar.start();
        } catch (Exception e) {
            throw new ft("Error to init reader and writer", e);
        }
    }

    @Override // com.xiaomi.push.fp, com.xiaomi.push.fi
    /* renamed from: a */
    protected synchronized void mo328a() {
        h();
        this.f455a.a();
    }

    @Override // com.xiaomi.push.fp
    protected synchronized void a(int i, Exception exc) {
        fc fcVar = this.a;
        if (fcVar != null) {
            fcVar.b();
            this.a = null;
        }
        fd fdVar = this.f455a;
        if (fdVar != null) {
            try {
                fdVar.b();
            } catch (Exception e) {
                b.a(e);
            }
            this.f455a = null;
        }
        this.f457a = null;
        super.a(i, exc);
    }

    void a(fb fbVar) {
        if (fbVar != null) {
            if (fbVar.m320a()) {
                b.m41a("[Slim] RCV blob chid=" + fbVar.a() + "; id=" + fbVar.e() + "; errCode=" + fbVar.b() + "; err=" + fbVar.m324c());
            }
            if (fbVar.a() == 0) {
                if ("PING".equals(fbVar.m317a())) {
                    b.m41a("[Slim] RCV ping id=" + fbVar.e());
                    g();
                } else if ("CLOSE".equals(fbVar.m317a())) {
                    c(13, null);
                }
            }
            for (fi.a aVar : this.f467a.values()) {
                aVar.a(fbVar);
            }
        }
    }

    @Override // com.xiaomi.push.fi
    @Deprecated
    public void a(fz fzVar) {
        b(fb.a(fzVar, (String) null));
    }

    @Override // com.xiaomi.push.fi
    public synchronized void a(as.b bVar) {
        fa.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fi
    public synchronized void a(String str, String str2) {
        fa.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fp
    /* renamed from: a  reason: collision with other method in class */
    protected void mo327a(boolean z) {
        if (this.f455a != null) {
            fb a2 = mo327a(z);
            b.m41a("[Slim] SND ping id=" + a2.e());
            b(a2);
            f();
            return;
        }
        throw new ft("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.fp, com.xiaomi.push.fi
    public void a(fb[] fbVarArr) {
        for (fb fbVar : fbVarArr) {
            b(fbVar);
        }
    }

    @Override // com.xiaomi.push.fp, com.xiaomi.push.fi
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo328a() {
        return true;
    }

    @Override // com.xiaomi.push.fp, com.xiaomi.push.fi
    /* renamed from: a */
    synchronized byte[] mo328a() {
        if (this.f457a == null && !TextUtils.isEmpty(this.f464a)) {
            String a2 = bh.m641a();
            this.f457a = bb.a(this.f464a.getBytes(), (this.f464a.substring(this.f464a.length() / 2) + a2.substring(a2.length() / 2)).getBytes());
        }
        return this.f457a;
    }

    @Override // com.xiaomi.push.fi
    public void b(fb fbVar) {
        fd fdVar = this.f455a;
        if (fdVar != null) {
            try {
                int a2 = fdVar.a(fbVar);
                this.d = System.currentTimeMillis();
                String f = fbVar.f();
                if (!TextUtils.isEmpty(f)) {
                    gn.a(this.f463a, f, (long) a2, false, true, System.currentTimeMillis());
                }
                for (fi.a aVar : this.f470b.values()) {
                    aVar.a(fbVar);
                }
            } catch (Exception e) {
                throw new ft(e);
            }
        } else {
            throw new ft("the writer is null.");
        }
    }

    void b(fz fzVar) {
        if (fzVar != null) {
            for (fi.a aVar : this.f467a.values()) {
                aVar.a(fzVar);
            }
        }
    }
}
