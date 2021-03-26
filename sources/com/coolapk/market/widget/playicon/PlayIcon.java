package com.coolapk.market.widget.playicon;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import com.coolapk.market.widget.playicon.PlayIconDrawable;

public interface PlayIcon {
    void animateToState(PlayIconDrawable.IconState iconState);

    PlayIconDrawable.IconState getIconState();

    void setAnimationDuration(int i);

    void setAnimationListener(Animator.AnimatorListener animatorListener);

    void setColor(int i);

    void setCurrentFraction(float f);

    void setIconState(PlayIconDrawable.IconState iconState);

    void setInterpolator(TimeInterpolator timeInterpolator);

    void setStateListener(PlayIconDrawable.StateListener stateListener);

    void setVisible(boolean z);

    void toggle(boolean z);
}
