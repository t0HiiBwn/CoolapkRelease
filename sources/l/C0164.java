package l;

import java.io.InputStream;

/* renamed from: l.۟ۨ۬  reason: contains not printable characters */
public class C0164 extends InputStream {

    /* renamed from: ۘ۠ۤ  reason: not valid java name and contains not printable characters */
    private long f1071;

    /* renamed from: ۡۤ۠  reason: not valid java name and contains not printable characters */
    private long f1072;

    /* renamed from: ۬۠ۚ  reason: not valid java name and contains not printable characters */
    private final AbstractC0170 f1073;

    public C0164(AbstractC0170 r1, long j, long j2) {
        this.f1073 = r1;
        this.f1071 = j2;
        this.f1072 = j;
    }

    @Override // java.io.InputStream
    public int available() {
        return (int) (this.f1071 & 2147483647L);
    }

    @Override // java.io.InputStream
    public int read() {
        int r1;
        long j = this.f1071;
        this.f1071 = j - 1;
        if (j <= 0) {
            return -1;
        }
        synchronized (this.f1073) {
            AbstractC0170 r12 = this.f1073;
            long j2 = this.f1072;
            this.f1072 = 1 + j2;
            r12.mo2142(j2);
            r1 = this.f1073.mo2133();
        }
        return r1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int r6;
        long j = this.f1071;
        if (j <= 0) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        if (((long) i2) > j) {
            i2 = (int) j;
        }
        synchronized (this.f1073) {
            this.f1073.mo2142(this.f1072);
            r6 = this.f1073.mo2140(bArr, i, i2);
        }
        if (r6 > 0) {
            long j2 = (long) r6;
            this.f1072 += j2;
            this.f1071 -= j2;
        }
        return r6;
    }
}
