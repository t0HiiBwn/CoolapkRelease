package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Base64 implements BinaryEncoder, BinaryDecoder {
    static final int BASELENGTH = 255;
    static final byte[] CHUNK_SEPARATOR = "\r\n".getBytes();
    static final int CHUNK_SIZE = 76;
    static final int EIGHTBIT = 8;
    static final int FOURBYTE = 4;
    static final int LOOKUPLENGTH = 64;
    static final byte PAD = 61;
    static final int SIGN = -128;
    static final int SIXTEENBIT = 16;
    static final int TWENTYFOURBITGROUP = 24;
    private static byte[] base64Alphabet = new byte[255];
    private static byte[] lookUpBase64Alphabet = new byte[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 255; i4++) {
            base64Alphabet[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            base64Alphabet[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            base64Alphabet[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            base64Alphabet[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = base64Alphabet;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            lookUpBase64Alphabet[i8] = (byte) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            lookUpBase64Alphabet[i] = (byte) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            lookUpBase64Alphabet[i2] = (byte) (i3 + 48);
            i2++;
            i3++;
        }
        byte[] bArr2 = lookUpBase64Alphabet;
        bArr2[62] = 43;
        bArr2[63] = 47;
    }

    private static boolean isBase64(byte b) {
        if (b == 61) {
            return true;
        }
        return b >= 0 && base64Alphabet[b] != -1;
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        byte[] discardWhitespace = discardWhitespace(bArr);
        int length = discardWhitespace.length;
        if (length == 0) {
            return true;
        }
        for (byte b : discardWhitespace) {
            if (!isBase64(b)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        return decodeBase64(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        int i;
        int length = bArr.length * 8;
        int i2 = length % 24;
        int i3 = length / 24;
        int i4 = i2 != 0 ? (i3 + 1) * 4 : i3 * 4;
        if (z) {
            i = CHUNK_SEPARATOR.length == 0 ? 0 : (int) Math.ceil((double) (((float) i4) / 76.0f));
            i4 += CHUNK_SEPARATOR.length * i;
        } else {
            i = 0;
        }
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 76;
        while (i5 < i3) {
            int i9 = i5 * 3;
            byte b = bArr[i9];
            byte b2 = bArr[i9 + 1];
            byte b3 = bArr[i9 + 2];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            int i10 = b & Byte.MIN_VALUE;
            int i11 = b >> 2;
            if (i10 != 0) {
                i11 ^= 192;
            }
            byte b6 = (byte) i11;
            int i12 = b2 & Byte.MIN_VALUE;
            int i13 = b2 >> 4;
            if (i12 != 0) {
                i13 ^= 240;
            }
            byte b7 = (byte) i13;
            int i14 = b3 >> 6;
            if ((b3 & Byte.MIN_VALUE) != 0) {
                i14 ^= 252;
            }
            byte[] bArr3 = lookUpBase64Alphabet;
            bArr2[i6] = bArr3[b6];
            bArr2[i6 + 1] = bArr3[(b5 << 4) | b7];
            bArr2[i6 + 2] = bArr3[(b4 << 2) | ((byte) i14)];
            bArr2[i6 + 3] = bArr3[b3 & 63];
            i6 += 4;
            if (z && i6 == i8) {
                byte[] bArr4 = CHUNK_SEPARATOR;
                System.arraycopy(bArr4, 0, bArr2, i6, bArr4.length);
                i7++;
                byte[] bArr5 = CHUNK_SEPARATOR;
                i8 = (bArr5.length * i7) + ((i7 + 1) * 76);
                i6 += bArr5.length;
            }
            i5++;
        }
        int i15 = i5 * 3;
        if (i2 == 8) {
            byte b8 = bArr[i15];
            byte b9 = (byte) (b8 & 3);
            int i16 = b8 & Byte.MIN_VALUE;
            int i17 = b8 >> 2;
            if (i16 != 0) {
                i17 ^= 192;
            }
            byte[] bArr6 = lookUpBase64Alphabet;
            bArr2[i6] = bArr6[(byte) i17];
            bArr2[i6 + 1] = bArr6[b9 << 4];
            bArr2[i6 + 2] = 61;
            bArr2[i6 + 3] = 61;
        } else if (i2 == 16) {
            byte b10 = bArr[i15];
            byte b11 = bArr[i15 + 1];
            byte b12 = (byte) (b11 & 15);
            byte b13 = (byte) (b10 & 3);
            int i18 = b10 & Byte.MIN_VALUE;
            int i19 = b10 >> 2;
            if (i18 != 0) {
                i19 ^= 192;
            }
            byte b14 = (byte) i19;
            int i20 = b11 & Byte.MIN_VALUE;
            int i21 = b11 >> 4;
            if (i20 != 0) {
                i21 ^= 240;
            }
            byte[] bArr7 = lookUpBase64Alphabet;
            bArr2[i6] = bArr7[b14];
            bArr2[i6 + 1] = bArr7[((byte) i21) | (b13 << 4)];
            bArr2[i6 + 2] = bArr7[b12 << 2];
            bArr2[i6 + 3] = 61;
        }
        if (z && i7 < i) {
            byte[] bArr8 = CHUNK_SEPARATOR;
            System.arraycopy(bArr8, 0, bArr2, i4 - bArr8.length, bArr8.length);
        }
        return bArr2;
    }

    public static byte[] decodeBase64(byte[] bArr) {
        byte[] discardNonBase64 = discardNonBase64(bArr);
        if (discardNonBase64.length == 0) {
            return new byte[0];
        }
        int length = discardNonBase64.length / 4;
        int length2 = discardNonBase64.length;
        while (discardNonBase64[length2 - 1] == 61) {
            length2--;
            if (length2 == 0) {
                return new byte[0];
            }
        }
        byte[] bArr2 = new byte[(length2 - length)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 4;
            byte b = discardNonBase64[i3 + 2];
            byte b2 = discardNonBase64[i3 + 3];
            byte[] bArr3 = base64Alphabet;
            byte b3 = bArr3[discardNonBase64[i3]];
            byte b4 = bArr3[discardNonBase64[i3 + 1]];
            if (b != 61 && b2 != 61) {
                byte b5 = bArr3[b];
                byte b6 = bArr3[b2];
                bArr2[i] = (byte) ((b3 << 2) | (b4 >> 4));
                bArr2[i + 1] = (byte) (((b4 & 15) << 4) | ((b5 >> 2) & 15));
                bArr2[i + 2] = (byte) ((b5 << 6) | b6);
            } else if (b == 61) {
                bArr2[i] = (byte) ((b4 >> 4) | (b3 << 2));
            } else if (b2 == 61) {
                byte b7 = base64Alphabet[b];
                bArr2[i] = (byte) ((b3 << 2) | (b4 >> 4));
                bArr2[i + 1] = (byte) (((b4 & 15) << 4) | ((b7 >> 2) & 15));
            }
            i += 3;
        }
        return bArr2;
    }

    static byte[] discardWhitespace(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            if (!(b == 9 || b == 10 || b == 13 || b == 32)) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    static byte[] discardNonBase64(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (isBase64(bArr[i2])) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeBase64(bArr, false);
    }
}
