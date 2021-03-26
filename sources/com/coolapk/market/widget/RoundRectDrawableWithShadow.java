package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

public class RoundRectDrawableWithShadow extends Drawable {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners = true;
    final RectF mCardBounds;
    float mCornerRadius;
    Paint mCornerShadowPaint;
    Path mCornerShadowPath;
    private boolean mDirty = true;
    Paint mEdgeShadowPaint;
    final int mInsetShadow;
    float mMaxShadowSize;
    Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    float mRawMaxShadowSize;
    float mRawShadowSize;
    private final int mShadowEndColor = Color.parseColor("#00000000");
    float mShadowSize;
    private final int mShadowStartColor = Color.parseColor("#24000000");

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public RoundRectDrawableWithShadow(Context context, int i, float f, float f2, float f3) {
        this.mInsetShadow = (int) (TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics()) + 0.5f);
        Paint paint = new Paint(5);
        this.mPaint = paint;
        paint.setColor(i);
        Paint paint2 = new Paint(5);
        this.mCornerShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (float) ((int) (f + 0.5f));
        this.mCardBounds = new RectF();
        Paint paint3 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint3;
        paint3.setAntiAlias(false);
        setShadowSize(f2, f3);
        sRoundRectHelper = new RoundRectHelper() {
            /* class com.coolapk.market.widget.RoundRectDrawableWithShadow.AnonymousClass1 */

            @Override // com.coolapk.market.widget.RoundRectDrawableWithShadow.RoundRectHelper
            public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }

    private int toEven(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.mAddPaddingForCorners = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        this.mCornerShadowPaint.setAlpha(i);
        this.mEdgeShadowPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    void setShadowSize(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = (float) toEven(f);
        float even2 = (float) toEven(f2);
        if (even > even2) {
            if (!this.mPrintedShadowClipWarning) {
                this.mPrintedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.mRawShadowSize != even || this.mRawMaxShadowSize != even2) {
            this.mRawShadowSize = even;
            this.mRawMaxShadowSize = even2;
            int i = this.mInsetShadow;
            this.mShadowSize = (float) ((int) ((even * 1.5f) + ((float) i) + 0.5f));
            this.mMaxShadowSize = even2 + ((float) i);
            this.mDirty = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        rect.set(0, (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners)), 0, 0);
        return true;
    }

    static float calculateVerticalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - COS_45) * ((double) f2))) : f * 1.5f;
    }

    static float calculateHorizontalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - COS_45) * ((double) f2))) : f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        this.mCornerShadowPaint.setColorFilter(colorFilter);
        this.mEdgeShadowPaint.setColorFilter(colorFilter);
    }

    void setCornerRadius(float f) {
        float f2 = (float) ((int) (f + 0.5f));
        if (this.mCornerRadius != f2) {
            this.mCornerRadius = f2;
            this.mDirty = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    private void drawShadow(Canvas canvas) {
        float f = this.mCornerRadius;
        float f2 = (-f) - this.mShadowSize;
        int i = this.mInsetShadow;
        float f3 = f + ((float) i) + (this.mRawShadowSize / 2.0f);
        float f4 = (float) (-i);
        int save = canvas.save();
        canvas.translate(this.mCardBounds.left + f4, this.mCardBounds.top + f3);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        canvas.drawRect(0.0f, f2, this.mCardBounds.width() - (2.0f * f4), (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.mCardBounds.right - f4, this.mCardBounds.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        canvas.restoreToCount(save2);
    }

    private void buildShadowCorners() {
        float f = this.mCornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.mShadowSize;
        rectF2.inset(-f2, -f2);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f3 = this.mCornerRadius;
        float f4 = f3 / (this.mShadowSize + f3);
        Paint paint = this.mCornerShadowPaint;
        float f5 = this.mCornerRadius + this.mShadowSize;
        int i = this.mShadowStartColor;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.mShadowEndColor}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.mEdgeShadowPaint;
        float f6 = this.mCornerRadius;
        float f7 = this.mShadowSize;
        int i2 = this.mShadowStartColor;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize * 1.5f;
        this.mCardBounds.set(((float) rect.left) + this.mRawMaxShadowSize, ((float) rect.top) + f, ((float) rect.right) - this.mRawMaxShadowSize, ((float) rect.bottom) - f);
        buildShadowCorners();
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    void setShadowSize(float f) {
        setShadowSize(f, this.mRawMaxShadowSize);
    }

    void setMaxShadowSize(float f) {
        setShadowSize(this.mRawShadowSize, f);
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinWidth() {
        float f = this.mRawMaxShadowSize;
        return (Math.max(f, this.mCornerRadius + ((float) this.mInsetShadow) + (f / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + ((float) this.mInsetShadow)) * 2.0f);
    }

    float getMinHeight() {
        float f = this.mRawMaxShadowSize;
        return (Math.max(f, this.mCornerRadius + ((float) this.mInsetShadow) + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * 1.5f) + ((float) this.mInsetShadow)) * 2.0f);
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
        invalidateSelf();
    }
}
