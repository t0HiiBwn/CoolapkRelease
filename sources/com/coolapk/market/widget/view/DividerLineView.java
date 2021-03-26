package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J8\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020(H\u0016J0\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0014J,\u00106\u001a\u00020\u0013*\u00020\u00132\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0014H\u0002R&\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u000e\u0010 \u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R$\u0010$\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019¨\u00067"}, d2 = {"Lcom/coolapk/market/widget/view/DividerLineView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "borderColor", "getBorderColor", "()I", "setBorderColor", "(I)V", "borderPaint", "Landroid/graphics/Paint;", "borderPath", "Landroid/graphics/Path;", "borderRectF", "Landroid/graphics/RectF;", "", "borderWidthPx", "getBorderWidthPx", "()F", "setBorderWidthPx", "(F)V", "bottomLeftRadius", "getBottomLeftRadius", "setBottomLeftRadius", "bottomRightRadius", "getBottomRightRadius", "setBottomRightRadius", "rectF", "topLeftRadius", "getTopLeftRadius", "setTopLeftRadius", "topRightRadius", "getTopRightRadius", "setTopRightRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "generatePath", "useBezier", "", "rect", "invalidate", "onLayout", "changed", "left", "top", "right", "bottom", "to", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DividerLineView.kt */
public final class DividerLineView extends View {
    private int borderColor;
    private final Paint borderPaint;
    private final Path borderPath;
    private final RectF borderRectF;
    private float borderWidthPx;
    private float bottomLeftRadius;
    private float bottomRightRadius;
    private final RectF rectF = new RectF();
    private float topLeftRadius;
    private float topRightRadius;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DividerLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        this.borderPaint = paint;
        this.borderRectF = new RectF();
        this.borderPath = new Path();
        this.borderColor = -1;
        paint.setStyle(Paint.Style.STROKE);
        float dp = (float) NumberExtendsKt.getDp((Number) 8);
        setTopLeftRadius(dp);
        setTopRightRadius(dp);
        setBottomRightRadius(dp);
        setBottomLeftRadius(dp);
        setBorderColor(AppHolder.getAppTheme().isDarkTheme() ? 0 : AppHolder.getAppTheme().getCurrencyColorDivider());
        setBorderWidthPx((float) NumberExtendsKt.getDp(Double.valueOf(0.5d)));
    }

    public final float getTopLeftRadius() {
        return this.topLeftRadius;
    }

    public final void setTopLeftRadius(float f) {
        this.topLeftRadius = f;
        invalidate();
    }

    public final float getTopRightRadius() {
        return this.topRightRadius;
    }

    public final void setTopRightRadius(float f) {
        this.topRightRadius = f;
        invalidate();
    }

    public final float getBottomRightRadius() {
        return this.bottomRightRadius;
    }

    public final void setBottomRightRadius(float f) {
        this.bottomRightRadius = f;
        invalidate();
    }

    public final float getBottomLeftRadius() {
        return this.bottomLeftRadius;
    }

    public final void setBottomLeftRadius(float f) {
        this.bottomLeftRadius = f;
        invalidate();
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final void setBorderColor(int i) {
        this.borderColor = i;
        invalidate();
    }

    public final float getBorderWidthPx() {
        return this.borderWidthPx;
    }

    public final void setBorderWidthPx(float f) {
        this.borderWidthPx = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        RectF rectF2 = this.borderRectF;
        float f = this.borderWidthPx;
        rectF2.set(f / 3.0f, f / 3.0f, ((float) getWidth()) - (this.borderWidthPx / 3.0f), ((float) getHeight()) - (this.borderWidthPx / 3.0f));
        this.borderPath.reset();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        if (this.borderPath.isEmpty()) {
            generatePath(false, this.borderRectF, this.topLeftRadius, this.topRightRadius, this.bottomRightRadius, this.bottomLeftRadius);
        }
        this.borderPaint.setStrokeWidth(this.borderWidthPx);
        this.borderPaint.setColor(this.borderColor);
        canvas.drawPath(this.borderPath, this.borderPaint);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.borderPath.reset();
    }

    private final Path generatePath(boolean z, RectF rectF2, float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        int i;
        Path path = this.borderPath;
        path.reset();
        float f7 = rectF2.left;
        float f8 = rectF2.top;
        float f9 = rectF2.bottom;
        float f10 = rectF2.right;
        float min = Math.min(rectF2.width() / 2.0f, rectF2.height() / 2.0f);
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        float abs3 = Math.abs(f4);
        float abs4 = Math.abs(f3);
        float f11 = abs > min ? min : abs;
        if (abs2 > min) {
            abs2 = min;
        }
        float f12 = abs3 > min ? min : abs3;
        float f13 = abs4 > min ? min : abs4;
        float f14 = f7 + f11;
        path.moveTo(f14, f8);
        path.lineTo(f10 - abs2, f8);
        if (z) {
            path.quadTo(f10, f8, f10, abs2 + f8);
            f5 = f14;
            f6 = f8;
            i = 0;
        } else {
            float f15 = abs2 * 2.0f;
            float f16 = f8 + f15;
            f6 = f8;
            i = 0;
            f5 = f14;
            path.arcTo(to(this.rectF, f10 - f15, f8, f10, f16), -90.0f, (float) (f2 > ((float) 0) ? 90 : -270));
        }
        path.lineTo(f10, f9 - f13);
        if (z) {
            path.quadTo(f10, f9, f10 - f13, f9);
        } else {
            int i2 = f13 > ((float) i) ? 90 : -270;
            float f17 = f13 * 2.0f;
            path.arcTo(to(this.rectF, f10 - f17, f9 - f17, f10, f9), 0.0f, (float) i2);
        }
        path.lineTo(f7 + f12, f9);
        if (z) {
            path.quadTo(f7, f9, f7, f9 - f12);
        } else {
            int i3 = f12 > ((float) i) ? 90 : -270;
            float f18 = f12 * 2.0f;
            path.arcTo(to(this.rectF, f7, f9 - f18, f7 + f18, f9), 90.0f, (float) i3);
        }
        path.lineTo(f7, f6 + f11);
        if (z) {
            path.quadTo(f7, f6, f5, f6);
        } else {
            int i4 = f11 > ((float) i) ? 90 : -270;
            float f19 = f11 * 2.0f;
            path.arcTo(to(this.rectF, f7, f6, f7 + f19, f6 + f19), 180.0f, (float) i4);
        }
        path.close();
        return path;
    }

    private final RectF to(RectF rectF2, float f, float f2, float f3, float f4) {
        rectF2.set(f, f2, f3, f4);
        return rectF2;
    }
}
