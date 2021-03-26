package com.coolapk.market.view.goods.detail;

import androidx.lifecycle.Observer;
import com.coolapk.market.databinding.LoadingViewBinding;
import com.coolapk.market.view.goods.detail.GoodsDetailViewModel;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel$LoadingStatus;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
final class GoodsDetailActivity$onCreate$3<T> implements Observer<GoodsDetailViewModel.LoadingStatus> {
    final /* synthetic */ String $id;
    final /* synthetic */ GoodsDetailActivity this$0;

    GoodsDetailActivity$onCreate$3(GoodsDetailActivity goodsDetailActivity, String str) {
        this.this$0 = goodsDetailActivity;
        this.$id = str;
    }

    public final void onChanged(GoodsDetailViewModel.LoadingStatus loadingStatus) {
        if (loadingStatus.isLoading()) {
            LoadingViewBinding loadingViewBinding = GoodsDetailActivity.access$getBinding$p(this.this$0).loadingView;
            Intrinsics.checkNotNullExpressionValue(loadingViewBinding, "binding.loadingView");
            BindingExtensionKt.setLoadingStart(loadingViewBinding);
            return;
        }
        if (loadingStatus.getErrorMessage().length() == 0) {
            LoadingViewBinding loadingViewBinding2 = GoodsDetailActivity.access$getBinding$p(this.this$0).loadingView;
            Intrinsics.checkNotNullExpressionValue(loadingViewBinding2, "binding.loadingView");
            BindingExtensionKt.setLoadingFinished(loadingViewBinding2);
            return;
        }
        LoadingViewBinding loadingViewBinding3 = GoodsDetailActivity.access$getBinding$p(this.this$0).loadingView;
        Intrinsics.checkNotNullExpressionValue(loadingViewBinding3, "binding.loadingView");
        BindingExtensionKt.setLoadingError(loadingViewBinding3, loadingStatus.getErrorMessage(), new Function0<Unit>(this) {
            /* class com.coolapk.market.view.goods.detail.GoodsDetailActivity$onCreate$3.AnonymousClass1 */
            final /* synthetic */ GoodsDetailActivity$onCreate$3 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                this.this$0.this$0.getViewModel().loadGoodsDetail(this.this$0.$id);
            }
        });
    }
}
