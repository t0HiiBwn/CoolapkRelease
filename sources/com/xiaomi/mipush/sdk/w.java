package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;

final class w implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f179a;

    w(Context context, Intent intent) {
        this.a = context;
        this.f179a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f179a);
        } catch (Exception e) {
            b.m41a(e.getMessage());
        }
    }
}
