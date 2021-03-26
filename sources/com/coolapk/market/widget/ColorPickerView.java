package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ColorPickerView extends View {
    private static final int[] PALETTE_COLORS = {-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
    private Paint mCirclePaint;
    private int mDefaultHeight;
    private int mDefaultWidth;
    private Paint mEdgePaint;
    private float[] mHSV;
    private int mHeight;
    private float[] mHue;
    private float mHueLeftOffset;
    private Drawable mHuePalette;
    private Rect mHueRect;
    private OnColorChooseListener mListener;
    private int mPaletteWidth;
    private int mRadius;
    private int[] mSatColors;
    private float mSatLeftOffset;
    private GradientDrawable mSatPalette;
    private Rect mSatRect;
    private int mWidth;
    private int target;

    public interface OnColorChooseListener {
        void onColorChoose(int i);
    }

    public ColorPickerView(Context context) {
        this(context, null);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSatColors = new int[]{-16777216, -65536};
        this.mHue = new float[]{0.0f, 1.0f, 1.0f};
        this.mHSV = new float[]{0.0f, 1.0f, 1.0f};
        float f = context.getResources().getDisplayMetrics().density;
        this.mDefaultHeight = (int) ((68.0f * f) + 0.5f);
        this.mDefaultWidth = (int) ((f * 256.0f) + 0.5f);
        Paint paint = new Paint(1);
        this.mEdgePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mEdgePaint.setStrokeWidth(3.0f);
        this.mEdgePaint.setColor(-3355444);
        Paint paint2 = new Paint(1);
        this.mCirclePaint = paint2;
        paint2.setColor(-855310);
        setLayerType(1, this.mCirclePaint);
        this.mCirclePaint.setShadowLayer(4.0f, 0.0f, 1.0f, -3355444);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            size = this.mDefaultWidth;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = this.mDefaultHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mHeight = measuredHeight;
        int i5 = measuredHeight / 7;
        this.mRadius = i5;
        this.mHueRect = new Rect(getPaddingLeft() + this.mRadius, i5, (this.mWidth - getPaddingRight()) - this.mRadius, i5 * 2);
        this.mSatRect = new Rect(getPaddingLeft() + this.mRadius, i5 * 5, (this.mWidth - getPaddingRight()) - this.mRadius, i5 * 6);
        int width = this.mHueRect.width();
        this.mPaletteWidth = width;
        float[] fArr = this.mHSV;
        int i6 = this.mRadius;
        this.mHueLeftOffset = (float) (((int) ((fArr[0] * ((float) width)) / 360.0f)) + i6);
        this.mSatLeftOffset = (float) (((int) (((fArr[2] * 10.0f) * ((float) width)) / 10.0f)) + i6);
        this.mHuePalette = createHuePalette();
        this.mSatPalette = createSatPalette();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mHuePalette.draw(canvas);
        this.mSatPalette.draw(canvas);
        canvas.drawCircle(this.mHueLeftOffset, (((float) this.mHeight) / 14.0f) * 3.0f, (float) this.mRadius, this.mCirclePaint);
        canvas.drawCircle(this.mHueLeftOffset, (((float) this.mHeight) / 14.0f) * 3.0f, (float) this.mRadius, this.mEdgePaint);
        canvas.drawCircle(this.mSatLeftOffset, (((float) this.mHeight) / 14.0f) * 11.0f, (float) this.mRadius, this.mCirclePaint);
        canvas.drawCircle(this.mSatLeftOffset, (((float) this.mHeight) / 14.0f) * 11.0f, (float) this.mRadius, this.mEdgePaint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.mHueRect.bottom > y) {
                this.target = -1;
            } else if (this.mSatRect.top < y) {
                this.target = 1;
            }
            if (this.mHueRect.left < x && this.mHueRect.right > x && this.target == -1) {
                int fixOffset = fixOffset(x);
                this.mHueLeftOffset = (float) fixOffset;
                float[] fArr = this.mHue;
                fArr[0] = ((((float) (fixOffset - this.mRadius)) * 360.0f) / ((float) this.mPaletteWidth)) * 1.0f;
                this.mHSV[0] = fArr[0];
                this.mSatColors[1] = Color.HSVToColor(fArr);
                this.mSatPalette = createSatPalette();
            } else if (this.mSatRect.left < x && this.mSatRect.right > x && this.target == 1) {
                int fixOffset2 = fixOffset(x);
                this.mSatLeftOffset = (float) fixOffset2;
                float[] fArr2 = this.mHSV;
                fArr2[0] = this.mHue[0];
                fArr2[2] = (((((float) (fixOffset2 - this.mRadius)) * 10.0f) / ((float) this.mPaletteWidth)) * 1.0f) / 10.0f;
            }
            OnColorChooseListener onColorChooseListener = this.mListener;
            if (onColorChooseListener != null) {
                onColorChooseListener.onColorChoose(Color.HSVToColor(this.mHSV));
            }
            invalidate();
        }
        return true;
    }

    public void setColor(int i) {
        Color.colorToHSV(i, this.mHSV);
        float[] fArr = this.mHue;
        float[] fArr2 = this.mHSV;
        fArr[0] = fArr2[0];
        fArr2[1] = 1.0f;
        this.mSatColors[1] = Color.HSVToColor(fArr);
        invalidate();
    }

    private Drawable createHuePalette() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, PALETTE_COLORS);
        gradientDrawable.setBounds(this.mHueRect);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    private GradientDrawable createSatPalette() {
        GradientDrawable gradientDrawable = this.mSatPalette;
        if (gradientDrawable == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.mSatColors);
            this.mSatPalette = gradientDrawable2;
            gradientDrawable2.setBounds(this.mSatRect);
            this.mSatPalette.setCornerRadius(30.0f);
        } else {
            gradientDrawable.setColors(this.mSatColors);
        }
        return this.mSatPalette;
    }

    private int fixOffset(int i) {
        if (i < this.mHueRect.left) {
            return this.mRadius;
        }
        return i > this.mHueRect.right ? this.mHueRect.right : i;
    }

    public void setOnColorChooseListener(OnColorChooseListener onColorChooseListener) {
        this.mListener = onColorChooseListener;
    }
}
