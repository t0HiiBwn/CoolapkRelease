package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.push.bc;
import com.xiaomi.push.cm;
import com.xiaomi.push.cp;
import com.xiaomi.push.cq;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.ex;
import com.xiaomi.push.fi;
import com.xiaomi.push.gk;
import com.xiaomi.push.gu;
import com.xiaomi.push.gw;
import com.xiaomi.push.service.bh;
import com.xiaomi.push.t;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ax extends bh.a implements cq.a {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f977a;

    static class a implements cq.b {
        a() {
        }

        @Override // com.xiaomi.push.cq.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(41));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", gk.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(t.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = bc.a(t.m674a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                gw.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                return a;
            } catch (IOException e) {
                gw.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    static class b extends cq {
        protected b(Context context, cp cpVar, cq.b bVar, String str) {
            super(context, cpVar, bVar, str);
        }

        @Override // com.xiaomi.push.cq
        protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (gu.m378a().m383a()) {
                    str2 = bh.m641a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                gw.a(0, ex.GSLB_ERR.a(), 1, null, bc.b(a) ? 1 : 0);
                throw e;
            }
        }
    }

    ax(XMPushService xMPushService) {
        this.f977a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ax axVar = new ax(xMPushService);
        bh.a().a(axVar);
        synchronized (cq.class) {
            cq.a(axVar);
            cq.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.cq.a
    public cq a(Context context, cp cpVar, cq.b bVar, String str) {
        return new b(context, cpVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.bh.a
    public void a(dv.a aVar) {
    }

    @Override // com.xiaomi.push.service.bh.a
    public void a(dw.b bVar) {
        cm b2;
        if (bVar.mo231b() && bVar.mo230a() && System.currentTimeMillis() - this.a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m41a("fetch bucket :" + bVar.mo230a());
            this.a = System.currentTimeMillis();
            cq a2 = cq.a();
            a2.m188a();
            a2.m191b();
            fi a3 = this.f977a.m581a();
            if (a3 != null && (b2 = a2.b(a3.m330a().c())) != null) {
                ArrayList<String> a4 = b2.m176a();
                boolean z = true;
                Iterator<String> it2 = a4.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().equals(a3.m331a())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z && !a4.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.m41a("bucket changed, force reconnect");
                    this.f977a.a(0, (Exception) null);
                    this.f977a.a(false);
                }
            }
        }
    }
}
