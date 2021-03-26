package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class CoolPicView extends AppCompatImageView {
    private boolean hasDrawable;
    private boolean imgLargeHeight;
    private boolean imgLargeWidth;
    private boolean isInit;
    private Matrix mAnimaMatrix = new Matrix();
    private Matrix mBaseMatrix = new Matrix();
    private RectF mBaseRect = new RectF();
    private float mHalfBaseRectHeight;
    private float mHalfBaseRectWidth;
    private RectF mImgRect = new RectF();
    private float mScale = 1.0f;
    private ImageView.ScaleType mScaleType;
    private PointF mScreenCenter = new PointF();
    private Matrix mSynthesisMatrix = new Matrix();
    private int mTranslateX;
    private int mTranslateY;
    private RectF mWidgetRect = new RectF();

    public CoolPicView(Context context) {
        super(context);
    }

    public CoolPicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoolPicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
        }
        if (this.isInit) {
            initBase();
        }
    }

    private void initFitCenter() {
        if (this.mImgRect.width() < this.mWidgetRect.width()) {
            float width = this.mWidgetRect.width() / this.mImgRect.width();
            this.mScale = width;
            this.mAnimaMatrix.postScale(width, width, this.mScreenCenter.x, this.mScreenCenter.y);
            executeTranslate();
            resetBase();
        }
    }

    private void initFitStart() {
        initFitCenter();
        float f = -this.mImgRect.top;
        this.mAnimaMatrix.postTranslate(0.0f, f);
        executeTranslate();
        resetBase();
        this.mTranslateY = (int) (((float) this.mTranslateY) + f);
    }

    private void resetBase() {
        Drawable drawable = getDrawable();
        this.mBaseRect.set(0.0f, 0.0f, (float) getDrawableWidth(drawable), (float) getDrawableHeight(drawable));
        this.mBaseMatrix.set(this.mSynthesisMatrix);
        this.mBaseMatrix.mapRect(this.mBaseRect);
        this.mHalfBaseRectWidth = this.mBaseRect.width() / 2.0f;
        this.mHalfBaseRectHeight = this.mBaseRect.height() / 2.0f;
        this.mScale = 1.0f;
        this.mTranslateX = 0;
        this.mTranslateY = 0;
        this.mAnimaMatrix.reset();
    }

    private void executeTranslate() {
        this.mSynthesisMatrix.set(this.mBaseMatrix);
        this.mSynthesisMatrix.postConcat(this.mAnimaMatrix);
        setImageMatrix(this.mSynthesisMatrix);
        this.mAnimaMatrix.mapRect(this.mImgRect, this.mBaseRect);
        boolean z = true;
        this.imgLargeWidth = this.mImgRect.width() > this.mWidgetRect.width();
        if (this.mImgRect.height() <= this.mWidgetRect.height()) {
            z = false;
        }
        this.imgLargeHeight = z;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        Drawable drawable;
        try {
            drawable = getResources().getDrawable(i);
        } catch (Exception unused) {
            drawable = null;
        }
        setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable == null) {
            this.hasDrawable = false;
        } else if (hasSize(drawable)) {
            if (!this.hasDrawable) {
                this.hasDrawable = true;
            }
            initBase();
        }
    }

    private boolean hasSize(Drawable drawable) {
        return (drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) || (drawable.getMinimumWidth() > 0 && drawable.getMinimumHeight() > 0) || (drawable.getBounds().width() > 0 && drawable.getBounds().height() > 0);
    }

    private void initBase() {
        if (this.hasDrawable) {
            this.mBaseMatrix.reset();
            this.mAnimaMatrix.reset();
            Drawable drawable = getDrawable();
            int width = getWidth();
            int height = getHeight();
            int drawableWidth = getDrawableWidth(drawable);
            int drawableHeight = getDrawableHeight(drawable);
            float f = (float) drawableWidth;
            float f2 = (float) drawableHeight;
            this.mBaseRect.set(0.0f, 0.0f, f, f2);
            int i = (width - drawableWidth) / 2;
            int i2 = (height - drawableHeight) / 2;
            float f3 = 1.0f;
            float f4 = drawableWidth > width ? ((float) width) / f : 1.0f;
            if (drawableHeight > height) {
                f3 = ((float) height) / f2;
            }
            if (f4 >= f3) {
                f4 = f3;
            }
            this.mBaseMatrix.reset();
            this.mBaseMatrix.postTranslate((float) i, (float) i2);
            this.mBaseMatrix.postScale(f4, f4, this.mScreenCenter.x, this.mScreenCenter.y);
            this.mBaseMatrix.mapRect(this.mBaseRect);
            this.mHalfBaseRectWidth = this.mBaseRect.width() / 2.0f;
            this.mHalfBaseRectHeight = this.mBaseRect.height() / 2.0f;
            executeTranslate();
            int i3 = AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i3 == 1) {
                initFitCenter();
            } else if (i3 != 2) {
                super.setScaleType(this.mScaleType);
            } else {
                initFitStart();
            }
            this.isInit = true;
        }
    }

    /* renamed from: com.coolapk.market.widget.CoolPicView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static int getDrawableWidth(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = drawable.getMinimumWidth();
        }
        return intrinsicWidth <= 0 ? drawable.getBounds().width() : intrinsicWidth;
    }

    private static int getDrawableHeight(Drawable drawable) {
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = drawable.getMinimumHeight();
        }
        return intrinsicHeight <= 0 ? drawable.getBounds().height() : intrinsicHeight;
    }
}
