package com.loc;

/* compiled from: AmapCellLte */
public final class cz extends cw {
    public int j = 0;
    public int k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1359l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;

    public cz(boolean z) {
        super(z, true);
    }

    @Override // com.loc.cw
    /* renamed from: a */
    public final cw clone() {
        cz czVar = new cz(this.h);
        czVar.a(this);
        czVar.j = this.j;
        czVar.k = this.k;
        czVar.f1359l = this.f1359l;
        czVar.m = this.m;
        czVar.n = this.n;
        return czVar;
    }

    @Override // com.loc.cw
    public final String toString() {
        return "AmapCellLte{lac=" + this.j + ", cid=" + this.k + ", pci=" + this.f1359l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + '}' + super.toString();
    }
}
