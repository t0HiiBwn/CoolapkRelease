package okio;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utf8.kt */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(String str, int i, int i2) {
        int i3;
        char c;
        Intrinsics.checkNotNullParameter(str, "$this$utf8Size");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (z) {
                    long j = 0;
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            j++;
                        } else {
                            if (charAt < 2048) {
                                i3 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i3 = 3;
                            } else {
                                int i4 = i + 1;
                                if (i4 < i2) {
                                    c = str.charAt(i4);
                                } else {
                                    c = 0;
                                }
                                if (charAt > 56319 || c < 56320 || c > 57343) {
                                    j++;
                                    i = i4;
                                } else {
                                    j += (long) 4;
                                    i += 2;
                                }
                            }
                            j += (long) i3;
                        }
                        i++;
                    }
                    return j;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    public static final void processUtf8Bytes(String str, int i, int i2, Function1<? super Byte, Unit> function1) {
        int i3;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "$this$processUtf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (Intrinsics.compare((int) charAt2, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) charAt2));
                i++;
                while (i < i2 && Intrinsics.compare((int) str.charAt(i), 128) < 0) {
                    function1.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (Intrinsics.compare((int) charAt2, 2048) < 0) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 > charAt2 || 57343 < charAt2) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    function1.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (Intrinsics.compare((int) charAt2, 56319) > 0 || i2 <= (i3 = i + 1) || 56320 > (charAt = str.charAt(i3)) || 57343 < charAt) {
                    function1.invoke((byte) 63);
                } else {
                    int charAt3 = ((charAt2 << '\n') + str.charAt(i3)) - 56613888;
                    function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                    i += 2;
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0097, code lost:
        if (r8 == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0118, code lost:
        if (r8 == false) goto L_0x0071;
     */
    public static final void processUtf8CodePoints(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        int i3;
        Intrinsics.checkNotNullParameter(bArr, "$this$processUtf8CodePoints");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i4 = i;
        while (i4 < i2) {
            byte b = bArr[i4];
            if (b >= 0) {
                function1.invoke(Integer.valueOf(b));
                i4++;
                while (i4 < i2 && bArr[i4] >= 0) {
                    function1.invoke(Integer.valueOf(bArr[i4]));
                    i4++;
                }
            } else {
                boolean z = false;
                if ((b >> 5) == -2) {
                    int i5 = i4 + 1;
                    if (i2 > i5) {
                        byte b2 = bArr[i4];
                        byte b3 = bArr[i5];
                        if ((b3 & 192) == 128) {
                            z = true;
                        }
                        if (z) {
                            int i6 = (b3 ^ 3968) ^ (b2 << 6);
                            function1.invoke(i6 < 128 ? 65533 : Integer.valueOf(i6));
                            Unit unit = Unit.INSTANCE;
                            i3 = 2;
                            i4 += i3;
                        }
                    }
                    function1.invoke(65533);
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    if ((b >> 4) == -2) {
                        int i7 = i4 + 2;
                        if (i2 <= i7) {
                            function1.invoke(65533);
                            Unit unit3 = Unit.INSTANCE;
                            int i8 = i4 + 1;
                            if (i2 > i8) {
                                if ((bArr[i8] & 192) == 128) {
                                    z = true;
                                }
                            }
                        } else {
                            byte b4 = bArr[i4];
                            byte b5 = bArr[i4 + 1];
                            if (!((b5 & 192) == 128)) {
                                function1.invoke(65533);
                                Unit unit4 = Unit.INSTANCE;
                            } else {
                                byte b6 = bArr[i7];
                                if ((b6 & 192) == 128) {
                                    z = true;
                                }
                                if (!z) {
                                    function1.invoke(65533);
                                    Unit unit5 = Unit.INSTANCE;
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    int i9 = ((b6 ^ -123008) ^ (b5 << 6)) ^ (b4 << 12);
                                    function1.invoke((i9 >= 2048 && (55296 > i9 || 57343 < i9)) ? Integer.valueOf(i9) : 65533);
                                    Unit unit6 = Unit.INSTANCE;
                                }
                            }
                        }
                    } else if ((b >> 3) == -2) {
                        int i10 = i4 + 3;
                        if (i2 <= i10) {
                            function1.invoke(65533);
                            Unit unit7 = Unit.INSTANCE;
                            int i11 = i4 + 1;
                            if (i2 > i11) {
                                if ((bArr[i11] & 192) == 128) {
                                    int i12 = i4 + 2;
                                    if (i2 > i12) {
                                        if ((bArr[i12] & 192) == 128) {
                                            z = true;
                                        }
                                    }
                                    i3 = 2;
                                    i4 += i3;
                                }
                            }
                        } else {
                            byte b7 = bArr[i4];
                            byte b8 = bArr[i4 + 1];
                            if (!((b8 & 192) == 128)) {
                                function1.invoke(65533);
                                Unit unit8 = Unit.INSTANCE;
                            } else {
                                byte b9 = bArr[i4 + 2];
                                if (!((b9 & 192) == 128)) {
                                    function1.invoke(65533);
                                    Unit unit9 = Unit.INSTANCE;
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    byte b10 = bArr[i10];
                                    if ((b10 & 192) == 128) {
                                        z = true;
                                    }
                                    if (!z) {
                                        function1.invoke(65533);
                                        Unit unit10 = Unit.INSTANCE;
                                    } else {
                                        int i13 = (((b10 ^ 3678080) ^ (b9 << 6)) ^ (b8 << 12)) ^ (b7 << 18);
                                        function1.invoke((i13 <= 1114111 && (55296 > i13 || 57343 < i13) && i13 >= 65536) ? Integer.valueOf(i13) : 65533);
                                        Unit unit11 = Unit.INSTANCE;
                                        i3 = 4;
                                        i4 += i3;
                                    }
                                }
                            }
                        }
                    } else {
                        function1.invoke(65533);
                        i4++;
                    }
                    i3 = 3;
                    i4 += i3;
                }
                i3 = 1;
                i4 += i3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0099, code lost:
        if (r8 == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011a, code lost:
        if (r8 == false) goto L_0x0072;
     */
    public static final void processUtf16Chars(byte[] bArr, int i, int i2, Function1<? super Character, Unit> function1) {
        int i3;
        Intrinsics.checkNotNullParameter(bArr, "$this$processUtf16Chars");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i4 = i;
        while (i4 < i2) {
            byte b = bArr[i4];
            if (b >= 0) {
                function1.invoke(Character.valueOf((char) b));
                i4++;
                while (i4 < i2 && bArr[i4] >= 0) {
                    function1.invoke(Character.valueOf((char) bArr[i4]));
                    i4++;
                }
            } else {
                boolean z = false;
                if ((b >> 5) == -2) {
                    int i5 = i4 + 1;
                    if (i2 > i5) {
                        byte b2 = bArr[i4];
                        byte b3 = bArr[i5];
                        if ((b3 & 192) == 128) {
                            z = true;
                        }
                        if (z) {
                            int i6 = (b3 ^ 3968) ^ (b2 << 6);
                            function1.invoke(Character.valueOf(i6 < 128 ? (char) 65533 : (char) i6));
                            Unit unit = Unit.INSTANCE;
                            i3 = 2;
                            i4 += i3;
                        }
                    }
                    function1.invoke(Character.valueOf((char) 65533));
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    if ((b >> 4) == -2) {
                        int i7 = i4 + 2;
                        if (i2 <= i7) {
                            function1.invoke(Character.valueOf((char) 65533));
                            Unit unit3 = Unit.INSTANCE;
                            int i8 = i4 + 1;
                            if (i2 > i8) {
                                if ((bArr[i8] & 192) == 128) {
                                    z = true;
                                }
                            }
                        } else {
                            byte b4 = bArr[i4];
                            byte b5 = bArr[i4 + 1];
                            if (!((b5 & 192) == 128)) {
                                function1.invoke(Character.valueOf((char) 65533));
                                Unit unit4 = Unit.INSTANCE;
                            } else {
                                byte b6 = bArr[i7];
                                if ((b6 & 192) == 128) {
                                    z = true;
                                }
                                if (!z) {
                                    function1.invoke(Character.valueOf((char) 65533));
                                    Unit unit5 = Unit.INSTANCE;
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    int i9 = ((b6 ^ -123008) ^ (b5 << 6)) ^ (b4 << 12);
                                    function1.invoke(Character.valueOf((i9 >= 2048 && (55296 > i9 || 57343 < i9)) ? (char) i9 : (char) 65533));
                                    Unit unit6 = Unit.INSTANCE;
                                }
                            }
                        }
                    } else if ((b >> 3) == -2) {
                        int i10 = i4 + 3;
                        if (i2 <= i10) {
                            function1.invoke((char) 65533);
                            Unit unit7 = Unit.INSTANCE;
                            int i11 = i4 + 1;
                            if (i2 > i11) {
                                if ((bArr[i11] & 192) == 128) {
                                    int i12 = i4 + 2;
                                    if (i2 > i12) {
                                        if ((bArr[i12] & 192) == 128) {
                                            z = true;
                                        }
                                    }
                                    i3 = 2;
                                    i4 += i3;
                                }
                            }
                        } else {
                            byte b7 = bArr[i4];
                            byte b8 = bArr[i4 + 1];
                            if (!((b8 & 192) == 128)) {
                                function1.invoke((char) 65533);
                                Unit unit8 = Unit.INSTANCE;
                            } else {
                                byte b9 = bArr[i4 + 2];
                                if (!((b9 & 192) == 128)) {
                                    function1.invoke((char) 65533);
                                    Unit unit9 = Unit.INSTANCE;
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    byte b10 = bArr[i10];
                                    if ((b10 & 192) == 128) {
                                        z = true;
                                    }
                                    if (!z) {
                                        function1.invoke((char) 65533);
                                        Unit unit10 = Unit.INSTANCE;
                                    } else {
                                        int i13 = (((b10 ^ 3678080) ^ (b9 << 6)) ^ (b8 << 12)) ^ (b7 << 18);
                                        if (i13 <= 1114111 && ((55296 > i13 || 57343 < i13) && i13 >= 65536 && i13 != 65533)) {
                                            function1.invoke(Character.valueOf((char) ((i13 >>> 10) + 55232)));
                                            function1.invoke(Character.valueOf((char) ((i13 & 1023) + 56320)));
                                        } else {
                                            function1.invoke((char) 65533);
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                        i3 = 4;
                                        i4 += i3;
                                    }
                                }
                            }
                        }
                    } else {
                        function1.invoke((char) 65533);
                        i4++;
                    }
                    i3 = 3;
                    i4 += i3;
                }
                i3 = 1;
                i4 += i3;
            }
        }
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$process2Utf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 1;
        if (i2 <= i3) {
            function1.invoke(65533);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if (!((b2 & 192) == 128)) {
            function1.invoke(65533);
            return 1;
        }
        int i4 = (b2 ^ 3968) ^ (b << 6);
        if (i4 < 128) {
            function1.invoke(65533);
            return 2;
        }
        function1.invoke(Integer.valueOf(i4));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$process3Utf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 2;
        boolean z = false;
        if (i2 <= i3) {
            function1.invoke(65533);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    z = true;
                }
                if (z) {
                    return 2;
                }
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(65533);
            return 1;
        }
        byte b3 = bArr[i3];
        if ((b3 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(65533);
            return 2;
        }
        int i5 = ((b3 ^ -123008) ^ (b2 << 6)) ^ (b << 12);
        if (i5 < 2048) {
            function1.invoke(65533);
            return 3;
        } else if (55296 <= i5 && 57343 >= i5) {
            function1.invoke(65533);
            return 3;
        } else {
            function1.invoke(Integer.valueOf(i5));
            return 3;
        }
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$process4Utf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 3;
        boolean z = false;
        if (i2 <= i3) {
            function1.invoke(65533);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        if ((bArr[i5] & 192) == 128) {
                            z = true;
                        }
                        if (z) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(65533);
            return 1;
        }
        byte b3 = bArr[i + 2];
        if (!((b3 & 192) == 128)) {
            function1.invoke(65533);
            return 2;
        }
        byte b4 = bArr[i3];
        if ((b4 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(65533);
            return 3;
        }
        int i6 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << 12)) ^ (b << 18);
        if (i6 > 1114111) {
            function1.invoke(65533);
            return 4;
        } else if (55296 <= i6 && 57343 >= i6) {
            function1.invoke(65533);
            return 4;
        } else if (i6 < 65536) {
            function1.invoke(65533);
            return 4;
        } else {
            function1.invoke(Integer.valueOf(i6));
            return 4;
        }
    }
}
