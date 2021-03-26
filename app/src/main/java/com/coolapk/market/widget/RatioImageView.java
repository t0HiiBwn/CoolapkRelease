package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

public class RatioImageView extends AppCompatImageView {
    private int originalHeight;
    private int originalWidth;

    public RatioImageView(Context context) {
        super(context);
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOriginalSize(int i, int i2) {
        this.originalWidth = i;
        this.originalHeight = i2;
        requestLayout();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = this.originalWidth;
        if (i4 <= 0 || (i3 = this.originalHeight) <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        float f = ((float) i4) / ((float) i3);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getMode(i);
        if (View.MeasureSpec.getMode(i2) == 1073741824 && size2 > 0) {
            setMeasuredDimension((int) (((float) size2) * f), size2);
        } else if (size > 0) {
            setMeasuredDimension(size, (int) (((float) size) / f));
        }
    }
}
