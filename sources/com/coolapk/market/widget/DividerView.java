package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.coolapk.market.R;

public class DividerView extends View {
    public static int ORIENTATION_HORIZONTAL = 0;
    public static int ORIENTATION_VERTICAL = 1;
    private Paint mPaint;
    private int orientation;

    /* JADX INFO: finally extract failed */
    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DividerView, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(2, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, 3);
            int color = obtainStyledAttributes.getColor(0, -16777216);
            this.orientation = obtainStyledAttributes.getInt(4, ORIENTATION_HORIZONTAL);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(color);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth((float) dimensionPixelSize3);
            this.mPaint.setPathEffect(new DashPathEffect(new float[]{(float) dimensionPixelSize2, (float) dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public DividerView(Context context) {
        this(context, null);
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.orientation == ORIENTATION_HORIZONTAL) {
            float height = ((float) getHeight()) * 0.5f;
            canvas.drawLine(0.0f, height, (float) getWidth(), height, this.mPaint);
            return;
        }
        float width = ((float) getWidth()) * 0.5f;
        canvas.drawLine(width, 0.0f, width, (float) getHeight(), this.mPaint);
    }
}
