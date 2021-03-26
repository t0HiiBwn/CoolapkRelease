package com.coolapk.market.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;

public class ActionButtonFrameLayout extends RevealFrameLayout {
    private boolean isCapsule = true;

    public ActionButtonFrameLayout(Context context) {
        super(context);
    }

    public ActionButtonFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionButtonFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ActionButtonFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.coolapk.market.widget.RevealFrameLayout, android.view.View
    public ViewOutlineProvider getOutlineProvider() {
        return new ViewOutlineProvider() {
            /* class com.coolapk.market.widget.ActionButtonFrameLayout.AnonymousClass1 */

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (ActionButtonFrameLayout.this.isCapsule) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ((float) view.getHeight()) / 2.0f);
                } else {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) DisplayUtils.dp2px(ActionButtonFrameLayout.this.getContext(), 6.0f));
                }
            }
        };
    }

    public void setOtherActionBackground(Drawable drawable, Drawable drawable2, Animator.AnimatorListener animatorListener) {
        super.setBackground(drawable, drawable2, true, animatorListener);
    }

    public void setActionBackground(final int i, final Animator.AnimatorListener animatorListener) {
        Float f;
        if (this.isCapsule) {
            int height = getHeight();
            if (height == 0) {
                height = getMinimumHeight();
            }
            f = height != 0 ? Float.valueOf(((float) height) / 2.0f) : null;
        } else {
            f = Float.valueOf((float) DisplayUtils.dp2px(getContext(), 6.0f));
        }
        super.setBackground(ShapeUtils.createRevealBg(getContext(), f), ShapeUtils.createDownloadBg(getContext(), f), true, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            /* class com.coolapk.market.widget.ActionButtonFrameLayout.AnonymousClass2 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Drawable background = ActionButtonFrameLayout.this.getBackground();
                if (background instanceof RippleDrawable) {
                    RippleDrawable rippleDrawable = (RippleDrawable) background;
                    if (rippleDrawable.getDrawable(0) instanceof LayerDrawable) {
                        Drawable findDrawableByLayerId = ((LayerDrawable) rippleDrawable.getDrawable(0)).findDrawableByLayerId(16908301);
                        int i = i;
                        ObjectAnimator ofInt = ObjectAnimator.ofInt(findDrawableByLayerId, "level", 0, i);
                        ofInt.setDuration((long) ((i * 350) / 10000));
                        ofInt.addListener(new AnimatorListenerAdapter() {
                            /* class com.coolapk.market.widget.ActionButtonFrameLayout.AnonymousClass2.AnonymousClass1 */

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (animatorListener != null) {
                                    animatorListener.onAnimationEnd(animator);
                                }
                            }
                        });
                        ofInt.start();
                    }
                }
            }
        });
        if (getChildAt(1) instanceof TextView) {
            ((TextView) getChildAt(1)).setTextColor(ResourceUtils.getColorInt(getContext(), 2131099912));
        }
    }

    public void setCapsule(boolean z) {
        this.isCapsule = z;
    }

    public boolean isCapsule() {
        return this.isCapsule;
    }
}
