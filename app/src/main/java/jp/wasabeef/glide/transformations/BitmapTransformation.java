package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    @Override // com.bumptech.glide.load.Key
    public abstract boolean equals(Object obj);

    @Override // com.bumptech.glide.load.Key
    public abstract int hashCode();

    protected abstract Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.Key
    public abstract void updateDiskCacheKey(MessageDigest messageDigest);

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int i, int i2) {
        if (Util.isValidDimensions(i, i2)) {
            BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap bitmap = resource.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap transform = transform(context.getApplicationContext(), bitmapPool, bitmap, i, i2);
            if (bitmap.equals(transform)) {
                return resource;
            }
            return BitmapResource.obtain(transform, bitmapPool);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    void setCanvasBitmapDensity(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
    }
}
