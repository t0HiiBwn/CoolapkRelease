package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.h.e;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DeviceBandwidthSampler */
public class b {
    public static volatile boolean a = false;
    private static final String b = "b";
    private static long g = -1;
    private static volatile b h;
    private final k c = k.a();
    private final AtomicInteger d = new AtomicInteger();
    private final a e = new a(e.a());
    private long f;

    public static b a() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b();
                }
            }
        }
        return h;
    }

    private b() {
    }

    public void b() {
        try {
            String str = b;
            com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.d);
            if (this.d.getAndIncrement() == 0) {
                this.e.a();
                this.f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = b;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.d);
            if (this.d.decrementAndGet() == 0) {
                this.e.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.e.b(com.ss.android.socialbase.downloader.downloader.b.L());
    }

    protected void f() {
        long j;
        try {
            e();
            if (a) {
                j = d();
            } else {
                j = TrafficStats.getMobileRxBytes();
            }
            long j2 = g;
            long j3 = j - j2;
            if (j2 >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.c.a(j3, uptimeMillis - this.f);
                    this.f = uptimeMillis;
                }
            }
            g = j;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void g() {
        f();
        g = -1;
    }

    /* compiled from: DeviceBandwidthSampler */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                b.this.f();
                sendEmptyMessageDelayed(1, 1000);
            }
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }
    }
}
