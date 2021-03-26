package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.stats.bs;
import com.huawei.hms.stats.bt;

public class HMSBIInit {
    public void init(Context context, boolean z, boolean z2, boolean z3, String str) {
        checkNonNull(context, "context must not be null.");
        new bt.a(context).d(z).b(z2).c(z3).a(0, str).a();
    }

    public void refresh(Context context, boolean z, boolean z2, boolean z3, String str, boolean z4) {
        checkNonNull(context, "context must not be null.");
        new bt.a(context).d(z).b(z2).c(z3).a(0, str).a(z4);
    }

    public boolean isInit() {
        return bs.b();
    }

    public static <T> T checkNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(str));
    }
}
