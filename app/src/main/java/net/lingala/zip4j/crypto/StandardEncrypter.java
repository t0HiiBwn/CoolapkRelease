package net.lingala.zip4j.crypto;

import java.util.Objects;
import java.util.Random;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardEncrypter implements Encrypter {
    private byte[] headerBytes = new byte[12];
    private ZipCryptoEngine zipCryptoEngine = new ZipCryptoEngine();

    public StandardEncrypter(char[] cArr, long j) throws ZipException {
        init(cArr, j);
    }

    private void init(char[] cArr, long j) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.zipCryptoEngine.initKeys(cArr);
        this.headerBytes = generateRandomBytes(12);
        this.zipCryptoEngine.initKeys(cArr);
        byte[] bArr = this.headerBytes;
        bArr[11] = (byte) ((int) (j >>> 24));
        bArr[10] = (byte) ((int) (j >>> 16));
        if (bArr.length >= 12) {
            encryptData(bArr);
            return;
        }
        throw new ZipException("invalid header bytes generated, cannot perform standard encryption");
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr) throws ZipException {
        Objects.requireNonNull(bArr);
        return encryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 >= 0) {
            for (int i3 = i; i3 < i + i2; i3++) {
                bArr[i3] = encryptByte(bArr[i3]);
            }
            return i2;
        }
        throw new ZipException("invalid length specified to decrpyt data");
    }

    protected byte encryptByte(byte b) {
        byte decryptByte = (byte) ((this.zipCryptoEngine.decryptByte() & 255) ^ b);
        this.zipCryptoEngine.updateKeys(b);
        return decryptByte;
    }

    protected byte[] generateRandomBytes(int i) throws ZipException {
        if (i > 0) {
            byte[] bArr = new byte[i];
            Random random = new Random();
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = encryptByte((byte) random.nextInt(256));
            }
            return bArr;
        }
        throw new ZipException("size is either 0 or less than 0, cannot generate header for standard encryptor");
    }

    public byte[] getHeaderBytes() {
        return this.headerBytes;
    }
}
