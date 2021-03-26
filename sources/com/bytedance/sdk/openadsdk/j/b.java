package com.bytedance.sdk.openadsdk.j;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: DelegateRunnable */
class b implements Comparable, Runnable {
    private g a = null;
    private a b = null;
    private long c = 0;
    private Thread d = null;

    public b(g gVar, a aVar) {
        this.a = gVar;
        this.b = aVar;
        this.c = SystemClock.uptimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.c;
        this.d = Thread.currentThread();
        g gVar = this.a;
        if (gVar != null) {
            gVar.run();
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        a aVar = this.b;
        if (aVar != null) {
            d.a(aVar, j, uptimeMillis2);
        }
        Log.i("DelegateRunnable", "run: pool  = " + this.b.a() + " waitTime =" + j + " taskCost = " + uptimeMillis2);
    }

    public g a() {
        return this.a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof b) {
            return this.a.compareTo(((b) obj).a());
        }
        return 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        g gVar;
        return (obj instanceof b) && (gVar = this.a) != null && gVar.equals(((b) obj).a());
    }
}
