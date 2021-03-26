package com.coolapk.market.view.main;

import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.coolapk.market.widget.AHBottomBehavior;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$onCreateView$1 implements Runnable {
    final /* synthetic */ MainFragment this$0;

    MainFragment$onCreateView$1(MainFragment mainFragment) {
        this.this$0 = mainFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AHBottomBehavior aHBottomBehavior = new AHBottomBehavior(this.this$0.getActivity(), null);
        aHBottomBehavior.setCallback(this.this$0.onScrollListener);
        AHBottomNavigation aHBottomNavigation = MainFragment.access$getBinding$p(this.this$0).bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
        ViewGroup.LayoutParams layoutParams = aHBottomNavigation.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(aHBottomBehavior);
    }
}
