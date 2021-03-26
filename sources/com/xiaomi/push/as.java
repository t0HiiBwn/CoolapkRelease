package com.xiaomi.push;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.j;

class as extends j.a {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 10052;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c("exec== mUploadJob");
        if (this.a.j != null) {
            this.a.j.a(this.a.f);
            this.a.b("upload_time");
        }
    }
}
