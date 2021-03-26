package com.coolapk.market.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/imageloader/GlideModuleImpl;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "applyOptions", "", "context", "Landroid/content/Context;", "builder", "Lcom/bumptech/glide/GlideBuilder;", "isManifestParsingEnabled", "", "registerComponents", "glide", "Lcom/bumptech/glide/Glide;", "registry", "Lcom/bumptech/glide/Registry;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GlideModuleImpl.kt */
public final class GlideModuleImpl extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glideBuilder, "builder");
        glideBuilder.setDefaultRequestOptions(RequestOptions.formatOf(DecodeFormat.PREFER_ARGB_8888));
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glide, "glide");
        Intrinsics.checkNotNullParameter(registry, "registry");
        super.registerComponents(context, glide, registry);
        Registry replace = registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(GlideProgressHelper.createOkHttpClient()));
        BitmapPool bitmapPool = glide.getBitmapPool();
        Intrinsics.checkNotNullExpressionValue(bitmapPool, "glide.bitmapPool");
        Registry register = replace.register(Bitmap.class, PaletteBitmap.class, new PaletteBitmapTranscoder(bitmapPool));
        BitmapPool bitmapPool2 = glide.getBitmapPool();
        Intrinsics.checkNotNullExpressionValue(bitmapPool2, "glide.bitmapPool");
        Registry append = register.append(Uri.class, Bitmap.class, new AppIconWithPackageNameDecoder(context, bitmapPool2));
        BitmapPool bitmapPool3 = glide.getBitmapPool();
        Intrinsics.checkNotNullExpressionValue(bitmapPool3, "glide.bitmapPool");
        append.append(Uri.class, Bitmap.class, new AppIconWithFilePathDecoder(context, bitmapPool3)).prepend(File.class, BitmapFactory.Options.class, new BitmapSizeDecoder()).register(BitmapFactory.Options.class, Size.class, new OptionsSizeResourceTranscoder());
    }
}
