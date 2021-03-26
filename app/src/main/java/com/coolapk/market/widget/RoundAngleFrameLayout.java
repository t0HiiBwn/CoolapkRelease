package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.coolapk.market.R;

public class RoundAngleFrameLayout extends FrameLayout {
    private float bottomLeftRadius;
    private float bottomRightRadius;
    private Paint imagePaint;
    private Paint roundPaint;
    private float topLeftRadius;
    private float topRightRadius;

    public RoundAngleFrameLayout(Context context) {
        this(context, null);
    }

    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundAngleFrameLayout);
            float dimension = obtainStyledAttributes.getDimension(2, 0.0f);
            this.topLeftRadius = obtainStyledAttributes.getDimension(3, dimension);
            this.topRightRadius = obtainStyledAttributes.getDimension(4, dimension);
            this.bottomLeftRadius = obtainStyledAttributes.getDimension(0, dimension);
            this.bottomRightRadius = obtainStyledAttributes.getDimension(1, dimension);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.roundPaint = paint;
        paint.setColor(-1);
        this.roundPaint.setAntiAlias(true);
        this.roundPaint.setStyle(Paint.Style.FILL);
        this.roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.imagePaint = paint2;
        paint2.setXfermode(null);
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), this.imagePaint, 31);
        super.dispatchDraw(canvas);
        drawTopLeft(canvas);
        drawTopRight(canvas);
        drawBottomLeft(canvas);
        drawBottomRight(canvas);
        canvas.restore();
    }

    private void drawTopLeft(Canvas canvas) {
        if (this.topLeftRadius > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.topLeftRadius);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.topLeftRadius, 0.0f);
            float f = this.topLeftRadius;
            path.arcTo(new RectF(0.0f, 0.0f, f * 2.0f, f * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void drawTopRight(Canvas canvas) {
        if (this.topRightRadius > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            float f = (float) width;
            path.moveTo(f - this.topRightRadius, 0.0f);
            path.lineTo(f, 0.0f);
            path.lineTo(f, this.topRightRadius);
            float f2 = this.topRightRadius;
            path.arcTo(new RectF(f - (f2 * 2.0f), 0.0f, f, f2 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void drawBottomLeft(Canvas canvas) {
        if (this.bottomLeftRadius > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            float f = (float) height;
            path.moveTo(0.0f, f - this.bottomLeftRadius);
            path.lineTo(0.0f, f);
            path.lineTo(this.bottomLeftRadius, f);
            float f2 = this.bottomLeftRadius;
            path.arcTo(new RectF(0.0f, f - (f2 * 2.0f), f2 * 2.0f, f), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void drawBottomRight(Canvas canvas) {
        if (this.bottomRightRadius > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f = (float) width;
            float f2 = (float) height;
            path.moveTo(f - this.bottomRightRadius, f2);
            path.lineTo(f, f2);
            path.lineTo(f, f2 - this.bottomRightRadius);
            float f3 = this.bottomRightRadius;
            path.arcTo(new RectF(f - (f3 * 2.0f), f2 - (f3 * 2.0f), f, f2), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }
}
