package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.push.bd;

public class ag {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        k.a a = k.m96a(dVar);
        if (a == null || TextUtils.isEmpty(a.a) || TextUtils.isEmpty(a.b)) {
            return null;
        }
        return (AbstractPushManager) bd.a(a.a, a.b, context);
    }
}
