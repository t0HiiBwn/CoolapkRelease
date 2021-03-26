package com.tencent.open.utils;

/* compiled from: ProGuard */
public final class k implements Cloneable {
    private long a;

    public k(long j) {
        this.a = j;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof k) || this.a != ((k) obj).b()) {
            return false;
        }
        return true;
    }

    public byte[] a() {
        long j = this.a;
        return new byte[]{(byte) ((int) (255 & j)), (byte) ((int) ((65280 & j) >> 8)), (byte) ((int) ((16711680 & j) >> 16)), (byte) ((int) ((j & 4278190080L) >> 24))};
    }

    public long b() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int) this.a;
    }
}
