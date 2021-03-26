package l;

import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* renamed from: l.ۦۜۖ  reason: contains not printable characters */
public class C0173 extends DeflaterOutputStream {
    public C0173(OutputStream outputStream, int i) {
        super(outputStream, new Deflater(i, true));
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.def.end();
    }
}
