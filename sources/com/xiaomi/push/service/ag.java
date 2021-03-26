package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ab;
import com.xiaomi.push.bc;
import com.xiaomi.push.dc;
import com.xiaomi.push.dd;
import com.xiaomi.push.fq;
import com.xiaomi.push.gw;
import com.xiaomi.push.jb;
import com.xiaomi.push.jg;
import com.xiaomi.push.m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ag {
    private static String a;
    private static ag e = new ag();
    private List<a> b = new ArrayList();
    private dc.a c;
    private m.b d;

    public static abstract class a {
        public void a(dc.a aVar) {
        }

        public void a(dd.b bVar) {
        }
    }

    private ag() {
    }

    public static ag a() {
        return e;
    }

    public static synchronized String e() {
        String str;
        synchronized (ag.class) {
            if (a == null) {
                SharedPreferences sharedPreferences = jb.a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                a = string;
                if (string == null) {
                    String a2 = gw.a(jb.a(), false);
                    a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", a).commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    private void f() {
        if (this.c == null) {
            h();
        }
    }

    private void g() {
        if (this.d == null) {
            ah ahVar = new ah(this);
            this.d = ahVar;
            fq.a(ahVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    private void h() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e2;
        try {
            bufferedInputStream = new BufferedInputStream(jb.a().openFileInput("XMCloudCfg"));
            try {
                this.c = dc.a.c(ab.a(bufferedInputStream));
                bufferedInputStream.close();
            } catch (Exception e3) {
                e2 = e3;
                try {
                    c.a("load config failure: " + e2.getMessage());
                    jg.a(bufferedInputStream);
                    if (this.c == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Exception e4) {
            bufferedInputStream = null;
            e2 = e4;
            c.a("load config failure: " + e2.getMessage());
            jg.a(bufferedInputStream);
            if (this.c == null) {
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            jg.a(bufferedInputStream);
            throw th;
        }
        jg.a(bufferedInputStream);
        if (this.c == null) {
            this.c = new dc.a();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        try {
            if (this.c != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(jb.a().openFileOutput("XMCloudCfg", 0));
                bc a2 = bc.a(bufferedOutputStream);
                this.c.a(a2);
                a2.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            c.a("save config failure: " + e2.getMessage());
        }
    }

    void a(dd.b bVar) {
        a[] aVarArr;
        if (bVar.i() && bVar.h() > c()) {
            g();
        }
        synchronized (this) {
            List<a> list = this.b;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    synchronized void b() {
        this.b.clear();
    }

    int c() {
        f();
        dc.a aVar = this.c;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    public dc.a d() {
        f();
        return this.c;
    }
}
