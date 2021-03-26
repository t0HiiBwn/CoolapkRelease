package com.coolapk.market.imageloader;

import android.graphics.BitmapFactory;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/imageloader/OptionsSizeResourceTranscoder;", "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;", "Landroid/graphics/BitmapFactory$Options;", "Lcom/coolapk/market/imageloader/Size;", "()V", "transcode", "Lcom/bumptech/glide/load/engine/Resource;", "resource", "options", "Lcom/bumptech/glide/load/Options;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OptionsSizeResourceTranscoder.kt */
public final class OptionsSizeResourceTranscoder implements ResourceTranscoder<BitmapFactory.Options, Size> {
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<Size> transcode(Resource<BitmapFactory.Options> resource, Options options) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(options, "options");
        BitmapFactory.Options options2 = resource.get();
        Intrinsics.checkNotNullExpressionValue(options2, "resource.get()");
        BitmapFactory.Options options3 = options2;
        return new SimpleResource(new Size(options3.outWidth, options3.outHeight));
    }
}
