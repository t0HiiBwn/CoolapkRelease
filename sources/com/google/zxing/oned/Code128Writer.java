package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i3 < length) {
            int chooseCode = chooseCode(str, i3, i5);
            int i7 = 100;
            if (chooseCode == i5) {
                switch (str.charAt(i3)) {
                    case 241:
                        i7 = 102;
                        break;
                    case 242:
                        i7 = 97;
                        break;
                    case 243:
                        i7 = 96;
                        break;
                    case 244:
                        break;
                    default:
                        if (i5 == 100) {
                            i7 = str.charAt(i3) - ' ';
                            break;
                        } else {
                            i7 = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3++;
                            break;
                        }
                }
                i3++;
            } else {
                i7 = i5 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
                i5 = chooseCode;
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[i7]);
            i4 += i7 * i6;
            if (i3 != 0) {
                i6++;
            }
        }
        arrayList.add(Code128Reader.CODE_PATTERNS[i4 % 103]);
        arrayList.add(Code128Reader.CODE_PATTERNS[106]);
        int i8 = 0;
        for (int[] iArr : arrayList) {
            for (int i9 : iArr) {
                i8 += i9;
            }
        }
        boolean[] zArr = new boolean[i8];
        for (int[] iArr2 : arrayList) {
            i += appendPattern(zArr, i, iArr2, true);
        }
        return zArr;
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType findCType;
        CType findCType2;
        CType findCType3 = findCType(charSequence, i);
        if (!(findCType3 == CType.UNCODABLE || findCType3 == CType.ONE_DIGIT)) {
            if (i2 == 99) {
                return i2;
            }
            if (i2 != 100) {
                if (findCType3 == CType.FNC_1) {
                    findCType3 = findCType(charSequence, i + 1);
                }
                if (findCType3 == CType.TWO_DIGITS) {
                    return 99;
                }
            } else if (findCType3 == CType.FNC_1 || (findCType = findCType(charSequence, i + 2)) == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
                return i2;
            } else {
                if (findCType == CType.FNC_1) {
                    return findCType(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i3 = i + 4;
                while (true) {
                    findCType2 = findCType(charSequence, i3);
                    if (findCType2 != CType.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                return findCType2 == CType.ONE_DIGIT ? 100 : 99;
            }
        }
        return 100;
    }
}
