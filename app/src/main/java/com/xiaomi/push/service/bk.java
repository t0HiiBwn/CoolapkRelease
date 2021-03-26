package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bj;

class bk implements Runnable {
    final /* synthetic */ bj a;

    bk(bj bjVar) {
        this.a = bjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            for (bj.a aVar : bj.a(this.a).values()) {
                aVar.run();
            }
        } catch (Exception e) {
            b.m41a("Sync job exception :" + e.getMessage());
        }
        this.a.f1001a = false;
    }
}
