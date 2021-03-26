package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.coolapk.market.R;

public class RingProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int centre;
    private int height;
    private OnProgressListener mOnProgressListener;
    private int max;
    private int padding;
    private Paint paint;
    private int progress;
    private int radius;
    private int result;
    private int ringColor;
    private int ringProgressColor;
    private float ringWidth;
    private int style;
    private int textColor;
    private boolean textIsShow;
    private float textSize;
    private int width;

    public interface OnProgressListener {
        void progressToComplete();
    }

    public RingProgressBar(Context context) {
        this(context, null);
    }

    public RingProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.result = 0;
        this.padding = 0;
        this.paint = new Paint();
        this.result = dp2px(100);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RingProgressBar);
        this.ringColor = obtainStyledAttributes.getColor(1, -16777216);
        this.ringProgressColor = obtainStyledAttributes.getColor(2, -1);
        this.textColor = obtainStyledAttributes.getColor(5, -16777216);
        this.textSize = obtainStyledAttributes.getDimension(7, 16.0f);
        this.ringWidth = obtainStyledAttributes.getDimension(3, 5.0f);
        this.max = obtainStyledAttributes.getInteger(0, 100);
        this.textIsShow = obtainStyledAttributes.getBoolean(6, true);
        this.style = obtainStyledAttributes.getInt(4, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width2 = getWidth() / 2;
        this.centre = width2;
        this.radius = (int) (((float) width2) - (this.ringWidth / 2.0f));
        drawCircle(canvas);
        drawTextContent(canvas);
        drawProgress(canvas);
    }

    private void drawCircle(Canvas canvas) {
        this.paint.setColor(this.ringColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.ringWidth);
        this.paint.setAntiAlias(true);
        int i = this.centre;
        canvas.drawCircle((float) i, (float) i, (float) this.radius, this.paint);
    }

    private void drawTextContent(Canvas canvas) {
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setTypeface(Typeface.DEFAULT);
        int i = (int) ((((float) this.progress) / ((float) this.max)) * 100.0f);
        float measureText = this.paint.measureText(i + "%");
        if (this.textIsShow && i != 0 && this.style == 0) {
            int i2 = this.centre;
            canvas.drawText(i + "%", ((float) i2) - (measureText / 2.0f), ((float) i2) + (this.textSize / 2.0f), this.paint);
        }
    }

    private void drawProgress(Canvas canvas) {
        this.paint.setStrokeWidth(this.ringWidth);
        this.paint.setColor(this.ringProgressColor);
        int i = this.centre;
        int i2 = this.radius;
        RectF rectF = new RectF((float) (i - i2), (float) (i - i2), (float) (i + i2), (float) (i + i2));
        int i3 = this.centre;
        int i4 = this.radius;
        float f = this.ringWidth;
        int i5 = this.padding;
        RectF rectF2 = new RectF(((float) (i3 - i4)) + f + ((float) i5), ((float) (i3 - i4)) + f + ((float) i5), (((float) (i3 + i4)) - f) - ((float) i5), (((float) (i3 + i4)) - f) - ((float) i5));
        int i6 = this.style;
        if (i6 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawArc(rectF, -90.0f, (float) ((this.progress * 360) / this.max), false, this.paint);
        } else if (i6 == 1) {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            int i7 = this.progress;
            if (i7 != 0) {
                canvas.drawArc(rectF2, -90.0f, (float) ((i7 * 360) / this.max), true, this.paint);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            this.width = this.result;
        } else {
            this.width = size;
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.height = this.result;
        } else {
            this.height = size2;
        }
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        this.padding = dp2px(5);
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized void setMax(int i) {
        if (i >= 0) {
            this.max = i;
        } else {
            throw new IllegalArgumentException("The max progress of 0");
        }
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public synchronized void setProgress(int i) {
        OnProgressListener onProgressListener;
        if (i < 0) {
            i = 0;
        }
        int i2 = this.max;
        if (i > i2) {
            i = i2;
        }
        if (i <= i2) {
            this.progress = i;
            postInvalidate();
        }
        if (i == this.max && (onProgressListener = this.mOnProgressListener) != null) {
            onProgressListener.progressToComplete();
        }
    }

    public int getRingColor() {
        return this.ringColor;
    }

    public void setRingColor(int i) {
        this.ringColor = i;
    }

    public int getRingProgressColor() {
        return this.ringProgressColor;
    }

    public void setRingProgressColor(int i) {
        this.ringProgressColor = i;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public float getRingWidth() {
        return this.ringWidth;
    }

    public void setRingWidth(float f) {
        this.ringWidth = f;
    }

    public int dp2px(int i) {
        return (int) ((((float) i) * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.mOnProgressListener = onProgressListener;
    }
}
