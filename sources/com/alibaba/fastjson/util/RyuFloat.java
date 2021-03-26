package com.alibaba.fastjson.util;

public final class RyuFloat {
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};

    public static String toString(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f, cArr, 0));
    }

    public static int toString(float f, char[] cArr, int i) {
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (Float.isNaN(f)) {
            int i16 = i + 1;
            cArr[i] = 'N';
            int i17 = i16 + 1;
            cArr[i16] = 'a';
            i15 = i17 + 1;
            cArr[i17] = 'N';
        } else if (f == Float.POSITIVE_INFINITY) {
            int i18 = i + 1;
            cArr[i] = 'I';
            int i19 = i18 + 1;
            cArr[i18] = 'n';
            int i20 = i19 + 1;
            cArr[i19] = 'f';
            int i21 = i20 + 1;
            cArr[i20] = 'i';
            int i22 = i21 + 1;
            cArr[i21] = 'n';
            int i23 = i22 + 1;
            cArr[i22] = 'i';
            int i24 = i23 + 1;
            cArr[i23] = 't';
            cArr[i24] = 'y';
            return (i24 + 1) - i;
        } else if (f == Float.NEGATIVE_INFINITY) {
            int i25 = i + 1;
            cArr[i] = '-';
            int i26 = i25 + 1;
            cArr[i25] = 'I';
            int i27 = i26 + 1;
            cArr[i26] = 'n';
            int i28 = i27 + 1;
            cArr[i27] = 'f';
            int i29 = i28 + 1;
            cArr[i28] = 'i';
            int i30 = i29 + 1;
            cArr[i29] = 'n';
            int i31 = i30 + 1;
            cArr[i30] = 'i';
            int i32 = i31 + 1;
            cArr[i31] = 't';
            i15 = i32 + 1;
            cArr[i32] = 'y';
        } else {
            int floatToIntBits = Float.floatToIntBits(f);
            if (floatToIntBits == 0) {
                int i33 = i + 1;
                cArr[i] = '0';
                int i34 = i33 + 1;
                cArr[i33] = '.';
                i15 = i34 + 1;
                cArr[i34] = '0';
            } else if (floatToIntBits == Integer.MIN_VALUE) {
                int i35 = i + 1;
                cArr[i] = '-';
                int i36 = i35 + 1;
                cArr[i35] = '0';
                int i37 = i36 + 1;
                cArr[i36] = '.';
                cArr[i37] = '0';
                return (i37 + 1) - i;
            } else {
                int i38 = (floatToIntBits >> 23) & 255;
                int i39 = 8388607 & floatToIntBits;
                if (i38 == 0) {
                    i2 = -149;
                } else {
                    i2 = (i38 - 127) - 23;
                    i39 |= 8388608;
                }
                boolean z5 = floatToIntBits < 0;
                boolean z6 = (i39 & 1) == 0;
                int i40 = i39 * 4;
                int i41 = i40 + 2;
                int i42 = i40 - ((((long) i39) != 8388608 || i38 <= 1) ? 2 : 1);
                int i43 = i2 - 2;
                if (i43 >= 0) {
                    i5 = (int) ((((long) i43) * 3010299) / 10000000);
                    if (i5 == 0) {
                        i13 = 1;
                    } else {
                        i13 = (int) ((((((long) i5) * 23219280) + 10000000) - 1) / 10000000);
                    }
                    int i44 = (-i43) + i5;
                    int[][] iArr = POW5_INV_SPLIT;
                    long j = (long) iArr[i5][0];
                    z = z6;
                    long j2 = (long) iArr[i5][1];
                    long j3 = (long) i40;
                    int i45 = (((i13 + 59) - 1) + i44) - 31;
                    i4 = (int) (((j3 * j) + ((j3 * j2) >> 31)) >> i45);
                    long j4 = (long) i41;
                    i3 = (int) (((j4 * j) + ((j4 * j2) >> 31)) >> i45);
                    long j5 = (long) i42;
                    i6 = (int) (((j * j5) + ((j5 * j2) >> 31)) >> i45);
                    if (i5 == 0 || (i3 - 1) / 10 > i6 / 10) {
                        i7 = 0;
                    } else {
                        int i46 = i5 - 1;
                        if (i46 == 0) {
                            i14 = 1;
                        } else {
                            i14 = (int) ((((((long) i46) * 23219280) + 10000000) - 1) / 10000000);
                        }
                        i7 = (int) ((((((long) iArr[i46][0]) * j3) + ((((long) iArr[i46][1]) * j3) >> 31)) >> (((i44 - 1) + ((i14 + 59) - 1)) - 31)) % 10);
                    }
                    int i47 = i41;
                    int i48 = 0;
                    while (i47 > 0 && i47 % 5 == 0) {
                        i47 /= 5;
                        i48++;
                    }
                    int i49 = 0;
                    while (i40 > 0 && i40 % 5 == 0) {
                        i40 /= 5;
                        i49++;
                    }
                    int i50 = 0;
                    while (i42 > 0 && i42 % 5 == 0) {
                        i42 /= 5;
                        i50++;
                    }
                    z4 = i48 >= i5;
                    z3 = i49 >= i5;
                    z2 = i50 >= i5;
                } else {
                    z = z6;
                    int i51 = -i43;
                    int i52 = (int) ((((long) i51) * 6989700) / 10000000);
                    int i53 = i51 - i52;
                    if (i53 == 0) {
                        i11 = 1;
                    } else {
                        i11 = (int) ((((((long) i53) * 23219280) + 10000000) - 1) / 10000000);
                    }
                    int i54 = i52 - (i11 - 61);
                    int[][] iArr2 = POW5_SPLIT;
                    long j6 = (long) iArr2[i53][0];
                    long j7 = (long) iArr2[i53][1];
                    int i55 = i54 - 31;
                    long j8 = (long) i40;
                    int i56 = (int) (((j8 * j6) + ((j8 * j7) >> 31)) >> i55);
                    long j9 = (long) i41;
                    i3 = (int) (((j9 * j6) + ((j9 * j7) >> 31)) >> i55);
                    long j10 = (long) i42;
                    int i57 = (int) (((j6 * j10) + ((j10 * j7) >> 31)) >> i55);
                    if (i52 == 0 || (i3 - 1) / 10 > i57 / 10) {
                        i7 = 0;
                    } else {
                        int i58 = i53 + 1;
                        int i59 = i52 - 1;
                        if (i58 == 0) {
                            i12 = 1;
                        } else {
                            i12 = (int) ((((((long) i58) * 23219280) + 10000000) - 1) / 10000000);
                        }
                        i7 = (int) ((((((long) iArr2[i58][0]) * j8) + ((((long) iArr2[i58][1]) * j8) >> 31)) >> ((i59 - (i12 - 61)) - 31)) % 10);
                    }
                    int i60 = i52 + i43;
                    boolean z7 = 1 >= i52;
                    boolean z8 = i52 < 23 && (((1 << (i52 + -1)) - 1) & i40) == 0;
                    boolean z9 = (i42 % 2 == 1 ? 0 : 1) >= i52;
                    z4 = z7;
                    i4 = i56;
                    z2 = z9;
                    i6 = i57;
                    i5 = i60;
                    z3 = z8;
                }
                int i61 = 1000000000;
                int i62 = 10;
                while (i62 > 0 && i3 < i61) {
                    i61 /= 10;
                    i62--;
                }
                int i63 = (i5 + i62) - 1;
                boolean z10 = i63 < -3 || i63 >= 7;
                if (z4 && !z) {
                    i3--;
                }
                int i64 = 0;
                while (true) {
                    int i65 = i3 / 10;
                    int i66 = i6 / 10;
                    if (i65 <= i66 || (i3 < 100 && z10)) {
                        break;
                    }
                    z2 &= i6 % 10 == 0;
                    i7 = i4 % 10;
                    i4 /= 10;
                    i64++;
                    i3 = i65;
                    i6 = i66;
                }
                if (z2 && z) {
                    while (i6 % 10 == 0 && (i3 >= 100 || !z10)) {
                        i3 /= 10;
                        i7 = i4 % 10;
                        i4 /= 10;
                        i6 /= 10;
                        i64++;
                    }
                }
                if (z3 && i7 == 5 && i4 % 2 == 0) {
                    i7 = 4;
                }
                int i67 = i4 + (((i4 != i6 || (z2 && z)) && i7 < 5) ? 0 : 1);
                int i68 = i62 - i64;
                if (z5) {
                    i8 = i + 1;
                    cArr[i] = '-';
                } else {
                    i8 = i;
                }
                if (z10) {
                    for (int i69 = 0; i69 < i68 - 1; i69++) {
                        int i70 = i67 % 10;
                        i67 /= 10;
                        cArr[(i8 + i68) - i69] = (char) (i70 + 48);
                    }
                    cArr[i8] = (char) ((i67 % 10) + 48);
                    cArr[i8 + 1] = '.';
                    int i71 = i8 + i68 + 1;
                    if (i68 == 1) {
                        cArr[i71] = '0';
                        i71++;
                    }
                    int i72 = i71 + 1;
                    cArr[i71] = 'E';
                    if (i63 < 0) {
                        cArr[i72] = '-';
                        i63 = -i63;
                        i72++;
                    }
                    if (i63 >= 10) {
                        i10 = 48;
                        cArr[i72] = (char) ((i63 / 10) + 48);
                        i72++;
                    } else {
                        i10 = 48;
                    }
                    i9 = i72 + 1;
                    cArr[i72] = (char) ((i63 % 10) + i10);
                } else {
                    int i73 = 48;
                    if (i63 < 0) {
                        int i74 = i8 + 1;
                        cArr[i8] = '0';
                        int i75 = i74 + 1;
                        cArr[i74] = '.';
                        int i76 = -1;
                        while (i76 > i63) {
                            cArr[i75] = '0';
                            i76--;
                            i75++;
                        }
                        int i77 = i75;
                        int i78 = 0;
                        while (i78 < i68) {
                            cArr[((i75 + i68) - i78) - 1] = (char) ((i67 % 10) + i73);
                            i67 /= 10;
                            i77++;
                            i78++;
                            i73 = 48;
                        }
                        i9 = i77;
                    } else {
                        int i79 = i63 + 1;
                        if (i79 >= i68) {
                            for (int i80 = 0; i80 < i68; i80++) {
                                cArr[((i8 + i68) - i80) - 1] = (char) ((i67 % 10) + 48);
                                i67 /= 10;
                            }
                            int i81 = i8 + i68;
                            while (i68 < i79) {
                                cArr[i81] = '0';
                                i68++;
                                i81++;
                            }
                            int i82 = i81 + 1;
                            cArr[i81] = '.';
                            i9 = i82 + 1;
                            cArr[i82] = '0';
                        } else {
                            int i83 = i8 + 1;
                            for (int i84 = 0; i84 < i68; i84++) {
                                if ((i68 - i84) - 1 == i63) {
                                    cArr[((i83 + i68) - i84) - 1] = '.';
                                    i83--;
                                }
                                cArr[((i83 + i68) - i84) - 1] = (char) ((i67 % 10) + 48);
                                i67 /= 10;
                            }
                            i9 = i8 + i68 + 1;
                        }
                    }
                }
                return i9 - i;
            }
        }
        return i15 - i;
    }
}
