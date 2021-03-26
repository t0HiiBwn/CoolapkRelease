package com.coolapk.market.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.OnBitmapTransformListener;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J(\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/util/BlurTransform;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "Lcom/coolapk/market/app/OnBitmapTransformListener;", "()V", "radius", "", "sampling", "blur", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "source", "transform", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlurTransform.kt */
public final class BlurTransform extends BitmapTransformation implements OnBitmapTransformListener {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = (BlurTransform.class.getName() + ".1");
    private static final int MAX_RADIUS = 25;
    private static final int VERSION = 1;
    private final int radius = 25;
    private final int sampling = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/util/BlurTransform$Companion;", "", "()V", "DEFAULT_DOWN_SAMPLING", "", "ID", "", "MAX_RADIUS", "VERSION", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BlurTransform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        String str = ID + this.radius + this.sampling;
        Charset charset = Key.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "Key.CHARSET");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(bitmap, "toTransform");
        return blur(bitmapPool, bitmap);
    }

    private final Bitmap blur(BitmapPool bitmapPool, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.sampling;
        int i2 = width / i;
        int i3 = height / i;
        Bitmap bitmap2 = bitmapPool.get(i2, i3, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        Intrinsics.checkNotNull(bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        float f = (float) 1;
        int i4 = this.sampling;
        canvas.scale(f / ((float) i4), f / ((float) i4));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        Bitmap blurLogoCover = BlurUtils.blurLogoCover(AppHolder.getApplication(), bitmap2);
        Intrinsics.checkNotNullExpressionValue(blurLogoCover, "bitmap");
        return blurLogoCover;
    }
}
