package com.coolapk.market.view.live;

import androidx.fragment.app.Fragment;
import com.coolapk.market.model.LiveProduct;
import com.coolapk.market.view.live.LiveProductListFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$updateUI$4 extends Lambda implements Function0<Fragment> {
    final /* synthetic */ LiveProduct $relationProduct;
    final /* synthetic */ LiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveActivity$updateUI$4(LiveActivity liveActivity, LiveProduct liveProduct) {
        super(0);
        this.this$0 = liveActivity;
        this.$relationProduct = liveProduct;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Fragment invoke() {
        LiveProductListFragment.Companion companion = LiveProductListFragment.Companion;
        String str = this.this$0.getLiveId();
        Intrinsics.checkNotNullExpressionValue(str, "liveId");
        String id = this.$relationProduct.getId();
        Intrinsics.checkNotNull(id);
        String title = this.$relationProduct.getTitle();
        Intrinsics.checkNotNull(title);
        String logo = this.$relationProduct.getLogo();
        Intrinsics.checkNotNull(logo);
        return companion.newInstance(str, id, title, logo);
    }
}
