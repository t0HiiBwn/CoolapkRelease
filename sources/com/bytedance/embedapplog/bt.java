package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.cf;
import com.bytedance.embedapplog.cn;

abstract class bt<SERVICE> implements cf {
    private final String a;
    private bs<Boolean> b = new bs<Boolean>() {
        /* class com.bytedance.embedapplog.bt.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf(by.a((Context) objArr[0], bt.this.a));
        }
    };

    protected abstract cn.b<SERVICE, String> a();

    protected abstract Intent c(Context context);

    bt(String str) {
        this.a = str;
    }

    @Override // com.bytedance.embedapplog.cf
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.b.b(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.cf
    public cf.a b(Context context) {
        return a((String) new cn(context, c(context), a()).a());
    }

    private cf.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        cf.a aVar = new cf.a();
        aVar.b = str;
        return aVar;
    }
}
