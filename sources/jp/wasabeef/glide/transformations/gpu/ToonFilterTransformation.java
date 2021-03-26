package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageToonFilter;

public class ToonFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation.1";
    private static final int VERSION = 1;
    private final float quantizationLevels;
    private final float threshold;

    public ToonFilterTransformation() {
        this(0.2f, 10.0f);
    }

    public ToonFilterTransformation(float f, float f2) {
        super(new GPUImageToonFilter());
        this.threshold = f;
        this.quantizationLevels = f2;
        GPUImageToonFilter gPUImageToonFilter = (GPUImageToonFilter) getFilter();
        gPUImageToonFilter.setThreshold(f);
        gPUImageToonFilter.setQuantizationLevels(f2);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "ToonFilterTransformation(threshold=" + this.threshold + ",quantizationLevels=" + this.quantizationLevels + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ToonFilterTransformation) {
            ToonFilterTransformation toonFilterTransformation = (ToonFilterTransformation) obj;
            if (toonFilterTransformation.threshold == this.threshold && toonFilterTransformation.quantizationLevels == this.quantizationLevels) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1209810327 + ((int) (this.threshold * 1000.0f)) + ((int) (this.quantizationLevels * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation.1" + this.threshold + this.quantizationLevels).getBytes(CHARSET));
    }
}
