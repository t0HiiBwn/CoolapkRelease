package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.exception.ZipException;

public class CountingOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {
    private long numberOfBytesWritten = 0;
    private OutputStream outputStream;

    public CountingOutputStream(OutputStream outputStream2) {
        this.outputStream = outputStream2;
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
        this.outputStream.write(bArr, i, i2);
        this.numberOfBytesWritten += (long) i2;
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public int getCurrentSplitFileCounter() {
        if (isSplitZipFile()) {
            return ((SplitOutputStream) this.outputStream).getCurrentSplitFileCounter();
        }
        return 0;
    }

    public long getOffsetForNextEntry() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream2).getFilePointer();
        }
        return this.numberOfBytesWritten;
    }

    public long getSplitLength() {
        if (isSplitZipFile()) {
            return ((SplitOutputStream) this.outputStream).getSplitLength();
        }
        return 0;
    }

    public boolean isSplitZipFile() {
        OutputStream outputStream2 = this.outputStream;
        return (outputStream2 instanceof SplitOutputStream) && ((SplitOutputStream) outputStream2).isSplitZipFile();
    }

    public long getNumberOfBytesWritten() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream2).getFilePointer();
        }
        return this.numberOfBytesWritten;
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i) throws ZipException {
        if (!isSplitZipFile()) {
            return false;
        }
        return ((SplitOutputStream) this.outputStream).checkBufferSizeAndStartNextSplitFile(i);
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public long getFilePointer() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream2).getFilePointer();
        }
        return this.numberOfBytesWritten;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.outputStream.close();
    }
}
