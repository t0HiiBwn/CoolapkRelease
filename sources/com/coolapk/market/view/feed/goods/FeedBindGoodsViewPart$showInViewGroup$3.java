package com.coolapk.market.view.feed.goods;

import android.view.View;
import com.coolapk.market.databinding.FeedBindGoodsMainBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
final class FeedBindGoodsViewPart$showInViewGroup$3 implements View.OnClickListener {
    final /* synthetic */ FeedBindGoodsViewPart this$0;

    FeedBindGoodsViewPart$showInViewGroup$3(FeedBindGoodsViewPart feedBindGoodsViewPart) {
        this.this$0 = feedBindGoodsViewPart;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.syncGoodsData(new Function0<Unit>(this) {
            /* class com.coolapk.market.view.feed.goods.FeedBindGoodsViewPart$showInViewGroup$3.AnonymousClass1 */
            final /* synthetic */ FeedBindGoodsViewPart$showInViewGroup$3 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                View root = ((FeedBindGoodsMainBinding) this.this$0.this$0.getBinding()).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                ViewExtendsKt.detachFromParent(root);
            }
        });
    }
}
