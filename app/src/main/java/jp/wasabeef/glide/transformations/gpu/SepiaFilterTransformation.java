package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSepiaToneFilter;

public class SepiaFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation.1";
    private static final int VERSION = 1;
    private final float intensity;

    public SepiaFilterTransformation() {
        this(1.0f);
    }

    public SepiaFilterTransformation(float f) {
        super(new GPUImageSepiaToneFilter());
        this.intensity = f;
        ((GPUImageSepiaToneFilter) getFilter()).setIntensity(f);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "SepiaFilterTransformation(intensity=" + this.intensity + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof SepiaFilterTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 895516065 + ((int) (this.intensity * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation.1" + this.intensity).getBytes(CHARSET));
    }
}
