package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

class AesCipherInputStream extends CipherInputStream<AESDecrypter> {
    private byte[] aes16ByteBlock = new byte[16];
    private int aes16ByteBlockPointer = 0;
    private int aes16ByteBlockReadLength = 0;
    private int bytesCopiedInThisIteration = 0;
    private int lengthToCopyInThisIteration = 0;
    private int lengthToRead = 0;
    private int offsetWithAesBlock = 0;
    private int remainingAes16ByteBlockLength = 0;
    private byte[] singleByteBuffer = new byte[1];

    public AesCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        super(zipEntryInputStream, localFileHeader, cArr);
    }

    /* access modifiers changed from: protected */
    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream
    public AESDecrypter initializeDecrypter(LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        return new AESDecrypter(localFileHeader.getAesExtraDataRecord(), cArr, getSalt(localFileHeader), getPasswordVerifier());
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream, java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0];
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.lengthToRead = i2;
        this.offsetWithAesBlock = i;
        this.bytesCopiedInThisIteration = 0;
        if (this.remainingAes16ByteBlockLength != 0) {
            copyBytesFromBuffer(bArr, i);
            int i3 = this.bytesCopiedInThisIteration;
            if (i3 == i2) {
                return i3;
            }
        }
        if (this.lengthToRead < 16) {
            byte[] bArr2 = this.aes16ByteBlock;
            int read = super.read(bArr2, 0, bArr2.length);
            this.aes16ByteBlockReadLength = read;
            this.aes16ByteBlockPointer = 0;
            if (read == -1) {
                this.remainingAes16ByteBlockLength = 0;
                int i4 = this.bytesCopiedInThisIteration;
                if (i4 > 0) {
                    return i4;
                }
                return -1;
            }
            this.remainingAes16ByteBlockLength = read;
            copyBytesFromBuffer(bArr, this.offsetWithAesBlock);
            int i5 = this.bytesCopiedInThisIteration;
            if (i5 == i2) {
                return i5;
            }
        }
        int i6 = this.offsetWithAesBlock;
        int i7 = this.lengthToRead;
        int read2 = super.read(bArr, i6, i7 - (i7 % 16));
        if (read2 != -1) {
            return read2 + this.bytesCopiedInThisIteration;
        }
        int i8 = this.bytesCopiedInThisIteration;
        if (i8 > 0) {
            return i8;
        }
        return -1;
    }

    private void copyBytesFromBuffer(byte[] bArr, int i) {
        int i2 = this.lengthToRead;
        int i3 = this.remainingAes16ByteBlockLength;
        if (i2 >= i3) {
            i2 = i3;
        }
        this.lengthToCopyInThisIteration = i2;
        System.arraycopy(this.aes16ByteBlock, this.aes16ByteBlockPointer, bArr, i, i2);
        incrementAesByteBlockPointer(this.lengthToCopyInThisIteration);
        decrementRemainingAesBytesLength(this.lengthToCopyInThisIteration);
        int i4 = this.bytesCopiedInThisIteration;
        int i5 = this.lengthToCopyInThisIteration;
        this.bytesCopiedInThisIteration = i4 + i5;
        this.lengthToRead -= i5;
        this.offsetWithAesBlock += i5;
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream
    protected void endOfEntryReached(InputStream inputStream) throws IOException {
        verifyContent(readStoredMac(inputStream));
    }

    private void verifyContent(byte[] bArr) throws IOException {
        if (!getLocalFileHeader().isDataDescriptorExists() || !CompressionMethod.DEFLATE.equals(Zip4jUtil.getCompressionMethod(getLocalFileHeader()))) {
            byte[] bArr2 = new byte[10];
            System.arraycopy(((AESDecrypter) getDecrypter()).getCalculatedAuthenticationBytes(), 0, bArr2, 0, 10);
            if (!Arrays.equals(bArr, bArr2)) {
                throw new IOException("Reached end of data for this entry, but aes verification failed");
            }
        }
    }

    protected byte[] readStoredMac(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        if (Zip4jUtil.readFully(inputStream, bArr) == 10) {
            return bArr;
        }
        throw new ZipException("Invalid AES Mac bytes. Could not read sufficient data");
    }

    private byte[] getSalt(LocalFileHeader localFileHeader) throws IOException {
        if (localFileHeader.getAesExtraDataRecord() != null) {
            byte[] bArr = new byte[localFileHeader.getAesExtraDataRecord().getAesKeyStrength().getSaltLength()];
            readRaw(bArr);
            return bArr;
        }
        throw new IOException("invalid aes extra data record");
    }

    private byte[] getPasswordVerifier() throws IOException {
        byte[] bArr = new byte[2];
        readRaw(bArr);
        return bArr;
    }

    private void incrementAesByteBlockPointer(int i) {
        int i2 = this.aes16ByteBlockPointer + i;
        this.aes16ByteBlockPointer = i2;
        if (i2 >= 15) {
            this.aes16ByteBlockPointer = 15;
        }
    }

    private void decrementRemainingAesBytesLength(int i) {
        int i2 = this.remainingAes16ByteBlockLength - i;
        this.remainingAes16ByteBlockLength = i2;
        if (i2 <= 0) {
            this.remainingAes16ByteBlockLength = 0;
        }
    }
}
