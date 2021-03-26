package com.bytedance.tea.crash.a;

import com.bytedance.tea.crash.e.f;
import com.bytedance.tea.crash.e.g;
import java.io.File;

/* compiled from: ANRThread */
public class d implements Runnable {
    private long a;
    private final c b;
    private volatile boolean c = false;
    private Runnable d = new Runnable() {
        /* class com.bytedance.tea.crash.a.d.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            d.this.c = false;
        }
    };

    d(c cVar) {
        this.b = cVar;
        this.a = a();
        g.a(2);
        f.a().a(4500, this.d);
        f.a().a(5000, this, 40, 5000);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        if (!this.c) {
            if (b()) {
                i = 200;
                str = "/data/anr/traces.txt";
            } else {
                str = null;
                i = 100;
            }
            if (this.b.a(i, str, 25)) {
                this.c = true;
            }
        }
    }

    private long a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0;
    }

    private boolean b() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
