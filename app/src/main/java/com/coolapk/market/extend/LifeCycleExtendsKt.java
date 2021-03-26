package com.coolapk.market.extend;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0007"}, d2 = {"oneTimeOnDestroy", "", "Landroidx/lifecycle/Lifecycle;", "onDestroy", "Lkotlin/Function0;", "oneTimeOnPause", "onPause", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: LifeCycleExtends.kt */
public final class LifeCycleExtendsKt {
    public static final void oneTimeOnDestroy(Lifecycle lifecycle, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(lifecycle, "$this$oneTimeOnDestroy");
        Intrinsics.checkNotNullParameter(function0, "onDestroy");
        lifecycle.addObserver(new LifeCycleExtendsKt$oneTimeOnDestroy$1(lifecycle, function0));
    }

    public static final void oneTimeOnPause(Lifecycle lifecycle, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(lifecycle, "$this$oneTimeOnPause");
        Intrinsics.checkNotNullParameter(function0, "onPause");
        lifecycle.addObserver(new LifeCycleExtendsKt$oneTimeOnPause$1(lifecycle, function0));
    }
}
