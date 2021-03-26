package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.cn;
import com.bytedance.embedapplog.e;

final class bd extends bt<e> {
    bd() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.bt
    protected cn.b<e, String> a() {
        return new cn.b<e, String>() {
            /* class com.bytedance.embedapplog.bd.AnonymousClass1 */

            /* renamed from: a */
            public e b(IBinder iBinder) {
                return e.a.a(iBinder);
            }

            public String a(e eVar) {
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }
        };
    }

    @Override // com.bytedance.embedapplog.bt
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
