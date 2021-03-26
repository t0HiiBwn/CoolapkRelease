package com.coolapk.market.imageloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/imageloader/AppIconWithPackageNameDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "(Landroid/content/Context;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)V", "decode", "Lcom/bumptech/glide/load/engine/Resource;", "source", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppIconDecoder.kt */
public final class AppIconWithPackageNameDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final Context context;

    public AppIconWithPackageNameDecoder(Context context2, BitmapPool bitmapPool2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        this.context = context2;
        this.bitmapPool = bitmapPool2;
    }

    public boolean handles(Uri uri, Options options) {
        Intrinsics.checkNotNullParameter(uri, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        return Intrinsics.areEqual(uri.getScheme(), "package");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[Catch:{ Exception -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    public Resource<Bitmap> decode(Uri uri, int i, int i2, Options options) {
        boolean z;
        Intrinsics.checkNotNullParameter(uri, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap bitmap = null;
        try {
            String host = uri.getHost();
            String str = host;
            if (str != null) {
                if (str.length() != 0) {
                    z = false;
                    if (!z) {
                        ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(host, 8192);
                        Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager\n …GET_UNINSTALLED_PACKAGES)");
                        bitmap = AppIconDecoderKt.getAppIconLoader().loadIcon(applicationInfo);
                    }
                    if (bitmap == null) {
                        bitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231374);
                    }
                    Intrinsics.checkNotNull(bitmap);
                    return new BitmapResource(bitmap, this.bitmapPool);
                }
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bitmap == null) {
        }
        Intrinsics.checkNotNull(bitmap);
        return new BitmapResource(bitmap, this.bitmapPool);
    }
}
