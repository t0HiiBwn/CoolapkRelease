package com.meg7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CircleImageView extends BaseImageView {
    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static Bitmap getBitmap(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        canvas.drawOval(new RectF(0.0f, 0.0f, (float) i, (float) i2), paint);
        return createBitmap;
    }

    @Override // com.meg7.widget.BaseImageView
    public Bitmap getBitmap() {
        return getBitmap(getWidth(), getHeight());
    }
}
