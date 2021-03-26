package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.a.a.a.c;

final class aa implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f117a;

    aa(Context context, Intent intent) {
        this.a = context;
        this.f117a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f117a);
        } catch (Exception e) {
            c.a(e.getMessage());
        }
    }
}
