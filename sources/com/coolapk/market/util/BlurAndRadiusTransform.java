package com.coolapk.market.util;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.extend.NumberExtendsKt;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/util/BlurAndRadiusTransform;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "Lcom/coolapk/market/app/OnBitmapTransformListener;", "radius", "", "(F)V", "context", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "getRadius", "()F", "setRadius", "circleRadiusCrop", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "source", "Landroid/content/Context;", "transform", "toTransform", "outWidth", "", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlurAndRadiusTransform.kt */
public final class BlurAndRadiusTransform extends BitmapTransformation implements OnBitmapTransformListener {
    public static final Companion Companion = new Companion(null);
    private static final String ID = (BlurAndRadiusTransform.class.getName() + ".1");
    private static final int VERSION = 1;
    private final Application context;
    private float radius;

    public BlurAndRadiusTransform() {
        this(0.0f, 1, null);
    }

    public BlurAndRadiusTransform(float f) {
        this.radius = f;
        this.context = AppHolder.getApplication();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlurAndRadiusTransform(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? NumberExtendsKt.getDpf((Number) 4) : f);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/util/BlurAndRadiusTransform$Companion;", "", "()V", "ID", "", "VERSION", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BlurAndRadiusTransform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(bitmap, "toTransform");
        Application application = this.context;
        Intrinsics.checkNotNullExpressionValue(application, "context");
        return circleRadiusCrop(bitmapPool, bitmap, application);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        String str = ID + this.radius;
        Charset charset = BitmapTransformation.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "CHARSET");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
    }

    private final Bitmap circleRadiusCrop(BitmapPool bitmapPool, Bitmap bitmap, Context context2) {
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Bitmap blurLogoCover = BlurUtils.blurLogoCover(context2, bitmap2);
        Canvas canvas = new Canvas(blurLogoCover);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(blurLogoCover, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        Intrinsics.checkNotNullExpressionValue(blurLogoCover, "result");
        RectF rectF = new RectF(0.0f, 0.0f, (float) blurLogoCover.getWidth(), (float) blurLogoCover.getHeight());
        float f = this.radius;
        canvas.drawRoundRect(rectF, f, f, paint);
        return blurLogoCover;
    }
}
