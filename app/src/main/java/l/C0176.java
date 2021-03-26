package l;

import java.io.EOFException;
import java.util.Arrays;

/* renamed from: l.ۧۖۢ  reason: contains not printable characters */
public final class C0176 implements AbstractC0170 {

    /* renamed from: ۗۦۚ  reason: not valid java name and contains not printable characters */
    private static final long f1144 = -65536;

    /* renamed from: ۟ۗ۠  reason: not valid java name and contains not printable characters */
    private static final int f1145 = 65536;

    /* renamed from: ۟ۜۛ  reason: not valid java name and contains not printable characters */
    private static final int f1146 = 16;

    /* renamed from: ۗۡۢ  reason: not valid java name and contains not printable characters */
    private AbstractC0162 f1147;

    /* renamed from: ۘ۠ۗ  reason: not valid java name and contains not printable characters */
    private boolean f1148;

    /* renamed from: ۙ۬۫  reason: not valid java name and contains not printable characters */
    private boolean f1149;

    /* renamed from: ۚۘۤ  reason: not valid java name and contains not printable characters */
    private byte[] f1150;

    /* renamed from: ۛۢۚ  reason: not valid java name and contains not printable characters */
    private long f1151;

    /* renamed from: ۠ۧۛ  reason: not valid java name and contains not printable characters */
    private long f1152;

    /* renamed from: ۢ۬ۛ  reason: not valid java name and contains not printable characters */
    private long f1153;

    /* renamed from: ۤ۟۠  reason: not valid java name and contains not printable characters */
    private long f1154;

    /* renamed from: ۥۖۨ  reason: contains not printable characters */
    private long f1155;

    /* renamed from: ۬ۛۡ  reason: not valid java name and contains not printable characters */
    private boolean f1156;

    public C0176(AbstractC0162 r1) {
        this.f1147 = r1;
        m2180();
    }

    /* renamed from: ۖ۠ۙ  reason: not valid java name and contains not printable characters */
    private int m2177(byte[] bArr, int i, int i2) {
        long j = this.f1151;
        long j2 = this.f1155;
        if (j >= j2) {
            if (this.f1148) {
                long j3 = this.f1154;
                if (j2 < j3) {
                    this.f1155 = j3;
                }
            }
            mo2142(this.f1151);
            if (this.f1151 == this.f1155) {
                this.f1155 = this.f1154;
            }
        }
        int min = Math.min(i2, (int) (this.f1155 - this.f1151));
        System.arraycopy(bArr, i, this.f1150, (int) (this.f1151 - this.f1153), min);
        this.f1151 += (long) min;
        return min;
    }

    /* renamed from: ۛۜۤ  reason: not valid java name and contains not printable characters */
    private int m2178() {
        int length = this.f1150.length;
        boolean z = false;
        int i = 0;
        while (length > 0) {
            int r3 = this.f1147.mo2030(this.f1150, i, length);
            if (r3 < 0) {
                break;
            }
            i += r3;
            length -= r3;
        }
        if (i < this.f1150.length) {
            z = true;
        }
        this.f1148 = z;
        if (z) {
            byte[] bArr = this.f1150;
            Arrays.fill(bArr, i, bArr.length, (byte) -1);
        }
        this.f1152 += (long) i;
        return i;
    }

    /* renamed from: ۛۡۚ  reason: not valid java name and contains not printable characters */
    private void m2179() {
        if (this.f1149) {
            long j = this.f1152;
            long j2 = this.f1153;
            if (j != j2) {
                this.f1147.mo2033(j2);
            }
            this.f1147.mo2031(this.f1150, 0, (int) (this.f1151 - this.f1153));
            this.f1152 = this.f1151;
            this.f1149 = false;
        }
    }

    /* renamed from: ۜۡۘ  reason: not valid java name and contains not printable characters */
    private void m2180() {
        this.f1156 = false;
        this.f1149 = false;
        this.f1155 = 0;
        this.f1151 = 0;
        this.f1153 = 0;
        this.f1150 = new byte[65536];
        this.f1154 = 65536;
        this.f1148 = false;
        this.f1152 = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m2181();
        this.f1156 = true;
        this.f1147.close();
    }

