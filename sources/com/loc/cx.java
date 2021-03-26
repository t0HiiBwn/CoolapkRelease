package com.loc;

/* compiled from: AmapCellCdma */
public final class cx extends cw {
    public int j = 0;
    public int k = 0;
    public int l = 0;
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
        this.l = cxVar.l;
        this.m = cxVar.m;
        this.n = cxVar.n;
        return cxVar;
    }

    @Override // com.loc.cw
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + '}' + super.toString();
    }
}
