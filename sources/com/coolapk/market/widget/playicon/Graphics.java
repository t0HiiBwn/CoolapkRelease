package com.coolapk.market.widget.playicon;

import android.graphics.Path;

final class Graphics {
    static float animateValue(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    private Graphics() {
    }

    static void inRect(Path path, float[] fArr) {
        if (!path.isEmpty()) {
            path.rewind();
        }
        path.moveTo(fArr[0], fArr[1]);
        path.lineTo(fArr[2], fArr[3]);
        path.lineTo(fArr[4], fArr[5]);
        path.lineTo(fArr[6], fArr[7]);
    }

    static void animatePath(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        if (fArr2.length == fArr3.length && fArr.length == fArr2.length) {
            int length = fArr2.length;
            for (int i = 0; i < length; i++) {
                fArr[i] = animateValue(fArr2[i], fArr3[i], f);
            }
            return;
        }
        throw new IllegalStateException("Paths should be of the same size");
    }
}
