package com.coolapk.market.view.app;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public abstract class ScrimAnimator {
    private static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    private static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    private Float scrimAlpha;
    private ValueAnimator scrimAnimator;
    private Boolean scrimsAreShown;

    protected abstract void onScrimAlphaChanged(float f);

    public void setScrimShown(boolean z, boolean z2) {
        Boolean bool = this.scrimsAreShown;
        if (bool == null || bool.booleanValue() != z) {
            float f = 1.0f;
            if (z2) {
                if (!z) {
                    f = 0.0f;
                }
                animateScrim(f);
            } else {
                if (!z) {
                    f = 0.0f;
                }
                setScrimAlpha(f);
            }
            this.scrimsAreShown = Boolean.valueOf(z);
        }
    }

    private void animateScrim(float f) {
        ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.scrimAnimator = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.coolapk.market.view.app.ScrimAnimator.AnonymousClass1 */

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ScrimAnimator.this.setScrimAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.scrimAnimator.cancel();
        }
        this.scrimAnimator.setInterpolator(f > this.scrimAlpha.floatValue() ? FAST_OUT_LINEAR_IN_INTERPOLATOR : LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.scrimAnimator.setFloatValues(this.scrimAlpha.floatValue(), f);
        this.scrimAnimator.start();
    }

    /* access modifiers changed from: private */
    public void setScrimAlpha(float f) {
        Float f2 = this.scrimAlpha;
        if (f2 == null || f != f2.floatValue()) {
            this.scrimAlpha = Float.valueOf(f);
            onScrimAlphaChanged(f);
        }
    }
}
