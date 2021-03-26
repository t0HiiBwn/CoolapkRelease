package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.coolapk.market.R;

public class AspectRatioImageView extends AppCompatImageView {
    private static final float DEFAULT_ASPECT_RATIO = 1.0f;
    private static final boolean DEFAULT_ASPECT_RATIO_ENABLED = false;
    private static final int DEFAULT_DOMINANT_MEASUREMENT = 0;
    public static final int MEASUREMENT_HEIGHT = 1;
    public static final int MEASUREMENT_WIDTH = 0;
    private float aspectRatio;
    private boolean aspectRatioEnabled;
    private int dominantMeasurement;

    public AspectRatioImageView(Context context) {
        this(context, null);
    }

    public AspectRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AspectRatioImageView);
        this.aspectRatio = obtainStyledAttributes.getFloat(0, 1.0f);
        this.aspectRatioEnabled = obtainStyledAttributes.getBoolean(1, false);
        this.dominantMeasurement = obtainStyledAttributes.getInt(2, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        if (this.aspectRatioEnabled) {
            int i5 = this.dominantMeasurement;
            if (i5 == 0) {
                i3 = getMeasuredWidth();
                i4 = (int) (((float) i3) * this.aspectRatio);
            } else if (i5 == 1) {
                i4 = getMeasuredHeight();
                i3 = (int) (((float) i4) * this.aspectRatio);
            } else {
                throw new IllegalStateException("Unknown measurement with ID " + this.dominantMeasurement);
            }
            setMeasuredDimension(i3, i4);
        }
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public void setAspectRatio(float f) {
        this.aspectRatio = f;
        if (this.aspectRatioEnabled) {
            requestLayout();
        }
    }

    public boolean getAspectRatioEnabled() {
        return this.aspectRatioEnabled;
    }

    public void setAspectRatioEnabled(boolean z) {
        this.aspectRatioEnabled = z;
        requestLayout();
    }

    public int getDominantMeasurement() {
        return this.dominantMeasurement;
    }

    public void setDominantMeasurement(int i) {
        if (i == 1 || i == 0) {
            this.dominantMeasurement = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid measurement type.");
    }
}
