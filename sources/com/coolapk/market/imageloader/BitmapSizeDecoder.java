package com.coolapk.market.imageloader;

import android.graphics.BitmapFactory;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/imageloader/BitmapSizeDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Ljava/io/File;", "Landroid/graphics/BitmapFactory$Options;", "()V", "decode", "Lcom/bumptech/glide/load/engine/Resource;", "file", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BitmapSizeDecoder.kt */
public final class BitmapSizeDecoder implements ResourceDecoder<File, BitmapFactory.Options> {
    public boolean handles(File file, Options options) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(options, "options");
        return true;
    }

    public Resource<BitmapFactory.Options> decode(File file, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(options, "options");
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
        return new SimpleResource(options2);
    }
}
