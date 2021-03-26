package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.FillAnimationValue;

public class FillAnimation extends ColorAnimation {
    private static final String ANIMATION_RADIUS = "ANIMATION_RADIUS";
    private static final String ANIMATION_RADIUS_REVERSE = "ANIMATION_RADIUS_REVERSE";
    private static final String ANIMATION_STROKE = "ANIMATION_STROKE";
    private static final String ANIMATION_STROKE_REVERSE = "ANIMATION_STROKE_REVERSE";
    public static final int DEFAULT_STROKE_DP = 1;
    private int radius;
    private int stroke;
    private FillAnimationValue value = new FillAnimationValue();

    public FillAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.ColorAnimation, com.rd.animation.type.BaseAnimation
    public ValueAnimator createAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.rd.animation.type.FillAnimation.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FillAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }

    public FillAnimation with(int i, int i2, int i3, int i4) {
        if (this.animator != null && hasChanges(i, i2, i3, i4)) {
            this.colorStart = i;
            this.colorEnd = i2;
            this.radius = i3;
            this.stroke = i4;
            ((ValueAnimator) this.animator).setValues(createColorPropertyHolder(false), createColorPropertyHolder(true), createRadiusPropertyHolder(false), createRadiusPropertyHolder(true), createStrokePropertyHolder(false), createStrokePropertyHolder(true));
        }
        return this;
    }

    private PropertyValuesHolder createRadiusPropertyHolder(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.radius;
            i2 = i / 2;
            str = "ANIMATION_RADIUS_REVERSE";
        } else {
            i2 = this.radius;
            i = i2 / 2;
            str = "ANIMATION_RADIUS";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private PropertyValuesHolder createStrokePropertyHolder(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.radius;
            str = "ANIMATION_STROKE_REVERSE";
            i2 = 0;
        } else {
            str = "ANIMATION_STROKE";
            i2 = this.radius;
            i = 0;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS_REVERSE")).intValue();
        int intValue5 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE")).intValue();
        int intValue6 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE_REVERSE")).intValue();
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        this.value.setRadius(intValue3);
        this.value.setRadiusReverse(intValue4);
        this.value.setStroke(intValue5);
        this.value.setStrokeReverse(intValue6);
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }

    private boolean hasChanges(int i, int i2, int i3, int i4) {
        if (this.colorStart == i && this.colorEnd == i2 && this.radius == i3 && this.stroke == i4) {
            return false;
        }
        return true;
    }
}
