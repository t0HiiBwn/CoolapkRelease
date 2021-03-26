package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class ScaleImageView extends AppCompatImageView {
    private ImageChangeListener imageChangeListener;
    private boolean isAutoScale = true;

    public interface ImageChangeListener {
        void changed(boolean z);
    }

    public ScaleImageView(Context context) {
        super(context);
        init();
    }

    public ScaleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public ScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ImageChangeListener imageChangeListener2 = this.imageChangeListener;
        if (imageChangeListener2 != null) {
            imageChangeListener2.changed(bitmap == null);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        boolean z = true;
        if (drawable instanceof BitmapDrawable) {
            setAutoScale(true);
        } else {
            setAutoScale(false);
        }
        ImageChangeListener imageChangeListener2 = this.imageChangeListener;
        if (imageChangeListener2 != null) {
            if (drawable != null) {
                z = false;
            }
            imageChangeListener2.changed(z);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        setAutoScale(false);
        super.setImageResource(i);
    }

    public ImageChangeListener getImageChangeListener() {
        return this.imageChangeListener;
    }

    public void setImageChangeListener(ImageChangeListener imageChangeListener2) {
        this.imageChangeListener = imageChangeListener2;
    }

    public void setAutoScale(boolean z) {
        this.isAutoScale = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        if (!this.isAutoScale) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = size - (getPaddingLeft() + getPaddingRight());
        int paddingTop = size2 - (getPaddingTop() + getPaddingBottom());
        if (mode == 1073741824 && mode2 == 1073741824) {
            super.onMeasure(i, i2);
        } else if (paddingLeft == 0 || paddingTop == 0) {
            super.onMeasure(i, i2);
        } else {
            if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
                z = true;
            } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
                z = false;
            } else {
                throw new IllegalStateException("width or height needs to be set to match_parent or a specific dimension");
            }
            if (getDrawable() == null || getDrawable().getIntrinsicWidth() == 0) {
                super.onMeasure(i, i2);
                return;
            }
            if (z) {
                int intrinsicWidth = getDrawable().getIntrinsicWidth();
                int intrinsicHeight = getDrawable().getIntrinsicHeight();
                int i3 = (paddingLeft * intrinsicHeight) / intrinsicWidth;
                if (paddingTop <= 0 || i3 <= paddingTop || mode2 == 0) {
                    paddingTop = i3;
                } else {
                    paddingLeft = (paddingTop * intrinsicWidth) / intrinsicHeight;
                }
                if (paddingTop / paddingLeft >= 2) {
                    paddingTop = paddingLeft * 2;
                    paddingLeft = (int) (((float) paddingTop) * (((float) intrinsicWidth) / ((float) intrinsicHeight)));
                }
                setMeasuredDimension(paddingLeft, paddingTop);
            } else {
                int intrinsicWidth2 = getDrawable().getIntrinsicWidth();
                int intrinsicHeight2 = getDrawable().getIntrinsicHeight();
                int i4 = (paddingTop * intrinsicWidth2) / intrinsicHeight2;
                if (paddingLeft <= 0 || i4 <= paddingLeft) {
                    paddingLeft = i4;
                } else {
                    paddingTop = (intrinsicHeight2 * paddingLeft) / intrinsicWidth2;
                }
                setMeasuredDimension(paddingLeft, paddingTop);
            }
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }
}
