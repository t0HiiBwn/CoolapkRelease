package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = {"android:clipBounds:clip"};

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            Rect clipBounds = ViewCompat.getClipBounds(view);
            transitionValues.values.put("android:clipBounds:clip", clipBounds);
            if (clipBounds == null) {
                transitionValues.values.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator = null;
        if (transitionValues != null && transitionValues2 != null && transitionValues.values.containsKey("android:clipBounds:clip") && transitionValues2.values.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) transitionValues.values.get("android:clipBounds:clip");
            Rect rect2 = (Rect) transitionValues2.values.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) transitionValues.values.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) transitionValues2.values.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            ViewCompat.setClipBounds(transitionValues2.view, rect);
            objectAnimator = ObjectAnimator.ofObject(transitionValues2.view, (Property<View, V>) ViewUtils.CLIP_BOUNDS, (TypeEvaluator) new RectEvaluator(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z) {
                final View view = transitionValues2.view;
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class androidx.transition.ChangeClipBounds.AnonymousClass1 */

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewCompat.setClipBounds(view, null);
                    }
                });
            }
        }
        return objectAnimator;
    }
}
