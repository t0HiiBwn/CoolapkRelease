package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.c.a;
import com.tencent.beacon.core.protocol.common.RequestPackage;

/* compiled from: QimeiUploadDatas */
public final class b extends a {
    private Context h = null;
    private RequestPackage i = null;

    public b(Context context, String str, a.AbstractC0139a aVar) {
        super(context, str, aVar);
        this.h = context;
    }

    @Override // com.tencent.beacon.core.c.a
    public final void b(boolean z) {
        if (this.g != null) {
            this.g.a(z);
        }
    }

    @Override // com.tencent.beacon.core.c.a
    public final RequestPackage a() {
        byte b;
        byte b2;
        com.tencent.beacon.core.d.b.b("[qimei] start", new Object[0]);
        RequestPackage requestPackage = this.i;
        if (requestPackage != null) {
            return requestPackage;
        }
        try {
            a a = a.a(this.h);
            QimeiPackage qimeiPackage = null;
            if (a == null) {
                com.tencent.beacon.core.d.b.d("[qimei] qimeiInfo is null, return", new Object[0]);
                return null;
            }
            if (a != null) {
                qimeiPackage = new QimeiPackage();
                String c = a.c();
                String str = "";
                if (c == null) {
                    c = str;
                }
                qimeiPackage.imei = c;
                String e = a.e();
                if (e == null) {
                    e = str;
                }
                qimeiPackage.imsi = e;
                String d = a.d();
                if (d == null) {
                    d = str;
                }
                qimeiPackage.mac = d;
                String f = a.f();
                if (f == null) {
                    f = str;
                }
                qimeiPackage.androidId = f;
                String a2 = a.a();
                if (a2 == null) {
                    a2 = str;
                }
                qimeiPackage.qimei = a2;
                String j = a.j();
                if (j == null) {
                    j = str;
                }
                qimeiPackage.model = j;
                String k = a.k();
                if (k == null) {
                    k = str;
                }
                qimeiPackage.brand = k;
                String g = a.g();
                if (g == null) {
                    g = str;
                }
                qimeiPackage.osVersion = g;
                qimeiPackage.broot = a.h();
                String i2 = a.i();
                if (i2 == null) {
                    i2 = str;
                }
                qimeiPackage.qq = i2;
                String l = a.l();
                if (l != null) {
                    str = l;
                }
                qimeiPackage.cid = str;
            }
            com.tencent.beacon.core.strategy.a a3 = com.tencent.beacon.core.strategy.a.a();
            if (a3 != null) {
                b = a3.l();
                b2 = a3.m();
            } else {
                b2 = 2;
                b = 3;
            }
            byte[] byteArray = qimeiPackage.toByteArray();
            this.i = a(this.a, com.tencent.beacon.core.b.b.a(this.c), byteArray, b2, b, this.f);
            return this.i;
        } catch (Throwable th) {
            com.tencent.beacon.core.d.b.a(th);
        }
    }
}
