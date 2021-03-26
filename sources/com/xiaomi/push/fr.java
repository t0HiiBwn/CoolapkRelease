package com.xiaomi.push;

import com.xiaomi.push.m;

final class fr extends m.b {
    final /* synthetic */ Runnable a;

    fr(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.push.m.b
    public void b() {
        this.a.run();
    }
}
