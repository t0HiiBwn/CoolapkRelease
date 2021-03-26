package com.coolapk.market.view.main;

import androidx.fragment.app.FragmentManager;
import com.coolapk.market.view.main.DiscoveryFragmentV11;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/main/DiscoveryFragmentV11$PagerAdapter;", "Lcom/coolapk/market/view/main/DiscoveryFragmentV11;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DiscoveryFragmentV11.kt */
final class DiscoveryFragmentV11$adapter$2 extends Lambda implements Function0<DiscoveryFragmentV11.PagerAdapter> {
    final /* synthetic */ DiscoveryFragmentV11 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoveryFragmentV11$adapter$2(DiscoveryFragmentV11 discoveryFragmentV11) {
        super(0);
        this.this$0 = discoveryFragmentV11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final DiscoveryFragmentV11.PagerAdapter invoke() {
        DiscoveryFragmentV11 discoveryFragmentV11 = this.this$0;
        FragmentManager childFragmentManager = discoveryFragmentV11.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return new DiscoveryFragmentV11.PagerAdapter(discoveryFragmentV11, childFragmentManager);
    }
}
