package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterCrop extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CenterCrop";
    private static final byte[] ID_BYTES = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(CHARSET);

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -599754482;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.centerCrop(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof CenterCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
