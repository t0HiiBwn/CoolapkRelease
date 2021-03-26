package com.xiaomi.push;

import com.xiaomi.push.ca;
import java.io.File;
import java.util.Date;

class cb extends ca.b {
    File a;
    final /* synthetic */ int d;
    final /* synthetic */ Date e;
    final /* synthetic */ Date f;
    final /* synthetic */ String g;
    final /* synthetic */ String h;
    final /* synthetic */ boolean i;
    final /* synthetic */ ca j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cb(ca caVar, int i2, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.j = caVar;
        this.d = i2;
        this.e = date;
        this.f = date2;
        this.g = str;
        this.h = str2;
        this.i = z;
    }

    @Override // com.xiaomi.push.ca.b, com.xiaomi.push.m.b
    public void b() {
        if (b.d()) {
            try {
                File file = new File(ca.a(this.j).getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    bz bzVar = new bz();
                    bzVar.a(this.d);
                    this.a = bzVar.a(ca.a(this.j), this.e, this.f, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.m.b
    public void c() {
        File file = this.a;
        if (file != null && file.exists()) {
            ca.b(this.j).add(new ca.c(this.g, this.h, this.a, this.i));
        }
        ca.a(this.j, 0);
    }
}
