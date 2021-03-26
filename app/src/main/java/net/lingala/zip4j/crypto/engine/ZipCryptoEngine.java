package net.lingala.zip4j.crypto.engine;

public class ZipCryptoEngine {
    private static final int[] CRC_TABLE = new int[256];
    private final int[] keys = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ -306674912 : i2 >>> 1;
            }
            CRC_TABLE[i] = i2;
        }
    }

    public void initKeys(char[] cArr) {
        int[] iArr = this.keys;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (char c : cArr) {
            updateKeys((byte) (c & 255));
        }
    }

    public void updateKeys(byte b) {
        int[] iArr = this.keys;
        iArr[0] = crc32(iArr[0], b);
        int[] iArr2 = this.keys;
        iArr2[1] = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = (iArr2[1] * 134775813) + 1;
        iArr2[2] = crc32(iArr2[2], (byte) (iArr2[1] >> 24));
    }

    private int crc32(int i, byte b) {
        return CRC_TABLE[(i ^ b) & 255] ^ (i >>> 8);
    }

    public byte decryptByte() {
        int i = this.keys[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }
}
