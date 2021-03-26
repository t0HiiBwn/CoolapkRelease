package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        bigIntegerArr[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = DEFAULT_ENCODING;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 != 913) {
                switch (i2) {
                    case 900:
                        i = textCompaction(iArr, i3, sb);
                        break;
                    case 901:
                        i = byteCompaction(i2, iArr, charset, i3, sb);
                        break;
                    case 902:
                        i = numericCompaction(iArr, i3, sb);
                        break;
                    default:
                        switch (i2) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i = i3 + 1;
                                break;
                            case 926:
                                i = i3 + 2;
                                break;
                            case 927:
                                i = i3 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i3]).name());
                                break;
                            case 928:
                                i = decodeMacroBlock(iArr, i3, pDF417ResultMetadata);
                                break;
                            default:
                                i = textCompaction(iArr, i3 - 1, sb);
                                break;
                        }
                }
            } else {
                i = i3 + 1;
                sb.append((char) iArr[i3]);
            }
            if (i < iArr.length) {
                i3 = i + 1;
                i2 = iArr[i];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = 0;
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            if (iArr[textCompaction] == 923) {
                int i3 = textCompaction + 1;
                int[] iArr3 = new int[(iArr[0] - i3)];
                boolean z = false;
                int i4 = 0;
                while (i3 < iArr[0] && !z) {
                    int i5 = i3 + 1;
                    int i6 = iArr[i3];
                    if (i6 < 900) {
                        iArr3[i4] = i6;
                        i3 = i5;
                        i4++;
                    } else if (i6 == 922) {
                        pDF417ResultMetadata.setLastSegment(true);
                        i3 = i5 + 1;
                        z = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i4));
                return i3;
            } else if (iArr[textCompaction] != 922) {
                return textCompaction;
            } else {
                pDF417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) << 1)];
        int[] iArr3 = new int[((iArr[0] - i) << 1)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != 913) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            iArr2[i2] = 900;
                            i2++;
                            break;
                        default:
                            switch (i4) {
                            }
                        case 901:
                        case 902:
                            i = i3 - 1;
                            z = true;
                            break;
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = 913;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        int i2;
        Mode mode;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = Mode.ALPHA;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            char c = ' ';
            switch (AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()]) {
                case 1:
                    if (i4 >= 26) {
                        if (i4 != 26) {
                            if (i4 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i4 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c = 0;
                                mode3 = mode2;
                                mode2 = mode;
                                break;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c = 0;
                            break;
                        }
                    } else {
                        i2 = i4 + 65;
                        c = (char) i2;
                        break;
                    }
                    break;
                case 2:
                    if (i4 >= 26) {
                        if (i4 != 26) {
                            if (i4 != 27) {
                                if (i4 == 28) {
                                    mode2 = Mode.MIXED;
                                } else if (i4 == 29) {
                                    mode = Mode.PUNCT_SHIFT;
                                } else if (i4 == 913) {
                                    sb.append((char) iArr2[i3]);
                                } else if (i4 == 900) {
                                    mode2 = Mode.ALPHA;
                                }
                                c = 0;
                                break;
                            } else {
                                mode = Mode.ALPHA_SHIFT;
                            }
                            c = 0;
                            mode3 = mode2;
                            mode2 = mode;
                            break;
                        }
                    } else {
                        i2 = i4 + 97;
                        c = (char) i2;
                        break;
                    }
                    break;
                case 3:
                    if (i4 < 25) {
                        c = MIXED_CHARS[i4];
                        break;
                    } else {
                        if (i4 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i4 != 26) {
                            if (i4 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i4 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c = 0;
                                mode3 = mode2;
                                mode2 = mode;
                                break;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                        break;
                    } else {
                        if (i4 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c = 0;
                        break;
                    }
                case 5:
                    if (i4 < 26) {
                        c = (char) (i4 + 65);
                    } else if (i4 != 26) {
                        if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                            c = 0;
                            break;
                        }
                        mode2 = mode3;
                        c = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i4 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            mode2 = mode3;
                        }
                        c = 0;
                        break;
                    }
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = 922;
        int i7 = 923;
        int i8 = 928;
        int i9 = 902;
        long j = 900;
        if (i == 901) {
            int[] iArr2 = new int[6];
            i3 = i2 + 1;
            int i10 = iArr[i2];
            boolean z = false;
            loop0:
            while (true) {
                i4 = 0;
                long j2 = 0;
                while (i3 < iArr[0] && !z) {
                    int i11 = i4 + 1;
                    iArr2[i4] = i10;
                    j2 = (j2 * j) + ((long) i10);
                    int i12 = i3 + 1;
                    i10 = iArr[i3];
                    if (i10 == 900 || i10 == 901 || i10 == 902 || i10 == 924 || i10 == 928 || i10 == i7 || i10 == i6) {
                        i3 = i12 - 1;
                        i4 = i11;
                        i6 = 922;
                        i7 = 923;
                        j = 900;
                        z = true;
                    } else if (i11 % 5 != 0 || i11 <= 0) {
                        i3 = i12;
                        i4 = i11;
                        i6 = 922;
                        i7 = 923;
                        j = 900;
                    } else {
                        int i13 = 0;
                        while (i13 < 6) {
                            byteArrayOutputStream.write((byte) ((int) (j2 >> ((5 - i13) * 8))));
                            i13++;
                            i6 = 922;
                            i7 = 923;
                        }
                        i3 = i12;
                        j = 900;
                    }
                }
            }
            if (i3 != iArr[0] || i10 >= 900) {
                i5 = i4;
            } else {
                i5 = i4 + 1;
                iArr2[i4] = i10;
            }
            for (int i14 = 0; i14 < i5; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i == 924) {
            int i15 = i2;
            boolean z2 = false;
            int i16 = 0;
            long j3 = 0;
            while (i15 < iArr[0] && !z2) {
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                if (i18 < 900) {
                    i16++;
                    j3 = (j3 * 900) + ((long) i18);
                    i15 = i17;
                } else {
                    if (i18 != 900 && i18 != 901 && i18 != i9 && i18 != 924 && i18 != i8) {
                        if (!(i18 == 923 || i18 == 922)) {
                            i15 = i17;
                        }
                    }
                    i15 = i17 - 1;
                    z2 = true;
                }
                if (i16 % 5 == 0 && i16 > 0) {
                    for (int i19 = 0; i19 < 6; i19++) {
                        byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i19) * 8))));
                    }
                    i16 = 0;
                    j3 = 0;
                }
                i8 = 928;
                i9 = 902;
            }
            i3 = i15;
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == 900 || i4 == 901 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922) {
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
