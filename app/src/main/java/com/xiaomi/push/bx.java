package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ce;
import java.lang.ref.WeakReference;

public class bx implements Runnable {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f247a;

    public bx(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f247a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f247a;
        if (weakReference != null && (context = weakReference.get()) != null) {
            if (ck.a(this.a) > bw.f245a) {
                ca a2 = ca.a(this.a);
                bz a3 = bz.a(this.a);
                a2.a(a3);
                a3.a(by.a(context, this.a, 1000));
                ce.a(context).a((ce.a) a2);
                return;
            }
            b.b("=====> do not need clean db");
        }
    }
}
