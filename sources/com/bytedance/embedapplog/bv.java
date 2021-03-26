package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.a;
import com.bytedance.embedapplog.cf;
import com.bytedance.embedapplog.cn;

final class bv extends bt<a> {
    bv() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.bt, com.bytedance.embedapplog.cf
    public cf.a b(Context context) {
        a(context, context.getPackageName());
        return super.b(context);
    }

    @Override // com.bytedance.embedapplog.bt
    protected cn.b<a, String> a() {
        return new cn.b<a, String>() {
            /* class com.bytedance.embedapplog.bv.AnonymousClass1 */

            /* renamed from: a */
            public a b(IBinder iBinder) {
                return a.AbstractBinderC0020a.a(iBinder);
            }

            public String a(a aVar) {
                if (aVar == null) {
                    return null;
                }
                return aVar.c();
            }
        };
    }

    @Override // com.bytedance.embedapplog.bt
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
