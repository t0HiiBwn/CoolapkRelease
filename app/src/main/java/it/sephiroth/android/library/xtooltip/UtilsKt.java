package it.sephiroth.android.library.xtooltip;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\b\u001a\u001d\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a&\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\b\u001a&\u0010\r\u001a\u00020\u0010*\u00020\u00102\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\b¨\u0006\u0012"}, d2 = {"addOnAttachStateChangeListener", "Landroid/view/View;", "func", "Lkotlin/Function1;", "Lit/sephiroth/android/library/xtooltip/AttachStateChangeListener;", "", "Lkotlin/ExtensionFunctionType;", "rectContainsWithTolerance", "", "Landroid/graphics/Rect;", "childRect", "t", "", "setListener", "Landroid/view/ViewPropertyAnimator;", "Lit/sephiroth/android/library/xtooltip/ViewPropertyAnimatorListener;", "Landroid/view/animation/Animation;", "Lit/sephiroth/android/library/xtooltip/AnimationListener;", "xtooltip_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final boolean rectContainsWithTolerance(Rect rect, Rect rect2, int i) {
        Intrinsics.checkParameterIsNotNull(rect, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rect2, "childRect");
        return rect.contains(rect2.left + i, rect2.top + i, rect2.right - i, rect2.bottom - i);
    }

    public static final View addOnAttachStateChangeListener(View view, Function1<? super AttachStateChangeListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "func");
        AttachStateChangeListener attachStateChangeListener = new AttachStateChangeListener();
        function1.invoke(attachStateChangeListener);
        view.addOnAttachStateChangeListener(attachStateChangeListener);
        return view;
    }

    public static final ViewPropertyAnimator setListener(ViewPropertyAnimator viewPropertyAnimator, Function1<? super ViewPropertyAnimatorListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewPropertyAnimator, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "func");
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = new ViewPropertyAnimatorListener();
        function1.invoke(viewPropertyAnimatorListener);
        viewPropertyAnimator.setListener(viewPropertyAnimatorListener);
        return viewPropertyAnimator;
    }

    public static final Animation setListener(Animation animation, Function1<? super AnimationListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "func");
        AnimationListener animationListener = new AnimationListener();
        function1.invoke(animationListener);
        animation.setAnimationListener(animationListener);
        return animation;
    }
}
