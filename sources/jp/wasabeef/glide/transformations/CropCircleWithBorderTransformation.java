package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.Utils;

public class CropCircleWithBorderTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1";
    private static final int VERSION = 1;
    private final int borderColor;
    private final int borderSize;

    public CropCircleWithBorderTransformation() {
        this.borderSize = Utils.toDp(4);
        this.borderColor = -16777216;
    }

    public CropCircleWithBorderTransformation(int i, int i2) {
        this.borderSize = i;
        this.borderColor = i2;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap circleCrop = TransformationUtils.circleCrop(bitmapPool, bitmap, i, i2);
        setCanvasBitmapDensity(bitmap, circleCrop);
        Paint paint = new Paint();
        paint.setColor(this.borderColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.borderSize);
        paint.setAntiAlias(true);
        new Canvas(circleCrop).drawCircle(((float) i) / 2.0f, ((float) i2) / 2.0f, (((float) Math.max(i, i2)) / 2.0f) - (((float) this.borderSize) / 2.0f), paint);
        return circleCrop;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1" + this.borderSize + this.borderColor).getBytes(CHARSET));
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof CropCircleWithBorderTransformation) {
            CropCircleWithBorderTransformation cropCircleWithBorderTransformation = (CropCircleWithBorderTransformation) obj;
            if (cropCircleWithBorderTransformation.borderSize == this.borderSize && cropCircleWithBorderTransformation.borderColor == this.borderColor) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 882652245 + (this.borderSize * 100) + this.borderColor + 10;
    }
}
