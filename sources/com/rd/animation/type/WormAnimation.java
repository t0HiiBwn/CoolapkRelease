package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.WormAnimationValue;
import java.util.Iterator;

public class WormAnimation extends BaseAnimation<AnimatorSet> {
    int coordinateEnd;
    int coordinateStart;
    boolean isRightSide;
    int radius;
    int rectLeftEdge;
    int rectRightEdge;
    private WormAnimationValue value = new WormAnimationValue();

    public WormAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.BaseAnimation
    public AnimatorSet createAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public WormAnimation duration(long j) {
        super.duration(j);
        return this;
    }

    public WormAnimation with(int i, int i2, int i3, boolean z) {
        if (hasChanges(i, i2, i3, z)) {
            this.animator = createAnimator();
            this.coordinateStart = i;
            this.coordinateEnd = i2;
            this.radius = i3;
            this.isRightSide = z;
            int i4 = i - i3;
            this.rectLeftEdge = i4;
            this.rectRightEdge = i + i3;
            this.value.setRectStart(i4);
            this.value.setRectEnd(this.rectRightEdge);
            RectValues createRectValues = createRectValues(z);
            long j = this.animationDuration / 2;
            ((AnimatorSet) this.animator).playSequentially(createWormAnimator(createRectValues.fromX, createRectValues.toX, j, false, this.value), createWormAnimator(createRectValues.reverseFromX, createRectValues.reverseToX, j, true, this.value));
        }
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public WormAnimation progress(float f) {
        if (this.animator == null) {
            return this;
        }
        long j = (long) (f * ((float) this.animationDuration));
        Iterator<Animator> it2 = ((AnimatorSet) this.animator).getChildAnimations().iterator();
        while (it2.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) it2.next();
            long duration = valueAnimator.getDuration();
            if (j <= duration) {
                duration = j;
            }
            valueAnimator.setCurrentPlayTime(duration);
            j -= duration;
        }
        return this;
    }

    ValueAnimator createWormAnimator(int i, int i2, long j, final boolean z, final WormAnimationValue wormAnimationValue) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.rd.animation.type.WormAnimation.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WormAnimation.this.onAnimateUpdated(wormAnimationValue, valueAnimator, z);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(WormAnimationValue wormAnimationValue, ValueAnimator valueAnimator, boolean z) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.isRightSide) {
            if (!z) {
                wormAnimationValue.setRectEnd(intValue);
            } else {
                wormAnimationValue.setRectStart(intValue);
            }
        } else if (!z) {
            wormAnimationValue.setRectStart(intValue);
        } else {
            wormAnimationValue.setRectEnd(intValue);
        }
        if (this.listener != null) {
            this.listener.onValueUpdated(wormAnimationValue);
        }
    }

    boolean hasChanges(int i, int i2, int i3, boolean z) {
        if (this.coordinateStart == i && this.coordinateEnd == i2 && this.radius == i3 && this.isRightSide == z) {
            return false;
        }
        return true;
    }

    RectValues createRectValues(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.coordinateStart;
            int i6 = this.radius;
            i4 = i5 + i6;
            int i7 = this.coordinateEnd;
            i2 = i7 + i6;
            i = i5 - i6;
            i3 = i7 - i6;
        } else {
            int i8 = this.coordinateStart;
            int i9 = this.radius;
            i4 = i8 - i9;
            int i10 = this.coordinateEnd;
            i2 = i10 - i9;
            i = i8 + i9;
            i3 = i10 + i9;
        }
        return new RectValues(i4, i2, i, i3);
    }

    class RectValues {
        final int fromX;
        final int reverseFromX;
        final int reverseToX;
        final int toX;

        RectValues(int i, int i2, int i3, int i4) {
            this.fromX = i;
            this.toX = i2;
            this.reverseFromX = i3;
            this.reverseToX = i4;
        }
    }
}
