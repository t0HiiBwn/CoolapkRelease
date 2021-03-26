package com.coolapk.market.widget.emotion;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class ImageSpanAlignCenter extends ImageSpan {
    private int mSize;
    private int mTextSize;
    private int mTransY;

    public ImageSpanAlignCenter(Drawable drawable, String str) {
        super(drawable, str, 0);
    }

    public ImageSpanAlignCenter(Drawable drawable, String str, int i) {
        super(drawable, str, 0);
        this.mTransY = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        this.mTextSize = fontMetricsInt2.descent - fontMetricsInt2.ascent;
        this.mSize = fontMetricsInt2.bottom - fontMetricsInt2.top;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return getDrawable().getBounds().right;
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        int i;
        Drawable drawable = super.getDrawable();
        if (drawable != null && (i = this.mTextSize) > 0 && this.mSize > 0) {
            int intrinsicWidth = (drawable.getIntrinsicWidth() * i) / drawable.getIntrinsicHeight();
            int i2 = (this.mSize - i) / 2;
            drawable.setBounds(0, i2, intrinsicWidth, i + i2);
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.save();
        canvas.translate(f, (float) ((((((fontMetricsInt.top + i4) + i4) + fontMetricsInt.bottom) / 2) - drawable.getBounds().centerY()) + this.mTransY));
        drawable.draw(canvas);
        canvas.restore();
    }
}
