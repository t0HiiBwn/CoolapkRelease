package l;

import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: l.ۦ۬ۧ  reason: contains not printable characters */
public class C0175 implements AbstractC0162 {

    /* renamed from: ۦۤۚ  reason: contains not printable characters */
    private final RandomAccessFile f1143;

    public C0175(File file, String str) {
        this.f1143 = new RandomAccessFile(file, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1143.close();
    }

    @Override // l.AbstractC0162
    /* renamed from: ۗۡۨ */
    public int mo2030(byte[] bArr, int i, int i2) {
        return this.f1143.read(bArr, i, i2);
    }

    @Override // l.AbstractC0162
    /* renamed from: ۜۖ۠ */
    public void mo2031(byte[] bArr, int i, int i2) {
        this.f1143.write(bArr, i, i2);
    }

    @Override // l.AbstractC0162
    /* renamed from: ۟۫ۗ */
    public long mo2032() {
        return this.f1143.length();
    }

    @Override // l.AbstractC0162
    /* renamed from: ۢۚ۟ */
    public void mo2033(long j) {
        this.f1143.seek(j);
    }
}
