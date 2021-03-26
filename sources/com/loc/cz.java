package com.loc;

/* compiled from: AmapCellLte */
public final class cz extends cw {
    public int j = 0;
    public int k = 0;
    public int l = Integer.MAX_VALUE;
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
        czVar.l = this.l;
        czVar.m = this.m;
        czVar.n = this.n;
        return czVar;
    }

    @Override // com.loc.cw
    public final String toString() {
        return "AmapCellLte{lac=" + this.j + ", cid=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + '}' + super.toString();
    }
}
