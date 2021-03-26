package com.coolapk.market.widget.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent;
import com.coolapk.market.util.UiUtils;

public class SlideUpView extends LinearLayout implements NestedScrollingParent {
    private ValueAnimator mAnimator;
    private Callback mCallback;
    private boolean mHandleFling;
    private float mInitTranslationY;
    private boolean mOneDirection;
    private int mScrollDirection;

    public interface Callback {
        void onDismiss();

        void onShow();

        void onTranslateYChange(int i);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public SlideUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setInitTranslationY(float f) {
        this.mInitTranslationY = f;
        setVisibility(4);
        postOnAnimation(new Runnable() {
            /* class com.coolapk.market.widget.view.$$Lambda$SlideUpView$D5Pezw82f2mhNAz_QUmzsMRM028 */

            @Override // java.lang.Runnable
            public final void run() {
                SlideUpView.this.lambda$setInitTranslationY$1$SlideUpView();
            }
        });
    }

    public /* synthetic */ void lambda$setInitTranslationY$1$SlideUpView() {
        setVisibility(0);
        animatorTranslateY((float) getHeight(), this.mInitTranslationY, new Runnable() {
            /* class com.coolapk.market.widget.view.$$Lambda$SlideUpView$l5bMc1DLixccxvoY3P6Zr9e2jbQ */

            @Override // java.lang.Runnable
            public final void run() {
                SlideUpView.this.lambda$null$0$SlideUpView();
            }
        });
    }

    public /* synthetic */ void lambda$null$0$SlideUpView() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onShow();
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private void animatorTranslateY(float f, float f2, final Runnable runnable) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, TRANSLATION_Y, f, f2);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(200L);
        this.mAnimator.addListener(new AnimatorListenerAdapter() {
            /* class com.coolapk.market.widget.view.SlideUpView.AnonymousClass1 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        this.mAnimator.start();
    }

    public void upSlideView() {
        animatorTranslateY(getTranslationY(), (float) (UiUtils.getStatusBarHeight(getContext()) - getTop()), null);
    }

    public void dismissView() {
        animatorTranslateY(getTranslationY(), (float) getHeight(), new Runnable() {
            /* class com.coolapk.market.widget.view.$$Lambda$SlideUpView$rJL6tp7yj2lpASnjIzj6TKCWElI */

            @Override // java.lang.Runnable
            public final void run() {
                SlideUpView.this.lambda$dismissView$2$SlideUpView();
            }
        });
    }

    public /* synthetic */ void lambda$dismissView$2$SlideUpView() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDismiss();
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return isEnabled() && (i & 2) > 0;
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
        this.mHandleFling = false;
        this.mScrollDirection = 0;
        this.mOneDirection = true;
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (!this.mHandleFling) {
            onScrollFinish();
        }
        super.onStopNestedScroll(view);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            if (getHeight() - ((int) getTranslationY()) >= i4) {
                moveView(-i4);
                if (this.mScrollDirection == 0) {
                    this.mScrollDirection = 1;
                }
                if (this.mScrollDirection != 1) {
                    this.mOneDirection = false;
                }
            }
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int translationY = (int) getTranslationY();
        if (translationY <= 0) {
            return;
        }
        if (i2 > 0) {
            if (translationY >= i2) {
                iArr[1] = i2;
            } else {
                iArr[1] = translationY;
            }
            moveView(-iArr[1]);
            if (this.mScrollDirection == 0) {
                this.mScrollDirection = -1;
            }
            if (this.mScrollDirection != -1) {
                this.mOneDirection = false;
                return;
            }
            return;
        }
        int height = getHeight() - translationY;
        if (height >= i2) {
            iArr[1] = i2;
        } else {
            iArr[1] = height;
        }
        moveView(-iArr[1]);
        if (this.mScrollDirection == 0) {
            this.mScrollDirection = 1;
        }
        if (this.mScrollDirection != 1) {
            this.mOneDirection = false;
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int translationY = (int) getTranslationY();
        if (translationY == 0 || ((float) translationY) == this.mInitTranslationY) {
            return false;
        }
        onScrollFinish();
        this.mHandleFling = true;
        return true;
    }

    private void onScrollFinish() {
        int translationY = (int) getTranslationY();
        boolean z = this.mOneDirection;
        if (z && this.mScrollDirection == 1) {
            float f = (float) translationY;
            if (f > this.mInitTranslationY * 1.2f) {
                if (this.mCallback != null) {
                    animatorTranslateY(f, (float) getHeight(), new Runnable() {
                        /* class com.coolapk.market.widget.view.$$Lambda$SlideUpView$_ejLtKHcNptTs2xZe_b0s_gl6l4 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            SlideUpView.this.lambda$onScrollFinish$3$SlideUpView();
                        }
                    });
                    return;
                }
                return;
            }
        }
        float f2 = (float) translationY;
        float f3 = this.mInitTranslationY;
        if (f2 > f3 || (z && this.mScrollDirection == 1)) {
            animatorTranslateY(f2, f3, null);
        } else if (translationY > 0 && f2 != f3) {
            animatorTranslateY(f2, 0.0f, null);
        }
    }

    public /* synthetic */ void lambda$onScrollFinish$3$SlideUpView() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDismiss();
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    private void moveView(int i) {
        setTranslationY(getTranslationY() + ((float) i));
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTranslateYChange((int) f);
        }
    }
}
