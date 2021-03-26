package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;

public class BlurTransformation extends BitmapTransformation {
    private static final int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = "jp.wasabeef.glide.transformations.BlurTransformation.1";
    private static final int MAX_RADIUS = 25;
    private static final int VERSION = 1;
    private final int radius;
    private final int sampling;

    public BlurTransformation() {
        this(25, 1);
    }

    public BlurTransformation(int i) {
        this(i, 1);
    }

    public BlurTransformation(int i, int i2) {
        this.radius = i;
        this.sampling = i2;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.sampling;
        Bitmap bitmap2 = bitmapPool.get(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        setCanvasBitmapDensity(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        int i4 = this.sampling;
        canvas.scale(1.0f / ((float) i4), 1.0f / ((float) i4));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            return RSBlur.blur(context, bitmap2, this.radius);
        } catch (RSRuntimeException unused) {
            return FastBlur.blur(bitmap2, this.radius, true);
        }
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.radius + ", sampling=" + this.sampling + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            if (blurTransformation.radius == this.radius && blurTransformation.sampling == this.sampling) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 737513610 + (this.radius * 1000) + (this.sampling * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.BlurTransformation.1" + this.radius + this.sampling).getBytes(CHARSET));
    }
}
