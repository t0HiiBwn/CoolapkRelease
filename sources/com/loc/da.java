package com.loc;

/* compiled from: AmapCellWcdma */
public final class da extends cw {
    public int j = 0;
    public int k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1361l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;

    public da(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.loc.cw
    /* renamed from: a */
    public final cw clone() {
        da daVar = new da(this.h, this.i);
        daVar.a(this);
        daVar.j = this.j;
        daVar.k = this.k;
        daVar.f1361l = this.f1361l;
        daVar.m = this.m;
        return daVar;
    }

    @Override // com.loc.cw
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.f1361l + ", uarfcn=" + this.m + '}' + super.toString();
    }
}
