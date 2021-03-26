package com.coolapk.market.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\n¨\u00062"}, d2 = {"Lcom/coolapk/market/widget/TextDrawable;", "Landroid/graphics/drawable/Drawable;", "text", "", "(Ljava/lang/String;)V", "backgroundColor", "", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "backgroundStyle", "getBackgroundStyle", "setBackgroundStyle", "padding", "Landroid/graphics/Rect;", "paint", "Landroid/graphics/Paint;", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "getText", "()Ljava/lang/String;", "setText", "textColor", "getTextColor", "setTextColor", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setPadding", "left", "top", "right", "bottom", "setTextSize", "size", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextDrawable.kt */
public final class TextDrawable extends Drawable {
    public static final Companion Companion = new Companion(null);
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int backgroundColor = AppHolder.getAppTheme().getColorAccent();
    private int backgroundStyle;
    private Rect padding = new Rect(0, 0, 0, 0);
    private final Paint paint = new Paint(1);
    private float radius = ((float) NumberExtendsKt.getDp((Number) 2));
    private String text;
    private int textColor = AppHolder.getAppTheme().getColorAccent();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public TextDrawable(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final int getBackgroundStyle() {
        return this.backgroundStyle;
    }

    public final void setBackgroundStyle(int i) {
        this.backgroundStyle = i;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/TextDrawable$Companion;", "", "()V", "FILL", "", "STROKE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TextDrawable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        this.padding.set(i, i2, i3, i4);
    }

    public final void setTextSize(float f) {
        this.paint.setTextSize(f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return ((int) this.paint.getFontSpacing()) + this.padding.top + this.padding.bottom;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return ((int) this.paint.measureText(this.text)) + this.padding.left + this.padding.right;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        if (bounds.isEmpty()) {
            setBounds(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
            bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        }
        if (this.backgroundStyle == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
        } else {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        this.paint.setStrokeWidth((float) NumberExtendsKt.getDp(Double.valueOf(0.5d)));
        this.paint.setColor(this.backgroundColor);
        float f = this.radius;
        canvas.drawRoundRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, f, f, this.paint);
        this.paint.setColor(this.textColor);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setTextAlign(Paint.Align.CENTER);
        this.paint.setTextSize((((float) bounds.height()) / 5.0f) * 3.0f);
        float f2 = (((float) ((bounds.bottom - this.padding.bottom) + (bounds.top + this.padding.top))) / 2.0f) - ((float) ((this.paint.getFontMetricsInt().bottom + this.paint.getFontMetricsInt().top) / 2));
        canvas.drawText(this.text, ((float) ((bounds.right - this.padding.right) + (bounds.left + this.padding.left))) / 2.0f, f2, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
