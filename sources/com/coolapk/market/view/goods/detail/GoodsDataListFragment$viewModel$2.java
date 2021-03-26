package com.coolapk.market.view.goods.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.view.goods.detail.GoodsDetailViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDataListFragment.kt */
final class GoodsDataListFragment$viewModel$2 extends Lambda implements Function0<GoodsDetailViewModel> {
    final /* synthetic */ GoodsDataListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsDataListFragment$viewModel$2(GoodsDataListFragment goodsDataListFragment) {
        super(0);
        this.this$0 = goodsDataListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final GoodsDetailViewModel invoke() {
        GoodsDetailViewModel.Companion companion = GoodsDetailViewModel.Companion;
        FragmentActivity activity = this.this$0.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        return companion.obtain((AppCompatActivity) activity);
    }
}
