package com.coolapk.market.extend;

import android.animation.Animator;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u001a\f\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"addListeners", "", "Landroid/animation/Animator;", "onStart", "Lkotlin/Function0;", "onEnd", "doOnEnd", "action", "isNullOrEmpty", "", "Landroid/graphics/Rect;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ExtraExtends.kt */
public final class ExtraExtendsKt {
    public static /* synthetic */ void addListeners$default(Animator animator, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        addListeners(animator, function0, function02);
    }

    public static final void addListeners(Animator animator, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(animator, "$this$addListeners");
        animator.addListener(new ExtraExtendsKt$addListeners$1(function02, function0));
    }

    public static final void doOnEnd(Animator animator, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(animator, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(function0, "action");
        addListeners$default(animator, null, function0, 1, null);
    }

    public static final boolean isNullOrEmpty(Rect rect) {
        return rect == null || rect.isEmpty();
    }
}
