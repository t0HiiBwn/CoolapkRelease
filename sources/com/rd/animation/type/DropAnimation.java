package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.DropAnimationValue;
import java.util.Iterator;

public class DropAnimation extends BaseAnimation<AnimatorSet> {
    private int heightEnd;
    private int heightStart;
    private int radius;
    private DropAnimationValue value = new DropAnimationValue();
    private int widthEnd;
    private int widthStart;

    private enum AnimationType {
        Width,
        Height,
        Radius
    }

    public DropAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.BaseAnimation
    public AnimatorSet createAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public DropAnimation progress(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.animationDuration));
            boolean z = false;
            Iterator<Animator> it2 = ((AnimatorSet) this.animator).getChildAnimations().iterator();
            while (it2.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it2.next();
                long duration = valueAnimator.getDuration();
                long j2 = z ? j - duration : j;
                if (j2 >= 0) {
                    if (j2 >= duration) {
                        j2 = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(j2);
                    }
                    if (!z && duration >= this.animationDuration) {
                        z = true;
                    }
                }
            }
        }
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public DropAnimation duration(long j) {
        super.duration(j);
        return this;
    }

    public DropAnimation with(int i, int i2, int i3, int i4, int i5) {
        if (hasChanges(i, i2, i3, i4, i5)) {
            this.animator = createAnimator();
            this.widthStart = i;
            this.widthEnd = i2;
            this.heightStart = i3;
            this.heightEnd = i4;
            this.radius = i5;
            int i6 = (int) (((double) i5) / 1.5d);
            long j = this.animationDuration / 2;
            ValueAnimator createValueAnimation = createValueAnimation(i, i2, this.animationDuration, AnimationType.Width);
            ValueAnimator createValueAnimation2 = createValueAnimation(i3, i4, j, AnimationType.Height);
            ValueAnimator createValueAnimation3 = createValueAnimation(i5, i6, j, AnimationType.Radius);
            ValueAnimator createValueAnimation4 = createValueAnimation(i4, i3, j, AnimationType.Height);
            ((AnimatorSet) this.animator).play(createValueAnimation2).with(createValueAnimation3).with(createValueAnimation).before(createValueAnimation4).before(createValueAnimation(i6, i5, j, AnimationType.Radius));
        }
        return this;
    }

    private ValueAnimator createValueAnimation(int i, int i2, long j, final AnimationType animationType) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.rd.animation.type.DropAnimation.AnonymousClass1 */

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropAnimation.this.onAnimatorUpdate(valueAnimator, animationType);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void onAnimatorUpdate(ValueAnimator valueAnimator, AnimationType animationType) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i = AnonymousClass2.$SwitchMap$com$rd$animation$type$DropAnimation$AnimationType[animationType.ordinal()];
        if (i == 1) {
            this.value.setWidth(intValue);
        } else if (i == 2) {
            this.value.setHeight(intValue);
        } else if (i == 3) {
            this.value.setRadius(intValue);
        }
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }

    /* renamed from: com.rd.animation.type.DropAnimation$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rd$animation$type$DropAnimation$AnimationType;

        static {
            int[] iArr = new int[AnimationType.values().length];
            $SwitchMap$com$rd$animation$type$DropAnimation$AnimationType = iArr;
            try {
                iArr[AnimationType.Width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rd$animation$type$DropAnimation$AnimationType[AnimationType.Height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rd$animation$type$DropAnimation$AnimationType[AnimationType.Radius.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean hasChanges(int i, int i2, int i3, int i4, int i5) {
        if (this.widthStart == i && this.widthEnd == i2 && this.heightStart == i3 && this.heightEnd == i4 && this.radius == i5) {
            return false;
        }
        return true;
    }
}
