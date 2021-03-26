package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;

class bt extends ai.a {
    final /* synthetic */ bs a;

    bt(bs bsVar) {
        this.a = bsVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public void run() {
        b.c("exec== mUploadJob");
        if (bs.a(this.a) != null) {
            bs.a(this.a).a(bs.a(this.a));
            this.a.b("upload_time");
        }
    }
}
