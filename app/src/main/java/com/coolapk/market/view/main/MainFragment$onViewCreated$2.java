package com.coolapk.market.view.main;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$onViewCreated$2 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ MainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainFragment$onViewCreated$2(MainFragment mainFragment) {
        super(1);
        this.this$0 = mainFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
        invoke(rect);
        return Unit.INSTANCE;
    }

    public final void invoke(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "it");
        MainFragment.access$getBinding$p(this.this$0).bottomNavigation.setPadding(0, 0, 0, rect.bottom);
        CoordinatorLayout coordinatorLayout = MainFragment.access$getBinding$p(this.this$0).coordinator;
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "binding.coordinator");
        CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
        ViewGroup.LayoutParams layoutParams = coordinatorLayout2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = rect.top;
        coordinatorLayout2.setLayoutParams(marginLayoutParams);
    }
}
