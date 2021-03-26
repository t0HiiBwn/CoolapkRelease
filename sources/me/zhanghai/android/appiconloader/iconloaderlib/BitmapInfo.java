package me.zhanghai.android.appiconloader.iconloaderlib;

import android.graphics.Bitmap;

public class BitmapInfo {
    public static final Bitmap LOW_RES_ICON;
    public static final BitmapInfo LOW_RES_INFO;
    public final int color;
    public final Bitmap icon;

    static {
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        LOW_RES_ICON = createBitmap;
        LOW_RES_INFO = fromBitmap(createBitmap);
    }

    public BitmapInfo(Bitmap bitmap, int i) {
        this.icon = bitmap;
        this.color = i;
    }

    public final boolean isNullOrLowRes() {
        Bitmap bitmap = this.icon;
        return bitmap == null || bitmap == LOW_RES_ICON;
    }

    public final boolean isLowRes() {
        return LOW_RES_ICON == this.icon;
    }

    public static BitmapInfo fromBitmap(Bitmap bitmap) {
        return of(bitmap, 0);
    }

    public static BitmapInfo of(Bitmap bitmap, int i) {
        return new BitmapInfo(bitmap, i);
    }

    public interface Extender {
        BitmapInfo getExtendedInfo(Bitmap bitmap, int i, BaseIconFactory baseIconFactory);

        void prepareToDrawOnUi();

        /* renamed from: me.zhanghai.android.appiconloader.iconloaderlib.BitmapInfo$Extender$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$prepareToDrawOnUi(Extender extender) {
            }

            public static BitmapInfo $default$getExtendedInfo(Extender _this, Bitmap bitmap, int i, BaseIconFactory baseIconFactory) {
                return BitmapInfo.of(bitmap, i);
            }
        }
    }
}
