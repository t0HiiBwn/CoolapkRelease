package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.ai;

class aj implements Runnable {
    final /* synthetic */ ai a;

    aj(ai aiVar) {
        this.a = aiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            for (ai.a aVar : this.a.e.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            c.a("Sync job exception :" + e.getMessage());
        }
        this.a.d = false;
    }
}
