package com.xiaomi.b.b;

import android.content.Context;
import android.os.Process;
import com.xiaomi.a.a.a.c;
import com.xiaomi.b.c.b;
import com.xiaomi.push.eu;

public class a {
    public static void a(Context context, com.xiaomi.b.a.a aVar) {
        if (aVar != null) {
            b.a(context).a(aVar.c(), aVar.d(), aVar.f(), aVar.g());
        }
    }

    public static void a(Context context, com.xiaomi.b.a.a aVar, com.xiaomi.b.c.a aVar2, b bVar) {
        c.c("init in process " + eu.a(context) + " pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        b.a(context).a(aVar, aVar2, bVar);
        if (eu.c(context)) {
            c.c("init in process　start scheduleJob");
            b.a(context).b();
        }
    }

    public static void a(Context context, com.xiaomi.b.a.b bVar) {
        if (bVar != null) {
            b.a(context).a(bVar);
        }
    }

    public static void a(Context context, com.xiaomi.b.a.c cVar) {
        if (cVar != null) {
            b.a(context).a(cVar);
        }
    }
}
