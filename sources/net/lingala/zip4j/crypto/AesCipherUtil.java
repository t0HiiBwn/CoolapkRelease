package net.lingala.zip4j.crypto;

public class AesCipherUtil {
    public static void prepareBuffAESIVBytes(byte[] bArr, int i) {
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) (i >> 24);
        for (int i2 = 4; i2 <= 15; i2++) {
            bArr[i2] = 0;
        }
    }
}
