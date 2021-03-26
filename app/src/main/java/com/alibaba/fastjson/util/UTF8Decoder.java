package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    private static boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    private static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i2);
            }
        }
        return CoderResult.malformedForLength(i);
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i) {
        int i2 = 1;
        if (i == 1) {
            byte b = byteBuffer.get();
            if ((b >> 2) == -2) {
                if (byteBuffer.remaining() < 4) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 5);
            } else if ((b >> 1) != -2) {
                return CoderResult.malformedForLength(1);
            } else {
                if (byteBuffer.remaining() < 5) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 6);
            }
        } else if (i == 2) {
            return CoderResult.malformedForLength(1);
        } else {
            if (i == 3) {
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                if (!(b2 == -32 && (b3 & 224) == 128) && !isNotContinuation(b3)) {
                    i2 = 2;
                }
                return CoderResult.malformedForLength(i2);
            } else if (i == 4) {
                int i3 = byteBuffer.get() & 255;
                int i4 = byteBuffer.get() & 255;
                if (i3 > 244 || ((i3 == 240 && (i4 < 144 || i4 > 191)) || ((i3 == 244 && (i4 & 240) != 128) || isNotContinuation(i4)))) {
                    return CoderResult.malformedForLength(1);
                }
                if (isNotContinuation(byteBuffer.get())) {
                    return CoderResult.malformedForLength(2);
                }
                return CoderResult.malformedForLength(3);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i3);
        byteBuffer.position(i);
        charBuffer.position(i2);
        return malformedN;
    }

    private static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        buffer.position(i);
        buffer2.position(i3);
        return (i4 == 0 || i2 - i < i4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        return xflow(r13, r5, r6, r14, r8, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ca, code lost:
        return xflow(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012f, code lost:
        return xflow(r13, r5, r6, r14, r8, 4);
     */
    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i;
        int i2;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int arrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] array2 = charBuffer.array();
        int arrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int arrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int min = Math.min(arrayOffset2 - arrayOffset, arrayOffset4 - arrayOffset3) + arrayOffset3;
        while (arrayOffset3 < min && array[arrayOffset] >= 0) {
            array2[arrayOffset3] = (char) array[arrayOffset];
            arrayOffset3++;
            arrayOffset++;
        }
        int i3 = arrayOffset;
        loop1:
        while (true) {
            i = arrayOffset3;
            while (i3 < arrayOffset2) {
                byte b = array[i3];
                if (b < 0) {
                    if ((b >> 5) == -2) {
                        if (arrayOffset2 - i3 < 2 || i >= arrayOffset4) {
                            break loop1;
                        }
                        byte b2 = array[i3 + 1];
                        if (isMalformed2(b, b2)) {
                            return malformed(byteBuffer, i3, charBuffer, i, 2);
                        }
                        i2 = i + 1;
                        array2[i] = (char) (((b << 6) ^ b2) ^ 3968);
                        i3 += 2;
                    } else if ((b >> 4) == -2) {
                        if (arrayOffset2 - i3 < 3 || i >= arrayOffset4) {
                            break loop1;
                        }
                        byte b3 = array[i3 + 1];
                        byte b4 = array[i3 + 2];
                        if (isMalformed3(b, b3, b4)) {
                            return malformed(byteBuffer, i3, charBuffer, i, 3);
                        }
                        i2 = i + 1;
                        array2[i] = (char) ((((b << 12) ^ (b3 << 6)) ^ b4) ^ 8064);
                        i3 += 3;
                    } else if ((b >> 3) != -2) {
                        return malformed(byteBuffer, i3, charBuffer, i, 1);
                    } else {
                        if (arrayOffset2 - i3 < 4 || arrayOffset4 - i < 2) {
                            break;
                        }
                        byte b5 = array[i3 + 1];
                        byte b6 = array[i3 + 2];
                        byte b7 = array[i3 + 3];
                        int i4 = ((b & 7) << 18) | ((b5 & 63) << 12) | ((b6 & 63) << 6) | (b7 & 63);
                        if (isMalformed4(b5, b6, b7) || i4 < 65536 || i4 > 1114111) {
                            break;
                        }
                        int i5 = i + 1;
                        int i6 = i4 - 65536;
                        array2[i] = (char) (((i6 >> 10) & 1023) | 55296);
                        arrayOffset3 = i5 + 1;
                        array2[i5] = (char) ((i6 & 1023) | 56320);
                        i3 += 4;
                    }
                    i = i2;
                } else if (i >= arrayOffset4) {
                    return xflow(byteBuffer, i3, arrayOffset2, charBuffer, i, 1);
                } else {
                    arrayOffset3 = i + 1;
                    array2[i] = (char) b;
                    i3++;
                }
            }
            return xflow(byteBuffer, i3, arrayOffset2, charBuffer, i, 0);
        }
        return malformed(byteBuffer, i3, charBuffer, i, 4);
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
