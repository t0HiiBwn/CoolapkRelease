package com.loc;

/* compiled from: AmapCellGsm */
public final class cy extends cw {
    public int j = 0;
    public int k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1358l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public int o = Integer.MAX_VALUE;

    public cy(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.loc.cw
    /* renamed from: a */
    public final cw clone() {
        cy cyVar = new cy(this.h, this.i);
        cyVar.a(this);
        cyVar.j = this.j;
        cyVar.k = this.k;
        cyVar.f1358l = this.f1358l;
        cyVar.m = this.m;
        cyVar.n = this.n;
        cyVar.o = this.o;
        return cyVar;
    }

    @Override // com.loc.cw
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.f1358l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + '}' + super.toString();
    }
}
