package net.lingala.zip4j.crypto;

import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardDecrypter implements Decrypter {
    private byte[] crc = new byte[4];
    private byte[] crcBytes;
    private char[] password;
    private ZipCryptoEngine zipCryptoEngine;

    public StandardDecrypter(char[] cArr, byte[] bArr, byte[] bArr2) throws ZipException {
        this.password = cArr;
        this.crcBytes = bArr;
        this.zipCryptoEngine = new ZipCryptoEngine();
        init(bArr2);
    }

    @Override // net.lingala.zip4j.crypto.Decrypter
    public int decryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i < 0 || i2 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrypt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            byte decryptByte = (byte) (((bArr[i3] & 255) ^ this.zipCryptoEngine.decryptByte()) & 255);
            this.zipCryptoEngine.updateKeys(decryptByte);
            bArr[i3] = decryptByte;
        }
        return i2;
    }

    private void init(byte[] bArr) throws ZipException {
        byte[] bArr2 = this.crc;
        byte[] bArr3 = this.crcBytes;
        bArr2[3] = (byte) (bArr3[3] & 255);
        bArr2[2] = (byte) ((bArr3[3] >> 8) & 255);
        bArr2[1] = (byte) ((bArr3[3] >> 16) & 255);
        int i = 0;
        bArr2[0] = (byte) ((bArr3[3] >> 24) & 255);
        if (bArr2[2] > 0 || bArr2[1] > 0 || bArr2[0] > 0) {
            throw new IllegalStateException("Invalid CRC in File Header");
        }
        char[] cArr = this.password;
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
        }
        this.zipCryptoEngine.initKeys(cArr);
        byte b = bArr[0];
        while (i < 12) {
            ZipCryptoEngine zipCryptoEngine2 = this.zipCryptoEngine;
            zipCryptoEngine2.updateKeys((byte) (zipCryptoEngine2.decryptByte() ^ b));
            i++;
            if (i != 12) {
                b = bArr[i];
            }
        }
    }
}