    @Override // l.AbstractC0170
    /* renamed from: ۖۧۘ */
    public int mo2133() {
        long j = this.f1151;
        if (j >= this.f1155) {
            if (this.f1148) {
                return -1;
            }
            mo2142(j);
            if (this.f1151 == this.f1155) {
                return -1;
            }
        }
        byte[] bArr = this.f1150;
        long j2 = this.f1151;
        byte b = bArr[(int) (j2 - this.f1153)];
        this.f1151 = j2 + 1;
        return b & 255;
    }

    @Override // l.AbstractC0170
    /* renamed from: ۖۨۦ */
    public void mo2134(byte[] bArr) {
        m2182(bArr, 0, bArr.length);
    }

    @Override // l.AbstractC0170
    /* renamed from: ۖ۫۟ */
    public void mo2135(byte[] bArr) {
        mo2139(bArr, 0, bArr.length);
    }

    @Override // l.AbstractC0170
    /* renamed from: ۖ۫ۨ */
    public void mo2136(int i) {
        long j = this.f1151;
        long j2 = this.f1155;
        if (j >= j2) {
            if (!this.f1148 || j2 >= this.f1154) {
                mo2142(this.f1151);
                long j3 = this.f1151;
                long j4 = this.f1155;
                if (j3 == j4) {
                    this.f1155 = j4 + 1;
                }
            } else {
                this.f1155 = j2 + 1;
            }
        }
        byte[] bArr = this.f1150;
        long j5 = this.f1151;
        bArr[(int) (j5 - this.f1153)] = (byte) i;
        this.f1151 = j5 + 1;
        this.f1149 = true;
    }

    /* renamed from: ۗ۫ۧ  reason: not valid java name and contains not printable characters */
    public void m2181() {
        m2179();
    }

    @Override // l.AbstractC0170
    /* renamed from: ۙ۬ۢ */
    public boolean mo2137() {
        return this.f1156;
    }

    @Override // l.AbstractC0170
    /* renamed from: ۠ۖۧ */
    public long mo2138() {
        return this.f1151;
    }

    @Override // l.AbstractC0170
    /* renamed from: ۠ۚۗ */
    public void mo2139(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int r0 = m2177(bArr, i, i2);
            i += r0;
            i2 -= r0;
            this.f1149 = true;
        }
    }

    /* renamed from: ۥۡۧ  reason: contains not printable characters */
    public void m2182(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int r1 = mo2140(bArr, i + i3, i2 - i3);
            if (r1 >= 0) {
                i3 += r1;
            } else {
                throw new EOFException();
            }
        } while (i3 < i2);
    }

    @Override // l.AbstractC0170
    /* renamed from: ۦ۬ۖ */
    public int mo2140(byte[] bArr, int i, int i2) {
        long j = this.f1151;
        if (j >= this.f1155) {
            if (this.f1148) {
                return -1;
            }
            mo2142(j);
            if (this.f1151 == this.f1155) {
                return -1;
            }
        }
        int min = Math.min(i2, (int) (this.f1155 - this.f1151));
        System.arraycopy(this.f1150, (int) (this.f1151 - this.f1153), bArr, i, min);
        this.f1151 += (long) min;
        return min;
    }

    @Override // l.AbstractC0170
    /* renamed from: ۧۙ۬ */
    public long mo2141() {
        return Math.max(this.f1151, this.f1147.mo2032());
    }

    @Override // l.AbstractC0170
    /* renamed from: ۫ۡۙ */
    public void mo2142(long j) {
        if (j >= this.f1155 || j < this.f1153) {
            m2179();
            this.f1153 = -65536 & j;
            long j2 = this.f1153;
            this.f1154 = ((long) this.f1150.length) + j2;
            if (this.f1152 != j2) {
                this.f1147.mo2033(j2);
                this.f1152 = this.f1153;
            }
            this.f1155 = this.f1153 + ((long) m2178());
        } else if (j < this.f1151) {
            m2179();
        }
        this.f1151 = j;
    }
}
