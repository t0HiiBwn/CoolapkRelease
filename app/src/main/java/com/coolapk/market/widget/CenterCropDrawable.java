package com.coolapk.market.widget;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/widget/CenterCropDrawable;", "Landroid/graphics/drawable/DrawableWrapper;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "matrix", "Landroid/graphics/Matrix;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "", "getIntrinsicWidth", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setupImageMatrix", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterCropDrawable.kt */
public final class CenterCropDrawable extends DrawableWrapper {
    private final Matrix matrix = new Matrix();

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return 0;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CenterCropDrawable(Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        super.onBoundsChange(rect);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Drawable drawable2 = getDrawable();
            Intrinsics.checkNotNull(drawable2);
            Intrinsics.checkNotNullExpressionValue(drawable2, "drawable!!");
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            Drawable drawable3 = getDrawable();
            Intrinsics.checkNotNull(drawable3);
            Intrinsics.checkNotNullExpressionValue(drawable3, "drawable!!");
            drawable.setBounds(0, 0, intrinsicWidth, drawable3.getIntrinsicHeight());
        }
        setupImageMatrix();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.concat(this.matrix);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    private final void setupImageMatrix() {
        float f;
        float f2;
        Drawable drawable = getDrawable();
        this.matrix.reset();
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int width = getBounds().width();
            int height = getBounds().height();
            if (intrinsicWidth > 0 && intrinsicHeight > 0 && height > 0 && width > 0) {
                float f3 = 0.0f;
                if (intrinsicWidth * height > width * intrinsicHeight) {
                    f = ((float) height) / ((float) intrinsicHeight);
                    f3 = (((float) width) - (((float) intrinsicWidth) * f)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    float f4 = ((float) width) / ((float) intrinsicWidth);
                    f2 = (((float) height) - (((float) intrinsicHeight) * f4)) * 0.5f;
                    f = f4;
                }
                this.matrix.setScale(f, f);
                this.matrix.postTranslate((float) Math.round(f3), (float) Math.round(f2));
            }
        }
    }
}
