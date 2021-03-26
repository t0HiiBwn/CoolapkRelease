package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

abstract class CipherInputStream<T extends Decrypter> extends InputStream {
    private T decrypter;
    private byte[] lastReadRawDataCache;
    private LocalFileHeader localFileHeader;
    private byte[] singleByteBuffer = new byte[1];
    private ZipEntryInputStream zipEntryInputStream;

    protected void endOfEntryReached(InputStream inputStream) throws IOException {
    }

    protected abstract T initializeDecrypter(LocalFileHeader localFileHeader2, char[] cArr) throws IOException, ZipException;

    public CipherInputStream(ZipEntryInputStream zipEntryInputStream2, LocalFileHeader localFileHeader2, char[] cArr) throws IOException, ZipException {
        this.zipEntryInputStream = zipEntryInputStream2;
        this.decrypter = initializeDecrypter(localFileHeader2, cArr);
        this.localFileHeader = localFileHeader2;
        if (getCompressionMethod(localFileHeader2) == CompressionMethod.DEFLATE) {
            this.lastReadRawDataCache = new byte[4096];
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readFully = Zip4jUtil.readFully(this.zipEntryInputStream, bArr, i, i2);
        if (readFully > 0) {
            cacheRawData(bArr, readFully);
            this.decrypter.decryptData(bArr, i, readFully);
        }
        return readFully;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zipEntryInputStream.close();
    }

    public byte[] getLastReadRawDataCache() {
        return this.lastReadRawDataCache;
    }

    protected int readRaw(byte[] bArr) throws IOException {
        return this.zipEntryInputStream.readRawFully(bArr);
    }

    private void cacheRawData(byte[] bArr, int i) {
        byte[] bArr2 = this.lastReadRawDataCache;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    private CompressionMethod getCompressionMethod(LocalFileHeader localFileHeader2) throws ZipException {
        if (localFileHeader2.getCompressionMethod() != CompressionMethod.AES_INTERNAL_ONLY) {
            return localFileHeader2.getCompressionMethod();
        }
        if (localFileHeader2.getAesExtraDataRecord() != null) {
            return localFileHeader2.getAesExtraDataRecord().getCompressionMethod();
        }
        throw new ZipException("AesExtraDataRecord not present in localheader for aes encrypted data");
    }

    public T getDecrypter() {
        return this.decrypter;
    }

    protected long getNumberOfBytesReadForThisEntry() {
        return this.zipEntryInputStream.getNumberOfBytesRead();
    }

    public LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }
}
