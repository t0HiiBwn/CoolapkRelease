package com.xiaomi.push;

import com.xiaomi.push.j;

class au extends j.a {
    final /* synthetic */ ar a;

    au(ar arVar) {
        this.a = arVar;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.j != null) {
            this.a.j.b(this.a.f);
            this.a.b("delete_time");
        }
    }
}
