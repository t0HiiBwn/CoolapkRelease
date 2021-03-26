package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: NetTrafficManager */
public class k {
    private static final String a = "k";
    private final d b;
    private volatile boolean c;
    private final AtomicReference<l> d;
    private AtomicReference<l> e;
    private final ArrayList<b> f;
    private int g;

    /* compiled from: NetTrafficManager */
    private static class a {
        public static final k a = new k(null);
    }

    /* compiled from: NetTrafficManager */
    public interface b {
        void a(l lVar);
    }

    /* synthetic */ k(AnonymousClass1 r1) {
        this();
    }

    public static k a() {
        return a.a;
    }

    private k() {
        this.b = new d(0.05d);
        this.c = false;
        this.d = new AtomicReference<>(l.UNKNOWN);
        this.f = new ArrayList<>();
    }

    public synchronized void a(long j, long j2) {
        double d2 = ((((double) j) * 1.0d) / ((double) j2)) * 8.0d;
        if (j2 != 0 && d2 >= 3.0d) {
            try {
                this.b.a(d2);
                l b2 = b();
                if (this.c) {
                    this.g++;
                    if (b2 != this.e.get()) {
                        this.c = false;
                        this.g = 1;
                    }
                    if (((double) this.g) >= 5.0d && c()) {
                        this.c = false;
                        this.g = 1;
                        this.d.set(this.e.get());
                        d();
                    }
                    return;
                }
                if (this.d.get() != b2) {
                    this.c = true;
                    this.e = new AtomicReference<>(b2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private boolean c() {
        if (this.b == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.a[this.d.get().ordinal()];
            double d2 = 2000.0d;
            double d3 = 550.0d;
            if (i == 1) {
                d3 = 0.0d;
                d2 = 150.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d3 = 150.0d;
            } else if (i != 3) {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d3 = 2000.0d;
            }
            double a2 = this.b.a();
            if (a2 > d2) {
                if (a2 > d2 * 1.25d) {
                    return true;
                }
            } else if (a2 < d3 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.k$1  reason: invalid class name */
    /* compiled from: NetTrafficManager */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public synchronized l b() {
        d dVar = this.b;
        if (dVar == null) {
            return l.UNKNOWN;
        }
        try {
            return a(dVar.a());
        } catch (Throwable th) {
            th.printStackTrace();
            return l.UNKNOWN;
        }
    }

    private l a(double d2) {
        if (d2 < 0.0d) {
            return l.UNKNOWN;
        }
        if (d2 < 150.0d) {
            return l.POOR;
        }
        if (d2 < 550.0d) {
            return l.MODERATE;
        }
        if (d2 < 2000.0d) {
            return l.GOOD;
        }
        return l.EXCELLENT;
    }

    private void d() {
        try {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(this.d.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
