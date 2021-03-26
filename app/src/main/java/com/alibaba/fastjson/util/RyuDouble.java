package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.math.BigInteger;

public final class RyuDouble {
    private static final int[][] POW5_INV_SPLIT = ((int[][]) Array.newInstance(int.class, 291, 4));
    private static final int[][] POW5_SPLIT = ((int[][]) Array.newInstance(int.class, 326, 4));

    static {
        int i;
        BigInteger subtract = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        BigInteger subtract2 = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        for (int i2 = 0; i2 < 326; i2++) {
            BigInteger pow = BigInteger.valueOf(5).pow(i2);
            int bitLength = pow.bitLength();
            if (i2 == 0) {
                i = 1;
            } else {
                i = (int) ((((((long) i2) * 23219280) + 10000000) - 1) / 10000000);
            }
            if (i == bitLength) {
                if (i2 < POW5_SPLIT.length) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        POW5_SPLIT[i2][i3] = pow.shiftRight((bitLength - 121) + ((3 - i3) * 31)).and(subtract).intValue();
                    }
                }
                if (i2 < POW5_INV_SPLIT.length) {
                    BigInteger add = BigInteger.ONE.shiftLeft(bitLength + 121).divide(pow).add(BigInteger.ONE);
                    for (int i4 = 0; i4 < 4; i4++) {
                        if (i4 == 0) {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).intValue();
                        } else {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).and(subtract2).intValue();
                        }
                    }
                }
            } else {
                throw new IllegalStateException(bitLength + " != " + i);
            }
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    public static int toString(double d, char[] cArr, int i) {
        int i2;
        long j;
        boolean z;
        long j2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        long j3;
        long j4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z5;
        int i11;
        int i12;
        int i13;
        int i14;
        if (Double.isNaN(d)) {
            int i15 = i + 1;
            cArr[i] = 'N';
            int i16 = i15 + 1;
            cArr[i15] = 'a';
            i14 = i16 + 1;
            cArr[i16] = 'N';
        } else {
            if (d == Double.POSITIVE_INFINITY) {
                int i17 = i + 1;
                cArr[i] = 'I';
                int i18 = i17 + 1;
                cArr[i17] = 'n';
                int i19 = i18 + 1;
                cArr[i18] = 'f';
                int i20 = i19 + 1;
                cArr[i19] = 'i';
                int i21 = i20 + 1;
                cArr[i20] = 'n';
                int i22 = i21 + 1;
                cArr[i21] = 'i';
                int i23 = i22 + 1;
                cArr[i22] = 't';
                i8 = i23 + 1;
                cArr[i23] = 'y';
            } else if (d == Double.NEGATIVE_INFINITY) {
                int i24 = i + 1;
                cArr[i] = '-';
                int i25 = i24 + 1;
                cArr[i24] = 'I';
                int i26 = i25 + 1;
                cArr[i25] = 'n';
                int i27 = i26 + 1;
                cArr[i26] = 'f';
                int i28 = i27 + 1;
                cArr[i27] = 'i';
                int i29 = i28 + 1;
                cArr[i28] = 'n';
                int i30 = i29 + 1;
                cArr[i29] = 'i';
                int i31 = i30 + 1;
                cArr[i30] = 't';
                i14 = i31 + 1;
                cArr[i31] = 'y';
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d);
                int i32 = (doubleToLongBits > 0 ? 1 : (doubleToLongBits == 0 ? 0 : -1));
                if (i32 == 0) {
                    int i33 = i + 1;
                    cArr[i] = '0';
                    int i34 = i33 + 1;
                    cArr[i33] = '.';
                    i14 = i34 + 1;
                    cArr[i34] = '0';
                } else if (doubleToLongBits == Long.MIN_VALUE) {
                    int i35 = i + 1;
                    cArr[i] = '-';
                    int i36 = i35 + 1;
                    cArr[i35] = '0';
                    int i37 = i36 + 1;
                    cArr[i36] = '.';
                    i8 = i37 + 1;
                    cArr[i37] = '0';
                } else {
                    int i38 = (int) ((doubleToLongBits >>> 52) & 2047);
                    long j5 = doubleToLongBits & 4503599627370495L;
                    if (i38 == 0) {
                        i2 = -1074;
                    } else {
                        i2 = (i38 - 1023) - 52;
                        j5 |= 4503599627370496L;
                    }
                    boolean z6 = i32 < 0;
                    boolean z7 = (j5 & 1) == 0;
                    long j6 = 4 * j5;
                    long j7 = j6 + 2;
                    int i39 = (j5 != 4503599627370496L || i38 <= 1) ? 1 : 0;
                    long j8 = (j6 - 1) - ((long) i39);
                    int i40 = i2 - 2;
                    int i41 = 3;
                    if (i40 >= 0) {
                        int max = Math.max(0, ((int) ((((long) i40) * 3010299) / 10000000)) - 1);
                        if (max == 0) {
                            i10 = 1;
                        } else {
                            i10 = (int) ((((((long) max) * 23219280) + 10000000) - 1) / 10000000);
                        }
                        int i42 = ((((-i40) + max) + ((i10 + 122) - 1)) - 93) - 21;
                        if (i42 >= 0) {
                            int[] iArr = POW5_INV_SPLIT[max];
                            long j9 = j6 >>> 31;
                            long j10 = j6 & 2147483647L;
                            z = z6;
                            long j11 = ((((((((((((j10 * ((long) iArr[3])) >>> 31) + (((long) iArr[2]) * j10)) + (j9 * ((long) iArr[3]))) >>> 31) + (((long) iArr[1]) * j10)) + (((long) iArr[2]) * j9)) >>> 31) + (((long) iArr[0]) * j10)) + (((long) iArr[1]) * j9)) >>> 21) + ((((long) iArr[0]) * j9) << 10)) >>> i42;
                            long j12 = j7 >>> 31;
                            long j13 = j7 & 2147483647L;
                            z2 = z7;
                            long j14 = ((((((((((((j13 * ((long) iArr[3])) >>> 31) + (((long) iArr[2]) * j13)) + (j12 * ((long) iArr[3]))) >>> 31) + (((long) iArr[1]) * j13)) + (((long) iArr[2]) * j12)) >>> 31) + (((long) iArr[0]) * j13)) + (((long) iArr[1]) * j12)) >>> 21) + ((((long) iArr[0]) * j12) << 10)) >>> i42;
                            long j15 = j8 >>> 31;
                            long j16 = j8 & 2147483647L;
                            j = j14;
                            j3 = ((((((((((((j16 * ((long) iArr[3])) >>> 31) + (((long) iArr[2]) * j16)) + (j15 * ((long) iArr[3]))) >>> 31) + (((long) iArr[1]) * j16)) + (((long) iArr[2]) * j15)) >>> 31) + (((long) iArr[0]) * j16)) + (((long) iArr[1]) * j15)) >>> 21) + ((((long) iArr[0]) * j15) << 10)) >>> i42;
                            if (max <= 21) {
                                long j17 = 0;
                                int i43 = ((j6 % 5) > 0 ? 1 : ((j6 % 5) == 0 ? 0 : -1));
                                if (i43 == 0) {
                                    if (i43 != 0) {
                                        i13 = 0;
                                    } else if (j6 % 25 != 0) {
                                        i13 = 1;
                                    } else if (j6 % 125 != 0) {
                                        i13 = 2;
                                    } else if (j6 % 625 != 0) {
                                        i13 = 3;
                                    } else {
                                        long j18 = j6 / 625;
                                        i13 = 4;
                                        while (j18 > j17 && j18 % 5 == j17) {
                                            j18 /= 5;
                                            i13++;
                                            j17 = 0;
                                        }
                                    }
                                    z3 = i13 >= max;
                                    z5 = false;
                                    j2 = j11;
                                    z4 = z5;
                                    i3 = max;
                                } else if (z2) {
                                    long j19 = 0;
                                    if (j8 % 5 != 0) {
                                        i12 = 0;
                                    } else if (j8 % 25 != 0) {
                                        i12 = 1;
                                    } else if (j8 % 125 != 0) {
                                        i12 = 2;
                                    } else if (j8 % 625 != 0) {
                                        i12 = 3;
                                    } else {
                                        long j20 = j8 / 625;
                                        i12 = 4;
                                        while (j20 > j19 && j20 % 5 == j19) {
                                            j20 /= 5;
                                            i12++;
                                            j19 = 0;
                                        }
                                    }
                                    if (i12 >= max) {
                                        z5 = true;
                                        z3 = false;
                                        j2 = j11;
                                        z4 = z5;
                                        i3 = max;
                                    }
                                } else {
                                    long j21 = 0;
                                    if (j7 % 5 != 0) {
                                        i11 = 0;
                                    } else if (j7 % 25 != 0) {
                                        i11 = 1;
                                    } else if (j7 % 125 != 0) {
                                        i11 = 2;
                                    } else if (j7 % 625 != 0) {
                                        i11 = 3;
                                    } else {
                                        long j22 = j7 / 625;
                                        i11 = 4;
                                        while (j22 > j21 && j22 % 5 == j21) {
                                            j22 /= 5;
                                            i11++;
                                            j21 = 0;
                                        }
                                    }
                                    if (i11 >= max) {
                                        j--;
                                    }
                                }
                            }
                            z5 = false;
                            z3 = false;
                            j2 = j11;
                            z4 = z5;
                            i3 = max;
                        } else {
                            throw new IllegalArgumentException("" + i42);
                        }
                    } else {
                        z = z6;
                        z2 = z7;
                        int i44 = -i40;
                        int max2 = Math.max(0, ((int) ((((long) i44) * 6989700) / 10000000)) - 1);
                        int i45 = i44 - max2;
                        if (i45 == 0) {
                            i9 = 1;
                        } else {
                            i9 = (int) ((((((long) i45) * 23219280) + 10000000) - 1) / 10000000);
                        }
                        int i46 = ((max2 - (i9 - 121)) - 93) - 21;
                        if (i46 >= 0) {
                            int[] iArr2 = POW5_SPLIT[i45];
                            long j23 = j6 >>> 31;
                            long j24 = j6 & 2147483647L;
                            long j25 = ((long) iArr2[0]) * j23;
                            long j26 = ((long) iArr2[0]) * j24;
                            long j27 = ((long) iArr2[1]) * j23;
                            long j28 = ((long) iArr2[1]) * j24;
                            long j29 = ((long) iArr2[2]) * j23;
                            long j30 = ((long) iArr2[2]) * j24;
                            long j31 = j23 * ((long) iArr2[3]);
                            long j32 = j7 >>> 31;
                            long j33 = j7 & 2147483647L;
                            long j34 = ((long) iArr2[0]) * j32;
                            long j35 = ((long) iArr2[0]) * j33;
                            long j36 = ((long) iArr2[1]) * j32;
                            j2 = ((((((((((((j24 * ((long) iArr2[3])) >>> 31) + j30) + j31) >>> 31) + j28) + j29) >>> 31) + j26) + j27) >>> 21) + (j25 << 10)) >>> i46;
                            long j37 = ((((((((((((j33 * ((long) iArr2[3])) >>> 31) + (((long) iArr2[2]) * j33)) + (j32 * ((long) iArr2[3]))) >>> 31) + (((long) iArr2[1]) * j33)) + (((long) iArr2[2]) * j32)) >>> 31) + j35) + j36) >>> 21) + (j34 << 10)) >>> i46;
                            long j38 = j8 >>> 31;
                            long j39 = j8 & 2147483647L;
                            j3 = ((((((((((((j39 * ((long) iArr2[3])) >>> 31) + (((long) iArr2[2]) * j39)) + (j38 * ((long) iArr2[3]))) >>> 31) + (((long) iArr2[1]) * j39)) + (((long) iArr2[2]) * j38)) >>> 31) + (((long) iArr2[0]) * j39)) + (((long) iArr2[1]) * j38)) >>> 21) + ((((long) iArr2[0]) * j38) << 10)) >>> i46;
                            i3 = max2 + i40;
                            if (max2 <= 1) {
                                if (z2) {
                                    j = j37;
                                    z4 = i39 == 1;
                                } else {
                                    j = j37 - 1;
                                    z4 = false;
                                }
                                z3 = true;
                            } else if (max2 < 63) {
                                z3 = (j6 & ((1 << (max2 - 1)) - 1)) == 0;
                                j = j37;
                                z4 = false;
                            } else {
                                j = j37;
                                z4 = false;
                                z3 = false;
                            }
                        } else {
                            throw new IllegalArgumentException("" + i46);
                        }
                    }
                    if (j >= 1000000000000000000L) {
                        i41 = 19;
                    } else if (j >= 100000000000000000L) {
                        i41 = 18;
                    } else if (j >= 10000000000000000L) {
                        i41 = 17;
                    } else if (j >= 1000000000000000L) {
                        i41 = 16;
                    } else if (j >= 100000000000000L) {
                        i41 = 15;
                    } else if (j >= 10000000000000L) {
                        i41 = 14;
                    } else if (j >= 1000000000000L) {
                        i41 = 13;
                    } else if (j >= 100000000000L) {
                        i41 = 12;
                    } else if (j >= 10000000000L) {
                        i41 = 11;
                    } else if (j >= 1000000000) {
                        i41 = 10;
                    } else if (j >= 100000000) {
                        i41 = 9;
                    } else if (j >= 10000000) {
                        i41 = 8;
                    } else if (j >= 1000000) {
                        i41 = 7;
                    } else if (j >= 100000) {
                        i41 = 6;
                    } else if (j >= 10000) {
                        i41 = 5;
                    } else if (j >= 1000) {
                        i41 = 4;
                    } else if (j < 100) {
                        i41 = j >= 10 ? 2 : 1;
                    }
                    int i47 = (i3 + i41) - 1;
                    boolean z8 = i47 < -3 || i47 >= 7;
                    if (z4 || z3) {
                        boolean z9 = z3;
                        int i48 = 0;
                        int i49 = 0;
                        while (true) {
                            long j40 = j / 10;
                            long j41 = j3 / 10;
                            if (j40 <= j41 || (j < 100 && z8)) {
                                break;
                            }
                            z4 &= j3 % 10 == 0;
                            z9 &= i48 == 0;
                            i48 = (int) (j2 % 10);
                            j2 /= 10;
                            i49++;
                            j = j40;
                            j3 = j41;
                        }
                        if (z4 && z2) {
                            while (j3 % 10 == 0 && (j >= 100 || !z8)) {
                                z9 &= i48 == 0;
                                i48 = (int) (j2 % 10);
                                j /= 10;
                                j2 /= 10;
                                j3 /= 10;
                                i49++;
                            }
                        }
                        if (z9 && i48 == 5 && j2 % 2 == 0) {
                            i48 = 4;
                        }
                        j4 = j2 + ((long) (((j2 != j3 || (z4 && z2)) && i48 < 5) ? 0 : 1));
                        i4 = i49;
                    } else {
                        i4 = 0;
                        int i50 = 0;
                        while (true) {
                            long j42 = j / 10;
                            long j43 = j3 / 10;
                            if (j42 <= j43 || (j < 100 && z8)) {
                                break;
                            }
                            i50 = (int) (j2 % 10);
                            j2 /= 10;
                            i4++;
                            j = j42;
                            j3 = j43;
                        }
                        j4 = j2 + ((long) ((j2 == j3 || i50 >= 5) ? 1 : 0));
                    }
                    int i51 = i41 - i4;
                    if (z) {
                        i5 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i5 = i;
                    }
                    if (z8) {
                        for (int i52 = 0; i52 < i51 - 1; i52++) {
                            int i53 = (int) (j4 % 10);
                            j4 /= 10;
                            cArr[(i5 + i51) - i52] = (char) (i53 + 48);
                        }
                        cArr[i5] = (char) ((int) ((j4 % 10) + 48));
                        cArr[i5 + 1] = '.';
                        int i54 = i5 + i51 + 1;
                        if (i51 == 1) {
                            cArr[i54] = '0';
                            i54++;
                        }
                        int i55 = i54 + 1;
                        cArr[i54] = 'E';
                        if (i47 < 0) {
                            cArr[i55] = '-';
                            i47 = -i47;
                            i55++;
                        }
                        if (i47 >= 100) {
                            int i56 = i55 + 1;
                            i7 = 48;
                            cArr[i55] = (char) ((i47 / 100) + 48);
                            i47 %= 100;
                            i55 = i56 + 1;
                            cArr[i56] = (char) ((i47 / 10) + 48);
                        } else {
                            i7 = 48;
                            if (i47 >= 10) {
                                cArr[i55] = (char) ((i47 / 10) + 48);
                                i55++;
                            }
                        }
                        i8 = i55 + 1;
                        cArr[i55] = (char) ((i47 % 10) + i7);
                    } else {
                        char c = '0';
                        if (i47 < 0) {
                            int i57 = i5 + 1;
                            cArr[i5] = '0';
                            int i58 = i57 + 1;
                            cArr[i57] = '.';
                            int i59 = -1;
                            while (i59 > i47) {
                                cArr[i58] = c;
                                i59--;
                                i58++;
                                c = '0';
                            }
                            i6 = i58;
                            for (int i60 = 0; i60 < i51; i60++) {
                                cArr[((i58 + i51) - i60) - 1] = (char) ((int) ((j4 % 10) + 48));
                                j4 /= 10;
                                i6++;
                            }
                        } else {
                            int i61 = i47 + 1;
                            if (i61 >= i51) {
                                for (int i62 = 0; i62 < i51; i62++) {
                                    cArr[((i5 + i51) - i62) - 1] = (char) ((int) ((j4 % 10) + 48));
                                    j4 /= 10;
                                }
                                int i63 = i5 + i51;
                                while (i51 < i61) {
                                    cArr[i63] = '0';
                                    i51++;
                                    i63++;
                                }
                                int i64 = i63 + 1;
                                cArr[i63] = '.';
                                i6 = i64 + 1;
                                cArr[i64] = '0';
                            } else {
                                int i65 = i5 + 1;
                                for (int i66 = 0; i66 < i51; i66++) {
                                    if ((i51 - i66) - 1 == i47) {
                                        cArr[((i65 + i51) - i66) - 1] = '.';
                                        i65--;
                                    }
                                    cArr[((i65 + i51) - i66) - 1] = (char) ((int) ((j4 % 10) + 48));
                                    j4 /= 10;
                                }
                                i6 = i5 + i51 + 1;
                            }
                        }
                        return i6 - i;
                    }
                }
            }
            return i8 - i;
        }
        return i14 - i;
    }
}
