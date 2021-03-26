package com.rd.animation.type;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.animation.type.WormAnimation;

public class ThinWormAnimation extends WormAnimation {
    private ThinWormAnimationValue value = new ThinWormAnimationValue();

    public ThinWormAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.WormAnimation, com.rd.animation.type.BaseAnimation
    public ThinWormAnimation duration(long j) {
        super.duration(j);
        return this;
    }

    @Override // com.rd.animation.type.WormAnimation
    public WormAnimation with(int i, int i2, int i3, boolean z) {
        if (hasChanges(i, i2, i3, z)) {
            this.animator = createAnimator();
            this.coordinateStart = i;
            this.coordinateEnd = i2;
            this.radius = i3;
            this.isRightSide = z;
            int i4 = i3 * 2;
            this.rectLeftEdge = i - i3;
            this.rectRightEdge = i + i3;
            this.value.setRectStart(this.rectLeftEdge);
            this.value.setRectEnd(this.rectRightEdge);
            this.value.setHeight(i4);
            WormAnimation.RectValues createRectValues = createRectValues(z);
            long j = (long) (((double) this.animationDuration) * 0.8d);
            long j2 = (long) (((double) this.animationDuration) * 0.2d);
            long j3 = (long) (((double) this.animationDuration) * 0.5d);
            long j4 = (long) (((double) this.animationDuration) * 0.5d);
            ValueAnimator createWormAnimator = createWormAnimator(createRectValues.fromX, createRectValues.toX, j, false, this.value);
            ValueAnimator createWormAnimator2 = createWormAnimator(createRectValues.reverseFromX, createRectValues.reverseToX, j, true, this.value);
            createWormAnimator2.setStartDelay(j2);
            ValueAnimator createHeightAnimator = createHeightAnimator(i4, i3, j3);
            ValueAnimator createHeightAnimator2 = createHeightAnimator(i3, i4, j3);
            createHeightAnimator2.setStartDelay(j4);
            ((AnimatorSet) this.animator).playTogether(createWormAnimator, createWormAnimator2, createHeightAnimator, createHeightAnimator2);
        }
        return this;
    }

    private ValueAnimator createHeightAnimator(int i, int i2, long j) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.rd.animation.type.ThinWormAnimation.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ThinWormAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(ValueAnimator valueAnimator) {
        this.value.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }

    @Override // com.rd.animation.type.WormAnimation, com.rd.animation.type.BaseAnimation
    public ThinWormAnimation progress(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.animationDuration));
            int size = ((AnimatorSet) this.animator).getChildAnimations().size();
            for (int i = 0; i < size; i++) {
                ValueAnimator valueAnimator = (ValueAnimator) ((AnimatorSet) this.animator).getChildAnimations().get(i);
                long startDelay = j - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (startDelay > duration) {
                    startDelay = duration;
                } else if (startDelay < 0) {
                    startDelay = 0;
                }
                if ((i != size - 1 || startDelay > 0) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(startDelay);
                }
            }
        }
        return this;
    }
}
