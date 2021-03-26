package com.tencent.bugly.proguard;

import java.io.Serializable;

/* compiled from: BUGLY */
public final class m implements Serializable, Comparable<m> {
    public long a;
    public String b;
    public long c;
    public int d;
    public String e;
    public String f;
    public long g;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(m mVar) {
        return (int) (this.c - mVar.c);
    }
}
