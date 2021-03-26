package com.coolapk.market.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;

public abstract class RevealFrameLayout extends FrameLayout {
    private float mHotSpotX;
    private float mHotSpotY;
    private View mRevealView;

    @Override // android.view.View
    public abstract ViewOutlineProvider getOutlineProvider();

    public RevealFrameLayout(Context context) {
        this(context, null, 0, 0);
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        SpaceView spaceView = new SpaceView(context);
        this.mRevealView = spaceView;
        spaceView.setMinimumHeight(getMinimumHeight());
        this.mRevealView.setMinimumWidth(getMinimumWidth());
        this.mRevealView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mRevealView, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.mHotSpotX = motionEvent.getX();
            this.mHotSpotY = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setOutlineProvider(getOutlineProvider());
        setClipToOutline(true);
    }

    public void setBackground(int i, int i2, boolean z, Animator.AnimatorListener animatorListener) {
        setBackground(ResourcesCompat.getDrawable(getResources(), i, getContext().getTheme()), ResourcesCompat.getDrawable(getResources(), i2, getContext().getTheme()), z, animatorListener);
    }

    public void setBackground(final Drawable drawable, final Drawable drawable2, boolean z, final Animator.AnimatorListener animatorListener) {
        if (!z || !isAttachedToWindow()) {
            this.mRevealView.setVisibility(8);
            setBackground(drawable2);
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.mRevealView, (int) this.mHotSpotX, (int) this.mHotSpotY, 0.0f, (float) (getWidth() / 2));
        createCircularReveal.addListener(new AnimatorListenerAdapter() {
            /* class com.coolapk.market.widget.RevealFrameLayout.AnonymousClass1 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RevealFrameLayout.this.setBackground(drawable, drawable2, false, (Animator.AnimatorListener) null);
                Animator.AnimatorListener animatorListener = animatorListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }
        });
        createCircularReveal.start();
        this.mRevealView.setVisibility(0);
        this.mRevealView.setBackground(drawable);
    }
}
