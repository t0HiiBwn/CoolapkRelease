package com.coolapk.market.imageloader;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/imageloader/PaletteBitmapResource;", "Lcom/bumptech/glide/load/engine/Resource;", "Lcom/coolapk/market/imageloader/PaletteBitmap;", "paletteBitmap", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "(Lcom/coolapk/market/imageloader/PaletteBitmap;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V", "get", "getResourceClass", "Ljava/lang/Class;", "getSize", "", "recycle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaletteBitmapResource.kt */
public final class PaletteBitmapResource implements Resource<PaletteBitmap> {
    private final BitmapPool bitmapPool;
    private final PaletteBitmap paletteBitmap;

    public PaletteBitmapResource(PaletteBitmap paletteBitmap2, BitmapPool bitmapPool2) {
        Intrinsics.checkNotNullParameter(paletteBitmap2, "paletteBitmap");
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        this.paletteBitmap = paletteBitmap2;
        this.bitmapPool = bitmapPool2;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<PaletteBitmap> getResourceClass() {
        return PaletteBitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public PaletteBitmap get() {
        return this.paletteBitmap;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.paletteBitmap.getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(this.paletteBitmap.getBitmap());
    }
}
