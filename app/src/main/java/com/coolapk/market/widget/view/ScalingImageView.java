package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0014J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/widget/view/ScalingImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "requestLayout", "", "setFrame", "", "l", "", "t", "r", "b", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setupImageMatrix", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ScalingImageView.kt */
public class ScalingImageView extends AppCompatImageView {
    public ScalingImageView(Context context) {
        super(context);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public ScalingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        boolean z = !Intrinsics.areEqual(getDrawable(), drawable);
        super.setImageDrawable(drawable);
        if (z) {
            setupImageMatrix();
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            setupImageMatrix();
        }
        return frame;
    }

    private final void setupImageMatrix() {
        float f;
        float f2;
        float f3;
        Matrix imageMatrix = getImageMatrix();
        Drawable drawable = getDrawable();
        imageMatrix.reset();
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if (intrinsicWidth > 0 && intrinsicHeight > 0 && height > 0 && width > 0) {
                float f4 = 0.0f;
                if (intrinsicWidth * height > width * intrinsicHeight) {
                    f3 = ((float) height) / ((float) intrinsicHeight);
                    f2 = (((float) width) - (((float) intrinsicWidth) * f3)) * 0.5f;
                    f = 0.0f;
                } else {
                    f3 = ((float) width) / ((float) intrinsicWidth);
                    f = (((float) height) - (((float) intrinsicHeight) * f3)) * 0.5f;
                    f2 = 0.0f;
                }
                imageMatrix.setScale(f3, f3);
                float f5 = ((float) width) / ((float) height);
                if (f5 <= ((float) intrinsicWidth) / ((float) intrinsicHeight) || f5 > 0.5f) {
                    f4 = f;
                }
                imageMatrix.postTranslate((float) Math.round(f2), (float) Math.round(f4));
                setImageMatrix(imageMatrix);
            }
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        if (ViewExtendsKt.checkShouldRequestLayout(this)) {
            super.requestLayout();
        }
    }
}
