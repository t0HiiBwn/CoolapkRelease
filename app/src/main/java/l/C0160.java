package l;

import java.io.EOFException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* renamed from: l.ۘۢۥ  reason: contains not printable characters */
public class C0160 extends InflaterInputStream {

    /* renamed from: ۬ۧۡ  reason: not valid java name and contains not printable characters */
    private boolean f1059 = false;

    public C0160(InputStream inputStream) {
        super(inputStream, new Inflater(true));
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        super.close();
        if (!this.f1059) {
            this.inf.end();
            this.f1059 = true;
        }
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return super.read(bArr, i, i2);
        } catch (EOFException unused) {
            return -1;
        }
    }
}
