package com.coolapk.market.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class TriangleDrawable extends Drawable {
    private int alpha;
    private int color;
    private Paint paint;
    private int strokeColor;
    private float strokeWidth;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public TriangleDrawable() {
        this(0);
    }

    public TriangleDrawable(int i) {
        this.color = 0;
        this.strokeColor = 0;
        this.strokeWidth = 0.0f;
        this.paint = new Paint();
        this.color = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Path path = new Path();
        path.moveTo((float) (bounds.left + ((bounds.right - bounds.left) / 2)), (float) bounds.top);
        path.lineTo((float) bounds.right, (float) bounds.bottom);
        path.lineTo((float) bounds.left, (float) bounds.bottom);
        path.lineTo((float) (bounds.left + ((bounds.right - bounds.left) / 2)), (float) bounds.top);
        this.paint.setColor(this.color);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.strokeColor);
        this.paint.setStrokeWidth(this.strokeWidth);
        canvas.drawPath(path, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public int getColor() {
        return this.color;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }
}
