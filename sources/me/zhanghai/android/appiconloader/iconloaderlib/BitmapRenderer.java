package me.zhanghai.android.appiconloader.iconloaderlib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Build;

public interface BitmapRenderer {
    public static final boolean USE_HARDWARE_BITMAP = (Build.VERSION.SDK_INT >= 28);

    void draw(Canvas canvas);

    /* renamed from: me.zhanghai.android.appiconloader.iconloaderlib.BitmapRenderer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Bitmap createSoftwareBitmap(int i, int i2, BitmapRenderer bitmapRenderer) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            bitmapRenderer.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        public static Bitmap createHardwareBitmap(int i, int i2, BitmapRenderer bitmapRenderer) {
            if (!BitmapRenderer.USE_HARDWARE_BITMAP) {
                return createSoftwareBitmap(i, i2, bitmapRenderer);
            }
            Picture picture = new Picture();
            bitmapRenderer.draw(picture.beginRecording(i, i2));
            picture.endRecording();
            return Bitmap.createBitmap(picture);
        }
    }
}
