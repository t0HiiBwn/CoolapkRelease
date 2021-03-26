package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageKuwaharaFilter;

public class KuwaharaFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation.1";
    private static final int VERSION = 1;
    private final int radius;

    public KuwaharaFilterTransformation() {
        this(25);
    }

    public KuwaharaFilterTransformation(int i) {
        super(new GPUImageKuwaharaFilter());
        this.radius = i;
        ((GPUImageKuwaharaFilter) getFilter()).setRadius(i);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "KuwaharaFilterTransformation(radius=" + this.radius + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof KuwaharaFilterTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -1859800423 + (this.radius * 10);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation.1" + this.radius).getBytes(CHARSET));
    }
}
