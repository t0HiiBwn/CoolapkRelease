package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private TransitionFactory<? super TranscodeType> transitionFactory = NoTransition.getFactory();

    private CHILD self() {
        return this;
    }

    public final CHILD dontTransition() {
        return transition(NoTransition.getFactory());
    }

    public final CHILD transition(int i) {
        return transition(new ViewAnimationFactory(i));
    }

    public final CHILD transition(ViewPropertyTransition.Animator animator) {
        return transition(new ViewPropertyAnimationFactory(animator));
    }

    public final CHILD transition(TransitionFactory<? super TranscodeType> transitionFactory2) {
        this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(transitionFactory2);
        return self();
    }

    @Override // java.lang.Object
    public final CHILD clone() {
        try {
            return (CHILD) ((TransitionOptions) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }
}
