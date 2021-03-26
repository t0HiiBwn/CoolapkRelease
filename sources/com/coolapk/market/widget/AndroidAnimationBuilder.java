package com.coolapk.market.widget;

import android.animation.Animator;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AndroidAnimationBuilder {
    public static AnimationStepHook CLEAN = new AnimationStepHook() {
        /* class com.coolapk.market.widget.AndroidAnimationBuilder.AnonymousClass1 */

        @Override // com.coolapk.market.widget.AndroidAnimationBuilder.AnimationStepHook
        public void run(View view) {
            view.setAlpha(1.0f);
            view.setRotation(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(0.0f);
            }
        }
    };
    private static final boolean DEBUG_LOGGING = false;
    private boolean allowLayerAdjustmentForAnimation = true;
    private boolean autoCancelWithTag = true;
    private AnimationStep currentStep = new AnimationStep();
    private int defaultStepDurationMS = 300;
    private boolean executionTriggered = false;
    private boolean startClean = false;
    private final ArrayList<AnimationStep> steps = new ArrayList<>();
    private final WeakReference<View> viewRef;

    public interface AnimationStepHook {
        void run(View view);
    }

    public AndroidAnimationBuilder(View view) {
        this.viewRef = new WeakReference<>(view);
    }

    public AndroidAnimationBuilder setDefaultStepDuration(int i) {
        if (alreadyExecuted()) {
            return this;
        }
        this.defaultStepDurationMS = i;
        return this;
    }

    public AndroidAnimationBuilder startClean(boolean z) {
        if (alreadyExecuted()) {
            return this;
        }
        this.startClean = z;
        return this;
    }

    public AndroidAnimationBuilder setAutoCancelWithTag(boolean z) {
        if (alreadyExecuted()) {
            return this;
        }
        this.autoCancelWithTag = z;
        return this;
    }

    public AndroidAnimationBuilder setAllowLayerAdjustmentForAnimation(boolean z) {
        if (alreadyExecuted()) {
            return this;
        }
        this.allowLayerAdjustmentForAnimation = z;
        return this;
    }

    public AndroidAnimationBuilder rotateBy(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setRotateBy(f);
        return this;
    }

    public AndroidAnimationBuilder rotateTo(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setRotateTo(Float.valueOf(f));
        return this;
    }

    public AndroidAnimationBuilder translateX(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setTranslateX(f);
        return this;
    }

    public AndroidAnimationBuilder translateY(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setTranslateY(f);
        return this;
    }

    public AndroidAnimationBuilder translateZ(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setTranslateZ(f);
        return this;
    }

    public AndroidAnimationBuilder scaleX(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setScaleX(f);
        return this;
    }

    public AndroidAnimationBuilder scaleY(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setScaleY(f);
        return this;
    }

    public AndroidAnimationBuilder alpha(float f) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setAlpha(f);
        return this;
    }

    public AndroidAnimationBuilder clean() {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setAlpha(1.0f);
        this.currentStep.setRotateTo(Float.valueOf(0.0f));
        this.currentStep.setScaleX(1.0f);
        this.currentStep.setScaleY(1.0f);
        this.currentStep.setTranslateX(0.0f);
        this.currentStep.setTranslateY(0.0f);
        this.currentStep.setTranslateZ(0.0f);
        return this;
    }

    public AndroidAnimationBuilder run(AnimationStepHook animationStepHook) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setPreStep(animationStepHook);
        return this;
    }

    public AndroidAnimationBuilder runAfter(AnimationStepHook animationStepHook) {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setPostStep(animationStepHook);
        return this;
    }

    public AndroidAnimationBuilder then() {
        if (alreadyExecuted()) {
            return this;
        }
        this.steps.add(this.currentStep);
        this.currentStep = new AnimationStep();
        return this;
    }

    public AndroidAnimationBuilder pause(int i) {
        if (!this.currentStep.isEmpty()) {
            then();
        }
        ms(i);
        then();
        return this;
    }

    public AndroidAnimationBuilder repeat(int i) {
        if (i <= 0 || alreadyExecuted()) {
            return this;
        }
        for (int i2 = 1; i2 < i; i2++) {
            this.steps.add(new AnimationStep(this.currentStep));
        }
        return this;
    }

    private boolean alreadyExecuted() {
        if (this.executionTriggered) {
            Log.w("AndroidAnimationBuilder", "Further animation definitions ignored: Execution already started!");
        }
        return this.executionTriggered;
    }

    public AndroidAnimationBuilder ms(int i) {
        this.currentStep.durationMs = i;
        return this;
    }

    public AndroidAnimationBuilder reset() {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setResetting(true);
        return this;
    }

    public AndroidAnimationBuilder decelerate() {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setInterpolator(new DecelerateInterpolator());
        return this;
    }

    public AndroidAnimationBuilder accelerate() {
        if (alreadyExecuted()) {
            return this;
        }
        this.currentStep.setInterpolator(new AccelerateInterpolator());
        return this;
    }

    public void execute() {
        String str;
        if (!alreadyExecuted()) {
            this.executionTriggered = true;
            if (!this.currentStep.isEmpty()) {
                this.steps.add(this.currentStep);
            }
            if (this.steps.size() >= 1) {
                View view = this.viewRef.get();
                if (view != null && this.startClean) {
                    CLEAN.run(view);
                }
                StartState startState = new StartState(view);
                FinalStep finalStep = new FinalStep();
                finalStep.viewRef = this.viewRef;
                this.steps.add(finalStep);
                if (view == null || !this.autoCancelWithTag) {
                    str = null;
                } else {
                    str = toString();
                    view.setTag(str);
                }
                int i = 0;
                while (i < this.steps.size() - 1) {
                    AnimationStep animationStep = this.steps.get(i);
                    animationStep.viewRef = this.viewRef;
                    i++;
                    animationStep.nextStep = this.steps.get(i);
                    animationStep.referencingTag = str;
                    animationStep.startState = startState;
                    animationStep.setDurationIfUnset(this.defaultStepDurationMS);
                }
                if (view != null && this.allowLayerAdjustmentForAnimation) {
                    finalStep.setEndLayerType(view.getLayerType());
                    view.setLayerType(2, null);
                }
                this.steps.get(0).execute();
            }
        }
    }

    static class AnimationStep implements Animator.AnimatorListener {
        Float alpha;
        boolean canceled = false;
        int durationMs;
        Interpolator interpolator;
        AnimationStep nextStep;
        AnimationStepHook postStep;
        AnimationStepHook preStep;
        String referencingTag;
        boolean resetting;
        Float rotateByDegrees;
        Float rotateToDegrees;
        Float scaleX;
        Float scaleY;
        StartState startState;
        boolean stepAlreadyFinished = false;
        Float translationX;
        Float translationY;
        Float translationZ;
        WeakReference<View> viewRef;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public AnimationStep() {
        }

        public AnimationStep(AnimationStep animationStep) {
            this.resetting = animationStep.resetting;
            this.rotateByDegrees = animationStep.rotateByDegrees;
            this.rotateToDegrees = animationStep.rotateToDegrees;
            this.translationX = animationStep.translationX;
            this.translationY = animationStep.translationY;
            this.translationZ = animationStep.translationZ;
            this.scaleX = animationStep.scaleX;
            this.scaleY = animationStep.scaleY;
            this.alpha = animationStep.alpha;
            this.preStep = animationStep.preStep;
            this.postStep = animationStep.postStep;
            this.interpolator = animationStep.interpolator;
        }

        public void setRotateTo(Float f) {
            this.rotateToDegrees = f;
        }

        void setRotateBy(float f) {
            this.rotateByDegrees = Float.valueOf(f);
        }

        void setTranslateX(float f) {
            this.translationX = Float.valueOf(f);
        }

        void setTranslateY(float f) {
            this.translationY = Float.valueOf(f);
        }

        void setTranslateZ(float f) {
            this.translationZ = Float.valueOf(f);
        }

        void setScaleX(float f) {
            this.scaleX = Float.valueOf(f);
        }

        void setScaleY(float f) {
            this.scaleY = Float.valueOf(f);
        }

        void setAlpha(float f) {
            this.alpha = Float.valueOf(f);
        }

        void setPreStep(AnimationStepHook animationStepHook) {
            this.preStep = animationStepHook;
        }

        public void setPostStep(AnimationStepHook animationStepHook) {
            this.postStep = animationStepHook;
        }

        void setResetting(boolean z) {
            this.resetting = z;
        }

        public void setInterpolator(Interpolator interpolator2) {
            this.interpolator = interpolator2;
        }

        boolean isEmpty() {
            return !hasAnimation() && this.preStep == null && !this.resetting;
        }

        boolean hasAnimation() {
            return (this.rotateByDegrees == null && this.rotateToDegrees == null && this.translationX == null && this.translationY == null && this.translationZ == null && this.scaleX == null && this.scaleY == null && this.alpha == null && !this.resetting) ? false : true;
        }

        void setDurationIfUnset(int i) {
            if (this.durationMs <= 0) {
                this.durationMs = i;
            }
        }

        void execute() {
            View view = this.viewRef.get();
            if (view == null) {
                Log.i("AndroidAnimationBuilder", "Aborting animation step: View was cleaned up");
            } else if (this.referencingTag == null || view.getTag() == this.referencingTag) {
                AnimationStepHook animationStepHook = this.preStep;
                if (animationStepHook != null) {
                    animationStepHook.run(view);
                }
                if (hasAnimation()) {
                    ViewPropertyAnimator animate = view.animate();
                    if (this.resetting) {
                        animate.alpha(this.startState.alpha);
                        animate.scaleX(this.startState.scaleX);
                        animate.scaleY(this.startState.scaleY);
                        animate.translationX(this.startState.translationX);
                        animate.translationY(this.startState.translationY);
                        if (Build.VERSION.SDK_INT >= 21) {
                            animate.translationZ(this.startState.translationZ);
                        }
                        animate.rotation(this.startState.rotation);
                    }
                    Float f = this.rotateToDegrees;
                    if (f != null) {
                        animate.rotation(f.floatValue());
                    } else {
                        Float f2 = this.rotateByDegrees;
                        if (f2 != null) {
                            animate.rotationBy(f2.floatValue());
                        }
                    }
                    Float f3 = this.translationX;
                    if (f3 != null) {
                        animate.translationX(f3.floatValue());
                    }
                    Float f4 = this.translationY;
                    if (f4 != null) {
                        animate.translationY(f4.floatValue());
                    }
                    if (this.translationZ != null && Build.VERSION.SDK_INT >= 21) {
                        animate.translationZ(this.translationZ.floatValue());
                    }
                    Float f5 = this.scaleX;
                    if (f5 != null) {
                        animate.scaleX(f5.floatValue());
                    }
                    Float f6 = this.scaleY;
                    if (f6 != null) {
                        animate.scaleY(f6.floatValue());
                    }
                    Float f7 = this.alpha;
                    if (f7 != null) {
                        animate.alpha(f7.floatValue());
                    }
                    Interpolator interpolator2 = this.interpolator;
                    if (interpolator2 != null) {
                        animate.setInterpolator(interpolator2);
                    } else {
                        animate.setInterpolator(new AccelerateDecelerateInterpolator());
                    }
                    animate.setDuration((long) this.durationMs);
                    animate.setListener(this);
                    animate.start();
                    return;
                }
                view.postDelayed(new Runnable() {
                    /* class com.coolapk.market.widget.AndroidAnimationBuilder.AnimationStep.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        AnimationStep.this.stepFinished();
                    }
                }, (long) this.durationMs);
            } else {
                Log.i("AnimationBuilder", "Aborting animation step: View tag has changed!");
            }
        }

        /* access modifiers changed from: private */
        public void stepFinished() {
            if (!this.canceled && !this.stepAlreadyFinished) {
                this.stepAlreadyFinished = true;
                View view = this.viewRef.get();
                if (view != null) {
                    AnimationStepHook animationStepHook = this.postStep;
                    if (animationStepHook != null) {
                        animationStepHook.run(view);
                    }
                    view.postDelayed(new Runnable() {
                        /* class com.coolapk.market.widget.AndroidAnimationBuilder.AnimationStep.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            AnimationStep.this.nextStep.execute();
                        }
                    }, 1);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            stepFinished();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.canceled = true;
        }
    }

    private static class FinalStep extends AnimationStep {
        private Integer endLayerType;

        private FinalStep() {
        }

        @Override // com.coolapk.market.widget.AndroidAnimationBuilder.AnimationStep
        public void execute() {
            Integer num;
            View view = (View) this.viewRef.get();
            if (view != null && (num = this.endLayerType) != null) {
                view.setLayerType(num.intValue(), null);
            }
        }

        public void setEndLayerType(int i) {
            this.endLayerType = Integer.valueOf(i);
        }
    }

    private static class StartState {
        public final float alpha;
        public final float rotation;
        public final float scaleX;
        public final float scaleY;
        public final float translationX;
        public final float translationY;
        public final float translationZ;

        public StartState(View view) {
            if (view == null) {
                this.alpha = 0.0f;
                this.scaleY = 0.0f;
                this.scaleX = 0.0f;
                this.translationZ = 0.0f;
                this.translationY = 0.0f;
                this.translationX = 0.0f;
                this.rotation = 0.0f;
                return;
            }
            this.alpha = view.getAlpha();
            this.scaleX = view.getScaleX();
            this.scaleY = view.getScaleY();
            this.translationX = view.getTranslationX();
            this.translationY = view.getTranslationY();
            if (Build.VERSION.SDK_INT >= 21) {
                this.translationZ = view.getTranslationZ();
            } else {
                this.translationZ = 0.0f;
            }
            this.rotation = view.getRotation();
        }
    }
}
