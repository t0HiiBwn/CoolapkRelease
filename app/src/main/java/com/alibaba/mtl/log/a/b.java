package com.alibaba.mtl.log.a;

import com.alibaba.mtl.log.d.e;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.l;
import com.alibaba.mtl.log.d.r;
import com.alibaba.mtl.log.d.t;
import java.util.HashMap;

/* compiled from: GcConfigChannelMgr */
public class b {
    private static String P = "adashxgc.ut.taobao.com";
    private static b a = new b();

    /* access modifiers changed from: private */
    public static String i() {
        return "https://" + P + "/rest/gc2";
    }

    public static b a() {
        return a;
    }

    public void q() {
        r.a().b(new a());
    }

    /* compiled from: GcConfigChannelMgr */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.isConnected()) {
                for (int i = 0; i < 8; i++) {
                    HashMap hashMap = new HashMap();
                    String b2 = a.m21b("b01n15");
                    String b3 = a.m21b("b01na");
                    hashMap.put("_b01n15", b2);
                    hashMap.put("_b01na", b3);
                    try {
                        String b4 = t.b(b.i(), hashMap, null);
                        i.a("ConfigMgr", "config:" + b4);
                        e.a a = e.a(1, b4, null, false);
                        if (a.e != null) {
                            a.h(new String(a.e, 0, a.e.length));
                            a.p();
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
