package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;

abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final P primaryAnimatorProvider;
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    protected MaterialVisibility(P p, VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    private Animator createAnimator(ViewGroup viewGroup, View view, boolean z) {
        Animator animator;
        Animator animator2;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z) {
            animator = this.primaryAnimatorProvider.createAppear(viewGroup, view);
        } else {
            animator = this.primaryAnimatorProvider.createDisappear(viewGroup, view);
        }
        if (animator != null) {
            arrayList.add(animator);
        }
        VisibilityAnimatorProvider visibilityAnimatorProvider = this.secondaryAnimatorProvider;
        if (visibilityAnimatorProvider != null) {
            if (z) {
                animator2 = visibilityAnimatorProvider.createAppear(viewGroup, view);
            } else {
                animator2 = visibilityAnimatorProvider.createDisappear(viewGroup, view);
            }
            if (animator2 != null) {
                arrayList.add(animator2);
            }
        }
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }
}
