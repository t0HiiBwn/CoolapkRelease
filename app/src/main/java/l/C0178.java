package l;

import java.io.OutputStream;

/* renamed from: l.۫ۧۗ  reason: contains not printable characters */
public class C0178 extends OutputStream {

    /* renamed from: ۦ۟ۨ  reason: contains not printable characters */
    private int f1160 = 0;

    /* renamed from: ۨۙۢ  reason: not valid java name and contains not printable characters */
    private final AbstractC0170 f1161;

    public C0178(AbstractC0170 r2) {
        this.f1161 = r2;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f1161.mo2136(i);
        this.f1160++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            this.f1161.mo2139(bArr, i, i2);
            this.f1160 += i2;
        }
    }

    /* renamed from: ۡ۟ۛ  reason: not valid java name and contains not printable characters */
    public int m2185() {
        return this.f1160;
    }
}
