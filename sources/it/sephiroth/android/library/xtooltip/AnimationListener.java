package it.sephiroth.android.library.xtooltip;

import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\f\u001a\u00020\t2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0012\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J+\u0010\u000e\u001a\u00020\t2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J+\u0010\u000f\u001a\u00020\t2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016R-\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R-\u0010\n\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R-\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lit/sephiroth/android/library/xtooltip/AnimationListener;", "Landroid/view/animation/Animation$AnimationListener;", "()V", "_onAnimationEnd", "Lkotlin/Function1;", "Landroid/view/animation/Animation;", "Lkotlin/ParameterName;", "name", "animation", "", "_onAnimationRepeat", "_onAnimationStart", "onAnimationEnd", "func", "onAnimationRepeat", "onAnimationStart", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Utils.kt */
public final class AnimationListener implements Animation.AnimationListener {
    private Function1<? super Animation, Unit> _onAnimationEnd;
    private Function1<? super Animation, Unit> _onAnimationRepeat;
    private Function1<? super Animation, Unit> _onAnimationStart;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        Function1<? super Animation, Unit> function1 = this._onAnimationRepeat;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Function1<? super Animation, Unit> function1 = this._onAnimationEnd;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        Function1<? super Animation, Unit> function1 = this._onAnimationStart;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    public final void onAnimationEnd(Function1<? super Animation, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "func");
        this._onAnimationEnd = function1;
    }

    public final void onAnimationRepeat(Function1<? super Animation, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "func");
        this._onAnimationRepeat = function1;
    }

    public final void onAnimationStart(Function1<? super Animation, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "func");
        this._onAnimationStart = function1;
    }
}
