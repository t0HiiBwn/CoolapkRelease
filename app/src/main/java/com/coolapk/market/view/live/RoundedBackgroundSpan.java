package com.coolapk.market.view.live;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BI\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJP\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0016J2\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J(\u0010&\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0002R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006'"}, d2 = {"Lcom/coolapk/market/view/live/RoundedBackgroundSpan;", "Landroid/text/style/ReplacementSpan;", "backgroundColor", "", "textColor", "textSize", "", "radius", "paddingX", "paddingY", "marginStart", "(IIFFFFF)V", "getBackgroundColor", "()I", "getMarginStart", "()F", "getPaddingX", "getPaddingY", "getRadius", "getTextColor", "getTextSize", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getSpanWidth", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RoundedBackgroundSpan.kt */
public final class RoundedBackgroundSpan extends ReplacementSpan {
    private final int backgroundColor;
    private final float marginStart;
    private final float paddingX;
    private final float paddingY;
    private final float radius;
    private final int textColor;
    private final float textSize;

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getPaddingX() {
        return this.paddingX;
    }

    public final float getPaddingY() {
        return this.paddingY;
    }

    public RoundedBackgroundSpan(int i, int i2, float f, float f2, float f3, float f4, float f5) {
        this.backgroundColor = i;
        this.textColor = i2;
        this.textSize = f;
        this.radius = f2;
        this.paddingX = f3;
        this.paddingY = f4;
        this.marginStart = f5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundedBackgroundSpan(int i, int i2, float f, float f2, float f3, float f4, float f5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, f, (i3 & 8) != 0 ? 0.0f : f2, (i3 & 16) != 0 ? 0.0f : f3, (i3 & 32) != 0 ? 0.0f : f4, (i3 & 64) != 0 ? 0.0f : f5);
    }

    public final float getMarginStart() {
        return this.marginStart;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        paint.setTextSize(this.textSize);
        return getSpanWidth(charSequence, i, i2, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setTextSize(this.textSize);
        int spanWidth = getSpanWidth(charSequence, i, i2, paint);
        float f2 = (((float) (i5 - i3)) - this.textSize) / ((float) 2);
        float f3 = f + this.marginStart;
        float f4 = ((float) i5) - f2;
        float f5 = this.paddingY;
        RectF rectF = new RectF(f3, (((float) i3) + f2) - f5, ((float) spanWidth) + f3, paint.descent() + f4 + f5);
        paint.setColor(this.backgroundColor);
        float f6 = this.radius;
        canvas.drawRoundRect(rectF, f6, f6, paint);
        paint.setColor(this.textColor);
        canvas.drawText(charSequence, i, i2, f3 + this.paddingX, f4, paint);
    }

    private final int getSpanWidth(CharSequence charSequence, int i, int i2, Paint paint) {
        return Math.round(paint.measureText(charSequence.subSequence(i, i2).toString()) + (this.paddingX * ((float) 2)));
    }
}
