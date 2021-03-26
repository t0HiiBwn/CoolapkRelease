package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cm;
import com.xiaomi.push.cq;
import com.xiaomi.push.cz;
import com.xiaomi.push.dw;
import com.xiaomi.push.ex;
import com.xiaomi.push.fb;
import com.xiaomi.push.fj;
import com.xiaomi.push.fw;
import com.xiaomi.push.fx;
import com.xiaomi.push.fy;
import com.xiaomi.push.fz;
import com.xiaomi.push.gn;
import com.xiaomi.push.gw;
import com.xiaomi.push.service.as;
import java.util.Date;

public class ar {
    private XMPushService a;

    ar(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(fw fwVar) {
        String c = fwVar.c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            cm a2 = cq.a().a(fj.a(), false);
            if (a2 != null && split.length > 0) {
                a2.a(split);
                this.a.a(20, (Exception) null);
                this.a.a(true);
            }
        }
    }

    private void b(fz fzVar) {
        as.b a2;
        String l2 = fzVar.l();
        String k = fzVar.k();
        if (!TextUtils.isEmpty(l2) && !TextUtils.isEmpty(k) && (a2 = as.a().a(k, l2)) != null) {
            gn.a(this.a, a2.f968a, (long) gn.a(fzVar.m352a()), true, true, System.currentTimeMillis());
        }
    }

