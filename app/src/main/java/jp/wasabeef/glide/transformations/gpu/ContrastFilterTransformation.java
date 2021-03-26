package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageContrastFilter;

public class ContrastFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation.1";
    private static final int VERSION = 1;
    private final float contrast;

    public ContrastFilterTransformation() {
        this(1.0f);
    }

    public ContrastFilterTransformation(float f) {
        super(new GPUImageContrastFilter());
        this.contrast = f;
        ((GPUImageContrastFilter) getFilter()).setContrast(f);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "ContrastFilterTransformation(contrast=" + this.contrast + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof ContrastFilterTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -306633601 + ((int) (this.contrast * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation.1" + this.contrast).getBytes(CHARSET));
    }
}
