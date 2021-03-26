package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;

class ZipEntryInputStream extends InputStream {
    private static final int MAX_RAW_READ_FULLY_RETRY_ATTEMPTS = 15;
    private long compressedSize;
    private InputStream inputStream;
    private long numberOfBytesRead = 0;
    private byte[] singleByteArray = new byte[1];

    public ZipEntryInputStream(InputStream inputStream2, long j) {
        this.inputStream = inputStream2;
        this.compressedSize = j;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByteArray) == -1) {
            return -1;
        }
        return this.singleByteArray[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.compressedSize;
        if (j != -1) {
            long j2 = this.numberOfBytesRead;
            if (j2 >= j) {
                return -1;
            }
            if (((long) i2) > j - j2) {
                i2 = (int) (j - j2);
            }
        }
        int read = this.inputStream.read(bArr, i, i2);
        if (read > 0) {
            this.numberOfBytesRead += (long) read;
        }
        return read;
    }

    public int readRawFully(byte[] bArr) throws IOException {
        int read = this.inputStream.read(bArr);
        if (read == bArr.length || (read = readUntilBufferIsFull(bArr, read)) == bArr.length) {
            return read;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    private int readUntilBufferIsFull(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int i2 = 0;
        int i3 = 0;
        while (i < bArr.length && i2 != -1 && i3 < 15) {
            i2 += this.inputStream.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
            i3++;
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inputStream.close();
    }

    public long getNumberOfBytesRead() {
        return this.numberOfBytesRead;
    }
}
