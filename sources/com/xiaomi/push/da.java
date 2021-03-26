package com.xiaomi.push;

import com.xiaomi.push.cz;
import java.io.File;
import java.util.Date;

class da extends cz.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cz f302a;

    /* renamed from: a  reason: collision with other field name */
    File f303a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f304a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f305a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f306a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f307b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    da(cz czVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f302a = czVar;
        this.a = i;
        this.f305a = date;
        this.f307b = date2;
        this.f304a = str;
        this.b = str2;
        this.f306a = z;
    }

    @Override // com.xiaomi.push.cz.b, com.xiaomi.push.al.b
    /* renamed from: b */
    public void mo197b() {
        if (aa.d()) {
            try {
                File file = new File(cz.a(this.f302a).getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    cy cyVar = new cy();
                    cyVar.a(this.a);
                    this.f303a = cyVar.a(cz.a(this.f302a), this.f305a, this.f307b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo198c() {
        File file = this.f303a;
        if (file != null && file.exists()) {
            cz.a(this.f302a).add(new cz.c(this.f304a, this.b, this.f303a, this.f306a));
        }
        cz.a(this.f302a, 0);
    }
}
