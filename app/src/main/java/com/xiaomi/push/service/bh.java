package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.al;
import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.gl;
import com.xiaomi.push.i;
import com.xiaomi.push.t;
import com.xiaomi.push.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class bh {
    private static bh a = new bh();

    /* renamed from: a  reason: collision with other field name */
    private static String f992a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f993a;

    /* renamed from: a  reason: collision with other field name */
    private dv.a f994a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f995a = new ArrayList();

    public static abstract class a {
        public void a(dv.a aVar) {
        }

        public void a(dw.b bVar) {
        }
    }

    private bh() {
    }

    public static bh a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m641a() {
        String str;
        synchronized (bh.class) {
            if (f992a == null) {
                SharedPreferences sharedPreferences = t.m674a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f992a = string;
                if (string == null) {
                    String a2 = i.a(t.m674a(), false);
                    f992a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f992a).commit();
                    }
                }
            }
            str = f992a;
        }
        return str;
    }

    private void b() {
        if (this.f994a == null) {
            d();
        }
    }

    private void c() {
        if (this.f993a == null) {
            bi biVar = new bi(this);
            this.f993a = biVar;
            gl.a(biVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    private void d() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e;
        try {
            bufferedInputStream = new BufferedInputStream(t.m674a().openFileInput("XMCloudCfg"));
            try {
                this.f994a = dv.a.b(b.a(bufferedInputStream));
                bufferedInputStream.close();
            } catch (Exception e2) {
                e = e2;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m41a("load config failure: " + e.getMessage());
                    y.a(bufferedInputStream);
                    if (this.f994a == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
            com.xiaomi.channel.commonutils.logger.b.m41a("load config failure: " + e.getMessage());
            y.a(bufferedInputStream);
            if (this.f994a == null) {
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            y.a(bufferedInputStream);
            throw th;
        }
        y.a(bufferedInputStream);
        if (this.f994a == null) {
            this.f994a = new dv.a();
        }
    }

    private void e() {
        try {
            if (this.f994a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(t.m674a().openFileOutput("XMCloudCfg", 0));
                c a2 = c.a(bufferedOutputStream);
                this.f994a.a(a2);
                a2.m150a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m41a("save config failure: " + e.getMessage());
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    int m642a() {
        b();
        dv.a aVar = this.f994a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dv.a m643a() {
        b();
        return this.f994a;
    }

    /* renamed from: a  reason: collision with other method in class */
    synchronized void m644a() {
        this.f995a.clear();
    }

    void a(dw.b bVar) {
        a[] aVarArr;
        if (bVar.m233d() && bVar.d() > m642a()) {
            c();
        }
        synchronized (this) {
            List<a> list = this.f995a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f995a.add(aVar);
    }
}
