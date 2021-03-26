package com.tencent.beacon.core.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.d;
import com.tencent.beacon.core.event.g;

/* compiled from: ActivityMonitorTask */
public final class a implements Runnable {
    private final Context a;
    private Object b;
    private boolean c = false;
    private int d = 0;

    public a(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d == 0) {
            b.b("[core] Activity Monitor Task was started.", new Object[0]);
        }
        int i = this.d;
        this.d = i + 1;
        if (i < 10) {
            if (com.tencent.beacon.core.b.a.a) {
                b.b("[core] Found visible activity.", new Object[0]);
                new g(this.a).c();
                this.d = 10;
            } else {
                if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 18 || this.b != null || this.c) {
                    a();
                } else {
                    new Handler(this.a.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.beacon.core.a.a.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a();
                        }
                    });
                    this.c = true;
                }
                b.a().a(this, 5000);
            }
        }
        if (this.d == 10) {
            b.b("[core] Activity Monitor Task was exited.", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        int a2;
        if (this.b == null) {
            this.b = d.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
        }
        Object obj = this.b;
        if (obj != null && (a2 = d.a("android.app.ActivityThread", obj, "mNumVisibleActivities")) > 0) {
            b.b("[core] mNumVisibleActivities: " + a2, new Object[0]);
            com.tencent.beacon.core.b.a.a = true;
        }
    }
}
