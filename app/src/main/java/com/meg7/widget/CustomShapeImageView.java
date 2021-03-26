package com.meg7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;

public class CustomShapeImageView extends BaseImageView {
    private int mShape;
    private int mSvgRawResourceId;

    public static class Shape {
        public static final int CIRCLE = 1;
        public static final int RECTANGLE = 2;
        public static final int SVG = 3;
    }

    public CustomShapeImageView(Context context) {
        super(context);
        this.mShape = 1;
    }

    public CustomShapeImageView(Context context, int i, int i2, int i3) {
        this(context);
        setImageResource(i);
        this.mShape = i2;
        this.mSvgRawResourceId = i3;
    }

    public CustomShapeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShape = 1;
        sharedConstructor(context, attributeSet);
    }

    public CustomShapeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShape = 1;
        sharedConstructor(context, attributeSet);
    }

    private void sharedConstructor(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomShapeImageView);
        this.mShape = obtainStyledAttributes.getInt(R.styleable.CustomShapeImageView_shape, 1);
        this.mSvgRawResourceId = obtainStyledAttributes.getResourceId(R.styleable.CustomShapeImageView_svg_raw_resource, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // com.meg7.widget.BaseImageView
    public Bitmap getBitmap() {
        int i = this.mShape;
        if (i == 1) {
            return CircleImageView.getBitmap(getWidth(), getHeight());
        }
        if (i == 2) {
            return RectangleImageView.getBitmap(getWidth(), getHeight());
        }
        if (i != 3) {
            return null;
        }
        return SvgImageView.getBitmap(this.mContext, getWidth(), getHeight(), this.mSvgRawResourceId);
    }
}
