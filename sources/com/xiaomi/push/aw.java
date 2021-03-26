package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.be;
import java.lang.ref.WeakReference;

public class aw implements Runnable {
    private String a;
    private WeakReference<Context> b;

    public aw(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.b = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.b;
        if (weakReference != null && (context = weakReference.get()) != null) {
            if (bk.a(this.a) > av.b) {
                az a2 = az.a(this.a);
                ay a3 = ay.a(this.a);
                a2.a(a3);
                a3.a(ax.a(context, this.a, 1000));
                be.a(context).a((be.a) a2);
                return;
            }
            c.b("=====> do not need clean db");
        }
    }
}
