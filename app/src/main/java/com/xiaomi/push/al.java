package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f192a;

    /* renamed from: a  reason: collision with other field name */
    private a f193a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f194a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f195a;
    private final boolean b;

    private class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f196a = new LinkedBlockingQueue<>();

        public a() {
            super("PackageProcessor");
        }

        private void a(int i, b bVar) {
            try {
                al.this.f192a.sendMessage(al.this.f192a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f196a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? (long) al.this.a : Long.MAX_VALUE;
            while (!al.this.f195a) {
                try {
                    b poll = this.f196a.poll(j, TimeUnit.SECONDS);
                    al.this.f194a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.mo197b();
                        a(1, poll);
                    } else if (al.this.a > 0) {
                        al.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    public static abstract class b {
        public void a() {
        }

        /* renamed from: b */
        public abstract void mo197b();

        /* renamed from: c */
        public void mo198c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f192a = null;
        this.f195a = false;
        this.a = 0;
        this.f192a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        this.f193a = null;
        this.f195a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f193a == null) {
            a aVar = new a();
            this.f193a = aVar;
            aVar.setDaemon(this.b);
            this.f195a = false;
            this.f193a.start();
        }
        this.f193a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f192a.postDelayed(new an(this, bVar), j);
    }
}
