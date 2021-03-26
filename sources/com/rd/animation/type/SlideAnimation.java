package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SlideAnimationValue;

public class SlideAnimation extends BaseAnimation<ValueAnimator> {
    private static final String ANIMATION_COORDINATE = "ANIMATION_COORDINATE";
    private static final int COORDINATE_NONE = -1;
    private int coordinateEnd = -1;
    private int coordinateStart = -1;
    private SlideAnimationValue value = new SlideAnimationValue();

    public SlideAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.BaseAnimation
    public ValueAnimator createAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.rd.animation.type.SlideAnimation.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SlideAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public SlideAnimation progress(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.animationDuration));
            if (((ValueAnimator) this.animator).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(j);
            }
        }
        return this;
    }

    public SlideAnimation with(int i, int i2) {
        if (this.animator != null && hasChanges(i, i2)) {
            this.coordinateStart = i;
            this.coordinateEnd = i2;
            ((ValueAnimator) this.animator).setValues(createSlidePropertyHolder());
        }
        return this;
    }

    private PropertyValuesHolder createSlidePropertyHolder() {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", this.coordinateStart, this.coordinateEnd);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(ValueAnimator valueAnimator) {
        this.value.setCoordinate(((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue());
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }

    private boolean hasChanges(int i, int i2) {
        if (this.coordinateStart == i && this.coordinateEnd == i2) {
            return false;
        }
        return true;
    }
}
