package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import java.security.MessageDigest;
import java.util.Arrays;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter;

public class VignetteFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1";
    private static final int VERSION = 1;
    private final PointF center;
    private final float[] vignetteColor;
    private final float vignetteEnd;
    private final float vignetteStart;

    public VignetteFilterTransformation() {
        this(new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 0.75f);
    }

    public VignetteFilterTransformation(PointF pointF, float[] fArr, float f, float f2) {
        super(new GPUImageVignetteFilter());
        this.center = pointF;
        this.vignetteColor = fArr;
        this.vignetteStart = f;
        this.vignetteEnd = f2;
        GPUImageVignetteFilter gPUImageVignetteFilter = (GPUImageVignetteFilter) getFilter();
        gPUImageVignetteFilter.setVignetteCenter(pointF);
        gPUImageVignetteFilter.setVignetteColor(fArr);
        gPUImageVignetteFilter.setVignetteStart(f);
        gPUImageVignetteFilter.setVignetteEnd(f2);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "VignetteFilterTransformation(center=" + this.center.toString() + ",color=" + Arrays.toString(this.vignetteColor) + ",start=" + this.vignetteStart + ",end=" + this.vignetteEnd + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof VignetteFilterTransformation) {
            VignetteFilterTransformation vignetteFilterTransformation = (VignetteFilterTransformation) obj;
            if (vignetteFilterTransformation.center.equals(this.center.x, this.center.y) && Arrays.equals(vignetteFilterTransformation.vignetteColor, this.vignetteColor) && vignetteFilterTransformation.vignetteStart == this.vignetteStart && vignetteFilterTransformation.vignetteEnd == this.vignetteEnd) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1874002103 + this.center.hashCode() + Arrays.hashCode(this.vignetteColor) + ((int) (this.vignetteStart * 100.0f)) + ((int) (this.vignetteEnd * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1" + this.center + Arrays.hashCode(this.vignetteColor) + this.vignetteStart + this.vignetteEnd).getBytes(CHARSET));
    }
}
