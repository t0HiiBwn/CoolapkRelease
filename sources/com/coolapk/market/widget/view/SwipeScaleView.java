package com.coolapk.market.widget.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.coolapk.market.util.DisplayUtils;

public class SwipeScaleView extends RelativeLayout {
    private float mDisplacementX;
    private float mDisplacementY;
    private boolean mIgnoreFollowingEvent;
    private boolean mIgnoreTrack;
    private float mInitialTx;
    private float mInitialTy;
    private int mScreenHeight = DisplayUtils.getHeightPixels(getContext());
    private boolean mTracking;
    private OnCanSwipeListener onCanSwipeListener;
    private OnSwipeListener onSwipeListener;

    public interface OnCanSwipeListener {
        boolean canSwipe();

        boolean isIgnoreTrack();
    }

    public interface OnSwipeListener {
        void downSwipe();

        void onSwiping(float f);

        void overSwipe();
    }

    public SwipeScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r0 != 3) goto L_0x004e;
     */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float rawX = motionEvent.getRawX() - this.mDisplacementX;
                    float rawY = motionEvent.getRawY() - this.mDisplacementY;
                    if (this.mTracking) {
                        setViewState(rawX, rawY);
                    }
                }
            }
            this.mIgnoreFollowingEvent = false;
            if (this.mTracking) {
                this.mTracking = false;
                if (getTranslationY() > ((float) (this.mScreenHeight / 6))) {
                    this.onSwipeListener.downSwipe();
                }
            }
            animatorToDefault();
            this.onSwipeListener.overSwipe();
        } else {
            recordInitState(motionEvent);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r0 == false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r0 != 3) goto L_0x007e;
     */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    OnCanSwipeListener onCanSwipeListener2 = this.onCanSwipeListener;
                    if (onCanSwipeListener2 != null) {
                        boolean canSwipe = onCanSwipeListener2.canSwipe();
                        this.mIgnoreTrack = this.onCanSwipeListener.isIgnoreTrack();
                    }
                    if (!this.mIgnoreFollowingEvent) {
                        float rawX = motionEvent.getRawX() - this.mDisplacementX;
                        float rawY = motionEvent.getRawY() - this.mDisplacementY;
                        if (rawY < 0.0f && !this.mTracking && !this.mIgnoreTrack) {
                            this.mIgnoreFollowingEvent = true;
                        } else if (rawY > 0.0f && Math.abs(rawY) > ((float) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2)) && Math.abs(rawX) < Math.abs(rawY) / 2.0f) {
                            recordInitState(motionEvent);
                            this.mTracking = true;
                            return true;
                        }
                    }
                }
            }
            this.mIgnoreFollowingEvent = false;
        } else {
            recordInitState(motionEvent);
        }
        return false;
    }

    private void recordInitState(MotionEvent motionEvent) {
        this.mDisplacementX = motionEvent.getRawX();
        this.mDisplacementY = motionEvent.getRawY();
        this.mInitialTy = getTranslationY();
        this.mInitialTx = getTranslationX();
    }

    private void setViewState(float f, float f2) {
        this.onSwipeListener.onSwiping(f2);
        if (f2 < 0.0f) {
            setViewDefault();
        } else {
            float f3 = 1.0f - (f2 / ((float) this.mScreenHeight));
            if (((double) f3) < 0.3d) {
                f3 = 0.3f;
            }
            setScaleX(f3);
            setScaleY(f3);
        }
        setTranslationY(this.mInitialTy + f2);
        setTranslationX(this.mInitialTx + f);
    }

    private void animatorToDefault() {
        animate().alpha(1.0f).translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
            /* class com.coolapk.market.widget.view.SwipeScaleView.AnonymousClass1 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SwipeScaleView.this.setViewDefault();
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void setViewDefault() {
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener2) {
        this.onSwipeListener = onSwipeListener2;
    }

    public void setOnGestureListener(OnCanSwipeListener onCanSwipeListener2) {
        this.onCanSwipeListener = onCanSwipeListener2;
    }
}
