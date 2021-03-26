package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

@Deprecated
public class CropCircleTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropCircleTransformation.1";
    private static final int VERSION = 1;

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1288474723;
    }

    public String toString() {
        return "CropCircleTransformation()";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.circleCrop(bitmapPool, bitmap, i, i2);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof CropCircleTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("jp.wasabeef.glide.transformations.CropCircleTransformation.1".getBytes(CHARSET));
    }
}
