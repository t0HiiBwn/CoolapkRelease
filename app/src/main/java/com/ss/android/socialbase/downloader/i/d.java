package com.ss.android.socialbase.downloader.i;

/* compiled from: DownloadStenographer */
public class d {
    private a a;
    private a b;
    private int c;
    private int d = 10;

    public boolean a(long j, long j2) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j >= aVar.a) {
                    if (j2 >= aVar.b) {
                        a aVar2 = aVar.c;
                        if (aVar2 != null && j2 - aVar2.b < 1000) {
                            aVar.a = j;
                            aVar.b = j2;
                            return true;
                        }
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j;
            a2.b = j2;
            if (aVar != null) {
                a2.c = aVar;
                aVar.d = a2;
            }
            this.a = a2;
            return true;
        }
    }

    public long b(long j, long j2) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar == null) {
                return -1;
            }
            a a2 = a(j);
            if (a2 == null) {
                return -1;
            }
            long j3 = aVar.a - a2.a;
            long j4 = j2 - a2.b;
            if (j3 < 0 || j4 <= 0) {
                return -1;
            }
            return j3 / j4;
        }
    }

    private a a() {
        a aVar;
        int i = this.c;
        if (i < this.d || (aVar = this.b) == null) {
            this.c = i + 1;
            return new a();
        }
        a aVar2 = aVar.d;
        aVar.d = null;
        this.b = aVar2;
        if (aVar2 != null) {
            aVar2.c = null;
        }
        return aVar;
    }

    private a a(long j) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.b > j) {
            aVar2 = aVar;
            aVar = aVar.c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j - aVar.b >= aVar2.b - j) ? aVar2 : aVar;
    }

    /* compiled from: DownloadStenographer */
    private static class a {
        long a;
        long b;
        a c;
        a d;

        private a() {
        }
    }
}
