package com.coolapk.market.imageloader;

import android.graphics.Bitmap;
import androidx.palette.graphics.Palette;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/imageloader/PaletteBitmapTranscoder;", "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;", "Landroid/graphics/Bitmap;", "Lcom/coolapk/market/imageloader/PaletteBitmap;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V", "transcode", "Lcom/bumptech/glide/load/engine/Resource;", "toTranscode", "options", "Lcom/bumptech/glide/load/Options;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaletteBitmapTranscoder.kt */
public final class PaletteBitmapTranscoder implements ResourceTranscoder<Bitmap, PaletteBitmap> {
    private final BitmapPool bitmapPool;

    public PaletteBitmapTranscoder(BitmapPool bitmapPool2) {
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        this.bitmapPool = bitmapPool2;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<PaletteBitmap> transcode(Resource<Bitmap> resource, Options options) {
        Intrinsics.checkNotNullParameter(resource, "toTranscode");
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap bitmap = resource.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "toTranscode.get()");
        Bitmap bitmap2 = bitmap;
        Palette generate = new Palette.Builder(bitmap2).generate();
        Intrinsics.checkNotNullExpressionValue(generate, "Palette.Builder(bitmap).generate()");
        return new PaletteBitmapResource(new PaletteBitmap(bitmap2, generate), this.bitmapPool);
    }
}
