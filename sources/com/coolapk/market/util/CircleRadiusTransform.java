package com.coolapk.market.util;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.Key;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/util/CircleRadiusTransform;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "Lcom/coolapk/market/app/OnBitmapTransformListener;", "radius", "", "isStroke", "", "(FZ)V", "circleRadiusCrop", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "source", "context", "Landroid/content/Context;", "transform", "toTransform", "outWidth", "", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CircleRadiusTransform.kt */
public final class CircleRadiusTransform extends BitmapTransformation implements OnBitmapTransformListener {
    public static final Companion Companion = new Companion(null);
    private static final String ID = (CircleRadiusTransform.class.getName() + ".1");
    private static final int VERSION = 1;
    private final boolean isStroke;
    private final float radius;

    public CircleRadiusTransform() {
        this(0.0f, false, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircleRadiusTransform(float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? NumberExtendsKt.getDpf((Number) 4) : f, (i & 2) != 0 ? true : z);
    }

    public CircleRadiusTransform(float f, boolean z) {
        this.radius = f;
        this.isStroke = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/util/CircleRadiusTransform$Companion;", "", "()V", "ID", "", "VERSION", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CircleRadiusTransform.kt */
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
        String str = ID + this.radius + this.isStroke;
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
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        return circleRadiusCrop(bitmapPool, bitmap, application, this.isStroke);
    }

    private final Bitmap circleRadiusCrop(BitmapPool bitmapPool, Bitmap bitmap, Context context, boolean z) {
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Intrinsics.checkNotNull(bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        float f = this.radius;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
            paint2.setStrokeWidth((float) DisplayUtils.dp2px(context, 1.0f));
            float f2 = this.radius;
            canvas.drawRoundRect(rectF, f2, f2, paint2);
        }
        return bitmap2;
    }
}
