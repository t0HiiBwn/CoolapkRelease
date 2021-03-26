package com.loc;

/* compiled from: AmapCellCdma */
public final class cx extends cw {
    public int j = 0;
    public int k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1357l = 0;
    public int m;
    public int n;

    public cx(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.loc.cw
    /* renamed from: a */
    public final cw clone() {
        cx cxVar = new cx(this.h, this.i);
        cxVar.a(this);
        this.j = cxVar.j;
        this.k = cxVar.k;
        this.f1357l = cxVar.f1357l;
        this.m = cxVar.m;
        this.n = cxVar.n;
        return cxVar;
    }

    @Override // com.loc.cw
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.f1357l + ", latitude=" + this.m + ", longitude=" + this.n + '}' + super.toString();
    }
}
