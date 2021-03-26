package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

abstract class DecompressedInputStream extends InputStream {
    private CipherInputStream cipherInputStream;
    protected byte[] oneByteBuffer = new byte[1];

    public void pushBackInputStreamIfNecessary(PushbackInputStream pushbackInputStream) throws IOException {
    }

    public DecompressedInputStream(CipherInputStream cipherInputStream2) {
        this.cipherInputStream = cipherInputStream2;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByteBuffer) == -1) {
            return -1;
        }
        return this.oneByteBuffer[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.cipherInputStream.read(bArr, i, i2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cipherInputStream.close();
    }

    public void endOfEntryReached(InputStream inputStream) throws IOException {
        this.cipherInputStream.endOfEntryReached(inputStream);
    }

    protected byte[] getLastReadRawDataCache() {
        return this.cipherInputStream.getLastReadRawDataCache();
    }
}
