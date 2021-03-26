package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class FastBlur {
    public static Bitmap blur(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        int i2 = i;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i6;
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, iArr8);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = -i2;
            int i24 = 0;
            while (i23 <= i2) {
                int i25 = iArr2[i13 + Math.min(i4, Math.max(i23, 0))];
                int[] iArr10 = iArr9[i23 + i2];
                iArr10[0] = (i25 & 16711680) >> 16;
                iArr10[1] = (i25 & 65280) >> 8;
                iArr10[2] = i25 & 255;
                int abs = i11 - Math.abs(i23);
                i24 += iArr10[0] * abs;
                i15 += iArr10[1] * abs;
                i16 += iArr10[2] * abs;
                if (i23 > 0) {
                    i20 += iArr10[0];
                    i21 += iArr10[1];
                    i22 += iArr10[2];
                } else {
                    i17 += iArr10[0];
                    i18 += iArr10[1];
                    i19 += iArr10[2];
                }
                i23++;
                i5 = i5;
                iArr6 = iArr6;
            }
            int i26 = i2;
            int i27 = i24;
            int i28 = 0;
            while (i28 < width) {
                iArr3[i13] = iArr7[i27];
                iArr4[i13] = iArr7[i15];
                iArr5[i13] = iArr7[i16];
                int i29 = i27 - i17;
                int i30 = i15 - i18;
                int i31 = i16 - i19;
                int[] iArr11 = iArr9[((i26 - i2) + i6) % i6];
                int i32 = i17 - iArr11[0];
                int i33 = i18 - iArr11[1];
                int i34 = i19 - iArr11[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr6[i28] = Math.min(i28 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i35 = iArr2[i14 + iArr6[i28]];
                iArr11[0] = (i35 & 16711680) >> 16;
                iArr11[1] = (i35 & 65280) >> 8;
                iArr11[2] = i35 & 255;
                int i36 = i20 + iArr11[0];
                int i37 = i21 + iArr11[1];
                int i38 = i22 + iArr11[2];
                i27 = i29 + i36;
                i15 = i30 + i37;
                i16 = i31 + i38;
                i26 = (i26 + 1) % i6;
                int[] iArr12 = iArr9[i26 % i6];
                i17 = i32 + iArr12[0];
                i18 = i33 + iArr12[1];
                i19 = i34 + iArr12[2];
                i20 = i36 - iArr12[0];
                i21 = i37 - iArr12[1];
                i22 = i38 - iArr12[2];
                i13++;
                i28++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            copy = copy;
            height = height;
            i5 = i5;
            iArr6 = iArr6;
        }
        int i39 = i5;
        int i40 = height;
        int i41 = 0;
        while (i41 < width) {
            int i42 = -i2;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = i42;
            int i51 = i42 * width;
            int i52 = 0;
            int i53 = 0;
            while (i50 <= i2) {
                int max = Math.max(0, i51) + i41;
                int[] iArr13 = iArr9[i50 + i2];
                iArr13[0] = iArr3[max];
                iArr13[1] = iArr4[max];
                iArr13[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i50);
                i52 += iArr3[max] * abs2;
                i53 += iArr4[max] * abs2;
                i43 += iArr5[max] * abs2;
                if (i50 > 0) {
                    i47 += iArr13[0];
                    i48 += iArr13[1];
                    i49 += iArr13[2];
                } else {
                    i44 += iArr13[0];
                    i45 += iArr13[1];
                    i46 += iArr13[2];
                }
                if (i50 < i39) {
                    i51 += width;
                }
                i50++;
                i39 = i39;
                width = width;
            }
            int i54 = i2;
            int i55 = i41;
            int i56 = i53;
            int i57 = i52;
            int i58 = 0;
            while (i58 < i40) {
                iArr2[i55] = (iArr2[i55] & -16777216) | (iArr7[i57] << 16) | (iArr7[i56] << 8) | iArr7[i43];
                int i59 = i57 - i44;
                int i60 = i56 - i45;
                int i61 = i43 - i46;
                int[] iArr14 = iArr9[((i54 - i2) + i6) % i6];
                int i62 = i44 - iArr14[0];
                int i63 = i45 - iArr14[1];
                int i64 = i46 - iArr14[2];
                if (i41 == 0) {
                    iArr6[i58] = Math.min(i58 + i11, i39) * width;
                }
                int i65 = iArr6[i58] + i41;
                iArr14[0] = iArr3[i65];
                iArr14[1] = iArr4[i65];
                iArr14[2] = iArr5[i65];
                int i66 = i47 + iArr14[0];
                int i67 = i48 + iArr14[1];
                int i68 = i49 + iArr14[2];
                i57 = i59 + i66;
                i56 = i60 + i67;
                i43 = i61 + i68;
                i54 = (i54 + 1) % i6;
                int[] iArr15 = iArr9[i54];
                i44 = i62 + iArr15[0];
                i45 = i63 + iArr15[1];
                i46 = i64 + iArr15[2];
                i47 = i66 - iArr15[0];
                i48 = i67 - iArr15[1];
                i49 = i68 - iArr15[2];
                i55 += width;
                i58++;
                i2 = i;
            }
            i41++;
            i2 = i;
            i39 = i39;
            i40 = i40;
            i6 = i6;
            iArr2 = iArr2;
            width = width;
        }
        copy.setPixels(iArr2, 0, width, 0, 0, width, i40);
        return copy;
    }
}
