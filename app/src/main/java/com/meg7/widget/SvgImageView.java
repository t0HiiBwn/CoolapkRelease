package com.meg7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.svgandroid.SVGParser;

public class SvgImageView extends BaseImageView {
    private int mSvgRawResourceId;

    public SvgImageView(Context context) {
        super(context);
    }

    public SvgImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        sharedConstructor(context, attributeSet);
    }

    public SvgImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sharedConstructor(context, attributeSet);
    }

    private void sharedConstructor(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomShapeImageView);
        this.mSvgRawResourceId = obtainStyledAttributes.getResourceId(R.styleable.CustomShapeImageView_svg_raw_resource, 0);
        obtainStyledAttributes.recycle();
    }

    public static Bitmap getBitmap(Context context, int i, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        if (i3 > 0) {
            canvas.drawPicture(SVGParser.getSVGFromInputStream(context.getResources().openRawResource(i3), i, i2).getPicture());
        } else {
            canvas.drawRect(new RectF(0.0f, 0.0f, (float) i, (float) i2), paint);
        }
        return createBitmap;
    }

    @Override // com.meg7.widget.BaseImageView
    public Bitmap getBitmap() {
        return getBitmap(this.mContext, getWidth(), getHeight(), this.mSvgRawResourceId);
    }
}
