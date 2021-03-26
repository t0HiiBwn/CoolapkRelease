package com.xiaomi.push.service;

import com.xiaomi.push.gc;
import java.util.Iterator;
import java.util.List;

final class f implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;

    f(List list, boolean z) {
        this.a = list;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        boolean z = e.b("www.baidu.com:80");
        Iterator it2 = this.a.iterator();
        while (true) {
            i = 1;
            if (!it2.hasNext()) {
                break;
            }
            z = z || (e.b((String) it2.next()));
            if (z && !this.b) {
                break;
            }
        }
        if (!z) {
            i = 2;
        }
        gc.a(i);
    }
}
