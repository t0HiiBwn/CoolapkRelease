package com.coolapk.market.extend;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/extend/ExtraExtendsKt$addListeners$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ExtraExtends.kt */
public final class ExtraExtendsKt$addListeners$1 extends AnimatorListenerAdapter {
    final /* synthetic */ Function0 $onEnd;
    final /* synthetic */ Function0 $onStart;

    ExtraExtendsKt$addListeners$1(Function0 function0, Function0 function02) {
        this.$onEnd = function0;
        this.$onStart = function02;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        Function0 function0 = this.$onEnd;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        Function0 function0 = this.$onStart;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}
