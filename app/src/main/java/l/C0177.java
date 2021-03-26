package l;

import java.io.OutputStream;
import java.util.zip.CRC32;

/* renamed from: l.ۨۨۤ  reason: contains not printable characters */
public class C0177 extends OutputStream {

    /* renamed from: ۗۘۢ  reason: not valid java name and contains not printable characters */
    private int f1157 = 0;

    /* renamed from: ۡۢۤ  reason: not valid java name and contains not printable characters */
    private CRC32 f1158 = new CRC32();

    /* renamed from: ۢۨۧ  reason: not valid java name and contains not printable characters */
    private OutputStream f1159;

    public C0177(OutputStream outputStream) {
        this.f1159 = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1159.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f1159.write(i);
        this.f1158.update(i);
        this.f1157++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f1159.write(bArr, i, i2);
        this.f1158.update(bArr, i, i2);
        this.f1157 += i2;
    }

    /* renamed from: ۗۤۛ  reason: not valid java name and contains not printable characters */
    public int m2183() {
        return (int) this.f1158.getValue();
    }

    /* renamed from: ۜۛۘ  reason: not valid java name and contains not printable characters */
    public int m2184() {
        return this.f1157;
    }
}
