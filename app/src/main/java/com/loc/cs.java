package com.loc;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.Iterator;
import java.util.List;

/* compiled from: RssiInfoManager */
public final class cs {
    private static volatile cs g;
    private static Object h = new Object();
    private LongSparseArray<a> a = new LongSparseArray<>();
    private LongSparseArray<a> b = new LongSparseArray<>();
    private LongSparseArray<a> c = new LongSparseArray<>();
    private LongSparseArray<a> d = new LongSparseArray<>();
    private Object e = new Object();
    private Object f = new Object();

    /* compiled from: RssiInfoManager */
    private static class a {
        int a;
        long b;
        boolean c;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private cs() {
    }

    public static cs a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new cs();
                }
            }
        }
        return g;
    }

    private static short a(LongSparseArray<a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j);
            if (aVar == null) {
                return 0;
            }
            short max = (short) ((int) Math.max(1L, Math.min(32767L, (SystemClock.elapsedRealtime() - aVar.b) / 1000)));
            if (!aVar.c) {
                max = (short) (-max);
            }
            return max;
        }
    }

    private static void a(List<cr> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int size = longSparseArray.size();
        Iterator<cr> it2 = list.iterator();
        if (size == 0) {
            while (it2.hasNext()) {
                cr next = it2.next();
                a aVar = new a((byte) 0);
                aVar.a = next.b();
                aVar.b = elapsedRealtime;
                aVar.c = false;
                longSparseArray2.put(next.a(), aVar);
            }
            return;
        }
        while (it2.hasNext()) {
            cr next2 = it2.next();
            long a2 = next2.a();
            a aVar2 = longSparseArray.get(a2);
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
            } else if (aVar2.a == next2.b()) {
                longSparseArray2.put(a2, aVar2);
            }
            aVar2.a = next2.b();
            aVar2.b = elapsedRealtime;
            aVar2.c = true;
            longSparseArray2.put(a2, aVar2);
        }
    }

    final short a(long j) {
        return a(this.a, j);
    }

    final void a(List<cr> list) {
        if (!list.isEmpty()) {
            synchronized (this.e) {
                a(list, this.a, this.b);
                LongSparseArray<a> longSparseArray = this.a;
                this.a = this.b;
                this.b = longSparseArray;
                longSparseArray.clear();
            }
        }
    }

    final short b(long j) {
        return a(this.c, j);
    }

    final void b(List<cr> list) {
        if (!list.isEmpty()) {
            synchronized (this.f) {
                a(list, this.c, this.d);
                LongSparseArray<a> longSparseArray = this.c;
                this.c = this.d;
                this.d = longSparseArray;
                longSparseArray.clear();
            }
        }
    }
}