    private void c(fb fbVar) {
        as.b a2;
        String g = fbVar.g();
        String num = Integer.toString(fbVar.a());
        if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(num) && (a2 = as.a().a(num, g)) != null) {
            gn.a(this.a, a2.f968a, (long) fbVar.c(), true, true, System.currentTimeMillis());
        }
    }

    public void a(fb fbVar) {
        if (5 != fbVar.a()) {
            c(fbVar);
        }
        try {
            b(fbVar);
        } catch (Exception e) {
            b.a("handle Blob chid = " + fbVar.a() + " cmd = " + fbVar.m317a() + " packetid = " + fbVar.e() + " failure ", e);
        }
    }

    public void a(fz fzVar) {
        if (!"5".equals(fzVar.k())) {
            b(fzVar);
        }
        String k = fzVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            fzVar.l(k);
        }
        if (k.equals("0")) {
            b.m41a("Received wrong packet with chid = 0 : " + fzVar.m352a());
        }
        if (fzVar instanceof fx) {
            fw a2 = fzVar.a("kick");
            if (a2 != null) {
                String l2 = fzVar.l();
                String a3 = a2.a("type");
                String a4 = a2.a("reason");
                b.m41a("kicked by server, chid=" + k + " res=" + as.b.a(l2) + " type=" + a3 + " reason=" + a4);
                if ("wait".equals(a3)) {
                    as.b a5 = as.a().a(k, l2);
                    if (a5 != null) {
                        this.a.a(a5);
                        a5.a(as.c.unbind, 3, 0, a4, a3);
                        return;
                    }
                    return;
                }
                this.a.a(k, l2, 3, a4, a3);
                as.a().m629a(k, l2);
                return;
            }
        } else if (fzVar instanceof fy) {
            fy fyVar = (fy) fzVar;
            if ("redir".equals(fyVar.b())) {
                fw a6 = fyVar.a("hosts");
                if (a6 != null) {
                    a(a6);
                    return;
                }
                return;
            }
        }
        this.a.b().a(this.a, k, fzVar);
    }

    public void b(fb fbVar) {
        StringBuilder sb;
        String a2;
        String str;
        int i;
        int i2;
        as.c cVar;
        String a3 = fbVar.m317a();
        if (fbVar.a() != 0) {
            String num = Integer.toString(fbVar.a());
            if ("SECMSG".equals(fbVar.m317a())) {
                if (!fbVar.m320a()) {
                    this.a.b().a(this.a, num, fbVar);
                    return;
                }
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(fbVar.b());
                sb.append(" errStr = ");
                a2 = fbVar.m324c();
            } else if ("BIND".equals(a3)) {
                dw.d a4 = dw.d.a(fbVar.m321a());
                String g = fbVar.g();
                as.b a5 = as.a().a(num, g);
                if (a5 != null) {
                    if (a4.mo244a()) {
                        b.m41a("SMACK: channel bind succeeded, chid=" + fbVar.a());
                        a5.a(as.c.binded, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String a6 = a4.mo243a();
                    if ("auth".equals(a6)) {
                        if ("invalid-sig".equals(a4.mo245b())) {
                            b.m41a("SMACK: bind error invalid-sig token = " + a5.c + " sec = " + a5.h);
                            gw.a(0, ex.BIND_INVALID_SIG.a(), 1, null, 0);
                        }
                        cVar = as.c.unbind;
                        i2 = 1;
                        i = 5;
                    } else if ("cancel".equals(a6)) {
                        cVar = as.c.unbind;
                        i2 = 1;
                        i = 7;
                    } else {
                        if ("wait".equals(a6)) {
                            this.a.a(a5);
                            a5.a(as.c.unbind, 1, 7, a4.mo245b(), a6);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.mo245b();
                        b.m41a(str);
                    }
                    a5.a(cVar, i2, i, a4.mo245b(), a6);
                    as.a().m629a(num, g);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.mo245b();
                    b.m41a(str);
                }
                return;
            } else if ("KICK".equals(a3)) {
                dw.g a7 = dw.g.a(fbVar.m321a());
                String g2 = fbVar.g();
                String a8 = a7.mo265a();
                String b = a7.mo267b();
                b.m41a("kicked by server, chid=" + num + " res= " + as.b.a(g2) + " type=" + a8 + " reason=" + b);
                if ("wait".equals(a8)) {
                    as.b a9 = as.a().a(num, g2);
                    if (a9 != null) {
                        this.a.a(a9);
                        a9.a(as.c.unbind, 3, 0, b, a8);
                        return;
                    }
                    return;
                }
                this.a.a(num, g2, 3, b, a8);
                as.a().m629a(num, g2);
                return;
            } else {
                return;
            }
        } else if ("PING".equals(a3)) {
            byte[] a10 = fbVar.m321a();
            if (a10 != null && a10.length > 0) {
                dw.j a11 = dw.j.a(a10);
                if (a11.mo278b()) {
                    bh.a().a(a11.mo276a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.m583a();
            }
            if ("1".equals(fbVar.e())) {
                b.m41a("received a server ping");
            } else {
                gw.b();
            }
            this.a.m586b();
            return;
        } else if ("SYNC".equals(a3)) {
            if ("CONF".equals(fbVar.m323b())) {
                bh.a().a(dw.b.a(fbVar.m321a()));
                return;
            } else if (TextUtils.equals("U", fbVar.m323b())) {
                dw.k a12 = dw.k.a(fbVar.m321a());
                cz.a(this.a).a(a12.mo280a(), a12.mo283b(), new Date(a12.mo279a()), new Date(a12.mo282b()), a12.c() * 1024, a12.e());
                fb fbVar2 = new fb();
                fbVar2.a(0);
                fbVar2.a(fbVar.m317a(), "UCA");
                fbVar2.a(fbVar.e());
                XMPushService xMPushService = this.a;
                xMPushService.a(new bd(xMPushService, fbVar2));
                return;
            } else if (TextUtils.equals("P", fbVar.m323b())) {
                dw.i a13 = dw.i.a(fbVar.m321a());
                fb fbVar3 = new fb();
                fbVar3.a(0);
                fbVar3.a(fbVar.m317a(), "PCA");
                fbVar3.a(fbVar.e());
                dw.i iVar = new dw.i();
                if (a13.mo274a()) {
                    iVar.a(a13.mo273a());
                }
                fbVar3.a(iVar.mo211a(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new bd(xMPushService2, fbVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                a2 = fbVar.e();
            } else {
                return;
            }
        } else if ("NOTIFY".equals(fbVar.m317a())) {
            dw.h a14 = dw.h.a(fbVar.m321a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a14.c());
            sb.append(" desc = ");
            a2 = a14.mo270a();
        } else {
            return;
        }
        sb.append(a2);
        str = sb.toString();
        b.m41a(str);
    }
}
