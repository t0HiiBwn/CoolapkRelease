package com.alibaba.alibclinkpartner.smartlink.manager;

import com.alibaba.alibclinkpartner.smartlink.b.a.a;

final class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (b.b()) {
            b.d(this.a);
        } else {
            b.e(this.a);
        }
    }
}
