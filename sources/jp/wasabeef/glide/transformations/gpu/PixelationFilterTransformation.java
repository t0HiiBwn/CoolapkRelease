package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImagePixelationFilter;

public class PixelationFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation.1";
    private static final int VERSION = 1;
    private final float pixel;

    public PixelationFilterTransformation() {
        this(10.0f);
    }

    public PixelationFilterTransformation(float f) {
        super(new GPUImagePixelationFilter());
        this.pixel = f;
        ((GPUImagePixelationFilter) getFilter()).setPixel(f);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "PixelationFilterTransformation(pixel=" + this.pixel + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof PixelationFilterTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1525023660 + ((int) (this.pixel * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation.1" + this.pixel).getBytes(CHARSET));
    }
}
