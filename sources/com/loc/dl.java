package com.loc;

/* compiled from: Base64 */
public class dl {
    static final /* synthetic */ boolean a = true;

    /* compiled from: Base64 */
    static abstract class a {
        public byte[] a;
        public int b;

        a() {
        }
    }

    /* compiled from: Base64 */
    static class b extends a {
        private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int e = 0;
        private int f = 0;
        private final int[] g = c;

        public b(byte[] bArr) {
            this.a = bArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b8, code lost:
            r17.e = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ed, code lost:
            if (r1 == 1) goto L_0x00b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ef, code lost:
            if (r1 == 2) goto L_0x0105;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f1, code lost:
            if (r1 == 3) goto L_0x00f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f3, code lost:
            if (r1 == 4) goto L_0x00b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f6, code lost:
            r2 = r11 + 1;
            r6[r11] = (byte) (r5 >> 10);
            r11 = r2 + 1;
            r6[r2] = (byte) (r5 >> 2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0105, code lost:
            r6[r11] = (byte) (r5 >> 4);
            r11 = r11 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x010d, code lost:
            r17.e = r1;
            r17.b = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0111, code lost:
            return true;
         */
        public final boolean a(byte[] bArr, int i) {
            int i2 = this.e;
            if (i2 == 6) {
                return false;
            }
            int i3 = i + 0;
            int i4 = this.f;
            byte[] bArr2 = this.a;
            int[] iArr = this.g;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= i3) {
                    break;
                }
                if (i2 == 0) {
                    while (true) {
                        int i7 = i5 + 4;
                        if (i7 > i3) {
                            break;
                        }
                        i4 = iArr[bArr[i5 + 3] & 255] | (iArr[bArr[i5 + 1] & 255] << 12) | (iArr[bArr[i5] & 255] << 18) | (iArr[bArr[i5 + 2] & 255] << 6);
                        if (i4 < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i4;
                        bArr2[i6 + 1] = (byte) (i4 >> 8);
                        bArr2[i6] = (byte) (i4 >> 16);
                        i6 += 3;
                        i5 = i7;
                    }
                    if (i5 >= i3) {
                        break;
                    }
                }
                int i8 = i5 + 1;
                int i9 = iArr[bArr[i5] & 255];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (i9 < 0) {
                                if (i9 != -2) {
                                    if (i9 != -1) {
                                        break;
                                    }
                                } else {
                                    bArr2[i6] = (byte) (i4 >> 4);
                                    i6++;
                                    i5 = i8;
                                    i2 = 4;
                                }
                            }
                        } else if (i2 == 3) {
                            if (i9 < 0) {
                                if (i9 != -2) {
                                    if (i9 != -1) {
                                        break;
                                    }
                                } else {
                                    bArr2[i6 + 1] = (byte) (i4 >> 2);
                                    bArr2[i6] = (byte) (i4 >> 10);
                                    i6 += 2;
                                    i5 = i8;
                                    i2 = 5;
                                }
                            } else {
                                i4 = (i4 << 6) | i9;
                                bArr2[i6 + 2] = (byte) i4;
                                bArr2[i6 + 1] = (byte) (i4 >> 8);
                                bArr2[i6] = (byte) (i4 >> 16);
                                i6 += 3;
                                i5 = i8;
                                i2 = 0;
                            }
                        } else if (i2 != 4) {
                            if (i2 == 5 && i9 != -1) {
                                break;
                            }
                        } else {
                            if (i9 != -2) {
                                if (i9 != -1) {
                                    this.e = 6;
                                    return false;
                                }
                            }
                            i2++;
                        }
                    } else if (i9 < 0) {
                        if (i9 != -1) {
                            this.e = 6;
                            return false;
                        }
                    }
                    i4 = (i4 << 6) | i9;
                    i2++;
                } else if (i9 >= 0) {
                    i2++;
                    i4 = i9;
                } else if (i9 != -1) {
                    this.e = 6;
                    return false;
                }
                i5 = i8;
            }
            this.e = 6;
            return false;
        }
    }

    private dl() {
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length;
        b bVar = new b(new byte[((length * 3) / 4)]);
        if (!bVar.a(bArr, length)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.b == bVar.a.length) {
            return bVar.a;
        } else {
            byte[] bArr2 = new byte[bVar.b];
            System.arraycopy(bVar.a, 0, bArr2, 0, bVar.b);
            return bArr2;
        }
    }
}
