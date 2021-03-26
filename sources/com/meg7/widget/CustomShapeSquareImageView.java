package com.meg7.widget;

import android.content.Context;
import android.util.AttributeSet;

public class CustomShapeSquareImageView extends CustomShapeImageView {
    public CustomShapeSquareImageView(Context context, int i, int i2, int i3) {
        super(context, i, i2, i3);
    }

    public CustomShapeSquareImageView(Context context) {
        super(context);
    }

    public CustomShapeSquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomShapeSquareImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
