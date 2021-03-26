package okio.internal;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: -Utf8.kt */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x011e, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L_0x0124;
     */
    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        Intrinsics.checkNotNullParameter(bArr, "$this$commonToUtf8String");
        if (i7 < 0 || i2 > bArr.length || i7 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i7 + " endIndex=" + i2);
        }
        char[] cArr = new char[(i2 - i7)];
        int i8 = 0;
        while (i7 < i2) {
            byte b = bArr[i7];
            if (b >= 0) {
                i5 = i8 + 1;
                cArr[i8] = (char) b;
                i7++;
                while (i7 < i2 && bArr[i7] >= 0) {
                    cArr[i5] = (char) bArr[i7];
                    i7++;
                    i5++;
                }
            } else {
                if ((b >> 5) == -2) {
                    int i9 = i7 + 1;
                    if (i2 <= i9) {
                        i5 = i8 + 1;
                        cArr[i8] = (char) 65533;
                    } else {
                        byte b2 = bArr[i7];
                        byte b3 = bArr[i9];
                        if (!((b3 & 192) == 128)) {
                            i5 = i8 + 1;
                            cArr[i8] = (char) 65533;
                        } else {
                            int i10 = (b3 ^ 3968) ^ (b2 << 6);
                            if (i10 < 128) {
                                i5 = i8 + 1;
                                cArr[i8] = (char) 65533;
                            } else {
                                i5 = i8 + 1;
                                cArr[i8] = (char) i10;
                            }
                            Unit unit = Unit.INSTANCE;
                            i6 = 2;
                            i7 += i6;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } else if ((b >> 4) == -2) {
                    int i11 = i7 + 2;
                    if (i2 <= i11) {
                        i5 = i8 + 1;
                        cArr[i8] = (char) 65533;
                        Unit unit3 = Unit.INSTANCE;
                        int i12 = i7 + 1;
                        if (i2 > i12) {
                        }
                    } else {
                        byte b4 = bArr[i7];
                        byte b5 = bArr[i7 + 1];
                        if (!((b5 & 192) == 128)) {
                            i5 = i8 + 1;
                            cArr[i8] = (char) 65533;
                            Unit unit4 = Unit.INSTANCE;
                        } else {
                            byte b6 = bArr[i11];
                            if (!((b6 & 192) == 128)) {
                                i5 = i8 + 1;
                                cArr[i8] = (char) 65533;
                                Unit unit5 = Unit.INSTANCE;
                                i6 = 2;
                                i7 += i6;
                            } else {
                                int i13 = ((b6 ^ -123008) ^ (b5 << 6)) ^ (b4 << 12);
                                if (i13 < 2048) {
                                    i5 = i8 + 1;
                                    cArr[i8] = (char) 65533;
                                } else if (55296 <= i13 && 57343 >= i13) {
                                    i5 = i8 + 1;
                                    cArr[i8] = (char) 65533;
                                } else {
                                    i5 = i8 + 1;
                                    cArr[i8] = (char) i13;
                                }
                                Unit unit6 = Unit.INSTANCE;
                                i6 = 3;
                                i7 += i6;
                            }
                        }
                    }
                } else {
                    if ((b >> 3) == -2) {
                        int i14 = i7 + 3;
                        if (i2 <= i14) {
                            i3 = i8 + 1;
                            cArr[i8] = 65533;
                            Unit unit7 = Unit.INSTANCE;
                            int i15 = i7 + 1;
                            if (i2 > i15) {
                                if ((bArr[i15] & 192) == 128) {
                                    int i16 = i7 + 2;
                                    if (i2 > i16) {
                                    }
                                    i4 = 2;
                                    i7 += i4;
                                }
                            }
                            i4 = 1;
                            i7 += i4;
                        } else {
                            byte b7 = bArr[i7];
                            byte b8 = bArr[i7 + 1];
                            if (!((b8 & 192) == 128)) {
                                i3 = i8 + 1;
                                cArr[i8] = 65533;
                                Unit unit8 = Unit.INSTANCE;
                                i4 = 1;
                                i7 += i4;
                            } else {
                                byte b9 = bArr[i7 + 2];
                                if (!((b9 & 192) == 128)) {
                                    i3 = i8 + 1;
                                    cArr[i8] = 65533;
                                    Unit unit9 = Unit.INSTANCE;
                                    i4 = 2;
                                    i7 += i4;
                                } else {
                                    byte b10 = bArr[i14];
                                    if (!((b10 & 192) == 128)) {
                                        i3 = i8 + 1;
                                        cArr[i8] = 65533;
                                        Unit unit10 = Unit.INSTANCE;
                                    } else {
                                        int i17 = (((b10 ^ 3678080) ^ (b9 << 6)) ^ (b8 << 12)) ^ (b7 << 18);
                                        if (i17 > 1114111) {
                                            i3 = i8 + 1;
                                            cArr[i8] = 65533;
                                        } else if (55296 <= i17 && 57343 >= i17) {
                                            i3 = i8 + 1;
                                            cArr[i8] = 65533;
                                        } else if (i17 < 65536) {
                                            i3 = i8 + 1;
                                            cArr[i8] = 65533;
                                        } else if (i17 != 65533) {
                                            int i18 = i8 + 1;
                                            cArr[i8] = (char) ((i17 >>> 10) + 55232);
                                            i3 = i18 + 1;
                                            cArr[i18] = (char) ((i17 & 1023) + 56320);
                                        } else {
                                            i3 = i8 + 1;
                                            cArr[i8] = 65533;
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                        i4 = 4;
                                        i7 += i4;
                                    }
                                }
                            }
                        }
                        i4 = 3;
                        i7 += i4;
                    } else {
                        i3 = i8 + 1;
                        cArr[i8] = 65533;
                        i7++;
                    }
                    i8 = i3;
                }
                i6 = 1;
                i7 += i6;
            }
            i8 = i5;
        }
        return new String(cArr, 0, i8);
    }

    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt2 = str.charAt(i3);
            if (Intrinsics.compare((int) charAt2, 128) >= 0) {
                int length2 = str.length();
                int i4 = i3;
                while (i3 < length2) {
                    char charAt3 = str.charAt(i3);
                    if (Intrinsics.compare((int) charAt3, 128) < 0) {
                        int i5 = i4 + 1;
                        bArr[i4] = (byte) charAt3;
                        i3++;
                        while (i3 < length2 && Intrinsics.compare((int) str.charAt(i3), 128) < 0) {
                            bArr[i5] = (byte) str.charAt(i3);
                            i3++;
                            i5++;
                        }
                        i4 = i5;
                    } else {
                        if (Intrinsics.compare((int) charAt3, 2048) < 0) {
                            int i6 = i4 + 1;
                            bArr[i4] = (byte) ((charAt3 >> 6) | 192);
                            i = i6 + 1;
                            bArr[i6] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            int i7 = i4 + 1;
                            bArr[i4] = (byte) ((charAt3 >> '\f') | 224);
                            int i8 = i7 + 1;
                            bArr[i7] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i = i8 + 1;
                            bArr[i8] = (byte) ((charAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) charAt3, 56319) > 0 || length2 <= (i2 = i3 + 1) || 56320 > (charAt = str.charAt(i2)) || 57343 < charAt) {
                            i = i4 + 1;
                            bArr[i4] = 63;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + str.charAt(i2)) - 56613888;
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((charAt4 >> 18) | 240);
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((charAt4 >> 12) & 63) | 128);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i = i11 + 1;
                            bArr[i11] = (byte) ((charAt4 & 63) | 128);
                            i3 += 2;
                            i4 = i;
                        }
                        i3++;
                        i4 = i;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i4);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i3] = (byte) charAt2;
            i3++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }
}
