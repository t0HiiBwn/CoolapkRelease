package com.xiaomi.push.service;

import com.xiaomi.push.gw;
import java.util.Iterator;
import java.util.List;

final class ag implements Runnable {
    final /* synthetic */ List a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f944a;

    ag(List list, boolean z) {
        this.a = list;
        this.f944a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        boolean a2 = af.a("www.baidu.com:80");
        Iterator it2 = this.a.iterator();
        while (true) {
            i = 1;
            if (!it2.hasNext()) {
                break;
            }
            a2 = a2 || af.a((String) it2.next());
            if (a2 && !this.f944a) {
                break;
            }
        }
        if (!a2) {
            i = 2;
        }
        gw.a(i);
    }
}
