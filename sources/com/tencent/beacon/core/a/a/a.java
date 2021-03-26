package com.tencent.beacon.core.a.a;

/* compiled from: AnalyticsBean */
public final class a {
    public long a = -1;
    public int b = -1;
    public int c = -1;
    public long d = -1;
    public byte[] e = null;
    public long f = 0;

    public a() {
    }

    public a(int i, int i2, long j, byte[] bArr) {
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = bArr;
        if (bArr != null) {
            this.f = (long) bArr.length;
        }
    }
}
