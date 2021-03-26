package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class ColorFilterTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.ColorFilterTransformation.1";
    private static final int VERSION = 1;
    private final int color;

    public ColorFilterTransformation(int i) {
        this.color = i;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        setCanvasBitmapDensity(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.color, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmap2;
    }

    public String toString() {
        return "ColorFilterTransformation(color=" + this.color + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof ColorFilterTransformation) && ((ColorFilterTransformation) obj).color == this.color;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 705373712 + (this.color * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.ColorFilterTransformation.1" + this.color).getBytes(CHARSET));
    }
}
