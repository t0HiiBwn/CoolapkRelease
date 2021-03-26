package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.bm;
import com.xiaomi.push.bq;
import com.xiaomi.push.ca;
import com.xiaomi.push.dd;
import com.xiaomi.push.eb;
import com.xiaomi.push.ef;
import com.xiaomi.push.en;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fd;
import com.xiaomi.push.fe;
import com.xiaomi.push.fs;
import com.xiaomi.push.gc;
import com.xiaomi.push.service.q;
import java.util.Date;

public class p {
    private XMPushService a;

    p(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(fb fbVar) {
        String c = fbVar.c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            bm a2 = bq.a().a(en.a(), false);
            if (a2 != null && split.length > 0) {
                a2.a(split);
                this.a.a(20, (Exception) null);
                this.a.a(true);
            }
        }
    }

    private void b(fe feVar) {
        q.b b;
        String m = feVar.m();
        String l = feVar.l();
        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(l) && (b = q.a().b(l, m)) != null) {
            fs.a(this.a, b.a, (long) fs.a(feVar.c()), true, true, System.currentTimeMillis());
        }
    }

    private void c(ef efVar) {
        q.b b;
        String j = efVar.j();
        String num = Integer.toString(efVar.c());
        if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(num) && (b = q.a().b(num, j)) != null) {
            fs.a(this.a, b.a, (long) efVar.l(), true, true, System.currentTimeMillis());
        }
    }

    public void a(ef efVar) {
        if (5 != efVar.c()) {
            c(efVar);
        }
        try {
            b(efVar);
        } catch (Exception e) {
            c.a("handle Blob chid = " + efVar.c() + " cmd = " + efVar.a() + " packetid = " + efVar.h() + " failure ", e);
        }
    }

    public void a(fe feVar) {
        if (!"5".equals(feVar.l())) {
            b(feVar);
        }
        String l = feVar.l();
        if (TextUtils.isEmpty(l)) {
            l = "1";
            feVar.l(l);
        }
        if (l.equals("0")) {
            c.a("Received wrong packet with chid = 0 : " + feVar.c());
        }
        if (feVar instanceof fc) {
            fb p = feVar.p("kick");
            if (p != null) {
                String m = feVar.m();
                String a2 = p.a("type");
                String a3 = p.a("reason");
                c.a("kicked by server, chid=" + l + " res=" + q.b.a(m) + " type=" + a2 + " reason=" + a3);
                if ("wait".equals(a2)) {
                    q.b b = q.a().b(l, m);
                    if (b != null) {
                        this.a.a(b);
                        b.a(q.c.unbind, 3, 0, a3, a2);
                        return;
                    }
                    return;
                }
                this.a.a(l, m, 3, a3, a2);
                q.a().a(l, m);
                return;
            }
        } else if (feVar instanceof fd) {
            fd fdVar = (fd) feVar;
            if ("redir".equals(fdVar.a())) {
                fb p2 = fdVar.p("hosts");
                if (p2 != null) {
                    a(p2);
                    return;
                }
                return;
            }
        }
        this.a.e().a(this.a, l, feVar);
    }

    public void b(ef efVar) {
        StringBuilder sb;
        String f;
        String str;
        int i;
        int i2;
        q.c cVar;
        String a2 = efVar.a();
        if (efVar.c() != 0) {
            String num = Integer.toString(efVar.c());
            if ("SECMSG".equals(efVar.a())) {
                if (!efVar.d()) {
                    this.a.e().a(this.a, num, efVar);
                    return;
                }
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(efVar.e());
                sb.append(" errStr = ");
                f = efVar.f();
            } else if ("BIND".equals(a2)) {
                dd.d b = dd.d.b(efVar.k());
                String j = efVar.j();
                q.b b2 = q.a().b(num, j);
                if (b2 != null) {
                    if (b.d()) {
                        c.a("SMACK: channel bind succeeded, chid=" + efVar.c());
                        b2.a(q.c.binded, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String f2 = b.f();
                    if ("auth".equals(f2)) {
                        if ("invalid-sig".equals(b.h())) {
                            c.a("SMACK: bind error invalid-sig token = " + b2.c + " sec = " + b2.i);
                            gc.a(0, eb.BIND_INVALID_SIG.a(), 1, null, 0);
                        }
                        cVar = q.c.unbind;
                        i2 = 1;
                        i = 5;
                    } else if ("cancel".equals(f2)) {
                        cVar = q.c.unbind;
                        i2 = 1;
                        i = 7;
                    } else {
                        if ("wait".equals(f2)) {
                            this.a.a(b2);
                            b2.a(q.c.unbind, 1, 7, b.h(), f2);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + b.h();
                        c.a(str);
                    }
                    b2.a(cVar, i2, i, b.h(), f2);
                    q.a().a(num, j);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + b.h();
                    c.a(str);
                }
                return;
            } else if ("KICK".equals(a2)) {
                dd.g b3 = dd.g.b(efVar.k());
                String j2 = efVar.j();
                String d = b3.d();
                String f3 = b3.f();
                c.a("kicked by server, chid=" + num + " res= " + q.b.a(j2) + " type=" + d + " reason=" + f3);
                if ("wait".equals(d)) {
                    q.b b4 = q.a().b(num, j2);
                    if (b4 != null) {
                        this.a.a(b4);
                        b4.a(q.c.unbind, 3, 0, f3, d);
                        return;
                    }
                    return;
                }
                this.a.a(num, j2, 3, f3, d);
                q.a().a(num, j2);
                return;
            } else {
                return;
            }
        } else if ("PING".equals(a2)) {
            byte[] k = efVar.k();
            if (k != null && k.length > 0) {
                dd.j b5 = dd.j.b(k);
                if (b5.f()) {
                    ag.a().a(b5.g());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.a();
            }
            if ("1".equals(efVar.h())) {
                c.a("received a server ping");
            } else {
                gc.b();
            }
            this.a.i();
            return;
        } else if ("SYNC".equals(a2)) {
            if ("CONF".equals(efVar.b())) {
                ag.a().a(dd.b.b(efVar.k()));
                return;
            } else if (TextUtils.equals("U", efVar.b())) {
                dd.k b6 = dd.k.b(efVar.k());
                ca.a(this.a).a(b6.d(), b6.f(), new Date(b6.h()), new Date(b6.j()), b6.n() * 1024, b6.l());
                ef efVar2 = new ef();
                efVar2.a(0);
                efVar2.a(efVar.a(), "UCA");
                efVar2.a(efVar.h());
                XMPushService xMPushService = this.a;
                xMPushService.a(new ac(xMPushService, efVar2));
                return;
            } else if (TextUtils.equals("P", efVar.b())) {
                dd.i b7 = dd.i.b(efVar.k());
                ef efVar3 = new ef();
                efVar3.a(0);
                efVar3.a(efVar.a(), "PCA");
                efVar3.a(efVar.h());
                dd.i iVar = new dd.i();
                if (b7.e()) {
                    iVar.a(b7.d());
                }
                efVar3.a(iVar.c(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new ac(xMPushService2, efVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                f = efVar.h();
            } else {
                return;
            }
        } else if ("NOTIFY".equals(efVar.a())) {
            dd.h b8 = dd.h.b(efVar.k());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(b8.d());
            sb.append(" desc = ");
            f = b8.f();
        } else {
            return;
        }
        sb.append(f);
        str = sb.toString();
        c.a(str);
    }
}
