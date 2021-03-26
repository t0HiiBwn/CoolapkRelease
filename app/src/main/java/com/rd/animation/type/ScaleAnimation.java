package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ScaleAnimationValue;

public class ScaleAnimation extends ColorAnimation {
    static final String ANIMATION_SCALE = "ANIMATION_SCALE";
    static final String ANIMATION_SCALE_REVERSE = "ANIMATION_SCALE_REVERSE";
    public static final float DEFAULT_SCALE_FACTOR = 0.7f;
    public static final float MAX_SCALE_FACTOR = 1.0f;
    public static final float MIN_SCALE_FACTOR = 0.3f;
    int radius;
    float scaleFactor;
    private ScaleAnimationValue value = new ScaleAnimationValue();

    public ScaleAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.ColorAnimation, com.rd.animation.type.BaseAnimation
    public ValueAnimator createAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.rd.animation.type.ScaleAnimation.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScaleAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }

    public ScaleAnimation with(int i, int i2, int i3, float f) {
        if (this.animator != null && hasChanges(i, i2, i3, f)) {
            this.colorStart = i;
            this.colorEnd = i2;
            this.radius = i3;
            this.scaleFactor = f;
            ((ValueAnimator) this.animator).setValues(createColorPropertyHolder(false), createColorPropertyHolder(true), createScalePropertyHolder(false), createScalePropertyHolder(true));
        }
        return this;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE")).intValue();
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        this.value.setRadius(intValue3);
        this.value.setRadiusReverse(intValue4);
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }

    protected PropertyValuesHolder createScalePropertyHolder(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.radius;
            i2 = (int) (((float) i) * this.scaleFactor);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i2 = this.radius;
            i = (int) (((float) i2) * this.scaleFactor);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean hasChanges(int i, int i2, int i3, float f) {
        if (this.colorStart == i && this.colorEnd == i2 && this.radius == i3 && this.scaleFactor == f) {
            return false;
        }
        return true;
    }
}
