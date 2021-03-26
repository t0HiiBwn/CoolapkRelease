package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;

public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    float f = 0.25f;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], 0.7f);
                        if (patternMatchVariance < f) {
                            i3 = i4;
                            f = patternMatchVariance;
                        }
                    }
                    if (i3 >= 0 && bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        return new int[]{i, nextSet, i3};
                    }
                    i += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i3 >= iArr2.length) {
                break;
            }
            float patternMatchVariance = patternMatchVariance(iArr, iArr2[i3], 0.7f);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e1, code lost:
        if (r9 != false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0127, code lost:
        if (r9 != false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0129, code lost:
        r3 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012e A[PHI: r17 
      PHI: (r17v12 boolean) = (r17v17 boolean), (r17v19 boolean) binds: [B:62:0x0107, B:41:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x013a A[PHI: r16 r17 
      PHI: (r16v5 boolean) = (r16v6 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean) binds: [B:79:0x0138, B:62:0x0107, B:63:0x010b, B:67:0x0117, B:66:0x0113, B:41:0x00c1, B:42:0x00c6, B:46:0x00d3, B:45:0x00ce] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r17v10 boolean) = (r17v11 boolean), (r17v17 boolean), (r17v17 boolean), (r17v17 boolean), (r17v17 boolean), (r17v19 boolean), (r17v19 boolean), (r17v19 boolean), (r17v19 boolean) binds: [B:79:0x0138, B:62:0x0107, B:63:0x010b, B:67:0x0117, B:66:0x0113, B:41:0x00c1, B:42:0x00c6, B:46:0x00d3, B:45:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        char c;
        boolean z;
        boolean z2 = false;
        boolean z3 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] findStartPattern = findStartPattern(bitArray);
        int i2 = findStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i2));
        switch (i2) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb = new StringBuilder(20);
        int i3 = 6;
        int[] iArr = new int[6];
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = findStartPattern[0];
        int i8 = findStartPattern[1];
        char c2 = c;
        while (!z5) {
            int decodeCode = decodeCode(bitArray, iArr, i8);
            arrayList.add(Byte.valueOf((byte) decodeCode));
            if (decodeCode != 106) {
                z6 = true;
            }
            if (decodeCode != 106) {
                i5++;
                i2 += i5 * decodeCode;
            }
            int i9 = i8;
            for (int i10 = 0; i10 < i3; i10++) {
                i9 += iArr[i10];
            }
            switch (decodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c2) {
                        case 'c':
                            if (decodeCode >= 100) {
                                if (decodeCode != 106) {
                                    z6 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 100:
                                            z = false;
                                            c2 = 'd';
                                            break;
                                        case 101:
                                            z = false;
                                            c2 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                        default:
                                            z = false;
                                            break;
                                    }
                                } else {
                                    z = false;
                                    z5 = true;
                                    break;
                                }
                            } else {
                                if (decodeCode < 10) {
                                    sb.append('0');
                                }
                                sb.append(decodeCode);
                            }
                            z = false;
                        case 'd':
                            if (decodeCode < 96) {
                                if (z4 == z2) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                                z = false;
                                z4 = false;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z6 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 96:
                                        case 97:
                                        default:
                                            z = false;
                                            break;
                                        case 98:
                                            z = true;
                                            c2 = 'e';
                                            break;
                                        case 99:
                                            z = false;
                                            c2 = 'c';
                                            break;
                                        case 100:
                                            if (z2 || !z4) {
                                                if (z2) {
                                                }
                                                z = false;
                                                z4 = true;
                                                break;
                                            }
                                            z2 = true;
                                            z = false;
                                            z4 = false;
                                            break;
                                        case 101:
                                            z = false;
                                            c2 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                            z = false;
                                            break;
                                    }
                                }
                                z5 = true;
                                z = false;
                            }
                            break;
                        case 'e':
                            if (decodeCode < 64) {
                                if (z4 == z2) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                            } else if (decodeCode >= 96) {
                                if (decodeCode != 106) {
                                    z6 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 98:
                                            z = true;
                                            c2 = 'd';
                                            break;
                                        case 100:
                                            z = false;
                                            c2 = 'd';
                                            break;
                                        case 101:
                                            if (z2 || !z4) {
                                                if (z2) {
                                                }
                                                z = false;
                                                z4 = true;
                                                break;
                                            }
                                            z2 = true;
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                            z = false;
                                            break;
                                    }
                                }
                                z5 = true;
                                z = false;
                            } else if (z4 == z2) {
                                sb.append((char) (decodeCode - 64));
                            } else {
                                sb.append((char) (decodeCode + 64));
                            }
                            z = false;
                            z4 = false;
                            break;
                        default:
                            z = false;
                            break;
                    }
                    if (z7) {
                        c2 = c2 == 'e' ? 'd' : 'e';
                    }
                    z7 = z;
                    i3 = 6;
                    i7 = i8;
                    i8 = i9;
                    i6 = i4;
                    i4 = decodeCode;
                    break;
            }
        }
        int i11 = i8 - i7;
        int nextUnset = bitArray.getNextUnset(i8);
        if (!bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i7) / 2) + nextUnset), false)) {
            throw NotFoundException.getNotFoundInstance();
        } else if ((i2 - (i5 * i6)) % 103 == i6) {
            int length = sb.length();
            if (length != 0) {
                if (length > 0 && z6) {
                    if (c2 == 'c') {
                        sb.delete(length - 2, length);
                    } else {
                        sb.delete(length - 1, length);
                    }
                }
                float f = ((float) (findStartPattern[1] + findStartPattern[0])) / 2.0f;
                float f2 = ((float) i7) + (((float) i11) / 2.0f);
                int size = arrayList.size();
                byte[] bArr = new byte[size];
                for (int i12 = 0; i12 < size; i12++) {
                    bArr[i12] = ((Byte) arrayList.get(i12)).byteValue();
                }
                float f3 = (float) i;
                return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f, f3), new ResultPoint(f2, f3)}, BarcodeFormat.CODE_128);
            }
            throw NotFoundException.getNotFoundInstance();
        } else {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
