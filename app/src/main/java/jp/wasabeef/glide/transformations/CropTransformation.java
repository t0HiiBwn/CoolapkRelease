package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CropTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropTransformation.1";
    private static final int VERSION = 1;
    private CropType cropType;
    private int height;
    private int width;

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(int i, int i2) {
        this(i, i2, CropType.CENTER);
    }

    public CropTransformation(int i, int i2, CropType cropType2) {
        this.cropType = CropType.CENTER;
        this.width = i;
        this.height = i2;
        this.cropType = cropType2;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int i3 = this.width;
        if (i3 == 0) {
            i3 = bitmap.getWidth();
        }
        this.width = i3;
        int i4 = this.height;
        if (i4 == 0) {
            i4 = bitmap.getHeight();
        }
        this.height = i4;
        Bitmap bitmap2 = bitmapPool.get(this.width, this.height, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        float max = Math.max(((float) this.width) / ((float) bitmap.getWidth()), ((float) this.height) / ((float) bitmap.getHeight()));
        float width2 = ((float) bitmap.getWidth()) * max;
        float height2 = max * ((float) bitmap.getHeight());
        float f = (((float) this.width) - width2) / 2.0f;
        float top = getTop(height2);
        RectF rectF = new RectF(f, top, width2 + f, height2 + top);
        setCanvasBitmapDensity(bitmap, bitmap2);
        new Canvas(bitmap2).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        return bitmap2;
    }

    /* renamed from: jp.wasabeef.glide.transformations.CropTransformation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType;

        static {
            int[] iArr = new int[CropType.values().length];
            $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType = iArr;
            try {
                iArr[CropType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[CropType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[CropType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private float getTop(float f) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[this.cropType.ordinal()];
        if (i == 2) {
            return (((float) this.height) - f) / 2.0f;
        }
        if (i != 3) {
            return 0.0f;
        }
        return ((float) this.height) - f;
    }

    public String toString() {
        return "CropTransformation(width=" + this.width + ", height=" + this.height + ", cropType=" + this.cropType + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) obj;
            if (cropTransformation.width == this.width && cropTransformation.height == this.height && cropTransformation.cropType == this.cropType) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -1462327117 + (this.width * 100000) + (this.height * 1000) + (this.cropType.ordinal() * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.CropTransformation.1" + this.width + this.height + this.cropType).getBytes(CHARSET));
    }
}
