package com.coolapk.market.animation.Interpolator;

import android.animation.TimeInterpolator;

public class EasingInterpolator implements TimeInterpolator {
    private final Ease ease;

    public EasingInterpolator(Ease ease2) {
        this.ease = ease2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return EasingProvider.get(this.ease, f);
    }

    public Ease getEase() {
        return this.ease;
    }
}
