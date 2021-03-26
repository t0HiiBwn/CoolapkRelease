package com.coolapk.market.view.main;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onOffsetChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: DataListViewPagerConverter.kt */
final class DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$2 implements AppBarLayout.OnOffsetChangedListener {
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ DataListViewPagerConverter this$0;

    DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$2(DataListViewPagerConverter dataListViewPagerConverter, RecyclerView recyclerView) {
        this.this$0 = dataListViewPagerConverter;
        this.$recyclerView = recyclerView;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        EntityListFixTopHelper entityListFixTopHelper$presentation_coolapkAppRelease = this.this$0.getFragment().getEntityListFixTopHelper$presentation_coolapkAppRelease();
        RecyclerView recyclerView = this.$recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        entityListFixTopHelper$presentation_coolapkAppRelease.checkFixTopAndSetMinHeight(recyclerView);
    }
}
