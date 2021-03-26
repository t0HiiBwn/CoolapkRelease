package com.meg7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RectangleImageView extends BaseImageView {
    public RectangleImageView(Context context) {
        super(context);
    }

    public RectangleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RectangleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static Bitmap getBitmap(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        canvas.drawRect(new RectF(0.0f, 0.0f, (float) i, (float) i2), paint);
        return createBitmap;
    }

    @Override // com.meg7.widget.BaseImageView
    public Bitmap getBitmap() {
        return getBitmap(getWidth(), getHeight());
    }
}
