package com.tencent.msdk.dns.base.c;

import android.content.Context;
import android.os.Build;

/* compiled from: NetworkChangeObservableFactory */
final class e {
    e() {
    }

    public b a(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return new f(context);
        }
        return new g(context);
    }
}
