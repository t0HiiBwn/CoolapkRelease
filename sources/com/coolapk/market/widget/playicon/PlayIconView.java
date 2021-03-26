package com.coolapk.market.widget.playicon;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.coolapk.market.widget.playicon.PlayIconDrawable;

public final class PlayIconView extends AppCompatImageView implements PlayIcon {
    private PlayIconDrawable playIconDrawable;

    public PlayIconView(Context context) {
        this(context, null);
    }

    public PlayIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlayIconDrawable playIconDrawable2 = new PlayIconDrawable();
        this.playIconDrawable = playIconDrawable2;
        setImageDrawable(playIconDrawable2);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable instanceof PlayIconDrawable) {
            this.playIconDrawable = (PlayIconDrawable) drawable;
        }
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setIconState(PlayIconDrawable.IconState iconState) {
        this.playIconDrawable.setIconState(iconState);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public PlayIconDrawable.IconState getIconState() {
        return this.playIconDrawable.getIconState();
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void animateToState(PlayIconDrawable.IconState iconState) {
        this.playIconDrawable.animateToState(iconState);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void toggle(boolean z) {
        this.playIconDrawable.toggle(z);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setStateListener(PlayIconDrawable.StateListener stateListener) {
        this.playIconDrawable.setStateListener(stateListener);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setColor(int i) {
        this.playIconDrawable.setColor(i);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setVisible(boolean z) {
        this.playIconDrawable.setVisible(z);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setAnimationDuration(int i) {
        this.playIconDrawable.setAnimationDuration(i);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.playIconDrawable.setInterpolator(timeInterpolator);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.playIconDrawable.setAnimationListener(animatorListener);
    }

    @Override // com.coolapk.market.widget.playicon.PlayIcon
    public void setCurrentFraction(float f) {
        this.playIconDrawable.setCurrentFraction(f);
    }
}
