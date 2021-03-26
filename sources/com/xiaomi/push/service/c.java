package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.j;

final class c extends j.a {
    final /* synthetic */ int a;
    final /* synthetic */ NotificationManager b;

    c(int i, NotificationManager notificationManager) {
        this.a = i;
        this.b = notificationManager;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.cancel(this.a);
    }
}
