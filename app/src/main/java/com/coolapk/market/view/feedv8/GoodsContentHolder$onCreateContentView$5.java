package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.view.feedv8.util.FeedGoodsHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$onCreateContentView$5 implements Runnable {
    final /* synthetic */ GoodsContentHolder this$0;

    GoodsContentHolder$onCreateContentView$5(GoodsContentHolder goodsContentHolder) {
        this.this$0 = goodsContentHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.this$0.getActivity().isFinishing()) {
            View root = this.this$0.getBinding$presentation_coolapkAppRelease().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            if (root.isAttachedToWindow() && this.this$0.getUiConfig().feedGoods() == null && FeedGoodsHelper.INSTANCE.isSupportAddGoodsUrl(UserPermissionChecker.INSTANCE.getClipBoardUrl(this.this$0.getActivity()))) {
                FeedGoodsHelper.showAddGoodsDialog$default(FeedGoodsHelper.INSTANCE, this.this$0.getActivity(), null, new Function1<FeedGoods, Unit>(this.this$0) {
                    /* class com.coolapk.market.view.feedv8.GoodsContentHolder$onCreateContentView$5.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FeedGoods feedGoods) {
                        invoke(feedGoods);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(FeedGoods feedGoods) {
                        GoodsContentHolder.access$updateGoodsUI((GoodsContentHolder) this.receiver, feedGoods);
                    }
                }, 2, null);
            }
        }
    }
}
