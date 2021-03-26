package com.coolapk.market.view.main;

import android.view.View;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "verticalOffset", "", "onOffsetChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: TranslucentHeaderConverter.kt */
final class TranslucentHeaderConverter$compatDefaultWithViewPagerConverter$3 implements AppBarLayout.OnOffsetChangedListener {
    final /* synthetic */ AlphableToolbar $alphaToolbar;
    final /* synthetic */ RefreshRecyclerTabsBinding $tabBinding;

    TranslucentHeaderConverter$compatDefaultWithViewPagerConverter$3(AlphableToolbar alphableToolbar, RefreshRecyclerTabsBinding refreshRecyclerTabsBinding) {
        this.$alphaToolbar = alphableToolbar;
        this.$tabBinding = refreshRecyclerTabsBinding;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        int abs = Math.abs(i);
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "appBarLayout");
        if (abs == appBarLayout.getTotalScrollRange()) {
            AlphableToolbar alphableToolbar = this.$alphaToolbar;
            if (!(alphableToolbar instanceof AlphaToolbarActivity)) {
                alphableToolbar = null;
            }
            AlphaToolbarActivity alphaToolbarActivity = (AlphaToolbarActivity) alphableToolbar;
            if (alphaToolbarActivity != null) {
                alphaToolbarActivity.setLightElevation();
            }
            View view = this.$tabBinding.divider;
            Intrinsics.checkNotNullExpressionValue(view, "tabBinding.divider");
            view.setVisibility(8);
            return;
        }
        this.$alphaToolbar.setToolbarAlpha(1.0f);
        View view2 = this.$tabBinding.divider;
        Intrinsics.checkNotNullExpressionValue(view2, "tabBinding.divider");
        view2.setVisibility(0);
    }
}
