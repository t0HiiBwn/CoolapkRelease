package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.g;

/* compiled from: DBAdapter */
public class f extends g {
    private static volatile f a;

    @Override // com.bytedance.sdk.openadsdk.core.g
    public /* bridge */ /* synthetic */ g.c a() {
        return super.a();
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    private f(Context context) {
        super(context);
    }
}
