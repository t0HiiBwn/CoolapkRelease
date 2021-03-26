package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;

class ZipEntryOutputStream extends OutputStream {
    private boolean entryClosed;
    private long numberOfBytesWrittenForThisEntry = 0;
    private OutputStream outputStream;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public ZipEntryOutputStream(OutputStream outputStream2) {
        this.outputStream = outputStream2;
        this.entryClosed = false;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.entryClosed) {
            this.outputStream.write(bArr, i, i2);
            this.numberOfBytesWrittenForThisEntry += (long) i2;
            return;
        }
        throw new IllegalStateException("ZipEntryOutputStream is closed");
    }

    public void closeEntry() throws IOException {
        this.entryClosed = true;
    }

    public long getNumberOfBytesWrittenForThisEntry() {
        return this.numberOfBytesWrittenForThisEntry;
    }
}
