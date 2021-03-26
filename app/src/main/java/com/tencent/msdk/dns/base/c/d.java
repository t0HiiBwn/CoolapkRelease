package com.tencent.msdk.dns.base.c;

import android.content.Context;
import com.tencent.msdk.dns.base.log.b;

/* compiled from: NetworkChangeManager */
public final class d {
    private static b a;

    public static void a(Context context) {
        if (context == null) {
            b.c("Install network change manager failed: context can not be null", new Object[0]);
        } else {
            a = new e().a(context);
        }
    }

    public static void a(c cVar) {
        b bVar = a;
        if (bVar != null) {
            bVar.a(cVar);
        }
    }
}
