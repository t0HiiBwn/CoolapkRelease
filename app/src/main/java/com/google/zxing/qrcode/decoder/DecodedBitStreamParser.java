package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e7 A[LOOP:0: B:1:0x001e->B:60:0x00e7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c6 A[SYNTHETIC] */
    static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        String str;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i = 1;
        ArrayList arrayList = new ArrayList(1);
        CharacterSetECI characterSetECI = null;
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            try {
                if (bitSource.available() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(bitSource.readBits(4));
                }
                if (forBits != Mode.TERMINATOR) {
                    if (forBits != Mode.FNC1_FIRST_POSITION) {
                        if (forBits != Mode.FNC1_SECOND_POSITION) {
                            if (forBits == Mode.STRUCTURED_APPEND) {
                                if (bitSource.available() >= 16) {
                                    int readBits = bitSource.readBits(8);
                                    i3 = bitSource.readBits(8);
                                    i2 = readBits;
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            } else if (forBits == Mode.ECI) {
                                characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                                if (characterSetECI == null) {
                                    throw FormatException.getFormatInstance();
                                }
                            } else if (forBits == Mode.HANZI) {
                                int readBits2 = bitSource.readBits(4);
                                int readBits3 = bitSource.readBits(forBits.getCharacterCountBits(version));
                                if (readBits2 == i) {
                                    decodeHanziSegment(bitSource, sb, readBits3);
                                }
                            } else {
                                int readBits4 = bitSource.readBits(forBits.getCharacterCountBits(version));
                                if (forBits == Mode.NUMERIC) {
                                    decodeNumericSegment(bitSource, sb, readBits4);
                                } else if (forBits == Mode.ALPHANUMERIC) {
                                    decodeAlphanumericSegment(bitSource, sb, readBits4, z);
                                } else {
                                    if (forBits == Mode.BYTE) {
                                        mode = forBits;
                                        decodeByteSegment(bitSource, sb, readBits4, characterSetECI, arrayList, map);
                                    } else {
                                        mode = forBits;
                                        if (mode == Mode.KANJI) {
                                            decodeKanjiSegment(bitSource, sb, readBits4);
                                        } else {
                                            throw FormatException.getFormatInstance();
                                        }
                                    }
                                    if (mode == Mode.TERMINATOR) {
                                        String sb2 = sb.toString();
                                        ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
                                        if (errorCorrectionLevel == null) {
                                            str = null;
                                        } else {
                                            str = errorCorrectionLevel.toString();
                                        }
                                        return new DecoderResult(bArr, sb2, arrayList2, str, i2, i3);
                                    }
                                    i = 1;
                                }
                            }
                        }
                    }
                    mode = forBits;
                    z = true;
                    if (mode == Mode.TERMINATOR) {
                    }
                }
                mode = forBits;
                if (mode == Mode.TERMINATOR) {
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int readBits = bitSource.readBits(13);
                int i3 = (readBits % 96) | ((readBits / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int readBits = bitSource.readBits(13);
                int i3 = (readBits % 192) | ((readBits / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String str;
        if ((i << 3) <= bitSource.available()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) bitSource.readBits(8);
            }
            if (characterSetECI == null) {
                str = StringUtils.guessEncoding(bArr, map);
            } else {
                str = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.getFormatInstance();
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (bitSource.available() >= 11) {
                int readBits = bitSource.readBits(11);
                sb.append(toAlphaNumericChar(readBits / 45));
                sb.append(toAlphaNumericChar(readBits % 45));
                i -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 1) {
            if (bitSource.available() >= 6) {
                sb.append(toAlphaNumericChar(bitSource.readBits(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() >= 10) {
                int readBits = bitSource.readBits(10);
                if (readBits < 1000) {
                    sb.append(toAlphaNumericChar(readBits / 100));
                    sb.append(toAlphaNumericChar((readBits / 10) % 10));
                    sb.append(toAlphaNumericChar(readBits % 10));
                    i -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 2) {
            if (bitSource.available() >= 7) {
                int readBits2 = bitSource.readBits(7);
                if (readBits2 < 100) {
                    sb.append(toAlphaNumericChar(readBits2 / 10));
                    sb.append(toAlphaNumericChar(readBits2 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i != 1) {
        } else {
            if (bitSource.available() >= 4) {
                int readBits3 = bitSource.readBits(4);
                if (readBits3 < 10) {
                    sb.append(toAlphaNumericChar(readBits3));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }
}
