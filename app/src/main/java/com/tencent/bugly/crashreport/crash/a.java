package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
public final class a implements Comparable<a> {
    public long a = -1;
    public long b = -1;
    public String c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        int i;
        a aVar2 = aVar;
        if (aVar2 == null || this.b - aVar2.b > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
