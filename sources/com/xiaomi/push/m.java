package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.a.a.a.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class m {
    private a a;
    private Handler b;
    private volatile boolean c;
    private final boolean d;
    private int e;
    private volatile b f;

    private class a extends Thread {
        private final LinkedBlockingQueue<b> b = new LinkedBlockingQueue<>();

        public a() {
            super("PackageProcessor");
        }

        private void a(int i, b bVar) {
            try {
                m.this.b.sendMessage(m.this.b.obtainMessage(i, bVar));
            } catch (Exception e) {
                c.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.b.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = m.this.e > 0 ? (long) m.this.e : Long.MAX_VALUE;
            while (!m.this.c) {
                try {
                    b poll = this.b.poll(j, TimeUnit.SECONDS);
                    m.this.f = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (m.this.e > 0) {
                        m.this.a();
                    }
                } catch (InterruptedException e) {
                    c.a(e);
                }
            }
        }
    }

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public m() {
        this(false);
    }

    public m(boolean z) {
        this(z, 0);
    }

    public m(boolean z, int i) {
        this.b = null;
        this.c = false;
        this.e = 0;
        this.b = new n(this, Looper.getMainLooper());
        this.d = z;
        this.e = i;
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        this.a = null;
        this.c = true;
    }

    public synchronized void a(b bVar) {
        if (this.a == null) {
            a aVar = new a();
            this.a = aVar;
            aVar.setDaemon(this.d);
            this.c = false;
            this.a.start();
        }
        this.a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.b.postDelayed(new o(this, bVar), j);
    }
}
