package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.coolapk.market.R;

public class ScrimInsetsFrameLayout extends FrameLayout {
    private Drawable mInsetForeground;
    private Rect mInsets;
    private OnInsetsCallback mOnInsetsCallback;
    private Rect mTempRect = new Rect();

    public interface OnInsetsCallback {
        void onInsetsChanged(Rect rect);
    }

    public ScrimInsetsFrameLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrimInsetsFrameLayout, i, 0);
        if (obtainStyledAttributes != null) {
            this.mInsetForeground = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            setWillNotDraw(true);
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        this.mInsets = new Rect(rect);
        setWillNotDraw(this.mInsetForeground == null);
        ViewCompat.postInvalidateOnAnimation(this);
        OnInsetsCallback onInsetsCallback = this.mOnInsetsCallback;
        if (onInsetsCallback != null) {
            onInsetsCallback.onInsetsChanged(rect);
        }
        return true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mInsets != null && this.mInsetForeground != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.mTempRect.set(0, 0, width, this.mInsets.top);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            this.mTempRect.set(0, height - this.mInsets.bottom, width, height);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            this.mTempRect.set(0, this.mInsets.top, this.mInsets.left, height - this.mInsets.bottom);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            this.mTempRect.set(width - this.mInsets.right, this.mInsets.top, width, height - this.mInsets.bottom);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.mInsetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.mInsetForeground;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setInsetForeground(Drawable drawable) {
        Drawable drawable2 = this.mInsetForeground;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            this.mInsetForeground = drawable;
            drawable.setCallback(this);
            invalidate();
        }
    }

    public void setOnInsetsCallback(OnInsetsCallback onInsetsCallback) {
        this.mOnInsetsCallback = onInsetsCallback;
    }
}
