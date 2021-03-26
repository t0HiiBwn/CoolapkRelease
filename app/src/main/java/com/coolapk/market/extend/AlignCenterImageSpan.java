package com.coolapk.market.extend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JR\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/extend/AlignCenterImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "source", "", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DrawableExtends.kt */
final class AlignCenterImageSpan extends ImageSpan {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlignCenterImageSpan(Drawable drawable, String str) {
        super(drawable, str);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(str, "source");
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        Intrinsics.checkNotNullExpressionValue(drawable, "b");
        canvas.save();
        canvas.translate(f, (float) (((((fontMetricsInt.top + i4) + i4) + fontMetricsInt.bottom) / 2) - drawable.getBounds().centerY()));
        drawable.draw(canvas);
        canvas.restore();
    }
}
