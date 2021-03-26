package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.al;
import com.xiaomi.push.bb;
import com.xiaomi.push.cu;
import com.xiaomi.push.dv;
import com.xiaomi.push.o;
import com.xiaomi.push.service.bh;
import com.xiaomi.push.t;
import java.util.List;

class bi extends al.b {
    final /* synthetic */ bh a;

    /* renamed from: a  reason: collision with other field name */
    boolean f996a = false;

    bi(bh bhVar) {
        this.a = bhVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039 A[Catch:{ Exception -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.al.b
    /* renamed from: b */
    public void mo197b() {
        String str;
        dv.a a2;
        try {
            String a3 = a.a(t.m674a()).a();
            if (!TextUtils.isEmpty(a3)) {
                if (!o.China.name().equals(a3)) {
                    str = "https://resolver.msg.global.xiaomi.net/psc/?t=a";
                    a2 = dv.a.a(Base64.decode(cu.a(t.m674a(), str, (List<bb>) null), 10));
                    if (a2 == null) {
                        this.a.f994a = a2;
                        this.f996a = true;
                        bh.a(this.a);
                        return;
                    }
                    return;
                }
            }
            str = "https://resolver.msg.xiaomi.net/psc/?t=a";
            a2 = dv.a.a(Base64.decode(cu.a(t.m674a(), str, (List<bb>) null), 10));
            if (a2 == null) {
            }
        } catch (Exception e) {
            b.m41a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo198c() {
        bh.a[] aVarArr;
        this.a.f993a = null;
        if (this.f996a) {
            synchronized (this.a) {
                aVarArr = (bh.a[]) bh.a(this.a).toArray(new bh.a[bh.a(this.a).size()]);
            }
            for (bh.a aVar : aVarArr) {
                aVar.a(bh.a(this.a));
            }
        }
    }
}
