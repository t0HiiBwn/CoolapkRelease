package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;

class bu extends ai.a {
    final /* synthetic */ bs a;

    bu(bs bsVar) {
        this.a = bsVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public void run() {
        b.c("exec== DbSizeControlJob");
        ce.a(bs.a(this.a)).a(new bx(bs.a(this.a), new WeakReference(bs.a(this.a))));
        this.a.b("check_time");
    }
}
