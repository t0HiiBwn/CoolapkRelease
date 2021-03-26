package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.aa;
import com.xiaomi.push.bm;
import com.xiaomi.push.bp;
import com.xiaomi.push.bq;
import com.xiaomi.push.dc;
import com.xiaomi.push.dd;
import com.xiaomi.push.eb;
import com.xiaomi.push.em;
import com.xiaomi.push.fp;
import com.xiaomi.push.ga;
import com.xiaomi.push.gc;
import com.xiaomi.push.jb;
import com.xiaomi.push.service.ag;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class v extends ag.a implements bq.a {
    private XMPushService a;
    private long b;

    static class a implements bq.b {
        a() {
        }

        @Override // com.xiaomi.push.bq.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(39));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", fp.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(jb.b()));
            String builder = buildUpon.toString();
            c.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = aa.a(jb.a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                gc.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                return a;
            } catch (IOException e) {
                gc.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    static class b extends bq {
        protected b(Context context, bp bpVar, bq.b bVar, String str) {
            super(context, bpVar, bVar, str);
        }

        @Override // com.xiaomi.push.bq
        protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (ga.a().c()) {
                    str2 = ag.e();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                gc.a(0, eb.GSLB_ERR.a(), 1, null, aa.c(c) ? 1 : 0);
                throw e;
            }
        }
    }

    v(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        v vVar = new v(xMPushService);
        ag.a().a(vVar);
        synchronized (bq.class) {
            bq.a(vVar);
            bq.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.bq.a
    public bq a(Context context, bp bpVar, bq.b bVar, String str) {
        return new b(context, bpVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.ag.a
    public void a(dc.a aVar) {
    }

    @Override // com.xiaomi.push.service.ag.a
    public void a(dd.b bVar) {
        bm b2;
        if (bVar.e() && bVar.d() && System.currentTimeMillis() - this.b > 3600000) {
            c.a("fetch bucket :" + bVar.d());
            this.b = System.currentTimeMillis();
            bq a2 = bq.a();
            a2.d();
            a2.f();
            em h = this.a.h();
            if (h != null && (b2 = a2.b(h.d().e())) != null) {
                ArrayList<String> d = b2.d();
                boolean z = true;
                Iterator<String> it2 = d.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().equals(h.e())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z && !d.isEmpty()) {
                    c.a("bucket changed, force reconnect");
                    this.a.a(0, (Exception) null);
                    this.a.a(false);
                }
            }
        }
    }
}
